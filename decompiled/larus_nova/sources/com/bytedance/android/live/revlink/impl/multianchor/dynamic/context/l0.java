package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes47.dex */
public final class l0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1 f94034a;

    public l0(RevLinkOldDynamicDataContextKt$transformLinkAnchorInfo$$inlined$also$lambda$1 r100) {
        this.f94034a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediatorLiveData r101 = this.f94034a.f93941a;
        r101.postValue((JSONArray) r100);
    }
}
