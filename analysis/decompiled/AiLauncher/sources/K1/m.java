package K1;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final x f4047a;

    /* renamed from: b, reason: collision with root package name */
    public final z f4048b;

    /* renamed from: j, reason: collision with root package name */
    public String f4056j;

    /* renamed from: k, reason: collision with root package name */
    public DateFormat f4057k;

    /* renamed from: m, reason: collision with root package name */
    public w f4059m;

    /* renamed from: n, reason: collision with root package name */
    public TimeZone f4060n;

    /* renamed from: c, reason: collision with root package name */
    public List<d> f4049c = null;

    /* renamed from: d, reason: collision with root package name */
    public List<AbstractC0903a> f4050d = null;

    /* renamed from: e, reason: collision with root package name */
    public List<u> f4051e = null;

    /* renamed from: f, reason: collision with root package name */
    public List<B> f4052f = null;

    /* renamed from: g, reason: collision with root package name */
    public List<r> f4053g = null;

    /* renamed from: h, reason: collision with root package name */
    public List<v> f4054h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f4055i = 0;

    /* renamed from: l, reason: collision with root package name */
    public IdentityHashMap<Object, w> f4058l = null;

    /* renamed from: o, reason: collision with root package name */
    public Locale f4061o = G1.a.f2773b;

    public m(z zVar, x xVar) {
        this.f4060n = G1.a.f2772a;
        this.f4048b = zVar;
        this.f4047a = xVar;
        this.f4060n = G1.a.f2772a;
    }

    public static Object o(m mVar, Object obj, Object obj2, Object obj3) {
        List<B> list = mVar.f4052f;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = G1.a.N(obj2);
            }
            Iterator<B> it = list.iterator();
            while (it.hasNext()) {
                obj3 = it.next().a(obj, (String) obj2, obj3);
            }
        }
        return obj3;
    }

    public boolean a(Object obj, Object obj2, Object obj3) {
        List<u> list = this.f4051e;
        if (list == null) {
            return true;
        }
        if (obj2 != null && !(obj2 instanceof String)) {
            obj2 = G1.a.N(obj2);
        }
        Iterator<u> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().c(obj, (String) obj2, obj3)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(Object obj, Object obj2) {
        List<v> list = this.f4054h;
        if (list == null) {
            return true;
        }
        for (v vVar : list) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = G1.a.N(obj2);
            }
            if (!vVar.b(this, obj, (String) obj2)) {
                return false;
            }
        }
        return true;
    }

    public void c(SerializerFeature serializerFeature, boolean z10) {
        this.f4048b.i(serializerFeature, z10);
    }

    public void d() {
        this.f4055i--;
    }

    public List<AbstractC0903a> e() {
        if (this.f4050d == null) {
            this.f4050d = new ArrayList();
        }
        return this.f4050d;
    }

    public List<d> f() {
        if (this.f4049c == null) {
            this.f4049c = new ArrayList();
        }
        return this.f4049c;
    }

    public DateFormat g() {
        if (this.f4057k == null && this.f4056j != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f4056j, this.f4061o);
            this.f4057k = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.f4060n);
        }
        return this.f4057k;
    }

    public List<r> h() {
        if (this.f4053g == null) {
            this.f4053g = new ArrayList();
        }
        return this.f4053g;
    }

    public List<u> i() {
        if (this.f4051e == null) {
            this.f4051e = new ArrayList();
        }
        return this.f4051e;
    }

    public List<v> j() {
        if (this.f4054h == null) {
            this.f4054h = new ArrayList();
        }
        return this.f4054h;
    }

    public List<B> k() {
        if (this.f4052f == null) {
            this.f4052f = new ArrayList();
        }
        return this.f4052f;
    }

    public void l() {
        this.f4055i++;
    }

    public void m() throws IOException {
        this.f4048b.write(10);
        for (int i10 = 0; i10 < this.f4055i; i10++) {
            this.f4048b.write(9);
        }
    }

    public Object n(Object obj, Object obj2, Object obj3) {
        List<r> list = this.f4053g;
        if (list != null) {
            if (obj2 != null && !(obj2 instanceof String)) {
                obj2 = G1.a.N(obj2);
            }
            Iterator<r> it = list.iterator();
            while (it.hasNext()) {
                obj2 = it.next().a(obj, (String) obj2, obj3);
            }
        }
        return obj2;
    }

    public void p(w wVar, Object obj, Object obj2, int i10) {
        if ((this.f4048b.f4092c & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            this.f4059m = new w(wVar, obj, obj2, i10);
            if (this.f4058l == null) {
                this.f4058l = new IdentityHashMap<>();
            }
            this.f4058l.put(obj, this.f4059m);
        }
    }

    public void q(String str) {
        this.f4056j = str;
        if (this.f4057k != null) {
            this.f4057k = null;
        }
    }

    public final void r(Object obj) {
        if (obj == null) {
            this.f4048b.Y();
            return;
        }
        try {
            this.f4047a.a(obj.getClass()).a(this, obj, null, null);
        } catch (IOException e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    public final void s(String str) throws IOException {
        if (str == null) {
            z zVar = this.f4048b;
            if ((zVar.f4092c & SerializerFeature.WriteNullStringAsEmpty.mask) != 0) {
                zVar.e0("");
                return;
            } else {
                zVar.Y();
                return;
            }
        }
        z zVar2 = this.f4048b;
        if ((zVar2.f4092c & SerializerFeature.UseSingleQuotes.mask) != 0) {
            zVar2.k0(str);
        } else {
            zVar2.g0(str, (char) 0, true);
        }
    }

    public void t(Object obj) throws IOException {
        w wVar = this.f4059m;
        if (obj == wVar.f4073b) {
            this.f4048b.write("{\"$ref\":\"@\"}");
            return;
        }
        w wVar2 = wVar.f4072a;
        if (wVar2 != null && obj == wVar2.f4073b) {
            this.f4048b.write("{\"$ref\":\"..\"}");
            return;
        }
        while (true) {
            w wVar3 = wVar.f4072a;
            if (wVar3 == null) {
                break;
            } else {
                wVar = wVar3;
            }
        }
        if (obj == wVar.f4073b) {
            this.f4048b.write("{\"$ref\":\"$\"}");
            return;
        }
        String string = this.f4058l.get(obj).toString();
        this.f4048b.write("{\"$ref\":\"");
        this.f4048b.write(string);
        this.f4048b.write("\"}");
    }

    public String toString() {
        return this.f4048b.toString();
    }

    public final void u(Object obj, Object obj2) {
        v(obj, obj2, null, 0);
    }

    public final void v(Object obj, Object obj2, Type type, int i10) {
        try {
            if (obj == null) {
                this.f4048b.Y();
            } else {
                this.f4047a.a(obj.getClass()).a(this, obj, obj2, type);
            }
        } catch (IOException e10) {
            throw new JSONException(e10.getMessage(), e10);
        }
    }

    public final void w(Object obj, String str) throws IOException {
        if (!(obj instanceof Date)) {
            r(obj);
            return;
        }
        DateFormat dateFormatG = g();
        if (dateFormatG == null) {
            dateFormatG = new SimpleDateFormat(str, this.f4061o);
            dateFormatG.setTimeZone(this.f4060n);
        }
        this.f4048b.e0(dateFormatG.format((Date) obj));
    }
}
