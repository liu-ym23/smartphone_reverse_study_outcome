package com.bytedance.android.livesdk.downloader;

import com.bytedance.android.livesdk.gift.configmodel.z;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.GiftResourceManager;
import com.bytedance.kmp.livesdk.gift.platform.resourcemanager.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class GiftResourceManagerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f122285a = null;

    static {
        f122285a = LazyKt.lazy(GiftResourceManagerFactory$downloaderManagerTypeOpt$2.INSTANCE);
    }

    public static e a() {
        if (((z) f122285a.getValue()).getEnable() == true) goto L5;
        GiftResourceManager r100 = GiftResourceManager.f252386h;
        if (r100 == null) goto L11;
        Intrinsics.checkNotNull(r100);
        return r100;
    L11:
        throw new IllegalStateException("GiftResourceManager is not initialized");
    L5:
        return NewGiftResourceManager.f122286m;
    }
}
