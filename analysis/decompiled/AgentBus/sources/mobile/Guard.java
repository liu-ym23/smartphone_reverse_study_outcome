package mobile;

import go.Seq;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Guard implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public Guard(long j2, long j4) {
        int i__NewGuard = __NewGuard(j2, j4);
        this.refnum = i__NewGuard;
        Seq.trackGoRef(i__NewGuard, this);
    }

    private static native int __NewGuard(long j2, long j4);

    private static native int __NewGuardWithDictDir(long j2, long j4, String str);

    private static native int __NewGuardWithEncrypt(long j2, long j4, boolean z4, String str);

    private static native int __NewGuardWithEncryptDefault(long j2, long j4, boolean z4);

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

    public native SanitizeResult sanitizeDetail(String str);

    public native String sanitizeJSON(String str);

    public native ScanReport scanJSON(String str);

    public String toString() {
        return "Guard{}";
    }

    public Guard(long j2, long j4, String str) {
        int i__NewGuardWithDictDir = __NewGuardWithDictDir(j2, j4, str);
        this.refnum = i__NewGuardWithDictDir;
        Seq.trackGoRef(i__NewGuardWithDictDir, this);
    }

    public Guard(long j2, long j4, boolean z4, String str) {
        int i__NewGuardWithEncrypt = __NewGuardWithEncrypt(j2, j4, z4, str);
        this.refnum = i__NewGuardWithEncrypt;
        Seq.trackGoRef(i__NewGuardWithEncrypt, this);
    }

    public Guard(long j2, long j4, boolean z4) {
        int i__NewGuardWithEncryptDefault = __NewGuardWithEncryptDefault(j2, j4, z4);
        this.refnum = i__NewGuardWithEncryptDefault;
        Seq.trackGoRef(i__NewGuardWithEncryptDefault, this);
    }

    public Guard(int i2) {
        this.refnum = i2;
        Seq.trackGoRef(i2, this);
    }
}
