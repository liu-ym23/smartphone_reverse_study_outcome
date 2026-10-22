package com.stepos.common.utils.filestorage.internal;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/common/utils/filestorage/internal/a;", "", "Ljava/util/concurrent/atomic/AtomicLong;", "global", "", "weight", "<init>", "(Ljava/util/concurrent/atomic/AtomicLong;J)V", "LY8/t;", "c", "()V", "delta", Const.INTENT_KEY_UMID, "(J)V", Const.INTENT_KEY_PKGNAME, "", Const.INTENT_KEY_APIKEY, "()I", "Ljava/util/concurrent/atomic/AtomicLong;", "J", "attemptBytes", "maxContributed", "utils_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    private long attemptBytes;
    private final AtomicLong global;
    private volatile long maxContributed;
    private final long weight;

    public a(AtomicLong global, long j10) {
        p.i(global, "global");
        this.global = global;
        this.weight = j10;
    }

    public final int a() {
        return C5685n.n((int) ((this.maxContributed * 100) / C5685n.g(this.weight, 1L)), 0, 100);
    }

    public final void b() {
        long j10 = this.maxContributed;
        long j11 = this.weight;
        if (j10 < j11) {
            long j12 = j11 - this.maxContributed;
            this.maxContributed = this.weight;
            this.global.addAndGet(j12);
        }
    }

    public final void c() {
        this.attemptBytes = 0L;
    }

    public final void d(long delta) {
        long j10 = this.attemptBytes + delta;
        this.attemptBytes = j10;
        long jK = C5685n.k(j10, this.weight);
        if (jK > this.maxContributed) {
            long j11 = jK - this.maxContributed;
            this.maxContributed = jK;
            this.global.addAndGet(j11);
        }
    }
}
