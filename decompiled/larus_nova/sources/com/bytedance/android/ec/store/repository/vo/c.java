package com.bytedance.android.ec.store.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/c;", "", "Lcom/bytedance/android/ec/store/repository/vo/v;", "prefixText", "Lcom/bytedance/android/ec/store/repository/vo/v;", "d", "()Lcom/bytedance/android/ec/store/repository/vo/v;", "setPrefixText", "(Lcom/bytedance/android/ec/store/repository/vo/v;)V", "activityTextStyle", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setActivityTextStyle", "", "expiredTimeStamp", "J", "c", "()J", "setExpiredTimeStamp", "(J)V", "serverTime", "e", "setServerTime", "expiredText", "b", "setExpiredText", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("activity_text_style")
    private v activityTextStyle;

    @SerializedName("expired_text")
    private v expiredText;

    @SerializedName("expired_timestamp")
    private long expiredTimeStamp;

    @SerializedName("prefix_text")
    private v prefixText;

    @SerializedName("server_time")
    private long serverTime;

    public c() {
    }

    public final v a() {
        return this.activityTextStyle;
    }

    public final v b() {
        return this.expiredText;
    }

    public final long c() {
        return this.expiredTimeStamp;
    }

    public final v d() {
        return this.prefixText;
    }

    public final long e() {
        return this.serverTime;
    }

    public c(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        Object r101 = r100.get("prefix_text");
        Object r102 = null;
        if ((r101 instanceof Map) == true) goto L8;
        r101 = null;
    L8:
        this.prefixText = new v((Map) r101);
        Object r103 = r100.get("activity_text_style");
        if ((r103 instanceof Map) == true) goto L11;
        r103 = null;
    L11:
        this.activityTextStyle = new v((Map) r103);
        Object r104 = r100.get("expired_time_stamp");
        if ((r104 instanceof Number) == true) goto L14;
        r104 = null;
    L14:
        Number r105 = (Number) r104;
        long r106 = 0;
        if (r105 == null) goto L17;
        long r107 = r105.longValue();
    L18:
        this.expiredTimeStamp = r107;
        Object r108 = r100.get("server_time");
        if ((r108 instanceof Number) == true) goto L21;
        r108 = null;
    L21:
        Number r109 = (Number) r108;
        if (r109 == null) goto L24;
        r106 = r109.longValue();
    L24:
        this.serverTime = r106;
        Object r110 = r100.get("expired_text");
        if ((r110 instanceof Map) == false) goto L28;
        r102 = r110;
    L28:
        this.expiredText = new v((Map) r102);
        return;
    L17:
        r107 = 0;
        goto L18
    }
}
