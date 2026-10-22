package com.jeffmony.async.http;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class ProtocolVersion implements Serializable, Cloneable {
    private static final long serialVersionUID = 8950662842175091068L;
    protected final int major;
    protected final int minor;
    protected final String protocol;

    public ProtocolVersion(String r10, int r11, int r12) {
        if (r10 == null) goto L13;
        if (r11 < 0) goto L11;
        if (r12 < 0) goto L9;
        this.protocol = r10;
        this.major = r11;
        this.minor = r12;
        return;
    L9:
        throw new IllegalArgumentException("Protocol minor version number may not be negative");
    L11:
        throw new IllegalArgumentException("Protocol major version number must not be negative.");
    L13:
        throw new IllegalArgumentException("Protocol name must not be null.");
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareToVersion(ProtocolVersion r10) {
        if (r10 == null) goto L12;
        if (this.protocol.equals(r10.protocol) == false) goto L10;
        int r11 = getMajor() - r10.getMajor();
        if (r11 == 0) goto L8;
        return r11;
    L8:
        return getMinor() - r10.getMinor();
    L10:
        throw new IllegalArgumentException("Versions for different protocols cannot be compared. " + this + " " + r10);
    L12:
        throw new IllegalArgumentException("Protocol version must not be null.");
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
