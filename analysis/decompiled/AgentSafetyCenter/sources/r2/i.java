package r2;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import stepos.support.v7.app.x;
import stepos.support.v7.widget.k0;
import stepos.support.v7.widget.n0;
import te.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i implements n1.a, h.a, n0, u, k0, rd.a, nb.f {

    /* renamed from: f, reason: collision with root package name */
    public static i f10408f;

    /* renamed from: g, reason: collision with root package name */
    public static volatile i f10409g;

    /* renamed from: h, reason: collision with root package name */
    public static HashMap f10410h;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10411c;

    public /* synthetic */ i(int i) {
        this.f10411c = i;
    }

    public static final void c(String str, String str2) {
        if (str2.length() == 0) {
            Log.i("NotePaperRepo", str.concat("=(empty)"));
            return;
        }
        if (str2.length() <= 900) {
            Log.i("NotePaperRepo", str + "=" + str2);
            return;
        }
        int i = 0;
        int i3 = 0;
        while (i < str2.length()) {
            int i10 = i + 900;
            int length = str2.length();
            if (i10 > length) {
                i10 = length;
            }
            Log.i("NotePaperRepo", str + " part[" + i3 + "]=" + str2.substring(i, i10));
            i3++;
            i = i10;
        }
    }

    public static final float[] d() {
        float[] fArr = s.p.f11076s;
        if (fArr != null) {
            return fArr;
        }
        float[] fArr2 = new float[91];
        s.p.f11076s = fArr2;
        return fArr2;
    }

    public static final aa.e f(i iVar, int i) {
        for (aa.e eVar : aa.e.values()) {
            if (eVar.f314c == i) {
                return eVar;
            }
        }
        g5.f.m("Array contains no element matching the predicate.");
        return null;
    }

    public static final y9.b g(i iVar, float f5, float f10, float f11, List list) {
        y9.a aVar = new y9.a(0);
        aVar.f16028f = f5;
        VarHandle.storeStoreFence();
        y9.a aVar2 = new y9.a(1);
        aVar2.f16028f = f10;
        VarHandle.storeStoreFence();
        y9.a aVar3 = new y9.a(2);
        aVar3.f16028f = f11;
        VarHandle.storeStoreFence();
        k8.d dVar = new k8.d(25);
        hc.p pVar = new hc.p(5);
        pVar.f5466f = list;
        VarHandle.storeStoreFence();
        return new y9.b(24.0f, aVar, aVar2, aVar3, dVar, pVar, new k8.d(24));
    }

    public static Class h(String str) {
        va.a aVar = (va.a) f10410h.get(str);
        if (aVar != null) {
            return aVar.f14864a;
        }
        Class<?> cls = Class.forName(str);
        va.a aVar2 = new va.a();
        aVar2.f14865b = new HashMap();
        new HashMap();
        aVar2.f14864a = cls;
        VarHandle.storeStoreFence();
        f10410h.put(str, aVar2);
        return cls;
    }

    public static i m() {
        if (f10408f == null) {
            i iVar = new i(4);
            z3.g gVar = new z3.g(new w.d());
            x xVar = new x(0);
            VarHandle.storeStoreFence();
            gVar.a(xVar);
            z3.g gVar2 = new z3.g(new w.d());
            x xVar2 = new x(1);
            VarHandle.storeStoreFence();
            gVar2.a(xVar2);
            VarHandle.storeStoreFence();
            f10408f = iVar;
        }
        return f10408f;
    }

    public static Method n(Class cls, Class... clsArr) {
        if (((va.a) f10410h.get(cls.getName())) == null) {
            try {
                h(cls.getName());
            } catch (ClassNotFoundException e10) {
                e10.printStackTrace();
            }
        }
        va.a aVar = (va.a) f10410h.get(cls.getName());
        if (aVar == null) {
            return null;
        }
        HashMap map = aVar.f14865b;
        String string = "get";
        for (Class cls2 : clsArr) {
            StringBuilder sbC = w2.c.c(string);
            sbC.append(cls2.toString());
            string = sbC.toString();
        }
        Method method = (Method) map.get(string);
        if (method != null) {
            return method;
        }
        Method method2 = cls.getMethod("get", clsArr);
        map.put(string, method2);
        return method2;
    }

    @Override // rd.a
    public rd.b a(String str) {
        return td.b.f13293c;
    }

    @Override // te.u
    public boolean e(te.l lVar) {
        return false;
    }

    public t8.c i(Context context) {
        t8.c cVar;
        context.getClass();
        t8.c cVar2 = t8.c.f13218c;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this) {
            cVar = t8.c.f13218c;
            if (cVar == null) {
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                w4.e eVarB = com.stepos.statsrpk.h.B(applicationContext, "agent_safety_delete_receipts_secure", "agent_safety_delete_receipts");
                cVar = new t8.c();
                cVar.f13224a = eVarB;
                VarHandle.storeStoreFence();
                t8.c.f13218c = cVar;
            }
        }
        return cVar;
    }

    public t8.c j(Context context) {
        t8.c cVar;
        context.getClass();
        t8.c cVar2 = t8.c.f13220e;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this) {
            cVar = t8.c.f13220e;
            if (cVar == null) {
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                w4.e eVarB = com.stepos.statsrpk.h.B(applicationContext, "agent_safety_local_delete_truth_secure", "agent_safety_local_delete_truth");
                cVar = new t8.c();
                cVar.f13224a = eVarB;
                VarHandle.storeStoreFence();
                t8.c.f13220e = cVar;
            }
        }
        return cVar;
    }

    public t8.c k(Context context) {
        t8.c cVar;
        context.getClass();
        t8.c cVar2 = t8.c.f13222g;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this) {
            cVar = t8.c.f13222g;
            if (cVar == null) {
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                w4.e eVarB = com.stepos.statsrpk.h.B(applicationContext, "agent_safety_pending_undo_sync_secure", "agent_safety_pending_undo_sync");
                cVar = new t8.c();
                cVar.f13224a = eVarB;
                VarHandle.storeStoreFence();
                t8.c.f13222g = cVar;
            }
        }
        return cVar;
    }

    public t8.c l(Context context) {
        t8.c cVar;
        context.getClass();
        t8.c cVar2 = t8.c.i;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this) {
            cVar = t8.c.i;
            if (cVar == null) {
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                w4.e eVarB = com.stepos.statsrpk.h.B(applicationContext, "agent_safety_revoked_steps_secure", "agent_safety_revoked_steps");
                cVar = new t8.c();
                cVar.f13224a = eVarB;
                VarHandle.storeStoreFence();
                t8.c.i = cVar;
            }
        }
        return cVar;
    }

    public void o(int i, f7.x xVar) {
        switch (this.f10411c) {
            case 5:
                if (i != 0 && i != 1) {
                    throw new InvalidParameterException();
                }
                return;
            case 6:
            default:
                if (i != 0 && i != 1) {
                    throw new InvalidParameterException();
                }
                return;
            case 7:
                if (i != 0 && i != 1) {
                    throw new InvalidParameterException();
                }
                return;
        }
    }

    public String toString() {
        switch (this.f10411c) {
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return "CompositionErrorContext";
            default:
                return super.toString();
        }
    }

    @Override // te.u
    public void b(te.l lVar, boolean z10) {
    }

    @Override // stepos.support.v7.widget.k0
    public void onScrollChange(View view, int i, int i3, int i10, int i11) {
    }
}
