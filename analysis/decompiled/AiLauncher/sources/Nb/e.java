package Nb;

import Mb.C0966d;
import Mb.z;
import Z8.A;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.io.EOFException;
import java.util.ArrayList;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0015\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001b\u0010\u000f\u001a\u00020\u0000*\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0013\u0010\u0015\u001a\u00020\u0011*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0018\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001c\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u0014\u0010\u001e\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b\"\u0014\u0010 \u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001b\"\u0014\u0010\"\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001b\"\u0014\u0010$\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001b\"\u0018\u0010&\u001a\u00020\u0001*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0003\"\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u0011*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"LMb/z;", "", "o", "(LMb/z;)I", "", "n", "(LMb/z;)Z", "child", "normalize", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(LMb/z;LMb/z;Z)LMb/z;", "", "k", "(Ljava/lang/String;Z)LMb/z;", "LMb/d;", "q", "(LMb/d;Z)LMb/z;", "Lokio/ByteString;", "s", "(Ljava/lang/String;)Lokio/ByteString;", "", "r", "(B)Lokio/ByteString;", "slash", "p", "(LMb/d;Lokio/ByteString;)Z", Const.INTENT_KEY_APIKEY, "Lokio/ByteString;", "SLASH", Const.INTENT_KEY_PKGNAME, "BACKSLASH", "c", "ANY_SLASH", Const.INTENT_KEY_UMID, "DOT", "e", "DOT_DOT", "l", "indexOfLastSlash", "m", "(LMb/z;)Lokio/ByteString;", "okio"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f5039a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f5040b;

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f5041c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f5042d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f5043e;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f5039a = companion.d("/");
        f5040b = companion.d("\\");
        f5041c = companion.d("/\\");
        f5042d = companion.d(".");
        f5043e = companion.d("..");
    }

    public static final z j(z zVar, z child, boolean z10) {
        kotlin.jvm.internal.p.i(zVar, "<this>");
        kotlin.jvm.internal.p.i(child, "child");
        if (child.isAbsolute() || child.q() != null) {
            return child;
        }
        ByteString byteStringM = m(zVar);
        if (byteStringM == null && (byteStringM = m(child)) == null) {
            byteStringM = s(z.f4761c);
        }
        C0966d c0966d = new C0966d();
        c0966d.j1(zVar.getBytes());
        if (c0966d.getSize() > 0) {
            c0966d.j1(byteStringM);
        }
        c0966d.j1(child.getBytes());
        return q(c0966d, z10);
    }

    public static final z k(String str, boolean z10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return q(new C0966d().L(str), z10);
    }

    public static final int l(z zVar) {
        int iC = ByteString.C(zVar.getBytes(), f5039a, 0, 2, null);
        return iC != -1 ? iC : ByteString.C(zVar.getBytes(), f5040b, 0, 2, null);
    }

    public static final ByteString m(z zVar) {
        ByteString byteStringB = zVar.getBytes();
        ByteString byteString = f5039a;
        if (ByteString.w(byteStringB, byteString, 0, 2, null) != -1) {
            return byteString;
        }
        ByteString byteStringB2 = zVar.getBytes();
        ByteString byteString2 = f5040b;
        if (ByteString.w(byteStringB2, byteString2, 0, 2, null) != -1) {
            return byteString2;
        }
        return null;
    }

    public static final boolean n(z zVar) {
        return zVar.getBytes().k(f5043e) && (zVar.getBytes().K() == 2 || zVar.getBytes().D(zVar.getBytes().K() + (-3), f5039a, 0, 1) || zVar.getBytes().D(zVar.getBytes().K() + (-3), f5040b, 0, 1));
    }

    public static final int o(z zVar) {
        if (zVar.getBytes().K() == 0) {
            return -1;
        }
        if (zVar.getBytes().l(0) == 47) {
            return 1;
        }
        if (zVar.getBytes().l(0) == 92) {
            if (zVar.getBytes().K() <= 2 || zVar.getBytes().l(1) != 92) {
                return 1;
            }
            int iU = zVar.getBytes().u(f5040b, 2);
            return iU == -1 ? zVar.getBytes().K() : iU;
        }
        if (zVar.getBytes().K() > 2 && zVar.getBytes().l(1) == 58 && zVar.getBytes().l(2) == 92) {
            char cL = (char) zVar.getBytes().l(0);
            if ('a' <= cL && cL < '{') {
                return 3;
            }
            if ('A' <= cL && cL < '[') {
                return 3;
            }
        }
        return -1;
    }

    public static final boolean p(C0966d c0966d, ByteString byteString) {
        if (!kotlin.jvm.internal.p.d(byteString, f5040b) || c0966d.getSize() < 2 || c0966d.Y(1L) != 58) {
            return false;
        }
        char cY = (char) c0966d.Y(0L);
        if ('a' > cY || cY >= '{') {
            return 'A' <= cY && cY < '[';
        }
        return true;
    }

    public static final z q(C0966d c0966d, boolean z10) throws EOFException {
        ByteString byteString;
        ByteString byteStringZ0;
        kotlin.jvm.internal.p.i(c0966d, "<this>");
        C0966d c0966d2 = new C0966d();
        ByteString byteStringR = null;
        int i10 = 0;
        while (true) {
            if (!c0966d.P(0L, f5039a)) {
                byteString = f5040b;
                if (!c0966d.P(0L, byteString)) {
                    break;
                }
            }
            byte b10 = c0966d.readByte();
            if (byteStringR == null) {
                byteStringR = r(b10);
            }
            i10++;
        }
        boolean z11 = i10 >= 2 && kotlin.jvm.internal.p.d(byteStringR, byteString);
        if (z11) {
            kotlin.jvm.internal.p.f(byteStringR);
            c0966d2.j1(byteStringR);
            c0966d2.j1(byteStringR);
        } else if (i10 > 0) {
            kotlin.jvm.internal.p.f(byteStringR);
            c0966d2.j1(byteStringR);
        } else {
            long jF = c0966d.F(f5041c);
            if (byteStringR == null) {
                byteStringR = jF == -1 ? s(z.f4761c) : r(c0966d.Y(jF));
            }
            if (p(c0966d, byteStringR)) {
                if (jF == 2) {
                    c0966d2.K(c0966d, 3L);
                } else {
                    c0966d2.K(c0966d, 2L);
                }
            }
            Y8.t tVar = Y8.t.f7040a;
        }
        boolean z12 = c0966d2.getSize() > 0;
        ArrayList arrayList = new ArrayList();
        while (!c0966d.k()) {
            long jF2 = c0966d.F(f5041c);
            if (jF2 == -1) {
                byteStringZ0 = c0966d.N0();
            } else {
                byteStringZ0 = c0966d.z0(jF2);
                c0966d.readByte();
            }
            ByteString byteString2 = f5043e;
            if (kotlin.jvm.internal.p.d(byteStringZ0, byteString2)) {
                if (!z12 || !arrayList.isEmpty()) {
                    if (!z10 || (!z12 && (arrayList.isEmpty() || kotlin.jvm.internal.p.d(F.C0(arrayList), byteString2)))) {
                        arrayList.add(byteStringZ0);
                    } else if (!z11 || arrayList.size() != 1) {
                        A.O(arrayList);
                    }
                }
            } else if (!kotlin.jvm.internal.p.d(byteStringZ0, f5042d) && !kotlin.jvm.internal.p.d(byteStringZ0, ByteString.f37756e)) {
                arrayList.add(byteStringZ0);
            }
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (i11 > 0) {
                c0966d2.j1(byteStringR);
            }
            c0966d2.j1((ByteString) arrayList.get(i11));
        }
        if (c0966d2.getSize() == 0) {
            c0966d2.j1(f5042d);
        }
        return new z(c0966d2.N0());
    }

    public static final ByteString r(byte b10) {
        if (b10 == 47) {
            return f5039a;
        }
        if (b10 == 92) {
            return f5040b;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b10));
    }

    public static final ByteString s(String str) {
        if (kotlin.jvm.internal.p.d(str, "/")) {
            return f5039a;
        }
        if (kotlin.jvm.internal.p.d(str, "\\")) {
            return f5040b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
