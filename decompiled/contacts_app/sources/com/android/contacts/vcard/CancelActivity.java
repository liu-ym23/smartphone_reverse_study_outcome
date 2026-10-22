package com.android.contacts.vcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CancelActivity extends Activity implements ServiceConnection {
    private static final String CANCEL_DIALOG_TAG = "CancelDialogFragment";
    static final String DISPLAY_NAME = "display_name";
    static final String JOB_ID = "job_id";
    static final String TYPE = "type";
    private final String LOG_TAG;
    private CancelDialogFragment mCancelDialog;
    private final CancelListener mCancelListener;
    private String mDisplayName;
    private FragmentManager mFragmentManager;
    private int mJobId;
    private final RequestCancelListener mRequestCancelListener;
    private int mType;

    /* JADX INFO: renamed from: com.android.contacts.vcard.CancelActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class CancelDialogFragment extends DialogFragment {
        private DialogInterface.OnClickListener mCancelListener;
        private DialogInterface.OnClickListener mConfirmListener;

        public CancelDialogFragment() {
        }

        public void setListeners(DialogInterface.OnClickListener r1, DialogInterface.OnClickListener r2) {
            this.mCancelListener = r2;
            this.mConfirmListener = r1;
        }

        @Override // android.app.DialogFragment
        public Dialog onCreateDialog(Bundle r4) {
            Bundle r5 = getArguments();
            int r0 = r5.getInt("type");
            String r6 = r5.getString(CancelActivity.DISPLAY_NAME);
            if (r0 != 1) goto L5;
            String r1 = getString(R.string.cancel_import_confirmation_title);
            String r7 = getString(R.string.cancel_import_confirmation_message, new Object[]{r6});
        L7:
            return new AlertDialog.Builder(getActivity()).setTitle(r1).setMessage(r7).setPositiveButton(android.R.string.ok, this.mConfirmListener).setNegativeButton(android.R.string.cancel, this.mCancelListener).create();
        L5:
            r1 = getString(R.string.cancel_export_confirmation_title);
            r7 = getString(R.string.cancel_export_confirmation_message, new Object[]{r6});
            goto L7
        }

        @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface r1) {
            super.onDismiss(r1);
            Activity r0 = getActivity();
            if (r0 == null) goto L6;
            r0.finish();
            return;
        }
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
            onCancel(r1);
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            if (r1 == null) goto L4;
            r1.dismiss();
        L4:
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

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
    }

    @Override // android.app.Activity
    protected void onStop() {
        com_android_contacts_vcard_CancelActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public CancelActivity() {
        this.LOG_TAG = "VCardCancel";
        AnonymousClass1 r1 = null;
        this.mCancelListener = new CancelListener(this, r1);
        this.mRequestCancelListener = new RequestCancelListener(this, r1);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        UiUtils.setWindowColorStatusBar(this);
        parseIntent(getIntent());
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        parseIntent(r1);
    }

    private void parseIntent(Intent r5) {
        Uri r6 = r5.getData();
        this.mJobId = Integer.parseInt(r6.getQueryParameter("job_id"));
        this.mDisplayName = r6.getQueryParameter(DISPLAY_NAME);
        this.mType = Integer.parseInt(r6.getQueryParameter("type"));
        if (this.mFragmentManager != null) goto L5;
        this.mFragmentManager = getFragmentManager();
    L5:
        CancelDialogFragment r7 = (CancelDialogFragment) this.mFragmentManager.findFragmentByTag(CANCEL_DIALOG_TAG);
        this.mCancelDialog = r7;
        if (r7 == null) goto L8;
        r7.dismiss();
    L8:
        this.mCancelDialog = new CancelDialogFragment();
        Bundle r8 = new Bundle();
        r8.putInt("type", this.mType);
        r8.putString(DISPLAY_NAME, this.mDisplayName);
        this.mCancelDialog.setArguments(r8);
        this.mCancelDialog.setListeners(this.mRequestCancelListener, this.mCancelListener);
        this.mCancelDialog.show(this.mFragmentManager, CANCEL_DIALOG_TAG);
    }

    public void com_android_contacts_vcard_CancelActivity__onStop$___twin___() {
        super.onStop();
        finish();
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int r4, Bundle r5) {
        switch(r4) {
            case 2131362492: goto L9;
            case 2131362493: goto L7;
            default: goto L4;
        };
    L4:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w("VCardCancel", "Unknown dialog id: " + r4);
        return super.onCreateDialog(r4, r5);
    L7:
        return new AlertDialog.Builder(this).setTitle(R.string.cancel_vcard_import_or_export_failed).setIconAttribute(android.R.attr.alertDialogIcon).setMessage(getString(R.string.fail_reason_unknown)).setOnCancelListener(this.mCancelListener).setPositiveButton(android.R.string.ok, this.mCancelListener).create();
    L9:
        if (this.mType != 1) goto L11;
        String r6 = getString(R.string.cancel_import_confirmation_title);
        String r7 = getString(R.string.cancel_import_confirmation_message, new Object[]{this.mDisplayName});
    L13:
        return new AlertDialog.Builder(this).setTitle(r6).setMessage(r7).setPositiveButton(android.R.string.ok, this.mRequestCancelListener).setOnCancelListener(this.mCancelListener).setNegativeButton(android.R.string.cancel, this.mCancelListener).create();
    L11:
        r6 = getString(R.string.cancel_export_confirmation_title);
        r7 = getString(R.string.cancel_export_confirmation_message, new Object[]{this.mDisplayName});
        goto L13
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r3, IBinder r4) {
        VCardService r5 = ((VCardService.MyBinder) r4).getService();
        r5.handleCancelRequest(new CancelRequest(this.mJobId, this.mDisplayName), new NotificationImportExportListener(this));     // Catch: Throwable -> L9
        unbindService(this);
        CancelDialogFragment r6 = this.mCancelDialog;
        if (r6 == null) goto L7;
        r6.dismiss();
    L7:
        finish();
        return;
    L9:
        th = move-exception;
        unbindService(this);
        throw th;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AnimationUtil.switchActivityAnimation(this, 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_vcard_CancelActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CancelActivity r1) {
        r1.com_android_contacts_vcard_CancelActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }
}
