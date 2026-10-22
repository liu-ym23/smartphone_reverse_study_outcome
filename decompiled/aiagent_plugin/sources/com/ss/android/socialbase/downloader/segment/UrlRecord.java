package com.ss.android.socialbase.downloader.segment;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
class UrlRecord {
    private final AtomicLong downloadBytes;
    private int failedTimes;
    private int hashCode;
    final String ip;
    final String ipFamily;
    private boolean isCurrentFailed;
    final boolean isMainUrl;
    private String key;
    private final List<SegmentReader> readers;
    final String url;

    public UrlRecord(String r2, boolean r3) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = r2;
        this.isMainUrl = r3;
        this.ip = null;
        this.ipFamily = null;
    }

    public UrlRecord(String r2, String r3) {
        this.readers = new ArrayList();
        this.downloadBytes = new AtomicLong();
        this.url = r2;
        this.isMainUrl = false;
        this.ip = r3;
        this.ipFamily = getIpFamily(r3);
    }

    private String getIpFamily(String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L16;
        int r1 = r2.lastIndexOf(".");     // Catch: Throwable -> L10
        if (r1 > 0) goto L7;
        return null;
    L7:
        if (r1 >= r2.length()) goto L18;
        return r2.substring(0, r1);
    L18:
        return null;
    L10:
        th = move-exception;
        th.printStackTrace();
        return null;
    L16:
        return null;
    }

    public synchronized void recordUse(SegmentReader r2) {
        monitor-enter(this);
        this.readers.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void recordUnUse(SegmentReader r2) {
        monitor-enter(this);
        this.readers.remove(r2);     // Catch: Throwable -> L6
    L4:
        monitor-exit(this);
    }

    public synchronized int getCurrentUsers() {
        monitor-enter(this);
        int r0 = this.readers.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void recordFailed() {
        monitor-enter(this);
        this.failedTimes++;     // Catch: Throwable -> L6
        this.isCurrentFailed = true;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void recordSucceed() {
        monitor-enter(this);
        this.isCurrentFailed = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isCurrentFailed() {
        monitor-enter(this);
        boolean r0 = this.isCurrentFailed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void increaseDownloadBytes(long r1) {
        this.downloadBytes.addAndGet(r1);
    }

    public long getDownloadBytes() {
        long r0 = this.downloadBytes.get();
        Iterator<SegmentReader> r5 = this.readers.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 + ((SegmentReader) ZeusTransformUtils.preCheckCast(r5.next(), SegmentReader.class, "com.obric.aiagent.plugin")).getReadingBytes();
        goto L4
    L6:
        return r0;
    }

    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        this.hashCode = getKey().hashCode();
    L6:
        return this.hashCode;
    }

    private String getKey() {
        if (this.key != null) goto L9;
        StringBuilder r0 = new StringBuilder().append(this.url).append("_");
        String r2 = this.ip;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        this.key = r0.append(r2).append("_").append(this.isMainUrl).toString();
    L9:
        return this.key;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, UrlRecord.class) == true) goto L11;
        return false;
    L11:
        return getKey().equals(((UrlRecord) ZeusTransformUtils.preCheckCast(r3, UrlRecord.class, "com.obric.aiagent.plugin")).getKey());
    }

    public String toString() {
        return "UrlRecord{url='" + this.url + "', ip='" + this.ip + "', ipFamily='" + this.ipFamily + "', isMainUrl=" + this.isMainUrl + ", failedTimes=" + this.failedTimes + ", isCurrentFailed=" + this.isCurrentFailed + '}';
    }
}
