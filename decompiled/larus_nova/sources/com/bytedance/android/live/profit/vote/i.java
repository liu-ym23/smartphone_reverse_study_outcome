package com.bytedance.android.live.profit.vote;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f89207a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f89208b = null;

    static {
        f89207a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(i.class, "IS_KTV_VOTE_RED_DOT_SHOWN", "getIS_KTV_VOTE_RED_DOT_SHOWN()Z", 1))};
        f89208b = SpongePreferenceManager.a().a("is_ktv_vote_red_dot_shown", Boolean.FALSE, Boolean.TYPE);
    }
}
