package com.bytedance.android.livesdkapi.depend.message;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.model.LinkerBaseInfo;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.q;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class RoomLinkMicSyncData extends FlexModelBase<IRoomLinkMicSyncData> implements IRoomLinkMicSyncData {
    public static final String SYNC_KEY = "RoomLinkMicSyncData";

    @SerializedName("client_ui_info")
    public ClientUIInfo clientUIInfo;

    @SerializedName("linker_base_info")
    public LinkerBaseInfo linkerBaseInfo;

    @SerializedName("linker_content_map")
    public Map<Long, RoomLinkerContent> linkerContentMap;

    @SerializedName("locked_positions")
    public List<LinkmicPositionItem> lockedPositions;

    @SerializedName("linked_users")
    public List<k> mLinkUsers;

    @SerializedName("positions")
    public List<LinkmicPositionItem> positions;

    public RoomLinkMicSyncData() {
        super(IRoomLinkMicSyncData.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData
    public /* bridge */ /* synthetic */ q getLinkerBaseInfo() {
        return getLinkerBaseInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData
    public ClientUIInfo getClientUIInfo() {
        return this.clientUIInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData
    public Map<Long, g2> getLinkerContentMap() {
        return this.linkerContentMap;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData
    public List<LinkmicPositionItem> getLockedPositions() {
        return this.lockedPositions;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData
    public List<k> getMLinkUsers() {
        return this.mLinkUsers;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData
    public List<LinkmicPositionItem> getPositions() {
        return this.positions;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.IRoomLinkMicSyncData
    public LinkerBaseInfo getLinkerBaseInfo() {
        return this.linkerBaseInfo;
    }

    public void setClientUIInfo(ClientUIInfo r100) {
        this.clientUIInfo = r100;
    }
}
