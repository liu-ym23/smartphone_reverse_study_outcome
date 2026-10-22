package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class sf extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sf f121223a = null;

    static {
        f121223a = new sf();
    }

    public sf() {
        super("live_av_privacy_detect_special_page", "音视频隐私权限检查需要检查的特殊页面", new ArrayList(), new ArrayList());
    }
}
