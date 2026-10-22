package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: ClassKey.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable, Comparable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f12962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12963c;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(b r3) {
        return a((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin"));
    }

    public b() {
        this.f12962b = null;
        this.f12961a = null;
        this.f12963c = 0;
    }

    public b(Class<?> r1) {
        this.f12962b = r1;
        String r2 = r1.getName();
        this.f12961a = r2;
        this.f12963c = r2.hashCode();
    }

    public int a(b r1) {
        return this.f12961a.compareTo(r1.f12961a);
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getClass() == getClass()) goto L12;
        return false;
    L12:
        if (((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f12962b != this.f12962b) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return this.f12963c;
    }

    public String toString() {
        return this.f12961a;
    }
}
