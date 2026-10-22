package mobile;

import go.Seq;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Finding implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public Finding(int i2) {
        this.refnum = i2;
        Seq.trackGoRef(i2, this);
    }

    private static native int __New();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Finding)) {
            return false;
        }
        Finding finding = (Finding) obj;
        String piType = getPiType();
        String piType2 = finding.getPiType();
        if (piType == null) {
            if (piType2 != null) {
                return false;
            }
        } else if (!piType.equals(piType2)) {
            return false;
        }
        String level = getLevel();
        String level2 = finding.getLevel();
        if (level == null) {
            if (level2 != null) {
                return false;
            }
        } else if (!level.equals(level2)) {
            return false;
        }
        String action = getAction();
        String action2 = finding.getAction();
        if (action == null) {
            if (action2 != null) {
                return false;
            }
        } else if (!action.equals(action2)) {
            return false;
        }
        String value = getValue();
        String value2 = finding.getValue();
        if (value == null) {
            if (value2 != null) {
                return false;
            }
        } else if (!value.equals(value2)) {
            return false;
        }
        String masked = getMasked();
        String masked2 = finding.getMasked();
        if (masked == null) {
            if (masked2 != null) {
                return false;
            }
        } else if (!masked.equals(masked2)) {
            return false;
        }
        if (getStart() != finding.getStart() || getEnd() != finding.getEnd()) {
            return false;
        }
        String ruleID = getRuleID();
        String ruleID2 = finding.getRuleID();
        return ruleID == null ? ruleID2 == null : ruleID.equals(ruleID2);
    }

    public final native String getAction();

    public final native long getEnd();

    public final native String getLevel();

    public final native String getMasked();

    public final native String getPiType();

    public final native String getRuleID();

    public final native long getStart();

    public final native String getValue();

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getPiType(), getLevel(), getAction(), getValue(), getMasked(), Long.valueOf(getStart()), Long.valueOf(getEnd()), getRuleID()});
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public final native void setAction(String str);

    public final native void setEnd(long j2);

    public final native void setLevel(String str);

    public final native void setMasked(String str);

    public final native void setPiType(String str);

    public final native void setRuleID(String str);

    public final native void setStart(long j2);

    public final native void setValue(String str);

    public String toString() {
        return "Finding{PiType:" + getPiType() + ",Level:" + getLevel() + ",Action:" + getAction() + ",Value:" + getValue() + ",Masked:" + getMasked() + ",Start:" + getStart() + ",End:" + getEnd() + ",RuleID:" + getRuleID() + ",}";
    }

    public Finding() {
        int i__New = __New();
        this.refnum = i__New;
        Seq.trackGoRef(i__New, this);
    }
}
