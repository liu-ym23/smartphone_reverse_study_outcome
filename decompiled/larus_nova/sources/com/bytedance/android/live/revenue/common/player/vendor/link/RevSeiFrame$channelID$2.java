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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Long;"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class RevSeiFrame$channelID$2 extends FunctionReferenceImpl implements Function0<Long> {
    public RevSeiFrame$channelID$2(RevSeiFrame r100) {
        super(0, r100, RevSeiFrame.class, "parseChannelIDByString", "parseChannelIDByString()Ljava/lang/Long;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        RevSeiFrame r100 = (RevSeiFrame) this.receiver;
        Lazy r101 = RevSeiFrame.D;
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        int r103 = r100.c();     // Catch: Throwable -> L11
        if (r103 >= 0) goto L6;
        long r104 = -1L;     // Catch: Throwable -> L11
    L17:
        return r104;
    L6:
        int r105 = StringsKt.indexOf$default(r100.C, "channel_id", r103, false, 4, null);     // Catch: Throwable -> L11
        if (r105 >= 0) goto L9;
        r104 = -1L;     // Catch: Throwable -> L11
        goto L17
    L9:
        r104 = RevSeiFrame.q(r100.C, r105);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == false) goto L20;
        r107 = null;
    L20:
        return (Long) r107;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return invoke();
    }
}
