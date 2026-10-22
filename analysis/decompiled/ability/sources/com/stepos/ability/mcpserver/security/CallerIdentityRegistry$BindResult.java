package com.stepos.ability.mcpserver.security;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/stepos/ability/mcpserver/security/CallerIdentityRegistry$BindResult", "", "Lcom/stepos/ability/mcpserver/security/CallerIdentityRegistry$BindResult;", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallerIdentityRegistry$BindResult {

    /* renamed from: a, reason: collision with root package name */
    public static final CallerIdentityRegistry$BindResult f3201a;
    public static final CallerIdentityRegistry$BindResult b;
    public static final /* synthetic */ CallerIdentityRegistry$BindResult[] c;

    static {
        CallerIdentityRegistry$BindResult callerIdentityRegistry$BindResult = new CallerIdentityRegistry$BindResult("NEW", 0);
        f3201a = callerIdentityRegistry$BindResult;
        CallerIdentityRegistry$BindResult callerIdentityRegistry$BindResult2 = new CallerIdentityRegistry$BindResult("UNCHANGED", 1);
        CallerIdentityRegistry$BindResult callerIdentityRegistry$BindResult3 = new CallerIdentityRegistry$BindResult("REBOUND", 2);
        b = callerIdentityRegistry$BindResult3;
        CallerIdentityRegistry$BindResult[] callerIdentityRegistry$BindResultArr = {callerIdentityRegistry$BindResult, callerIdentityRegistry$BindResult2, callerIdentityRegistry$BindResult3};
        c = callerIdentityRegistry$BindResultArr;
        kotlin.enums.a.a(callerIdentityRegistry$BindResultArr);
    }

    public static CallerIdentityRegistry$BindResult valueOf(String str) {
        return (CallerIdentityRegistry$BindResult) Enum.valueOf(CallerIdentityRegistry$BindResult.class, str);
    }

    public static CallerIdentityRegistry$BindResult[] values() {
        return (CallerIdentityRegistry$BindResult[]) c.clone();
    }
}
