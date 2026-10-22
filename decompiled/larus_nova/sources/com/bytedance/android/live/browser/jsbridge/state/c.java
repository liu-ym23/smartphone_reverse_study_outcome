package com.bytedance.android.live.browser.jsbridge.state;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c<T> extends BaseObservableState<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f63951e;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        return this.f63951e;
    }

    public c(T r100) {
        super(false);
        this.f63951e = r100;
    }
}
