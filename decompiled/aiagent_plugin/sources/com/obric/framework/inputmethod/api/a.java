package com.obric.framework.inputmethod.api;

import android.os.Bundle;
import d.f;
import d.g;

/* JADX INFO: compiled from: ObricInjectEventCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f33236a;

    public static /* synthetic */ ObricInjectEventCallback$stub$2$1 lambda$mSAex417P14Y3c9kDp_6nM0EWJA(a r0) {
        return a(r0);
    }

    public abstract void a(int r1, Bundle r2);

    public a() {
        this.f33236a = g.a(new $$Lambda$a$mSAex417P14Y3c9kDp_6nM0EWJA(this));
    }

    public final Object a() {
        return this.f33236a.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.framework.inputmethod.api.ObricInjectEventCallback$stub$2$1] */
    private static final ObricInjectEventCallback$stub$2$1 a(final a r1) {
        return new ObricInjectEventCallback$stub$2$1(r1);
    }
}
