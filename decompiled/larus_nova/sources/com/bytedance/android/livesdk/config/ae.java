package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.live.model.AnnouncementInstructionInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class ae extends SSettingKey<List<? extends AnnouncementInstructionInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ae f119781a = null;

    static {
        f119781a = new ae();
    }

    public ae() {
        super("live_announcement_examples", "公告说明页", CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }
}
