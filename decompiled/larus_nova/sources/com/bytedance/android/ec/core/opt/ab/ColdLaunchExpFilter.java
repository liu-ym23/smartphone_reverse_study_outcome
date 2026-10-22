package com.bytedance.android.ec.core.opt.ab;

import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import java.util.HashSet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes43.dex */
public final class ColdLaunchExpFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f45201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f45202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f45203c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f45204d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ColdLaunchExpFilter f45205e = null;

    static {
        f45201a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ColdLaunchExpFilter.class, FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY, "getConfigs()Ljava/util/HashSet;", 0))};
        f45205e = new ColdLaunchExpFilter();
        f45203c = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ColdLaunchExpFilter$enable$2.INSTANCE);
        HashSet r100 = new HashSet();
        ColdLaunchExpFilter$configs$2 r101 = ColdLaunchExpFilter$configs$2.INSTANCE;
        KProperty[] r102 = h.f45230a;
        LazyHostSettingsKt$lazyOptHostSettingsOrNull$3 r103 = new LazyHostSettingsKt$lazyOptHostSettingsOrNull$3(null);
        Intrinsics.checkNotNullParameter("ec_exp_whitelist_filter_cold_launch_config", "configKey");
        Intrinsics.checkNotNullParameter(r100, "defaultConfig");
        Intrinsics.checkNotNullParameter(r101, "isEnable");
        Intrinsics.checkNotNullParameter(r103, "onConfigReady");
        f45204d = h.b("ec_exp_whitelist_filter_cold_launch_config", r100, null, r101, r103);
    }

    public ColdLaunchExpFilter() {
    }

    public static boolean a() {
        return ((Boolean) f45203c.getValue()).booleanValue();
    }

    public final boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (a() == true) goto L5;
        return false;
    L5:
        if ((!Intrinsics.areEqual(r100, "ec_exp_whitelist_filter_cold_launch_config")) == true) goto L7;
        return false;
    L7:
        if (f45202b == true) goto L16;
        HashSet r101 = (HashSet) f45204d.getValue(this, f45201a[0]);
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r101.contains(r100) != true) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    }
}
