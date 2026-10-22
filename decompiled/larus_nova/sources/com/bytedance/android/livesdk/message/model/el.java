package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.ShelfTradeData")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/el;", "", "", "roomId", "J", "getRoomId", "()J", "", "topDataType", "I", "getTopDataType", "()I", "", "Lcom/bytedance/android/livesdk/message/model/dl;", "topTradeDataList", "Ljava/util/List;", "b", "()Ljava/util/List;", "", "Lcom/bytedance/android/livesdk/message/model/bl;", "cardTradeDataMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class el implements vh7.h {

    @SerializedName("card_data")
    protected Map<Long, bl> cardTradeDataMap;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("top_data_type")
    protected int topDataType;

    @SerializedName("top_data")
    protected List<dl> topTradeDataList;

    public el() {
    }

    public final Map<Long, bl> a() {
        return this.cardTradeDataMap;
    }

    public final List<dl> b() {
        return this.topTradeDataList;
    }

    public el(am3.g r110) {
        this.topTradeDataList = new ArrayList();
        this.cardTradeDataMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.roomId = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.topDataType = r110.i();
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.topTradeDataList.add(new dl(r110));
        goto L3
    L12:
        if (r101 != 4) goto L13;
        long r102 = r110.c();
        Long r103 = null;
        bl r104 = null;
    L15:
        int r105 = r110.f();
        if (r105 == (-1)) goto L22;
        if (r105 != 1) goto L18;
        r103 = Long.valueOf(r110.j());
        goto L15
    L18:
        if (r105 != 2) goto L19;
        r104 = new bl(r110);
        goto L15
    L19:
        am3.h.e(r110);
        goto L15
    L22:
        r110.d(r102);
        Map<Long, bl> r106 = this.cardTradeDataMap;
        if (r103 == null) goto L29;
        if (r104 == null) goto L27;
        r106.put(r103, r104);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }
}
