package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ForMain
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/z1;", "", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "I", "", "Lcom/bytedance/android/livesdk/message/model/y1;", "commonTriggerList", "Ljava/util/List;", "", "", "customTriggerMap", "Ljava/util/Map;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class z1 implements vh7.h {

    @SerializedName("commonTriggerList")
    public List<y1> commonTriggerList;

    @SerializedName("customTriggerMap")
    public Map<String, String> customTriggerMap;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    public int strategy;

    public z1() {
    }

    public final String toString() {
        return "CardTriggerConfig(strategy=" + this.strategy + ", commonTriggerList=" + this.commonTriggerList + ", customTriggerMap=" + this.customTriggerMap + ')';
    }

    public z1(am3.g r110) {
        this.commonTriggerList = new ArrayList();
        this.customTriggerMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L30;
        if (r101 != 1) goto L8;
        this.strategy = r110.i();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.commonTriggerList.add(new y1(r110));
        goto L3
    L10:
        if (r101 != 3) goto L11;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L13:
        int r105 = r110.f();
        if (r105 == (-1)) goto L20;
        if (r105 != 1) goto L16;
        r103 = am3.h.c(r110);
        goto L13
    L16:
        if (r105 != 2) goto L17;
        r104 = am3.h.c(r110);
        goto L13
    L17:
        am3.h.e(r110);
        goto L13
    L20:
        r110.d(r102);
        Map<String, String> r106 = this.customTriggerMap;
        if (r103 == null) goto L27;
        if (r104 == null) goto L25;
        r106.put(r103, r104);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r100);
    }
}
