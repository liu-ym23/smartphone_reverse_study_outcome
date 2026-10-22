package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.android.sdk.bdticketguard.attestation.AttestSignResult;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public interface j1 {
    boolean a();

    c0 b(p r100);

    AttestationResult c();

    String d(String r100, String r101, e0.c r102);

    String e(String r100, String r101, e0.c r102);

    void f(com.bytedance.android.sdk.bdticketguard.data.c r100, Function1<? super AttestSignResult, Unit> r101);

    k g(o r100);

    g h(i r100);

    void i(Function3<? super Result<AttestationResult>, ? super Integer, ? super Boolean, Unit> r100);

    String j(String r100, String r101, e0.c r102);

    l0 k();

    a0 l(b0 r100);

    String m();

    void n(com.bytedance.android.sdk.bdticketguard.data.a r100);

    void o(String r100, String r101);
}
