package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class SessionSettingUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f170344a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f170345b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f170346c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f170347d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f170348e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f170349f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f170350g = null;

    static {
        f170344a = new Gson();
        f170345b = LazyKt.lazy(SessionSettingUtil$deliveryExtractRule$2.INSTANCE);
        f170346c = LazyKt.lazy(SessionSettingUtil$defaultAddParams$2.INSTANCE);
        f170347d = LazyKt.lazy(SessionSettingUtil$stageConfigSetting$2.INSTANCE);
        f170348e = LazyKt.lazy(SessionSettingUtil$useGeneralApi$2.INSTANCE);
        f170349f = LazyKt.lazy(SessionSettingUtil$deliveryActionReportSetting$2.INSTANCE);
        f170350g = LazyKt.lazy(SessionSettingUtil$stageMappingSetting$2.INSTANCE);
    }
}
