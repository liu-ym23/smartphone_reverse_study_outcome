package com.bytedance.android.livesdk.gift.platform.core.utils;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f132020a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f132021b = null;

    static {
        f132020a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(b.class, "DSAssetShowTimes", "getDSAssetShowTimes()Ljava/util/Set;", 1))};
        f132021b = SpongePreferenceManager.a().a("ds_asset_show_times", SetsKt.emptySet(), ql3.a.I);
    }
}
