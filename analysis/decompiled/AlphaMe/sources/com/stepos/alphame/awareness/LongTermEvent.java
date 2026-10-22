package com.stepos.alphame.awareness;

import androidx.room.AbstractC0351g;
import com.stepos.alphame.utils.StringUtil;

/* loaded from: classes.dex */
public class LongTermEvent {
    public static final long MINUTE = 60000;
    public static final long SECEND = 1000;
    private static final long TIME_OFFSET = 300000;
    public long end;
    public String info1;
    public String info2;
    int scene;
    long start;
    long term;

    public LongTermEvent(int i4, long j4, long j5, String str, String str2) {
        this.scene = i4;
        this.start = j4;
        this.end = j5;
        this.info1 = str;
        this.info2 = str2;
        this.term = j5 - j4;
    }

    public boolean include(long j4, long j5) {
        return j4 - this.start > -300000 && this.end - j5 > -300000;
    }

    public String toString() {
        int i4 = this.scene;
        String dateFull = StringUtil.formatDateFull(this.start);
        String dateFull2 = StringUtil.formatDateFull(this.end);
        String str = this.info1;
        String str2 = this.info2;
        long j4 = this.term / 60000;
        StringBuilder sb = new StringBuilder("[scene=");
        sb.append(i4);
        sb.append(" start=");
        sb.append(dateFull);
        sb.append(" end=");
        AbstractC0351g.C(sb, dateFull2, " info1=", str, " info2=");
        sb.append(str2);
        sb.append(" term=");
        sb.append(j4);
        sb.append("]");
        return sb.toString();
    }
}
