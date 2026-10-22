package e8;

import X8.C0278i;
import androidx.exifinterface.media.ExifInterface;
import h8.AbstractC1532o;
import h8.C1531n;
import h8.InterfaceC1536s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import k8.C1628A;
import k8.C1640i;
import k8.O;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final C1628A f4429a;

    static {
        Z8.i iVar = Z8.i.f1619a;
        g8.k kVar = new g8.k(Z8.i.b, o.f, 1);
        ClassKind classKind = ClassKind.f4951a;
        G8.f fVarF = o.g.f();
        W8.b bVar = W8.i.e;
        C1628A c1628a = new C1628A(kVar, fVarF, bVar);
        c1628a.h = Modality.e;
        C1531n c1531n = AbstractC1532o.e;
        if (c1531n == null) {
            C1628A.C(9);
            throw null;
        }
        c1628a.i = c1531n;
        List listM = H4.o.M(O.U0(c1628a, Variance.d, G8.f.e(ExifInterface.GPS_DIRECTION_TRUE), 0, bVar));
        if (c1628a.k != null) {
            throw new IllegalStateException("Type parameters are already set for " + c1628a.getName());
        }
        ArrayList arrayList = new ArrayList(listM);
        c1628a.k = arrayList;
        c1628a.f4824j = new C0278i(c1628a, arrayList, c1628a.l, c1628a.m);
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            C1628A.C(13);
            throw null;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((C1640i) ((InterfaceC1536s) it.next())).g = c1628a.g();
        }
        f4429a = c1628a;
    }
}
