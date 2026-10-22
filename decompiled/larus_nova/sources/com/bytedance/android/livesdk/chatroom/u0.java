package com.bytedance.android.livesdk.chatroom;

import com.bytedance.android.live.GsonHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f111968a = 0;

    static {
    }

    @JvmStatic
    public static final long[] a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        Object r102 = null;
        if (r101 == false) goto L21;
        return null;
    L21:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl((long[]) GsonHelper.get().fromJson(r100, long[].class));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r104) == true) goto L20;
        r102 = r104;
    L20:
        return (long[]) r102;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }
}
