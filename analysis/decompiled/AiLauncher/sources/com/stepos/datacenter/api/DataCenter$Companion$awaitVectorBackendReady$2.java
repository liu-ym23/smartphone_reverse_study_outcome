package com.stepos.datacenter.api;

import com.stepos.datacenter.api.DataCenter;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.DataCenter$Companion", f = "DataCenter.kt", l = {124}, m = "awaitVectorBackendReady")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCenter$Companion$awaitVectorBackendReady$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f29820a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataCenter.Companion f29821b;

    /* renamed from: c, reason: collision with root package name */
    public int f29822c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataCenter$Companion$awaitVectorBackendReady$2(DataCenter.Companion companion, InterfaceC4014c<? super DataCenter$Companion$awaitVectorBackendReady$2> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29821b = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29820a = obj;
        this.f29822c |= Integer.MIN_VALUE;
        return this.f29821b.awaitVectorBackendReady(0L, this);
    }
}
