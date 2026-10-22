package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopPaging.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class an<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<T> f19496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19499d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, an.class) == true) goto L8;
        return false;
    L8:
        an r6 = (an) ZeusTransformUtils.preCheckCast(r5, an.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19496a, r6.f19496a) == true) goto L12;
        return false;
    L12:
        if (this.f19497b == r6.f19497b) goto L15;
        return false;
    L15:
        if (this.f19498c == r6.f19498c) goto L18;
        return false;
    L18:
        if (this.f19499d == r6.f19499d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f19496a.hashCode() * 31) + Integer.hashCode(this.f19497b)) * 31) + Integer.hashCode(this.f19498c)) * 31) + Integer.hashCode(this.f19499d);
    }

    public String toString() {
        return "ShopPage(items=" + this.f19496a + ", page=" + this.f19497b + ", pageSize=" + this.f19498c + ", total=" + this.f19499d + ')';
    }

    public an(List<? extends T> r3, int r4, int r5, int r6) {
        List<T> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "items");
        this.f19496a = r7;
        this.f19497b = r4;
        this.f19498c = r5;
        this.f19499d = r6;
    }

    public final List<T> a() {
        return this.f19496a;
    }

    public final int b() {
        return this.f19497b;
    }

    public final boolean c() {
        if ((((long) this.f19497b) * ((long) this.f19498c)) >= this.f19499d) goto L5;
        return true;
    L5:
        return false;
    }
}
