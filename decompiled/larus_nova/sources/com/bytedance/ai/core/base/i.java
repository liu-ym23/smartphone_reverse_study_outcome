package com.bytedance.ai.core.base;

import java.util.HashMap;

/* JADX INFO: loaded from: classes43.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SessionType f36154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f36155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, h> f36156d;

    public boolean a() {
        if (this.f36156d.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int hashCode() {
        return this.f36153a.hashCode();
    }

    public final boolean equals(Object r100) {
        return super.equals(r100);
    }

    public i(String r100, SessionType r101) {
        this.f36153a = r100;
        this.f36154b = r101;
        this.f36156d = new HashMap();
    }
}
