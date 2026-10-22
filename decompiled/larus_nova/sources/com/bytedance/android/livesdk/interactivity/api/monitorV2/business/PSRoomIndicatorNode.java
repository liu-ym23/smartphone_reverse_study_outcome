package com.bytedance.android.livesdk.interactivity.api.monitorV2.business;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/monitorV2/business/PSRoomIndicatorNode;", "", "", "indicatorName", "Ljava/lang/String;", "getIndicatorName", "()Ljava/lang/String;", "PortraitCommentPanelShowDelay", "PortraitLongClickCommentPanelShowDelay", "LandscapeCommentPanelShowDelay", "PortraitAdminDanmakuShowDelay", "PortraitPrivilegeDanmakuShowDelay", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PSRoomIndicatorNode extends Enum<PSRoomIndicatorNode> {
    public static final PSRoomIndicatorNode LandscapeCommentPanelShowDelay = null;
    public static final PSRoomIndicatorNode PortraitAdminDanmakuShowDelay = null;
    public static final PSRoomIndicatorNode PortraitCommentPanelShowDelay = null;
    public static final PSRoomIndicatorNode PortraitLongClickCommentPanelShowDelay = null;
    public static final PSRoomIndicatorNode PortraitPrivilegeDanmakuShowDelay = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PSRoomIndicatorNode[] f133349a = null;
    private final String indicatorName;

    static {
        PSRoomIndicatorNode r100 = new PSRoomIndicatorNode("PortraitCommentPanelShowDelay", 0, "portrait_comment_panel_show_delay");
        PortraitCommentPanelShowDelay = r100;
        PSRoomIndicatorNode r101 = new PSRoomIndicatorNode("PortraitLongClickCommentPanelShowDelay", 1, "portrait_long_click_panel_show_delay");
        PortraitLongClickCommentPanelShowDelay = r101;
        PSRoomIndicatorNode r102 = new PSRoomIndicatorNode("LandscapeCommentPanelShowDelay", 2, "landscape_comment_panel_show_delay");
        LandscapeCommentPanelShowDelay = r102;
        PSRoomIndicatorNode r103 = new PSRoomIndicatorNode("PortraitAdminDanmakuShowDelay", 3, "portrait_admin_danmaku_show_delay");
        PortraitAdminDanmakuShowDelay = r103;
        PSRoomIndicatorNode r104 = new PSRoomIndicatorNode("PortraitPrivilegeDanmakuShowDelay", 4, "portrait_privilege_danmaku_show_delay");
        PortraitPrivilegeDanmakuShowDelay = r104;
        f133349a = new PSRoomIndicatorNode[]{r100, r101, r102, r103, r104};
    }

    public static PSRoomIndicatorNode valueOf(String r100) {
        return (PSRoomIndicatorNode) a.a(PSRoomIndicatorNode.class, r100);
    }

    public static PSRoomIndicatorNode[] values() {
        return (PSRoomIndicatorNode[]) f133349a.clone();
    }

    public final String getIndicatorName() {
        return this.indicatorName;
    }

    public PSRoomIndicatorNode(String r100, int r101, String r102) {
        super(r100, r101);
        this.indicatorName = r102;
    }
}
