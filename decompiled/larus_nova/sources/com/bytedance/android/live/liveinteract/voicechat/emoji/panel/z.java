package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class z<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f80262a;

    public z(s r100) {
        this.f80262a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        r101.printStackTrace();
        s.a r102 = (s.a) this.f80262a.f531633a;
        if (r102 == null) goto L6;
        r102.B4();
        return;
    }
}
