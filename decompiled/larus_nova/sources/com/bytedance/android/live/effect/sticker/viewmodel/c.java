package com.bytedance.android.live.effect.sticker.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c<T, R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<T, MutableLiveData<R>> f68821a;

    public c() {
        this.f68821a = new LinkedHashMap();
    }

    public final R a(T r100) {
        MutableLiveData r101 = (MutableLiveData) ((LinkedHashMap) this.f68821a).get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getValue();
    }

    public final void update(T r100, R r101) {
        MutableLiveData r102 = (MutableLiveData) ((LinkedHashMap) this.f68821a).get(r100);
        if (r102 == null) goto L6;
        r102.setValue(r101);
        return;
    }

    public final void b(T r100, LifecycleOwner r101, Observer<R> r102) {
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (this.f68821a.containsKey(r100) == true) goto L5;
        this.f68821a.put(r100, new MutableLiveData());
    L5:
        MutableLiveData r103 = (MutableLiveData) ((LinkedHashMap) this.f68821a).get(r100);
        if (r103 == null) goto L9;
        r103.observe(r101, r102);
        return;
    }
}
