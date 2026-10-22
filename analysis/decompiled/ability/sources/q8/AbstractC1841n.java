package q8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1494B;
import h8.InterfaceC1520c;
import h8.InterfaceC1527j;
import h8.InterfaceC1530m;
import java.util.HashMap;
import k8.AbstractC1629B;
import l8.C1664a;
import l8.C1665b;
import l8.C1666c;

/* renamed from: q8.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1841n {

    /* renamed from: a, reason: collision with root package name */
    public static final C1531n f5605a;
    public static final C1531n b;
    public static final C1531n c;
    public static final HashMap d;

    static {
        C1664a c1664a = C1664a.c;
        C1531n c1531n = new C1531n(c1664a, 9);
        f5605a = c1531n;
        C1666c c1666c = C1666c.c;
        C1531n c1531n2 = new C1531n(c1666c, 10);
        b = c1531n2;
        C1665b c1665b = C1665b.c;
        C1531n c1531n3 = new C1531n(c1665b, 11);
        c = c1531n3;
        HashMap map = new HashMap();
        d = map;
        map.put(c1664a, c1531n);
        map.put(c1666c, c1531n2);
        map.put(c1665b, c1531n3);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = TypedValues.TransitionType.S_FROM;
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String str2 = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(R8.d dVar, InterfaceC1530m interfaceC1530m, InterfaceC1527j interfaceC1527j) {
        if (interfaceC1527j == null) {
            a(1);
            throw null;
        }
        int i = J8.e.f883a;
        if (c(interfaceC1530m instanceof InterfaceC1520c ? J8.e.t((InterfaceC1520c) interfaceC1530m) : interfaceC1530m, interfaceC1527j)) {
            return true;
        }
        return AbstractC1532o.c.a(dVar, interfaceC1530m, interfaceC1527j);
    }

    public static boolean c(InterfaceC1530m interfaceC1530m, InterfaceC1527j interfaceC1527j) {
        if (interfaceC1530m == null) {
            a(2);
            throw null;
        }
        if (interfaceC1527j == null) {
            a(3);
            throw null;
        }
        InterfaceC1494B interfaceC1494B = (InterfaceC1494B) J8.e.i(interfaceC1530m, InterfaceC1494B.class, false);
        InterfaceC1494B interfaceC1494B2 = (InterfaceC1494B) J8.e.i(interfaceC1527j, InterfaceC1494B.class, false);
        return (interfaceC1494B2 == null || interfaceC1494B == null || !((AbstractC1629B) interfaceC1494B).e.equals(((AbstractC1629B) interfaceC1494B2).e)) ? false : true;
    }
}
