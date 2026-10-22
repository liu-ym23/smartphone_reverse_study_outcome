package com.bytedance.android.live.profit.fansclub;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f87291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f87292b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f87293c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f87294d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f87295e = null;

    static {
        f87291a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "LIVE_JOIN_FANS_CLUB_INCENTIVE_ANIM", "getLIVE_JOIN_FANS_CLUB_INCENTIVE_ANIM()Ljava/util/HashMap;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "FANS_CLUB_GUIDE_LAST_DATE", "getFANS_CLUB_GUIDE_LAST_DATE()J", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "FANS_CLUB_GUIDE_ANCHOR_LIST", "getFANS_CLUB_GUIDE_ANCHOR_LIST()Ljava/util/List;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(f.class, "LIVE_FANS_GROUP_PANEL_HAS_OPENED_UID", "getLIVE_FANS_GROUP_PANEL_HAS_OPENED_UID()Ljava/util/List;", 1))};
        f87292b = SpongePreferenceManager.a().a("live_join_fans_club_incentive_anim", new HashMap(), sl3.a.f542452b);
        f87293c = SpongePreferenceManager.a().a("fans_club_guide_last_date", 0L, Long.TYPE);
        f87294d = SpongePreferenceManager.a().a("fans_club_guide_anchor_list", new ArrayList(), sl3.a.f542455e);
        f87295e = SpongePreferenceManager.a().a("live_fans_group_panel_has_opened_uid", new ArrayList(), sl3.a.f542454d);
    }
}
