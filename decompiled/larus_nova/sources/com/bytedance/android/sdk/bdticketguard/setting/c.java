package com.bytedance.android.sdk.bdticketguard.setting;

/* JADX INFO: loaded from: classes3.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile d<T> f163991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f163992b;

    public final d a() {
        d<T> r100 = this.f163991a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new b(new ExternalSettingDelegate$getValue$1(this));
    }

    public c(T r100) {
        this.f163992b = r100;
    }
}
