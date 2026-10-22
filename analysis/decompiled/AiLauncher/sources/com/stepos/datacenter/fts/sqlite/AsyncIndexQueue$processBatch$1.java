package com.stepos.datacenter.fts.sqlite;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.AsyncIndexQueue", f = "AsyncIndexQueue.kt", l = {179}, m = "processBatch")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncIndexQueue$processBatch$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f30047a;

    /* renamed from: b, reason: collision with root package name */
    public Object f30048b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f30049c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AsyncIndexQueue f30050d;

    /* renamed from: e, reason: collision with root package name */
    public int f30051e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncIndexQueue$processBatch$1(AsyncIndexQueue asyncIndexQueue, InterfaceC4014c<? super AsyncIndexQueue$processBatch$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f30050d = asyncIndexQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f30049c = obj;
        this.f30051e |= Integer.MIN_VALUE;
        return this.f30050d.c(null, this);
    }
}
