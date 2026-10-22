package mobile;

import go.Seq;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class ScanReport implements Seq.Proxy {
    private final int refnum;

    static {
        Mobile.touch();
    }

    public ScanReport(int i2) {
        this.refnum = i2;
        Seq.trackGoRef(i2, this);
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

    public final native void setBlockedLines(long j2);

    public final native void setLinesProcessed(long j2);

    public final native void setTotalHits(long j2);

    public String toString() {
        return "ScanReport{LinesProcessed:" + getLinesProcessed() + ",TotalHits:" + getTotalHits() + ",BlockedLines:" + getBlockedLines() + ",}";
    }

    public ScanReport() {
        int i__New = __New();
        this.refnum = i__New;
        Seq.trackGoRef(i__New, this);
    }
}
