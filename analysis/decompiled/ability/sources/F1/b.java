package F1;

import G8.f;
import H.h;
import L8.q;
import L8.s;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.google.protobuf.GeneratedMessageV3;
import d8.AbstractC1379a;
import h8.InterfaceC1503K;
import h8.InterfaceC1522e;
import i8.C1557c;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.k;
import org.json.JSONObject;
import u1.d;
import x.i;
import z8.C2193e;
import z8.n;
import z8.o;

/* loaded from: classes2.dex */
public final class b implements n {
    public static volatile b i;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f534a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;

    public /* synthetic */ b() {
        this.f534a = 2;
    }

    public static b b() {
        if (i == null) {
            synchronized (b.class) {
                try {
                    if (i == null) {
                        D1.a aVarB = D1.a.b();
                        S0.b.L(aVarB.f371a, "You must call init() first before using !!!");
                        i = new b(aVarB.f371a);
                    }
                } finally {
                }
            }
        }
        return i;
    }

    public HashMap a() {
        HashMap map = new HashMap();
        String str = (String) this.h;
        String str2 = i.i;
        if (str != null) {
            map.put("id", str);
        }
        String str3 = (String) this.b;
        if (str3 != null) {
            map.put("req_id", str3);
        }
        map.put("is_track_limited", String.valueOf((Boolean) this.c));
        map.put("take_ms", String.valueOf((Long) this.d));
        map.put("time", String.valueOf((Long) this.e));
        map.put("query_times", String.valueOf((Integer) this.f));
        map.put("hw_id_version_code", String.valueOf((Long) this.g));
        return map;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        i.b(jSONObject, "id", (String) this.h);
        i.b(jSONObject, "req_id", (String) this.b);
        i.b(jSONObject, "is_track_limited", (Boolean) this.c);
        i.b(jSONObject, "take_ms", (Long) this.d);
        i.b(jSONObject, "time", (Long) this.e);
        i.b(jSONObject, "query_times", (Integer) this.f);
        i.b(jSONObject, "hw_id_version_code", (Long) this.g);
        return jSONObject;
    }

    public boolean d() {
        return new File((File) this.f, "festival.jpg.heap").exists();
    }

    @Override // z8.n
    public void k() {
        C2193e c2193e = (C2193e) this.d;
        G8.b bVar = (G8.b) this.f;
        HashMap arguments = (HashMap) this.c;
        k.f(arguments, "arguments");
        boolean zD = false;
        if (bVar.equals(AbstractC1379a.b)) {
            Object obj = arguments.get(f.e("value"));
            s sVar = obj instanceof s ? (s) obj : null;
            if (sVar != null) {
                Object obj2 = sVar.f939a;
                q qVar = obj2 instanceof q ? (q) obj2 : null;
                if (qVar != null) {
                    zD = c2193e.d(qVar.f943a.f938a);
                }
            }
        }
        if (zD || c2193e.d(bVar)) {
            return;
        }
        ((List) this.g).add(new C1557c(((InterfaceC1522e) this.e).g(), arguments, (InterfaceC1503K) this.h));
    }

    @Override // z8.n
    public n l(G8.b bVar, f fVar) {
        ArrayList arrayList = new ArrayList();
        b bVarE = ((C2193e) this.b).e(bVar, InterfaceC1503K.f4577I, arrayList);
        K1.a aVar = new K1.a();
        aVar.b = bVarE;
        aVar.c = this;
        aVar.d = fVar;
        aVar.e = arrayList;
        aVar.f903a = bVarE;
        return aVar;
    }

    @Override // z8.n
    public void m(f fVar, L8.f fVar2) {
        ((HashMap) this.c).put(fVar, new s(new q(fVar2)));
    }

    @Override // z8.n
    public o n(f fVar) {
        return new d((C2193e) this.b, fVar, this);
    }

    @Override // z8.n
    public void t(f fVar, Object obj) {
        ((HashMap) this.c).put(fVar, C2193e.h((C2193e) this.b, fVar, obj));
    }

    public String toString() {
        switch (this.f534a) {
            case 3:
                return c().toString();
            default:
                return super.toString();
        }
    }

    @Override // z8.n
    public void y(f fVar, G8.b bVar, f fVar2) {
        ((HashMap) this.c).put(fVar, new L8.i(bVar, fVar2));
    }

    public b(Context context) {
        this.f534a = 0;
        String str = D1.a.b().f;
        if (TextUtils.isEmpty(str)) {
            this.h = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName();
        } else {
            this.h = new File(str).getAbsolutePath();
        }
        String strC = h.c();
        if (strC != null) {
            this.f = new File(B7.a.q(new StringBuilder(), (String) this.h, "/memorywidgets"), strC);
            this.g = new File(B7.a.q(new StringBuilder(), (String) this.h, "/memory"), strC);
        } else {
            this.f = new File(B7.a.q(new StringBuilder(), (String) this.h, "/memorywidgets"), context.getPackageName());
            this.g = new File(B7.a.q(new StringBuilder(), (String) this.h, "/memory"), context.getPackageName());
        }
        if (!((File) this.f).exists()) {
            ((File) this.f).mkdirs();
        }
        if (!((File) this.g).exists()) {
            ((File) this.g).mkdirs();
        }
        File file = new File((File) this.f, "cache");
        this.d = file;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.b = new File((File) this.f, "festival.jpg");
        this.c = new File((File) this.f, "festival.jpg.heap");
        File file2 = new File((File) this.f, "shrink");
        this.e = file2;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            Z6.k.f(new File((String) this.h, "memorywidget"));
        } catch (Exception unused) {
        }
    }

    public b(String str, String str2, Boolean bool, Long l, Long l5, Integer num, Long l9) {
        this.f534a = 3;
        this.h = str;
        this.b = str2;
        this.c = bool;
        this.d = l;
        this.e = l5;
        this.f = num;
        this.g = l9;
    }

    public b(C2193e c2193e, InterfaceC1522e interfaceC1522e, G8.b bVar, List list, InterfaceC1503K interfaceC1503K) {
        this.f534a = 4;
        this.d = c2193e;
        this.e = interfaceC1522e;
        this.f = bVar;
        this.g = list;
        this.h = interfaceC1503K;
        this.b = c2193e;
        this.c = new HashMap();
    }

    public b(String str, Class cls, Class cls2, String str2, boolean z10, boolean z11) {
        this.f534a = 1;
        Method methodT = GeneratedMessageV3.t(cls, B7.a.k("get", str), new Class[0]);
        this.b = methodT;
        this.c = GeneratedMessageV3.t(cls2, B7.a.k("get", str), new Class[0]);
        this.d = GeneratedMessageV3.t(cls2, B7.a.k("set", str), new Class[]{methodT.getReturnType()});
        this.e = z11 ? GeneratedMessageV3.t(cls, B7.a.k("has", str), new Class[0]) : null;
        this.f = z11 ? GeneratedMessageV3.t(cls2, B7.a.k("has", str), new Class[0]) : null;
        GeneratedMessageV3.t(cls2, B7.a.k("clear", str), new Class[0]);
        this.g = z10 ? GeneratedMessageV3.t(cls, B7.a.m("get", str2, "Case"), new Class[0]) : null;
        this.h = z10 ? GeneratedMessageV3.t(cls2, B7.a.m("get", str2, "Case"), new Class[0]) : null;
    }
}
