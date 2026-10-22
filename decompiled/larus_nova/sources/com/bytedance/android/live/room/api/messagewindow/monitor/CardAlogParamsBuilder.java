package com.bytedance.android.live.room.api.messagewindow.monitor;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class CardAlogParamsBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Throwable f98996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f98997b;

    public final a b() {
        return new a(((StringBuilder) this.f98997b.getValue()).toString(), this.f98996a);
    }

    public CardAlogParamsBuilder() {
        this.f98997b = LazyKt.lazy(CardAlogParamsBuilder$strBuilder$2.INSTANCE);
    }

    public final void c(String r100) {
        ((StringBuilder) this.f98997b.getValue()).append(r100 + '.');
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ((StringBuilder) this.f98997b.getValue()).append("tag:" + r100 + '\t');
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        ((StringBuilder) this.f98997b.getValue()).append("the " + r100 + " is " + r101 + '.');
    }
}
