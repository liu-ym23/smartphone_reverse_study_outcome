package com.bytedance.android.shopping.widget.rittag;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c implements LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f187453a = null;

    static {
        f187453a = new c();
    }

    public c() {
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
        RitTagViewCache.f187448e.remove(r100);
        return;
    }
}
