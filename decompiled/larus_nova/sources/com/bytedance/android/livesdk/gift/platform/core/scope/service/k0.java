package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f131612a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a f131613b = null;

    static {
        f131612a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(k0.class, "LAST_SEND_CONFIRM_IDS", "getLAST_SEND_CONFIRM_IDS()Ljava/util/Set;", 1))};
        f131613b = SpongePreferenceManager.a().a("last_send_confirm_ids", new LinkedHashSet(), ql3.a.f533750j);
    }
}
