package mobile;

import go.Seq;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ScanHit implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public ScanHit(int i2) {
        this.refnum = i2;
        Seq.trackGoRef(i2, this);
    }

    private static native int __New();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ScanHit)) {
            return false;
        }
        ScanHit scanHit = (ScanHit) obj;
        if (getLine() != scanHit.getLine()) {
            return false;
        }
        String ruleID = getRuleID();
        String ruleID2 = scanHit.getRuleID();
        if (ruleID == null) {
            if (ruleID2 != null) {
                return false;
            }
        } else if (!ruleID.equals(ruleID2)) {
            return false;
        }
        String piType = getPiType();
        String piType2 = scanHit.getPiType();
        if (piType == null) {
            if (piType2 != null) {
                return false;
            }
        } else if (!piType.equals(piType2)) {
            return false;
        }
        String level = getLevel();
        String level2 = scanHit.getLevel();
        if (level == null) {
            if (level2 != null) {
                return false;
            }
        } else if (!level.equals(level2)) {
            return false;
        }
        String action = getAction();
        String action2 = scanHit.getAction();
        if (action == null) {
            if (action2 != null) {
                return false;
            }
        } else if (!action.equals(action2)) {
            return false;
        }
        String value = getValue();
        String value2 = scanHit.getValue();
        if (value == null) {
            if (value2 != null) {
                return false;
            }
        } else if (!value.equals(value2)) {
            return false;
        }
        String masked = getMasked();
        String masked2 = scanHit.getMasked();
        if (masked == null) {
            if (masked2 != null) {
                return false;
            }
        } else if (!masked.equals(masked2)) {
            return false;
        }
        String excerpt = getExcerpt();
        String excerpt2 = scanHit.getExcerpt();
        return excerpt == null ? excerpt2 == null : excerpt.equals(excerpt2);
    }

    public final native String getAction();

    public final native String getExcerpt();

    public final native String getLevel();

    public final native long getLine();

    public final native String getMasked();

    public final native String getPiType();

    public final native String getRuleID();

    public final native String getValue();

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getLine()), getRuleID(), getPiType(), getLevel(), getAction(), getValue(), getMasked(), getExcerpt()});
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public final native void setAction(String str);

    public final native void setExcerpt(String str);

    public final native void setLevel(String str);

    public final native void setLine(long j2);

    public final native void setMasked(String str);

    public final native void setPiType(String str);

    public final native void setRuleID(String str);

    public final native void setValue(String str);

    public String toString() {
        return "ScanHit{Line:" + getLine() + ",RuleID:" + getRuleID() + ",PiType:" + getPiType() + ",Level:" + getLevel() + ",Action:" + getAction() + ",Value:" + getValue() + ",Masked:" + getMasked() + ",Excerpt:" + getExcerpt() + ",}";
    }

    public ScanHit() {
        int i__New = __New();
        this.refnum = i__New;
        Seq.trackGoRef(i__New, this);
    }
}
