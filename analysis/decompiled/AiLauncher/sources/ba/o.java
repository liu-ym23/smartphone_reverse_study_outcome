package ba;

import La.H;
import androidx.exifinterface.media.ExifInterface;
import ba.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import pa.C5080d;

/* loaded from: classes5.dex */
public final class o implements n<m> {

    /* renamed from: a, reason: collision with root package name */
    public static final o f15356a = new o();

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15357a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            try {
                iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PrimitiveType.CHAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PrimitiveType.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PrimitiveType.SHORT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PrimitiveType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PrimitiveType.LONG.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f15357a = iArr;
        }
    }

    @Override // ba.n
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public m b(m possiblyPrimitiveType) {
        kotlin.jvm.internal.p.i(possiblyPrimitiveType, "possiblyPrimitiveType");
        if (possiblyPrimitiveType instanceof m.d) {
            m.d dVar = (m.d) possiblyPrimitiveType;
            if (dVar.i() != null) {
                String strF = C5080d.c(dVar.i().getWrapperFqName()).f();
                kotlin.jvm.internal.p.h(strF, "getInternalName(...)");
                return e(strF);
            }
        }
        return possiblyPrimitiveType;
    }

    @Override // ba.n
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public m a(String representation) {
        JvmPrimitiveType jvmPrimitiveType;
        kotlin.jvm.internal.p.i(representation, "representation");
        representation.length();
        char cCharAt = representation.charAt(0);
        JvmPrimitiveType[] jvmPrimitiveTypeArrValues = JvmPrimitiveType.values();
        int length = jvmPrimitiveTypeArrValues.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = jvmPrimitiveTypeArrValues[i10];
            if (jvmPrimitiveType.getDesc().charAt(0) == cCharAt) {
                break;
            }
            i10++;
        }
        if (jvmPrimitiveType != null) {
            return new m.d(jvmPrimitiveType);
        }
        if (cCharAt == 'V') {
            return new m.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = representation.substring(1);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            return new m.a(a(strSubstring));
        }
        if (cCharAt == 'L') {
            H.j0(representation, ';', false, 2, null);
        }
        String strSubstring2 = representation.substring(1, representation.length() - 1);
        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        return new m.c(strSubstring2);
    }

    @Override // ba.n
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public m.c e(String internalName) {
        kotlin.jvm.internal.p.i(internalName, "internalName");
        return new m.c(internalName);
    }

    @Override // ba.n
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public m c(PrimitiveType primitiveType) {
        kotlin.jvm.internal.p.i(primitiveType, "primitiveType");
        switch (a.f15357a[primitiveType.ordinal()]) {
            case 1:
                return m.f15344a.a();
            case 2:
                return m.f15344a.c();
            case 3:
                return m.f15344a.b();
            case 4:
                return m.f15344a.h();
            case 5:
                return m.f15344a.f();
            case 6:
                return m.f15344a.e();
            case 7:
                return m.f15344a.g();
            case 8:
                return m.f15344a.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // ba.n
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public m f() {
        return e("java/lang/Class");
    }

    @Override // ba.n
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String d(m type) {
        String desc;
        kotlin.jvm.internal.p.i(type, "type");
        if (type instanceof m.a) {
            return '[' + d(((m.a) type).i());
        }
        if (type instanceof m.d) {
            JvmPrimitiveType jvmPrimitiveTypeI = ((m.d) type).i();
            return (jvmPrimitiveTypeI == null || (desc = jvmPrimitiveTypeI.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        }
        if (!(type instanceof m.c)) {
            throw new NoWhenBranchMatchedException();
        }
        return 'L' + ((m.c) type).i() + ';';
    }
}
