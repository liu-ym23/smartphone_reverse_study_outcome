package mobile;

import go.Seq;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class SanitizeResult implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public SanitizeResult(int i2) {
        this.refnum = i2;
        Seq.trackGoRef(i2, this);
    }

    private static native int __New();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SanitizeResult)) {
            return false;
        }
        SanitizeResult sanitizeResult = (SanitizeResult) obj;
        String text = getText();
        String text2 = sanitizeResult.getText();
        if (text == null) {
            if (text2 != null) {
                return false;
            }
        } else if (!text.equals(text2)) {
            return false;
        }
        return getBlocked() == sanitizeResult.getBlocked();
    }

    public final native boolean getBlocked();

    public final native String getText();

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getText(), Boolean.valueOf(getBlocked())});
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public final native void setBlocked(boolean z4);

    public final native void setText(String str);

    public String toString() {
        return "SanitizeResult{Text:" + getText() + ",Blocked:" + getBlocked() + ",}";
    }

    public SanitizeResult() {
        int i__New = __New();
        this.refnum = i__New;
        Seq.trackGoRef(i__New, this);
    }
}
