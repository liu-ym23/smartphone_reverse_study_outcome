package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.ContentOpenTreasureTouchItem")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/sh;", "", "Lcom/bytedance/android/livesdk/message/model/zg;", "detail", "Lcom/bytedance/android/livesdk/message/model/zg;", "Lcom/bytedance/android/livesdk/message/model/yg;", "freqCtr", "Lcom/bytedance/android/livesdk/message/model/yg;", "", "priority", "I", "", "", "bizExtra", "Ljava/util/Map;", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class sh implements vh7.h {

    @SerializedName("biz_extra")
    public Map<String, String> bizExtra;

    @SerializedName("detail")
    public zg detail;

    @SerializedName("freqCtr")
    public yg freqCtr;

    @SerializedName("priority")
    public int priority;

    public sh() {
    }

    public sh(am3.g r110) {
        this.bizExtra = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.detail = new zg(r110);
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.freqCtr = new yg(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        this.priority = r110.i();
        goto L3
    L12:
        if (r101 != 4) goto L13;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L15:
        int r105 = r110.f();
        if (r105 == (-1)) goto L22;
        if (r105 != 1) goto L18;
        r103 = am3.h.c(r110);
        goto L15
    L18:
        if (r105 != 2) goto L19;
        r104 = am3.h.c(r110);
        goto L15
    L19:
        am3.h.e(r110);
        goto L15
    L22:
        r110.d(r102);
        Map<String, String> r106 = this.bizExtra;
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
