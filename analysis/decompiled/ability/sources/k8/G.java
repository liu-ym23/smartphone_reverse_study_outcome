package k8;

import X8.AbstractC0272c;
import androidx.autofill.HintConstants;
import h8.AbstractC1532o;
import h8.C1504L;
import h8.C1531n;
import h8.InterfaceC1501I;
import h8.InterfaceC1503K;
import h8.InterfaceC1527j;
import i8.InterfaceC1561g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1527j f4828a;
    public Modality b;
    public C1531n c;
    public CallableMemberDescriptor$Kind e;
    public final u h;
    public final G8.f i;

    /* renamed from: j, reason: collision with root package name */
    public final X8.w f4829j;
    public final /* synthetic */ H k;
    public InterfaceC1501I d = null;
    public X8.P f = X8.P.f1526a;
    public boolean g = true;

    public G(H h) {
        this.k = h;
        this.f4828a = h.d();
        this.b = h.i();
        this.c = h.getVisibility();
        this.e = h.getKind();
        this.h = h.f4834t;
        this.i = h.getName();
        this.f4829j = h.getType();
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 5 || i == 7 || i == 9 || i == 11 || i == 19 || i == 13 || i == 14 || i == 16 || i == 17) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                break;
            case 4:
                objArr[0] = "type";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 8:
                objArr[0] = "visibility";
                break;
            case 10:
                objArr[0] = "kind";
                break;
            case 12:
                objArr[0] = "typeParameters";
                break;
            case 15:
                objArr[0] = "substitution";
                break;
            case 18:
                objArr[0] = HintConstants.AUTOFILL_HINT_NAME;
                break;
            default:
                objArr[0] = "owner";
                break;
        }
        if (i == 1) {
            objArr[1] = "setOwner";
        } else if (i == 2) {
            objArr[1] = "setOriginal";
        } else if (i == 3) {
            objArr[1] = "setPreserveSourceElement";
        } else if (i == 5) {
            objArr[1] = "setReturnType";
        } else if (i == 7) {
            objArr[1] = "setModality";
        } else if (i == 9) {
            objArr[1] = "setVisibility";
        } else if (i == 11) {
            objArr[1] = "setKind";
        } else if (i == 19) {
            objArr[1] = "setName";
        } else if (i == 13) {
            objArr[1] = "setTypeParameters";
        } else if (i == 14) {
            objArr[1] = "setDispatchReceiverParameter";
        } else if (i == 16) {
            objArr[1] = "setSubstitution";
        } else if (i != 17) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        } else {
            objArr[1] = "setCopyOverrides";
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 9:
            case 11:
            case 13:
            case 14:
            case 16:
            case 17:
            case 19:
                break;
            case 4:
                objArr[2] = "setReturnType";
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 8:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setKind";
                break;
            case 12:
                objArr[2] = "setTypeParameters";
                break;
            case 15:
                objArr[2] = "setSubstitution";
                break;
            case 18:
                objArr[2] = "setName";
                break;
            default:
                objArr[2] = "setOwner";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2 && i != 3 && i != 5 && i != 7 && i != 9 && i != 11 && i != 19 && i != 13 && i != 14 && i != 16 && i != 17) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public final H b() {
        u uVar;
        u uVar2;
        I i;
        J j5;
        kotlin.reflect.jvm.internal.impl.types.a aVar;
        S7.a aVar2;
        u uVar3;
        u uVar4;
        InterfaceC1527j interfaceC1527j = this.f4828a;
        Modality modality = this.b;
        C1531n c1531n = this.c;
        InterfaceC1501I interfaceC1501I = this.d;
        CallableMemberDescriptor$Kind callableMemberDescriptor$Kind = this.e;
        G8.f fVar = this.i;
        H h = this.k;
        H hT0 = h.T0(interfaceC1527j, modality, c1531n, interfaceC1501I, callableMemberDescriptor$Kind, fVar);
        List typeParameters = h.getTypeParameters();
        ArrayList arrayList = new ArrayList(((ArrayList) typeParameters).size());
        kotlin.reflect.jvm.internal.impl.types.a aVarA = AbstractC0272c.A(typeParameters, this.f, hT0, arrayList);
        Variance variance = Variance.e;
        X8.w wVar = this.f4829j;
        X8.w wVarI = aVarA.i(wVar, variance);
        if (wVarI != null) {
            Variance variance2 = Variance.d;
            X8.w wVarI2 = aVarA.i(wVar, variance2);
            if (wVarI2 != null) {
                hT0.X0(wVarI2);
            }
            u uVar5 = this.h;
            if (uVar5 != null) {
                u uVarB = uVar5.b(aVarA);
                uVar = uVarB != null ? uVarB : null;
            }
            u uVar6 = h.u;
            if (uVar6 != null) {
                X8.w wVarI3 = aVarA.i(uVar6.getType(), variance2);
                if (wVarI3 == null) {
                    uVar4 = null;
                } else {
                    uVar6.R0();
                    uVar4 = new u(hT0, new R8.b(hT0, wVarI3), uVar6.getAnnotations());
                }
                uVar2 = uVar4;
            } else {
                uVar2 = null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (u uVar7 : h.f4833s) {
                X8.w wVarI4 = aVarA.i(uVar7.getType(), Variance.d);
                if (wVarI4 == null) {
                    uVar3 = null;
                } else {
                    G8.f fVarP0 = ((R8.a) uVar7.R0()).P0();
                    uVar7.R0();
                    uVar3 = new u(hT0, new R8.a(hT0, wVarI4, fVarP0), uVar7.getAnnotations());
                }
                if (uVar3 != null) {
                    arrayList2.add(uVar3);
                }
            }
            hT0.Y0(wVarI, arrayList, uVar, uVar2, arrayList2);
            I i6 = h.f4836w;
            CallableMemberDescriptor$Kind callableMemberDescriptor$Kind2 = CallableMemberDescriptor$Kind.b;
            C1504L c1504l = InterfaceC1503K.f4577I;
            if (i6 == null) {
                i = null;
            } else {
                InterfaceC1561g annotations = i6.getAnnotations();
                Modality modality2 = this.b;
                C1531n visibility = h.f4836w.getVisibility();
                if (this.e == callableMemberDescriptor$Kind2 && AbstractC1532o.e(AbstractC1532o.f(visibility.f4582a.c()))) {
                    visibility = AbstractC1532o.h;
                }
                C1531n c1531n2 = visibility;
                I i10 = h.f4836w;
                boolean z10 = i10.e;
                boolean z11 = i10.f;
                boolean z12 = i10.i;
                CallableMemberDescriptor$Kind callableMemberDescriptor$Kind3 = this.e;
                InterfaceC1501I interfaceC1501I2 = this.d;
                i = new I(hT0, annotations, modality2, c1531n2, z10, z11, z12, callableMemberDescriptor$Kind3, interfaceC1501I2 == null ? null : interfaceC1501I2.getGetter(), c1504l);
            }
            if (i != null) {
                I i11 = h.f4836w;
                X8.w wVar2 = i11.m;
                i.l = H.U0(aVarA, i11);
                i.U0(wVar2 != null ? aVarA.i(wVar2, Variance.e) : null);
            }
            J j6 = h.f4837x;
            if (j6 == null) {
                j5 = null;
            } else {
                InterfaceC1561g annotations2 = j6.getAnnotations();
                Modality modality3 = this.b;
                C1531n visibility2 = h.f4837x.getVisibility();
                if (this.e == callableMemberDescriptor$Kind2 && AbstractC1532o.e(AbstractC1532o.f(visibility2.f4582a.c()))) {
                    visibility2 = AbstractC1532o.h;
                }
                C1531n c1531n3 = visibility2;
                J j10 = h.f4837x;
                boolean z13 = j10.e;
                boolean z14 = j10.f;
                boolean z15 = j10.i;
                CallableMemberDescriptor$Kind callableMemberDescriptor$Kind4 = this.e;
                InterfaceC1501I interfaceC1501I3 = this.d;
                j5 = new J(hT0, annotations2, modality3, c1531n3, z13, z14, z15, callableMemberDescriptor$Kind4, interfaceC1501I3 == null ? null : interfaceC1501I3.getSetter(), c1504l);
            }
            if (j5 != null) {
                aVar = aVarA;
                List listV0 = t.V0(j5, h.f4837x.x(), aVar, false, false, null);
                if (listV0 == null) {
                    listV0 = Collections.singletonList(J.T0(j5, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(this.f4828a).n(), ((Q) h.f4837x.x().get(0)).getAnnotations()));
                }
                if (listV0.size() != 1) {
                    throw new IllegalStateException();
                }
                j5.l = H.U0(aVar, h.f4837x);
                Q q5 = (Q) listV0.get(0);
                if (q5 == null) {
                    J.C0(6);
                    throw null;
                }
                j5.m = q5;
            } else {
                aVar = aVarA;
            }
            r rVar = h.y;
            r rVar2 = rVar == null ? null : new r(rVar.getAnnotations(), hT0);
            r rVar3 = h.f4838z;
            hT0.V0(i, j5, rVar2, rVar3 != null ? new r(rVar3.getAnnotations(), hT0) : null);
            if (this.g) {
                int i12 = g9.i.c;
                g9.i iVarF = g9.l.f();
                Iterator it = h.e().iterator();
                while (it.hasNext()) {
                    iVarF.add(((InterfaceC1501I) it.next()).b(aVar));
                }
                hT0.k = iVarF;
            }
            if (h.isConst() && (aVar2 = h.h) != null) {
                hT0.W0(h.g, aVar2);
            }
            return hT0;
        }
        return null;
    }
}
