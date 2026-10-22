package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {592, 593}, m = "executeWithReconnect")
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$executeWithReconnect$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29686a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29687b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29688c;

    /* renamed from: d, reason: collision with root package name */
    public int f29689d;

    /* renamed from: e, reason: collision with root package name */
    public int f29690e;

    /* renamed from: f, reason: collision with root package name */
    public int f29691f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f29692g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29693h;

    /* renamed from: i, reason: collision with root package name */
    public int f29694i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$executeWithReconnect$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$executeWithReconnect$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29693h = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29692g = obj;
        this.f29694i |= Integer.MIN_VALUE;
        return this.f29693h.A(null, this);
    }
}
