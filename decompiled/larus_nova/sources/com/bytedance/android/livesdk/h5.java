package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h5 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h5 f132627a = null;

    static {
        f132627a = new h5();
    }

    public h5() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_dialog_jsb_context", "修复dialog jsb调用context问题", r100, r100, true);
    }
}
