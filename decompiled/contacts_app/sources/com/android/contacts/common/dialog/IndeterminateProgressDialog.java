package com.android.contacts.common.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class IndeterminateProgressDialog extends DialogFragment {
    private static final String TAG = "IndeterminateProgressDialog";
    private boolean mActivityReady;
    private boolean mAllowStateLoss;
    private boolean mCalledSuperDismiss;
    private final Runnable mDismisser;
    private final Handler mHandler;
    private CharSequence mMessage;
    private long mMinDisplayTime;
    private Dialog mOldDialog;
    private long mShowTime;
    private CharSequence mTitle;

    static {
    }

    public IndeterminateProgressDialog() {
        this.mShowTime = 0;
        this.mActivityReady = false;
        this.mHandler = new Handler();
        this.mCalledSuperDismiss = false;
        this.mDismisser = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(IndeterminateProgressDialog r0) {
        r0.superDismiss();
    }

    public static IndeterminateProgressDialog show(FragmentManager r1, CharSequence r2, CharSequence r3, long r4) {
        IndeterminateProgressDialog r0 = new IndeterminateProgressDialog();
        r0.mTitle = r2;
        r0.mMessage = r3;
        r0.mMinDisplayTime = r4;
        r0.show(r1, TAG);
        r0.mShowTime = System.currentTimeMillis();
        r0.setCancelable(false);
        return r0;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        setRetainInstance(true);
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        ProgressDialog r3 = new ProgressDialog(getActivity());
        r3.setIndeterminate(true);
        r3.setIndeterminateDrawable(null);
        r3.setTitle(this.mTitle);
        r3.setMessage(this.mMessage);
        return r3;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        this.mActivityReady = true;
        if (this.mCalledSuperDismiss == false) goto L6;
        superDismiss();
        return;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStop() {
        super.onStop();
        this.mActivityReady = false;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r2) {
        Dialog r0 = this.mOldDialog;
        if (r0 == null) goto L6;
        if (r0 != r2) goto L6;
        return;
    L6:
        super.onDismiss(r2);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        this.mOldDialog = getDialog();
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        this.mAllowStateLoss = false;
        dismissWhenReady();
    }

    @Override // android.app.DialogFragment
    public void dismissAllowingStateLoss() {
        this.mAllowStateLoss = true;
        dismissWhenReady();
    }

    private void dismissWhenReady() {
        long r0 = System.currentTimeMillis() - this.mShowTime;
        long r2 = this.mMinDisplayTime;
        if (r0 < r2) goto L5;
        this.mHandler.post(this.mDismisser);
        return;
    L5:
        long r3 = r2 - r0;
        this.mHandler.postDelayed(this.mDismisser, r3);
    }

    private void superDismiss() {
        this.mCalledSuperDismiss = true;
        if (this.mActivityReady == true) goto L5;
        return;
    L5:
        if (this.mAllowStateLoss == false) goto L7;
        super.dismissAllowingStateLoss();
        return;
    L7:
        super.dismiss();
    }
}
