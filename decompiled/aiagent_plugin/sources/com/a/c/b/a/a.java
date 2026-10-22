package com.a.c.b.a;

import com.a.c.b.d.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: FieldConstraints.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Integer> f3093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Integer, Integer> f3094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<c> f3095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f3096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Integer f3097e;
    private final boolean f;

    public a(Map<String, Integer> r3, Map<Integer, Integer> r4, Set<c> r5, int r6, int r7, boolean r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        this.f3093a = Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r9, "String mapping must not be null"), Map.class, "com.obric.aiagent.plugin"));
        this.f3094b = Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r10, "Integer mapping must not be null"), Map.class, "com.obric.aiagent.plugin"));
        this.f3095c = Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(com.a.e.a.a(r11, "Special (non-standard) chars set must not be null"), Set.class, "com.obric.aiagent.plugin"));
        this.f3096d = Integer.valueOf(r6);
        this.f3097e = Integer.valueOf(r7);
        this.f = r8;
    }

    public int a() {
        return this.f3096d.intValue();
    }

    public int b() {
        return this.f3097e.intValue();
    }

    public Set<c> c() {
        return this.f3095c;
    }

    public boolean a(int r2) {
        if (r2 >= a()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > b()) goto L7;
        return true;
    }

    public boolean b(int r4) {
        if (r4 > 0) goto L5;
    L9:
        return false;
    L5:
        if (r4 > ((b() - a()) + 1)) goto L9;
        if (r4 > b()) goto L9;
        return true;
    }

    public Set<String> d() {
        return this.f3093a.keySet();
    }

    public Integer a(String r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(this.f3093a.get(r2), Integer.class, "com.obric.aiagent.plugin");
    }

    public Integer a(Integer r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(this.f3094b.get(r2), Integer.class, "com.obric.aiagent.plugin");
    }

    public boolean e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L25;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f != r6.f) goto L24;
        if (this.f3093a.equals(r6.f3093a) == false) goto L24;
        if (this.f3094b.equals(r6.f3094b) == false) goto L24;
        if (this.f3095c.equals(r6.f3095c) == false) goto L24;
        if (this.f3096d.equals(r6.f3096d) == false) goto L24;
        if (this.f3097e.equals(r6.f3097e) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f3093a, this.f3094b, this.f3095c, this.f3096d, this.f3097e, Boolean.valueOf(this.f)});
    }
}
