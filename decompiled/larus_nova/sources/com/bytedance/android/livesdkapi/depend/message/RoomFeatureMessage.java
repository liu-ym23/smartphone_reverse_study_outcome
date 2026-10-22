package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.RoomFeatureMessage")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/RoomFeatureMessage;", "", "()V", "anchorId", "", "getAnchorId", "()Ljava/lang/Long;", "setAnchorId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "anchorOpenId", "", "getAnchorOpenId", "()Ljava/lang/String;", "setAnchorOpenId", "(Ljava/lang/String;)V", "featureMap", "", "Lcom/bytedance/android/livesdkapi/depend/message/RoomFeatureValue;", "getFeatureMap", "()Ljava/util/Map;", "setFeatureMap", "(Ljava/util/Map;)V", "pushType", "getPushType", "setPushType", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomFeatureMessage implements h {

    @SerializedName("anchor_id")
    protected Long anchorId;

    @SerializedName("anchor_open_id")
    protected String anchorOpenId;

    @SerializedName("featureMap")
    protected Map<String, RoomFeatureValue> featureMap;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE)
    protected String pushType;

    public RoomFeatureMessage() {
    }

    public final Long getAnchorId() {
        return this.anchorId;
    }

    public final String getAnchorOpenId() {
        return this.anchorOpenId;
    }

    public final Map<String, RoomFeatureValue> getFeatureMap() {
        return this.featureMap;
    }

    public final String getPushType() {
        return this.pushType;
    }

    public RoomFeatureMessage(g r110) {
        this.featureMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.anchorId = Long.valueOf(r110.j());
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.pushType = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        long r102 = r110.c();
        String r103 = null;
        RoomFeatureValue r104 = null;
    L16:
        int r105 = r110.f();
        if (r105 == (-1)) goto L23;
        if (r105 != 1) goto L19;
        r103 = am3.h.c(r110);
        goto L16
    L19:
        if (r105 != 2) goto L20;
        r104 = new RoomFeatureValue(r110);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r102);
        Map<String, RoomFeatureValue> r106 = this.featureMap;
        if (r103 == null) goto L30;
        if (r104 == null) goto L28;
        r106.put(r103, r104);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 5000) goto L13;
        this.anchorOpenId = am3.h.c(r110);
        goto L3
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }

    public final void setAnchorId(Long r100) {
        this.anchorId = r100;
    }

    public final void setAnchorOpenId(String r100) {
        this.anchorOpenId = r100;
    }

    public final void setFeatureMap(Map<String, RoomFeatureValue> r100) {
        this.featureMap = r100;
    }

    public final void setPushType(String r100) {
        this.pushType = r100;
    }
}
