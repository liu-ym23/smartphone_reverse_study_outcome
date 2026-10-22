package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes47.dex */
public final class v0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1 f94066a;

    public v0(RevNewDynamicFeedDataContext$transformLinkAnchorInfo$$inlined$also$lambda$1 r100) {
        this.f94066a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediatorLiveData r101 = this.f94066a.f93947a;
        r101.postValue((JSONArray) r100);
    }
}
