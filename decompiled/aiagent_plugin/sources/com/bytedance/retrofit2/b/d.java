package com.bytedance.retrofit2.b;

import com.bytedance.retrofit2.e.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<b> f9488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f9489e;
    private Object f;
    private String g;
    private String h;

    public d(String r3, int r4, String r5, List<b> r6, i r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        i r9 = (i) ZeusTransformUtils.wrapperContextForParams(r7, i.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L17;
        if (r4 < 200) goto L15;
        if (r5 == null) goto L13;
        if (r8 == null) goto L11;
        this.f9485a = r3;
        this.f9486b = r4;
        this.f9487c = r5;
        this.f9488d = Collections.unmodifiableList(new ArrayList(r8));
        this.f9489e = r9;
        return;
    L11:
        throw new IllegalArgumentException("headers == null");
    L13:
        throw new IllegalArgumentException("reason == null");
    L15:
        throw new IllegalArgumentException("Invalid status code: " + r4);
    L17:
        throw new IllegalArgumentException("url == null");
    }

    public String a() {
        return this.f9485a;
    }

    public int b() {
        return this.f9486b;
    }

    public List<b> c() {
        return this.f9488d;
    }

    public b a(String r5) {
        if (r5 == null) goto L13;
        List<b> r4 = this.f9488d;
        if (r4 == null) goto L13;
        Iterator<b> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin");
        if (r5.equalsIgnoreCase(r1.a()) == false) goto L9;
        return r1;
    L13:
        return null;
    }

    public List<b> b(String r5) {
        ArrayList r0 = null;
        if (r5 == null) goto L15;
        List<b> r4 = this.f9488d;
        if (r4 == null) goto L15;
        Iterator<b> r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin");
        if (r5.equalsIgnoreCase(r1.a()) == false) goto L9;
        if (r0 != null) goto L14;
        r0 = new ArrayList();
    L14:
        r0.add(r1);
    L15:
        return r0;
    }

    public i d() {
        return this.f9489e;
    }

    public boolean e() {
        int r1 = this.f9486b;
        if (r1 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r1 >= 300) goto L7;
        return true;
    }

    public void a(Object r1) {
        this.f = r1;
    }

    public Object f() {
        return this.f;
    }

    public void c(String r1) {
        this.g = r1;
    }

    public String g() {
        return this.h;
    }
}
