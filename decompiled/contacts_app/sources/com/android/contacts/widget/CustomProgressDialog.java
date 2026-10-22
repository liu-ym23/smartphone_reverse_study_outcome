package com.android.contacts.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.android.contacts.util.BytedanceApi;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes2.dex */
public class CustomProgressDialog extends AlertDialog {
    private Context mCtx;
    private boolean mHasStarted;
    private int mIncrementBy;
    private int mIncrementSecondaryBy;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private int mMax;
    private CharSequence mMessage;
    private TextView mMessageView;
    private ProgressBar mProgress;
    private CharSequence mProgressDescription;
    private TextView mProgressDescriptionView;
    private Drawable mProgressDrawable;
    private TextView mProgressNumber;
    private String mProgressNumberFormat;
    private TextView mProgressPercent;
    private NumberFormat mProgressPercentFormat;
    private int mProgressVal;
    private int mSecondaryProgressVal;
    private Handler mViewUpdateHandler;

    static /* synthetic */ ProgressBar access$000(CustomProgressDialog r0) {
        return r0.mProgress;
    }

    static /* synthetic */ String access$100(CustomProgressDialog r0) {
        return r0.mProgressNumberFormat;
    }

    static /* synthetic */ TextView access$200(CustomProgressDialog r0) {
        return r0.mProgressNumber;
    }

    static /* synthetic */ NumberFormat access$300(CustomProgressDialog r0) {
        return r0.mProgressPercentFormat;
    }

    static /* synthetic */ TextView access$400(CustomProgressDialog r0) {
        return r0.mProgressPercent;
    }

    public CustomProgressDialog(Context r1) {
        super(r1);
        this.mCtx = r1;
        initFormats();
    }

    public CustomProgressDialog(Context r1, int r2) {
        super(r1, r2);
        this.mCtx = r1;
        initFormats();
    }

    private void initFormats() {
        this.mProgressNumberFormat = "(%1d/%2d)";
        NumberFormat r0 = NumberFormat.getPercentInstance();
        this.mProgressPercentFormat = r0;
        r0.setMaximumFractionDigits(0);
    }

    public static CustomProgressDialog show(Context r1, CharSequence r2, CharSequence r3) {
        return show(r1, r2, r3, false);
    }

    public static CustomProgressDialog show(Context r6, CharSequence r7, CharSequence r8, boolean r9) {
        return show(r6, r7, r8, r9, false, null);
    }

    public static CustomProgressDialog show(Context r6, CharSequence r7, CharSequence r8, boolean r9, boolean r10) {
        return show(r6, r7, r8, r9, r10, null);
    }

    public static CustomProgressDialog show(Context r1, CharSequence r2, CharSequence r3, boolean r4, boolean r5, DialogInterface.OnCancelListener r6) {
        CustomProgressDialog r0 = new CustomProgressDialog(r1);
        r0.setTitle(r2);
        r0.setMessage(r3);
        r0.setIndeterminate(r4);
        r0.setCancelable(r5);
        r0.setOnCancelListener(r6);
        r0.show();
        return r0;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle r6) {
        LayoutInflater r0 = LayoutInflater.from(this.mCtx);
        this.mViewUpdateHandler = new AnonymousClass1(this);
        View r1 = r0.inflate(R.layout.custom_dialog_progress, null);
        this.mMessageView = (TextView) r1.findViewById(R.id.message);
        this.mProgress = (ProgressBar) r1.findViewById(R.id.progress);
        this.mProgressNumber = (TextView) r1.findViewById(R.id.progress_number);
        TextView r2 = (TextView) r1.findViewById(R.id.progress_percent);
        this.mProgressPercent = r2;
        BytedanceApi.setMaxTextSize(r2, ContactsUtils.dipTopx(getContext(), 15.0d));
        this.mProgressDescriptionView = (TextView) r1.findViewById(R.id.progress_description);
        setView(r1);
        int r3 = this.mMax;
        if (r3 <= 0) goto L5;
        setMax(r3);
    L5:
        int r4 = this.mProgressVal;
        if (r4 <= 0) goto L8;
        setProgress(r4);
    L8:
        int r5 = this.mSecondaryProgressVal;
        if (r5 <= 0) goto L11;
        setSecondaryProgress(r5);
    L11:
        int r7 = this.mIncrementBy;
        if (r7 <= 0) goto L14;
        incrementProgressBy(r7);
    L14:
        int r8 = this.mIncrementSecondaryBy;
        if (r8 <= 0) goto L17;
        incrementSecondaryProgressBy(r8);
    L17:
        Drawable r9 = this.mProgressDrawable;
        if (r9 == null) goto L20;
        setProgressDrawable(r9);
    L20:
        Drawable r10 = this.mIndeterminateDrawable;
        if (r10 == null) goto L23;
        setIndeterminateDrawable(r10);
    L23:
        CharSequence r11 = this.mMessage;
        if (r11 == null) goto L26;
        setMessage(r11);
    L26:
        CharSequence r12 = this.mProgressDescription;
        if (r12 == null) goto L29;
        setProgressDescription(r12);
    L29:
        setIndeterminate(this.mIndeterminate);
        onProgressChanged();
        super.onCreate(r6);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.mHasStarted = true;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.mHasStarted = false;
    }

