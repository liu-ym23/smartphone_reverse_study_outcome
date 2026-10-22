package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f132844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.chatroom.model.b f132845b;

    public a(String r100, com.bytedance.android.livesdk.chatroom.model.b r101) {
        this.f132844a = r100;
        this.f132845b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        com.bytedance.android.livesdk.interactivity.api.asr.utils.c.c("update switch status success. " + this.f132844a);
        com.bytedance.android.livesdk.chatroom.model.b r102 = this.f132845b;
        if (r102 != null) goto L5;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = com.bytedance.android.livesdk.interactivity.api.asr.utils.e.f132883a;
        com.bytedance.android.livesdk.chatroom.model.b r104 = new com.bytedance.android.livesdk.chatroom.model.b();
    L6:
        com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.chatroom.model.b> r105 = com.bytedance.android.livesdk.interactivity.api.asr.utils.e.f132884b;
        if ((!Intrinsics.areEqual(r105.getValue(), r104)) == false) goto L10;
        com.bytedance.android.livesdk.sharedpref.f.d(r105, r102);
        xs2.b.a().post(com.bytedance.android.livesdk.interactivity.api.asr.utils.e.a());
        return;
    L10:
        return;
    L5:
        r104 = r102;
        goto L6
    }
}
