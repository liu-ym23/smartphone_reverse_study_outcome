package com.baidu.a;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.a.b;
import com.baidu.a.f;
import com.baidu.a.g;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f4611a;

    /* renamed from: f, reason: collision with root package name */
    private c f4616f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f4617g;

    /* renamed from: i, reason: collision with root package name */
    private long f4619i;

    /* renamed from: j, reason: collision with root package name */
    private long f4620j;

    /* renamed from: k, reason: collision with root package name */
    private int f4621k;

    /* renamed from: b, reason: collision with root package name */
    private final g f4612b = g.a();

    /* renamed from: c, reason: collision with root package name */
    private final e f4613c = e.a();

    /* renamed from: d, reason: collision with root package name */
    private final f f4614d = new f("DNS", true);

    /* renamed from: e, reason: collision with root package name */
    private final f f4615e = new f("HTTPDNS", false);

    /* renamed from: h, reason: collision with root package name */
    private EnumC0003a f4618h = EnumC0003a.POLICY_TOLERANT;

    /* renamed from: com.baidu.a.a$a, reason: collision with other inner class name */
    public enum EnumC0003a {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    private a(Context context) {
        this.f4617g = context;
        f();
        this.f4616f.a();
        this.f4620j = System.currentTimeMillis();
    }

    public static a a(Context context) {
        if (f4611a == null) {
            synchronized (a.class) {
                try {
                    if (f4611a == null) {
                        f4611a = new a(context);
                    }
                } finally {
                }
            }
        }
        return f4611a;
    }

    private void f() {
        this.f4616f = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f4617g.registerReceiver(this.f4616f, intentFilter);
    }

    public f b() {
        return this.f4614d;
    }

    public EnumC0003a c() {
        return this.f4618h;
    }

    public g d() {
        return this.f4612b;
    }

    public int e() {
        return this.f4621k;
    }

    public b a(String str, boolean z4) throws UnknownHostException {
        if (d.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            return new b(b.EnumC0004b.RESOLVE_NONEED, b.a.BDHttpDnsResolveOK, arrayList, null);
        }
        if (d.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            return new b(b.EnumC0004b.RESOLVE_NONEED, b.a.BDHttpDnsResolveOK, null, arrayList2);
        }
        b.EnumC0004b enumC0004b = b.EnumC0004b.RESOLVE_NONE;
        f.a aVarA = this.f4615e.a(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList3 = new ArrayList<>();
        if (a(jCurrentTimeMillis)) {
            if (aVarA == null) {
                arrayList3.add(str);
            } else if (aVarA.a()) {
                this.f4612b.a(str);
            }
            if (b(jCurrentTimeMillis)) {
                arrayList3.addAll(this.f4612b.c());
            }
            this.f4612b.a(arrayList3, new i(this.f4617g));
        } else {
            j.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
        }
        if (aVarA != null) {
            b.EnumC0004b enumC0004b2 = aVarA.a() ? b.EnumC0004b.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : b.EnumC0004b.RESOLVE_FROM_HTTPDNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = aVarA.b() != null ? aVarA.b().toString() : null;
            objArr[2] = aVarA.c() != null ? aVarA.c().toString() : null;
            objArr[3] = enumC0004b2.toString();
            j.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            return new b(enumC0004b2, b.a.BDHttpDnsResolveOK, aVarA.b(), aVarA.c());
        }
        if (aVarA == null && z4) {
            j.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
            return new b(enumC0004b, b.a.BDHttpDnsResolveErrorCacheMiss, null, null);
        }
        f.a aVarA2 = this.f4614d.a(str);
        if (aVarA2 != null) {
            b.EnumC0004b enumC0004b3 = b.EnumC0004b.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str;
            objArr2[1] = aVarA2.b() != null ? aVarA2.b().toString() : null;
            objArr2[2] = aVarA2.c() != null ? aVarA2.c().toString() : null;
            objArr2[3] = enumC0004b3.toString();
            j.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr2);
            return new b(enumC0004b3, b.a.BDHttpDnsResolveOK, aVarA2.b(), aVarA2.c());
        }
        b bVarA = this.f4613c.a(str);
        if (bVarA.b() == b.a.BDHttpDnsResolveOK) {
            f.a aVar = new f.a();
            aVar.a(60L);
            aVar.b(System.currentTimeMillis() / 1000);
            aVar.a(bVarA.c());
            aVar.b(bVarA.d());
            this.f4614d.a(str, aVar);
            Object[] objArr3 = new Object[4];
            objArr3[0] = str;
            objArr3[1] = aVar.b() != null ? aVar.b().toString() : null;
            objArr3[2] = aVar.c() != null ? aVar.c().toString() : null;
            objArr3[3] = bVarA.a().toString();
            j.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr3);
        } else {
            j.a("Sync resolve failed, host(%s), dns resolve failed", str);
        }
        return bVarA;
    }

    public void b(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.f4612b.d(str);
        String strSubstring = str.substring(0, 3);
        for (int i4 = 0; i4 < length - 6; i4++) {
            StringBuilder sbS = B0.g.s(strSubstring);
            sbS.append(String.valueOf('*'));
            strSubstring = sbS.toString();
        }
        StringBuilder sbS2 = B0.g.s(strSubstring);
        sbS2.append(str.substring(length - 3));
        j.a("Set secret to %s", sbS2.toString());
    }

    public f a() {
        return this.f4615e;
    }

    public void a(EnumC0003a enumC0003a) {
        this.f4618h = enumC0003a;
        this.f4615e.a(enumC0003a == EnumC0003a.POLICY_STRICT);
        j.a("Set cache policy to %s", enumC0003a.name());
    }

    public void a(String str) {
        if (str.length() <= 64) {
            this.f4612b.c(str);
            j.a("Set account id to %s", str);
        } else {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList.size() <= 0) {
            j.a("Set pre resolve hosts error, get empty hosts", new Object[0]);
            return;
        }
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int iD = this.f4612b.d();
        if (arrayList2.size() > iD) {
            j.a("The current number of hosts is %d, and the max supported size is %s.Please reduce it to %s or less.", Integer.valueOf(arrayList2.size()), Integer.valueOf(iD), Integer.valueOf(iD));
            return;
        }
        int i4 = this.f4621k + 1;
        this.f4621k = i4;
        if (i4 > 1) {
            j.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
        }
        this.f4619i = System.currentTimeMillis();
        String strR = "";
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            strR = B0.g.r(B0.g.s(strR), (String) arrayList2.get(i5), ",");
        }
        if (strR == null || strR.isEmpty()) {
            return;
        }
        String strSubstring = strR.substring(0, strR.length() - 1);
        j.a("Set pre resolve hosts: %s", strSubstring);
        this.f4612b.a(strSubstring, g.d.DNLIST_HOSTS, new i(this.f4617g));
    }

    private boolean b(long j4) {
        if (j4 - this.f4620j <= 60000) {
            return false;
        }
        this.f4620j = j4;
        return true;
    }

    public void a(boolean z4) {
        this.f4612b.a(z4);
        j.a("Set https enabled to %b", Boolean.valueOf(z4));
    }

    public void a(boolean z4, boolean z5) {
        this.f4616f.a(z4);
        this.f4616f.b(z5);
        j.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z4), Boolean.valueOf(z5));
    }

    private boolean a(long j4) {
        return this.f4612b.f() || j4 - this.f4619i > 1000;
    }
}
