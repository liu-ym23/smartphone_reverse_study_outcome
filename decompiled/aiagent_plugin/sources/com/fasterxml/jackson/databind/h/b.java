package com.fasterxml.jackson.databind.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: NamedType.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Class<?> f12745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final int f12746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f12747c;

    public b(Class<?> r2) {
        this(r2, null);
    }

    public b(Class<?> r2, String r3) {
        this.f12745a = r2;
        int r4 = r2.getName().hashCode();
        if (r3 != null) goto L5;
        int r0 = 0;
    L6:
        this.f12746b = r4 + r0;
        a(r3);
        return;
    L5:
        r0 = r3.hashCode();
        goto L6
    }

    public Class<?> getType() {
        return this.f12745a;
    }

    public String a() {
        return this.f12747c;
    }

    public void a(String r2) {
        if (r2 != null) goto L4;
    L5:
        r2 = null;
    L6:
        this.f12747c = r2;
        return;
    L4:
        if (r2.isEmpty() == false) goto L6;
        goto L5
    }

    public boolean b() {
        if (this.f12747c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (r5.getClass() == getClass()) goto L11;
        return false;
    L11:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f12745a != r6.f12745a) goto L17;
        if (Objects.equals(this.f12747c, r6.f12747c) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public int hashCode() {
        return this.f12746b;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("[NamedType, class ").append(this.f12745a.getName()).append(", name: ");
        if (this.f12747c != null) goto L5;
        String r3 = "null";
    L7:
        return r0.append(r3).append("]").toString();
    L5:
        r3 = "'" + this.f12747c + "'";
        goto L7
    }
}
