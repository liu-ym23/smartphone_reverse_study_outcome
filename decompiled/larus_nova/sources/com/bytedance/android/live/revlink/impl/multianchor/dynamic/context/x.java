package com.bytedance.android.live.revlink.impl.multianchor.dynamic.context;

import androidx.lifecycle.MediatorLiveData;
import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes47.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1 f94069a;

    public x(RevLinkDynamicDataContext$transformAIAnchorList$$inlined$also$lambda$1 r100) {
        this.f94069a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MediatorLiveData r101 = this.f94069a.f93933a;
        r101.postValue((JSONArray) r100);
    }
}
