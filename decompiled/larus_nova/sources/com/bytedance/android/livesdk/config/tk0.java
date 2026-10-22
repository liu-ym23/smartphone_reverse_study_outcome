package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.schema.constants.SchemaHandlerHostConstants;

/* JADX INFO: loaded from: classes8.dex */
public final class tk0 extends SSettingKey<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tk0 f121307a = null;

    static {
        f121307a = new tk0();
    }

    public tk0() {
        super("live_privacy_room_uid_log_prefix", "隐私直播间上报uid埋点前缀", SchemaHandlerHostConstants.WEBCAST_SCHEMA_HOST);
    }
}
