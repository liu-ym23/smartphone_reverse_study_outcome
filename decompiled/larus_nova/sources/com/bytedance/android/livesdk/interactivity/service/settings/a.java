package com.bytedance.android.livesdk.interactivity.service.settings;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends SettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f140989a = null;

    static {
        f140989a = new a();
    }

    public a() {
        Float r100 = Float.valueOf(1.0f);
        super("live_giant_gift_resouce_size", "上报大型礼物资源的大小阈值(MB)", r100, r100);
    }
}
