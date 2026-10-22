package com.obric.autoaction.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ComponentBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.m.c<? extends h> f22638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22639b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22638a, r6.f22638a) == true) goto L12;
        return false;
    L12:
        if (this.f22639b == r6.f22639b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f22638a.hashCode() * 31) + Integer.hashCode(this.f22639b);
    }

    public String toString() {
        return "UIComponentSpec(type=" + this.f22638a + ", viewId=" + this.f22639b + ')';
    }

    @Override // com.obric.autoaction.a.d
    public d.m.c<? extends h> getType() {
        return this.f22638a;
    }

    public final int a() {
        return this.f22639b;
    }
}
