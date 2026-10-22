package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class v4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v4 f159242a = null;

    static {
        f159242a = new v4();
    }

    public v4() {
        Boolean r100 = Boolean.TRUE;
        super("live_comment_widget_enable_layout_listener", "评论组件使用layoutListener监听布局变化", r100, r100);
    }
}
