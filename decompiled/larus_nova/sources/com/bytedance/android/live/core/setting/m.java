package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class m extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f65354a = null;

    static {
        f65354a = new m();
    }

    public m() {
        super("live_anchor_more_dialog_show_list_in_play_together", "在一起玩场景下，主播侧更多面板中可展示的 toolbar button", CollectionsKt.mutableListOf(new String[]{"BROADCAST_GIFT", "BROADCAST_ADMIN", "MANAGE"}), CollectionsKt.mutableListOf(new String[]{"BROADCAST_GIFT", "BROADCAST_ADMIN", "MANAGE"}));
    }
}
