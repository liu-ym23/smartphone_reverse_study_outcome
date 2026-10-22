package com.bytedance.android.goldboxentrance.saas.firstguide;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f58154a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f58155b = null;

    static {
        f58154a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(a.class, "LIVE_NEW_GOLD_BOX_FIRST_GUIDE", "getLIVE_NEW_GOLD_BOX_FIRST_GUIDE()Z", 1))};
        f58155b = SpongePreferenceManager.a().a("live_gold_box_container_first_guide", Boolean.FALSE, Boolean.TYPE);
    }
}
