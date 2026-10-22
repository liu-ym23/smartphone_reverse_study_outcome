package com.bytedance.android.ec.hybrid.log.mall;

import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.texturerender.VideoSurfaceTexture;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECMallLogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f47441a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f47442b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f47443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f47444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f47445c;

        public a(Map r100, Map r101, String r102) {
            this.f47443a = r100;
            this.f47444b = r101;
            this.f47445c = r102;
        }

        public final void a() {
            String r100 = com.bytedance.android.ec.hybrid.list.util.k.d(this.f47443a);
            String r101 = com.bytedance.android.ec.hybrid.list.util.k.d(this.f47444b);
            Lazy r102 = ECMallLogUtil.f47441a;
            ECMallLogUtil.f(4, d.b.f47466b, "jsbName: " + this.f47445c + ", callParams: " + r100 + ", backStr: " + r101, null, 24);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECMallLogUtil() {
    }

    static {
        f47441a = LazyKt.lazy(ECMallLogUtil$logService$2.INSTANCE);
        f47442b = LazyKt.lazy(ECMallLogUtil$mLogger$2.INSTANCE);
    }

    public static void a(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        ((l) f47442b.getValue()).e(r100, r101);
    }

    public static void b(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        ((l) f47442b.getValue()).d(r100, r101);
    }

    public static void c(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        ((l) f47442b.getValue()).c(r100, r101);
    }

    public static void d(p r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        ((l) f47442b.getValue()).a(r100, r101);
    }

    public static void g(Map r100, Map r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "callMsg");
        Intrinsics.checkNotNullParameter(r101, "backMsg");
        Intrinsics.checkNotNullParameter(r102, "eventName");
        IHybridHostService r103 = com.bytedance.android.ec.hybrid.a.h();
        if (r103 == null) goto L9;
        yj.g r104 = r103.getHostAB();
        if (r104 == null) goto L9;
        Map<String, List<String>> r105 = r104.s();
        if (r105 == null) goto L9;
        List<String> r106 = r105.get(PrefetchTiming.JSB);
    L10:
        if (r106 != null) goto L12;
    L14:
        com.bytedance.android.ec.hybrid.a.i(new a(r100, r101, r102));
        return;
    L12:
        if (r106.contains(r102) == false) goto L14;
        return;
    L9:
        r106 = null;
        goto L10
    }

    public static void h(p r100, Object r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "prefix");
        com.bytedance.android.ec.hybrid.a.i(new j(r101, r102, r100));
    }

    public static void e(int r100, p r101, String r102, Thread r103, String r110) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "message");
        Intrinsics.checkNotNullParameter(r110, VideoSurfaceTexture.KEY_TIME);
        String r104 = r101.scene();
        if (r103 != null) goto L6;
        r103 = ThreadMethodProxy.currentThread();
    L6:
        if (r102.length() <= 3072) goto L17;
        List r105 = StringsKt.chunked(r102, 3072);
        int r106 = r105.size();
        Iterator r107 = r105.iterator();
        int r108 = 0;
    L9:
        if (r107.hasNext() == false) goto L25;
        Object r109 = r107.next();
        int r111 = r108 + 1;
        if (r108 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        String r112 = (String) r109;
        yj.h r113 = (yj.h) f47441a.getValue();
        if (r113 == null) goto L16;
        r113.a(r100, r110 + ' ' + r104 + r103 + "| (" + r111 + '/' + r106 + ") " + r112);
    L16:
        r108 = r111;
        goto L9
    L25:
        return;
    L17:
        yj.h r114 = (yj.h) f47441a.getValue();
        if (r114 == null) goto L24;
        r114.a(r100, r104 + r103 + "| " + r102);
        return;
    }

    public static /* synthetic */ void f(int r100, p r101, String r102, Thread r103, int r104) {
        String r105 = null;
        if ((r104 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r104 & 16) == 0) goto L8;
        r105 = "";
    L8:
        e(r100, r101, r102, r103, r105);
    }
}
