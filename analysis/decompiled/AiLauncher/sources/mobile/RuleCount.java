package mobile;

import com.autonavi.aps.amapapi.config.Const;
import go.Seq;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class RuleCount implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public RuleCount(int i10) {
        this.refnum = i10;
        Seq.trackGoRef(i10, this);
    }

    private static native int __New();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RuleCount)) {
            return false;
        }
        RuleCount ruleCount = (RuleCount) obj;
        String rule = getRule();
        String rule2 = ruleCount.getRule();
        if (rule == null) {
            if (rule2 != null) {
                return false;
            }
        } else if (!rule.equals(rule2)) {
            return false;
        }
        return getCount() == ruleCount.getCount();
    }

    public final native long getCount();

    public final native String getRule();

    public int hashCode() {
        return Arrays.hashCode(new Object[]{getRule(), Long.valueOf(getCount())});
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public final native void setCount(long j10);

    public final native void setRule(String str);

    public String toString() {
        return "RuleCount" + Const.STR_MART_JSON_BEGIN + "Rule:" + getRule() + Const.STR_MART_COMMA + "Count:" + getCount() + Const.STR_MART_COMMA + "}";
    }

    public RuleCount() {
        int i__New = __New();
        this.refnum = i__New;
        Seq.trackGoRef(i__New, this);
    }
}
