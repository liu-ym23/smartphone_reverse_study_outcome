package h8;

import X8.C0278i;
import androidx.exifinterface.media.ExifInterface;
import g1.AbstractC1451a;
import i8.C1560f;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k8.AbstractC1641j;
import k8.C1640i;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: h8.A, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1493A extends AbstractC1641j {
    public final boolean g;
    public final ArrayList h;
    public final C0278i i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1493A(W8.i iVar, InterfaceC1523f container, G8.f fVar, boolean z10, int i) {
        super(iVar, container, fVar, InterfaceC1503K.f4577I);
        kotlin.jvm.internal.k.f(container, "container");
        this.g = z10;
        Y7.f fVarX = AbstractC1451a.X(0, i);
        ArrayList arrayList = new ArrayList(D7.w.c0(fVarX, 10));
        Y7.e it = fVarX.iterator();
        while (it.c) {
            int iNextInt = it.nextInt();
            arrayList.add(k8.O.U0(this, Variance.c, G8.f.e(ExifInterface.GPS_DIRECTION_TRUE + iNextInt), iNextInt, iVar));
        }
        this.h = arrayList;
        this.i = new C0278i(this, AbstractC1538u.c(this), D7.N.Q(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.j(this).c().e()), iVar);
    }

    @Override // k8.y
    public final Q8.o A(Y8.f fVar) {
        return Q8.n.b;
    }

    @Override // h8.InterfaceC1522e
    public final boolean A0() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final AbstractC1508P P() {
        return null;
    }

    @Override // h8.InterfaceC1539v
    public final boolean S() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean X() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean c0() {
        return false;
    }

    @Override // h8.InterfaceC1539v
    public final boolean g0() {
        return false;
    }

    @Override // i8.InterfaceC1555a
    public final InterfaceC1561g getAnnotations() {
        return C1560f.f4611a;
    }

    @Override // h8.InterfaceC1522e
    public final ClassKind getKind() {
        return ClassKind.f4951a;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final C1531n getVisibility() {
        C1531n PUBLIC = AbstractC1532o.e;
        kotlin.jvm.internal.k.e(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1525h
    public final List h() {
        return this.h;
    }

    @Override // h8.InterfaceC1522e
    public final /* bridge */ /* synthetic */ Q8.o h0() {
        return Q8.n.b;
    }

    @Override // h8.InterfaceC1522e, h8.InterfaceC1539v
    public final Modality i() {
        return Modality.b;
    }

    @Override // k8.AbstractC1641j, h8.InterfaceC1539v
    public final boolean isExternal() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean isInline() {
        return false;
    }

    @Override // h8.InterfaceC1522e
    public final boolean j() {
        return false;
    }

    @Override // h8.InterfaceC1524g
    public final X8.K m() {
        return this.i;
    }

    @Override // h8.InterfaceC1522e
    public final Collection n() {
        return EmptySet.f4895a;
    }

    @Override // h8.InterfaceC1522e
    public final Collection p() {
        return EmptyList.f4893a;
    }

    @Override // h8.InterfaceC1525h
    public final boolean q() {
        return this.g;
    }

    public final String toString() {
        return "class " + getName() + " (not found)";
    }

    @Override // h8.InterfaceC1522e
    public final C1640i u() {
        return null;
    }
}
