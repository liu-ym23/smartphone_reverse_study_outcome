package com.bytedance.android.livesdk.livecommerce.room.quick;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/quick/LiveRoomLifecycleOwner;", "Lcom/bytedance/android/ec/core/utils/ECLifecycleOwnerAdapter;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRoomLifecycleOwner implements ECLifecycleOwnerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f151868a;

    public LiveRoomLifecycleOwner() {
        this.f151868a = new LifecycleRegistry(this);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return rK();
    }

    @Override // com.bytedance.android.ec.core.utils.ECLifecycleOwnerAdapter
    public final Lifecycle rK() {
        return this.f151868a;
    }
}
