package com.ss.bduploader.net;

import com.ss.bduploader.s;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class BDUploadDNSParserBridge implements d {
    private static final String TAG = "BDUploadDNSParserBridge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f37505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f37506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Lock f37507c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f37508d;

    private static native void _notifyParserResult(long r0, String r2, String r3, long r4, String r6);

    public BDUploadDNSParserBridge() {
        this.f37506b = null;
        this.f37505a = false;
        this.f37507c = new ReentrantLock();
        this.f37508d = 0;
    }

    @Override // com.ss.bduploader.net.d
    public void a(int r10, String r11, String r12, long r13, String r15) {
        this.f37507c.lock();
    L12:
        th = move-exception;
        this.f37507c.unlock();
        throw th;
    L5:
        if (this.f37505a == true) goto L9;
        s.c(TAG, String.format("receive completion code:%d result:%s", new Object[]{Integer.valueOf(r10), r12}));     // Catch: Throwable -> L12
        this.f37506b = r12;     // Catch: Throwable -> L12
        this.f37505a = true;     // Catch: Throwable -> L12
        long r2 = this.f37508d;     // Catch: Throwable -> L12
        if (r2 == 0) goto L10;
        _notifyParserResult(r2, r11, r12, r13, r15);     // Catch: Throwable -> L12
    L10:
        this.f37507c.unlock();
        return;
    L9:
        s.c(TAG, String.format("has finished not nedd cur completion code:%d result:%s expiredTime:%lld", new Object[]{Integer.valueOf(r10), r12, Long.valueOf(r13)}));     // Catch: Throwable -> L12
        goto L10
    }
}
