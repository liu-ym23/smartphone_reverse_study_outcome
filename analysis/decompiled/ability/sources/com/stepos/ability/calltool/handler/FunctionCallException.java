package com.stepos.ability.calltool.handler;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/stepos/ability/calltool/handler/FunctionCallException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "calltool_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class FunctionCallException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final int f3068a;
    public final String b;

    public FunctionCallException(int i, String str) {
        super("AppFunctions Exception");
        this.f3068a = i;
        this.b = str;
    }
}
