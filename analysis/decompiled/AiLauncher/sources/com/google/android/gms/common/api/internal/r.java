package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C1660a;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* loaded from: classes2.dex */
public class r {
    @ResultIgnorabilityUnspecified
    public static <ResultT> boolean a(Status status, ResultT resultt, D2.j<ResultT> jVar) {
        return status.isSuccess() ? jVar.e(resultt) : jVar.d(C1660a.a(status));
    }
}
