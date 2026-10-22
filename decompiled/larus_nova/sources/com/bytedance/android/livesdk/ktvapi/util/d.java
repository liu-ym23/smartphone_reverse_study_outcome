package com.bytedance.android.livesdk.ktvapi.util;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.bytedance.android.livesdk.utils.s3;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static final <T> void b(MutableLiveData<T> r100, Function1<? super T, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setState");
        Intrinsics.checkNotNullParameter(r101, "reducer");
        T r102 = r100.getValue();
        if (r102 == null) goto L5;
        T r103 = r101.invoke(r102);
    L6:
        r100.setValue(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void a(MutableLiveData r100, LifecycleOwner r101, KProperty1 r102, Observer r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$observeState");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "prop1");
        Intrinsics.checkNotNullParameter(r103, "action");
        Intrinsics.checkNotNullParameter(r100, "$this$getLiveDateTCompat");
        Intrinsics.checkNotNullParameter(r102, "prop1");
        LiveData r104 = Transformations.map(r100, new s3(r102));
        Intrinsics.checkNotNullParameter(r104, "$this$distinctUntilChanged");
        MediatorLiveData r105 = new MediatorLiveData();
        r105.addSource(r104, new c(r105));
        r105.observe(r101, r103);
    }
}
