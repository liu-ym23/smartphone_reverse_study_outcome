package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class r4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r4 f156934a = null;

    static {
        f156934a = new r4();
    }

    public r4() {
        Boolean r100 = Boolean.TRUE;
        super("live_comment_enable_add_ai_params", "评论接口是否允许添加端智能参数", r100, r100);
    }
}
