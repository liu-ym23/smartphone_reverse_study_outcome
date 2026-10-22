package com.bytedance.bdtracker;

import com.bytedance.applog.InitConfig;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class n2 {
    public static final n2 b = new n2();
    public static final Map<InitConfig, Boolean> a = new LinkedHashMap();

    @JvmStatic
    public static final boolean a(InitConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        Boolean bool = a.get(config);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @JvmStatic
    public static final Object b(InitConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        Map<InitConfig, Boolean> map = a;
        Boolean bool = map.get(config);
        if (bool != null) {
            return bool;
        }
        map.put(config, true);
        return Unit.INSTANCE;
    }
}
