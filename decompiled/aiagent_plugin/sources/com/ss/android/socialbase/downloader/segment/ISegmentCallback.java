package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.HttpResponse;

/* JADX INFO: loaded from: classes4.dex */
interface ISegmentCallback {
    void applySegment(SegmentReader r1, Segment r2);

    IOutput createOutput(SegmentReader r1, Segment r2);

    Segment obtainSegment(SegmentReader r1, UrlRecord r2);

    void onReaderExit(SegmentReader r1);

    void onReaderRun(SegmentReader r1);

    void onSegmentConnected(SegmentReader r1, Segment r2, UrlRecord r3, HttpResponse r4);

    void onSegmentFailed(SegmentReader r1, UrlRecord r2, Segment r3, BaseException r4);

    boolean onSegmentRetry(SegmentReader r1, UrlRecord r2, Segment r3, BaseException r4, int r5, int r6);

    void unApplySegment(SegmentReader r1, Segment r2);

    void unObtainSegment(SegmentReader r1, Segment r2);
}
