package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "", "Ljava/io/Serializable;", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "STATUS_ACTIVE", "STATUS_FREEZE", "STATUS_DEAD", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FreqStatus extends Enum<FreqStatus> implements Serializable {
    public static final a Companion = null;

    @SerializedName("active")
    public static final FreqStatus STATUS_ACTIVE = null;

    @SerializedName("dead")
    public static final FreqStatus STATUS_DEAD = null;

    @SerializedName("freeze")
    public static final FreqStatus STATUS_FREEZE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FreqStatus[] f179868a = null;
    private final String status;

    public static final class a {
        public a() {
        }
    }

    static {
        FreqStatus r100 = new FreqStatus("STATUS_ACTIVE", 0, "active");
        STATUS_ACTIVE = r100;
        FreqStatus r101 = new FreqStatus("STATUS_FREEZE", 1, "freeze");
        STATUS_FREEZE = r101;
        FreqStatus r102 = new FreqStatus("STATUS_DEAD", 2, "dead");
        STATUS_DEAD = r102;
        f179868a = new FreqStatus[]{r100, r101, r102};
        Companion = new a();
    }

    public static FreqStatus valueOf(String r100) {
        return (FreqStatus) r27.a.a(FreqStatus.class, r100);
    }

    public static FreqStatus[] values() {
        return (FreqStatus[]) f179868a.clone();
    }

    public final String getStatus() {
        return this.status;
    }

    public FreqStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.status = r102;
    }
}
