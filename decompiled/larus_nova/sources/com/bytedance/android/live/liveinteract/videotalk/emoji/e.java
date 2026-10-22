package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.plantform.model.ContributeShowResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f79351a;

    public e(d r100) {
        this.f79351a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ContributeShowResponse.ResponseData r101 = ((ContributeShowResponse) r100).getData();
        if (r101 == null) goto L10;
        ContributeShowResponse.OwnerHonorInfo r102 = r101.getOwnerHonorInfo();
        if (r102 == null) goto L11;
        d.a r103 = (d.a) this.f79351a.f531633a;
        if (r103 == null) goto L12;
        r103.ta(r102);
        return;
    L12:
        return;
    L11:
        return;
    }
}
