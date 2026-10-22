package O9;

import N9.c;
import Y8.j;
import Y8.k;
import Y8.m;
import Y8.o;
import Y8.r;
import ea.C4018b;
import ea.InterfaceC4020d;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;

/* loaded from: classes5.dex */
public final class e {

    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5301a;

        static {
            int[] iArr = new int[ProtoBuf$Annotation.Argument.Value.Type.values().length];
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.SHORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ProtoBuf$Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            f5301a = iArr;
        }
    }

    public static final String a(InterfaceC4020d interfaceC4020d, int i10) {
        p.i(interfaceC4020d, "<this>");
        String strB = interfaceC4020d.b(i10);
        if (!interfaceC4020d.a(i10)) {
            return strB;
        }
        return '.' + strB;
    }

    public static final N9.b b(ProtoBuf$Annotation protoBuf$Annotation, InterfaceC4020d strings) {
        p.i(protoBuf$Annotation, "<this>");
        p.i(strings, "strings");
        String strA = a(strings, protoBuf$Annotation.y());
        List<ProtoBuf$Annotation.Argument> listW = protoBuf$Annotation.w();
        p.h(listW, "getArgumentList(...)");
        ArrayList arrayList = new ArrayList();
        for (ProtoBuf$Annotation.Argument argument : listW) {
            ProtoBuf$Annotation.Argument.Value valueV = argument.v();
            p.h(valueV, "getValue(...)");
            N9.c cVarC = c(valueV, strings);
            Pair pairA = cVarC != null ? j.a(strings.getString(argument.u()), cVarC) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return new N9.b(strA, kotlin.collections.a.y(arrayList));
    }

    public static final N9.c c(ProtoBuf$Annotation.Argument.Value value, InterfaceC4020d strings) {
        p.i(value, "<this>");
        p.i(strings, "strings");
        if (C4018b.f32373S.d(value.O()).booleanValue()) {
            ProtoBuf$Annotation.Argument.Value.Type typeS = value.S();
            int i10 = typeS != null ? a.f5301a[typeS.ordinal()] : -1;
            if (i10 == 1) {
                return new c.p(k.b((byte) value.Q()), null);
            }
            if (i10 == 2) {
                return new c.s(r.b((short) value.Q()), null);
            }
            if (i10 == 3) {
                return new c.q(m.b((int) value.Q()), null);
            }
            if (i10 == 4) {
                return new c.r(o.b(value.Q()), null);
            }
            throw new IllegalStateException(("Cannot read value of unsigned type: " + value.S()).toString());
        }
        ProtoBuf$Annotation.Argument.Value.Type typeS2 = value.S();
        switch (typeS2 != null ? a.f5301a[typeS2.ordinal()] : -1) {
            case -1:
                return null;
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                return new c.e((byte) value.Q());
            case 2:
                return new c.n((short) value.Q());
            case 3:
                return new c.j((int) value.Q());
            case 4:
                return new c.m(value.Q());
            case 5:
                return new c.f((char) value.Q());
            case 6:
                return new c.i(value.P());
            case 7:
                return new c.g(value.M());
            case 8:
                return new c.d(value.Q() != 0);
            case 9:
                return new c.o(strings.getString(value.R()));
            case 10:
                String strA = a(strings, value.K());
                return value.F() == 0 ? new c.k(strA) : new c.b(strA, value.F());
            case 11:
                return new c.h(a(strings, value.K()), strings.getString(value.N()));
            case 12:
                ProtoBuf$Annotation protoBuf$AnnotationE = value.E();
                p.h(protoBuf$AnnotationE, "getAnnotation(...)");
                return new c.a(b(protoBuf$AnnotationE, strings));
            case 13:
                List<ProtoBuf$Annotation.Argument.Value> listJ = value.J();
                p.h(listJ, "getArrayElementList(...)");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf$Annotation.Argument.Value value2 : listJ) {
                    p.f(value2);
                    N9.c cVarC = c(value2, strings);
                    if (cVarC != null) {
                        arrayList.add(cVarC);
                    }
                }
                return new c.C0087c(arrayList);
        }
    }
}
