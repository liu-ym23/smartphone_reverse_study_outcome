package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.x70;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMatrixLoader f116470a;

    public c(LiveMatrixLoader r100) {
        this.f116470a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Response r101 = (Response) r100;
        Intrinsics.checkNotNullParameter(r101, "response");
        LiveMatrixLoader r102 = this.f116470a;
        if (x70.f121581a.getValue().booleanValue() == false) goto L5;
        boolean r103 = ((com.bytedance.android.livesdk.livematrix.a) r101.data).a();
    L6:
        r102.f116420i = r103;
        return;
    L5:
        r103 = false;
        goto L6
    }
}
