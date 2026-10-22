package com.bytedance.android.livesdk.saas.impl.utils;

import com.bytedance.android.live.core.setting.SettingKey;
import kotlin.Metadata;
import ys2.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0005¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/saas/impl/utils/DolphinConfig;", "", "Lcom/bytedance/android/live/core/setting/SettingKey;", "", "LIVE_SAAS_SYNC_FOLLOW_ENABLE", "Lcom/bytedance/android/live/core/setting/SettingKey;", "", "LIVE_SAAS_SYNC_FOLLOW_TIPS", "Lys2/a;", "DEEP_LINK_CONFIG", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DolphinConfig {
    public static final SettingKey<a> DEEP_LINK_CONFIG = null;
    public static final DolphinConfig INSTANCE = null;
    public static final SettingKey<Boolean> LIVE_SAAS_SYNC_FOLLOW_ENABLE = null;
    public static final SettingKey<String> LIVE_SAAS_SYNC_FOLLOW_TIPS = null;

    private DolphinConfig() {
    }

    static {
        INSTANCE = new DolphinConfig();
        Class r100 = Boolean.TYPE;
        Boolean r101 = Boolean.FALSE;
        LIVE_SAAS_SYNC_FOLLOW_ENABLE = new SettingKey("live_saas_sync_follow_enable", r100, "是否开启关注关系同步功能", r101, r101);
        LIVE_SAAS_SYNC_FOLLOW_TIPS = new SettingKey("live_saas_sync_follow_tips", String.class, "关注关系弹窗中的提示文案", "", "");
        DEEP_LINK_CONFIG = new SettingKey("deeplink_config", a.class, "DeepLink 安全配置", new a(), new a());
    }
}
