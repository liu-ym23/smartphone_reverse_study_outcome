package com.bytedance.android.shopping.commentv3.base;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.core.utils.ECLifecycleAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/base/InvalidLifecycle;", "Lcom/bytedance/android/ec/core/utils/ECLifecycleAdapter;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InvalidLifecycle extends ECLifecycleAdapter {

    public static final class a {
    }

    static {
    }

    public InvalidLifecycle() {
    }

    @Override // com.bytedance.android.ec.core.utils.ECLifecycleAdapter
    public final Lifecycle.State f() {
        return Lifecycle.State.DESTROYED;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        dm.a.a("InvalidLifecycle_v3").i("try add observer to invalid lifecycle");
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        dm.a.a("InvalidLifecycle_v3").i("try remove observer from invalid lifecycle");
    }
}
