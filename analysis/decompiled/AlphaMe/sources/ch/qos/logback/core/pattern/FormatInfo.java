package ch.qos.logback.core.pattern;

import B0.g;

/* loaded from: classes.dex */
public class FormatInfo {
    private boolean leftPad;
    private boolean leftTruncate;
    private int max;
    private int min;

    public FormatInfo() {
        this.min = Integer.MIN_VALUE;
        this.max = Integer.MAX_VALUE;
        this.leftPad = true;
        this.leftTruncate = true;
    }

    public static FormatInfo valueOf(String str) throws IllegalArgumentException {
        String strSubstring;
        if (str == null) {
            throw new NullPointerException("Argument cannot be null");
        }
        FormatInfo formatInfo = new FormatInfo();
        int iIndexOf = str.indexOf(46);
        if (iIndexOf != -1) {
            String strSubstring2 = str.substring(0, iIndexOf);
            int i4 = iIndexOf + 1;
            if (i4 == str.length()) {
                throw new IllegalArgumentException(g.n("Formatting string [", str, "] should not end with '.'"));
            }
            strSubstring = str.substring(i4);
            str = strSubstring2;
        } else {
            strSubstring = null;
        }
        if (str != null && str.length() > 0) {
            int i5 = Integer.parseInt(str);
            if (i5 >= 0) {
                formatInfo.min = i5;
            } else {
                formatInfo.min = -i5;
                formatInfo.leftPad = false;
            }
        }
        if (strSubstring != null && strSubstring.length() > 0) {
            int i6 = Integer.parseInt(strSubstring);
            if (i6 >= 0) {
                formatInfo.max = i6;
            } else {
                formatInfo.max = -i6;
                formatInfo.leftTruncate = false;
            }
        }
        return formatInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatInfo)) {
            return false;
        }
        FormatInfo formatInfo = (FormatInfo) obj;
        return this.min == formatInfo.min && this.max == formatInfo.max && this.leftPad == formatInfo.leftPad && this.leftTruncate == formatInfo.leftTruncate;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public int hashCode() {
        return (((((this.min * 31) + this.max) * 31) + (this.leftPad ? 1 : 0)) * 31) + (this.leftTruncate ? 1 : 0);
    }

    public boolean isLeftPad() {
        return this.leftPad;
    }

    public boolean isLeftTruncate() {
        return this.leftTruncate;
    }

    public void setLeftPad(boolean z4) {
        this.leftPad = z4;
    }

    public void setLeftTruncate(boolean z4) {
        this.leftTruncate = z4;
    }

    public void setMax(int i4) {
        this.max = i4;
    }

    public void setMin(int i4) {
        this.min = i4;
    }

    public String toString() {
        return "FormatInfo(" + this.min + ", " + this.max + ", " + this.leftPad + ", " + this.leftTruncate + ")";
    }

    public FormatInfo(int i4, int i5) {
        this.leftPad = true;
        this.leftTruncate = true;
        this.min = i4;
        this.max = i5;
    }

    public FormatInfo(int i4, int i5, boolean z4, boolean z5) {
        this.min = i4;
        this.max = i5;
        this.leftPad = z4;
        this.leftTruncate = z5;
    }
}
