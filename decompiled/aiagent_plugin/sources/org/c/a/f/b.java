package org.c.a.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: Tag.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40421a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f40422b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f40423c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f40424d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f40425e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    public static final b j = null;
    public static final b k = null;
    public static final b l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    protected static final Map<b, Set<Class<?>>> p = null;
    private final String q;
    private boolean r;

    static {
        f40421a = new b("tag:yaml.org,2002:yaml");
        f40422b = new b("tag:yaml.org,2002:merge");
        f40423c = new b("tag:yaml.org,2002:set");
        f40424d = new b("tag:yaml.org,2002:pairs");
        f40425e = new b("tag:yaml.org,2002:omap");
        f = new b("tag:yaml.org,2002:binary");
        b r1 = new b("tag:yaml.org,2002:int");
        g = r1;
        b r2 = new b("tag:yaml.org,2002:float");
        h = r2;
        i = new b("tag:yaml.org,2002:timestamp");
        j = new b("tag:yaml.org,2002:bool");
        k = new b("tag:yaml.org,2002:null");
        l = new b("tag:yaml.org,2002:str");
        m = new b("tag:yaml.org,2002:seq");
        n = new b("tag:yaml.org,2002:map");
        o = new b("tag:yaml.org,2002:comment");
        HashMap r3 = new HashMap();
        p = r3;
        HashSet r4 = new HashSet();
        r4.add(Double.class);
        r4.add(Float.class);
        r4.add(BigDecimal.class);
        r3.put(r2, r4);
        HashSet r5 = new HashSet();
        r5.add(Integer.class);
        r5.add(Long.class);
        r5.add(BigInteger.class);
        r3.put(r1, r5);
        HashSet r6 = new HashSet();
        r6.add(Date.class);
        r6.add(ZeusTransformUtils.forName("java.sql.Date", "com.obric.aiagent.plugin"));     // Catch: ClassNotFoundException -> L6
        r6.add(ZeusTransformUtils.forName("java.sql.Timestamp", "com.obric.aiagent.plugin"));     // Catch: ClassNotFoundException -> L6
    L4:
        p.put(i, r6);
    }

    public b(String r3) {
        this.r = false;
        Objects.requireNonNull(r3, "Tag must be provided.");
        if (r3.length() == 0) goto L11;
        if (r3.trim().length() != r3.length()) goto L9;
        this.q = org.c.a.m.b.a(r3);
        this.r = !r3.startsWith("tag:yaml.org,2002:");
        return;
    L9:
        throw new IllegalArgumentException("Tag must not contain leading or trailing spaces.");
    L11:
        throw new IllegalArgumentException("Tag must not be empty.");
    }

    public String a() {
        return this.q;
    }

    public String toString() {
        return this.q;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L5;
        return false;
    L5:
        return this.q.equals(((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin")).a());
    }

    public int hashCode() {
        return this.q.hashCode();
    }
}
