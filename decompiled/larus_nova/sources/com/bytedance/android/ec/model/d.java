package com.bytedance.android.ec.model;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f47856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f47857b;

    public final WeakReference<Context> getContext() {
        return this.f47856a;
    }

    public d(Context r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.f47856a = new WeakReference(r100);
        this.f47857b = Long.valueOf(r102);
    }
}
