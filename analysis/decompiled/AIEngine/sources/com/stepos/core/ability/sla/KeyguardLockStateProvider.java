package com.stepos.core.ability.sla;

import android.app.KeyguardManager;
import android.content.Context;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import l7.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class KeyguardLockStateProvider implements LockStateProvider {
    @Override // com.stepos.core.ability.sla.LockStateProvider
    public boolean isKeyguardLocked() {
        Object objA;
        Context context;
        try {
            context = a.f10344a;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (context == null) {
            throw new IllegalStateException("ContextHolder must be initialized before use!");
        }
        Object systemService = context.getSystemService("keyguard");
        g.d(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        objA = Boolean.valueOf(((KeyguardManager) systemService).isKeyguardLocked());
        Object obj = Boolean.FALSE;
        if (objA instanceof Result.Failure) {
            objA = obj;
        }
        return ((Boolean) objA).booleanValue();
    }
}
