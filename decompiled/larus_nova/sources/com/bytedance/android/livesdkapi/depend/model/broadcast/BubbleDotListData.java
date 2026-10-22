package com.bytedance.android.livesdkapi.depend.model.broadcast;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/broadcast/BubbleDotListData;", "", "()V", "listData", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/BubbleDotPanelInfo;", "getListData", "()Ljava/util/Map;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BubbleDotListData implements h {

    @SerializedName("panels")
    protected Map<String, BubbleDotPanelInfo> listData;

    public BubbleDotListData() {
        this.listData = new LinkedHashMap();
    }

    public final Map<String, BubbleDotPanelInfo> getListData() {
        return this.listData;
    }

    public BubbleDotListData(g r110) {
        this.listData = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        if (r101 != 1) goto L7;
        long r102 = r110.c();
        String r103 = null;
        BubbleDotPanelInfo r104 = null;
    L9:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L9
    L13:
        if (r105 != 2) goto L14;
        r104 = new BubbleDotPanelInfo(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r102);
        Map<String, BubbleDotPanelInfo> r106 = this.listData;
        if (r103 == null) goto L24;
        if (r104 == null) goto L22;
        r106.put(r103, r104);
        goto L3
    L22:
        throw new IllegalStateException("Value must not be null");
    L24:
        throw new IllegalStateException("Key must not be null");
    L7:
        am3.h.e(r110);
        goto L3
    L25:
        r110.d(r100);
        if (this.listData != null) goto L46;
        this.listData = new LinkedHashMap();
        return;
    }
}
