package com.bytedance.android.livesdk.utils;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes11.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f159176a = 0;

    static {
    }

    public static long a(String r100) {
        if (r100 == null) goto L11;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        return CastLongProtector.parseLong(r100);
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return 0;
    L11:
        return 0;
    }
}
