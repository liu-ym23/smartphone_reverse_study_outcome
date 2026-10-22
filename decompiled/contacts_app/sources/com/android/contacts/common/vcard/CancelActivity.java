package com.android.contacts.common.vcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.GlobalProxyLancet;
import com.android.contacts.common.R;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class CancelActivity extends Activity implements ServiceConnection {
    static final String DISPLAY_NAME = "display_name";
    static final String JOB_ID = "job_id";
    static final String TYPE = "type";
    private final String LOG_TAG;
    private final CancelListener mCancelListener;
    private String mDisplayName;
    private int mJobId;
    private int mType;

    /* JADX INFO: renamed from: com.android.contacts.common.vcard.CancelActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class CancelListener implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {
        final /* synthetic */ CancelActivity this$0;

        private CancelListener(CancelActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CancelListener(CancelActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            this.this$0.finish();
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            this.this$0.finish();
        }
    }

    private class RequestCancelListener implements DialogInterface.OnClickListener {
        final /* synthetic */ CancelActivity this$0;

        private RequestCancelListener(CancelActivity r1) {
            this.this$0 = r1;
        }

        /* synthetic */ RequestCancelListener(CancelActivity r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r3, int r4) {
            this.this$0.bindService(new Intent(this.this$0, VCardService.class), this.this$0, 1);
        }
    }

    public void com_android_contacts_common_vcard_CancelActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_common_vcard_CancelActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public CancelActivity() {
        this.LOG_TAG = "VCardCancel";
        this.mCancelListener = new CancelListener(this, null);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        Uri r3 = getIntent().getData();
        String r0 = r3.getQueryParameter("job_id");
        if (r0 == null) goto L5;
        this.mJobId = Integer.parseInt(r0);
    L5:
        this.mDisplayName = r3.getQueryParameter(DISPLAY_NAME);
        String r4 = r3.getQueryParameter("type");
        if (r4 == null) goto L8;
        this.mType = Integer.parseInt(r4);
    L8:
        showDialog(R.id.dialog_cancel_confirmation);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r4, Bundle r5) {
        if (r4 != R.id.dialog_cancel_confirmation) goto L11;
        if (this.mType != 1) goto L7;
        String r6 = getString(R.string.cancel_import_confirmation_message, new Object[]{this.mDisplayName});
    L9:
        return new AlertDialog.Builder(this).setMessage(r6).setPositiveButton(android.R.string.ok, new RequestCancelListener(this, null)).setOnCancelListener(this.mCancelListener).setNegativeButton(android.R.string.cancel, this.mCancelListener).create();
    L7:
        r6 = getString(R.string.cancel_export_confirmation_message, new Object[]{this.mDisplayName});
        goto L9
    L11:
        if (r4 == R.id.dialog_cancel_failed) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("VCardCancel", "Unknown dialog id: " + r4);
        return super.onCreateDialog(r4, r5);
    L13:
        return new AlertDialog.Builder(this).setTitle(R.string.cancel_vcard_import_or_export_failed).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(getString(R.string.fail_reason_unknown)).setOnCancelListener(this.mCancelListener).setPositiveButton(android.R.string.ok, this.mCancelListener).create();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r3, IBinder r4) {
        VCardService r5 = ((VCardService.MyBinder) r4).getService();
        r5.handleCancelRequest(new CancelRequest(this.mJobId, this.mDisplayName), null);     // Catch: Throwable -> L6
        unbindService(this);
        finish();
        return;
    L6:
        th = move-exception;
        unbindService(this);
        throw th;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_common_vcard_CancelActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CancelActivity r1) {
        r1.com_android_contacts_common_vcard_CancelActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
