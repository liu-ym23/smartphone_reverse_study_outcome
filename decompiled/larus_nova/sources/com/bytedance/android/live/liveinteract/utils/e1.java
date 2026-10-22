package com.bytedance.android.live.liveinteract.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f78764a;

    public e1(boolean r100) {
        this.f78764a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = com.bytedance.android.livesdk.sharedpref.c.f158262e1;
        if (this.f78764a == false) goto L5;
        int r103 = 1;
    L6:
        Integer r104 = Integer.valueOf(r103);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r104);
        if (TextUtils.isEmpty(((com.bytedance.android.live.liveinteract.plantform.model.z0) r101.data).a()) == true) goto L10;
        f2.c(((com.bytedance.android.live.liveinteract.plantform.model.z0) r101.data).a(), 0);
    L10:
        if (this.f78764a == false) goto L13;
        com.bytedance.android.live.liveinteract.linkpanel.util.w.d();
        return;
    L13:
        return;
    L5:
        r103 = 2;
        goto L6
    }
}
