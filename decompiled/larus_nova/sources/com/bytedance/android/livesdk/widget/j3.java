package com.bytedance.android.livesdk.widget;

import io.reactivex.functions.Function;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class j3<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f161777a = null;

    static {
        f161777a = new j3();
    }

    public j3() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "e");
        if ((r101 instanceof Break) == false) goto L5;
        r101.getMessage();
    L7:
        return Unit.INSTANCE;
    L5:
        StringWriter r102 = new StringWriter();
        r101.printStackTrace(new PrintWriter(r102));
        r102.toString();
        goto L7
    }
}
