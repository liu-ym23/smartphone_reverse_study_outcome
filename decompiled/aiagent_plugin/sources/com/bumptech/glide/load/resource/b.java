package com.bumptech.glide.load.resource;

import com.bumptech.glide.f.j;
import com.bumptech.glide.load.engine.v;

/* JADX INFO: compiled from: SimpleResource.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T> implements v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f3776a;

    @Override // com.bumptech.glide.load.engine.v
    public final int e() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.v
    public void f() {
    }

    public b(T r1) {
        this.f3776a = (T) j.a(r1);
    }

    @Override // com.bumptech.glide.load.engine.v
    public Class<T> c() {
        return (Class<T>) this.f3776a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.v
    public final T d() {
        return this.f3776a;
    }
}
