package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.android.ec.ab.opt.OptSetting;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes43.dex */
@OptSetting(business = "VmSdk setting")
public final class VmSdkSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45762a = null;

    public static final c a() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        cl.d r102 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L8
        if (r102 == null) goto L6;
        r102.g();     // Catch: Throwable -> L8
    L6:
        Object r103 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == true) goto L14;
        r100 = r103;
    L14:
        c r104 = (c) r100;
        if (r104 == null) goto L17;
        return r104;
    L17:
        return (c) f45762a.getValue();
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    static {
        f45762a = LazyKt.lazy(VmSdkSetting$config$2.INSTANCE);
    }
}
