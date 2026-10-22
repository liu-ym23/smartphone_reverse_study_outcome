package mobile;

import go.Seq;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Opener implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public Opener(String str, String str2) {
        int i__NewOpener = __NewOpener(str, str2);
        this.refnum = i__NewOpener;
        Seq.trackGoRef(i__NewOpener, this);
    }

    private static native int __NewOpener(String str, String str2);

    private static native int __NewOpenerDefault();

    public native void addKey(String str, String str2);

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Opener)) {
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

    public native String resolveInline(String str);

    public String toString() {
        return "Opener{}";
    }

    public Opener() {
        int i__NewOpenerDefault = __NewOpenerDefault();
        this.refnum = i__NewOpenerDefault;
        Seq.trackGoRef(i__NewOpenerDefault, this);
    }

    public Opener(int i2) {
        this.refnum = i2;
        Seq.trackGoRef(i2, this);
    }
}
