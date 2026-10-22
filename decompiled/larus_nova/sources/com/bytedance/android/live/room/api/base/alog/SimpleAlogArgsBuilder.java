package com.bytedance.android.live.room.api.base.alog;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import tb2.c;

/* JADX INFO: loaded from: classes47.dex */
public final class SimpleAlogArgsBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f98897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f98898b;

    public final a b() {
        return new a(((StringBuilder) this.f98898b.getValue()).toString(), this.f98897a);
    }

    public SimpleAlogArgsBuilder() {
        this.f98898b = LazyKt.lazy(SimpleAlogArgsBuilder$strBuilder$2.INSTANCE);
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ((StringBuilder) this.f98898b.getValue()).append(r100 + '.');
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ((StringBuilder) this.f98898b.getValue()).append("tag:" + r100 + '\t');
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ((StringBuilder) this.f98898b.getValue()).append(r100 + com.alipay.sdk.m.n.a.f25612h + r101 + c.DEFAULT_TEXT);
    }
}
