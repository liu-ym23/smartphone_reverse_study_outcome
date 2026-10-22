package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.browser.jsbridge.newmethods.k4;
import com.bytedance.android.live.browser.jsbridge.newmethods.q4;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class t0 implements t2, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f131743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vy0.c f131744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a f131745c;

    public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f131746a = null;

        static {
            f131746a = new a();
        }

        public a() {
        }

        @Override // com.bytedance.ies.web.jsbridge2.f.b
        public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
            return new com.bytedance.android.livesdk.gift.platform.core.ui.configuration.f();
        }
    }

    public static final class b implements wy0.f {

        public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f131747a = null;

            static {
                f131747a = new a();
            }

            public a() {
            }

            @Override // com.bytedance.ies.web.jsbridge2.f.b
            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.browser.jsbridge.newmethods.q2();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.gift.platform.core.scope.service.t0$b$b, reason: collision with other inner class name */
        public static final class C2086b implements com.bytedance.ies.web.jsbridge2.f.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C2086b f131748a = null;

            static {
                f131748a = new C2086b();
            }

            public C2086b() {
            }

            @Override // com.bytedance.ies.web.jsbridge2.f.b
            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.browser.jsbridge.newmethods.u3();
            }
        }

        public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f131749a = null;

            static {
                f131749a = new c();
            }

            public c() {
            }

            @Override // com.bytedance.ies.web.jsbridge2.f.b
            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new q4();
            }
        }

        public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f131750a = null;

            static {
                f131750a = new d();
            }

            public d() {
            }

            @Override // com.bytedance.ies.web.jsbridge2.f.b
            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new k4();
            }
        }

        public b() {
        }

        @Override // wy0.f
        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("downloadGiftAsset", a.f131747a), TuplesKt.to("getAssetsPath", C2086b.f131748a), TuplesKt.to("getGiftExtraData", c.f131749a), TuplesKt.to("getDownloadGiftAssets", d.f131750a)});
        }

        @Override // wy0.d
        public final Map<String, wy0.h<Object, ?>> c(y6.c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            return wy0.f.a.a(r100);
        }

        @Override // wy0.f
        public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> d(y6.c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            Intrinsics.checkNotNullParameter(r100, "manager");
            return MapsKt.emptyMap();
        }

        @Override // wy0.d
        public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            return wy0.f.a.b(r100);
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.t2
    public final void g0() {
        this.f131743a.add(this.f131744b.O3(new b()));
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f131745c.registerMethod("revenue.requestStickerEffectStatus", a.f131746a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131743a.clear();
    }

    public t0(vy0.c r100, com.bytedance.android.live.revenue.platform.hybrid.api.shareview.a r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridService");
        Intrinsics.checkNotNullParameter(r101, "shareViewService");
        this.f131744b = r100;
        this.f131745c = r101;
        this.f131743a = new CompositeDisposable();
    }
}
