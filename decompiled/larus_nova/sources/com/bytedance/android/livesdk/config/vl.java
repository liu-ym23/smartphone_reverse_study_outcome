package com.bytedance.android.livesdk.config;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class vl extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vl f121460a = null;

    static {
        f121460a = new vl();
    }

    public vl() {
        super("live_common_enter_params_support_list", "直播通用进房传参支持传递keyList", new ArrayList(), new ArrayList());
    }
}
