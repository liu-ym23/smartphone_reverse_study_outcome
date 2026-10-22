package com.android.contacts.common.vcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.text.BidiFormatter;
import android.text.TextDirectionHeuristics;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.android.contacts.common.activity.RequestImportVCardPermissionsActivity;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ExportVCardActivity extends Activity implements ServiceConnection, DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
    protected static final boolean DEBUG = false;
    private static final String LOG_TAG = "VCardExport";
    private static final int REQUEST_CREATE_DOCUMENT = 100;
    private static final BidiFormatter mBidiFormatter = null;
    protected boolean mConnected;
    private String mErrorReason;
    private volatile boolean mProcessOngoing;
    protected VCardService mService;
    private String selExport;

    public ExportVCardActivity() {
        this.mProcessOngoing = true;
        this.selExport = "";
    }

    static {
        mBidiFormatter = BidiFormatter.getInstance();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (RequestImportVCardPermissionsActivity.startPermissionActivity(this) == false) goto L6;
        return;
    L6:
        if (hasExportIntentHandler() == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Couldn't find export intent handler");
        showErrorDialog();
        return;
    L9:
        connectVCardService();
    }

    private void connectVCardService() {
        String r0 = getIntent().getExtras().getString(VCardCommonArguments.ARG_CALLING_ACTIVITY);
        Intent r2 = new Intent(this, VCardService.class);
        r2.putExtra(VCardCommonArguments.ARG_CALLING_ACTIVITY, r0);
        if (startService(r2) != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Failed to start vCard service");
        showErrorDialog();
        return;
    L7:
        if (bindService(r2, this, 1) == true) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(LOG_TAG, "Failed to connect to vCard service.");
        showErrorDialog();
    L9:
        Intent r1 = getIntent();
        if (r1 == null) goto L13;
        this.selExport = r1.getStringExtra("SelExport");
        return;
    }

    private boolean hasExportIntentHandler() {
        Intent r0 = getCreateDocIntent();
        List<ResolveInfo> r2 = getPackageManager().queryIntentActivities(r0, 65536);
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.size() <= 0) goto L7;
        return true;
    }

    private Intent getCreateDocIntent() {
        Intent r0 = new Intent("android.intent.action.CREATE_DOCUMENT");
        r0.addCategory("android.intent.category.OPENABLE");
        r0.setType("text/x-vcard");
        r0.putExtra("android.intent.extra.TITLE", mBidiFormatter.unicodeWrap(getString(R.string.exporting_vcard_filename), TextDirectionHeuristics.LTR));
        return r0;
    }

    private void showErrorDialog() {
        this.mErrorReason = getString(R.string.fail_reason_unknown);
        showDialog(R.id.dialog_fail_to_export_with_reason);
    }

    @Override // android.app.Activity
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r2 == 100) goto L5;
        return;
    L5:
        if (r3 == (-1)) goto L7;
    L12:
        unbindAndFinish();
        return;
    L7:
        if (this.mService == null) goto L12;
        if (r4 == null) goto L12;
        if (r4.getData() == null) goto L12;
        Uri r5 = r4.getData();
        this.mService.setSelExport(this.selExport);
        ExportRequest r6 = new ExportRequest(r5);
        this.mService.handleExportRequest(r6, new NotificationImportExportListener(this));
        goto L12
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName r1, IBinder r2) {
        monitor-enter(this);
        this.mConnected = true;     // Catch: Throwable -> L7
        this.mService = ((VCardService.MyBinder) r2).getService();     // Catch: Throwable -> L7
        startActivityForResult(getCreateDocIntent(), 100);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName r2) {
        monitor-enter(this);
        this.mService = null;     // Catch: Throwable -> L9
        this.mConnected = false;     // Catch: Throwable -> L9
        if (this.mProcessOngoing == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(LOG_TAG, "Disconnected from service during the process ongoing.");     // Catch: Throwable -> L9
        showErrorDialog();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r4, Bundle r5) {
        if (r4 != R.id.dialog_fail_to_export_with_reason) goto L11;
        this.mProcessOngoing = false;
        AlertDialog.Builder r6 = new AlertDialog.Builder(this).setTitle(R.string.exporting_contact_failed_title);
        int r0 = R.string.exporting_contact_failed_message;
        Object[] r1 = new Object[1];
        String r2 = this.mErrorReason;
        if (r2 != null) goto L8;
        r2 = getString(R.string.fail_reason_unknown);
    L8:
        r1[0] = r2;
        return r6.setMessage(getString(r0, r1)).setPositiveButton(android.R.string.ok, this).setOnCancelListener(this).create();
    L11:
        return super.onCreateDialog(r4, r5);
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int r2, Dialog r3, Bundle r4) {
        if (r2 != R.id.dialog_fail_to_export_with_reason) goto L5;
        ((AlertDialog) r3).setMessage(this.mErrorReason);
        return;
    L5:
        super.onPrepareDialog(r2, r3, r4);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        unbindAndFinish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        this.mProcessOngoing = false;
        unbindAndFinish();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection r2) {
        this.mProcessOngoing = false;
        super.unbindService(r2);
    }

    static String getOpenableUriDisplayName(Context r7, Uri r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        Cursor r9 = r7.getContentResolver().query(r8, null, null, null, null);
        if (r9 != null) goto L20;
    L17:
        if (r9 == null) goto L19;
        r9.close();
    L19:
        return null;
    L20:
    L13:
        th = move-exception;
        if (r9 == null) goto L16;
        r9.close();
    L16:
        throw th;
    L8:
        if (r9.moveToFirst() == false) goto L17;
        String r10 = r9.getString(r9.getColumnIndex("_display_name"));     // Catch: Throwable -> L13
        if (r9 == null) goto L12;
        r9.close();
    L12:
        return r10;
    }

    protected synchronized void unbindAndFinish() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mConnected == false) goto L6;
        unbindService(this);     // Catch: Throwable -> L9
        this.mConnected = false;     // Catch: Throwable -> L9
    L6:
        finish();     // Catch: Throwable -> L9
        monitor-exit(this);
    }
}
