package com.stepos.base.strategy;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OrchestrationRejectedException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f6394a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6395b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrchestrationRejectedException(int i10, String message) {
        super(message);
        g.f(message, "message");
        this.f6394a = i10;
        this.f6395b = message;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f6395b;
    }
}
