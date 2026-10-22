package s7;

import a4.u;
import a6.b0;
import a6.c0;
import a6.i;
import a6.l;
import a6.y;
import android.content.Context;
import android.os.Bundle;
import bb.b;
import c7.f;
import c7.h;
import c7.o;
import c7.q;
import c7.s;
import c8.m;
import d7.a0;
import d7.d0;
import d7.e0;
import d7.p;
import d7.t;
import d7.z;
import d8.e;
import f8.g;
import f8.n0;
import f8.q0;
import ga.r;
import i1.d1;
import i8.r0;
import ib.c;
import j9.w;
import java.io.DataInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import l4.j;
import m.x;
import o4.j0;
import o4.l0;
import org.json.JSONException;
import org.json.JSONObject;
import p7.n;
import q7.k;
import v7.d;
import v9.f0;
import v9.p0;
import v9.v;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static l8.a f9510a;

    public static final List A(v vVar) {
        k.e(vVar, "<this>");
        B(vVar);
        List listC0 = vVar.C0();
        return listC0.subList(((!B(vVar) || vVar.getAnnotations().b(m.f2045p) == null) ? 0 : 1) + k(vVar), listC0.size() - 1);
    }

    public static final boolean B(v vVar) {
        k.e(vVar, "<this>");
        g gVarC = vVar.E0().c();
        if (gVarC == null) {
            return false;
        }
        e eVarU = u(gVarC);
        return eVarU == e.f2994i || eVarU == e.f2995j;
    }

    public static boolean C(byte b10) {
        return b10 > -65;
    }

    public static boolean D(byte b10) {
        return b10 > -65;
    }

    public static final boolean E(v vVar) {
        k.e(vVar, "<this>");
        g gVarC = vVar.E0().c();
        return (gVarC != null ? u(gVarC) : null) == e.f2995j;
    }

    public static fa.k F(n nVar) {
        fa.k kVar = new fa.k();
        kVar.f3638h = ib.k.r(kVar, kVar, nVar);
        return kVar;
    }

    public static f G(h hVar, p7.a aVar) {
        q qVar = q.f1985a;
        int i2 = c7.g.$EnumSwitchMapping$0[hVar.ordinal()];
        if (i2 == 1) {
            return new o(aVar);
        }
        if (i2 == 2) {
            c7.n nVar = new c7.n();
            nVar.f1977f = aVar;
            nVar.f1978g = qVar;
            return nVar;
        }
        if (i2 != 3) {
            throw new u();
        }
        s sVar = new s();
        sVar.f1987f = aVar;
        sVar.f1988g = qVar;
        return sVar;
    }

    public static o H(p7.a aVar) {
        k.e(aVar, "initializer");
        return new o(aVar);
    }

    public static final long I(float f10, long j2) {
        return (Float.isNaN(f10) || f10 >= 1.0f) ? j2 : u0.m.b(u0.m.d(j2) * f10, j2);
    }

    public static ab.n J(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        int length = strArr2.length;
        int i2 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr2[i10];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i10] = ga.k.N0(str).toString();
        }
        int iB = c.B(0, strArr2.length - 1, 2);
        if (iB >= 0) {
            while (true) {
                String str2 = strArr2[i2];
                String str3 = strArr2[i2 + 1];
                g(str2);
                i(str3, str2);
                if (i2 == iB) {
                    break;
                }
                i2 += 2;
            }
        }
        return new ab.n(strArr2);
    }

    public static final long Q(float f10, long j2) {
        long jFloatToRawIntBits = j2 | (Float.floatToRawIntBits(f10) & 4294967295L);
        d2.o[] oVarArr = d2.n.f2797b;
        return jFloatToRawIntBits;
    }

    public static List R(Object obj) {
        String string;
        if (!(obj instanceof List)) {
            return z.f2978f;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            String str = null;
            if (obj2 instanceof String) {
                if (((String) obj2).length() <= 0) {
                    obj2 = null;
                }
                str = obj2;
            } else if (obj2 != null && (string = obj2.toString()) != null && string.length() > 0) {
                str = string;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static a9.a S(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        d dVar = new d(1, dataInputStream.readInt(), 1);
        ArrayList arrayList = new ArrayList(t.A0(dVar, 10));
        Iterator it = dVar.iterator();
        while (true) {
            v7.c cVar = (v7.c) it;
            if (!cVar.f10528h) {
                break;
            }
            cVar.nextInt();
            arrayList.add(Integer.valueOf(dataInputStream.readInt()));
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it2 = arrayList.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            iArr[i2] = ((Number) it2.next()).intValue();
            i2++;
        }
        return new a9.a(Arrays.copyOf(iArr, iArr.length));
    }

    public static final boolean T(v vVar) {
        g gVarC = vVar.E0().c();
        if (gVarC != null && h9.h.b(gVarC) && !l9.d.g((f8.e) gVarC).equals(c8.n.f2062g)) {
            return true;
        }
        g gVarC2 = vVar.E0().c();
        q0 q0Var = gVarC2 instanceof q0 ? (q0) gVarC2 : null;
        return q0Var == null ? false : T(n7.m.x(q0Var));
    }

    public static int U(float f10) {
        if (Float.isNaN(f10)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f10);
    }

    public static long V(double d6) {
        if (Double.isNaN(d6)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(d6);
    }

    public static byte[] W(String str, com.google.protobuf.k kVar) {
        String string = UUID.randomUUID().toString();
        k.d(string, "toString(...)");
        l4.e eVarV = l4.g.v();
        eVarV.d();
        l4.g.q((l4.g) eVarV.f2351g);
        eVarV.d();
        l4.g.t((l4.g) eVarV.f2351g);
        eVarV.d();
        l4.g.s((l4.g) eVarV.f2351g, string);
        eVarV.d();
        l4.g.r((l4.g) eVarV.f2351g);
        eVarV.d();
        l4.g.p((l4.g) eVarV.f2351g, str);
        l4.g gVar = (l4.g) eVarV.build();
        j jVarR = l4.k.r();
        jVarR.d();
        l4.k.q((l4.k) jVarR.f2351g, gVar);
        jVarR.d();
        l4.k.p((l4.k) jVarR.f2351g, kVar);
        return ((l4.k) jVarR.build()).toByteArray();
    }

    public static final String X(String str) {
        k.e(str, "<this>");
        int i2 = 0;
        int i10 = -1;
        if (!ga.k.k0(str, ":", false)) {
            try {
                String ascii = IDN.toASCII(str);
                k.d(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                k.d(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                k.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i11 = 0; i11 < length; i11++) {
                    char cCharAt = lowerCase.charAt(i11);
                    if (k.f(cCharAt, 31) <= 0 || k.f(cCharAt, 127) >= 0 || ga.k.q0(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressO = (r.g0(str, "[", false) && r.Z(str, "]", false)) ? o(str, 1, str.length() - 1) : o(str, 0, str.length());
        if (inetAddressO == null) {
            return null;
        }
        byte[] address = inetAddressO.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressO.getHostAddress();
            }
            throw new AssertionError(a1.a.e('\'', "Invalid IPv6 address: '", str));
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < address.length) {
            int i14 = i12;
            while (i14 < 16 && address[i14] == 0 && address[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i10 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        ob.h hVar = new ob.h();
        while (i2 < address.length) {
            if (i2 == i10) {
                hVar.Q(58);
                i2 += i13;
                if (i2 == 16) {
                    hVar.Q(58);
                }
            } else {
                if (i2 > 0) {
                    hVar.Q(58);
                }
                byte b10 = address[i2];
                byte[] bArr = b.f1659a;
                hVar.R(((b10 & 255) << 8) | (address[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return hVar.z();
    }

    public static final a6.d Y(Map map) {
        Object obj = map.get("jobId");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            throw new IllegalArgumentException("cronjob: missing jobId");
        }
        Object obj2 = map.get("name");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null) {
            throw new IllegalArgumentException("cronjob: missing name");
        }
        Object obj3 = map.get("schedule");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        if (str3 == null) {
            throw new IllegalArgumentException("cronjob: missing schedule");
        }
        Object obj4 = map.get("actionTarget");
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        if (str4 == null) {
            throw new IllegalArgumentException("cronjob: missing actionTarget");
        }
        Object obj5 = map.get("isEnabled");
        Boolean bool = obj5 instanceof Boolean ? (Boolean) obj5 : null;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
        Object obj6 = map.get("deleteAfterRun");
        Boolean bool2 = obj6 instanceof Boolean ? (Boolean) obj6 : null;
        boolean zBooleanValue2 = bool2 != null ? bool2.booleanValue() : false;
        Object obj7 = map.get("nextRunAtMs");
        Number number = obj7 instanceof Number ? (Number) obj7 : null;
        Long lValueOf = number != null ? Long.valueOf(number.longValue()) : null;
        Object obj8 = map.get("payloadText");
        return new a6.d(str, str2, str3, str4, zBooleanValue, zBooleanValue2, lValueOf, obj8 instanceof String ? (String) obj8 : null);
    }

    public static final c5.b Z(a6.m mVar, String str) {
        k.e(mVar, "<this>");
        Map map = mVar.f350e;
        k.e(str, "id");
        if (mVar.f346a) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str2 = mVar.f347b;
            if (str2 != null) {
                linkedHashMap.put("id", str2);
            }
            if (!map.isEmpty()) {
                linkedHashMap.putAll(map);
            }
            return new c5.b("res", e0.U(new c7.j("type", "res"), new c7.j("id", str), new c7.j("ok", Boolean.TRUE), new c7.j("payload", linkedHashMap)));
        }
        String str3 = mVar.f348c;
        if (str3 == null) {
            str3 = "STEPCLAW_TRANSPORT_ERROR";
        }
        String str4 = str3;
        String str5 = mVar.f349d;
        if (str5 == null) {
            str5 = "operation failed";
        }
        String str6 = str5;
        if (map.isEmpty()) {
            map = null;
        }
        return s9.d.n(str, str4, str6, false, null, map, 24);
    }

    public static final d2.e a(Context context) {
        float f10 = context.getResources().getConfiguration().fontScale;
        float f11 = context.getResources().getDisplayMetrics().density;
        e2.a aVarA = e2.b.a(f10);
        if (aVarA == null) {
            aVarA = new d2.m(f10);
        }
        return new d2.e(f11, f10, aVarA);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a6.h a0(java.util.Map r10) {
        /*
            java.lang.String r0 = "id"
            java.lang.Object r0 = r10.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            r2 = 0
            if (r1 == 0) goto Lf
            java.lang.String r0 = (java.lang.String) r0
            r4 = r0
            goto L10
        Lf:
            r4 = r2
        L10:
            if (r4 == 0) goto L9e
            java.lang.String r0 = "version"
            java.lang.Object r0 = r10.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L20
            java.lang.String r0 = (java.lang.String) r0
            r5 = r0
            goto L21
        L20:
            r5 = r2
        L21:
            if (r5 == 0) goto L96
            java.lang.String r0 = "blobRef"
            java.lang.Object r0 = r10.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L31
            java.lang.String r0 = (java.lang.String) r0
            r6 = r0
            goto L32
        L31:
            r6 = r2
        L32:
            if (r6 == 0) goto L8e
            java.lang.String r0 = "source"
            java.lang.Object r0 = r10.get(r0)
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L41
            java.lang.String r0 = (java.lang.String) r0
            goto L42
        L41:
            r0 = r2
        L42:
            if (r0 == 0) goto L64
            java.util.Locale r1 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L54
            java.lang.String r0 = r0.toUpperCase(r1)     // Catch: java.lang.Throwable -> L54
            java.lang.String r1 = "toUpperCase(...)"
            q7.k.d(r0, r1)     // Catch: java.lang.Throwable -> L54
            a6.i r0 = a6.i.valueOf(r0)     // Catch: java.lang.Throwable -> L54
            goto L59
        L54:
            r0 = move-exception
            c7.l r0 = w7.e0.n(r0)
        L59:
            boolean r1 = r0 instanceof c7.l
            if (r1 == 0) goto L5e
            r0 = r2
        L5e:
            a6.i r0 = (a6.i) r0
            if (r0 == 0) goto L64
        L62:
            r7 = r0
            goto L67
        L64:
            a6.i r0 = a6.i.LOCAL
            goto L62
        L67:
            java.lang.String r0 = "extras"
            java.lang.Object r0 = r10.get(r0)
            boolean r1 = r0 instanceof java.util.Map
            if (r1 == 0) goto L74
            java.util.Map r0 = (java.util.Map) r0
            goto L75
        L74:
            r0 = r2
        L75:
            if (r0 != 0) goto L79
            d7.a0 r0 = d7.a0.f2944f
        L79:
            r8 = r0
            java.lang.String r0 = "catalogDescription"
            java.lang.Object r10 = r10.get(r0)
            boolean r0 = r10 instanceof java.lang.String
            if (r0 == 0) goto L87
            r2 = r10
            java.lang.String r2 = (java.lang.String) r2
        L87:
            r9 = r2
            a6.h r3 = new a6.h
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r3
        L8e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "install: missing blobRef"
            r10.<init>(r0)
            throw r10
        L96:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "install: missing version"
            r10.<init>(r0)
            throw r10
        L9e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "install: missing id"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.a.a0(java.util.Map):a6.h");
    }

    public static final a6.c b(String str) {
        Object objN;
        try {
            String upperCase = str.toUpperCase(Locale.ROOT);
            k.d(upperCase, "toUpperCase(...)");
            objN = a6.c.valueOf(upperCase);
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (c7.m.a(objN) == null) {
            return (a6.c) objN;
        }
        throw new IllegalArgumentException("unknown coreFileType: ".concat(str));
    }

    public static final Map b0(a6.b bVar) {
        k.e(bVar, "<this>");
        return e0.U(new c7.j("id", bVar.f275a), new c7.j("channelId", bVar.f276b), new c7.j("name", bVar.f277c), new c7.j("status", bVar.f278d), new c7.j("version", bVar.f279e), new c7.j("tags", bVar.f280f), new c7.j("isEnabled", Boolean.valueOf(bVar.f281g)), new c7.j("description", bVar.f282h), new c7.j("metadata", bVar.f283i));
    }

    public static final boolean c(String str, Map map) {
        Object obj = map.get("enabled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalArgumentException("missing enabled (bool) in frame ".concat(str));
    }

    public static final Map c0(a6.d dVar) {
        k.e(dVar, "<this>");
        return e0.U(new c7.j("jobId", dVar.f295a), new c7.j("name", dVar.f296b), new c7.j("schedule", dVar.f297c), new c7.j("actionTarget", dVar.f298d), new c7.j("isEnabled", Boolean.valueOf(dVar.f299e)), new c7.j("deleteAfterRun", Boolean.valueOf(dVar.f300f)), new c7.j("nextRunAtMs", dVar.f301g), new c7.j("payloadText", dVar.f302h));
    }

    public static final String d(String str, Map map) {
        Object obj = map.get("jobId");
        String str2 = obj instanceof String ? (String) obj : null;
        if (str2 != null) {
            return str2;
        }
        Object obj2 = map.get("id");
        String str3 = obj2 instanceof String ? (String) obj2 : null;
        if (str3 != null) {
            return str3;
        }
        throw new IllegalArgumentException("missing jobId in frame ".concat(str));
    }

    public static final Map d0(a6.e eVar) {
        k.e(eVar, "<this>");
        c7.j jVar = new c7.j("tsMs", Long.valueOf(eVar.f305a));
        c7.j jVar2 = new c7.j("jobId", eVar.f306b);
        a6.f fVar = eVar.f307c;
        return e0.U(jVar, jVar2, new c7.j("status", fVar != null ? fVar.name() : null), new c7.j("summary", eVar.f308d), new c7.j("error", eVar.f309e), new c7.j("nextRunAtMs", eVar.f310f), new c7.j("durationMs", eVar.f311g), new c7.j("runAtMs", eVar.f312h), new c7.j("sessionKey", eVar.f313i));
    }

    public static final String e(String str, String str2, Map map) {
        Object obj = map.get(str);
        String str3 = obj instanceof String ? (String) obj : null;
        if (str3 != null) {
            return str3;
        }
        throw new IllegalArgumentException(a1.a.k("missing ", str, " in frame ", str2));
    }

    public static final Map e0(a6.k kVar) {
        k.e(kVar, "<this>");
        return e0.U(new c7.j("provider", kVar.f336a), new c7.j("model", kVar.f337b), new c7.j("baseUrl", kVar.f338c), new c7.j("api", kVar.f339d), new c7.j("apiKey", null));
    }

    public static final Map f(Map map) {
        Object obj = map.get("credentials");
        Map map2 = obj instanceof Map ? (Map) obj : null;
        if (map2 == null) {
            return a0.f2944f;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2.size());
        for (Map.Entry entry : map2.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && value != null) {
                linkedHashMap.put(key, value.toString());
            }
        }
        return linkedHashMap;
    }

    public static final Map f0(a6.z zVar) {
        k.e(zVar, "<this>");
        return e0.U(new c7.j("id", zVar.f389a), new c7.j("name", zVar.f390b), new c7.j("description", zVar.f391c), new c7.j("version", zVar.f392d), new c7.j("tags", zVar.f393e), new c7.j("isEnabled", Boolean.valueOf(zVar.f394f)), new c7.j("hasSkillMd", Boolean.valueOf(zVar.f395g)), new c7.j("source", zVar.f396h.name()), new c7.j("modifiedAtMs", zVar.f397i), new c7.j("metadata", zVar.f398j));
    }

    public static void g(String str) {
        if (str.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if ('!' > cCharAt || cCharAt >= 127) {
                throw new IllegalArgumentException(b.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i2), str).toString());
            }
        }
    }

    public static final Map g0(b0 b0Var) {
        k.e(b0Var, "<this>");
        return e0.U(new c7.j("id", b0Var.f284a), new c7.j("name", b0Var.f285b), new c7.j("description", b0Var.f286c), new c7.j("version", b0Var.f287d), new c7.j("tags", b0Var.f288e), new c7.j("isEnabled", Boolean.valueOf(b0Var.f289f)), new c7.j("type", b0Var.f290g.name()), new c7.j("category", b0Var.f291h), new c7.j("source", b0Var.f292i.name()), new c7.j("modifiedAtMs", b0Var.f293j), new c7.j("metadata", b0Var.f294k));
    }

    public static void h(int i2, int i10, int i11) {
        if (i2 >= 0 && i10 <= i11) {
            if (i2 > i10) {
                throw new IllegalArgumentException(x.k("fromIndex: ", i2, i10, " > toIndex: "));
            }
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i10 + ", size: " + i11);
    }

    public static final l h0(Map map) {
        Object obj = map.get("provider");
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = map.get("model");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = map.get("baseUrl");
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        Object obj4 = map.get("api");
        String str4 = obj4 instanceof String ? (String) obj4 : null;
        Object obj5 = map.get("apiKey");
        return new l(str, str2, str3, str4, obj5 instanceof String ? (String) obj5 : null);
    }

    public static void i(String str, String str2) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b.i("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i2), str2));
                sb2.append(b.q(str2) ? "" : ": ".concat(str));
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }

    public static final Set i0(Map map) {
        Object objN;
        Object obj = map.get("scopes");
        List list = obj instanceof List ? (List) obj : null;
        if (list == null) {
            return d7.b0.f2947f;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
                k.d(upperCase, "toUpperCase(...)");
                objN = a6.x.valueOf(upperCase);
            } catch (Throwable th) {
                objN = w7.e0.n(th);
            }
            if (objN instanceof c7.l) {
                objN = null;
            }
            a6.x xVar = (a6.x) objN;
            if (xVar != null) {
                linkedHashSet.add(xVar);
            }
        }
        return linkedHashSet;
    }

    public static final y j0(Map map) {
        HashSet hashSet;
        Object objN;
        if (map.isEmpty()) {
            return null;
        }
        Object obj = map.get("sources");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            HashSet hashSet2 = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
                    k.d(upperCase, "toUpperCase(...)");
                    objN = i.valueOf(upperCase);
                } catch (Throwable th) {
                    objN = w7.e0.n(th);
                }
                if (objN instanceof c7.l) {
                    objN = null;
                }
                i iVar = (i) objN;
                if (iVar != null) {
                    hashSet2.add(iVar);
                }
            }
            hashSet = hashSet2;
        } else {
            hashSet = null;
        }
        Object obj2 = map.get("tagsAny");
        List list2 = obj2 instanceof List ? (List) obj2 : null;
        Set setQ1 = list2 != null ? d7.r.q1(list2) : null;
        Object obj3 = map.get("tagsAll");
        List list3 = obj3 instanceof List ? (List) obj3 : null;
        Set setQ12 = list3 != null ? d7.r.q1(list3) : null;
        Object obj4 = map.get("enabled");
        Boolean bool = obj4 instanceof Boolean ? (Boolean) obj4 : null;
        Object obj5 = map.get("hasSkillMd");
        Boolean bool2 = obj5 instanceof Boolean ? (Boolean) obj5 : null;
        Object obj6 = map.get("modifiedOnOrAfterMs");
        Number number = obj6 instanceof Number ? (Number) obj6 : null;
        return new y(hashSet, setQ1, setQ12, bool, bool2, number != null ? Long.valueOf(number.longValue()) : null);
    }

    public static final int k(v vVar) {
        k.e(vVar, "<this>");
        g8.c cVarB = vVar.getAnnotations().b(m.f2046q);
        if (cVarB == null) {
            return 0;
        }
        j9.g gVar = (j9.g) e0.Q(c8.n.f2059d, cVarB.b());
        k.c(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((Number) ((j9.k) gVar).f5408a).intValue();
    }

    public static final a6.a0 k0(Map map) {
        HashSet hashSet;
        Object objN;
        if (map.isEmpty()) {
            return null;
        }
        Object obj = map.get("types");
        List list = obj instanceof List ? (List) obj : null;
        if (list != null) {
            hashSet = new HashSet();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    String upperCase = ((String) it.next()).toUpperCase(Locale.ROOT);
                    k.d(upperCase, "toUpperCase(...)");
                    objN = c0.valueOf(upperCase);
                } catch (Throwable th) {
                    objN = w7.e0.n(th);
                }
                if (objN instanceof c7.l) {
                    objN = null;
                }
                c0 c0Var = (c0) objN;
                if (c0Var != null) {
                    hashSet.add(c0Var);
                }
            }
        } else {
            hashSet = null;
        }
        Object obj2 = map.get("tagsAny");
        List list2 = obj2 instanceof List ? (List) obj2 : null;
        Set setQ1 = list2 != null ? d7.r.q1(list2) : null;
        Object obj3 = map.get("enabled");
        return new a6.a0(hashSet, setQ1, obj3 instanceof Boolean ? (Boolean) obj3 : null);
    }

    public static d8.g l(d8.c cVar, boolean z4) {
        String lowerCase;
        k.e(cVar, "functionClass");
        List list = cVar.f2990p;
        d8.g gVar = new d8.g(cVar, null, 1, z4);
        i8.v vVarB0 = cVar.B0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((q0) obj).a0() != 2) {
                break;
            }
            arrayList.add(obj);
        }
        p pVarR1 = d7.r.r1(arrayList);
        ArrayList arrayList2 = new ArrayList(t.A0(pVarR1, 10));
        Iterator it = pVarR1.iterator();
        while (true) {
            d0 d0Var = (d0) it;
            if (!d0Var.f2955g.hasNext()) {
                v9.z zVarK = ((q0) d7.r.W0(list)).k();
                f8.n nVar = f8.o.f3492e;
                z zVar = z.f2978f;
                gVar.L0(null, vVarB0, zVar, zVar, arrayList2, zVarK, 4, nVar);
                d8.g gVar2 = gVar;
                gVar2.B = true;
                return gVar2;
            }
            d7.c0 c0Var = (d7.c0) d0Var.next();
            int i2 = c0Var.f2951a;
            q0 q0Var = (q0) c0Var.f2952b;
            String strB = q0Var.getName().b();
            k.d(strB, "typeParameter.name.asString()");
            if (strB.equals("T")) {
                lowerCase = "instance";
            } else if (strB.equals("E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = strB.toLowerCase(Locale.ROOT);
                k.d(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            d8.g gVar3 = gVar;
            e9.f fVarE = e9.f.e(lowerCase);
            v9.z zVarK2 = q0Var.k();
            k.d(zVarK2, "typeParameter.defaultType");
            arrayList2.add(new r0(gVar3, null, i2, g8.h.f3888a, fVarE, zVarK2, false, false, false, null, n0.f3487b));
            gVar = gVar3;
        }
    }

    public static final a6.d0 l0(Map map) {
        Object obj = map.get("id");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            throw new IllegalArgumentException("update: missing id");
        }
        Object obj2 = map.get("blobRef");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 != null) {
            return new a6.d0(str, str2);
        }
        throw new IllegalArgumentException("update: missing blobRef");
    }

    public static final v9.z m(c8.h hVar, g8.j jVar, v vVar, List list, ArrayList arrayList, v vVar2, boolean z4) {
        f8.e eVarJ;
        int i2 = 0;
        ArrayList arrayList2 = new ArrayList(list.size() + arrayList.size() + (vVar != null ? 1 : 0) + 1);
        ArrayList arrayList3 = new ArrayList(t.A0(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList3.add(n7.m.f((v) it.next()));
        }
        arrayList2.addAll(arrayList3);
        ea.k.a(arrayList2, vVar != null ? n7.m.f(vVar) : null);
        Iterator it2 = arrayList.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            int i11 = i10 + 1;
            if (i10 < 0) {
                d7.s.z0();
                throw null;
            }
            arrayList2.add(n7.m.f((v) next));
            i10 = i11;
        }
        arrayList2.add(n7.m.f(vVar2));
        int size = list.size() + arrayList.size() + (vVar == null ? 0 : 1);
        if (z4) {
            eVarJ = hVar.v(size);
        } else {
            e9.f fVar = c8.n.f2056a;
            eVarJ = hVar.j("Function" + size);
        }
        g8.j kVar = g8.h.f3888a;
        if (vVar != null) {
            e9.c cVar = m.f2045p;
            if (!jVar.g(cVar)) {
                ArrayList arrayListB1 = d7.r.b1(jVar, new g8.l(hVar, cVar, a0.f2944f));
                jVar = arrayListB1.isEmpty() ? kVar : new g8.k(i2, arrayListB1);
            }
        }
        if (!list.isEmpty()) {
            int size2 = list.size();
            e9.c cVar2 = m.f2046q;
            if (!jVar.g(cVar2)) {
                ArrayList arrayListB12 = d7.r.b1(jVar, new g8.l(hVar, cVar2, e0.T(new c7.j(c8.n.f2059d, new j9.k(size2)))));
                if (!arrayListB12.isEmpty()) {
                    kVar = new g8.k(i2, arrayListB12);
                }
                jVar = kVar;
            }
        }
        return v9.d.q(v9.c.w(jVar), eVarJ, arrayList2);
    }

    public static final boolean m0(Throwable th, p7.a aVar) {
        Collection collectionS;
        Object objInvoke;
        k.e(th, "<this>");
        Integer num = l7.a.f5845a;
        m0.e eVar = null;
        if (num == null || num.intValue() >= 19) {
            Throwable[] suppressed = th.getSuppressed();
            k.d(suppressed, "getSuppressed(...)");
            collectionS = d7.n.S(suppressed);
        } else {
            Method method = k7.a.f5649b;
            collectionS = (method == null || (objInvoke = method.invoke(th, null)) == null) ? z.f2978f : d7.n.S((Throwable[]) objInvoke);
        }
        boolean z4 = false;
        if (!collectionS.isEmpty()) {
            Iterator it = collectionS.iterator();
            while (it.hasNext()) {
                if (((Throwable) it.next()) instanceof m0.e) {
                    return false;
                }
            }
        }
        try {
            List list = (List) aVar.c();
            boolean zIsEmpty = list.isEmpty();
            z4 = !zIsEmpty;
            if (!zIsEmpty) {
                eVar = new m0.e(list);
            }
        } catch (Throwable th2) {
            eVar = th2;
        }
        if (eVar != null) {
            ib.k.e(th, eVar);
        }
        return z4;
    }

    public static final f0 n(f8.e eVar, f8.e eVar2) {
        k.e(eVar, "from");
        k.e(eVar2, "to");
        eVar.s().size();
        eVar2.s().size();
        List listS = eVar.s();
        k.d(listS, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(t.A0(listS, 10));
        Iterator it = listS.iterator();
        while (it.hasNext()) {
            arrayList.add(((q0) it.next()).h());
        }
        List listS2 = eVar2.s();
        k.d(listS2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(t.A0(listS2, 10));
        Iterator it2 = listS2.iterator();
        while (it2.hasNext()) {
            v9.z zVarK = ((q0) it2.next()).k();
            k.d(zVarK, "it.defaultType");
            arrayList2.add(n7.m.f(zVarK));
        }
        return new f0(1, e0.Z(d7.r.s1(arrayList, arrayList2)));
    }

    public static final Class n0(ClassLoader classLoader, String str) {
        k.e(str, "fqName");
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00cb, code lost:
    
        if (r7 == 16) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cd, code lost:
    
        if (r8 != (-1)) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d1, code lost:
    
        r0 = r7 - r8;
        java.lang.System.arraycopy(r3, r8, r3, 16 - r0, r0);
        java.util.Arrays.fill(r3, r8, (16 - r7) + r8, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e1, code lost:
    
        return java.net.InetAddress.getByAddress(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.net.InetAddress o(java.lang.String r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s7.a.o(java.lang.String, int, int):java.net.InetAddress");
    }

    public static final long p(long j2) {
        long j4 = (j2 << 1) + 1;
        int i2 = ha.a.f4249h;
        int i10 = ha.b.f4250a;
        return j4;
    }

    public static final e9.f q(v vVar) {
        String str;
        g8.c cVarB = vVar.getAnnotations().b(m.f2047r);
        if (cVarB != null) {
            Object objG1 = d7.r.g1(cVarB.b().values());
            w wVar = objG1 instanceof w ? (w) objG1 : null;
            if (wVar != null && (str = (String) wVar.f5408a) != null) {
                if (!e9.f.f(str)) {
                    str = null;
                }
                if (str != null) {
                    return e9.f.e(str);
                }
            }
        }
        return null;
    }

    public static l0 r(n4.d dVar, String str) throws JSONException {
        k.e(dVar, "outcome");
        k.e(str, "sessionId");
        if (!dVar.f6849a) {
            String str2 = dVar.f6851c;
            if (str2 == null) {
                str2 = "AGENT_RUNTIME_ERROR";
            }
            String str3 = dVar.f6852d;
            if (str3 == null) {
                str3 = "unknown error";
            }
            return new l0(false, null, new j0(str2, str3, null));
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ok", true);
        String str4 = dVar.f6850b;
        if (str4 == null) {
            str4 = "";
        }
        jSONObject.put("summary", str4);
        jSONObject.put("session_id", str);
        return new l0(true, jSONObject.toString(), null);
    }

    public static final List t(v vVar) {
        k.e(vVar, "<this>");
        B(vVar);
        int iK = k(vVar);
        if (iK == 0) {
            return z.f2978f;
        }
        List listSubList = vVar.C0().subList(0, iK);
        ArrayList arrayList = new ArrayList(t.A0(listSubList, 10));
        Iterator it = listSubList.iterator();
        while (it.hasNext()) {
            v vVarB = ((p0) it.next()).b();
            k.d(vVarB, "it.type");
            arrayList.add(vVarB);
        }
        return arrayList;
    }

    public static final e u(g gVar) {
        if (!(gVar instanceof f8.e) || !c8.h.I(gVar)) {
            return null;
        }
        e9.e eVarH = l9.d.h(gVar);
        if (!eVarH.d() || eVarH.f3193a.isEmpty()) {
            return null;
        }
        s9.d dVar = e.f2993h;
        String strB = eVarH.f().b();
        k.d(strB, "shortName().asString()");
        e9.c cVarE = eVarH.g().e();
        dVar.getClass();
        d8.d dVarM = s9.d.m(strB, cVarE);
        if (dVarM != null) {
            return dVarM.f2991a;
        }
        return null;
    }

    public static final v v(v vVar) {
        k.e(vVar, "<this>");
        B(vVar);
        if (vVar.getAnnotations().b(m.f2045p) == null) {
            return null;
        }
        return ((p0) vVar.C0().get(k(vVar))).b();
    }

    public static final i1.n0 w(i1.n0 n0Var) {
        i1.f0 f0Var = n0Var.f4544t.f4437t;
        while (true) {
            i1.f0 f0VarN = f0Var.n();
            i1.f0 f0Var2 = null;
            if ((f0VarN != null ? f0VarN.f4458l : null) == null) {
                i1.n0 n0VarX0 = ((d1) f0Var.H.f4402h).x0();
                k.b(n0VarX0);
                return n0VarX0;
            }
            i1.f0 f0VarN2 = f0Var.n();
            if (f0VarN2 != null) {
                f0Var2 = f0VarN2.f4458l;
            }
            k.b(f0Var2);
            i1.f0 f0VarN3 = f0Var.n();
            k.b(f0VarN3);
            f0Var = f0VarN3.f4458l;
            k.b(f0Var);
        }
    }

    public static final Bundle x(Bundle bundle, String str) {
        k.e(str, "key");
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return bundle2;
        }
        throw new IllegalArgumentException(a1.a.j("No valid saved state was found for the key '", str, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
    }

    public static final long y(double d6) {
        return Q((float) d6, 4294967296L);
    }

    public static final long z(int i2) {
        return Q(i2, 4294967296L);
    }

    public abstract void K(ab.e0 e0Var, int i2, String str);

    public void L(ab.e0 e0Var, int i2, String str) {
        k.e(e0Var, "webSocket");
    }

    public abstract void M(nb.g gVar, Exception exc, ab.z zVar);

    public void N(ab.e0 e0Var, String str) {
        k.e(e0Var, "webSocket");
    }

    public void O(ab.e0 e0Var, ob.k kVar) {
        k.e(e0Var, "webSocket");
    }

    public abstract void P(ab.e0 e0Var, ab.z zVar);

    public abstract boolean j(h1.f fVar);

    public abstract Object s(h1.f fVar);
}
