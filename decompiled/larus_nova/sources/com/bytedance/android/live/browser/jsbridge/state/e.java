package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.live.browser.jsbridge.i;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> extends a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i.f<T> f63953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final T f63954d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JsonElement f63955e;

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        return this.f63954d;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final i.f<T> d() {
        return this.f63953c;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final JsonElement e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f63955e.isJsonObject() == true) goto L7;
        return this.f63955e;
    L7:
        return f(r100, this.f63955e);
    }

    public e(a<T> r100, T r101, JsonElement r102) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r102, "jsonElement");
        super(0);
        this.f63954d = r101;
        this.f63955e = r102;
        this.f63953c = r100.d();
    }
}
