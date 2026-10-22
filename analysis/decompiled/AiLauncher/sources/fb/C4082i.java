package fb;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lfb/i;", "Lfb/k;", "Lfb/v;", "upstream", "<init>", "(Lfb/v;)V", "Lfb/a;", "sink", "", "byteCount", "readAtMostTo", "(Lfb/a;J)J", "LY8/t;", "close", "()V", Const.INTENT_KEY_APIKEY, "Lfb/v;", Const.INTENT_KEY_PKGNAME, "Lfb/a;", "getBuffer$annotations", "buffer", "Lfb/o;", "c", "Lfb/o;", "expectedSegment", "", Const.INTENT_KEY_UMID, "I", "expectedPos", "", "e", "Z", AlipayXuiIsland.REASON_CLOSED, "f", "J", "pos", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4082i implements InterfaceC4084k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final v upstream;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C4074a buffer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public o expectedSegment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int expectedPos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public long pos;

    public C4082i(v upstream) {
        kotlin.jvm.internal.p.i(upstream, "upstream");
        this.upstream = upstream;
        C4074a c4074aA = upstream.getBufferField();
        this.buffer = c4074aA;
        this.expectedSegment = c4074aA.getHead();
        o head = c4074aA.getHead();
        this.expectedPos = head != null ? head.getPos() : -1;
    }

    @Override // fb.InterfaceC4084k, java.lang.AutoCloseable, fb.InterfaceC4083j
    public void close() {
        this.closed = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
    
        if (r3 == r4.getPos()) goto L15;
     */
    @Override // fb.InterfaceC4084k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long readAtMostTo(fb.C4074a r7, long r8) {
        /*
            r6 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.p.i(r7, r0)
            boolean r0 = r6.closed
            if (r0 != 0) goto La8
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 < 0) goto L88
            fb.o r3 = r6.expectedSegment
            if (r3 == 0) goto L35
            fb.a r4 = r6.buffer
            fb.o r4 = r4.getHead()
            if (r3 != r4) goto L2d
            int r3 = r6.expectedPos
            fb.a r4 = r6.buffer
            fb.o r4 = r4.getHead()
            kotlin.jvm.internal.p.f(r4)
            int r4 = r4.getPos()
            if (r3 != r4) goto L2d
            goto L35
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Peek source is invalid because upstream source was used"
            r6.<init>(r7)
            throw r6
        L35:
            if (r2 != 0) goto L38
            return r0
        L38:
            fb.v r0 = r6.upstream
            long r1 = r6.pos
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L48
            r6 = -1
            return r6
        L48:
            fb.o r0 = r6.expectedSegment
            if (r0 != 0) goto L6b
            fb.a r0 = r6.buffer
            fb.o r0 = r0.getHead()
            if (r0 == 0) goto L6b
            fb.a r0 = r6.buffer
            fb.o r0 = r0.getHead()
            r6.expectedSegment = r0
            fb.a r0 = r6.buffer
            fb.o r0 = r0.getHead()
            kotlin.jvm.internal.p.f(r0)
            int r0 = r0.getPos()
            r6.expectedPos = r0
        L6b:
            fb.a r0 = r6.buffer
            long r0 = r0.n()
            long r2 = r6.pos
            long r0 = r0 - r2
            long r8 = java.lang.Math.min(r8, r0)
            fb.a r0 = r6.buffer
            long r2 = r6.pos
            long r4 = r2 + r8
            r1 = r7
            r0.i(r1, r2, r4)
            long r0 = r6.pos
            long r0 = r0 + r8
            r6.pos = r0
            return r8
        L88:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "byteCount ("
            r6.append(r7)
            r6.append(r8)
            java.lang.String r7 = ") < 0"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        La8:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Source is closed."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fb.C4082i.readAtMostTo(fb.a, long):long");
    }
}
