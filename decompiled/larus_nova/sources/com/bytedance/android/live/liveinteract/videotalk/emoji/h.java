package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f79355a;

    public h(d r100) {
        this.f79355a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        r101.printStackTrace();
        d.a r102 = (d.a) this.f79355a.f531633a;
        if (r102 == null) goto L6;
        r102.B4();
        return;
    }
}
