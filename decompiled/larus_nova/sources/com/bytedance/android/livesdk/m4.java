package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveAudiencePanelConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class m4 extends SettingKey<LiveAudiencePanelConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m4 f153487a = null;

    static {
        f153487a = new m4();
    }

    public m4() {
        super("live_message_list_float_sheet_config", "观众侧操作面板配置项", new LiveAudiencePanelConfig(), new LiveAudiencePanelConfig());
    }
}
