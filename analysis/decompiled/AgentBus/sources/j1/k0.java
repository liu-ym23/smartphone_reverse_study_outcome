package j1;

import android.R;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class k0 implements x1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class[] f5214a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final boolean d(p1.n nVar) {
        p1.i iVarK = nVar.k();
        return !iVarK.f8304f.c(p1.s.f8352i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005b, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.view.View f(android.view.View r4, android.view.View r5, int r6) {
        /*
            r0 = 1
            r1 = -1
            r2 = 0
            if (r6 == r0) goto L33
            r0 = 2
            if (r6 == r0) goto L9
            goto L39
        L9:
            int r6 = r4.getNextFocusForwardId()
            if (r6 != r1) goto L10
            goto L39
        L10:
            j1.v r0 = new j1.v
            r1 = 1
            r0.<init>(r6, r1)
            r6 = r2
        L17:
            android.view.View r6 = j(r4, r0, r6)
            if (r6 != 0) goto L32
            if (r4 != r5) goto L20
            goto L32
        L20:
            android.view.ViewParent r6 = r4.getParent()
            if (r6 == 0) goto L31
            boolean r1 = r6 instanceof android.view.View
            if (r1 != 0) goto L2b
            goto L31
        L2b:
            android.view.View r6 = (android.view.View) r6
            r3 = r6
            r6 = r4
            r4 = r3
            goto L17
        L31:
            return r2
        L32:
            return r6
        L33:
            int r6 = r4.getId()
            if (r6 != r1) goto L3a
        L39:
            return r2
        L3a:
            g1.y r6 = new g1.y
            r0 = 6
            r6.<init>(r0, r5, r4)
            r0 = r2
        L41:
            android.view.View r0 = j(r4, r6, r0)
            if (r0 != 0) goto L5c
            if (r4 != r5) goto L4a
            goto L5c
        L4a:
            android.view.ViewParent r0 = r4.getParent()
            if (r0 == 0) goto L5b
            boolean r1 = r0 instanceof android.view.View
            if (r1 != 0) goto L55
            goto L5b
        L55:
            android.view.View r0 = (android.view.View) r0
            r3 = r0
            r0 = r4
            r4 = r3
            goto L41
        L5b:
            return r2
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.k0.f(android.view.View, android.view.View, int):android.view.View");
    }

    public static final boolean g(p1.n nVar, Resources resources) {
        boolean z4;
        Object objG = nVar.f8315d.f8304f.g(p1.s.f8344a);
        if (objG == null) {
            objG = null;
        }
        List list = (List) objG;
        boolean z10 = ((list != null ? (String) d7.r.P0(list) : null) == null && m(nVar) == null && l(nVar, resources) == null && !k(nVar)) ? false : true;
        if (!p1.q.e(nVar)) {
            if (!nVar.f8315d.f8306h) {
                if (!nVar.f8316e && nVar.i((4 & 1) != 0 ? !nVar.f8313b : false, (4 & 2) == 0).isEmpty()) {
                    i1.f0 f0VarN = nVar.f8314c.n();
                    while (true) {
                        z4 = true;
                        if (f0VarN == null) {
                            f0VarN = null;
                            break;
                        }
                        p1.i iVarQ = f0VarN.q();
                        if (iVarQ != null && iVarQ.f8306h) {
                            break;
                        }
                        f0VarN = f0VarN.n();
                    }
                    if (f0VarN != null) {
                    }
                    if (z4 || !z10) {
                    }
                }
                z4 = false;
                if (z4) {
                }
            }
            return true;
        }
        return false;
    }

    public static final void h(p1.n nVar, p2.h hVar) {
        p1.i iVar = nVar.f8315d;
        k.a0 a0Var = iVar.f8304f;
        Object objG = iVar.f8304f.g(p1.s.f8365v);
        if (objG == null) {
            objG = null;
        }
        if (d(nVar)) {
            Object objG2 = a0Var.g(p1.h.f8299v);
            if (objG2 == null) {
                objG2 = null;
            }
            p1.a aVar = (p1.a) objG2;
            if (aVar != null) {
                hVar.a(new p2.d(null, R.id.accessibilityActionPageUp, aVar.f8266a, null));
            }
            Object objG3 = a0Var.g(p1.h.f8301x);
            if (objG3 == null) {
                objG3 = null;
            }
            p1.a aVar2 = (p1.a) objG3;
            if (aVar2 != null) {
                hVar.a(new p2.d(null, R.id.accessibilityActionPageDown, aVar2.f8266a, null));
            }
            Object objG4 = a0Var.g(p1.h.f8300w);
            if (objG4 == null) {
                objG4 = null;
            }
            p1.a aVar3 = (p1.a) objG4;
            if (aVar3 != null) {
                hVar.a(new p2.d(null, R.id.accessibilityActionPageLeft, aVar3.f8266a, null));
            }
            Object objG5 = a0Var.g(p1.h.f8302y);
            if (objG5 == null) {
                objG5 = null;
            }
            p1.a aVar4 = (p1.a) objG5;
            if (aVar4 != null) {
                hVar.a(new p2.d(null, R.id.accessibilityActionPageRight, aVar4.f8266a, null));
            }
        }
    }

    public static final boolean i(Object obj) {
        if (obj instanceof l0.n) {
            l0.n nVar = (l0.n) obj;
            if (nVar.b() == b0.b1.f1108h || nVar.b() == b0.b1.f1111k || nVar.b() == b0.b1.f1109i) {
                Object value = nVar.getValue();
                if (value == null) {
                    return true;
                }
                return i(value);
            }
        } else {
            if ((obj instanceof c7.c) && (obj instanceof Serializable)) {
                return false;
            }
            for (int i2 = 0; i2 < 7; i2++) {
                if (f5214a[i2].isInstance(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final View j(View view, p7.k kVar, View view2) {
        View viewJ;
        if (((Boolean) kVar.invoke(view)).booleanValue()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != view2 && (viewJ = j(childAt, kVar, view2)) != null) {
                return viewJ;
            }
        }
        return null;
    }

    public static final boolean k(p1.n nVar) {
        Object objG = nVar.f8315d.f8304f.g(p1.s.F);
        if (objG == null) {
            objG = null;
        }
        r1.a aVar = (r1.a) objG;
        k.a0 a0Var = nVar.f8315d.f8304f;
        Object objG2 = a0Var.g(p1.s.f8365v);
        if (objG2 == null) {
            objG2 = null;
        }
        boolean z4 = aVar != null;
        Object objG3 = a0Var.g(p1.s.E);
        if (((Boolean) (objG3 != null ? objG3 : null)) != null) {
            return true;
        }
        return z4;
    }

    public static final String l(p1.n nVar, Resources resources) throws Resources.NotFoundException {
        int iOrdinal;
        p1.i iVar = nVar.f8315d;
        p1.i iVar2 = nVar.f8315d;
        Object objG = iVar.f8304f.g(p1.s.f8345b);
        String string = null;
        if (objG == null) {
            objG = null;
        }
        k.a0 a0Var = iVar2.f8304f;
        Object objG2 = a0Var.g(p1.s.F);
        if (objG2 == null) {
            objG2 = null;
        }
        r1.a aVar = (r1.a) objG2;
        Object objG3 = a0Var.g(p1.s.f8365v);
        if (objG3 == null) {
            objG3 = null;
        }
        if (aVar != null && (iOrdinal = aVar.ordinal()) != 0 && iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new a4.u();
            }
            if (objG == null) {
                objG = resources.getString(com.stepos.agentbus.R.string.indeterminate);
            }
        }
        Object objG4 = a0Var.g(p1.s.E);
        if (objG4 == null) {
            objG4 = null;
        }
        Boolean bool = (Boolean) objG4;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if (objG == null) {
                objG = zBooleanValue ? resources.getString(com.stepos.agentbus.R.string.selected) : resources.getString(com.stepos.agentbus.R.string.not_selected);
            }
        }
        Object objG5 = a0Var.g(p1.s.f8346c);
        if (objG5 == null) {
            objG5 = null;
        }
        p1.e eVar = (p1.e) objG5;
        if (eVar != null) {
            if (eVar != p1.e.f8274b) {
                if (objG == null) {
                    objG = resources.getString(com.stepos.agentbus.R.string.template_percent, 0);
                }
            } else if (objG == null) {
                objG = resources.getString(com.stepos.agentbus.R.string.in_progress);
            }
        }
        p1.v vVar = p1.s.C;
        if (a0Var.c(vVar)) {
            k.a0 a0Var2 = new p1.n(nVar.f8312a, true, nVar.f8314c, iVar2).k().f8304f;
            Object objG6 = a0Var2.g(p1.s.f8344a);
            if (objG6 == null) {
                objG6 = null;
            }
            Collection collection = (Collection) objG6;
            if (collection == null || collection.isEmpty()) {
                Object objG7 = a0Var2.g(p1.s.f8368y);
                if (objG7 == null) {
                    objG7 = null;
                }
                Collection collection2 = (Collection) objG7;
                if (collection2 == null || collection2.isEmpty()) {
                    Object objG8 = a0Var2.g(vVar);
                    if (objG8 == null) {
                        objG8 = null;
                    }
                    CharSequence charSequence = (CharSequence) objG8;
                    if (charSequence == null || charSequence.length() == 0) {
                        string = resources.getString(com.stepos.agentbus.R.string.state_empty);
                    }
                }
            }
            objG = string;
        }
        return (String) objG;
    }

    public static final s1.e m(p1.n nVar) {
        p1.i iVar = nVar.f8315d;
        p1.v vVar = p1.s.f8344a;
        s1.e eVar = (s1.e) p1.q.d(iVar, p1.s.C);
        List list = (List) p1.q.d(nVar.f8315d, p1.s.f8368y);
        return eVar == null ? list != null ? (s1.e) d7.r.P0(list) : null : eVar;
    }

    public static final s1.e0 n(p1.i iVar) {
        p7.k kVar;
        ArrayList arrayList = new ArrayList();
        Object objG = iVar.f8304f.g(p1.h.f8278a);
        if (objG == null) {
            objG = null;
        }
        p1.a aVar = (p1.a) objG;
        if (aVar == null || (kVar = (p7.k) aVar.f8267b) == null || !((Boolean) kVar.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (s1.e0) arrayList.get(0);
    }

    public static final boolean o(float[] fArr, float[] fArr2) {
        if (fArr.length < 16 || fArr2.length < 16) {
            return false;
        }
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float f13 = fArr[3];
        float f14 = fArr[4];
        float f15 = fArr[5];
        float f16 = fArr[6];
        float f17 = fArr[7];
        float f18 = fArr[8];
        float f19 = fArr[9];
        float f20 = fArr[10];
        float f21 = fArr[11];
        float f22 = fArr[12];
        float f23 = fArr[13];
        float f24 = fArr[14];
        float f25 = fArr[15];
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f10 * f17) - (f13 * f14);
        float f29 = (f11 * f16) - (f12 * f15);
        float f30 = (f11 * f17) - (f13 * f15);
        float f31 = (f12 * f17) - (f13 * f16);
        float f32 = (f18 * f23) - (f19 * f22);
        float f33 = (f18 * f24) - (f20 * f22);
        float f34 = (f18 * f25) - (f21 * f22);
        float f35 = (f19 * f24) - (f20 * f23);
        float f36 = (f19 * f25) - (f21 * f23);
        float f37 = (f20 * f25) - (f21 * f24);
        float f38 = (f31 * f32) + (((f29 * f34) + ((f28 * f35) + ((f26 * f37) - (f27 * f36)))) - (f30 * f33));
        if (f38 != 0.0f) {
            float f39 = 1.0f / f38;
            fArr2[0] = ((f17 * f35) + ((f15 * f37) - (f16 * f36))) * f39;
            fArr2[1] = (((f12 * f36) + ((-f11) * f37)) - (f13 * f35)) * f39;
            fArr2[2] = ((f25 * f29) + ((f23 * f31) - (f24 * f30))) * f39;
            fArr2[3] = (((f20 * f30) + ((-f19) * f31)) - (f21 * f29)) * f39;
            float f40 = -f14;
            fArr2[4] = (((f16 * f34) + (f40 * f37)) - (f17 * f33)) * f39;
            fArr2[5] = ((f13 * f33) + ((f37 * f10) - (f12 * f34))) * f39;
            float f41 = -f22;
            fArr2[6] = (((f24 * f28) + (f41 * f31)) - (f25 * f27)) * f39;
            fArr2[7] = ((f21 * f27) + ((f31 * f18) - (f20 * f28))) * f39;
            fArr2[8] = ((f17 * f32) + ((f14 * f36) - (f15 * f34))) * f39;
            fArr2[9] = (((f34 * f11) + ((-f10) * f36)) - (f13 * f32)) * f39;
            fArr2[10] = ((f25 * f26) + ((f22 * f30) - (f23 * f28))) * f39;
            fArr2[11] = (((f28 * f19) + ((-f18) * f30)) - (f21 * f26)) * f39;
            fArr2[12] = (((f15 * f33) + (f40 * f35)) - (f16 * f32)) * f39;
            fArr2[13] = ((f12 * f32) + ((f10 * f35) - (f11 * f33))) * f39;
            fArr2[14] = (((f23 * f27) + (f41 * f29)) - (f24 * f26)) * f39;
            fArr2[15] = ((f20 * f26) + ((f18 * f29) - (f19 * f27))) * f39;
        }
        return !(f38 == 0.0f);
    }

    public static final boolean p(u0.f fVar, float f10, float f11) {
        t0.c cVar = new t0.c(f10 - 0.005f, f11 - 0.005f, f10 + 0.005f, f11 + 0.005f);
        u0.f fVarA = u0.h.a();
        u0.f.a(fVarA, cVar);
        u0.f fVarA2 = u0.h.a();
        fVarA2.d(fVar, fVarA, 1);
        boolean zIsEmpty = fVarA2.f9903a.isEmpty();
        fVarA2.e();
        fVarA.e();
        return !zIsEmpty;
    }

    public static final boolean q(float f10, float f11, float f12, float f13, long j2) {
        float f14 = f10 - f12;
        float f15 = f11 - f13;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L));
        return ((f15 * f15) / (fIntBitsToFloat2 * fIntBitsToFloat2)) + ((f14 * f14) / (fIntBitsToFloat * fIntBitsToFloat)) <= 1.0f;
    }

    public static final void r(w0 w0Var, int i2) {
        Object next;
        Iterator<T> it = w0Var.getLayoutNodeToHolder().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((i1.f0) ((Map.Entry) next).getKey()).f4453g == i2) {
                    break;
                }
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null && entry.getValue() != null) {
            throw new ClassCastException();
        }
    }

    public static final String s(Object obj) {
        return (obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName()) + '@' + String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
    }
}
