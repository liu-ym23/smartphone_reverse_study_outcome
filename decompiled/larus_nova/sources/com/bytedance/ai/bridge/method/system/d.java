package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import f4.a0;
import f4.b0;
import f4.c0;
import f4.y;
import f4.z;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f35975a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35979d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f35976a == r101.f35976a) goto L12;
            return false;
        L12:
            if (this.f35977b == r101.f35977b) goto L15;
            return false;
        L15:
            if (this.f35978c == r101.f35978c) goto L18;
            return false;
        L18:
            if (this.f35979d == r101.f35979d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f35976a * 31) + this.f35977b) * 31) + this.f35978c) * 31) + this.f35979d;
        }

        public final String toString() {
            return "SafeAreaInsets(marginTop=" + this.f35976a + ", marginBottom=" + this.f35977b + ", marginLeft=" + this.f35978c + ", marginRight=" + this.f35979d + ')';
        }

        public a(int r100, int r101, int r102, int r103) {
            this.f35976a = r100;
            this.f35977b = r101;
            this.f35978c = r102;
            this.f35979d = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f35980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f35981b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f35980a, r101.f35980a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f35981b, r101.f35981b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f35980a.hashCode() * 31) + this.f35981b.hashCode();
        }

        public final String toString() {
            return "WindowSafeAreaInfo(windowRectPx=" + this.f35980a + ", safeAreaInsets=" + this.f35981b + ')';
        }

        public b(Rect r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "windowRectPx");
            Intrinsics.checkNotNullParameter(r101, "safeAreaInsets");
            this.f35980a = r100;
            this.f35981b = r101;
        }
    }

    static {
    }

    public d() {
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

    public static a b(int r100, int r101, Rect r102, double r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "windowRectPx");
        int r105 = s4.a.f540517a;
        int r106 = Math.max(r100 - s4.a.c(RangesKt.coerceAtLeast(r102.bottom, 0), r103), 0);
        if (r104 == false) goto L6;
        return new a(0, 0, r101, r106);
    L6:
        return new a(r101, r106, 0, 0);
    }

    public static Rect d(Rect r100, int r101, int r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "rawRect");
        Rect r105 = new Rect(r100);
        if (r105.right > r105.left) goto L5;
        r105.right = r101;
    L5:
        int r106 = r105.bottom;
        int r107 = r105.top;
        if (r106 > r107) goto L8;
        r105.bottom = r102;
    L8:
        if (r104 == false) goto L11;
        if (r107 != 0) goto L11;
        r105.top = r107 + r103;
        r105.bottom = RangesKt.coerceAtMost(r105.bottom + r103, r102);
    L11:
        r105.left = RangesKt.coerceIn(r105.left, 0, r101);
        r105.top = RangesKt.coerceIn(r105.top, 0, r102);
        r105.right = RangesKt.coerceIn(r105.right, r105.left, r101);
        r105.bottom = RangesKt.coerceIn(r105.bottom, r105.top, r102);
        return r105;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [f4.y] */
    /* JADX WARN: Type inference failed for: r2v3, types: [f4.z] */
    /* JADX WARN: Type inference failed for: r3v5, types: [f4.a0, java.lang.Runnable] */
    public static void c(final Activity r110, final int r111, final int r210, final int r211, final double r212, final int r213, final int r214, final boolean r215, boolean r216, final Function1 r217) {
        Intrinsics.checkNotNullParameter(r217, "callback");
        if (r110 != null) goto L7;
        if (r216 == true) goto L6;
        r217.invoke(null);
        return;
    L6:
        Rect r100 = d(new Rect(0, r214, r111, r210), r111, r210, r214, false);
        r217.invoke(new b(r100, b(r211, r213, r100, r212, r215)));
        return;
    L7:
        final ?? r112 = new y(r111, r210, r214, r110, r217, r211, r213, r212, r215);
        final View r101 = a(r110.getWindow());
        int r102 = Build.VERSION.SDK_INT;
        boolean r103 = true;
        if (r102 < 30) goto L14;
        WindowInsets r104 = a(r110.getWindow()).getRootWindowInsets();
        if (r104 != null) goto L12;
    L17:
        r103 = false;
    L19:
        if (r102 < 30) goto L24;
        final AtomicBoolean r105 = new AtomicBoolean(false);
        final ?? r106 = new z(r101, r112);
        if (r103 == true) goto L23;
        r106.invoke();
        return;
    L23:
        ?? r107 = new a0(r105, r106);
        r101.setWindowInsetsAnimationCallback(new c0(r105, r101, r107, r106));
        r101.postDelayed(r107, 300 + ((long) 50));
        return;
    L24:
        Rect r108 = new Rect();
        r101.getWindowVisibleDisplayFrame(r108);
        if (r103 == true) goto L27;
        r112.invoke(r108);
        return;
    L27:
        r101.postDelayed(new b0(r101, r112), 300);
        return;
    L12:
        if (r104.isVisible(WindowInsets.Type.ime()) != true) goto L17;
    L14:
        View r109 = a(r110.getWindow());
        Rect r113 = new Rect();
        r109.getWindowVisibleDisplayFrame(r113);
        int r114 = r109.getHeight();
        if ((r114 - r113.bottom) <= (((double) r114) * 0.15d)) goto L17;
        goto L17
    }
}
