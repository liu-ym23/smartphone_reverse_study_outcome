package com.bytedance.android.annie.scheme.helper;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
public final class LiveSchemaUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f39807a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f39808b = null;

    static {
        f39807a = LazyKt.lazy(LiveSchemaUtil$fixScheme$2.INSTANCE);
        f39808b = LazyKt.lazy(LiveSchemaUtil$enableSchemePerformance$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        if (((Boolean) f39807a.getValue()).booleanValue() == false) goto L7;
        if (((Boolean) f39808b.getValue()).booleanValue() == false) goto L7;
    L8:
        return true;
    L7:
        if (AnnieConfigSettingKeys.ENABLE_OPTIMIZE_SCHEMA_PERFORMANCE.a().booleanValue() == true) goto L8;
        return false;
    }
}
