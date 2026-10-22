package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedPkBridgePresenter f96452a;

    public a(FeedPkBridgePresenter r100) {
        this.f96452a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        String r102 = this.f96452a.f96449m.getValue();
        if (r102 == null) goto L5;
        CastLongProtector.parseLong(r102);
    L5:
        MutableLiveData<String> r103 = this.f96452a.f96449m;
        long r104 = System.currentTimeMillis();
        String r105 = this.f96452a.f96448l.getValue();
        if (r105 == null) goto L8;
        long r106 = CastLongProtector.parseLong(r105);
    L9:
        r103.setValue(String.valueOf((r104 - r106) / ((long) 1000)));
        return;
    L8:
        r106 = 0;
        goto L9
    }
}
