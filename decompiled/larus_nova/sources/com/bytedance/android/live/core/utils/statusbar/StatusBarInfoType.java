package com.bytedance.android.live.core.utils.statusbar;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/core/utils/statusbar/StatusBarInfoType;", "", "STATUSBAR_HEIGHT", "HIDE_STATUSBAR", "STE_STATUSBAR_HEIGHT", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StatusBarInfoType extends Enum<StatusBarInfoType> {
    public static final StatusBarInfoType HIDE_STATUSBAR = null;
    public static final StatusBarInfoType STATUSBAR_HEIGHT = null;
    public static final StatusBarInfoType STE_STATUSBAR_HEIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StatusBarInfoType[] f66399a = null;

    static {
        StatusBarInfoType r100 = new StatusBarInfoType("STATUSBAR_HEIGHT", 0);
        STATUSBAR_HEIGHT = r100;
        StatusBarInfoType r101 = new StatusBarInfoType("HIDE_STATUSBAR", 1);
        HIDE_STATUSBAR = r101;
        StatusBarInfoType r102 = new StatusBarInfoType("STE_STATUSBAR_HEIGHT", 2);
        STE_STATUSBAR_HEIGHT = r102;
        f66399a = new StatusBarInfoType[]{r100, r101, r102};
    }

    public static StatusBarInfoType valueOf(String r100) {
        return (StatusBarInfoType) r27.a.a(StatusBarInfoType.class, r100);
    }

    public static StatusBarInfoType[] values() {
        return (StatusBarInfoType[]) f66399a.clone();
    }

    public StatusBarInfoType(String r100, int r101) {
        super(r100, r101);
    }
}
