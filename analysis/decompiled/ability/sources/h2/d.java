package h2;

import M0.i;
import Va.l;
import Va.n;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatDelegate;
import b8.AbstractC0830C;
import b8.C0832E;
import b8.C0834G;
import b8.C0836I;
import b8.C0838K;
import b8.V;
import b8.Y;
import com.apm.insight.nativecrash.NativeImpl;
import com.stepos.taskrobot.logger.LogStrategy;
import h8.InterfaceC1529l;
import h8.InterfaceC1536s;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import k8.AbstractC1629B;
import k8.AbstractC1637f;
import k8.AbstractC1639h;
import k8.C1640i;
import k8.H;
import k8.I;
import k8.J;
import k8.Q;
import k8.u;
import k8.w;
import k8.y;
import k8.z;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qa.C1856h;
import qa.InterfaceC1854f;
import qa.v;
import stepos.support.v7.app.C1960i;
import stepos.support.v7.app.DialogInterfaceC1961j;
import stepos.support.v7.app.InterfaceC1959h;
import stepos.support.v7.app.b0;
import w0.C2085f;

/* loaded from: classes2.dex */
public class d implements InterfaceC1529l, LogStrategy, InterfaceC1854f, InterfaceC1959h, l, v.c {
    public static volatile d b;
    public static g c;

    /* renamed from: a, reason: collision with root package name */
    public Object f4555a;

    public d(Context context, int i) throws NoSuchFieldException, SecurityException {
        Printer printer;
        switch (i) {
            case 12:
                this.f4555a = context.getSharedPreferences("device_register_oaid_refine", 0);
                return;
            default:
                this.f4555a = new C1483a(context);
                if (com.apm.insight.g.f2165t) {
                    g gVar = new g();
                    gVar.f4558a = 0;
                    gVar.b = 0;
                    gVar.c = 200;
                    gVar.e = -1L;
                    gVar.f = -1L;
                    gVar.g = -1;
                    gVar.h = -1L;
                    gVar.l = false;
                    new A1.a(gVar);
                    c = gVar;
                    if (gVar.l) {
                        return;
                    }
                    int i6 = 1;
                    gVar.l = true;
                    gVar.c = 300;
                    A0.d dVar = new A0.d();
                    dVar.d = new ArrayList();
                    dVar.f70a = 100;
                    gVar.d = dVar;
                    gVar.k = new e(gVar);
                    if (!h.f4560a) {
                        h.f4560a = true;
                        h.b = new g0.d(i6);
                        if (!M.a.e) {
                            M.a.e = true;
                            D2.a aVar = new D2.a(1);
                            aVar.b = new ArrayList();
                            new ArrayList();
                            aVar.c = new ArrayList();
                            aVar.d = false;
                            M.a.d = aVar;
                            try {
                                Field declaredField = Class.forName("android.os.Looper").getDeclaredField("mLogging");
                                declaredField.setAccessible(true);
                                printer = (Printer) declaredField.get(Looper.getMainLooper());
                            } catch (Exception unused) {
                                printer = null;
                            }
                            if (printer != null) {
                                M.a.d.b.add(printer);
                            }
                            Looper.getMainLooper().setMessageLogging(M.a.d);
                        }
                        g0.d dVar2 = h.b;
                        if (dVar2 != null && !M.a.d.c.contains(dVar2)) {
                            M.a.d.c.add(dVar2);
                            M.a.d.d = true;
                        }
                    }
                    e eVar = gVar.k;
                    CopyOnWriteArrayList copyOnWriteArrayList = h.c;
                    synchronized (copyOnWriteArrayList) {
                        copyOnWriteArrayList.add(eVar);
                    }
                    i.d(i.e());
                    return;
                }
                return;
        }
    }

    public static void B() {
        if (b == null || ((C1483a) b.f4555a) == null) {
            return;
        }
        C1483a c1483a = (C1483a) b.f4555a;
        File fileK = c1483a.k();
        try {
            int iIntValue = Integer.decode(M.a.w(fileK.getAbsolutePath())).intValue();
            c1483a.y = iIntValue;
            if (iIntValue >= 2) {
                NativeImpl.f(false);
            } else {
                NativeImpl.f(true);
            }
        } catch (IOException unused) {
            NativeImpl.f(true);
        } catch (Throwable unused2) {
            M.a.u(fileK);
        }
    }

    public static void C() {
        if (b == null || ((C1483a) b.f4555a) == null) {
            return;
        }
        C1483a c1483a = (C1483a) b.f4555a;
        c1483a.getClass();
        if (NativeImpl.c) {
            try {
                M.a.t(String.valueOf(c1483a.y + 1), c1483a.k(), false);
            } catch (Throwable th) {
                int i = com.apm.insight.b.f2156a;
                i.k("NPTH_CATCH", th);
            }
        }
        c1483a.f4549v = SystemClock.uptimeMillis();
        c1483a.u = true;
    }

