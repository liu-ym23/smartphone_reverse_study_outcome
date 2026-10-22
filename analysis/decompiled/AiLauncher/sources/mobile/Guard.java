package mobile;

import com.autonavi.aps.amapapi.config.Const;
import go.Seq;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class Guard implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public Guard(long j10, long j11) {
        int i__NewGuard = __NewGuard(j10, j11);
        this.refnum = i__NewGuard;
        Seq.trackGoRef(i__NewGuard, this);
    }

    private static native int __NewGuard(long j10, long j11);

    private static native int __NewGuardWithDictDir(long j10, long j11, String str);

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Guard)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[0]);
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public native String sanitize(String str);

    public native SanitizeResult sanitizeDetail(String str) throws Exception;

    public native String sanitizeJSON(String str);

    public native ScanReport scanJSON(String str) throws Exception;

    public String toString() {
        return "Guard" + Const.STR_MART_JSON_BEGIN + "}";
    }

    public Guard(long j10, long j11, String str) {
        int i__NewGuardWithDictDir = __NewGuardWithDictDir(j10, j11, str);
        this.refnum = i__NewGuardWithDictDir;
        Seq.trackGoRef(i__NewGuardWithDictDir, this);
    }

    public Guard(int i10) {
        this.refnum = i10;
        Seq.trackGoRef(i10, this);
    }
}
