package com.bytedance.android.livesdkapi.depend.message.wrds;

import com.bytedance.android.live.liveinteract.wrds.RoomLinkmicMicDisplayInfoSyncData;
import com.bytedance.android.livesdk.chatroom.model.interact.RoomLinkMicAnchorSettings;
import com.bytedance.android.livesdk.ktvimpl.multichorus.model.KtvMultiChorusSyncData;
import com.bytedance.android.livesdk.message.model.kd;
import com.bytedance.android.livesdk.message.model.pb;
import com.bytedance.android.livesdkapi.depend.message.IOrderSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.KtvDressSyncData;
import com.bytedance.android.livesdkapi.depend.message.KtvStreamSingSyncData;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/wrds/MultiPreviewSyncDataType;", "", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/IPreviewSyncDataType;", "syncKey", "", "dataClass", "Ljava/lang/Class;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Class;)V", "getDataClass", "()Ljava/lang/Class;", "getSyncKey", "()Ljava/lang/String;", "ROOM_LINK_MIC_SYNC_DATA", "KTV_STREAM_SING_SYNC_DATA", "KTV_MULTI_CHORUS_SYNC_DATA", "KTV_CHORUS_MESSAGE_SYNC_DATA", "KTV_DRESS_SYNC_DATA", "ORDER_SING_SYNC_DATA", "ROOM_LINK_MIC_MIC_DISPLAY_INFO_SYNC_DATA", "ROOM_LINK_MIC_ANCHOR_SETTINGS_SYNC_DATA", "ROOM_LINK_MIC_PROFIT_EGG_SYNC_DATA", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiPreviewSyncDataType extends Enum<MultiPreviewSyncDataType> implements IPreviewSyncDataType {
    private static final /* synthetic */ MultiPreviewSyncDataType[] $VALUES = null;
    public static final MultiPreviewSyncDataType KTV_CHORUS_MESSAGE_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType KTV_DRESS_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType KTV_MULTI_CHORUS_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType KTV_STREAM_SING_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType ORDER_SING_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType ROOM_LINK_MIC_ANCHOR_SETTINGS_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType ROOM_LINK_MIC_MIC_DISPLAY_INFO_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType ROOM_LINK_MIC_PROFIT_EGG_SYNC_DATA = null;
    public static final MultiPreviewSyncDataType ROOM_LINK_MIC_SYNC_DATA = null;
    private final Class<?> dataClass;
    private final String syncKey;

    public static MultiPreviewSyncDataType valueOf(String r100) {
        return (MultiPreviewSyncDataType) a.a(MultiPreviewSyncDataType.class, r100);
    }

    public static MultiPreviewSyncDataType[] values() {
        return (MultiPreviewSyncDataType[]) $VALUES.clone();
    }

    static {
        MultiPreviewSyncDataType r100 = new MultiPreviewSyncDataType("ROOM_LINK_MIC_SYNC_DATA", 0, RoomLinkMicSyncData.SYNC_KEY, RoomLinkMicSyncData.class);
        ROOM_LINK_MIC_SYNC_DATA = r100;
        MultiPreviewSyncDataType r101 = new MultiPreviewSyncDataType("KTV_STREAM_SING_SYNC_DATA", 1, KtvStreamSingSyncData.SYNC_KEY, KtvStreamSingSyncData.class);
        KTV_STREAM_SING_SYNC_DATA = r101;
        MultiPreviewSyncDataType r102 = new MultiPreviewSyncDataType("KTV_MULTI_CHORUS_SYNC_DATA", 2, KtvMultiChorusSyncData.SYNC_KEY, KtvMultiChorusSyncData.class);
        KTV_MULTI_CHORUS_SYNC_DATA = r102;
        MultiPreviewSyncDataType r103 = new MultiPreviewSyncDataType("KTV_CHORUS_MESSAGE_SYNC_DATA", 3, "WebcastKtvChorusMessage", kd.class);
        KTV_CHORUS_MESSAGE_SYNC_DATA = r103;
        MultiPreviewSyncDataType r104 = new MultiPreviewSyncDataType("KTV_DRESS_SYNC_DATA", 4, KtvDressSyncData.SYNC_KEY, KtvDressSyncData.class);
        KTV_DRESS_SYNC_DATA = r104;
        MultiPreviewSyncDataType r105 = new MultiPreviewSyncDataType("ORDER_SING_SYNC_DATA", 5, "OrderSingSyncData", IOrderSingSyncData.class);
        ORDER_SING_SYNC_DATA = r105;
        MultiPreviewSyncDataType r106 = new MultiPreviewSyncDataType("ROOM_LINK_MIC_MIC_DISPLAY_INFO_SYNC_DATA", 6, "RoomLinkmicMicDisplayInfoSyncData", RoomLinkmicMicDisplayInfoSyncData.class);
        ROOM_LINK_MIC_MIC_DISPLAY_INFO_SYNC_DATA = r106;
        MultiPreviewSyncDataType r107 = new MultiPreviewSyncDataType("ROOM_LINK_MIC_ANCHOR_SETTINGS_SYNC_DATA", 7, "RoomLinkMicAnchorSettingsSyncData", RoomLinkMicAnchorSettings.class);
        ROOM_LINK_MIC_ANCHOR_SETTINGS_SYNC_DATA = r107;
        MultiPreviewSyncDataType r108 = new MultiPreviewSyncDataType("ROOM_LINK_MIC_PROFIT_EGG_SYNC_DATA", 8, "RoomLinkMicProfitEggSyncData", pb.class);
        ROOM_LINK_MIC_PROFIT_EGG_SYNC_DATA = r108;
        $VALUES = new MultiPreviewSyncDataType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType
    public Class<?> getDataClass() {
        return this.dataClass;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType
    public String getSyncKey() {
        return this.syncKey;
    }

    private MultiPreviewSyncDataType(String r100, int r101, String r102, Class r103) {
        super(r100, r101);
        this.syncKey = r102;
        this.dataClass = r103;
    }
}
