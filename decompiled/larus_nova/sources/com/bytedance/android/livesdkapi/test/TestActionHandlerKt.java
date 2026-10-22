package com.bytedance.android.livesdkapi.test;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0006\u001a\"\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0006\u001a\"\u0010\u0007\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\b"}, d2 = {"error", "", "Lkotlin/Function1;", "Lcom/bytedance/android/livesdkapi/test/HandleResult;", "msg", "", "", "success", "livesdkapi-middleware_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class TestActionHandlerKt {
    public static final void error(Function1<? super HandleResult, Unit> r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$error");
        r100.invoke(HandleResult.Companion.error(r101));
    }

    public static final void success(Function1<? super HandleResult, Unit> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$success");
        r100.invoke(HandleResult.Companion.success(r101));
    }

    public static final void error(Function1<? super HandleResult, Unit> r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$error");
        r100.invoke(HandleResult.Companion.error(r101, r102));
    }

    public static /* synthetic */ void error$default(Function1 r100, Throwable r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        error(r100, r101);
    }

    public static /* synthetic */ void success$default(Function1 r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = null;
    L5:
        success(r100, r101);
    }

    public static /* synthetic */ void error$default(Function1 r100, String r101, Throwable r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        error(r100, r101, r102);
    }
}
