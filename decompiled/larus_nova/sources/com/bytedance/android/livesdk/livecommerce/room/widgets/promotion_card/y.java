package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.content.Context;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.promotion.ECUISmallPopCard;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class y {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f152722j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f152723k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f152724l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f152725m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap<String, y> f152726n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f152727o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f152728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f152729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f152730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ECUIPromotion f152731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f152732e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f152733f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Function1<? super ECUIPromotion, Unit> f152734g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f152735h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference<Context> f152736i;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y$a$a, reason: collision with other inner class name */
        public static final class C2351a extends BaseRequestListener {
            public C2351a() {
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
                OptCardUtil.b("image", "botton prefetch success");
            }

            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
            public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
                super.onRequestStart(r100, r101, r102, r103);
                OptCardUtil.b("image", "botton prefetch start");
            }
        }

        public static final class c extends BaseRequestListener {
            public c() {
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

        public static final class d extends BaseRequestListener {
            public d() {
            }

            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
            public final void onRequestSuccess(ImageRequest r100, String r101, boolean r102) {
                super.onRequestSuccess(r100, r101, r102);
                OptCardUtil.b("image", "activity prefetch success");
            }

            @Override // com.facebook.imagepipeline.listener.BaseRequestListener, com.facebook.imagepipeline.listener.RequestListener
            public final void onRequestStart(ImageRequest r100, Object r101, String r102, boolean r103) {
                super.onRequestStart(r100, r101, r102, r103);
                OptCardUtil.b("image", "activity prefetch start");
            }
        }

        public a() {
        }

        public static y a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "roomId");
            HashMap<String, y> r101 = y.f152726n;
            y r102 = r101.get(r100);
            if (r102 != null) goto L6;
            y r103 = new y();
            y.f152727o.getClass();
            r101.put(r100, r103);
            return r103;
        L6:
            return r102;
        }

        public static void b(ECUIPromotion r110) {
            Intrinsics.checkNotNullParameter(r110, "promotion");
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L14
            String r101 = r110.imageUrl;     // Catch: Throwable -> L14
            int r102 = com.bytedance.android.ec.core.imagex.r.f44937h;     // Catch: Throwable -> L14
            com.bytedance.android.ec.core.imagex.r r103 = com.bytedance.android.ec.core.imagex.r.a.b("goods_card_view");     // Catch: Throwable -> L14
            Priority r104 = Priority.IMMEDIATE;     // Catch: Throwable -> L14
            ImageExtensionsKt.B(r101, r103, null, null, r104, new C2351a(), null, false, 192);     // Catch: Throwable -> L14
            y.f152727o.getClass();     // Catch: Throwable -> L14
            if (y.f152725m == true) goto L6;
            return;
        L6:
            ImageExtensionsKt.B(r110.normalBottonIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_botton_normal_view"), null, null, r104, new b(), null, false, 192);     // Catch: Throwable -> L14
            ImageExtensionsKt.B(r110.qIvIcon, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_up_view"), null, null, r104, new c(), null, false, 192);     // Catch: Throwable -> L14
            ECUISmallPopCard r111 = r110.smallPopCard;     // Catch: Throwable -> L14
            if (r111 == null) goto L11;
            String r105 = r111.backgroundImgNew;     // Catch: Throwable -> L14
            if (r105 == null) goto L11;
            ImageExtensionsKt.B(r105, com.bytedance.android.ec.core.imagex.r.a.b("goods_card_activity_view"), null, null, r104, new d(), null, false, 192);     // Catch: Throwable -> L14
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L14
        L12:
            Result.m9449constructorimpl(r112);     // Catch: Throwable -> L14
            return;
        L11:
            r112 = null;
        L14:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        }
    }

    public y() {
    }

    static {
        f152727o = new a();
        boolean r100 = false;
        if (EComABUtils.cardLoadOptV3Api() != 1) goto L5;
        boolean r101 = true;
    L6:
        f152722j = r101;
        if (EComABUtils.cardLoadOptV3Layout() != 1) goto L9;
        boolean r102 = true;
    L10:
        f152723k = r102;
        if (EComABUtils.cardLoadOptV3Event() != 1) goto L13;
        boolean r103 = true;
    L14:
        f152724l = r103;
        if (EComABUtils.cardLoadOptV3Image() != 1) goto L17;
        r100 = true;
    L17:
        f152725m = r100;
        f152726n = new HashMap();
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
        return this.f152736i;
    }
}
