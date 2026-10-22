package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class t0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 f94062a;

    public t0(RevNewDynamicFeedDataContext$packagePlayStatus$$inlined$also$lambda$1 r100) {
        this.f94062a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediatorLiveData r101 = this.f94062a.f93945a;
        r101.postValue((JSONObject) r100);
    }
}
