package com.bytedance.android.ec.core.arch.state;

import androidx.lifecycle.MediatorLiveData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/ec/core/arch/state/LivedataKt$transformationsDistinctUntilChanged$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivedataKt$transformationsDistinctUntilChanged$1 implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f43857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f43858b;

    public LivedataKt$transformationsDistinctUntilChanged$1(MediatorLiveData r100) {
        this.f43858b = r100;
        this.f43857a = true;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        T r101 = this.f43858b.getValue();
        if (this.f43857a == true) goto L9;
        if (r101 != 0) goto L6;
        if (r100 != null) goto L9;
    L6:
        if (r101 != 0) goto L8;
        return;
    L8:
        if ((!Intrinsics.areEqual(r101, r100)) == true) goto L9;
        return;
    L9:
        this.f43857a = false;
        this.f43858b.setValue(r100);
    }
}
