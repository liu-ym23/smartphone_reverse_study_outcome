package Mb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"LMb/A;", "LMb/I;", "LMb/f;", "upstream", "<init>", "(LMb/f;)V", "LMb/d;", "sink", "", "byteCount", "u0", "(LMb/d;J)J", "LMb/J;", "c", "()LMb/J;", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "LMb/f;", Const.INTENT_KEY_PKGNAME, "LMb/d;", "buffer", "LMb/E;", "LMb/E;", "expectedSegment", "", Const.INTENT_KEY_UMID, "I", "expectedPos", "", "e", "Z", AlipayXuiIsland.REASON_CLOSED, "f", "J", "pos", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class A implements I {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC0968f upstream;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C0966d buffer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public E expectedSegment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int expectedPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long pos;

    public A(InterfaceC0968f upstream) {
        kotlin.jvm.internal.p.i(upstream, "upstream");
        this.upstream = upstream;
        C0966d c0966dA = upstream.getBufferField();
        this.buffer = c0966dA;
        E e10 = c0966dA.head;
        this.expectedSegment = e10;
        this.expectedPos = e10 != null ? e10.pos : -1;
    }

    @Override // Mb.I
    public J c() {
        return this.upstream.c();
    }

    @Override // Mb.I, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r4.pos) goto L15;
     */
    @Override // Mb.I
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long u0(Mb.C0966d r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.p.i(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L74
            boolean r3 = r8.closed
            if (r3 != 0) goto L6c
            Mb.E r3 = r8.expectedSegment
            if (r3 == 0) goto L2b
            Mb.d r4 = r8.buffer
            Mb.E r4 = r4.head
            if (r3 != r4) goto L23
            int r3 = r8.expectedPos
            kotlin.jvm.internal.p.f(r4)
            int r4 = r4.pos
            if (r3 != r4) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Peek source is invalid because upstream source was used"
            r8.<init>(r9)
            throw r8
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            Mb.f r0 = r8.upstream
            long r1 = r8.pos
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L3e
            r8 = -1
            return r8
        L3e:
            Mb.E r0 = r8.expectedSegment
            if (r0 != 0) goto L51
            Mb.d r0 = r8.buffer
            Mb.E r0 = r0.head
            if (r0 == 0) goto L51
            r8.expectedSegment = r0
            kotlin.jvm.internal.p.f(r0)
            int r0 = r0.pos
            r8.expectedPos = r0
        L51:
            Mb.d r0 = r8.buffer
            long r0 = r0.getSize()
            long r2 = r8.pos
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            Mb.d r2 = r8.buffer
            long r4 = r8.pos
            r3 = r9
            r2.V(r3, r4, r6)
            long r9 = r8.pos
            long r9 = r9 + r6
            r8.pos = r9
            return r6
        L6c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "closed"
            r8.<init>(r9)
            throw r8
        L74:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "byteCount < 0: "
            r8.append(r9)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: Mb.A.u0(Mb.d, long):long");
    }
}
