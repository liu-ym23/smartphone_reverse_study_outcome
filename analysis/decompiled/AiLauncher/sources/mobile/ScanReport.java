package mobile;

import com.autonavi.aps.amapapi.config.Const;
import go.Seq;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class ScanReport implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public ScanReport(int i10) {
        this.refnum = i10;
        Seq.trackGoRef(i10, this);
    }

    private static native int __New();

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ScanReport)) {
            return false;
        }
        ScanReport scanReport = (ScanReport) obj;
        return getLinesProcessed() == scanReport.getLinesProcessed() && getTotalHits() == scanReport.getTotalHits() && getBlockedLines() == scanReport.getBlockedLines();
    }

    public final native long getBlockedLines();

    public final native long getLinesProcessed();

    public final native long getTotalHits();

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(getLinesProcessed()), Long.valueOf(getTotalHits()), Long.valueOf(getBlockedLines())});
    }

    @Override // go.Seq.GoObject
    public final int incRefnum() {
        Seq.incGoRef(this.refnum, this);
        return this.refnum;
    }

    public final native void setBlockedLines(long j10);

    public final native void setLinesProcessed(long j10);

    public final native void setTotalHits(long j10);

    public String toString() {
        return "ScanReport" + Const.STR_MART_JSON_BEGIN + "LinesProcessed:" + getLinesProcessed() + Const.STR_MART_COMMA + "TotalHits:" + getTotalHits() + Const.STR_MART_COMMA + "BlockedLines:" + getBlockedLines() + Const.STR_MART_COMMA + "}";
    }

    public ScanReport() {
        int i__New = __New();
        this.refnum = i__New;
        Seq.trackGoRef(i__New, this);
    }
}
