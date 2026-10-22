package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/RealTimeChorusBusinessLifecycleOwner;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RealTimeChorusBusinessLifecycleOwner implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f146255a;

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public RealTimeChorusBusinessLifecycleOwner() {
        LifecycleRegistry r100 = new LifecycleRegistry(this);
        this.f146255a = r100;
        r100.setCurrentState(Lifecycle.State.CREATED);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return this.f146255a;
    }
}
