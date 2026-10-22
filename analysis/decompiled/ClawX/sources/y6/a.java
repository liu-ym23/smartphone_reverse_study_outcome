package y6;

import c5.m;
import c5.s;
import c7.i;
import com.stepos.stepclaw.SecurePrefs;
import f2.p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import p0.b;
import t1.f;
import w5.c;
import w5.d;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final i f6360b;

    /* renamed from: c, reason: collision with root package name */
    public static final List f6361c;
    public static a d;

    /* renamed from: a, reason: collision with root package name */
    public final p f6362a;

    static {
        byte[] bArrCopyOf = Arrays.copyOf(new byte[]{42}, 1);
        kotlin.jvm.internal.p.d(bArrCopyOf, "copyOf(...)");
        f6360b = new i(bArrCopyOf);
        f6361c = a.a.S("*");
        d = new a(new p(2));
    }

    public a(p pVar) {
        this.f6362a = pVar;
    }

    public static List b(String str) {
        List listH1 = n.H1(str, new char[]{'.'});
        return kotlin.jvm.internal.p.a(m.B0(listH1), SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID) ? m.s0(1, listH1) : listH1;
    }

    public final String a(String str) throws InterruptedException {
        String strA;
        String strA2;
        String strA3;
        List listH1;
        int size;
        int size2;
        String unicode = IDN.toUnicode(str);
        kotlin.jvm.internal.p.b(unicode);
        List listB = b(unicode);
        p pVar = this.f6362a;
        AtomicBoolean atomicBoolean = (AtomicBoolean) pVar.f2574b;
        int i8 = 0;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            try {
                ((CountDownLatch) pVar.f2575c).await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        pVar.g();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    } catch (IOException e9) {
                        pVar.f2577f = e9;
                        if (z) {
                        }
                    }
                } finally {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
        if (((i) pVar.d) == null) {
            StringBuilder sb = new StringBuilder("Unable to load ");
            sb.append(pVar.f2573a);
            sb.append(" resource.");
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            illegalStateException.initCause((IOException) pVar.f2577f);
            throw illegalStateException;
        }
        int size3 = listB.size();
        i[] iVarArr = new i[size3];
        for (int i9 = 0; i9 < size3; i9++) {
            i iVar = i.d;
            iVarArr[i9] = f.f((String) listB.get(i9));
        }
        int i10 = 0;
        while (true) {
            if (i10 >= size3) {
                strA = null;
                break;
            }
            i iVar2 = (i) pVar.d;
            if (iVar2 == null) {
                kotlin.jvm.internal.p.l("bytes");
                throw null;
            }
            strA = b.a(iVar2, iVarArr, i10);
            if (strA != null) {
                break;
            }
            i10++;
        }
        if (size3 > 1) {
            i[] iVarArr2 = (i[]) iVarArr.clone();
            int length = iVarArr2.length - 1;
            for (int i11 = 0; i11 < length; i11++) {
                iVarArr2[i11] = f6360b;
                i iVar3 = (i) pVar.d;
                if (iVar3 == null) {
                    kotlin.jvm.internal.p.l("bytes");
                    throw null;
                }
                strA2 = b.a(iVar3, iVarArr2, i11);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            int i12 = size3 - 1;
            for (int i13 = 0; i13 < i12; i13++) {
                i iVar4 = (i) pVar.f2576e;
                if (iVar4 == null) {
                    kotlin.jvm.internal.p.l("exceptionBytes");
                    throw null;
                }
                strA3 = b.a(iVar4, iVarArr, i13);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            listH1 = n.H1("!".concat(strA3), new char[]{'.'});
        } else if (strA == null && strA2 == null) {
            listH1 = f6361c;
        } else {
            List listH12 = s.f1092a;
            List listH13 = strA != null ? n.H1(strA, new char[]{'.'}) : listH12;
            if (strA2 != null) {
                listH12 = n.H1(strA2, new char[]{'.'});
            }
            listH1 = listH13.size() > listH12.size() ? listH13 : listH12;
        }
        if (listB.size() == listH1.size() && ((String) listH1.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listH1.get(0)).charAt(0) == '!') {
            size = listB.size();
            size2 = listH1.size();
        } else {
            size = listB.size();
            size2 = listH1.size() + 1;
        }
        int i14 = size - size2;
        w5.i iVarQ0 = m.q0(b(str));
        if (i14 < 0) {
            throw new IllegalArgumentException(a8.b.k(i14, "Requested element count ", " is less than zero.").toString());
        }
        if (i14 != 0) {
            iVarQ0 = iVarQ0 instanceof d ? ((d) iVarQ0).a(i14) : new c(iVarQ0, i14);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        for (Object obj : iVarQ0) {
            i8++;
            if (i8 > 1) {
                sb2.append((CharSequence) ".");
            }
            x.f.o(sb2, obj, null);
        }
        sb2.append((CharSequence) SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        return sb2.toString();
    }
}