    public void setProgress(int r2) {
        if (this.mHasStarted == false) goto L5;
        this.mProgress.setProgress(r2);
        onProgressChanged();
        return;
    L5:
        this.mProgressVal = r2;
    }

    public void setSecondaryProgress(int r2) {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L5;
        r0.setSecondaryProgress(r2);
        onProgressChanged();
        return;
    L5:
        this.mSecondaryProgressVal = r2;
    }

    public int getProgress() {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L7;
        return r0.getProgress();
    L7:
        return this.mProgressVal;
    }

    public int getSecondaryProgress() {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L7;
        return r0.getSecondaryProgress();
    L7:
        return this.mSecondaryProgressVal;
    }

    public int getMax() {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L7;
        return r0.getMax();
    L7:
        return this.mMax;
    }

    public void setMax(int r2) {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L5;
        r0.setMax(r2);
        onProgressChanged();
        return;
    L5:
        this.mMax = r2;
    }

    public void incrementProgressBy(int r2) {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L5;
        r0.incrementProgressBy(r2);
        onProgressChanged();
        return;
    L5:
        this.mIncrementBy += r2;
    }

    public void incrementSecondaryProgressBy(int r2) {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L5;
        r0.incrementSecondaryProgressBy(r2);
        onProgressChanged();
        return;
    L5:
        this.mIncrementSecondaryBy += r2;
    }

    public void setProgressDrawable(Drawable r2) {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L5;
        r0.setProgressDrawable(r2);
        return;
    L5:
        this.mProgressDrawable = r2;
    }

    public void setIndeterminateDrawable(Drawable r2) {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L5;
        r0.setIndeterminateDrawable(r2);
        return;
    L5:
        this.mIndeterminateDrawable = r2;
    }

    public void setIndeterminate(boolean r2) {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L5;
        r0.setIndeterminate(r2);
        return;
    L5:
        this.mIndeterminate = r2;
    }

    public boolean isIndeterminate() {
        ProgressBar r0 = this.mProgress;
        if (r0 == null) goto L7;
        return r0.isIndeterminate();
    L7:
        return this.mIndeterminate;
    }

    @Override // android.app.AlertDialog
    public void setMessage(CharSequence r2) {
        TextView r0 = this.mMessageView;
        if (r0 == null) goto L5;
        r0.setText(r2);
        return;
    L5:
        this.mMessage = r2;
    }

    public void setProgressDescription(CharSequence r2) {
        TextView r0 = this.mProgressDescriptionView;
        if (r0 == null) goto L5;
        r0.setText(r2);
        return;
    L5:
        this.mProgressDescription = r2;
    }

    public void setProgressNumberFormat(String r1) {
        this.mProgressNumberFormat = r1;
        onProgressChanged();
    }

    public void setProgressPercentFormat(NumberFormat r1) {
        this.mProgressPercentFormat = r1;
        onProgressChanged();
    }

    private void onProgressChanged() {
        Handler r0 = this.mViewUpdateHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasMessages(0) == true) goto L9;
        this.mViewUpdateHandler.sendEmptyMessage(0);
        return;
    }
}
