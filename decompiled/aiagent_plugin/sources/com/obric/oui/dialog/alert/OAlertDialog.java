package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.text.OTextView;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.x;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: OAlertDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OAlertDialog extends AbstractDialog {
    private final String TAG;
    private FrameLayout bodyPanel;
    private com.obric.oui.dialog.alert.d bodyStyleController;
    private FrameLayout buttonPanel;
    private com.obric.oui.dialog.alert.d buttonStyleController;
    private FrameLayout iconPanel;
    private com.obric.oui.dialog.alert.d iconStyleController;
    private boolean messageMoreThanTwoLines;
    private TextView messageTextView;
    private TextView titleTextView;

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class a extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35036a;

        a(OAlertDialog r1) {
            this.f35036a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            if (this.f35036a.getRootView().getAlpha() != 0.0f) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L9;
            this.f35036a.getRootView().setAlpha(1.0f);
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
        final /* synthetic */ OAlertDialog f35037a;

        b(OAlertDialog r1) {
            this.f35037a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35037a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35037a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class c extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35038a;

        c(OAlertDialog r1) {
            this.f35038a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35038a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35038a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class d extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35039a;

        d(OAlertDialog r1) {
            this.f35039a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35039a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35039a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class e extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35040a;

        e(OAlertDialog r1) {
            this.f35040a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35040a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35040a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class f extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35041a;

        f(OAlertDialog r1) {
            this.f35041a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35041a.originDismiss();
        }
    }

    /* JADX INFO: compiled from: OAlertDialog.kt */
    static final class g extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f35042a;

        g(OAlertDialog r1) {
            this.f35042a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35042a.originDismiss();
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$KfTqwUy2VYn7JIYivV5CbzaXLFs(OAlertDialog r0) {
        m1001onStart$lambda9(r0);
    }

    public static /* synthetic */ void lambda$yXPlMElexfjX1OYDAjgjH9BBzrk(OAlertDialog r0) {
        m1002performEnterAnimation$lambda11(r0);
    }

    public /* synthetic */ OAlertDialog(Context r2, boolean r3, boolean r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        this(r7, r3, r4);
    }

    public OAlertDialog(Context r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        super(r8, r6, r7);
        this.TAG = "OAlertDialog";
        this.iconPanel = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.iconPanel, DbHelper.COL_ID, "iconPanel")), FrameLayout.class, "com.obric.aiagent.plugin");
        TextView r9 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.textTitle, DbHelper.COL_ID, "textTitle")), TextView.class, "com.obric.aiagent.plugin");
        OTextView r0 = null;
        if (r9 != null) goto L6;
        r9 = null;
    L12:
        this.titleTextView = r9;
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.textSubTitle, DbHelper.COL_ID, "textSubTitle"));
        TextView r2 = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, OTextView.class) == false) goto L15;
        r0 = (OTextView) ZeusTransformUtils.preCheckCast(r2, OTextView.class, "com.obric.aiagent.plugin");
    L15:
        if (r0 == null) goto L18;
        r0.setEnableAutoAlignLeft(true);
    L18:
        this.messageTextView = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
        this.buttonPanel = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.button_container, DbHelper.COL_ID, "button_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        this.bodyPanel = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.body_container, DbHelper.COL_ID, "body_container")), FrameLayout.class, "com.obric.aiagent.plugin");
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, OTextView.class) == false) goto L8;
        OTextView r3 = (OTextView) ZeusTransformUtils.preCheckCast(r9, OTextView.class, "com.obric.aiagent.plugin");
    L9:
        if (r3 == null) goto L12;
        r3.setEnableAutoAlignLeft(true);
        goto L12
    L8:
        r3 = null;
        goto L9
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int getLayout() {
        return ZeusTransformUtils.mapRes(R.layout.o_alert_dialog, "layout", "o_alert_dialog");
    }

    public final void setTopImageStyleController(com.obric.oui.dialog.alert.d r4) {
        com.obric.oui.dialog.alert.d r5 = (com.obric.oui.dialog.alert.d) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.dialog.alert.d.class, "com.obric.aiagent.plugin");
        o.e(r5, "controller");
        this.iconStyleController = r5;
        FrameLayout r0 = this.iconPanel;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        r5.a(r3, r0);
        return;
    }

    public final void setTitleText(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r4, DBDefinition.TITLE);
        TextView r2 = this.titleTextView;
        if (r2 == null) goto L7;
        r2.setVisibility(0);
        r2.setText(r4);
        r2.setPadding(0, 0, 0, 0);
        return;
    }

    public final void setOnlyTitleText(CharSequence r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        o.e(r6, DBDefinition.TITLE);
        TextView r4 = this.titleTextView;
        if (r4 == null) goto L7;
        r4.setVisibility(0);
        r4.setText(r6);
        r4.setPadding(0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 19), 0, com.obric.oui.common.util.g.a((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"), 19));
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

    public final void setButtonStyleController(com.obric.oui.dialog.alert.d r4) {
        com.obric.oui.dialog.alert.d r5 = (com.obric.oui.dialog.alert.d) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.oui.dialog.alert.d.class, "com.obric.aiagent.plugin");
        o.e(r5, "controller");
        this.buttonStyleController = r5;
        FrameLayout r0 = this.buttonPanel;
        if (r0 == null) goto L7;
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r3, "context");
        r5.a(r3, r0);
        return;
    }

    public final void setBodyStyleController(com.obric.oui.dialog.alert.d r5) {
        com.obric.oui.dialog.alert.d r6 = (com.obric.oui.dialog.alert.d) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.oui.dialog.alert.d.class, "com.obric.aiagent.plugin");
        o.e(r6, "controller");
        this.bodyStyleController = r6;
        FrameLayout r0 = this.bodyPanel;
        if (r0 != null) goto L6;
        return;
    L6:
        if (getMatchParentHeight() == false) goto L8;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = 0;
        r0.setLayoutParams(r2);
    L8:
        r0.setVisibility(0);
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r4, "context");
        r6.a(r4, r0);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r3) {
        if (getHideFirstFrame() == false) goto L5;
        getRootView().setAlpha(0.0f);
    L5:
        super.onCreate(r3);
        com.obric.oui.dialog.alert.d r4 = this.iconStyleController;
        if (r4 == null) goto L9;
        r4.a(this);
    L9:
        com.obric.oui.dialog.alert.d r5 = this.buttonStyleController;
        if (r5 == null) goto L13;
        r5.a(this);
    L13:
        com.obric.oui.dialog.alert.d r6 = this.bodyStyleController;
        if (r6 == null) goto L18;
        r6.a(this);
        return;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        performEnterAnimation();
        if (ZeusTransformUtils.instanceOf(this.buttonStyleController, com.obric.oui.dialog.alert.a.class) == false) goto L5;
        com.obric.oui.dialog.alert.d r0 = this.buttonStyleController;
        Objects.requireNonNull(r0, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        ((com.obric.oui.dialog.alert.a) ZeusTransformUtils.preCheckCast(r0, com.obric.oui.dialog.alert.a.class, "com.obric.aiagent.plugin")).d();
    L5:
        TextView r1 = this.messageTextView;
        if (r1 == null) goto L10;
        r1.postDelayed(new $$Lambda$OAlertDialog$KfTqwUy2VYn7JIYivV5CbzaXLFs(this), 1000);
        return;
    }

    /* JADX INFO: renamed from: onStart$lambda-9, reason: not valid java name */
    private static final void m1001onStart$lambda9(OAlertDialog r2) {
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
        getRootView().post(new $$Lambda$OAlertDialog$yXPlMElexfjX1OYDAjgjH9BBzrk(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-11, reason: not valid java name */
    private static final void m1002performEnterAnimation$lambda11(OAlertDialog r10) {
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
        INVOKESTATIC_com_obric_oui_dialog_alert_OAlertDialog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("OAlertDialog", "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        performExitAnimation();
    }

    public final void cancelCountDown() {
        com.obric.oui.dialog.alert.d r0 = this.buttonStyleController;
        if (r0 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.dialog.alert.a.class) == false) goto L9;
        com.obric.oui.dialog.alert.d r2 = this.buttonStyleController;
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        ((com.obric.oui.dialog.alert.a) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.dialog.alert.a.class, "com.obric.aiagent.plugin")).e();
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

    public final OButton getPositiveButton() {
        com.obric.oui.dialog.alert.d r0 = this.buttonStyleController;
        if (r0 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.dialog.alert.a.class) == false) goto L8;
        com.obric.oui.dialog.alert.d r3 = this.buttonStyleController;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        return ((com.obric.oui.dialog.alert.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.alert.a.class, "com.obric.aiagent.plugin")).a();
    L8:
        return (OButton) ZeusTransformUtils.preCheckCast(null, OButton.class, "com.obric.aiagent.plugin");
    }

    public final OButton getNegativeButton() {
        com.obric.oui.dialog.alert.d r0 = this.buttonStyleController;
        if (r0 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.dialog.alert.a.class) == false) goto L8;
        com.obric.oui.dialog.alert.d r3 = this.buttonStyleController;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        return ((com.obric.oui.dialog.alert.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.alert.a.class, "com.obric.aiagent.plugin")).b();
    L8:
        return (OButton) ZeusTransformUtils.preCheckCast(null, OButton.class, "com.obric.aiagent.plugin");
    }

    public final OButton getNeutralButton() {
        com.obric.oui.dialog.alert.d r0 = this.buttonStyleController;
        if (r0 == null) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, com.obric.oui.dialog.alert.a.class) == false) goto L8;
        com.obric.oui.dialog.alert.d r3 = this.buttonStyleController;
        Objects.requireNonNull(r3, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        return ((com.obric.oui.dialog.alert.a) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.dialog.alert.a.class, "com.obric.aiagent.plugin")).c();
    L8:
        return (OButton) ZeusTransformUtils.preCheckCast(null, OButton.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        adjustContentHeight(r0);
    }

    private final void adjustContentHeight(Context r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        FrameLayout r0 = this.bodyPanel;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() == 0) goto L8;
        return;
    L8:
        if (com.obric.oui.common.util.h.f34570a.a(r15) == false) goto L25;
        int r2 = com.obric.oui.window.a.f36851a.b(r15);     // Catch: Exception -> L19
        if (getWidthMatch() == false) goto L12;
        r2 = r2 - com.obric.oui.common.util.g.a(r15, 16);     // Catch: Exception -> L19
    L12:
        int r3 = getIconPanelVerticalSpace();     // Catch: Exception -> L19
        int r4 = getTitleVerticalSpace();     // Catch: Exception -> L19
        int r5 = getMessageVerticalSpace();     // Catch: Exception -> L19
        int r6 = getButtonVerticalSpace();     // Catch: Exception -> L19
        int r7 = getBodyMarginSpace();     // Catch: Exception -> L19
        int r8 = com.obric.oui.common.util.g.b(r15);     // Catch: Exception -> L19
        int r9 = com.obric.oui.common.util.g.a(r15, 300);     // Catch: Exception -> L19
        int r10 = com.obric.oui.common.util.g.a(r15, AbstractDialog.HORIZONTAL_MAX_WIDTH);     // Catch: Exception -> L19
        if (r8 <= r9) goto L15;
        r9 = r8 - 156;     // Catch: Exception -> L19
    L15:
        int r11 = (((((r9 - r2) - r3) - r4) - r5) - r6) - r7;     // Catch: Exception -> L19
        int r16 = n.a(r11, 0, r9 - com.obric.oui.common.util.g.a(r15, 52));     // Catch: Exception -> L19
        r0.measure(View.MeasureSpec.makeMeasureSpec(r10, Integer.MIN_VALUE), 0);     // Catch: Exception -> L19
        int r12 = r0.getMeasuredHeight();     // Catch: Exception -> L19
        com.obric.oui.d.a.b.b(this.TAG, "adjustContentHeight, maxHeight: " + r9 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r11 + ", measured BodyHeight: " + r12 + ", maxBodyHeight: " + r16 + ", iconPanelVerticalSpace: " + r3 + ", titleVerticalSpace: " + r4 + ", messageVerticalSpace: " + r5 + ", buttonVerticalSpace: " + r6 + ", bodyMarginSpace: " + r7);     // Catch: Exception -> L19
        if (r12 <= r16) goto L26;
        com.obric.oui.d.a.b.c(this.TAG, "adjustContentHeight, from: " + r12 + " to: " + r16);     // Catch: Exception -> L19
        ViewGroup.LayoutParams r13 = r0.getLayoutParams();     // Catch: Exception -> L19
        r13.height = r16;     // Catch: Exception -> L19
        r0.setLayoutParams(r13);     // Catch: Exception -> L19
        return;
    L26:
        return;
    L19:
        e = move-exception;
        com.obric.oui.d.a.b.b(this.TAG, "adjustContentHeight error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final int getIconPanelVerticalSpace() {
        FrameLayout r0 = this.iconPanel;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.a(r0);
        r0.measure(0, 0);
        FrameLayout r2 = this.iconPanel;
        o.a(r2);
        if (r2.getVisibility() != 0) goto L8;
        FrameLayout r3 = this.iconPanel;
        o.a(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.d.c r5 = com.obric.oui.d.c.f35012a;
        FrameLayout r6 = this.iconPanel;
        o.a(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int getTitleVerticalSpace() {
        TextView r0 = this.titleTextView;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.a(r0);
        r0.measure(0, 0);
        TextView r2 = this.titleTextView;
        o.a(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.titleTextView;
        o.a(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.d.c r5 = com.obric.oui.d.c.f35012a;
        TextView r6 = this.titleTextView;
        o.a(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int getMessageVerticalSpace() {
        TextView r0 = this.messageTextView;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.a(r0);
        r0.measure(0, 0);
        TextView r2 = this.messageTextView;
        o.a(r2);
        if (r2.getVisibility() != 0) goto L8;
        TextView r3 = this.messageTextView;
        o.a(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.d.c r5 = com.obric.oui.d.c.f35012a;
        TextView r6 = this.messageTextView;
        o.a(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int getButtonVerticalSpace() {
        FrameLayout r0 = this.buttonPanel;
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        o.a(r0);
        r0.measure(0, 0);
        FrameLayout r2 = this.buttonPanel;
        o.a(r2);
        if (r2.getVisibility() != 0) goto L8;
        FrameLayout r3 = this.buttonPanel;
        o.a(r3);
        int r4 = r3.getMeasuredHeight();
    L9:
        com.obric.oui.d.c r5 = com.obric.oui.d.c.f35012a;
        FrameLayout r6 = this.buttonPanel;
        o.a(r6);
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 != null) goto L13;
    L11:
        r7 = null;
    L14:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r7, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L19;
        r1 = r8.topMargin;
    L19:
        return r4 + r1;
    L13:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.MarginLayoutParams.class) == false) goto L11;
    L8:
        r4 = 0;
        goto L9
    }

    private final int getBodyMarginSpace() {
        if (this.bodyPanel != null) goto L5;
        return 0;
    L5:
        com.obric.oui.d.c r0 = com.obric.oui.d.c.f35012a;
        FrameLayout r3 = this.bodyPanel;
        o.a(r3);
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if (r4 != null) goto L9;
    L7:
        r4 = null;
    L10:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L14;
        return 0;
    L14:
        return r5.topMargin;
    L9:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.MarginLayoutParams.class) == false) goto L7;
        goto L7
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_oui_dialog_alert_OAlertDialog_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
