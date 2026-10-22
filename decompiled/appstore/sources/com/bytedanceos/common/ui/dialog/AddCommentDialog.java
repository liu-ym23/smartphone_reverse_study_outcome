package com.bytedanceos.common.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.core.ui.presenter.APresenter;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.CommentParams;
import com.bytedanceos.common.toolbox.e0;

/* JADX INFO: loaded from: classes2.dex */
public class AddCommentDialog extends Dialog implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {
    private static final int MAX_COMMNET_NUM = 800;
    public APresenter mCallBack;
    private String mComment;
    private EditText mContentEditText;
    private int mEditViewTextCount;
    private Object mLockObject;
    private String mPackageName;
    private int mRatingByUser;

    /* JADX INFO: renamed from: com.bytedanceos.common.ui.dialog.AddCommentDialog$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class MyTextWatcher implements TextWatcher {
        final /* synthetic */ AddCommentDialog this$0;

        private MyTextWatcher(AddCommentDialog r10) {
            this.this$0 = r10;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r10) {
            Object r11 = AddCommentDialog.access$100(this.this$0);
            monitor-enter(r11);
            AddCommentDialog.access$202(this.this$0, r10.length());     // Catch: Throwable -> L7
            AddCommentDialog.access$300(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r10, int r11, int r12, int r13) {
        }

        public /* synthetic */ MyTextWatcher(AddCommentDialog r10, AnonymousClass1 r11) {
            this(r10);
        }
    }

    public AddCommentDialog(Context r10, int r11, APresenter r12) {
        super(r10, r11);
        this.mLockObject = new Object();
        this.mCallBack = r12;
    }

    public static /* synthetic */ Object access$100(AddCommentDialog r10) {
        return r10.mLockObject;
    }

    public static /* synthetic */ int access$202(AddCommentDialog r10, int r11) {
        r10.mEditViewTextCount = r11;
        return r11;
    }

    public static /* synthetic */ void access$300(AddCommentDialog r10) {
        r10.judgeDoneBtnEnabled();
    }

    private void initDialogView() {
        Object r10 = this.mLockObject;
        monitor-enter(r10);
        ((RatingBar) findViewById(R$id.comment_rating)).setRating(this.mRatingByUser);     // Catch: Throwable -> L11
        this.mContentEditText.setText(this.mComment);     // Catch: Throwable -> L11
        EditText r11 = this.mContentEditText;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(this.mComment) == false) goto L7;
        int r12 = 0;
    L8:
        r11.setSelection(r12);     // Catch: Throwable -> L11
        this.mEditViewTextCount = 0;     // Catch: Throwable -> L11
        judgeDoneBtnEnabled();     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L7:
        r12 = this.mComment.length();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void judgeDoneBtnEnabled() {
        if (this.mEditViewTextCount <= MAX_COMMNET_NUM) goto L5;
    L7:
        boolean r10 = false;
    L8:
        int r11 = R$id.done_btn;
        findViewById(r11).setEnabled(r10);
        findViewById(r11).setClickable(r10);
        return;
    L5:
        if (this.mRatingByUser == 0) goto L7;
        r10 = true;
        goto L8
    }

    private void submitComment() {
        if (BaseApplication.c().b().b0(this.mPackageName) == true) goto L6;
        dismiss();
        e0.e(R$string.add_comment_no_buy);
        return;
    L6:
        String r10 = ((EditText) findViewById(R$id.comment_et)).getText().toString();
        findViewById(R$id.done_btn).setEnabled(false);
        CommentParams r11 = new CommentParams();
        r11.mAppPackage = this.mPackageName;
        AppInfo r12 = BaseApplication.c().b().D(this.mPackageName);
        r11.mVersionName = r12.appVersionName;
        r11.mVersionCode = r12.appVersionCode;
        r11.mScore = this.mRatingByUser;
        r11.mContent = r10;
        this.mCallBack.e(700007, null, r11);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        resetCommitState(true);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 != R$id.cancel_btn) goto L6;
        dismiss();
        return;
    L6:
        if (r11 != R$id.done_btn) goto L10;
        submitComment();
        return;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R$layout.dialog_comment);
        findViewById(R$id.cancel_btn).setOnClickListener(this);
        findViewById(R$id.done_btn).setOnClickListener(this);
        ((RatingBar) findViewById(R$id.comment_rating)).setOnRatingBarChangeListener(this);
        EditText r11 = (EditText) findViewById(R$id.comment_et);
        this.mContentEditText = r11;
        r11.addTextChangedListener(new MyTextWatcher(this, null));
    }

    @Override // android.widget.RatingBar.OnRatingBarChangeListener
    public void onRatingChanged(RatingBar r10, float r11, boolean r12) {
        if (r12 == false) goto L12;
        Object r13 = this.mLockObject;
        monitor-enter(r13);
        this.mRatingByUser = (int) r11;     // Catch: Throwable -> L9
        judgeDoneBtnEnabled();     // Catch: Throwable -> L9
        monitor-exit(r13);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void resetCommitState(boolean r10) {
        findViewById(R$id.done_btn).setEnabled(true);
        if (r10 == false) goto L6;
        ((RatingBar) findViewById(R$id.comment_rating)).setRating(0.0f);
        return;
    }

    public void setData(String r10, String r11) {
        this.mComment = r10;
        if (TextUtils.isEmpty(r11) == false) goto L5;
        this.mRatingByUser = 0;
        return;
    L5:
        this.mRatingByUser = Integer.parseInt(r11);
    }

    public void setPackageName(String r10) {
        this.mPackageName = r10;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        initDialogView();
    }
}
