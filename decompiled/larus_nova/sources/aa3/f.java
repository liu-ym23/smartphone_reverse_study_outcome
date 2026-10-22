package aa3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR6\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012¨\u0006\u001f"}, d2 = {"Laa3/f;", "", "", "", "", "Laa3/g;", "mallStorageClear", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setMallStorageClear", "(Ljava/util/Map;)V", "", "clearStorageByCrashNum", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setClearStorageByCrashNum", "(Ljava/lang/Integer;)V", "", "clearStorageByCrashTime", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "setClearStorageByCrashTime", "(Ljava/lang/Long;)V", "cacheValidDay", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCacheValidDay", "<init>", "()V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("cache_valid_day")
    private Integer cacheValidDay;

    @SerializedName("clear_storage_by_crash_num")
    private Integer clearStorageByCrashNum;

    @SerializedName("clear_storage_by_crash_time")
    private Long clearStorageByCrashTime;

    @SerializedName("mall_storage_clear")
    private Map<String, List<g>> mallStorageClear;

    public f() {
    }

    public final Integer a() {
        return this.cacheValidDay;
    }

    public final Integer b() {
        return this.clearStorageByCrashNum;
    }

    public final Long c() {
        return this.clearStorageByCrashTime;
    }

    public final Map<String, List<g>> d() {
        return this.mallStorageClear;
    }
}
