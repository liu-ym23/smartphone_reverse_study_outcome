package be;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f2081b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f2082c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f2083d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f2084e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f2085f;

    /* renamed from: g, reason: collision with root package name */
    public static final a f2086g;

    /* renamed from: h, reason: collision with root package name */
    public static final a f2087h;
    public static final a i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f2088j;

    /* renamed from: k, reason: collision with root package name */
    public static final HashMap f2089k;

    /* renamed from: a, reason: collision with root package name */
    public final String f2090a;

    static {
        a aVar = new a("tag:yaml.org,2002:yaml");
        f2081b = aVar;
        a aVar2 = new a("tag:yaml.org,2002:merge");
        f2082c = aVar2;
        a aVar3 = new a("tag:yaml.org,2002:set");
        a aVar4 = new a("tag:yaml.org,2002:pairs");
        a aVar5 = new a("tag:yaml.org,2002:omap");
        a aVar6 = new a("tag:yaml.org,2002:binary");
        f2083d = aVar6;
        a aVar7 = new a("tag:yaml.org,2002:int");
        f2084e = aVar7;
        a aVar8 = new a("tag:yaml.org,2002:float");
        f2085f = aVar8;
        a aVar9 = new a("tag:yaml.org,2002:timestamp");
        f2086g = aVar9;
        a aVar10 = new a("tag:yaml.org,2002:bool");
        f2087h = aVar10;
        a aVar11 = new a("tag:yaml.org,2002:null");
        i = aVar11;
        a aVar12 = new a("tag:yaml.org,2002:str");
        f2088j = aVar12;
        a aVar13 = new a("tag:yaml.org,2002:seq");
        a aVar14 = new a("tag:yaml.org,2002:map");
        HashSet hashSet = new HashSet(15);
        hashSet.add(aVar);
        hashSet.add(aVar2);
        hashSet.add(aVar3);
        hashSet.add(aVar4);
        hashSet.add(aVar5);
        hashSet.add(aVar6);
        hashSet.add(aVar7);
        hashSet.add(aVar8);
        hashSet.add(aVar9);
        hashSet.add(aVar10);
        hashSet.add(aVar11);
        hashSet.add(aVar12);
        hashSet.add(aVar13);
        hashSet.add(aVar14);
        new a("tag:yaml.org,2002:comment");
        HashMap map = new HashMap();
        f2089k = map;
        HashSet hashSet2 = new HashSet();
        hashSet2.add(Double.class);
        hashSet2.add(Float.class);
        hashSet2.add(BigDecimal.class);
        map.put(aVar8, hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(Integer.class);
        hashSet3.add(Long.class);
        hashSet3.add(BigInteger.class);
        map.put(aVar7, hashSet3);
        HashSet hashSet4 = new HashSet();
        hashSet4.add(Date.class);
        try {
            hashSet4.add(Class.forName("java.sql.Date"));
            hashSet4.add(Class.forName("java.sql.Timestamp"));
        } catch (ClassNotFoundException unused) {
        }
        f2089k.put(f2086g, hashSet4);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: be.a.<init>(java.lang.String):void");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f2090a.equals(((a) obj).f2090a);
    }

    public final int hashCode() {
        return this.f2090a.hashCode();
    }

    public final String toString() {
        return this.f2090a;
    }
}
