package com.bytedance.android.live.revenue.platform.hybrid.api.shareview;

import com.bytedance.android.livesdk.gift.platform.core.scope.service.t0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f91403a;

    public static final class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.ies.web.jsbridge2.f.b f91404b;

        public a() {
            t0.a r100 = t0.a.f131746a;
            Intrinsics.checkNotNullParameter("revenue.requestStickerEffectStatus", "name");
            Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
            this.f91404b = r100;
        }
    }

    public static final class b extends e {
    }

    public e() {
        this.f91403a = "revenue.requestStickerEffectStatus";
    }
}
