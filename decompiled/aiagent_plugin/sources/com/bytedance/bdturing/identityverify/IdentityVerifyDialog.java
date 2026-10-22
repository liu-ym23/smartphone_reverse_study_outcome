package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class IdentityVerifyDialog extends Dialog {
    private TextView mCancel;
    private TextView mConfirm;
    private View mContentView;
    protected Activity mContext;
    private a mDialogCallback;
    private View mHorizontalDivideLine;
    private TextView mTvContent;
    private TextView mTvTitle;
    private View mVerticalDivideLine;

    public interface a {
        void a();

        void b();
    }

    static /* synthetic */ a access$000(IdentityVerifyDialog r0) {
        return r0.mDialogCallback;
    }

    static /* synthetic */ void access$100(IdentityVerifyDialog r0) {
        r0.safeDismiss();
    }

    public IdentityVerifyDialog(Activity r5, a r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r5, Activity.class, "com.obric.aiagent.plugin");
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.aiagent.plugin");
        super(r7, ZeusTransformUtils.mapRes(R.style.BdTuring_Identify_Dialog, "style", "BdTuring_Identify_Dialog"));
        this.mContext = ZeusTransformUtils.wrapperContext2Activity(r7, "com.obric.aiagent.plugin");
        this.mDialogCallback = r8;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(ZeusTransformUtils.mapRes(R.layout.bdturing_identity_verify_dialog_layout, "layout", "bdturing_identity_verify_dialog_layout"));
        initView();
        bindData();
        initAction();
    }

    private void bindData() {
        if (com.bytedance.bdturing.b.a().b() == null) goto L5;
        com.bytedance.bdturing.c.c r0 = com.bytedance.bdturing.b.a().b().getThemeConfig();
    L6:
        if (r0 == null) goto L31;
        com.bytedance.bdturing.c.a r1 = r0.a();
        if (r1 == null) goto L32;
        this.mTvTitle.setTextSize(r1.e());
        this.mTvTitle.setTextColor(r1.i());
        if (TextUtils.isEmpty(r1.a()) == true) goto L12;
        this.mTvTitle.setText(r1.a());
    L12:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.mTvTitle.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r2.topMargin = dpToPix((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1.p());
        this.mTvTitle.setLayoutParams(r2);
        this.mTvContent.setTextSize(r1.f());
        this.mTvContent.setTextColor(r1.j());
        if (TextUtils.isEmpty(r1.b()) == true) goto L15;
        this.mTvContent.setText(r1.b());
    L15:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.mTvContent.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        r3.topMargin = dpToPix((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1.q());
        this.mTvContent.setLayoutParams(r3);
        this.mCancel.setTextSize(r1.g());
        this.mCancel.setTextColor(r1.k());
        if (TextUtils.isEmpty(r1.c()) == true) goto L19;
        this.mCancel.setText(r1.c());
    L19:
        if (r1.r() == null) goto L21;
        this.mCancel.setBackground(r1.r());
    L21:
        this.mConfirm.setTextSize(r1.h());
        this.mConfirm.setTextColor(r1.l());
        if (TextUtils.isEmpty(r1.d()) == true) goto L25;
        this.mConfirm.setText(r1.d());
    L25:
        if (r1.s() == null) goto L27;
        this.mConfirm.setBackground(r1.s());
    L27:
        this.mHorizontalDivideLine.setBackgroundColor(r1.m());
        int r4 = dpToPix((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1.n());
        ViewGroup.LayoutParams r5 = this.mHorizontalDivideLine.getLayoutParams();
        r5.height = r4;
        this.mHorizontalDivideLine.setLayoutParams(r5);
        this.mVerticalDivideLine.setBackgroundColor(r1.m());
        ViewGroup.LayoutParams r6 = this.mVerticalDivideLine.getLayoutParams();
        r6.width = r4;
        this.mVerticalDivideLine.setLayoutParams(r6);
        if (r1.o() == null) goto L33;
        this.mContentView.setBackground(r1.o());
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L5:
        r0 = null;
        goto L6
    }

    private void initView() {
        this.mHorizontalDivideLine = findViewById(ZeusTransformUtils.mapRes(R.id.v_divide_line_h, DbHelper.COL_ID, "v_divide_line_h"));
        this.mVerticalDivideLine = findViewById(ZeusTransformUtils.mapRes(R.id.v_divide_line_v, DbHelper.COL_ID, "v_divide_line_v"));
        this.mTvTitle = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_dlg_title, DbHelper.COL_ID, "tv_dlg_title")), TextView.class, "com.obric.aiagent.plugin");
        this.mTvContent = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_dlg_content, DbHelper.COL_ID, "tv_dlg_content")), TextView.class, "com.obric.aiagent.plugin");
        this.mCancel = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_dlg_cancel, DbHelper.COL_ID, "tv_dlg_cancel")), TextView.class, "com.obric.aiagent.plugin");
        this.mConfirm = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.tv_dlg_confirm, DbHelper.COL_ID, "tv_dlg_confirm")), TextView.class, "com.obric.aiagent.plugin");
        this.mContentView = findViewById(ZeusTransformUtils.mapRes(R.id.root_view, DbHelper.COL_ID, "root_view"));
    }

    private void initAction() {
        setOnCancelListener(new AnonymousClass1(this));
        this.mCancel.setOnClickListener(new AnonymousClass2(this));
        this.mConfirm.setOnClickListener(new AnonymousClass3(this));
    }

    public boolean isViewValid() {
        return !this.mContext.isFinishing();
    }

    @Override // android.app.Dialog
    public void show() {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        super.show();
    }

    private void safeDismiss() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private int dpToPix(Context r2, float r3) {
        return (int) ((ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getDisplayMetrics().density * r3) + 0.5f);
    }
}
