package w;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0014"}, d2 = {"Lw/L;", "", "", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(J)J", "", "e", "(J)Ljava/lang/String;", "", Const.INTENT_KEY_UMID, "(J)I", "other", "", "c", "(JLjava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "getValue", "()J", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class L {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long value;

    public /* synthetic */ L(long j10) {
        this.value = j10;
    }

    public static final /* synthetic */ L a(long j10) {
        return new L(j10);
    }

    public static long b(long j10) {
        return j10;
    }

    public static boolean c(long j10, Object obj) {
        return (obj instanceof L) && j10 == ((L) obj).getValue();
    }

    public static int d(long j10) {
        return Long.hashCode(j10);
    }

    public static String e(long j10) {
        return "RequestNumber(value=" + j10 + ')';
    }

    public boolean equals(Object obj) {
        return c(this.value, obj);
    }

    /* renamed from: f, reason: from getter */
    public final /* synthetic */ long getValue() {
        return this.value;
    }

    public int hashCode() {
        return d(this.value);
    }

    public String toString() {
        return e(this.value);
    }
}
