package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.jsbridge.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d<T> extends a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i.a<T> f63952c;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        return this.f63952c.b();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f<T> d() {
        return this.f63952c.c();
    }

    public d(i.a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        super(0);
        this.f63952c = r100;
    }
}
