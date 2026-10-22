package com.bytedance.android.live.revenue.common.player.vendor.link;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Integer;"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$isHorizontal$2 extends FunctionReferenceImpl implements Function0<Integer> {
    public RevSeiFrame$isHorizontal$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseIsHorizontal", "parseIsHorizontal()Ljava/lang/Integer;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Integer invoke() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        r100.getClass();
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        if (r100.c() < 0) goto L22;
        int r104 = StringsKt.indexOf$default(r100.C, "is_horizontal", 0, false, 6, null);     // Catch: Throwable -> L13
        if (r104 < 0) goto L23;
        Long r105 = RevSeiFrame.q(r100.C, r104);     // Catch: Throwable -> L13
        if (r105 == null) goto L24;
        return Integer.valueOf((int) r105.longValue());
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L19;
        r102 = r107;
    L19:
        return (Integer) r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return invoke();
    }
}
