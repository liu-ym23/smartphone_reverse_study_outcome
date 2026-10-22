package v1;

import android.R;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.RectF;
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

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g0 implements t1 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class[] f14425c = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final boolean g(a2.p pVar) {
        a2.k kVarK = pVar.k();
        return !kVarK.f75c.c(a2.u.i);
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
    public static final android.view.View i(android.view.View r4, android.view.View r5, int r6) {
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
            v1.r r0 = new v1.r
            r1 = 1
            r0.<init>(r6, r1)
            r6 = r2
        L17:
            android.view.View r6 = n(r4, r0, r6)
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
            v1.i0 r6 = new v1.i0
            r0 = 4
            r6.<init>(r0, r5, r4)
            r0 = r2
        L41:
            android.view.View r0 = n(r4, r6, r0)
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
        throw new UnsupportedOperationException("Method not decompiled: v1.g0.i(android.view.View, android.view.View, int):android.view.View");
    }

    public static final boolean j(a2.p pVar, Resources resources) {
        Object objG = pVar.f88d.f75c.g(a2.u.f117a);
        if (objG == null) {
            objG = null;
        }
        List list = (List) objG;
        return !a2.s.e(pVar) && (pVar.f88d.f77g || (pVar.n() && ((list != null ? (String) kb.l.x0(list) : null) != null || q(pVar) != null || p(pVar, resources) != null || o(pVar))));
    }

    public static final void k(a2.p pVar, o3.e eVar) {
        a2.k kVar = pVar.f88d;
        p.f0 f0Var = kVar.f75c;
        Object objG = kVar.f75c.g(a2.u.f138w);
        if (objG == null) {
            objG = null;
        }
        a2.g gVar = (a2.g) objG;
        if (g(pVar)) {
            if (gVar != null && gVar.f45a == 8) {
                return;
            }
            Object objG2 = f0Var.g(a2.j.f71w);
            if (objG2 == null) {
                objG2 = null;
            }
            a2.a aVar = (a2.a) objG2;
            if (aVar != null) {
                eVar.b(new o3.b(R.id.accessibilityActionPageUp, aVar.f29a));
            }
            Object objG3 = f0Var.g(a2.j.f73y);
            if (objG3 == null) {
                objG3 = null;
            }
            a2.a aVar2 = (a2.a) objG3;
            if (aVar2 != null) {
                eVar.b(new o3.b(R.id.accessibilityActionPageDown, aVar2.f29a));
            }
            Object objG4 = f0Var.g(a2.j.f72x);
            if (objG4 == null) {
                objG4 = null;
            }
            a2.a aVar3 = (a2.a) objG4;
            if (aVar3 != null) {
                eVar.b(new o3.b(R.id.accessibilityActionPageLeft, aVar3.f29a));
            }
            Object objG5 = f0Var.g(a2.j.f74z);
            a2.a aVar4 = (a2.a) (objG5 != null ? objG5 : null);
            if (aVar4 != null) {
                eVar.b(new o3.b(R.id.accessibilityActionPageRight, aVar4.f29a));
            }
        }
    }

    public static final boolean l(Object obj) {
        if (obj instanceof u0.n) {
            u0.n nVar = (u0.n) obj;
            if (nVar.b() == k0.y0.f7137g || nVar.b() == k0.y0.f7139j || nVar.b() == k0.y0.f7138h) {
                Object value = nVar.getValue();
                if (value == null) {
                    return true;
                }
                return l(value);
            }
        } else {
            if ((obj instanceof jb.b) && (obj instanceof Serializable)) {
                return false;
            }
            for (int i = 0; i < 7; i++) {
                if (f14425c[i].isInstance(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final int m(float f5) {
        return ((int) (f5 >= 0.0f ? Math.ceil(f5) : Math.floor(f5))) * (-1);
    }

    public static final View n(View view, xb.l lVar, View view2) {
        View viewN;
        if (((Boolean) lVar.invoke(view)).booleanValue()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != view2 && (viewN = n(childAt, lVar, view2)) != null) {
                return viewN;
            }
        }
        return null;
    }

    public static final boolean o(a2.p pVar) {
        Object objG = pVar.f88d.f75c.g(a2.u.G);
        if (objG == null) {
            objG = null;
        }
        c2.a aVar = (c2.a) objG;
        p.f0 f0Var = pVar.f88d.f75c;
        Object objG2 = f0Var.g(a2.u.f138w);
        if (objG2 == null) {
            objG2 = null;
        }
        a2.g gVar = (a2.g) objG2;
        boolean z10 = aVar != null;
        Object objG3 = f0Var.g(a2.u.F);
        if (((Boolean) (objG3 != null ? objG3 : null)) == null || (gVar != null && gVar.f45a == 4)) {
            return z10;
        }
        return true;
    }

    public static final String p(a2.p pVar, Resources resources) throws Resources.NotFoundException {
        a2.k kVar = pVar.f88d;
        a2.k kVar2 = pVar.f88d;
        Object objG = kVar.f75c.g(a2.u.f118b);
        String string = null;
        if (objG == null) {
            objG = null;
        }
        p.f0 f0Var = kVar2.f75c;
        Object objG2 = f0Var.g(a2.u.G);
        if (objG2 == null) {
            objG2 = null;
        }
        c2.a aVar = (c2.a) objG2;
        Object objG3 = f0Var.g(a2.u.f138w);
        if (objG3 == null) {
            objG3 = null;
        }
        a2.g gVar = (a2.g) objG3;
        if (aVar != null) {
            int iOrdinal = aVar.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        g5.f.a();
                        return null;
                    }
                    if (objG == null) {
                        objG = resources.getString(com.stepos.agentsafetycenter.R.string.indeterminate);
                    }
                } else if (gVar != null && gVar.f45a == 2 && objG == null) {
                    objG = resources.getString(com.stepos.agentsafetycenter.R.string.state_off);
                }
            } else if (gVar != null && gVar.f45a == 2 && objG == null) {
                objG = resources.getString(com.stepos.agentsafetycenter.R.string.state_on);
            }
        }
        Object objG4 = f0Var.g(a2.u.F);
        if (objG4 == null) {
            objG4 = null;
        }
        Boolean bool = (Boolean) objG4;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if ((gVar == null || gVar.f45a != 4) && objG == null) {
                objG = zBooleanValue ? resources.getString(com.stepos.agentsafetycenter.R.string.selected) : resources.getString(com.stepos.agentsafetycenter.R.string.not_selected);
            }
        }
        Object objG5 = f0Var.g(a2.u.f119c);
        if (objG5 == null) {
            objG5 = null;
        }
        a2.f fVar = (a2.f) objG5;
        if (fVar != null) {
            if (fVar != a2.f.f43b) {
                if (objG == null) {
                    objG = resources.getString(com.stepos.agentsafetycenter.R.string.template_percent, 0);
                }
            } else if (objG == null) {
                objG = resources.getString(com.stepos.agentsafetycenter.R.string.in_progress);
            }
        }
        a2.x xVar = a2.u.D;
        if (f0Var.c(xVar)) {
            p.f0 f0Var2 = new a2.p(pVar.f85a, true, pVar.f87c, kVar2).k().f75c;
            Object objG6 = f0Var2.g(a2.u.f117a);
            if (objG6 == null) {
                objG6 = null;
            }
            Collection collection = (Collection) objG6;
            if (collection == null || collection.isEmpty()) {
                Object objG7 = f0Var2.g(a2.u.f141z);
                if (objG7 == null) {
                    objG7 = null;
                }
                Collection collection2 = (Collection) objG7;
                if (collection2 == null || collection2.isEmpty()) {
                    Object objG8 = f0Var2.g(xVar);
                    if (objG8 == null) {
                        objG8 = null;
                    }
                    CharSequence charSequence = (CharSequence) objG8;
                    if (charSequence == null || charSequence.length() == 0) {
                        string = resources.getString(com.stepos.agentsafetycenter.R.string.state_empty);
                    }
                }
            }
            objG = string;
        }
        return (String) objG;
    }

    public static final d2.g q(a2.p pVar) {
        Object objG = pVar.f88d.f75c.g(a2.u.D);
        if (objG == null) {
            objG = null;
        }
        d2.g gVar = (d2.g) objG;
        Object objG2 = pVar.f88d.f75c.g(a2.u.f141z);
        if (objG2 == null) {
            objG2 = null;
        }
        List list = (List) objG2;
        return gVar == null ? list != null ? (d2.g) kb.l.x0(list) : null : gVar;
    }

    public static final d2.i0 r(a2.k kVar) {
        xb.l lVar;
        ArrayList arrayList = new ArrayList();
        Object objG = kVar.f75c.g(a2.j.f50a);
        if (objG == null) {
            objG = null;
        }
        a2.a aVar = (a2.a) objG;
        if (aVar == null || (lVar = (xb.l) aVar.f30b) == null || !((Boolean) lVar.invoke(arrayList)).booleanValue()) {
            return null;
        }
        return (d2.i0) arrayList.get(0);
    }

    public static final boolean s(float[] fArr, float[] fArr2) {
        if (fArr.length < 16 || fArr2.length < 16) {
            return false;
        }
        float f5 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        float f13 = fArr[4];
        float f14 = fArr[5];
        float f15 = fArr[6];
        float f16 = fArr[7];
        float f17 = fArr[8];
        float f18 = fArr[9];
        float f19 = fArr[10];
        float f20 = fArr[11];
        float f21 = fArr[12];
        float f22 = fArr[13];
        float f23 = fArr[14];
        float f24 = fArr[15];
        float f25 = (f5 * f14) - (f10 * f13);
        float f26 = (f5 * f15) - (f11 * f13);
        float f27 = (f5 * f16) - (f12 * f13);
        float f28 = (f10 * f15) - (f11 * f14);
        float f29 = (f10 * f16) - (f12 * f14);
        float f30 = (f11 * f16) - (f12 * f15);
        float f31 = (f17 * f22) - (f18 * f21);
        float f32 = (f17 * f23) - (f19 * f21);
        float f33 = (f17 * f24) - (f20 * f21);
        float f34 = (f18 * f23) - (f19 * f22);
        float f35 = (f18 * f24) - (f20 * f22);
        float f36 = (f19 * f24) - (f20 * f23);
        float f37 = (f30 * f31) + (((f28 * f33) + ((f27 * f34) + ((f25 * f36) - (f26 * f35)))) - (f29 * f32));
        if (f37 != 0.0f) {
            float f38 = 1.0f / f37;
            fArr2[0] = ((f16 * f34) + ((f14 * f36) - (f15 * f35))) * f38;
            fArr2[1] = (((f11 * f35) + ((-f10) * f36)) - (f12 * f34)) * f38;
            fArr2[2] = ((f24 * f28) + ((f22 * f30) - (f23 * f29))) * f38;
            fArr2[3] = (((f19 * f29) + ((-f18) * f30)) - (f20 * f28)) * f38;
            float f39 = -f13;
            fArr2[4] = (((f15 * f33) + (f39 * f36)) - (f16 * f32)) * f38;
            fArr2[5] = ((f12 * f32) + ((f36 * f5) - (f11 * f33))) * f38;
            float f40 = -f21;
            fArr2[6] = (((f23 * f27) + (f40 * f30)) - (f24 * f26)) * f38;
            fArr2[7] = ((f20 * f26) + ((f30 * f17) - (f19 * f27))) * f38;
            fArr2[8] = ((f16 * f31) + ((f13 * f35) - (f14 * f33))) * f38;
            fArr2[9] = (((f33 * f10) + ((-f5) * f35)) - (f12 * f31)) * f38;
            fArr2[10] = ((f24 * f25) + ((f21 * f29) - (f22 * f27))) * f38;
            fArr2[11] = (((f27 * f18) + ((-f17) * f29)) - (f20 * f25)) * f38;
            fArr2[12] = (((f14 * f32) + (f39 * f34)) - (f15 * f31)) * f38;
            fArr2[13] = ((f11 * f31) + ((f5 * f34) - (f10 * f32))) * f38;
            fArr2[14] = (((f22 * f26) + (f40 * f28)) - (f23 * f25)) * f38;
            fArr2[15] = ((f19 * f25) + ((f17 * f28) - (f18 * f26))) * f38;
        }
        return !(f37 == 0.0f);
    }

    public static final boolean t(float f5, float f10, d1.h hVar) {
        float f11 = f5 - 0.005f;
        float f12 = f10 - 0.005f;
        float f13 = f5 + 0.005f;
        float f14 = f10 + 0.005f;
        d1.h hVarA = d1.k.a();
        Path path = hVarA.f2990a;
        d1.d0[] d0VarArr = d1.d0.f2965c;
        if (Float.isNaN(f11) || Float.isNaN(f12) || Float.isNaN(f13) || Float.isNaN(f14)) {
            d1.k.b("Invalid rectangle, make sure no value is NaN");
        }
        if (hVarA.f2991b == null) {
            hVarA.f2991b = new RectF();
        }
        RectF rectF = hVarA.f2991b;
        rectF.getClass();
        rectF.set(f11, f12, f13, f14);
        RectF rectF2 = hVarA.f2991b;
        rectF2.getClass();
        path.addRect(rectF2, Path.Direction.CCW);
        d1.h hVarA2 = d1.k.a();
        Path path2 = hVarA2.f2990a;
        hVarA2.c(hVar, hVarA, 1);
        boolean zIsEmpty = path2.isEmpty();
        path2.reset();
        path.reset();
        return !zIsEmpty;
    }

    public static final boolean u(float f5, float f10, float f11, float f12, long j10) {
        float f13 = f5 - f11;
        float f14 = f10 - f12;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L));
        return ((f14 * f14) / (fIntBitsToFloat2 * fIntBitsToFloat2)) + ((f13 * f13) / (fIntBitsToFloat * fIntBitsToFloat)) <= 1.0f;
    }

    public static final r2.h v(q0 q0Var, int i) {
        Object next;
        Iterator<T> it = q0Var.getLayoutNodeToHolder().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((u1.g0) ((Map.Entry) next).getKey()).f13790f == i) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (r2.h) entry.getValue();
        }
        return null;
    }

    public static final String w(Object obj) {
        return (obj.getClass().isAnonymousClass() ? obj.getClass().getName() : obj.getClass().getSimpleName()) + '@' + String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(obj))}, 1));
    }

    public static final String x(int i) {
        if (i == 0) {
            return "android.widget.Button";
        }
        if (i == 1) {
            return "android.widget.CheckBox";
        }
        if (i == 3) {
            return "android.widget.RadioButton";
        }
        if (i == 5) {
            return "android.widget.ImageView";
        }
        if (i == 6) {
            return "android.widget.Spinner";
        }
        if (i == 7) {
            return "android.widget.NumberPicker";
        }
        return null;
    }
}
