package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.CreatePageConfigPre")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/b0;", "", "", "", "Lcom/bytedance/android/live/broadcast/api/model/q1;", "configMap", "Ljava/util/Map;", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 implements vh7.h {

    @SerializedName("config_map")
    public Map<String, q1> configMap;

    public b0() {
    }

    public b0(am3.g r110) {
        this.configMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L25;
        if (r101 != 1) goto L7;
        long r102 = r110.c();
        String r103 = null;
        q1 r104 = null;
    L9:
        int r105 = r110.f();
        if (r105 == (-1)) goto L17;
        if (r105 != 1) goto L13;
        r103 = am3.h.c(r110);
        goto L9
    L13:
        if (r105 != 2) goto L14;
        r104 = new q1(r110);
        goto L9
    L14:
        am3.h.e(r110);
        goto L9
    L17:
        r110.d(r102);
        Map<String, q1> r106 = this.configMap;
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
    }
}
