package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f2.k;
import f4.x;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f35954a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f35955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f35956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final s4.a.C7565a f35957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f35958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f35959e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35960f;

        public final Activity getActivity() {
            return this.f35955a;
        }

        public a(Activity r100, Context r101, boolean r102, s4.a.C7565a r103, double r104, int r105, int r106) {
            Intrinsics.checkNotNullParameter(r101, "baseContext");
            Intrinsics.checkNotNullParameter(r103, "screenSizeInfo");
            this.f35955a = r100;
            this.f35956b = r102;
            this.f35957c = r103;
            this.f35958d = r104;
            this.f35959e = r105;
            this.f35960f = r106;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35964d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f35965e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35966f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f35961a == r101.f35961a) goto L12;
            return false;
        L12:
            if (this.f35962b == r101.f35962b) goto L15;
            return false;
        L15:
            if (this.f35963c == r101.f35963c) goto L18;
            return false;
        L18:
            if (this.f35964d == r101.f35964d) goto L21;
            return false;
        L21:
            if (this.f35965e == r101.f35965e) goto L24;
            return false;
        L24:
            if (this.f35966f == r101.f35966f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f35961a * 31) + this.f35962b) * 31) + this.f35963c) * 31) + this.f35964d) * 31) + this.f35965e) * 31) + this.f35966f;
        }

        public final String toString() {
            return "SafeAreaInfo(left=" + this.f35961a + ", right=" + this.f35962b + ", top=" + this.f35963c + ", bottom=" + this.f35964d + ", width=" + this.f35965e + ", height=" + this.f35966f + ')';
        }

        public b(int r100, int r101, int r102, int r103, int r104, int r105) {
            this.f35961a = r100;
            this.f35962b = r101;
            this.f35963c = r102;
            this.f35964d = r103;
            this.f35965e = r104;
            this.f35966f = r105;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.system.c$c, reason: collision with other inner class name */
    public static final class C0701c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f35967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f35971e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35972f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final b f35973g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f35974h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C0701c) == true) goto L8;
            return false;
        L8:
            C0701c r101 = (C0701c) r100;
            if (Double.compare(this.f35967a, r101.f35967a) == 0) goto L12;
            return false;
        L12:
            if (this.f35968b == r101.f35968b) goto L15;
            return false;
        L15:
            if (this.f35969c == r101.f35969c) goto L18;
            return false;
        L18:
            if (this.f35970d == r101.f35970d) goto L21;
            return false;
        L21:
            if (this.f35971e == r101.f35971e) goto L24;
            return false;
        L24:
            if (this.f35972f == r101.f35972f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f35973g, r101.f35973g) == true) goto L30;
            return false;
        L30:
            if (this.f35974h == r101.f35974h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r100 = Double.doubleToLongBits(this.f35967a);
            return (((((((((((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f35968b) * 31) + this.f35969c) * 31) + this.f35970d) * 31) + this.f35971e) * 31) + this.f35972f) * 31) + this.f35973g.hashCode()) * 31) + this.f35974h;
        }

        public final String toString() {
            return "WindowInfo(pixelRatio=" + this.f35967a + ", screenWidth=" + this.f35968b + ", screenHeight=" + this.f35969c + ", windowWidth=" + this.f35970d + ", windowHeight=" + this.f35971e + ", statusBarHeight=" + this.f35972f + ", safeArea=" + this.f35973g + ", screenTop=" + this.f35974h + ')';
        }

        public C0701c(double r100, int r101, int r102, int r103, int r104, int r105, b r106, int r110) {
            Intrinsics.checkNotNullParameter(r106, "safeArea");
            this.f35967a = r100;
            this.f35968b = r101;
            this.f35969c = r102;
            this.f35970d = r103;
            this.f35971e = r104;
            this.f35972f = r105;
            this.f35973g = r106;
            this.f35974h = r110;
        }
    }

    static {
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static C0701c d(Context r110) {
        a r111 = e(r110);
        if (r111 != null) goto L6;
        return null;
    L6:
        boolean r100 = false;
        if (r111.getActivity() == null) goto L9;
        Rect r101 = new Rect();
        a(r111.getActivity().getWindow()).getWindowVisibleDisplayFrame(r101);
    L10:
        int r102 = d.f35975a;
        s4.a.C7565a r103 = r111.f35957c;
        int r104 = r103.f540519b;
        int r105 = r103.f540520c;
        int r106 = r111.f35959e;
        if (r111.getActivity() != null) goto L13;
    L15:
        Rect r107 = d.d(r101, r104, r105, r106, r100);
        return b(r111, r107, d.b(r111.f35957c.f540522e, r111.f35960f, r107, r111.f35958d, r111.f35956b));
    L13:
        if (a(r111.getActivity().getWindow()).getHeight() != 0) goto L15;
        r100 = true;
        goto L15
    L9:
        int r108 = r111.f35959e;
        s4.a.C7565a r109 = r111.f35957c;
        r101 = new Rect(0, r108, r109.f540519b, r109.f540520c);
        goto L10
    }

    public static a e(Context r110) {
        int r100 = s4.a.f540517a;
        Context r101 = r110;
    L4:
        if (r101 == null) goto L11;
        if ((r101 instanceof Activity) == true) goto L7;
        if ((r101 instanceof ContextWrapper) == false) goto L11;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L4
    L7:
        Activity r102 = (Activity) r101;
    L12:
        if (r102 != null) goto L24;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r103 = AppletRuntimeManager.f36749d;
        if (r103 == null) goto L16;
        r102 = r103.currentActivity();
    L17:
        if (r102 != null) goto L24;
        g2.b r104 = AppletRuntimeManager.f36749d;
        if (r104 == null) goto L21;
        r102 = r104.O();
    L22:
        if (r102 != null) goto L24;
        r102 = k.b();
        goto L24
    L21:
        r102 = null;
        goto L22
    L16:
        r102 = null;
    L24:
        Activity r105 = r102;
        if (r105 == null) goto L27;
        Context r106 = r105;
    L33:
        if (r106.getResources().getConfiguration().orientation != 2) goto L35;
        boolean r107 = true;
    L36:
        s4.a.C7565a r108 = s4.a.a(r106);
        double r109 = r108.f540518a;
        int r111 = s4.a.b(r106, true);
        return new a(r105, r106, r107, r108, r109, r111, s4.a.c(r111, r109));
    L35:
        r107 = false;
        goto L36
    L27:
        if (r110 != null) goto L31;
        r110 = k.a();
        if (r110 != null) goto L31;
        return null;
    L31:
        r106 = r110;
    L11:
        r102 = null;
        goto L12
    }

    public static void c(Context r110, final Function1 r111) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        final a r112 = e(r110);
        if (r112 != null) goto L6;
        r111.invoke(null);
        return;
    L6:
        int r100 = d.f35975a;
        Activity r101 = r112.getActivity();
        s4.a.C7565a r102 = r112.f35957c;
        d.c(r101, r102.f540519b, r102.f540520c, r102.f540522e, r112.f35958d, r112.f35960f, r112.f35959e, r112.f35956b, true, new x(r111, r112));
    }

    public static C0701c b(a r210, Rect r211, d.a r212) {
        int r100 = d.f35975a;
        s4.a.C7565a r101 = r210.f35957c;
        int r102 = r101.f540521d;
        int r103 = r101.f540522e;
        Intrinsics.checkNotNullParameter(r212, "safeAreaInsets");
        int r104 = r212.f35978c;
        int r105 = r102 - r212.f35979d;
        int r106 = r212.f35976a;
        int r107 = r103 - r212.f35977b;
        int r108 = RangesKt.coerceIn(r104, 0, r102);
        int r110 = RangesKt.coerceIn(r106, 0, r103);
        int r111 = RangesKt.coerceIn(r105, r108, r102);
        int r112 = RangesKt.coerceIn(r107, r110, r103);
        int r113 = RangesKt.coerceAtLeast(r111 - r108, 0);
        int r114 = RangesKt.coerceAtLeast(r112 - r110, 0);
        double r109 = r210.f35958d;
        s4.a.C7565a r115 = r210.f35957c;
        int r116 = r115.f540521d;
        int r117 = r115.f540522e;
        int r118 = s4.a.f540517a;
        return new C0701c(r109, r116, r117, s4.a.c(RangesKt.coerceAtLeast(r211.width(), 0), r210.f35958d), s4.a.c(RangesKt.coerceAtLeast(r211.height(), 0), r210.f35958d), r210.f35960f, new b(r108, r111, r110, r112, r113, r114), s4.a.c(RangesKt.coerceAtLeast(r211.top, 0), r210.f35958d));
    }
}
