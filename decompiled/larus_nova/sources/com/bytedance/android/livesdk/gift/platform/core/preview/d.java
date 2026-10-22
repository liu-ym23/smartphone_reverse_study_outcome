package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.AssetsService;
import com.bytedance.android.scope.o;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements dy0.c, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetsService f130989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.revenue.service.effect.c f130990b;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f130991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f130992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f130993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ long f130994d;

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void b(boolean r100) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onProgress(int r100) {
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void a(long r100) {
            this.f130992b.invoke();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "t");
            this.f130992b.invoke();
        }

        @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
        public final void c(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "path");
            this.f130992b.invoke();
            d r102 = this.f130991a;
            long r103 = this.f130993c;
            long r104 = this.f130994d;
            yp2.c r105 = r102.f130990b.Hk(new e(r102, r104, r103));
            r102.f130990b.nm(r105, "_Interact_preview", null);
        }

        public b(d r100, Function0 r101, long r102, long r103) {
            this.f130991a = r100;
            this.f130992b = r101;
            this.f130993c = r102;
            this.f130994d = r103;
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final void a() {
        this.f130990b.D8();
    }

    public d(AssetsService r100, com.bytedance.android.livesdk.revenue.service.effect.c r101) {
        Intrinsics.checkNotNullParameter(r100, "assertService");
        Intrinsics.checkNotNullParameter(r101, "effectService");
        this.f130989a = r100;
        this.f130990b = r101;
    }

    public final void f(long r100, long r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r111, "endCallback");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        ((IGiftService) k.n(IGiftService.class)).initGiftResourceManager(s1.getContext());     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        b r102 = new b(this, r111, r100, r110);
        if (this.f130989a.G1(r100) != null) goto L10;
        r111.invoke();
        ALogger.e("InteractGiftPreviewService", "assertModel is null");
        return;
    L10:
        this.f130989a.j4(r100, r102, 1005);
        return;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
