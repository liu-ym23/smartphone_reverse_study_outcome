package La;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0000H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u0004\u0018\u00010\n*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"", "LY8/k;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)B", "LY8/r;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)S", "LY8/m;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)I", "LY8/o;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)J", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LY8/k;", "", "radix", "c", "(Ljava/lang/String;I)LY8/k;", "k", "(Ljava/lang/String;)LY8/r;", "l", "(Ljava/lang/String;I)LY8/r;", "e", "(Ljava/lang/String;)LY8/m;", "f", "(Ljava/lang/String;I)LY8/m;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)LY8/o;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;I)LY8/o;", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class L {
    public static final byte a(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        Y8.k kVarB = b(str);
        if (kVarB != null) {
            return kVarB.getData();
        }
        C.v(str);
        throw new KotlinNothingValueException();
    }

    public static final Y8.k b(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return c(str, 10);
    }

    public static final Y8.k c(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        Y8.m mVarF = f(str, i10);
        if (mVarF == null) {
            return null;
        }
        int data = mVarF.getData();
        if (Integer.compareUnsigned(data, Y8.m.b(255)) > 0) {
            return null;
        }
        return Y8.k.a(Y8.k.b((byte) data));
    }

    public static final int d(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        Y8.m mVarE = e(str);
        if (mVarE != null) {
            return mVarE.getData();
        }
        C.v(str);
        throw new KotlinNothingValueException();
    }

    public static final Y8.m e(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return f(str, 10);
    }

    public static final Y8.m f(String str, int i10) {
        int i11;
        kotlin.jvm.internal.p.i(str, "<this>");
        C0951a.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.p.k(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i11 = 0;
        }
        int iB = Y8.m.b(i10);
        int iDivideUnsigned = 119304647;
        while (i11 < length) {
            int iB2 = C0951a.b(str.charAt(i11), i10);
            if (iB2 < 0) {
                return null;
            }
            if (Integer.compareUnsigned(i12, iDivideUnsigned) > 0) {
                if (iDivideUnsigned == 119304647) {
                    iDivideUnsigned = Integer.divideUnsigned(-1, iB);
                    if (Integer.compareUnsigned(i12, iDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            int iB3 = Y8.m.b(i12 * iB);
            int iB4 = Y8.m.b(Y8.m.b(iB2) + iB3);
            if (Integer.compareUnsigned(iB4, iB3) < 0) {
                return null;
            }
            i11++;
            i12 = iB4;
        }
        return Y8.m.a(i12);
    }

    public static final long g(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        Y8.o oVarH = h(str);
        if (oVarH != null) {
            return oVarH.getData();
        }
        C.v(str);
        throw new KotlinNothingValueException();
    }

    public static final Y8.o h(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return i(str, 10);
    }

    public static final Y8.o i(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        C0951a.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.p.k(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jB = Y8.o.b(i10);
        long j10 = 0;
        long jDivideUnsigned = 512409557603043100L;
        while (i11 < length) {
            if (C0951a.b(str.charAt(i11), i10) < 0) {
                return null;
            }
            if (Long.compareUnsigned(j10, jDivideUnsigned) > 0) {
                if (jDivideUnsigned == 512409557603043100L) {
                    jDivideUnsigned = Long.divideUnsigned(-1L, jB);
                    if (Long.compareUnsigned(j10, jDivideUnsigned) > 0) {
                    }
                }
                return null;
            }
            long jB2 = Y8.o.b(j10 * jB);
            long jB3 = Y8.o.b(Y8.o.b(Y8.m.b(r13) & 4294967295L) + jB2);
            if (Long.compareUnsigned(jB3, jB2) < 0) {
                return null;
            }
            i11++;
            j10 = jB3;
        }
        return Y8.o.a(j10);
    }

    public static final short j(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        Y8.r rVarK = k(str);
        if (rVarK != null) {
            return rVarK.getData();
        }
        C.v(str);
        throw new KotlinNothingValueException();
    }

    public static final Y8.r k(String str) {
        kotlin.jvm.internal.p.i(str, "<this>");
        return l(str, 10);
    }

    public static final Y8.r l(String str, int i10) {
        kotlin.jvm.internal.p.i(str, "<this>");
        Y8.m mVarF = f(str, i10);
        if (mVarF == null) {
            return null;
        }
        int data = mVarF.getData();
        if (Integer.compareUnsigned(data, Y8.m.b(65535)) > 0) {
            return null;
        }
        return Y8.r.a(Y8.r.b((short) data));
    }
}
