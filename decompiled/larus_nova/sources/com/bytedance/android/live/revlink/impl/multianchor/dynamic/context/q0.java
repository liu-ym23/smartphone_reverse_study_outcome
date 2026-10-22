package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class q0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f94055a;

    public q0(o0 r100) {
        this.f94055a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MutableLiveData<JSONObject> r101 = this.f94055a.f94041c;
        r101.postValue((JSONObject) r100);
    }
}
