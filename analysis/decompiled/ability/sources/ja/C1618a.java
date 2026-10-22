package ja;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: ja.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1618a {
    public static final C1618a b;
    public static final C1618a c;
    public static final C1618a d;
    public static final C1618a e;
    public static final C1618a f;
    public static final C1618a g;
    public static final C1618a h;
    public static final C1618a i;

    /* renamed from: j, reason: collision with root package name */
    public static final C1618a f4789j;
    public static final HashMap k;

    /* renamed from: a, reason: collision with root package name */
    public final String f4790a;

    static {
        C1618a c1618a = new C1618a("tag:yaml.org,2002:yaml");
        b = c1618a;
        C1618a c1618a2 = new C1618a("tag:yaml.org,2002:merge");
        c = c1618a2;
        C1618a c1618a3 = new C1618a("tag:yaml.org,2002:set");
        C1618a c1618a4 = new C1618a("tag:yaml.org,2002:pairs");
        C1618a c1618a5 = new C1618a("tag:yaml.org,2002:omap");
        C1618a c1618a6 = new C1618a("tag:yaml.org,2002:binary");
        d = c1618a6;
        C1618a c1618a7 = new C1618a("tag:yaml.org,2002:int");
        e = c1618a7;
        C1618a c1618a8 = new C1618a("tag:yaml.org,2002:float");
        f = c1618a8;
        C1618a c1618a9 = new C1618a("tag:yaml.org,2002:timestamp");
        g = c1618a9;
        C1618a c1618a10 = new C1618a("tag:yaml.org,2002:bool");
        h = c1618a10;
        C1618a c1618a11 = new C1618a("tag:yaml.org,2002:null");
        i = c1618a11;
        C1618a c1618a12 = new C1618a("tag:yaml.org,2002:str");
        f4789j = c1618a12;
        C1618a c1618a13 = new C1618a("tag:yaml.org,2002:seq");
        C1618a c1618a14 = new C1618a("tag:yaml.org,2002:map");
        HashSet hashSet = new HashSet(15);
        hashSet.add(c1618a);
        hashSet.add(c1618a2);
        hashSet.add(c1618a3);
        hashSet.add(c1618a4);
        hashSet.add(c1618a5);
        hashSet.add(c1618a6);
        hashSet.add(c1618a7);
        hashSet.add(c1618a8);
        hashSet.add(c1618a9);
        hashSet.add(c1618a10);
        hashSet.add(c1618a11);
        hashSet.add(c1618a12);
        hashSet.add(c1618a13);
        hashSet.add(c1618a14);
        new C1618a("tag:yaml.org,2002:comment");
        HashMap map = new HashMap();
        k = map;
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Double.class);
        hashSet2.add(Float.class);
        hashSet2.add(BigDecimal.class);
        map.put(c1618a8, hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(Integer.class);
        hashSet3.add(Long.class);
        hashSet3.add(BigInteger.class);
        map.put(c1618a7, hashSet3);
        HashSet hashSet4 = new HashSet();
        hashSet4.add(Date.class);
        try {
            hashSet4.add(Class.forName("java.sql.Date"));
            hashSet4.add(Class.forName("java.sql.Timestamp"));
        } catch (ClassNotFoundException unused) {
        }
        k.put(g, hashSet4);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public C1618a(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ja.C1618a.<init>(java.lang.String):void");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1618a)) {
            return false;
        }
        return this.f4790a.equals(((C1618a) obj).f4790a);
    }

    public final int hashCode() {
        return this.f4790a.hashCode();
    }

    public final String toString() {
        return this.f4790a;
    }
}
