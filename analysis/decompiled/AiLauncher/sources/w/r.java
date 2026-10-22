package w;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000b\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\f"}, d2 = {"Lw/r;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(J)J", "", Const.INTENT_KEY_UMID, "(J)Ljava/lang/String;", "", "c", "(J)I", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r {
    public static long a(long j10) {
        return j10;
    }

    public static final boolean b(long j10, long j11) {
        return j10 == j11;
    }

    public static int c(long j10) {
        return Long.hashCode(j10);
    }

    public static String d(long j10) {
        return "CameraTimestamp(value=" + j10 + ')';
    }
}
