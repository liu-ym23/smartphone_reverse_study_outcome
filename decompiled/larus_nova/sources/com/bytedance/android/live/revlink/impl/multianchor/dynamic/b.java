package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1 f93896a;

    public b(DynamicUtilsKt$packagePlayStatus$$inlined$also$lambda$1 r100) {
        this.f93896a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediatorLiveData r101 = this.f93896a.f93848a;
        r101.postValue((JSONObject) r100);
    }
}
