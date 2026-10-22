package Mb;

import Z8.C1168p;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\u0017B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u001d\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001cR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"LMb/E;", "", "<init>", "()V", "", "data", "", "pos", "limit", "", "shared", "owner", "([BIIZZ)V", Const.INTENT_KEY_UMID, "()LMb/E;", Const.INTENT_KEY_PKGNAME, "segment", "c", "(LMb/E;)LMb/E;", "byteCount", "e", "(I)LMb/E;", "LY8/t;", Const.INTENT_KEY_APIKEY, "sink", "f", "(LMb/E;I)V", "[B", "I", "Z", "LMb/E;", "next", Const.INTENT_KEY_BACKGROUND_COMMAND, "prev", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final byte[] data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int pos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int limit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean shared;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean owner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public E next;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public E prev;

    public E() {
        this.data = new byte[com.stepos.agentframework.chatui.longtext.b.THRESHOLD];
        this.owner = true;
        this.shared = false;
    }

    public final void a() {
        int i10;
        E e10 = this.prev;
        if (e10 == this) {
            throw new IllegalStateException("cannot compact");
        }
        kotlin.jvm.internal.p.f(e10);
        if (e10.owner) {
            int i11 = this.limit - this.pos;
            E e11 = this.prev;
            kotlin.jvm.internal.p.f(e11);
            int i12 = 8192 - e11.limit;
            E e12 = this.prev;
            kotlin.jvm.internal.p.f(e12);
            if (e12.shared) {
                i10 = 0;
            } else {
                E e13 = this.prev;
                kotlin.jvm.internal.p.f(e13);
                i10 = e13.pos;
            }
            if (i11 > i12 + i10) {
                return;
            }
            E e14 = this.prev;
            kotlin.jvm.internal.p.f(e14);
            f(e14, i11);
            b();
            F.b(this);
        }
    }

    public final E b() {
        E e10 = this.next;
        if (e10 == this) {
            e10 = null;
        }
        E e11 = this.prev;
        kotlin.jvm.internal.p.f(e11);
        e11.next = this.next;
        E e12 = this.next;
        kotlin.jvm.internal.p.f(e12);
        e12.prev = this.prev;
        this.next = null;
        this.prev = null;
        return e10;
    }

    public final E c(E segment) {
        kotlin.jvm.internal.p.i(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        E e10 = this.next;
        kotlin.jvm.internal.p.f(e10);
        e10.prev = segment;
        this.next = segment;
        return segment;
    }

    public final E d() {
        this.shared = true;
        return new E(this.data, this.pos, this.limit, true, false);
    }

    public final E e(int byteCount) {
        E eC;
        if (byteCount <= 0 || byteCount > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (byteCount >= 1024) {
            eC = d();
        } else {
            eC = F.c();
            byte[] bArr = this.data;
            byte[] bArr2 = eC.data;
            int i10 = this.pos;
            C1168p.j(bArr, bArr2, 0, i10, i10 + byteCount, 2, null);
        }
        eC.limit = eC.pos + byteCount;
        this.pos += byteCount;
        E e10 = this.prev;
        kotlin.jvm.internal.p.f(e10);
        e10.c(eC);
        return eC;
    }

    public final void f(E sink, int byteCount) {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        int i10 = sink.limit;
        if (i10 + byteCount > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i11 = sink.pos;
            if ((i10 + byteCount) - i11 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            C1168p.j(bArr, bArr, 0, i11, i10, 2, null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i12 = sink.limit;
        int i13 = this.pos;
        C1168p.e(bArr2, bArr3, i12, i13, i13 + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    public E(byte[] data, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(data, "data");
        this.data = data;
        this.pos = i10;
        this.limit = i11;
        this.shared = z10;
        this.owner = z11;
    }
}
