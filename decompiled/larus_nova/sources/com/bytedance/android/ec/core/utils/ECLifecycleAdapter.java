package com.bytedance.android.ec.core.utils;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/utils/ECLifecycleAdapter;", "Landroidx/lifecycle/Lifecycle;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECLifecycleAdapter extends Lifecycle {
    public abstract Lifecycle.State f();

    @Override // androidx.lifecycle.Lifecycle
    public final Lifecycle.State getCurrentState() {
        return f();
    }

    public ECLifecycleAdapter() {
    }
}
