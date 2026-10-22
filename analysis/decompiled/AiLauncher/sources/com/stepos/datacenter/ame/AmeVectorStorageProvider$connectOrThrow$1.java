package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {560}, m = "connectOrThrow")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$connectOrThrow$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f29683a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29684b;

    /* renamed from: c, reason: collision with root package name */
    public int f29685c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$connectOrThrow$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$connectOrThrow$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29684b = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29683a = obj;
        this.f29685c |= Integer.MIN_VALUE;
        return this.f29684b.z(this);
    }
}
