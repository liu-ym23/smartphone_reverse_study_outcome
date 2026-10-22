package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new;

import android.net.Uri;
import com.bytedance.android.live.revenue.core.util.f;
import kotlin.jvm.internal.Intrinsics;
import vy0.c;

/* JADX INFO: loaded from: classes9.dex */
public final class l implements k<Uri> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f128252a;

    public l() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final void clear() {
        this.f128252a = null;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final GiftPreloadResType a() {
        return GiftPreloadResType.ICON_ANIMATOR_URI;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final void b(h r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        this.f128252a = ((c) f.a(c.class)).Q("/gift/ttlive_gift_icon_rare_effect.webp");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final boolean c(h r100) {
        Intrinsics.checkNotNullParameter(r100, "trigger");
        if ((r100 instanceof h.f) == false) goto L6;
        return false;
    L6:
        if (this.f128252a != null) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v3.preload.p006new.k
    public final Uri d(f r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        return this.f128252a;
    }
}
