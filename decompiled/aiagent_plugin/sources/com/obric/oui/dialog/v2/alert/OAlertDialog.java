package com.obric.oui.dialog.v2.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.AlertDialogHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OAlertDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OAlertDialog extends AbstractDialog implements com.obric.oui.dialog.v2.alert.style.c {
    private final String TAG;
    private final FrameLayout bannderPanel;
    private final FrameLayout bodyPanel;
    private com.obric.oui.dialog.v2.alert.style.e bodyStyleController;
    private final FrameLayout buttonPanel;
    private com.obric.oui.dialog.v2.alert.style.e buttonStyleController;
    private final ViewGroup headerPanel;
    private final FrameLayout iconPanel;
    private boolean messageMoreThanTwoLines;
    private TextView messageTextView;
    private TextView titleTextView;
    private com.obric.oui.dialog.v2.alert.style.e topImageStyleController;

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class a extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35120a;

        a(OAlertDialog r1) {
            this.f35120a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            if (this.f35120a.getRootView().getAlpha() != 0.0f) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            this.f35120a.getRootView().setAlpha(1.0f);
            return;
        L9:
            return;
        L5:
            r3 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class b extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35121a;

        b(OAlertDialog r1) {
            this.f35121a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35121a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35121a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class c extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35122a;

        c(OAlertDialog r1) {
            this.f35122a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35122a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35122a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class d extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35123a;

        d(OAlertDialog r1) {
            this.f35123a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35123a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35123a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class e extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35124a;

        e(OAlertDialog r1) {
            this.f35124a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35124a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35124a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class f extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35125a;

        f(OAlertDialog r1) {
            this.f35125a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35125a.originDismiss();
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class g extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35126a;

        g(OAlertDialog r1) {
            this.f35126a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35126a.originDismiss();
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$gAGq4ydqJ7-4XhQMQEZB3exC1Kg, reason: not valid java name */
    public static /* synthetic */ void m1030lambda$gAGq4ydqJ74XhQMQEZB3exC1Kg(OAlertDialog r0) {
        m1032onStart$lambda8(r0);
    }

    /* JADX INFO: renamed from: lambda$m15tSjQ3aBtWi9ge3PF-cZjRfzo, reason: not valid java name */
    public static /* synthetic */ void m1031lambda$m15tSjQ3aBtWi9ge3PFcZjRfzo(OAlertDialog r0) {
        m1033performEnterAnimation$lambda10(r0);
    }

    public /* synthetic */ OAlertDialog(Context r2, boolean r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        this(r6, r3);
    }

    public OAlertDialog(Context r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, false, r5);
        this.TAG = "OAlertDialog";
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

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_alert_dialog_v2, "layout", "o_alert_dialog_v2");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public View getHeightChangeAnimContainer() {
        return (View) ZeusTransformUtils.preCheckCast(this.headerPanel, View.class, "com.obric.aiagent.plugin");
    }

    public final void setTopImageStyleController(com.obric.oui.dialog.v2.alert.style.e r4) {
        com.obric.oui.dialog.v2.alert.style.e r5 = (com.obric.oui.dialog.v2.alert.style.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.dialog.v2.alert.style.e.class, "com.obric.aiagent.plugin");
        o.e(r5, "controller");
        this.topImageStyleController = r5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        r5.a(r0, (com.obric.oui.dialog.v2.alert.style.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.v2.alert.style.c.class, "com.obric.aiagent.plugin"));
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
        r4 = com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), 8);
    L16:
        r10.topMargin = r4;
        return;
    }

    public final void setOnlyTitleText(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L10;
        TextView r4 = this.titleTextView;
        if (r4 == null) goto L11;
        r4.setVisibility(0);
        r4.setText(r6);
        r4.setPadding(0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 19), 0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 19));
        return;
    L11:
        return;
    }

    public static /* synthetic */ void setMessage$default(OAlertDialog r2, CharSequence r3, boolean r4, int r5, Object r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L10;
        if ((r5 & 2) == 0) goto L7;
        r4 = false;
    L7:
        r2.setMessage(r7, r4);
        return;
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    public final void setMessage(CharSequence r2, boolean r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, "message");
        TextView r5 = this.messageTextView;
        if (r5 == null) goto L6;
        r5.setVisibility(0);
        r5.setText(r4);
        com.obric.oui.dialog.b.a(r5, r4);
    L6:
        TextView r1 = this.messageTextView;
        if (r1 == null) goto L11;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void allowMoreThanTwoLinesMessage() {
        TextView r1 = this.messageTextView;
        if (r1 == null) goto L7;
        r1.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void setButtonStyleController(com.obric.oui.dialog.v2.alert.style.e r4) {
        com.obric.oui.dialog.v2.alert.style.e r5 = (com.obric.oui.dialog.v2.alert.style.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.dialog.v2.alert.style.e.class, "com.obric.aiagent.plugin");
        o.e(r5, "controller");
        this.buttonStyleController = r5;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        r5.a(r0, (com.obric.oui.dialog.v2.alert.style.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.v2.alert.style.c.class, "com.obric.aiagent.plugin"));
    }

    public final void setBodyStyleController(com.obric.oui.dialog.v2.alert.style.e r5) {
        com.obric.oui.dialog.v2.alert.style.e r6 = (com.obric.oui.dialog.v2.alert.style.e) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.dialog.v2.alert.style.e.class, "com.obric.aiagent.plugin");
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
        r6.a(r1, (com.obric.oui.dialog.v2.alert.style.c) ZeusTransformUtils.preCheckCast(this, com.obric.oui.dialog.v2.alert.style.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r3) {
        if (getHideFirstFrame() == false) goto L5;
        getRootView().setAlpha(0.0f);
    L5:
        super.onCreate(r3);
        com.obric.oui.dialog.v2.alert.style.e r4 = this.topImageStyleController;
        if (r4 == null) goto L9;
        r4.a((AlertDialogHost) ZeusTransformUtils.preCheckCast(this, AlertDialogHost.class, "com.obric.aiagent.plugin"));
    L9:
        com.obric.oui.dialog.v2.alert.style.e r5 = this.buttonStyleController;
        if (r5 == null) goto L13;
        r5.a((AlertDialogHost) ZeusTransformUtils.preCheckCast(this, AlertDialogHost.class, "com.obric.aiagent.plugin"));
    L13:
        com.obric.oui.dialog.v2.alert.style.e r6 = this.bodyStyleController;
        if (r6 == null) goto L18;
        r6.a((AlertDialogHost) ZeusTransformUtils.preCheckCast(this, AlertDialogHost.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        performEnterAnimation();
        TextView r0 = this.messageTextView;
        if (r0 == null) goto L7;
        r0.postDelayed(new $$Lambda$OAlertDialog$gAGq4ydqJ74XhQMQEZB3exC1Kg(this), 1000);
        return;
    }

    /* JADX INFO: renamed from: onStart$lambda-8, reason: not valid java name */
    private static final void m1032onStart$lambda8(OAlertDialog r2) {
        o.e(r2, "this$0");
        TextView r0 = r2.messageTextView;
        if (r0 == null) goto L9;
        Layout r1 = r0.getLayout();
        if (r1 == null) goto L9;
        r1.getLineCount();
    L9:
        TextView r3 = r2.messageTextView;
        if (r3 == null) goto L14;
        r3.getMaxLines();
        return;
    }

    public void performExitAnimation() {
        com.obric.oui.animation.a.b r0 = com.obric.oui.dialog.a.a.a(com.obric.oui.dialog.a.a.f35019a, getRootView(), getWindow(), !getAdaptWindowDim(), false, 4, null);
        com.obric.oui.animation.a.b.a(r0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(this), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
        r0.b();
    }

    public void performEnterAnimation() {
        getRootView().post(new $$Lambda$OAlertDialog$m15tSjQ3aBtWi9ge3PFcZjRfzo(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-10, reason: not valid java name */
    private static final void m1033performEnterAnimation$lambda10(OAlertDialog r10) {
        o.e(r10, "this$0");
        com.obric.oui.dialog.a.a r1 = com.obric.oui.dialog.a.a.f35019a;
        View r2 = r10.getRootView();
        Window r3 = r10.getWindow();
        boolean r4 = !r10.getAdaptWindowDim();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        com.obric.oui.animation.a.b r5 = com.obric.oui.dialog.a.a.a(r1, r2, r3, r4, r10.getTargetWindowDimAmount(r0), false, 8, null).b();
        if (r10.getHideFirstFrame() == false) goto L5;
        r5.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r10), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new b(r10), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r10), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L5:
        com.obric.oui.animation.a.b.a(r5, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r10), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(r10), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
    }

    public final void originDismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        INVOKESTATIC_com_obric_oui_dialog_v2_alert_OAlertDialog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("OAlertDialog", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        performExitAnimation();
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
        com.obric.oui.dialog.v2.alert.style.e r3 = this.buttonStyleController;
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L7:
        com.obric.oui.dialog.v2.alert.style.a r4 = (com.obric.oui.dialog.v2.alert.style.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.v2.alert.style.a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.a();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.dialog.v2.alert.style.a.class) == false) goto L4;
        goto L4
    }

    public final View getNegativeButton() {
        com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
        com.obric.oui.dialog.v2.alert.style.e r3 = this.buttonStyleController;
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L7:
        com.obric.oui.dialog.v2.alert.style.a r4 = (com.obric.oui.dialog.v2.alert.style.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.v2.alert.style.a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.b();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.dialog.v2.alert.style.a.class) == false) goto L4;
        goto L4
    }

    public final View getNeutralButton() {
        com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
        com.obric.oui.dialog.v2.alert.style.e r3 = this.buttonStyleController;
        if (r3 != null) goto L6;
    L4:
        r3 = null;
    L7:
        com.obric.oui.dialog.v2.alert.style.a r4 = (com.obric.oui.dialog.v2.alert.style.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.v2.alert.style.a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.c();
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.oui.dialog.v2.alert.style.a.class) == false) goto L4;
        goto L4
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
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

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_dialog_v2_alert_OAlertDialog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
