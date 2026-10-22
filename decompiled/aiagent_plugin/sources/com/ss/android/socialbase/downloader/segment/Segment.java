package com.ss.android.socialbase.downloader.segment;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class Segment {
    private static final String TAG = "Segment";
    int competitor;
    private final AtomicLong currentOffset;
    private volatile long currentOffsetRead;
    private long endOffset;
    private int index;
    private JSONObject jsonObject;
    volatile SegmentReader owner;
    private final long startOffset;

    interface JsonKey {
        public static final String CURRENT = "cu";
        public static final String END = "en";
        public static final String START = "st";
    }

    public Segment(long r3) {
        this(r3, -1);
    }

    public Segment(long r3, long r5) {
        AtomicLong r0 = new AtomicLong();
        this.currentOffset = r0;
        this.competitor = 0;
        this.startOffset = r3;
        r0.set(r3);
        this.currentOffsetRead = r3;
        if (r5 < r3) goto L5;
        this.endOffset = r5;
        return;
    L5:
        this.endOffset = -1;
    }

    public Segment(Segment r4) {
        AtomicLong r0 = new AtomicLong();
        this.currentOffset = r0;
        this.competitor = 0;
        this.startOffset = r4.startOffset;
        this.endOffset = r4.endOffset;
        r0.set(r4.currentOffset.get());
        this.currentOffsetRead = r0.get();
        this.index = r4.index;
    }

    public Segment(JSONObject r3) {
        this.currentOffset = new AtomicLong();
        this.competitor = 0;
        this.startOffset = r3.optLong(JsonKey.START);
        setEndOffset(r3.optLong(JsonKey.END));
        setCurrentOffset(r3.optLong(JsonKey.CURRENT));
        setCurrentOffsetRead(getCurrentOffset());
    }

    public boolean isDownloaded() {
        if (this.endOffset >= this.startOffset) goto L5;
    L7:
        return false;
    L5:
        if (this.currentOffset.get() <= this.endOffset) goto L7;
        return true;
    }

    public long getDownloadBytes() {
        return this.currentOffset.get() - this.startOffset;
    }

    public long getRemainDownloadBytes() {
        long r0 = this.endOffset;
        if (r0 >= this.startOffset) goto L5;
        return -1;
    L5:
        return (r0 - this.currentOffset.get()) + 1;
    }

    public boolean isReadFinish() {
        if (this.endOffset >= this.startOffset) goto L5;
    L7:
        return false;
    L5:
        if (getCurrentOffsetRead() <= this.endOffset) goto L7;
        return true;
    }

    public long getReadBytes() {
        return getCurrentOffsetRead() - this.startOffset;
    }

    public long getRemainReadBytes() {
        long r0 = this.endOffset;
        if (r0 >= this.startOffset) goto L5;
        return -1;
    L5:
        return (r0 - getCurrentOffsetRead()) + 1;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public long getCurrentOffset() {
        long r0 = this.currentOffset.get();
        long r2 = this.endOffset;
        if (r2 <= 0) goto L7;
        long r3 = r2 + 1;
        if (r0 <= r3) goto L7;
        return r3;
    L7:
        return r0;
    }

    public long getCurrentOffsetRead() {
        SegmentReader r0 = this.owner;
        if (r0 == null) goto L8;
        long r1 = r0.getCurSegmentReadOffset();
        if (r1 <= this.currentOffsetRead) goto L8;
        return r1;
    L8:
        return this.currentOffsetRead;
    }

    public void setCurrentOffset(long r5) {
        long r0 = this.startOffset;
        if (r5 >= r0) goto L5;
        r5 = r0;
    L5:
        long r1 = this.endOffset;
        if (r1 <= 0) goto L10;
        long r2 = r1 + 1;
        if (r5 <= r2) goto L10;
        r5 = r2;
    L10:
        this.currentOffset.set(r5);
    }

    void increaseCurrentOffset(long r1) {
        this.currentOffset.addAndGet(r1);
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    void setEndOffset(long r4) {
        if (r4 < this.startOffset) goto L6;
        this.endOffset = r4;
        return;
    L6:
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug(TAG, "setEndOffset", "EndOffset = " + r4 + ", segment = " + this);
    L9:
        if (r4 != (-1)) goto L13;
        this.endOffset = r4;
        return;
    }

    public void setCurrentOffsetRead(long r3) {
        if (r3 < this.currentOffset.get()) goto L6;
        this.currentOffsetRead = r3;
        return;
    }

    public int getIndex() {
        return this.index;
    }

    void setIndex(int r1) {
        this.index = r1;
    }

    void increaseCompetitor() {
        this.competitor++;
    }

    void decreaseCompetitor() {
        this.competitor--;
    }

    int getCompetitor() {
        return this.competitor;
    }

    void setCompetitor(int r1) {
        this.competitor = r1;
    }

    public String toString() {
        return "Segment{startOffset=" + this.startOffset + ",\t currentOffset=" + this.currentOffset + ",\t currentOffsetRead=" + getCurrentOffsetRead() + ",\t endOffset=" + this.endOffset + '}';
    }

    public static String toString(List<Segment> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.isEmpty() == true) goto L16;
        Collections.sort(r5, new AnonymousClass1());
        StringBuilder r0 = new StringBuilder();
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L12;
        r0.append((Segment) ZeusTransformUtils.preCheckCast(r6.next(), Segment.class, "com.obric.aiagent.plugin")).append("\r\n");
        goto L9
    L12:
        return r0.toString();
    L16:
        return null;
    }

    public JSONObject toJson() {
        JSONObject r0 = this.jsonObject;
        if (r0 != null) goto L5;
        r0 = new JSONObject();
        this.jsonObject = r0;
    L5:
        r0.put(JsonKey.START, getStartOffset());
        r0.put(JsonKey.CURRENT, getCurrentOffset());
        r0.put(JsonKey.END, getEndOffset());
        return r0;
    }
}
