package com.bytedance.android.livesdk.config;

import com.huawei.hms.android.SystemUtils;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class fp extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fp f120221a = null;

    static {
        f120221a = new fp();
    }

    public fp() {
        super("live_drawer_fold_screen_opt_list", "抽屉折叠屏适配白名单", CollectionsKt.mutableListOf(new String[]{SystemUtils.PRODUCT_HUAWEI, SystemUtils.PRODUCT_HONOR, "OPPO", "VIVO"}), CollectionsKt.mutableListOf(new String[]{SystemUtils.PRODUCT_HUAWEI, SystemUtils.PRODUCT_HONOR, "OPPO", "VIVO"}));
    }
}
