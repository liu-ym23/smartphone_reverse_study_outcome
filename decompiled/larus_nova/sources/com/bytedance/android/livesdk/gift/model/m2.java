package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u001c\u0010\u001f\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0019R\u0014\u0010!\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0010R\u001c\u0010'\u001a\u00020\"8&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u001e\u0010,\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0004\"\u0004\b+\u0010\u0006R\u001c\u0010/\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0010\"\u0004\b.\u0010\u0019R\u0014\u00100\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0010R\u0014\u00102\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0010R\u001c\u00107\u001a\n\u0012\u0004\u0012\u000204\u0018\u0001038&X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001c\u0010:\u001a\n\u0012\u0004\u0012\u000208\u0018\u0001038&X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u00106R\u001c\u0010=\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0019R\u0014\u0010?\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u0004¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/m2;", "Lvh7/c;", "", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "logId", "Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayText", "()Lcom/bytedance/android/live/base/model/message/a5;", "setDisplayText", "(Lcom/bytedance/android/live/base/model/message/a5;)V", "displayText", "", "getFanTicketCount", "()J", "fanTicketCount", "getLeftDiamonds", "leftDiamonds", "getDescribe", "setDescribe", "describe", "getGiftId", "setGiftId", "(J)V", "giftId", "getGroupCount", "groupCount", "getGroupId", "setGroupId", "groupId", "getRepeatCount", "repeatCount", "", "getGiftCnt", "()I", "setGiftCnt", "(I)V", "giftCnt", "getComboCount", "comboCount", "getMsgId", "setMsgId", RemoteMessageConst.MSGID, "getPropId", "setPropId", "propId", "isAwemeFreeGift", "getPropType", "propType", "", "Lcom/bytedance/android/livesdk/gift/model/l2;", "getProps", "()Ljava/util/List;", SlcElement.KEY_PROPS, "Lcom/bytedance/android/livesdk/gift/model/y1;", "getGifts", "gifts", "getConsumeDiamonds", "setConsumeDiamonds", "consumeDiamonds", "getTraceId", "traceId", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m2 extends vh7.c<m2> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    long getComboCount();

    long getConsumeDiamonds();

    String getDescribe();

    a5 getDisplayText();

    long getFanTicketCount();

    int getGiftCnt();

    long getGiftId();

    List<y1> getGifts();

    long getGroupCount();

    long getGroupId();

    long getLeftDiamonds();

    String getLogId();

    String getMsgId();

    long getPropId();

    long getPropType();

    List<l2> getProps();

    long getRepeatCount();

    String getTraceId();

    long isAwemeFreeGift();

    void setConsumeDiamonds(long r100);

    void setDescribe(String r100);

    void setDisplayText(a5 r100);

    void setGiftCnt(int r100);

    void setGiftId(long r100);

    void setGroupId(long r100);

    void setLogId(String r100);

    void setMsgId(String r100);

    void setPropId(long r100);
}
