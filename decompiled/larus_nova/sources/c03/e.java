package c03;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00018\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lc03/e;", "K", "V", "", "", "statusCode", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "data", "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "extra", "b", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e<K, V> {

    @SerializedName("data")
    private final K data;

    @SerializedName("extra")
    private final V extra;

    @SerializedName("status_code")
    private final Integer statusCode;

    public e() {
        this.statusCode = null;
        this.data = null;
        this.extra = null;
    }

    public final K a() {
        return this.data;
    }

    public final V b() {
        return this.extra;
    }

    public final Integer c() {
        return this.statusCode;
    }
}
