package org.apache.http;

import java.io.Serializable;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class ProtocolVersion implements Serializable, Cloneable {
    private static final long serialVersionUID = 8950662842175091068L;
    protected final int major;
    protected final int minor;
    protected final String protocol;

    public ProtocolVersion(String r10, int r11, int r12) {
        this.protocol = (String) Args.notNull(r10, "Protocol name");
        this.major = Args.notNegative(r11, "Protocol minor version");
        this.minor = Args.notNegative(r12, "Protocol minor version");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareToVersion(ProtocolVersion r10) {
        Args.notNull(r10, "Protocol version");
        Args.check(this.protocol.equals(r10.protocol), "Versions for different protocols cannot be compared: %s %s", new Object[]{this, r10});
        int r11 = getMajor() - r10.getMajor();
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return getMinor() - r10.getMinor();
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ProtocolVersion) == true) goto L8;
        return false;
    L8:
        ProtocolVersion r11 = (ProtocolVersion) r10;
        if (this.protocol.equals(r11.protocol) == false) goto L16;
        if (this.major != r11.major) goto L16;
        if (this.minor != r11.minor) goto L16;
        return true;
    L16:
        return false;
    }

    public ProtocolVersion forVersion(int r10, int r11) {
        if (r10 != this.major) goto L8;
        if (r11 != this.minor) goto L8;
        return this;
    L8:
        return new ProtocolVersion(this.protocol, r10, r11);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final boolean greaterEquals(ProtocolVersion r10) {
        if (isComparable(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (compareToVersion(r10) < 0) goto L7;
        return true;
    }

    public final int hashCode() {
        int r10 = this.protocol.hashCode() ^ (this.major * 100000);
        return this.minor ^ r10;
    }

    public boolean isComparable(ProtocolVersion r10) {
        if (r10 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.protocol.equals(r10.protocol) == false) goto L6;
        return true;
    }

    public final boolean lessEquals(ProtocolVersion r10) {
        if (isComparable(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if (compareToVersion(r10) > 0) goto L7;
        return true;
    }

    public String toString() {
        return this.protocol + '/' + Integer.toString(this.major) + '.' + Integer.toString(this.minor);
    }
}
