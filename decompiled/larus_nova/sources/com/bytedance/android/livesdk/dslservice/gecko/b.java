package com.bytedance.android.livesdk.dslservice.gecko;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function3<File, Boolean, String, Unit> f122832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Throwable, Unit> f122833b;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function3<? super File, ? super Boolean, ? super String, Unit> r100, Function1<? super Throwable, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "onSuccess");
        Intrinsics.checkNotNullParameter(r101, LynxVideoManagerLite.EVENT_ON_ERROR);
        this.f122832a = r100;
        this.f122833b = r101;
    }
}
