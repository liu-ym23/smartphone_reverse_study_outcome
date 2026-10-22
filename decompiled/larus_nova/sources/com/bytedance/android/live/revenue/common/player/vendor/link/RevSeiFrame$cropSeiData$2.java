package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.android.livesdk.model.n0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/model/n0;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/model/n0;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$cropSeiData$2 extends FunctionReferenceImpl implements Function0<n0> {
    public RevSeiFrame$cropSeiData$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseCropSeiData", "parseCropSeiData()Lcom/bytedance/android/livesdk/model/RevCropSeiData;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final n0 invoke() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        r100.getClass();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        n0 r104 = r100.s();     // Catch: Throwable -> L9
        if (r104 != null) goto L18;
        n0 r105 = r100.r();     // Catch: Throwable -> L9
        if (r105 != null) goto L20;
        return null;
    L20:
        return r105;
    L18:
        return r104;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L15;
        r102 = r107;
    L15:
        return (n0) r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ n0 invoke() {
        return invoke();
    }
}
