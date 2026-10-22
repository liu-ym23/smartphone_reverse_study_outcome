package com.bytedance.android.shopping.new_cart.utils;

import android.graphics.Rect;
import android.os.Looper;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.AccessibilityUtil$setAccessibilityDelegate$1;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bg3.a f179357a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f179358b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f179359c = null;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.utils.a$a, reason: collision with other inner class name */
    public static final class C2668a implements com.bytedance.android.ec.core.utils.a.InterfaceC0810a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f179360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f179361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f179362c;

        @Override // com.bytedance.android.ec.core.utils.a.InterfaceC0810a
        public final void a(AccessibilityNodeInfoCompat r100) {
            if (r100 == null) goto L4;
            r100.setClassName(this.f179360a);
        L4:
            if (r100 == null) goto L6;
            r100.setContentDescription(this.f179361b);
        L6:
            if (r100 == null) goto L9;
            r100.setHeading(this.f179362c);
            return;
        }

        public C2668a(String r100, String r101, boolean r102) {
            this.f179360a = r100;
            this.f179361b = r101;
            this.f179362c = r102;
        }
    }

    public a() {
    }

    static {
        f179359c = new a();
        f179357a = new bg3.a();
        f179358b = new d(Looper.getMainLooper());
        new Rect();
    }

    public static void f(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r100.run();
        return;
    L5:
        f179358b.post(r100);
    }

    public static void b(String r100, String r101) {
        Map<? extends String, ? extends Object> r102 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "newSourceType");
        Intrinsics.checkNotNullParameter(r102, "extra");
        bg3.a r103 = f179357a;
        Map<String, ? extends Object> r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "write"), TuplesKt.to("result", r100), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r101), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI)});
        r104.putAll(r102);
        Unit r105 = Unit.INSTANCE;
        r103.a("cart_cache_operate", r104, null, null);
    }

    @Deprecated(message = "会内存泄露，不要用了")
    public static void e(long r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L5;
    L7:
        f179358b.postDelayed(r101, r100);
        return;
    L5:
        if (r100 != 0) goto L7;
        r101.run();
    }

    public final void d(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "errorType");
        Intrinsics.checkNotNullParameter(r101, "task");
        c(null, r100, r101, null);
    }

    public static void a(String r100, String r101, String r102) {
        Map<? extends String, ? extends Object> r103 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "renderNewSourceType");
        Intrinsics.checkNotNullParameter(r102, "cachedNewSourceType");
        Intrinsics.checkNotNullParameter(r103, "extra");
        bg3.a r104 = f179357a;
        Map<String, ? extends Object> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "read"), TuplesKt.to("result", r100), TuplesKt.to("reader_new_source_type", r101), TuplesKt.to("cached_new_source_type", r102), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI)});
        r105.putAll(r103);
        Unit r106 = Unit.INSTANCE;
        r104.a("cart_cache_operate", r105, null, null);
    }

    public static void c(CartViewModel r100, String r101, Runnable r102, Runnable r103) {
        Intrinsics.checkNotNullParameter(r101, "errorType");
        Intrinsics.checkNotNullParameter(r102, "task");
        r102.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        if (r103 == null) goto L8;
        r103.run();
    L8:
        if (r100 == null) goto L10;
        g(r100, r101, th.getMessage(), MapsKt.emptyMap());
        return;
    L10:
        String r104 = th.getMessage();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        j(r101, r104, null, 4);
    }

    public static void g(CartViewModel r100, String r101, String r102, Map r110) {
        Intrinsics.checkNotNullParameter(r100, "cartVM");
        Intrinsics.checkNotNullParameter(r110, "params");
        Map r103 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("error_type", r101), TuplesKt.to("error_message", r102)});
        r103.putAll(r110);
        Unit r104 = Unit.INSTANCE;
        CartViewModel.doEventAction$default(r100, "yata_cart_monitor", r103, null, 4, null);
    }

    public static void h(View r100, @AccessibilityType String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$setAccessibilityInfo");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "content");
        C2668a r104 = new C2668a(com.bytedance.android.ec.core.utils.a.b(r101), r102, r103);
        if (r100 == null) goto L7;
        ViewCompat.setAccessibilityDelegate(r100, new AccessibilityUtil$setAccessibilityDelegate$1(r104));
        return;
    }

    public static void i(String r100, String r101, Map r102, PageFinder r103) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        Intrinsics.checkNotNullParameter(r102, "extra");
        bg3.a r104 = f179357a;
        Map<String, ? extends Object> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("error_type", r100), TuplesKt.to("error_message", r101)});
        r105.putAll(r102);
        Unit r106 = Unit.INSTANCE;
        r104.a("yata_cart_monitor", r105, r103, null);
    }

    public static /* synthetic */ void j(String r100, String r101, PageFinder r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        Map r104 = MapsKt.emptyMap();
    L7:
        if ((r103 & 8) == 0) goto L9;
        r102 = null;
    L9:
        i(r100, r101, r104, r102);
        return;
    L5:
        r104 = null;
        goto L7
    }
}
