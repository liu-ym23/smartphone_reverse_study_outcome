package l1;

import B0.m;
import G1.p;
import X.r;
import Z2.I;
import android.text.TextUtils;
import androidx.appcompat.widget.RunnableC0209k;
import androidx.room.AbstractC0351g;
import com.google.android.gms.common.api.internal.s;
import com.google.gson.reflect.TypeToken;
import com.stepos.activeview.utils.Constants;
import f1.AbstractC0557a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class g implements t3.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13459a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13460b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13461c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13462d;

    public g() {
        this.f13459a = 0;
        this.f13461c = new Object();
    }

    public static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ".concat(cls.getName());
        }
        return null;
    }

    public static void e(String str) throws JSONException {
        com.stepos.statsapp.v3.lib.plugin.emitter.remote.e eVar;
        try {
            T2.d.a("ConfigController", "parseConfigJson 1");
            JSONObject jSONObject = new JSONObject(str);
            T2.d.a("ConfigController", "parseConfigJson 2, config json:" + jSONObject);
            T2.d.a("ConfigController", "parseAndApply, version: " + jSONObject.getInt(Constants.JSON_KEY_VERSION));
            boolean z4 = jSONObject.getBoolean("active");
            JSONObject jSONObject2 = jSONObject.getJSONObject("uploadPolicy");
            boolean z5 = jSONObject2.getBoolean("onStart");
            boolean z6 = jSONObject2.getBoolean("onCharge");
            boolean z7 = jSONObject2.getBoolean("onReconnect");
            long j4 = jSONObject2.getLong("interval") * 60000;
            int i4 = jSONObject2.getInt("cacheCapacity");
            long j5 = jSONObject2.getLong("mobileQuota");
            int i5 = jSONObject2.getInt("neartimeInterval");
            s sVar = L2.b.f1231a.f1236e;
            if (sVar == null) {
                T2.d.b("SDKInstanceImpl", "getEmitter fail, tracker is null");
                eVar = null;
            } else {
                eVar = (com.stepos.statsapp.v3.lib.plugin.emitter.remote.e) sVar.f9680b;
            }
            eVar.d(z4, z5, z6, z7, j4, i4, j5, i5);
            HashMap map = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("events");
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i6);
                String string = jSONObject3.getString("name");
                map.put(string, new O2.a(string, jSONObject3.getBoolean("active"), jSONObject3.getBoolean("realtime"), jSONObject3.getBoolean("neartime")));
            }
            s sVar2 = L2.b.f1231a.f1236e;
            if (sVar2 != null) {
                sVar2.b(map);
            }
        } catch (Exception e4) {
            T2.d.b("ConfigController", "parseAndApply error, " + e4.getMessage());
        }
    }

    public final p b(TypeToken typeToken) throws NoSuchMethodException, SecurityException {
        String str;
        p rVar;
        Type type = typeToken.getType();
        Class rawType = typeToken.getRawType();
        Map map = (Map) this.f13461c;
        B0.g.y(map.get(type));
        B0.g.y(map.get(rawType));
        y0.e eVar = null;
        G1.e eVar2 = EnumSet.class.isAssignableFrom(rawType) ? new G1.e(0, type) : rawType == EnumMap.class ? new G1.e(1, type) : null;
        if (eVar2 != null) {
            return eVar2;
        }
        B0.f.E((List) this.f13462d);
        int i4 = 12;
        if (Modifier.isAbstract(rawType.getModifiers())) {
            rVar = null;
        } else {
            try {
                Constructor declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
                AbstractC0557a abstractC0557a = J1.c.f880a;
                try {
                    declaredConstructor.setAccessible(true);
                    str = null;
                } catch (Exception e4) {
                    str = "Failed making constructor '" + J1.c.b(declaredConstructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e4.getMessage();
                }
                rVar = str != null ? new r(str, 2) : new com.google.android.gms.common.api.internal.p(i4, declaredConstructor);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (rVar != null) {
            return rVar;
        }
        int i5 = 8;
        if (Collection.class.isAssignableFrom(rawType)) {
            eVar = SortedSet.class.isAssignableFrom(rawType) ? new y0.e(6) : Set.class.isAssignableFrom(rawType) ? new y0.e(7) : Queue.class.isAssignableFrom(rawType) ? new y0.e(i5) : new y0.e(9);
        } else if (Map.class.isAssignableFrom(rawType)) {
            eVar = ConcurrentNavigableMap.class.isAssignableFrom(rawType) ? new y0.e(10) : ConcurrentMap.class.isAssignableFrom(rawType) ? new y0.e(11) : SortedMap.class.isAssignableFrom(rawType) ? new y0.e(i4) : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new y0.e(14) : new y0.e(13);
        }
        if (eVar != null) {
            return eVar;
        }
        String strA = a(rawType);
        if (strA != null) {
            return new m(i5, this, strA);
        }
        if (this.f13460b) {
            B0.c cVar = new B0.c();
            cVar.f137b = this;
            cVar.f136a = rawType;
            return cVar;
        }
        return new B0.e(this, "Unable to create instance of " + rawType + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.", i5);
    }

    @Override // t3.d
    public final void c(long j4) {
        if (this.f13460b) {
            return;
        }
        if (j4 < 0) {
            throw new IllegalStateException(AbstractC0351g.n("n >= required but it was ", j4));
        }
        if (j4 == 0) {
            return;
        }
        this.f13460b = true;
        t3.g gVar = (t3.g) this.f13462d;
        if (gVar.f15444a.a()) {
            return;
        }
        Object obj = this.f13461c;
        try {
            gVar.g(obj);
            if (gVar.f15444a.a()) {
                return;
            }
            gVar.e();
        } catch (Throwable th) {
            I.E(th, gVar, obj);
        }
    }

    public final boolean d() {
        S2.a aVar = (S2.a) this.f13462d;
        if (aVar == null) {
            return false;
        }
        return System.currentTimeMillis() - aVar.f1791a.getLong("key_config_last_time", 0L) <= 21600000;
    }

    public final void f(C0760e c0760e) {
        synchronized (this.f13461c) {
            try {
                if (((Queue) this.f13462d) == null) {
                    this.f13462d = new ArrayDeque();
                }
                ((Queue) this.f13462d).add(c0760e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g(h hVar) {
        InterfaceC0761f interfaceC0761f;
        synchronized (this.f13461c) {
            if (((Queue) this.f13462d) != null && !this.f13460b) {
                this.f13460b = true;
                while (true) {
                    synchronized (this.f13461c) {
                        try {
                            interfaceC0761f = (InterfaceC0761f) ((Queue) this.f13462d).poll();
                            if (interfaceC0761f == null) {
                                this.f13460b = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    C0760e c0760e = (C0760e) interfaceC0761f;
                    synchronized (c0760e.f13457b) {
                        try {
                            if (c0760e.f13458c != null) {
                                c0760e.f13456a.execute(new RunnableC0209k(15, c0760e, hVar));
                            }
                        } finally {
                        }
                    }
                }
            }
        }
    }

    public final String toString() {
        switch (this.f13459a) {
            case 1:
                return ((Map) this.f13461c).toString();
            default:
                return super.toString();
        }
    }

    public g(String str) {
        this.f13459a = 3;
        this.f13460b = false;
        this.f13461c = str;
    }

    public g(String str, boolean z4) {
        this.f13459a = 2;
        boolean zIsEmpty = TextUtils.isEmpty(str);
        this.f13460b = !zIsEmpty;
        if (zIsEmpty) {
            return;
        }
        if (z4) {
            this.f13461c = "com.stepos.openid.permission.SECURESERVICE_OPEN_ID_CHANGE";
            this.f13462d = "content://com.stepos.secureservice.openidsdk/";
        } else {
            this.f13461c = "com.stepos.openid.permission.OPEN_ID_CHANGE";
            this.f13462d = "content://com.stepos.openidsdk/";
        }
    }

    public g(Map map, List list) {
        this.f13459a = 1;
        this.f13461c = map;
        this.f13460b = true;
        this.f13462d = list;
    }

    public g(t3.g gVar, Object obj) {
        this.f13459a = 4;
        this.f13462d = gVar;
        this.f13461c = obj;
    }
}
