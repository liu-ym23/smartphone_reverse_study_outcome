package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class i4 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i4 f132641a = null;

    static {
        f132641a = new i4();
    }

    public i4() {
        super("live_anchor_preset_template_panel_list", "美颜预设模板影响的面板列表", CollectionsKt.listOf(new String[]{"livebeauty", "makeupforever", "livefilter", "livebody", "live_adjustment"}), CollectionsKt.listOf(new String[]{"livebeauty", "makeupforever", "livefilter", "livebody", "live_adjustment"}));
    }
}
