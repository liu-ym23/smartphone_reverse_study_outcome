package com.ss.android.socialbase.downloader.segment;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SegmentUtils {
    public SegmentUtils() {
    }

    public static long getFirstOffset(List<Segment> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        int r0 = r9.size();
        long r2 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L10;
        Segment r5 = (Segment) ZeusTransformUtils.preCheckCast(r9.get(r4), Segment.class, "com.obric.aiagent.plugin");
        if (r5.getStartOffset() > r2) goto L10;
        if (r5.getCurrentOffsetRead() <= r2) goto L9;
        r2 = r5.getCurrentOffsetRead();
    L9:
        r4 = r4 + 1;
    L10:
        return r2;
    }

    public static long getDownloadedBytes(List<Segment> r14) {
        Iterator r15 = ((List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin")).iterator();
        long r10 = 0;
    L3:
        long r6 = -1;
        long r8 = -1;
    L5:
        if (r15.hasNext() == false) goto L20;
        Segment r0 = (Segment) ZeusTransformUtils.preCheckCast(r15.next(), Segment.class, "com.obric.aiagent.plugin");
        if (r6 == (-1)) goto L9;
        if (r0.getStartOffset() <= r8) goto L14;
        r10 = r10 + (r8 - r6);
        if (r0.getDownloadBytes() <= 0) goto L3;
        r6 = r0.getStartOffset();
        r8 = r0.getCurrentOffset();
        goto L5
    L14:
        if (r0.getCurrentOffset() <= r8) goto L5;
        r8 = r0.getCurrentOffset();
        goto L5
    L9:
        if (r0.getDownloadBytes() <= 0) goto L5;
        r6 = r0.getStartOffset();
        r8 = r0.getCurrentOffset();
        goto L5
    L20:
        if (r6 >= 0) goto L22;
        return r10;
    L22:
        if (r8 > r6) goto L24;
        return r10;
    L24:
        return r10 + (r8 - r6);
    }
}
