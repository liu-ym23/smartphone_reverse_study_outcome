package com.stepos.ability.calltool.handler;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/stepos/ability/calltool/handler/JetpackFunctionCallException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "calltool_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class JetpackFunctionCallException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f3071a;
    public final String b;

    public JetpackFunctionCallException(int i, String str) {
        super("Jetpack AppFunctions business failure");
        this.f3071a = i;
        this.b = str;
    }
}
