package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f125376a = null;

    static {
        f125376a = new g();
    }

    public g() {
        Boolean r100 = Boolean.FALSE;
        super("enable_dislike_in_feed", "是否开启对外feed长按dislike", r100, r100);
    }
}
