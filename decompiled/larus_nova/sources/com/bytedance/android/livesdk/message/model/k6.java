package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u00032\u00020\u00042\u00020\u0005R\u001c\u0010\u000b\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001c8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR(\u0010%\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010+\u001a\u0004\u0018\u00010&8&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0014\u0010.\u001a\u00020!8&X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0018¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/k6;", "Lvh7/c;", "Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "Lgm2/d;", "", "", "getAssetId", "()J", "setAssetId", "(J)V", "assetId", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getFromUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setFromUser", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "fromUser", "Lcom/bytedance/android/live/base/model/message/a5;", "getPanelDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "panelDisplayText", "", "getShowMessage", "()Z", "showMessage", "getShowPanel", "showPanel", "Lcom/bytedance/android/livesdk/message/model/m7;", "getGiftPriority", "()Lcom/bytedance/android/livesdk/message/model/m7;", "giftPriority", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getRequiredAssets", "()Ljava/util/List;", "requiredAssets", "", "getDiyItemInfo", "()Ljava/lang/String;", "diyItemInfo", "getScene", "scene", "getPlayPriority", "()I", "playPriority", "isLocalExt", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k6 extends vh7.c<k6>, yh6.c, gm2.d {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    long getAssetId();

    @Override // yh6.c
    /* synthetic */ com.bytedance.android.live.base.model.message.m0 getCommonData();

    String getDiyItemInfo();

    IBaseUser getFromUser();

    m7 getGiftPriority();

    /* synthetic */ long getGiftTimeStamp();

    /* synthetic */ String getLogId();

    /* synthetic */ Map<Integer, Long> getMaps();

    com.bytedance.android.live.base.model.message.a5 getPanelDisplayText();

    int getPlayPriority();

    List<Integer> getRequiredAssets();

    /* synthetic */ boolean getRtcRoomMessageIsExpire();

    String getScene();

    boolean getShowMessage();

    boolean getShowPanel();

    /* synthetic */ IBaseUser getToUser();

    boolean isLocalExt();

    /* synthetic */ boolean isRtcRoomMessage();

    void setAssetId(long r100);

    /* synthetic */ void setCommonData(com.bytedance.android.live.base.model.message.m0 r100);

    void setFromUser(IBaseUser r100);

    /* synthetic */ void setGiftTimeStamp(long r100);

    /* synthetic */ void setLogId(String r100);

    /* synthetic */ void setMaps(Map<Integer, Long> r100);

    /* synthetic */ void setRtcRoomMessage(boolean r100);

    /* synthetic */ void setRtcRoomMessageIsExpire(boolean r100);

    /* synthetic */ void setTimeStampMap(int r100, long r101);

    /* synthetic */ void setToUser(IBaseUser r100);
}
