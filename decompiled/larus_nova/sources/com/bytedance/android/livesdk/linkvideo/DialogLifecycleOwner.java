package com.bytedance.android.livesdk.linkvideo;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/DialogLifecycleOwner;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "<init>", "()V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogLifecycleOwner implements LifecycleOwnerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f147111a;

    @Override // androidx.lifecycle.LifecycleOwner
    public final /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.utils.LifecycleOwnerCompat
    public final Lifecycle getLifecycleCompat() {
        return (LifecycleRegistry) this.f147111a.getValue();
    }

    public DialogLifecycleOwner() {
        Lazy r100 = LazyKt.lazy(new DialogLifecycleOwner$lifecycleRegistry$2(this));
        this.f147111a = r100;
        ((LifecycleRegistry) r100.getValue()).handleLifecycleEvent(Lifecycle.Event.ON_START);
    }
}
