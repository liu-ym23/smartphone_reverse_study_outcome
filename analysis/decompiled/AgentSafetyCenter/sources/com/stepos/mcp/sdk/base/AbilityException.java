package com.stepos.mcp.sdk.base;

import yb.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AbilityException extends Exception {
    public /* synthetic */ AbilityException(String str, Throwable th, int i, f fVar) {
        this(str, (i & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbilityException(String str, Throwable th) {
        super(str, th);
        str.getClass();
    }
}
