package com.obric.autogui.util.ui;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.graphics.g;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.al;
import androidx.core.view.t;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;
import java.util.List;

/* JADX INFO: compiled from: AutoActionUIHelpers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: compiled from: AutoActionUIHelpers.kt */
    public static final class a extends WindowInsetsAnimationCompat.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f31575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f31576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f31577d;

        /* JADX INFO: renamed from: com.obric.autogui.util.ui.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AutoActionUIHelpers.kt */
        public static final class C0867a implements t {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f31578a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ View f31579b;

            C0867a(a r1, View r2) {
                this.f31578a = r1;
                this.f31579b = r2;
            }

            @Override // androidx.core.view.t
            public al onApplyWindowInsets(View r3, al r4) {
                o.e(r3, "v");
                o.e(r4, "insets");
                g r5 = r4.a(al.m.b());
                o.c(r5, "getInsets(...)");
                g r1 = r4.a(al.m.c());
                o.c(r1, "getInsets(...)");
                a.a(this.f31578a, n.c(r1.f1213e - r5.f1213e, 0));
                ViewCompat.a(this.f31579b, null);
                return r4;
            }
        }

        a(View r1) {
            this.f31575b = r1;
            super(0);
        }

        public static final /* synthetic */ void a(a r0, int r1) {
            r0.a(r1);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public void a(WindowInsetsAnimationCompat r2) {
            o.e(r2, "animation");
            this.f31576c = b();
            this.f31577d = false;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public void b(WindowInsetsAnimationCompat r3) {
            o.e(r3, "animation");
            super.b(r3);
            if (this.f31577d == true) goto L6;
            ViewCompat.a(this.f31575b, (t) ZeusTransformUtils.preCheckCast(new C0867a(this, this.f31575b), t.class, "com.obric.aiagent.plugin"));
            return;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public al a(al r3, List<WindowInsetsAnimationCompat> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "insets");
            o.e(r5, "runningAnimations");
            g r6 = r3.a(al.m.b());
            o.c(r6, "getInsets(...)");
            g r1 = r3.a(al.m.c());
            o.c(r1, "getInsets(...)");
            a(n.c(r1.f1213e - r6.f1213e, 0));
            if (r1.f1213e == 0) goto L5;
            this.f31577d = true;
        L5:
            return r3;
        }

        private final void a(int r4) {
            ViewGroup.LayoutParams r0 = this.f31575b.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r0, ViewGroup.MarginLayoutParams.class) == false) goto L5;
            ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        L6:
            if (r1 == null) goto L8;
            r1.bottomMargin = r4;
        L8:
            this.f31575b.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
            return;
        L5:
            r1 = null;
            goto L6
        }

        private final int b() {
            ViewGroup.LayoutParams r2 = this.f31575b.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r2, ViewGroup.MarginLayoutParams.class) == false) goto L5;
            ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        L6:
            if (r3 != null) goto L10;
            return 0;
        L10:
            return r3.bottomMargin;
        L5:
            r3 = null;
            goto L6
        }
    }

    public static /* synthetic */ void a(Activity r1, boolean r2, Integer r3, Integer r4, int r5, Object r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r1, Activity.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = null;
    L8:
        a(r7, r2, r3, r4);
    }

    public static final void a(Activity r2, boolean r3, Integer r4, Integer r5) {
        Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        o.e(r6, "<this>");
        int r0 = ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin").getDecorView().getSystemUiVisibility();
        if (r3 == false) goto L5;
        int r7 = r0 | 8192;
    L6:
        ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin").getDecorView().setSystemUiVisibility(r7);
        Window r8 = ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin");
        int r1 = 0;
        if (r8 == null) goto L12;
        if (r4 == null) goto L10;
        int r9 = r4.intValue();
    L11:
        r8.setStatusBarColor(r9);
        goto L12
    L10:
        r9 = 0;
    L12:
        Window r10 = ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin");
        if (r10 == null) goto L18;
        if (r5 == null) goto L16;
        r1 = r5.intValue();
    L16:
        r10.setNavigationBarColor(r1);
        return;
    L18:
        return;
    L5:
        r7 = r0 & (-8193);
        goto L6
    }

    public static final void a(Activity r2, boolean r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
        o.e(r4, "<this>");
        int r0 = ZeusTransformUtils.getWindow(r4, "com.obric.aiagent.plugin").getDecorView().getSystemUiVisibility();
        if (r3 == false) goto L5;
        int r5 = ((r0 | 256) | 1024) | 512;
    L6:
        ZeusTransformUtils.getWindow(r4, "com.obric.aiagent.plugin").getDecorView().setSystemUiVisibility(r5);
        return;
    L5:
        r5 = ((r0 & (-257)) & (-1025)) & (-513);
        goto L6
    }

    public static final void a(View r5) {
        o.e(r5, "<this>");
        a r0 = new a(r5);
        Loog.INSTANCE.d(LogUtil.INSTANCE.getCLAZZ_TAG(r5), " - Configured IME insets of view: " + r5);
        ViewCompat.a(r5, (WindowInsetsAnimationCompat.b) ZeusTransformUtils.preCheckCast(r0, WindowInsetsAnimationCompat.b.class, "com.obric.aiagent.plugin"));
    }

    public static final void b(View r1) {
        o.e(r1, "<this>");
        ViewCompat.a(r1, null);
        ViewCompat.a(r1, null);
    }
}
