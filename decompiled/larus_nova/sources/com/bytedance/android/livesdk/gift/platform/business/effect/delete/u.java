package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, Long> f129313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, Long> f129314b;

    public u(LinkedHashMap<String, Long> r100, LinkedHashMap<String, Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "blackDownloadList");
        Intrinsics.checkNotNullParameter(r101, "whiteDeleteList");
        this.f129313a = r100;
        this.f129314b = r101;
    }
}
