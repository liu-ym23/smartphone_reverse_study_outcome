package com.bytedance.android.livesdk.interactivity.service.richcontent.resourceloader;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieTask;
import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h implements hk6.a<ob2.e> {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // hk6.a
    public final void a(ek6.b r100, ak6.f r101, ek6.d r102, hk6.d r103) {
        ob2.e r104 = (ob2.e) r100;
        Intrinsics.checkNotNullParameter(r104, "resourceInfo");
        Intrinsics.checkNotNullParameter(r101, "loadConfig");
        Intrinsics.checkNotNullParameter(r102, "content");
        Intrinsics.checkNotNullParameter(r103, "callback");
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.info("LiveLottieResourceLoader, load lottie resource " + r104);     // Catch: Exception -> L5
        LottieTask<LottieComposition> r105 = LottieCompositionFactory.fromAsset(s1.getContext(), r104.f522599a);     // Catch: Exception -> L5
        r105.addListener(new i(this, r102, r104, r103));     // Catch: Exception -> L5
        r105.addFailureListener(new j(r104, r103));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        com.bytedance.android.livesdk.interactivity.service.richcontent.config.a.f140958a.error("LiveLottieResourceLoader, load lottie resource error " + r104, e);
        r103.a("load error", e);
    }
}
