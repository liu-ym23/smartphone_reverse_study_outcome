package com.bytedance.android.monitorV2.settings;

/* JADX INFO: loaded from: classes12.dex */
public final class b<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f163218a;

    @Override // com.bytedance.android.monitorV2.settings.c
    public final void release() {
        this.f163218a = null;
    }

    @Override // com.bytedance.android.monitorV2.settings.c
    public final T provideInstance() {
        return this.f163218a;
    }

    public b(T r100) {
        this.f163218a = r100;
    }
}
