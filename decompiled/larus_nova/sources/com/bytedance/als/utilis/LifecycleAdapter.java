package com.bytedance.als.utilis;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/als/utilis/LifecycleAdapter;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class LifecycleAdapter extends Lifecycle implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f38106a;

    @Override // androidx.lifecycle.Lifecycle
    public final Lifecycle.State getCurrentState() {
        return this.f38106a.getCurrentState();
    }

    public LifecycleAdapter() {
        this.f38106a = new LifecycleRegistry(this);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f38106a;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f38106a.addObserver(r100);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f38106a.removeObserver(r100);
    }
}
