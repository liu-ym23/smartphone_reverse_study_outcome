package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/SubtitleUpdateType;", "", "UNKNOWN", "OPEN_SUBTITLE_SETTING_PANEL", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SubtitleUpdateType extends Enum<SubtitleUpdateType> {
    public static final SubtitleUpdateType OPEN_SUBTITLE_SETTING_PANEL = null;
    public static final SubtitleUpdateType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubtitleUpdateType[] f77083a = null;

    static {
        SubtitleUpdateType r100 = new SubtitleUpdateType("UNKNOWN", 0);
        UNKNOWN = r100;
        SubtitleUpdateType r101 = new SubtitleUpdateType("OPEN_SUBTITLE_SETTING_PANEL", 1);
        OPEN_SUBTITLE_SETTING_PANEL = r101;
        f77083a = new SubtitleUpdateType[]{r100, r101};
    }

    public static SubtitleUpdateType valueOf(String r100) {
        return (SubtitleUpdateType) a.a(SubtitleUpdateType.class, r100);
    }

    public static SubtitleUpdateType[] values() {
        return (SubtitleUpdateType[]) f77083a.clone();
    }

    public SubtitleUpdateType(String r100, int r101) {
        super(r100, r101);
    }
}
