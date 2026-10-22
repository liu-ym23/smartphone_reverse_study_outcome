package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class r9 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r9 f121113a = null;

    static {
        f121113a = new r9();
    }

    public r9() {
        super("ttlive_activity_enter_room_report_access_list", "上报schema进房授权list", new ArrayList(), new ArrayList());
    }
}
