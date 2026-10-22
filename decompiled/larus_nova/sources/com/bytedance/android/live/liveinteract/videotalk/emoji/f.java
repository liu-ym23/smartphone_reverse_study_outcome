package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f79353a;

    public f(d r100) {
        this.f79353a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        r101.printStackTrace();
        d.a r102 = (d.a) this.f79353a.f531633a;
        if (r102 == null) goto L6;
        r102.G3(r101);
        return;
    }
}
