package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class q2 extends SSettingKey<List<? extends Integer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q2 f65390a = null;

    public q2() {
        super("live_multi_link_adjust_player_sei_ver_black_list", "多人场景调整布局seiVer黑名单", CollectionsKt.arrayListOf(new Integer[]{14, 19}), CollectionsKt.arrayListOf(new Integer[]{14, 19}));
    }

    static {
        f65390a = new q2();
    }
}
