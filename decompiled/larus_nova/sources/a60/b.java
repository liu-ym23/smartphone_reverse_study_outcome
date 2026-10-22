package a60;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"La60/b;", "", "", "maxCacheTime", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setMaxCacheTime", "(I)V", "maxPayloadSize", "b", "setMaxPayloadSize", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("max_cache_time")
    private int maxCacheTime;

    @SerializedName("max_payload_size")
    private int maxPayloadSize;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.maxCacheTime == r101.maxCacheTime) goto L8;
        return false;
    L8:
        if (this.maxPayloadSize == r101.maxPayloadSize) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.maxCacheTime * 31) + this.maxPayloadSize;
    }

    public final String toString() {
        return "BatchConfigV2(maxCacheTime=" + this.maxCacheTime + ", maxPayloadSize=" + this.maxPayloadSize + ")";
    }

    public final int a() {
        return this.maxCacheTime;
    }

    public final int b() {
        return this.maxPayloadSize;
    }

    public b(int r100) {
        this.maxCacheTime = 0;
        this.maxPayloadSize = 81920;
    }
}
