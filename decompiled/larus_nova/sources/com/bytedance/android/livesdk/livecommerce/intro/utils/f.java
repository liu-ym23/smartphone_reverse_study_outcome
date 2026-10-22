package com.bytedance.android.livesdk.livecommerce.intro.utils;

import android.content.Context;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntro;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.LiveIntroResponse;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f148525j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f148526k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f148527l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f148528m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap<String, f> f148529n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f148530o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f148531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f148532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f148533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveIntroResponse f148534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f148535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f148536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Function1<? super LiveIntroResponse, Unit> f148537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f148538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<Context> f148539i;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.intro.utils.f$a$a, reason: collision with other inner class name */
        public static final class C2301a extends BaseRequestListener {
            public C2301a() {
            }

            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
            public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
                super.onRequestSuccess(r100, r101, r102);
                OptCardUtil.b("image", "prefetch success");
            }

            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
            public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
                super.onRequestStart(r100, r101, r102, r103);
                OptCardUtil.b("image", "prefetch start");
            }
        }

        public static final class b extends BaseRequestListener {
            public b() {
            }

            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
            public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
                super.onRequestSuccess(r100, r101, r102);
                OptCardUtil.b("image", "up prefetch success");
            }

            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
            public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
                super.onRequestStart(r100, r101, r102, r103);
                OptCardUtil.b("image", "up prefetch start");
            }
        }

        public a() {
        }

        public static void a(LiveIntroResponse r110) {
            Intrinsics.checkNotNullParameter(r110, "liveIntroResp");
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L38
            List<LiveIntro> r111 = r110.getIntros();     // Catch: Throwable -> L38
            if (r111 == null) goto L35;
            Iterator<T> r112 = r111.iterator();     // Catch: Throwable -> L38
        L7:
            if (r112.hasNext() == false) goto L34;
            LiveIntro r101 = (LiveIntro) r112.next();     // Catch: Throwable -> L38
            if (r101.c() != 1) goto L7;
            t0 r102 = r101.d();     // Catch: Throwable -> L38
            if (r102 == null) goto L18;
            u r103 = r102.i();     // Catch: Throwable -> L38
            if (r103 == null) goto L18;
            String r104 = r103.c();     // Catch: Throwable -> L38
            if (r104 == null) goto L18;
            int r105 = r.f44937h;     // Catch: Throwable -> L38
            ImageExtensionsKt.B(r104, r.a.b("ec_live_intro_card_image"), null, null, Priority.IMMEDIATE, new C2301a(), null, false, 192);     // Catch: Throwable -> L38
        L18:
            t0 r106 = r101.d();     // Catch: Throwable -> L38
            if (r106 == null) goto L7;
            u r107 = r106.i();     // Catch: Throwable -> L38
            if (r107 == null) goto L7;
            List<t> r108 = r107.d();     // Catch: Throwable -> L38
            if (r108 == null) goto L7;
            Iterator<T> r109 = r108.iterator();     // Catch: Throwable -> L38
        L26:
            if (r109.hasNext() == false) goto L7;
            t1 r113 = ((t) r109.next()).c();     // Catch: Throwable -> L38
            if (r113 == null) goto L26;
            List<String> r114 = r113.b();     // Catch: Throwable -> L38
            if (r114 == null) goto L26;
            String r115 = (String) CollectionsKt.firstOrNull(r114);     // Catch: Throwable -> L38
            if (r115 == null) goto L26;
            int r116 = r.f44937h;     // Catch: Throwable -> L38
            ImageExtensionsKt.B(r115, r.a.b("ec_live_intro_card_upper_left_image"), null, null, Priority.IMMEDIATE, new b(), null, false, 192);     // Catch: Throwable -> L38
            goto L26
        L34:
            Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L38
        L36:
            Result.m9449constructorimpl(r117);     // Catch: Throwable -> L38
            return;
        L35:
            r117 = null;
        L38:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    public f() {
    }

    static {
        f148530o = new a();
        boolean r100 = false;
        if (EComABUtils.cardLoadOptV3Api() != 1) goto L5;
        boolean r101 = true;
    L6:
        f148525j = r101;
        if (EComABUtils.cardLoadOptV3Layout() != 1) goto L9;
        boolean r102 = true;
    L10:
        f148526k = r102;
        if (EComABUtils.cardLoadOptV3Event() != 1) goto L13;
        boolean r103 = true;
    L14:
        f148527l = r103;
        if (EComABUtils.cardLoadOptV3Image() != 1) goto L17;
        r100 = true;
    L17:
        f148528m = r100;
        f148529n = new HashMap();
        return;
    L13:
        r103 = false;
        goto L14
    L9:
        r102 = false;
        goto L10
    L5:
        r101 = false;
        goto L6
    }

    public final WeakReference<Context> getContext() {
        return this.f148539i;
    }
}
