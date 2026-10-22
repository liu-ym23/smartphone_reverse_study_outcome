package com.bytedance.android.live.openplatform.api.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniGameSource;", "", "Toolbar", "ExplainCard", "Detail", "GameLiveBtn", "Lottery", "InteractPanel", "LiveRoomBussiness", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MountedMiniGameSource extends Enum<MountedMiniGameSource> {
    public static final MountedMiniGameSource Detail = null;
    public static final MountedMiniGameSource ExplainCard = null;
    public static final MountedMiniGameSource GameLiveBtn = null;
    public static final MountedMiniGameSource InteractPanel = null;
    public static final MountedMiniGameSource LiveRoomBussiness = null;
    public static final MountedMiniGameSource Lottery = null;
    public static final MountedMiniGameSource Toolbar = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MountedMiniGameSource[] f83960a = null;

    static {
        MountedMiniGameSource r100 = new MountedMiniGameSource("Toolbar", 0);
        Toolbar = r100;
        MountedMiniGameSource r101 = new MountedMiniGameSource("ExplainCard", 1);
        ExplainCard = r101;
        MountedMiniGameSource r102 = new MountedMiniGameSource("Detail", 2);
        Detail = r102;
        MountedMiniGameSource r103 = new MountedMiniGameSource("GameLiveBtn", 3);
        GameLiveBtn = r103;
        MountedMiniGameSource r104 = new MountedMiniGameSource("Lottery", 4);
        Lottery = r104;
        MountedMiniGameSource r105 = new MountedMiniGameSource("InteractPanel", 5);
        InteractPanel = r105;
        MountedMiniGameSource r106 = new MountedMiniGameSource("LiveRoomBussiness", 6);
        LiveRoomBussiness = r106;
        f83960a = new MountedMiniGameSource[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static MountedMiniGameSource valueOf(String r100) {
        return (MountedMiniGameSource) a.a(MountedMiniGameSource.class, r100);
    }

    public static MountedMiniGameSource[] values() {
        return (MountedMiniGameSource[]) f83960a.clone();
    }

    public MountedMiniGameSource(String r100, int r101) {
        super(r100, r101);
    }
}
