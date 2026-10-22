package com.bytedance.android.live.openplatform.impl.miniappanchor.debug;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniAppAnchorDebugContextService f84365a;

    public e(MiniAppAnchorDebugContextService r100) {
        this.f84365a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        UtilityKotlinExtentionsKt.s(0, false, false, new MiniAppAnchorDebugContextService$checkFastStartLiveInfo$3$1(this), 7);
    }
}
