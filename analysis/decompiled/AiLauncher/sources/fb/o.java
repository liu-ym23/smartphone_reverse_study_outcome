package fb;

import Z8.C1168p;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\bM\u0018\u0000 o2\u00020\u0001:\u0001\u0017B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003B3\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0002\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u000fJ\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0018H\u0000¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u001dH\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0000¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020$H\u0000¢\u0006\u0004\b.\u0010/J\u001f\u00101\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006H\u0000¢\u0006\u0004\b1\u00102J'\u00106\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u0006H\u0000¢\u0006\u0004\b6\u00107J'\u0010;\u001a\u00020\u001a2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0000¢\u0006\u0004\b;\u00107J\u0017\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u000bH\u0001¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u0006H\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00182\u0006\u0010B\u001a\u00020\u0006H\u0000¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0004\bF\u0010GJ'\u0010J\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u0018H\u0000¢\u0006\u0004\bJ\u0010KJ/\u0010M\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u0018H\u0000¢\u0006\u0004\bM\u0010NJ7\u0010P\u001a\u00020\u001a2\u0006\u0010B\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u00182\u0006\u0010O\u001a\u00020\u0018H\u0000¢\u0006\u0004\bP\u0010QR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010RR(\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\b=\u00101\u0012\u0004\bU\u0010\u0003\u001a\u0004\bS\u0010-\"\u0004\bT\u0010#R(\u0010\b\u001a\u00020\u00068\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bV\u00101\u0012\u0004\bY\u0010\u0003\u001a\u0004\bW\u0010-\"\u0004\bX\u0010#R$\u0010^\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bW\u0010Z\u001a\u0004\bV\u0010[\"\u0004\b\\\u0010]R\u0016\u0010\f\u001a\u00020\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b_\u0010`R*\u0010e\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bS\u0010a\u0012\u0004\bd\u0010\u0003\u001a\u0004\b_\u0010\u000f\"\u0004\bb\u0010cR*\u0010i\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0081\u000e¢\u0006\u0018\n\u0004\bf\u0010a\u0012\u0004\bh\u0010\u0003\u001a\u0004\bf\u0010\u000f\"\u0004\bg\u0010cR\u0014\u0010l\u001a\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0011\u0010n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bm\u0010-R\u0011\u0010p\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bo\u0010-¨\u0006q"}, d2 = {"Lfb/o;", "", "<init>", "()V", "", "data", "", "pos", "limit", "Lfb/p;", "shareToken", "", "owner", "([BIILfb/p;Z)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lfb/o;", "l", "segment", "m", "(Lfb/o;)Lfb/o;", "byteCount", "B", "(I)Lfb/o;", Const.INTENT_KEY_APIKEY, "", "byte", "LY8/t;", ExifInterface.LONGITUDE_EAST, "(B)V", "", "short", "H", "(S)V", "int", "F", "(I)V", "", "long", "G", "(J)V", "n", "()B", "q", "()S", "o", "()I", "p", "()J", "sink", "I", "(Lfb/o;I)V", "dst", "dstStartOffset", "dstEndOffset", "r", "([BII)V", "src", "srcStartOffset", "srcEndOffset", "C", "readOnly", Const.INTENT_KEY_PKGNAME, "(Z)[B", "bytesToCommit", "D", "([BI)V", "index", "k", "(I)B", UxipConstants.f30680s, "w", "(IB)V", "b0", "b1", "x", "(IBB)V", "b2", "y", "(IBBB)V", "b3", "z", "(IBBBB)V", "[B", "f", "u", "getPos$annotations", "c", Const.INTENT_KEY_UMID, "s", "getLimit$annotations", "Lfb/p;", "()Lfb/p;", "setCopyTracker$kotlinx_io_core", "(Lfb/p;)V", "copyTracker", "e", "Z", "Lfb/o;", "t", "(Lfb/o;)V", "getNext$annotations", "next", Const.INTENT_KEY_BACKGROUND_COMMAND, "v", "getPrev$annotations", "prev", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "shared", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, ContentDisposition.Parameters.Size, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "remainingCapacity", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class o {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final byte[] data;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int pos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int limit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public p copyTracker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean owner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public o next;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public o prev;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J9\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lfb/o$a;", "", "<init>", "()V", "Lfb/o;", Const.INTENT_KEY_APIKEY, "()Lfb/o;", "", "data", "", "pos", "limit", "Lfb/p;", "copyTracker", "", "owner", Const.INTENT_KEY_PKGNAME, "([BIILfb/p;Z)Lfb/o;", "SIZE", "I", "SHARE_MINIMUM", "kotlinx-io-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: fb.o$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final /* synthetic */ o a() {
            return new o(null);
        }

        public final /* synthetic */ o b(byte[] data, int pos, int limit, p copyTracker, boolean owner) {
            kotlin.jvm.internal.p.i(data, "data");
            return new o(data, pos, limit, copyTracker, owner, null);
        }

        public Companion() {
        }
    }

    public /* synthetic */ o(kotlin.jvm.internal.i iVar) {
        this();
    }

    public final o A() {
        p pVarH = this.copyTracker;
        if (pVarH == null) {
            pVarH = r.h();
            this.copyTracker = pVarH;
        }
        p pVar = pVarH;
        byte[] bArr = this.data;
        int i10 = this.pos;
        int i11 = this.limit;
        pVar.a();
        Y8.t tVar = Y8.t.f7040a;
        return new o(bArr, i10, i11, pVar, false);
    }

    public final o B(int byteCount) {
        o oVarF;
        if (byteCount <= 0 || byteCount > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (byteCount >= 1024) {
            oVarF = A();
        } else {
            oVarF = r.f();
            byte[] bArr = this.data;
            byte[] bArr2 = oVarF.data;
            int i10 = this.pos;
            C1168p.j(bArr, bArr2, 0, i10, i10 + byteCount, 2, null);
        }
        oVarF.limit = oVarF.pos + byteCount;
        this.pos += byteCount;
        o oVar = this.prev;
        if (oVar != null) {
            kotlin.jvm.internal.p.f(oVar);
            oVar.m(oVarF);
            return oVarF;
        }
        oVarF.next = this;
        this.prev = oVarF;
        return oVarF;
    }

    public final void C(byte[] src, int srcStartOffset, int srcEndOffset) {
        kotlin.jvm.internal.p.i(src, "src");
        C1168p.e(src, this.data, this.limit, srcStartOffset, srcEndOffset);
        this.limit += srcEndOffset - srcStartOffset;
    }

    public final /* synthetic */ void D(byte[] data, int bytesToCommit) {
        kotlin.jvm.internal.p.i(data, "data");
    }

    public final void E(byte b10) {
        byte[] bArr = this.data;
        int i10 = this.limit;
        this.limit = i10 + 1;
        bArr[i10] = b10;
    }

    public final void F(int i10) {
        byte[] bArr = this.data;
        int i11 = this.limit;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        this.limit = i11 + 4;
    }

    public final void G(long j10) {
        byte[] bArr = this.data;
        int i10 = this.limit;
        bArr[i10] = (byte) ((j10 >>> 56) & 255);
        bArr[i10 + 1] = (byte) ((j10 >>> 48) & 255);
        bArr[i10 + 2] = (byte) ((j10 >>> 40) & 255);
        bArr[i10 + 3] = (byte) ((j10 >>> 32) & 255);
        bArr[i10 + 4] = (byte) ((j10 >>> 24) & 255);
        bArr[i10 + 5] = (byte) ((j10 >>> 16) & 255);
        bArr[i10 + 6] = (byte) ((j10 >>> 8) & 255);
        bArr[i10 + 7] = (byte) (j10 & 255);
        this.limit = i10 + 8;
    }

    public final void H(short s10) {
        byte[] bArr = this.data;
        int i10 = this.limit;
        bArr[i10] = (byte) ((s10 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (s10 & 255);
        this.limit = i10 + 2;
    }

    public final void I(o sink, int byteCount) {
        kotlin.jvm.internal.p.i(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write");
        }
        if (sink.limit + byteCount > 8192) {
            if (sink.i()) {
                throw new IllegalArgumentException();
            }
            int i10 = sink.limit;
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

    public final o a() {
        int i10;
        o oVar = this.prev;
        if (oVar == null) {
            throw new IllegalStateException("cannot compact");
        }
        kotlin.jvm.internal.p.f(oVar);
        if (oVar.owner) {
            int i11 = this.limit - this.pos;
            o oVar2 = this.prev;
            kotlin.jvm.internal.p.f(oVar2);
            int i12 = 8192 - oVar2.limit;
            o oVar3 = this.prev;
            kotlin.jvm.internal.p.f(oVar3);
            if (oVar3.i()) {
                i10 = 0;
            } else {
                o oVar4 = this.prev;
                kotlin.jvm.internal.p.f(oVar4);
                i10 = oVar4.pos;
            }
            if (i11 <= i12 + i10) {
                o oVar5 = this.prev;
                kotlin.jvm.internal.p.f(oVar5);
                I(oVar5, i11);
                if (l() != null) {
                    throw new IllegalStateException("Check failed.");
                }
                r.d(this);
                return oVar5;
            }
        }
        return this;
    }

    public final /* synthetic */ byte[] b(boolean readOnly) {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final p getCopyTracker() {
        return this.copyTracker;
    }

    /* renamed from: d, reason: from getter */
    public final /* synthetic */ int getLimit() {
        return this.limit;
    }

    /* renamed from: e, reason: from getter */
    public final /* synthetic */ o getNext() {
        return this.next;
    }

    /* renamed from: f, reason: from getter */
    public final /* synthetic */ int getPos() {
        return this.pos;
    }

    /* renamed from: g, reason: from getter */
    public final /* synthetic */ o getPrev() {
        return this.prev;
    }

    public final int h() {
        return this.data.length - this.limit;
    }

    public final boolean i() {
        p pVar = this.copyTracker;
        if (pVar != null) {
            return pVar.b();
        }
        return false;
    }

    public final int j() {
        return this.limit - this.pos;
    }

    public final byte k(int index) {
        return this.data[this.pos + index];
    }

    public final o l() {
        o oVar = this.next;
        o oVar2 = this.prev;
        if (oVar2 != null) {
            kotlin.jvm.internal.p.f(oVar2);
            oVar2.next = this.next;
        }
        o oVar3 = this.next;
        if (oVar3 != null) {
            kotlin.jvm.internal.p.f(oVar3);
            oVar3.prev = this.prev;
        }
        this.next = null;
        this.prev = null;
        return oVar;
    }

    public final o m(o segment) {
        kotlin.jvm.internal.p.i(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        o oVar = this.next;
        if (oVar != null) {
            kotlin.jvm.internal.p.f(oVar);
            oVar.prev = segment;
        }
        this.next = segment;
        return segment;
    }

    public final byte n() {
        byte[] bArr = this.data;
        int i10 = this.pos;
        this.pos = i10 + 1;
        return bArr[i10];
    }

    public final int o() {
        byte[] bArr = this.data;
        int i10 = this.pos;
        int i11 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24);
        int i12 = i11 | ((bArr[i10 + 2] & 255) << 8);
        int i13 = (bArr[i10 + 3] & 255) | i12;
        this.pos = i10 + 4;
        return i13;
    }

    public final long p() {
        byte[] bArr = this.data;
        long j10 = ((bArr[r1] & 255) << 56) | ((bArr[r1 + 1] & 255) << 48) | ((bArr[r1 + 2] & 255) << 40) | ((bArr[r1 + 3] & 255) << 32) | ((bArr[r1 + 4] & 255) << 24) | ((bArr[r1 + 5] & 255) << 16) | ((bArr[r1 + 6] & 255) << 8) | (bArr[r1 + 7] & 255);
        this.pos = this.pos + 8;
        return j10;
    }

    public final short q() {
        byte[] bArr = this.data;
        int i10 = this.pos;
        int i11 = (bArr[i10] & 255) << 8;
        short s10 = (short) ((bArr[i10 + 1] & 255) | i11);
        this.pos = i10 + 2;
        return s10;
    }

    public final void r(byte[] dst, int dstStartOffset, int dstEndOffset) {
        kotlin.jvm.internal.p.i(dst, "dst");
        int i10 = dstEndOffset - dstStartOffset;
        byte[] bArr = this.data;
        int i11 = this.pos;
        C1168p.e(bArr, dst, dstStartOffset, i11, i11 + i10);
        this.pos += i10;
    }

    public final /* synthetic */ void s(int i10) {
        this.limit = i10;
    }

    public final /* synthetic */ void t(o oVar) {
        this.next = oVar;
    }

    public final /* synthetic */ void u(int i10) {
        this.pos = i10;
    }

    public final /* synthetic */ void v(o oVar) {
        this.prev = oVar;
    }

    public final void w(int index, byte value) {
        this.data[this.limit + index] = value;
    }

    public final void x(int index, byte b02, byte b12) {
        byte[] bArr = this.data;
        int i10 = this.limit + index;
        bArr[i10] = b02;
        bArr[i10 + 1] = b12;
    }

    public final void y(int index, byte b02, byte b12, byte b22) {
        byte[] bArr = this.data;
        int i10 = this.limit + index;
        bArr[i10] = b02;
        bArr[i10 + 1] = b12;
        bArr[i10 + 2] = b22;
    }

    public final void z(int index, byte b02, byte b12, byte b22, byte b32) {
        byte[] bArr = this.data;
        int i10 = this.limit + index;
        bArr[i10] = b02;
        bArr[i10 + 1] = b12;
        bArr[i10 + 2] = b22;
        bArr[i10 + 3] = b32;
    }

    public /* synthetic */ o(byte[] bArr, int i10, int i11, p pVar, boolean z10, kotlin.jvm.internal.i iVar) {
        this(bArr, i10, i11, pVar, z10);
    }

    public o() {
        this.data = new byte[com.stepos.agentframework.chatui.longtext.b.THRESHOLD];
        this.owner = true;
        this.copyTracker = null;
    }

    public o(byte[] bArr, int i10, int i11, p pVar, boolean z10) {
        this.data = bArr;
        this.pos = i10;
        this.limit = i11;
        this.copyTracker = pVar;
        this.owner = z10;
    }
}
