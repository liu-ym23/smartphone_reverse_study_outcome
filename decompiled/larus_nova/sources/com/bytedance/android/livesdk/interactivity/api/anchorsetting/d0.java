package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f132852a;

    public d0(int r100) {
        this.f132852a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        if (((Response) r100).statusCode != 0) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = com.bytedance.android.livesdk.sharedpref.b.W0;
        Integer r102 = Integer.valueOf(this.f132852a);
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        return;
    }
}
