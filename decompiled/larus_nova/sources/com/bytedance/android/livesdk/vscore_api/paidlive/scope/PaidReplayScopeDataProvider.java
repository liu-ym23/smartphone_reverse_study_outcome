package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes11.dex */
public abstract class PaidReplayScopeDataProvider implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f159483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f159484b;

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.c
    public final com.bytedance.android.livesdk.vscore_api.paidlive.d getRoomContext() {
        return null;
    }

    public PaidReplayScopeDataProvider() {
        this.f159483a = PaidReplayScopeDataProvider$paidLiveBusiness$1.INSTANCE;
        this.f159484b = PaidReplayScopeDataProvider$playerClient$1.INSTANCE;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.c
    public final Function0 a() {
        return this.f159484b;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.scope.c
    public final Function0 f() {
        return this.f159483a;
    }
}
