package com.bytedance.android.live.openplatform.api.constant;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "", "ConnectionPanel", "ExplainCard", "ExplainCardButton", "ToolbarDirectMicroApp", "ShelfPageMicroApp", "ShelfPageCard", "ShelfPageCardActionButton", "ShelfPageLinkCast", "liveopenplatform-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MountedMiniAppSource extends Enum<MountedMiniAppSource> {
    public static final MountedMiniAppSource ConnectionPanel = null;
    public static final MountedMiniAppSource ExplainCard = null;
    public static final MountedMiniAppSource ExplainCardButton = null;
    public static final MountedMiniAppSource ShelfPageCard = null;
    public static final MountedMiniAppSource ShelfPageCardActionButton = null;
    public static final MountedMiniAppSource ShelfPageLinkCast = null;
    public static final MountedMiniAppSource ShelfPageMicroApp = null;
    public static final MountedMiniAppSource ToolbarDirectMicroApp = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MountedMiniAppSource[] f83959a = null;

    static {
        MountedMiniAppSource r100 = new MountedMiniAppSource("ConnectionPanel", 0);
        ConnectionPanel = r100;
        MountedMiniAppSource r101 = new MountedMiniAppSource("ExplainCard", 1);
        ExplainCard = r101;
        MountedMiniAppSource r102 = new MountedMiniAppSource("ExplainCardButton", 2);
        ExplainCardButton = r102;
        MountedMiniAppSource r103 = new MountedMiniAppSource("ToolbarDirectMicroApp", 3);
        ToolbarDirectMicroApp = r103;
        MountedMiniAppSource r104 = new MountedMiniAppSource("ShelfPageMicroApp", 4);
        ShelfPageMicroApp = r104;
        MountedMiniAppSource r105 = new MountedMiniAppSource("ShelfPageCard", 5);
        ShelfPageCard = r105;
        MountedMiniAppSource r106 = new MountedMiniAppSource("ShelfPageCardActionButton", 6);
        ShelfPageCardActionButton = r106;
        MountedMiniAppSource r107 = new MountedMiniAppSource("ShelfPageLinkCast", 7);
        ShelfPageLinkCast = r107;
        f83959a = new MountedMiniAppSource[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static MountedMiniAppSource valueOf(String r100) {
        return (MountedMiniAppSource) a.a(MountedMiniAppSource.class, r100);
    }

    public static MountedMiniAppSource[] values() {
        return (MountedMiniAppSource[]) f83959a.clone();
    }

    public MountedMiniAppSource(String r100, int r101) {
        super(r100, r101);
    }
}
