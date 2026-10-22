package fb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.io.EOFException;
import kb.C4845d;
import kb.InterfaceC4843b;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\rH\u0017¢\u0006\u0004\b\u001d\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J)\u0010\"\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0000¢\u0006\u0004\b$\u0010\u001cJ\u0018\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\r¢\u0006\u0004\b(\u0010\u0004J\u0017\u0010)\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b)\u0010\u000fJ'\u0010,\u001a\u00020\u00182\u0006\u0010+\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020\r2\u0006\u0010+\u001a\u0002002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u00020\u00052\u0006\u0010+\u001a\u000200H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0001H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u0002082\u0006\u00107\u001a\u00020\u0018H\u0001¢\u0006\u0004\b9\u0010:J'\u0010<\u001a\u00020\r2\u0006\u0010;\u001a\u00020*2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018H\u0016¢\u0006\u0004\b<\u0010=J\u001f\u0010?\u001a\u00020\r2\u0006\u0010;\u001a\u00020>2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b?\u0010@J\u001f\u0010<\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b<\u0010AJ\u0017\u0010B\u001a\u00020\u00052\u0006\u0010;\u001a\u00020>H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0012H\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\r2\u0006\u0010G\u001a\u00020\u0015H\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u0018H\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020\r2\u0006\u0010M\u001a\u00020\u0005H\u0016¢\u0006\u0004\bN\u0010\u000fJ\r\u0010O\u001a\u00020\u0000¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\rH\u0016¢\u0006\u0004\bQ\u0010\u0004J\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u00020\rH\u0000¢\u0006\u0004\bU\u0010\u0004J\u000f\u0010V\u001a\u00020\rH\u0001¢\u0006\u0004\bV\u0010\u0004R*\u0010^\u001a\u0004\u0018\u0001088\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bW\u0010X\u0012\u0004\b]\u0010\u0004\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010b\u001a\u0004\u0018\u0001088\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b(\u0010X\u0012\u0004\ba\u0010\u0004\u001a\u0004\b_\u0010Z\"\u0004\b`\u0010\\R(\u0010g\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bc\u0010U\u0012\u0004\bf\u0010\u0004\u001a\u0004\bd\u0010\u001c\"\u0004\be\u0010\u000fR\u0011\u0010i\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bh\u0010\u001cR\u001a\u0010k\u001a\u00020\u00008VX\u0097\u0004¢\u0006\f\u0012\u0004\bj\u0010\u0004\u001a\u0004\bW\u0010P¨\u0006l"}, d2 = {"Lfb/a;", "Lfb/v;", "Lfb/s;", "<init>", "()V", "", "byteCount", "", "g0", "(J)Ljava/lang/Void;", "", "k", "()Z", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "", "readInt", "()I", "readLong", "()J", "X", "flush", "out", "startIndex", "endIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lfb/a;JJ)V", "e", "position", "l", "(J)B", Const.INTENT_KEY_PKGNAME, "skip", "", "sink", "G0", "([BII)I", "readAtMostTo", "(Lfb/a;J)J", "Lfb/j;", "E0", "(Lfb/j;J)V", "B", "(Lfb/j;)J", "peek", "()Lfb/v;", "minimumCapacity", "Lfb/o;", "k0", "(I)Lfb/o;", "source", "write", "([BII)V", "Lfb/k;", "t0", "(Lfb/k;J)V", "(Lfb/a;J)V", "m0", "(Lfb/k;)J", "byte", "H0", "(B)V", "short", "writeShort", "(S)V", "int", "writeInt", "(I)V", "long", "writeLong", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lfb/a;", "close", "", "toString", "()Ljava/lang/String;", "J", "U", Const.INTENT_KEY_APIKEY, "Lfb/o;", "m", "()Lfb/o;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Lfb/o;)V", "getHead$annotations", "head", "G", "e0", "getTail$annotations", "tail", "c", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Y", "getSizeMut$annotations", "sizeMut", "n", ContentDisposition.Parameters.Size, "getBuffer$annotations", "buffer", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: fb.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4074a implements v, s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public o head;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public o tail;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long sizeMut;

    /* renamed from: A, reason: from getter */
    public final /* synthetic */ long getSizeMut() {
        return this.sizeMut;
    }

    @Override // fb.v
    public long B(InterfaceC4083j sink) {
        kotlin.jvm.internal.p.i(sink, "sink");
        long jN = n();
        if (jN > 0) {
            sink.write(this, jN);
        }
        return jN;
    }

    @Override // fb.v
    public void E0(InterfaceC4083j sink, long byteCount) throws EOFException {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
        }
        if (n() >= byteCount) {
            sink.write(this, byteCount);
            return;
        }
        sink.write(this, n());
        throw new EOFException("Buffer exhausted before writing " + byteCount + " bytes. Only " + n() + " bytes were written.");
    }

    /* renamed from: G, reason: from getter */
    public final /* synthetic */ o getTail() {
        return this.tail;
    }

    @Override // fb.v
    public int G0(byte[] sink, int startIndex, int endIndex) {
        kotlin.jvm.internal.p.i(sink, "sink");
        z.a(sink.length, startIndex, endIndex);
        o oVar = this.head;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(endIndex - startIndex, oVar.j());
        oVar.r(sink, startIndex, startIndex + iMin);
        this.sizeMut -= iMin;
        if (q.b(oVar)) {
            J();
        }
        return iMin;
    }

    @Override // fb.s
    public void H0(byte b10) {
        k0(1).E(b10);
        this.sizeMut++;
    }

    public final void J() {
        o oVar = this.head;
        kotlin.jvm.internal.p.f(oVar);
        o next = oVar.getNext();
        this.head = next;
        if (next == null) {
            this.tail = null;
        } else {
            next.v(null);
        }
        oVar.t(null);
        r.d(oVar);
    }

    public final /* synthetic */ void U() {
        o oVar = this.tail;
        kotlin.jvm.internal.p.f(oVar);
        o prev = oVar.getPrev();
        this.tail = prev;
        if (prev == null) {
            this.head = null;
        } else {
            prev.t(null);
        }
        oVar.v(null);
        r.d(oVar);
    }

    public final /* synthetic */ void V(o oVar) {
        this.head = oVar;
    }

    @Override // fb.s
    public void X() {
    }

    public final /* synthetic */ void Y(long j10) {
        this.sizeMut = j10;
    }

    @Override // fb.v, fb.s
    public C4074a a() {
        return this;
    }

    public final void b() throws EOFException {
        skip(n());
    }

    @Override // fb.InterfaceC4084k, java.lang.AutoCloseable, fb.InterfaceC4083j
    public void close() {
    }

    public final long e() {
        long jN = n();
        if (jN == 0) {
            return 0L;
        }
        o oVar = this.tail;
        kotlin.jvm.internal.p.f(oVar);
        return (oVar.getLimit() >= 8192 || !oVar.owner) ? jN : jN - (oVar.getLimit() - oVar.getPos());
    }

    public final /* synthetic */ void e0(o oVar) {
        this.tail = oVar;
    }

    @Override // fb.s, fb.InterfaceC4083j, java.io.Flushable
    public void flush() {
    }

    public final C4074a g() {
        C4074a c4074a = new C4074a();
        if (n() == 0) {
            return c4074a;
        }
        o oVar = this.head;
        kotlin.jvm.internal.p.f(oVar);
        o oVarA = oVar.A();
        c4074a.head = oVarA;
        c4074a.tail = oVarA;
        for (o next = oVar.getNext(); next != null; next = next.getNext()) {
            o oVar2 = c4074a.tail;
            kotlin.jvm.internal.p.f(oVar2);
            c4074a.tail = oVar2.m(next.A());
        }
        c4074a.sizeMut = n();
        return c4074a;
    }

    public final Void g0(long byteCount) throws EOFException {
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + n() + ", required: " + byteCount + ')');
    }

    public final void i(C4074a out, long startIndex, long endIndex) {
        kotlin.jvm.internal.p.i(out, "out");
        z.a(n(), startIndex, endIndex);
        if (startIndex == endIndex) {
            return;
        }
        long limit = endIndex - startIndex;
        out.sizeMut += limit;
        o next = this.head;
        long limit2 = startIndex;
        while (true) {
            kotlin.jvm.internal.p.f(next);
            if (limit2 < next.getLimit() - next.getPos()) {
                break;
            }
            limit2 -= next.getLimit() - next.getPos();
            next = next.getNext();
        }
        while (limit > 0) {
            kotlin.jvm.internal.p.f(next);
            o oVarA = next.A();
            oVarA.u(oVarA.getPos() + ((int) limit2));
            oVarA.s(Math.min(oVarA.getPos() + ((int) limit), oVarA.getLimit()));
            if (out.getHead() == null) {
                out.V(oVarA);
                out.e0(oVarA);
            } else {
                o tail = out.getTail();
                kotlin.jvm.internal.p.f(tail);
                out.e0(tail.m(oVarA));
            }
            limit -= oVarA.getLimit() - oVarA.getPos();
            next = next.getNext();
            limit2 = 0;
        }
    }

    @Override // fb.v
    public void j(long byteCount) throws EOFException {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (n() >= byteCount) {
            return;
        }
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + n() + ", required: " + byteCount + ')');
    }

    @Override // fb.v
    public boolean k() {
        return n() == 0;
    }

    public final /* synthetic */ o k0(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException(("unexpected capacity (" + minimumCapacity + "), should be in range [1, 8192]").toString());
        }
        o oVar = this.tail;
        if (oVar == null) {
            o oVarF = r.f();
            this.head = oVarF;
            this.tail = oVarF;
            return oVarF;
        }
        kotlin.jvm.internal.p.f(oVar);
        if (oVar.getLimit() + minimumCapacity <= 8192 && oVar.owner) {
            return oVar;
        }
        o oVarM = oVar.m(r.f());
        this.tail = oVarM;
        return oVarM;
    }

    public final byte l(long position) {
        long j10 = 0;
        if (position < 0 || position >= n()) {
            throw new IndexOutOfBoundsException("position (" + position + ") is not within the range [0..size(" + n() + "))");
        }
        if (position == 0) {
            o oVar = this.head;
            kotlin.jvm.internal.p.f(oVar);
            return oVar.k(0);
        }
        if (getHead() == null) {
            kotlin.jvm.internal.p.f(null);
            throw null;
        }
        if (n() - position >= position) {
            o head = getHead();
            while (head != null) {
                long limit = (head.getLimit() - head.getPos()) + j10;
                if (limit > position) {
                    break;
                }
                head = head.getNext();
                j10 = limit;
            }
            kotlin.jvm.internal.p.f(head);
            return head.k((int) (position - j10));
        }
        o tail = getTail();
        long jN = n();
        while (tail != null && jN > position) {
            jN -= tail.getLimit() - tail.getPos();
            if (jN <= position) {
                break;
            }
            tail = tail.getPrev();
        }
        kotlin.jvm.internal.p.f(tail);
        return tail.k((int) (position - jN));
    }

    /* renamed from: m, reason: from getter */
    public final /* synthetic */ o getHead() {
        return this.head;
    }

    @Override // fb.s
    public long m0(InterfaceC4084k source) {
        kotlin.jvm.internal.p.i(source, "source");
        long j10 = 0;
        while (true) {
            long atMostTo = source.readAtMostTo(this, 8192L);
            if (atMostTo == -1) {
                return j10;
            }
            j10 += atMostTo;
        }
    }

    public final long n() {
        return this.sizeMut;
    }

    @Override // fb.v
    public v peek() {
        return C4078e.b(new C4082i(this));
    }

    @Override // fb.InterfaceC4084k
    public long readAtMostTo(C4074a sink, long byteCount) {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
        }
        if (n() == 0) {
            return -1L;
        }
        if (byteCount > n()) {
            byteCount = n();
        }
        sink.write(this, byteCount);
        return byteCount;
    }

    @Override // fb.v
    public byte readByte() throws EOFException {
        o oVar = this.head;
        if (oVar == null) {
            g0(1L);
            throw new KotlinNothingValueException();
        }
        int iJ = oVar.j();
        if (iJ == 0) {
            J();
            return readByte();
        }
        byte bN = oVar.n();
        this.sizeMut--;
        if (iJ == 1) {
            J();
        }
        return bN;
    }

    @Override // fb.v
    public int readInt() throws EOFException {
        o oVar = this.head;
        if (oVar == null) {
            g0(4L);
            throw new KotlinNothingValueException();
        }
        int iJ = oVar.j();
        if (iJ >= 4) {
            int iO = oVar.o();
            this.sizeMut -= 4;
            if (iJ == 4) {
                J();
            }
            return iO;
        }
        j(4L);
        if (iJ == 0) {
            J();
            return readInt();
        }
        return (readShort() & 65535) | (readShort() << 16);
    }

    @Override // fb.v
    public long readLong() throws EOFException {
        o oVar = this.head;
        if (oVar == null) {
            g0(8L);
            throw new KotlinNothingValueException();
        }
        int iJ = oVar.j();
        if (iJ < 8) {
            j(8L);
            if (iJ != 0) {
                return (readInt() << 32) | (readInt() & 4294967295L);
            }
            J();
            return readLong();
        }
        long jP = oVar.p();
        this.sizeMut -= 8;
        if (iJ == 8) {
            J();
        }
        return jP;
    }

    @Override // fb.v
    public short readShort() throws EOFException {
        o oVar = this.head;
        if (oVar == null) {
            g0(2L);
            throw new KotlinNothingValueException();
        }
        int iJ = oVar.j();
        if (iJ >= 2) {
            short sQ = oVar.q();
            this.sizeMut -= 2;
            if (iJ == 2) {
                J();
            }
            return sQ;
        }
        j(2L);
        if (iJ == 0) {
            J();
            return readShort();
        }
        return (short) ((readByte() & 255) | ((readByte() & 255) << 8));
    }

    @Override // fb.v
    public boolean request(long byteCount) {
        if (byteCount >= 0) {
            return n() >= byteCount;
        }
        throw new IllegalArgumentException(("byteCount: " + byteCount + " < 0").toString());
    }

    public void skip(long byteCount) throws EOFException {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
        }
        long j10 = byteCount;
        while (j10 > 0) {
            o oVar = this.head;
            if (oVar == null) {
                throw new EOFException("Buffer exhausted before skipping " + byteCount + " bytes.");
            }
            int iMin = (int) Math.min(j10, oVar.getLimit() - oVar.getPos());
            long j11 = iMin;
            this.sizeMut -= j11;
            j10 -= j11;
            oVar.u(oVar.getPos() + iMin);
            if (oVar.getPos() == oVar.getLimit()) {
                J();
            }
        }
    }

    @Override // fb.s
    public void t0(InterfaceC4084k source, long byteCount) throws EOFException {
        kotlin.jvm.internal.p.i(source, "source");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount (" + byteCount + ") < 0").toString());
        }
        long j10 = byteCount;
        while (j10 > 0) {
            long atMostTo = source.readAtMostTo(this, j10);
            if (atMostTo == -1) {
                throw new EOFException("Source exhausted before reading " + byteCount + " bytes. Only " + (byteCount - j10) + " were read.");
            }
            j10 -= atMostTo;
        }
    }

    public String toString() {
        if (n() == 0) {
            return "Buffer(size=0)";
        }
        long j10 = 64;
        int iMin = (int) Math.min(j10, n());
        StringBuilder sb2 = new StringBuilder((iMin * 2) + (n() > j10 ? 1 : 0));
        C4845d c4845d = C4845d.f34666a;
        int i10 = 0;
        for (o head = getHead(); head != null; head = head.getNext()) {
            InterfaceC4843b interfaceC4843b = kb.e.f34667a;
            int i11 = 0;
            while (i10 < iMin && i11 < head.j()) {
                int i12 = i11 + 1;
                byte bA = interfaceC4843b.a(head, i11);
                i10++;
                sb2.append(z.c()[(bA >> 4) & 15]);
                sb2.append(z.c()[bA & 15]);
                i11 = i12;
            }
        }
        if (n() > j10) {
            sb2.append((char) 8230);
        }
        return "Buffer(size=" + n() + " hex=" + ((Object) sb2) + ')';
    }

    @Override // fb.s
    public void write(byte[] source, int startIndex, int endIndex) {
        kotlin.jvm.internal.p.i(source, "source");
        z.a(source.length, startIndex, endIndex);
        int i10 = startIndex;
        while (i10 < endIndex) {
            o oVarK0 = k0(1);
            int iMin = Math.min(endIndex - i10, oVarK0.h()) + i10;
            oVarK0.C(source, i10, iMin);
            i10 = iMin;
        }
        this.sizeMut += endIndex - startIndex;
    }

    @Override // fb.s
    public void writeInt(int i10) {
        k0(4).F(i10);
        this.sizeMut += 4;
    }

    @Override // fb.s
    public void writeLong(long j10) {
        k0(8).G(j10);
        this.sizeMut += 8;
    }

    @Override // fb.s
    public void writeShort(short s10) {
        k0(2).H(s10);
        this.sizeMut += 2;
    }

    @Override // fb.InterfaceC4083j
    public void write(C4074a source, long byteCount) {
        kotlin.jvm.internal.p.i(source, "source");
        if (source != this) {
            z.b(source.sizeMut, 0L, byteCount);
            while (byteCount > 0) {
                kotlin.jvm.internal.p.f(source.head);
                if (byteCount < r0.j()) {
                    o oVar = this.tail;
                    if (oVar != null && oVar.owner) {
                        if ((oVar.getLimit() + byteCount) - (oVar.i() ? 0 : oVar.getPos()) <= 8192) {
                            o oVar2 = source.head;
                            kotlin.jvm.internal.p.f(oVar2);
                            oVar2.I(oVar, (int) byteCount);
                            source.sizeMut -= byteCount;
                            this.sizeMut += byteCount;
                            return;
                        }
                    }
                    o oVar3 = source.head;
                    kotlin.jvm.internal.p.f(oVar3);
                    source.head = oVar3.B((int) byteCount);
                }
                o oVar4 = source.head;
                kotlin.jvm.internal.p.f(oVar4);
                long j10 = oVar4.j();
                o oVarL = oVar4.l();
                source.head = oVarL;
                if (oVarL == null) {
                    source.tail = null;
                }
                if (getHead() == null) {
                    V(oVar4);
                    e0(oVar4);
                } else {
                    o tail = getTail();
                    kotlin.jvm.internal.p.f(tail);
                    e0(tail.m(oVar4).a());
                    o tail2 = getTail();
                    kotlin.jvm.internal.p.f(tail2);
                    if (tail2.getPrev() == null) {
                        V(getTail());
                    }
                }
                source.sizeMut -= j10;
                this.sizeMut += j10;
                byteCount -= j10;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }
}
