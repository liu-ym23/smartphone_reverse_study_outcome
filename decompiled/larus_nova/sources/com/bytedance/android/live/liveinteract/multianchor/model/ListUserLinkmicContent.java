package com.bytedance.android.live.liveinteract.multianchor.model;

import com.bytedance.android.livesdk.link.model.bridge.m1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.EventConstants;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ListUserLinkmicContent extends FlexModelBase<m1> implements m1 {

    @SerializedName("anchor_auth_role")
    public int anchorAuthRole;

    @SerializedName("host_back_color")
    public String hostLabelBackgroundColor;

    @SerializedName("host_name")
    public String hostLabelName;

    @SerializedName("host_name_color")
    public String hostLabelNameColor;

    @SerializedName("host_switch")
    public boolean hostSwitch;

    @SerializedName("live_room_mode")
    public long liveRoomMode;

    @SerializedName("anchor_linkmic_id_info")
    public AnchorLinkMicIdInfo mAnchorLinkMicIdInfo;

    @SerializedName(EventConstants.ExtraJson.GAME_NAME)
    public String mGameName;

    @SerializedName("resource_id")
    public long resourceId;

    @SerializedName("pk_user_role")
    public int role;

    @SerializedName("virtual_tool")
    public String virtualTool;

    public static final enum AnchorAuthRole extends Enum<AnchorAuthRole> {
        public static final AnchorAuthRole AnchorAuthRoleGeneral = null;
        public static final AnchorAuthRole AnchorAuthRoleOrganizer = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AnchorAuthRole[] f75466a = null;

        static {
            AnchorAuthRole r100 = new AnchorAuthRole("AnchorAuthRoleGeneral", 0);
            AnchorAuthRoleGeneral = r100;
            AnchorAuthRole r101 = new AnchorAuthRole("AnchorAuthRoleOrganizer", 1);
            AnchorAuthRoleOrganizer = r101;
            f75466a = new AnchorAuthRole[]{r100, r101};
        }

        public static AnchorAuthRole[] values() {
            return (AnchorAuthRole[]) f75466a.clone();
        }

        public static AnchorAuthRole valueOf(String r100) {
            return (AnchorAuthRole) r27.a.a(AnchorAuthRole.class, r100);
        }

        public AnchorAuthRole(String r100, int r101) {
            super(r100, r101);
        }
    }

    public ListUserLinkmicContent() {
        super(m1.class);
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public int getAnchorAuthRole() {
        return this.anchorAuthRole;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public com.bytedance.android.livesdk.link.model.bridge.j getAnchorLinkMicIdInfo() {
        return this.mAnchorLinkMicIdInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public String getGameName() {
        return this.mGameName;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public String getHostLabelBackgroundColor() {
        return this.hostLabelBackgroundColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public String getHostLabelName() {
        return this.hostLabelName;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public String getHostLabelNameColor() {
        return this.hostLabelNameColor;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public boolean getHostSwitch() {
        return this.hostSwitch;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public long getLiveRoomMode() {
        return this.liveRoomMode;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.m1
    public String getVirtualTool() {
        return this.virtualTool;
    }
}
