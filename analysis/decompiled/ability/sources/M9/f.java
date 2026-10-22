package M9;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Process;
import com.apm.insight.CrashType;
import com.networknt.schema.InvalidSchemaException;
import com.networknt.schema.SpecificationVersion;
import com.networknt.schema.keyword.KeywordType;
import f1.C1431a;
import g1.AbstractC1451a;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k2.C1621a;
import l2.C1655a;
import org.json.JSONObject;
import s2.C1912a;
import u3.C2036b;
import w2.AbstractC2095a;
import w3.C2097b;

/* loaded from: classes4.dex */
public final class f implements n2.b {
    public Object c;

    /* renamed from: a, reason: collision with root package name */
    public Object f981a = "$id";
    public Object b = null;
    public Object d = new HashMap();
    public Object e = new HashMap();
    public Object f = new HashMap();

    public f(String str) {
        this.c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0074 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.d
            android.content.SharedPreferences r0 = (android.content.SharedPreferences) r0
            java.util.Map r0 = r0.getAll()
            if (r0 == 0) goto Lad
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L12:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lad
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L12
            java.lang.String r3 = ","
            java.lang.String[] r1 = r1.split(r3)     // Catch: java.lang.Throwable -> L12
            r3 = 0
            r1 = r1[r3]     // Catch: java.lang.Throwable -> L12
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r4.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch: java.lang.Throwable -> L12
            r4.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = "/stat"
            r4.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L12
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L12
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L66
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L66
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L66
            r3 = 100
            r1.<init>(r4, r3)     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Throwable -> L67
            r1.close()     // Catch: java.lang.Throwable -> L12
            goto L6e
        L66:
            r1 = 0
        L67:
            if (r1 == 0) goto L6c
            r1.close()     // Catch: java.lang.Throwable -> L12
        L6c:
            java.lang.String r3 = ""
        L6e:
            boolean r1 = r3.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r1 == 0) goto L84
            java.lang.Object r1 = r6.d     // Catch: java.lang.Throwable -> L12
            android.content.SharedPreferences r1 = (android.content.SharedPreferences) r1     // Catch: java.lang.Throwable -> L12
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> L12
            android.content.SharedPreferences$Editor r1 = r1.remove(r2)     // Catch: java.lang.Throwable -> L12
            r1.apply()     // Catch: java.lang.Throwable -> L12
            goto L12
        L84:
            java.lang.String r1 = " "
            java.lang.String[] r1 = r3.split(r1)     // Catch: java.lang.Throwable -> L12
            r3 = 1
            r1 = r1[r3]     // Catch: java.lang.Throwable -> L12
            int r4 = r1.length()     // Catch: java.lang.Throwable -> L12
            int r4 = r4 - r3
            java.lang.String r1 = r1.substring(r3, r4)     // Catch: java.lang.Throwable -> L12
            boolean r1 = r2.endsWith(r1)     // Catch: java.lang.Throwable -> L12
            if (r1 != 0) goto L12
            java.lang.Object r1 = r6.d     // Catch: java.lang.Throwable -> L12
            android.content.SharedPreferences r1 = (android.content.SharedPreferences) r1     // Catch: java.lang.Throwable -> L12
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch: java.lang.Throwable -> L12
            android.content.SharedPreferences$Editor r1 = r1.remove(r2)     // Catch: java.lang.Throwable -> L12
            r1.apply()     // Catch: java.lang.Throwable -> L12
            goto L12
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: M9.f.a():void");
    }

    public boolean b() {
        if (!((C1431a) this.e).e) {
            Map<String, ?> all = ((SharedPreferences) this.d).getAll();
            if (all != null) {
                Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    if (((String) it.next().getValue()).split(",")[1].equals("true")) {
                        return true;
                    }
                }
            }
            return ((C1431a) this.e).e;
        }
        ((SharedPreferences) this.d).edit().putString(AbstractC1451a.A(), Process.myPid() + "," + ((C1431a) this.e).e).apply();
        return true;
    }

    @Override // n2.b
    public void c(JSONObject jSONObject) {
        String str = (String) ((F1.b) this.f981a).h;
        String string = jSONObject.toString();
        File file = (File) this.b;
        File file2 = new File(file, "logZip");
        Context context = ((w2.f) this.f).f6835a;
        w2.e eVar = (w2.e) this.c;
        if (AbstractC2095a.a(str, string, file2, N9.j.g(context, eVar.f6834a)).a()) {
            if (!M.a.u(file)) {
                C1621a c1621aA = C1621a.a();
                String absolutePath = file.getAbsolutePath();
                C1655a c1655a = new C1655a();
                c1655a.f5272a = absolutePath;
                c1655a.b = System.currentTimeMillis();
                synchronized (c1621aA) {
                    if (((C1912a) c1621aA.f4793a) == null) {
                        c1621aA.b(com.apm.insight.g.f2160a);
                    }
                    C1912a c1912a = (C1912a) c1621aA.f4793a;
                    if (c1912a != null) {
                        c1912a.d((SQLiteDatabase) c1621aA.b, c1655a);
                    }
                }
            }
            H4.o.e(N9.j.k(com.apm.insight.g.f2160a, eVar.f6834a), file.getName());
            w2.h.a((CrashType) this.d, (JSONObject) this.e);
            eVar.h = true;
        }
    }

    public C2097b d() {
        HashMap map = (HashMap) this.f;
        HashMap map2 = (HashMap) this.d;
        SpecificationVersion specificationVersion = (SpecificationVersion) this.b;
        if (specificationVersion != null && specificationVersion.f3013a >= 8) {
            HashMap map3 = new HashMap(map2);
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                F3.b bVar = (F3.b) F3.a.f536a.get(str);
                if (bVar != null) {
                    for (z3.t tVar : bVar.b) {
                        map3.putIfAbsent(tVar.getValue(), tVar);
                    }
                } else if (Boolean.TRUE.equals(entry.getValue())) {
                    C2036b c2036b = new C2036b();
                    c2036b.g = "Meta-schema ''{0}'' has unknown required vocabulary ''{1}''";
                    c2036b.e = new Object[]{(String) this.c, str};
                    throw new InvalidSchemaException(c2036b.a());
                }
            }
            map2 = map3;
        }
        HashMap map4 = (HashMap) this.e;
        HashMap map5 = new HashMap();
        boolean z10 = false;
        for (Map.Entry entry2 : map2.entrySet()) {
            String str2 = (String) entry2.getKey();
            z3.t tVar2 = (z3.t) entry2.getValue();
            KeywordType keywordType = KeywordType.f3049t;
            if (!keywordType.f3054a.equals(str2)) {
                map5.put(tVar2.getValue(), tVar2);
            } else {
                if (!(tVar2 instanceof z3.o) && !keywordType.equals(tVar2)) {
                    throw new IllegalArgumentException("Overriding the keyword 'format' is not supported. Use the formatKeywordFactory and extend the FormatKeyword.");
                }
                z10 = true;
            }
        }
        if (z10) {
            z3.o oVar = new z3.o(map4);
            map5.put(oVar.f6950a, oVar);
        }
        return new C2097b((String) this.c, (String) this.f981a, map5, map, (SpecificationVersion) this.b, this);
    }

    public void e(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            x3.d dVar = (x3.d) it.next();
            ((HashMap) this.e).put(dVar.getName(), dVar);
        }
    }

    public void f(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            z3.t tVar = (z3.t) it.next();
            ((HashMap) this.d).put(tVar.getValue(), tVar);
        }
    }
}
