package aa3;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Laa3/g;", "", "", DyPayConstant.KEY_START_TIME, "J", "b", "()J", "setStartTime", "(J)V", "endTime", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEndTime", "<init>", "()V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("end_time")
    private long endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private long startTime;

    public g() {
    }

    public final long a() {
        return this.endTime;
    }

    public final long b() {
        return this.startTime;
    }
}
