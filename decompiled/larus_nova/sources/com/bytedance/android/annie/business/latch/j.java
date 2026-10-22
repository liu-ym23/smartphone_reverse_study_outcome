package com.bytedance.android.annie.business.latch;

import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class j implements q26.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q26.a f39038a;

    @Override // q26.j
    public final String getBid() {
        return "Latch";
    }

    public j() {
        this.f39038a = new q26.a(null, false);
    }

    @Override // q26.j
    public final Map<Class<?>, Object> getAllDependency() {
        return ((q26.a) getServiceContext()).getAllDependency();
    }

    @Override // q26.j
    public final q26.h getServiceContext() {
        return this.f39038a;
    }

    @Override // q26.j
    public final <T> T a(Class<T> r100) {
        return (T) q26.j.a.a(this, r100);
    }

    @Override // q26.j
    public final <T extends q26.c> T getService(Class<T> r100) {
        return (T) q26.j.a.b(this, r100);
    }
}
