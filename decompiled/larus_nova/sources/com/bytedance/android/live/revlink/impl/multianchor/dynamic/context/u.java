package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevLinkDynamicDataContext$packagePlayStatus$$inlined$also$lambda$1 f94063a;

    public u(RevLinkDynamicDataContext$packagePlayStatus$$inlined$also$lambda$1 r100) {
        this.f94063a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediatorLiveData r101 = this.f94063a.f93930a;
        r101.postValue((JSONObject) r100);
    }
}
