package c93;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lc93/b;", "", "", "type", "I", "getType", "()I", "startDelay", "c", VideoThumbInfo.KEY_INTERVAL, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "repeatTimes", "b", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final int interval;

    @SerializedName("repeat_times")
    private final int repeatTimes;

    @SerializedName("start_delay")
    private final int startDelay;

    @SerializedName("type")
    private final int type;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.type == r101.type) goto L8;
        return false;
    L8:
        if (this.startDelay == r101.startDelay) goto L10;
        return false;
    L10:
        if (this.interval == r101.interval) goto L12;
        return false;
    L12:
        if (this.repeatTimes == r101.repeatTimes) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.type * 31) + this.startDelay) * 31) + this.interval) * 31) + this.repeatTimes;
    }

    public final String toString() {
        return "LigoDecisionSchedulerDsl(type=" + this.type + ", startDelay=" + this.startDelay + ", interval=" + this.interval + ", repeatTimes=" + this.repeatTimes + ")";
    }

    public b() {
        this.type = 0;
        this.startDelay = 0;
        this.interval = 0;
        this.repeatTimes = 0;
    }

    public final int a() {
        return this.interval;
    }

    public final int b() {
        return this.repeatTimes;
    }

    public final int c() {
        return this.startDelay;
    }

    public final int getType() {
        return this.type;
    }
}
