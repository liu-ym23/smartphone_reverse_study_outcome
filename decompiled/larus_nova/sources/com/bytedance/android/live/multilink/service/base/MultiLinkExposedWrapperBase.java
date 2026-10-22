package com.bytedance.android.live.multilink.service.base;

import com.bytedance.android.live.multilink.MultiLinkInitializer;
import dn0.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class MultiLinkExposedWrapperBase<T extends a> {
    private final Lazy realInstance$delegate;

    public final T getRealInstance() {
        return (T) this.realInstance$delegate.getValue();
    }

    public MultiLinkExposedWrapperBase(final Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "instanceClass");
        this.realInstance$delegate = LazyKt.lazy(new MultiLinkExposedWrapperBase$realInstance$2(r100));
        MultiLinkInitializer.INSTANCE.ensureInitialized();
    }
}
