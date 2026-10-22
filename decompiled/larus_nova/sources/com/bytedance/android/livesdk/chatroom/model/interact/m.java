package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0005R\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0005R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0017\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u0004\u0018\u00010 8&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u0004\u0018\u00010$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0016R\u0014\u0010+\u001a\u00020\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0016¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/m;", "Lvh7/c;", "", "", "getAccessKey", "()Ljava/lang/String;", "accessKey", "", "isCanJoinChannelDirectly", "()Z", "getRtcAppId", "rtcAppId", "", "getRivalLinkmicId", "()J", "rivalLinkmicId", "getRivalLinkmicIdStr", "rivalLinkmicIdStr", "getRtcAppSign", "rtcAppSign", "", "getVendor", "()I", Constants.OperatorKey.KEY_VENDOR, "Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "getMultiChannelInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/s1;", "multiChannelInfo", "Lcom/bytedance/android/live/liveinteract/plantform/model/h;", "getEarlyJoinChannelData", "()Lcom/bytedance/android/live/liveinteract/plantform/model/h;", "earlyJoinChannelData", "Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "getMultiRtcInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/v1;", "multiRtcInfo", "Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "getMultiLiveCoreInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/u1;", "multiLiveCoreInfo", "getConfluenceType", "confluenceType", "getLinkMicId", "linkMicId", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m extends vh7.c<m> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getAccessKey();

    /* synthetic */ String getAnchorLinkMicIdStr();

    int getConfluenceType();

    com.bytedance.android.live.liveinteract.plantform.model.h getEarlyJoinChannelData();

    int getLinkMicId();

    /* synthetic */ String getLinkMicIdStr();

    /* synthetic */ com.bytedance.android.live.liveinteract.plantform.model.e0 getMcuContent();

    com.bytedance.android.livesdk.link.model.bridge.s1 getMultiChannelInfo();

    com.bytedance.android.livesdk.link.model.bridge.u1 getMultiLiveCoreInfo();

    com.bytedance.android.livesdk.link.model.bridge.v1 getMultiRtcInfo();

    long getRivalLinkmicId();

    String getRivalLinkmicIdStr();

    String getRtcAppId();

    String getRtcAppSign();

    /* synthetic */ String getRtcExtInfo();

    int getVendor();

    boolean isCanJoinChannelDirectly();
}
