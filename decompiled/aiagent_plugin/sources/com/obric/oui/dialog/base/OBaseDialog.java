package com.obric.oui.dialog.base;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import com.obric.oui.button.OButton;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.x;

/* JADX INFO: compiled from: OBaseDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class OBaseDialog extends AbstractDialog {
    public static final b Companion = null;
    private static final String TAG = "BaseDialog";
    private boolean isDismissing;
    private boolean useNewDialogAnim;

    /* JADX INFO: compiled from: OBaseDialog.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f35091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d.h.a.a<x> f35092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d.h.a.b<OButton, x> f35093c;

        public a(String r3, d.h.a.a<x> r4, d.h.a.b<? super OButton, x> r5) {
            d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.b<OButton, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r3, "text");
            this.f35091a = r3;
            this.f35092b = r6;
            this.f35093c = r7;
        }

        public /* synthetic */ a(String r2, d.h.a.a r3, d.h.a.b r4, int r5, h r6) {
            d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            d.h.a.b r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r8 = null;
        L5:
            this(r2, r7, r8);
        }

        public final String a() {
            return this.f35091a;
        }

        public final d.h.a.a<x> b() {
            return this.f35092b;
        }

        public final d.h.a.b<OButton, x> c() {
            return this.f35093c;
        }
    }

    /* JADX INFO: compiled from: OBaseDialog.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: OBaseDialog.kt */
    static final class c extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseDialog f35094a;

        c(OBaseDialog r1) {
            this.f35094a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35094a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35094a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OBaseDialog.kt */
    static final class d extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseDialog f35095a;

        d(OBaseDialog r1) {
            this.f35095a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r3) {
            o.e(r3, "it");
            DialogInterface.OnShowListener r4 = this.f35095a.getCompleteShowListener();
            if (r4 == null) goto L7;
            r4.onShow((DialogInterface) ZeusTransformUtils.preCheckCast(this.f35095a, DialogInterface.class, "com.obric.aiagent.plugin"));
            return;
        }
    }

    /* JADX INFO: compiled from: OBaseDialog.kt */
    static final class e extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseDialog f35096a;

        e(OBaseDialog r1) {
            this.f35096a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35096a.originDismiss();
        }
    }

    /* JADX INFO: compiled from: OBaseDialog.kt */
    static final class f extends p implements d.h.a.b<com.obric.oui.animation.a.b<View>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OBaseDialog f35097a;

        f(OBaseDialog r1) {
            this.f35097a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(com.obric.oui.animation.a.b<View> r3) {
            a((com.obric.oui.animation.a.b) ZeusTransformUtils.preCheckCast(r3, com.obric.oui.animation.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(com.obric.oui.animation.a.b<View> r2) {
            o.e(r2, "it");
            this.f35097a.originDismiss();
        }
    }

    static {
        Companion = new b(null);
    }

    public static /* synthetic */ void lambda$qgHI4QevAF3s02sJ4oQs8VZAX6g(OBaseDialog r0) {
        m1029performEnterAnimation$lambda1(r0);
    }

    public OBaseDialog(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        super(r4, false, false);
        this.useNewDialogAnim = true;
    }

    public final boolean getUseNewDialogAnim() {
        return this.useNewDialogAnim;
    }

    public final void setUseNewDialogAnim(boolean r1) {
        this.useNewDialogAnim = r1;
    }

    public final boolean isDismissing() {
        return this.isDismissing;
    }

    public final void setDismissing(boolean r1) {
        this.isDismissing = r1;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.isDismissing = false;
        performEnterAnimation();
    }

    public final void performExitAnimation() {
        com.obric.oui.animation.a.b<View> r0 = com.obric.oui.dialog.a.a.f35019a.a(getRootView(), getWindow(), !getAdaptWindowDim(), this.useNewDialogAnim);
        com.obric.oui.animation.a.b.a(r0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new e(this), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
        r0.b();
    }

    public final void performEnterAnimation() {
        getRootView().post(new $$Lambda$OBaseDialog$qgHI4QevAF3s02sJ4oQs8VZAX6g(this));
    }

    /* JADX INFO: renamed from: performEnterAnimation$lambda-1, reason: not valid java name */
    private static final void m1029performEnterAnimation$lambda1(OBaseDialog r8) {
        o.e(r8, "this$0");
        com.obric.oui.dialog.a.a r1 = com.obric.oui.dialog.a.a.f35019a;
        View r2 = r8.getRootView();
        Window r3 = r8.getWindow();
        boolean r4 = !r8.getAdaptWindowDim();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "context");
        com.obric.oui.animation.a.b.a(r1.a(r2, r3, r4, r8.getTargetWindowDimAmount(r0), r8.useNewDialogAnim).b(), null, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r8), d.h.a.b.class, "com.obric.aiagent.plugin"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r8), d.h.a.b.class, "com.obric.aiagent.plugin"), 1, null);
    }

    public void originDismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.oui.d.a.b.b(TAG, "origin Dismiss exception!", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.isDismissing == false) goto L6;
        com.obric.oui.d.a.b.b(TAG, "dismiss() called but dialog is already dismissing, ignore.");
        return;
    L6:
        this.isDismissing = true;
        performExitAnimation();
    }
}
