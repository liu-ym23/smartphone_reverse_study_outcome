package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class q extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f121019a = null;

    static {
        f121019a = new q();
    }

    public q() {
        super("live_mseq_audience_enter_last_liveroom", "麦序房最后一个节目结束是否进入主播房间", Boolean.FALSE, Boolean.TRUE);
    }
}
