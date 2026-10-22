package com.bytedance.android.live.broadcast.api.stable;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes45.dex */
public abstract class AbsAnchorFactor<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f59072a;

    public abstract String a();

    public abstract T b();

    public AbsAnchorFactor() {
        this.f59072a = LazyKt.lazy(new AbsAnchorFactor$factorForStrategy$2(this));
    }
}