    public static d m(Context context) {
        if (b == null) {
            synchronized (d.class) {
                try {
                    if (b == null) {
                        b = new d(context, 0);
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static JSONObject n(long j5) {
        g gVar = c;
        if (gVar == null) {
            return null;
        }
        f fVar = new f();
        fVar.h = gVar.f4559j;
        fVar.f = j5 - gVar.f;
        int i = gVar.g;
        long jC = 0;
        if (i >= 0) {
            try {
                jC = i.c() * NativeImpl.m(i);
            } catch (Throwable unused) {
            }
        }
        fVar.g = jC - gVar.h;
        fVar.e = gVar.f4558a;
        return fVar.a();
    }

    public static JSONArray y() {
        g gVar = c;
        if (gVar == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = gVar.d.a().iterator();
            int i = 0;
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar != null) {
                    i++;
                    jSONArray.put(fVar.a().put("id", i));
                }
            }
        } catch (Throwable unused) {
        }
        return jSONArray;
    }

    @Override // h8.InterfaceC1529l
    public Object A(u uVar, Object obj) {
        return null;
    }

    @Override // v.c
    public String a() {
        return ((A8.b) this.f4555a).M0("device_id");
    }

    @Override // v.c
    public boolean b(Object obj) {
        return !TextUtils.isEmpty((String) obj);
    }

    @Override // h8.InterfaceC1529l
    public Object c(J j5, Object obj) {
        return z(j5, obj);
    }

    @Override // h8.InterfaceC1529l
    public Object d(C1640i c1640i, Object obj) {
        return z(c1640i, obj);
    }

    @Override // Va.l
    public boolean e(n nVar, MenuItem menuItem) {
        return false;
    }

    @Override // v.c
    public String f(Object obj, Object obj2, A8.b bVar) {
        String str = (String) obj;
        return bVar == null ? str : (String) bVar.E0(str, (String) obj2, new d(bVar));
    }

    @Override // h8.InterfaceC1529l
    public Object g(y yVar, Object obj) {
        return null;
    }

    @Override // qa.InterfaceC1854f
    public Type h() {
        return (Type) this.f4555a;
    }

    @Override // qa.InterfaceC1854f
    public Object i(v vVar) {
        C1856h c1856h = new C1856h(vVar);
        vVar.g(new a5.d(c1856h, 5));
        return c1856h;
    }

    @Override // h8.InterfaceC1529l
    public Object j(w wVar, Object obj) {
        return null;
    }

    @Override // Va.l
    public void k(n nVar) {
        b0 b0Var = (b0) this.f4555a;
        if (b0Var.c != null) {
            if (b0Var.f6292a.f6462a.m()) {
                b0Var.c.onPanelClosed(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, nVar);
            } else if (b0Var.c.onPreparePanel(0, null, nVar)) {
                b0Var.c.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, nVar);
            }
        }
    }

    public F1.b l() {
        String string = ((SharedPreferences) this.f4555a).getString("oaid", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            return new F1.b(jSONObject.optString("id", null), jSONObject.optString("req_id", null), jSONObject.has("is_track_limited") ? Boolean.valueOf(jSONObject.optBoolean("is_track_limited")) : null, jSONObject.has("take_ms") ? Long.valueOf(jSONObject.optLong("take_ms", -1L)) : null, jSONObject.has("time") ? Long.valueOf(jSONObject.optLong("time", -1L)) : null, jSONObject.has("query_times") ? Integer.valueOf(jSONObject.optInt("query_times", -1)) : null, jSONObject.has("hw_id_version_code") ? Long.valueOf(jSONObject.optLong("hw_id_version_code", -1L)) : null);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.stepos.taskrobot.logger.LogStrategy
    public void log(int i, String str, String str2) {
        str2.getClass();
        l6.b bVar = (l6.b) this.f4555a;
        bVar.sendMessage(bVar.obtainMessage(i, str2));
    }

    @Override // stepos.support.v7.app.InterfaceC1959h
    public DialogInterfaceC1961j newDialog(Context context, int i) {
        C1960i c1960i = (C1960i) this.f4555a;
        return new DialogInterfaceC1961j(c1960i.f6314a.f6295a, c1960i.b);
    }

    @Override // v.c
    public boolean o(Object obj, Object obj2) {
        return U7.a.m((String) obj, (String) obj2);
    }

    @Override // h8.InterfaceC1529l
    public Object p(H descriptor, Object obj) {
        AbstractC0830C abstractC0830C = (AbstractC0830C) this.f4555a;
        k.f(descriptor, "descriptor");
        int i = (descriptor.f4834t != null ? 1 : 0) + (descriptor.u != null ? 1 : 0);
        if (descriptor.f) {
            if (i == 0) {
                return new C0834G(abstractC0830C, descriptor);
            }
            if (i == 1) {
                return new C0836I(abstractC0830C, descriptor);
            }
            if (i == 2) {
                return new C0838K(abstractC0830C, descriptor);
            }
        } else {
            if (i == 0) {
                return new V(abstractC0830C, descriptor);
            }
            if (i == 1) {
                return new Y(abstractC0830C, descriptor);
            }
            if (i == 2) {
                return new b8.b0(abstractC0830C, descriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + descriptor);
    }

    @Override // v.c
    public void q(Object obj) {
        ((A8.b) this.f4555a).J0("device_id", (String) obj);
    }

    @Override // h8.InterfaceC1529l
    public Object r(I i, Object obj) {
        return z(i, obj);
    }

    @Override // h8.InterfaceC1529l
    public Object s(Q q5, Object obj) {
        return null;
    }

    public void t() {
        synchronized (this) {
            ((C2085f) this.f4555a).getClass();
        }
    }

    @Override // h8.InterfaceC1529l
    public Object u(AbstractC1629B abstractC1629B, Object obj) {
        return null;
    }

    @Override // h8.InterfaceC1529l
    public Object v(Object obj, z zVar) {
        return null;
    }

    @Override // h8.InterfaceC1529l
    public Object w(AbstractC1639h abstractC1639h, Object obj) {
        return null;
    }

    @Override // h8.InterfaceC1529l
    public Object x(AbstractC1637f abstractC1637f, Object obj) {
        return null;
    }

    @Override // h8.InterfaceC1529l
    public Object z(InterfaceC1536s interfaceC1536s, Object obj) {
        return new C0832E((AbstractC0830C) this.f4555a, interfaceC1536s);
    }

    public /* synthetic */ d(Object obj) {
        this.f4555a = obj;
    }
}
