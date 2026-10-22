package com.bytedance.android.live.liveinteract.widget.widget;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.liveinteract.plantform.model.h0;
import com.lynx.tasm.LynxError;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoFriendPairDialog f81050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h0 f81051b;

    public d0(VideoFriendPairDialog r100, h0 r101) {
        this.f81050a = r100;
        this.f81051b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
        ExceptionUtils.handleException(this.f81050a.getContext(), r101);
    }
}
