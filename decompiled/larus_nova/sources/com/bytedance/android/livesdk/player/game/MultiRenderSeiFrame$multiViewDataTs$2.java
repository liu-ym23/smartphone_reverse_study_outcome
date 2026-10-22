package com.bytedance.android.livesdk.player.game;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class MultiRenderSeiFrame$multiViewDataTs$2 extends FunctionReferenceImpl implements Function0<Long> {
    public MultiRenderSeiFrame$multiViewDataTs$2(MultiRenderSeiFrame r100) {
        super(0, r100, MultiRenderSeiFrame.class, "parseTs", "parseTs()J", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        MultiRenderSeiFrame r100 = (MultiRenderSeiFrame) this.receiver;
        Lazy r101 = MultiRenderSeiFrame.f155378h;
        r100.getClass();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        String r103 = (String) r100.f155383c.getValue();     // Catch: Throwable -> L21
        if (r103 == null) goto L33;
        int r104 = StringsKt.indexOf$default(r103, "timestamp", 0, false, 6, null);     // Catch: Throwable -> L21
        if (r104 < 0) goto L34;
        int r105 = r103.length();     // Catch: Throwable -> L21
    L10:
        if (r104 >= r105) goto L14;
        if (Character.isDigit(r103.charAt(r104)) == true) goto L14;
        r104 = r104 + 1;     // Catch: Throwable -> L21
    L14:
        long r106 = 0;
    L15:
        if (r104 >= r105) goto L35;
        if (Character.isDigit(r103.charAt(r104)) == false) goto L35;
        r106 = (r106 * ((long) 10)) + ((long) (r103.charAt(r104) - '0'));
        r104 = r104 + 1;
    L35:
        return r106;
    L34:
        return 0;
    L33:
        return 0;
    L21:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r108) == false) goto L26;
        r108 = 0L;
    L26:
        return ((Number) r108).longValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }
}
