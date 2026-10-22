package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.dialog.b;
import com.obric.oui.dialog.base.AbstractDialogModal;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.obric.oui.dialog.v2.alert.style.c;
import com.obric.oui.dialog.v2.alert.style.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: OAlertDialogModal.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OAlertDialogModal extends AbstractDialogModal implements c {
    private final FrameLayout bannderPanel;
    private final FrameLayout bodyPanel;
    private e bodyStyleController;
    private final FrameLayout buttonPanel;
    private com.obric.oui.dialog.v2.alert.style.a buttonStyleController;
    private final ViewGroup headerPanel;
    private final FrameLayout iconPanel;
    private TextView messageTextView;
    private final String tagName;
    private TextView titleTextView;
    private e topImageStyleController;

    public static /* synthetic */ void lambda$36EAq5VMGAxVappcZyyeqiry_sI(OAlertDialogModal r0) {
        m1034show$lambda8(r0);
    }

    public /* synthetic */ OAlertDialogModal(Context r2, boolean r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        this(r6, r3);
    }

    public OAlertDialogModal(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, false, r5);
        this.tagName = "OAlertDialogModal";
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.bannerPanel, DbHelper.COL_ID, "bannerPanel"));
        o.c(r7, "findViewById(R.id.bannerPanel)");
        this.bannderPanel = (FrameLayout) ZeusTransformUtils.preCheckCast(r7, FrameLayout.class, "com.obric.aiagent.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.iconPanel, DbHelper.COL_ID, "iconPanel"));
        o.c(r8, "findViewById(R.id.iconPanel)");
        this.iconPanel = (FrameLayout) ZeusTransformUtils.preCheckCast(r8, FrameLayout.class, "com.obric.aiagent.plugin");
        View r9 = findViewById(ZeusTransformUtils.mapRes(R.id.header_container, DbHelper.COL_ID, "header_container"));
        o.c(r9, "findViewById(R.id.header_container)");
        this.headerPanel = (ViewGroup) ZeusTransformUtils.preCheckCast(r9, ViewGroup.class, "com.obric.aiagent.plugin");
        TextView r10 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.textTitle, DbHelper.COL_ID, "textTitle")), TextView.class, "com.obric.aiagent.plugin");
        this.titleTextView = r10;
        if (r10 == null) goto L6;
        r10.setIncludeFontPadding(true);
    L6:
        TextView r11 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.textSubTitle, DbHelper.COL_ID, "textSubTitle")), TextView.class, "com.obric.aiagent.plugin");
        this.messageTextView = r11;
        if (r11 == null) goto L10;
        r11.setIncludeFontPadding(true);
    L10:
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.button_container, DbHelper.COL_ID, "button_container"));
        o.c(r12, "findViewById(R.id.button_container)");
        this.buttonPanel = (FrameLayout) ZeusTransformUtils.preCheckCast(r12, FrameLayout.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.body_container, DbHelper.COL_ID, "body_container"));
        o.c(r13, "findViewById(R.id.body_container)");
        this.bodyPanel = (FrameLayout) ZeusTransformUtils.preCheckCast(r13, FrameLayout.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_alert_dialog_v2, "layout", "o_alert_dialog_v2");
    }

    public final void setTopImageStyleController(e r4) {
        e r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        o.e(r5, "controller");
        this.topImageStyleController = r5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        r5.a(r0, (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin"));
    }

    public final void setTitleText(CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r0 = TextUtils.isEmpty(r8);
        TextView r2 = this.titleTextView;
        int r4 = 0;
        if (r2 == null) goto L9;
        if (r0 == false) goto L7;
        int r5 = 8;
    L8:
        r2.setVisibility(r5);
        r2.setText(r8);
        r2.setPadding(0, 0, 0, 0);
        goto L9
    L7:
        r5 = 0;
    L9:
        TextView r6 = this.messageTextView;
        if (r6 == null) goto L18;
        ViewGroup.LayoutParams r9 = r6.getLayoutParams();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r9, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r0 == true) goto L16;
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r11, "it.context");
        r4 = g.a(r11, 8);
    L16:
        r10.topMargin = r4;
        return;
    }

    public final void setOnlyTitleText(CharSequence r7) {
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r7, CharSequence.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L10;
        TextView r6 = this.titleTextView;
        if (r6 == null) goto L11;
        r6.setVisibility(0);
        r6.setText(r8);
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r9, "tv.context");
        int r10 = g.a(r9, 19);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "tv.context");
        r6.setPadding(0, r10, 0, g.a(r1, 19));
        return;
    L11:
        return;
    }

    public final void setMessage(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "message");
        TextView r0 = this.messageTextView;
        if (r0 == null) goto L6;
        r0.setVisibility(0);
        r0.setText(r4);
        b.a(r0, r4);
    L6:
        TextView r2 = this.messageTextView;
        if (r2 == null) goto L11;
        r2.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void allowMoreThanTwoLinesMessage() {
        TextView r1 = this.messageTextView;
        if (r1 == null) goto L7;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void setButtonStyleController(com.obric.oui.dialog.v2.alert.style.a r4) {
        o.e(r4, "controller");
        this.buttonStyleController = r4;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        r4.a(r0, (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin"));
        r4.a((AlertDialogHost) ZeusTransformUtils.preCheckCast(this, AlertDialogHost.class, "com.obric.aiagent.plugin"));
    }

    public final void setBodyStyleController(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.aiagent.plugin");
        o.e(r6, "controller");
        this.bodyStyleController = r6;
        FrameLayout r0 = this.bodyPanel;
        if (getMatchParentHeight() == false) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = 0;
        r0.setLayoutParams(r2);
    L5:
        r0.setVisibility(0);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "context");
        r6.a(r1, (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialogModal
    public void show(ViewGroup r4) {
        super.show(r4);
        e r5 = this.topImageStyleController;
        if (r5 == null) goto L6;
        r5.a((AlertDialogHost) ZeusTransformUtils.preCheckCast(this, AlertDialogHost.class, "com.obric.aiagent.plugin"));
    L6:
        e r6 = this.bodyStyleController;
        if (r6 == null) goto L10;
        r6.a((AlertDialogHost) ZeusTransformUtils.preCheckCast(this, AlertDialogHost.class, "com.obric.aiagent.plugin"));
    L10:
        com.obric.oui.dialog.v2.alert.style.a r7 = this.buttonStyleController;
        if (r7 == null) goto L14;
        r7.a((AlertDialogHost) ZeusTransformUtils.preCheckCast(this, AlertDialogHost.class, "com.obric.aiagent.plugin"));
    L14:
        TextView r8 = this.messageTextView;
        if (r8 == null) goto L19;
        r8.postDelayed(new $$Lambda$OAlertDialogModal$36EAq5VMGAxVappcZyyeqiry_sI(this), 1000);
        return;
    }

    /* JADX INFO: renamed from: show$lambda-8, reason: not valid java name */
    private static final void m1034show$lambda8(OAlertDialogModal r1) {
        o.e(r1, "this$0");
        TextView r0 = r1.messageTextView;
        if (r0 == null) goto L9;
        Layout r2 = r0.getLayout();
        if (r2 == null) goto L9;
        r2.getLineCount();
    L9:
        TextView r3 = r1.messageTextView;
        if (r3 == null) goto L14;
        r3.getMaxLines();
        return;
    }

    public final CharSequence getTitleStr() {
        TextView r0 = this.titleTextView;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final CharSequence getMessageStr() {
        TextView r0 = this.messageTextView;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getText();
    }

    public final TextView getTitleView() {
        return this.titleTextView;
    }

    public final TextView getMessageView() {
        return this.messageTextView;
    }

    public final View getPositiveButton() {
        com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
        com.obric.oui.dialog.v2.alert.style.a r1 = this.buttonStyleController;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.a();
    }

    public final View getNegativeButton() {
        com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
        com.obric.oui.dialog.v2.alert.style.a r1 = this.buttonStyleController;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.b();
    }

    public final View getNeutralButton() {
        com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
        com.obric.oui.dialog.v2.alert.style.a r1 = this.buttonStyleController;
        if (r1 != null) goto L5;
        r1 = null;
    L5:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.c();
    }

    @Override // com.obric.oui.dialog.v2.alert.style.c
    public FrameLayout getBannerSlot() {
        return this.bannderPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.c
    public FrameLayout getIconSlot() {
        return this.iconPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.c
    public FrameLayout getBodySlot() {
        return this.bodyPanel;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.c
    public FrameLayout getButtonSlot() {
        return this.buttonPanel;
    }
}
