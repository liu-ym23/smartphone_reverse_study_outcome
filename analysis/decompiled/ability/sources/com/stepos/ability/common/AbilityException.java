package com.stepos.ability.common;

import B7.a;
import O3.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcom/stepos/ability/common/AbilityException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final d f3075a;
    public final String b;

    public AbilityException(d dVar, String str, Exception exc) {
        super(a.n("[", dVar.f1034a, "] ", str == null ? dVar.b : str), exc);
        this.f3075a = dVar;
        this.b = str;
    }
}
