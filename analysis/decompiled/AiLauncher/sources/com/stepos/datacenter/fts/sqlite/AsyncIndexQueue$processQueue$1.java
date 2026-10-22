package com.stepos.datacenter.fts.sqlite;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.AsyncIndexQueue", f = "AsyncIndexQueue.kt", l = {152, 157, 164}, m = "processQueue")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncIndexQueue$processQueue$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f30052a;

    /* renamed from: b, reason: collision with root package name */
    public Object f30053b;

    /* renamed from: c, reason: collision with root package name */
    public Object f30054c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f30055d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AsyncIndexQueue f30056e;

    /* renamed from: f, reason: collision with root package name */
    public int f30057f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncIndexQueue$processQueue$1(AsyncIndexQueue asyncIndexQueue, InterfaceC4014c<? super AsyncIndexQueue$processQueue$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f30056e = asyncIndexQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f30055d = obj;
        this.f30057f |= Integer.MIN_VALUE;
        return this.f30056e.d(this);
    }
}
