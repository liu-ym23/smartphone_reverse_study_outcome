package com.bytedance.android.shopping.anchorv4.containers.page;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/containers/page/PageLifeCycleOwner;", "Lcom/bytedance/android/ec/core/utils/ECLifecycleOwnerAdapter;", "Landroidx/lifecycle/LifecycleEventObserver;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PageLifeCycleOwner implements ECLifecycleOwnerAdapter, LifecycleEventObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f166266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f166267b;

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return rK();
    }

    @Override // com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter
    public final Lifecycle rK() {
        return this.f166266a;
    }

    public PageLifeCycleOwner(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        this.f166267b = r100;
        this.f166266a = new LifecycleRegistry(this);
    }

    public final void a(Lifecycle.State r100) {
        this.f166266a.setCurrentState(r100);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        switch(o.f166299a[r101.ordinal()]) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L17;
        };
    L5:
        a(Lifecycle.State.DESTROYED);
        this.f166267b.getLifecycle().removeObserver(this);
        return;
    L6:
        a(Lifecycle.State.CREATED);
        return;
    L7:
        a(Lifecycle.State.STARTED);
        return;
    L8:
        a(Lifecycle.State.RESUMED);
        return;
    L9:
        a(Lifecycle.State.STARTED);
        return;
    L10:
        a(Lifecycle.State.CREATED);
        return;
    }
}
