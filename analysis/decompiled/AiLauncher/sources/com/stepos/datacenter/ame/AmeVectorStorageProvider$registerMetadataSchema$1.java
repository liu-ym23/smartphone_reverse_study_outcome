package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {579}, m = "registerMetadataSchema")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$registerMetadataSchema$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29737a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29738b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29739c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29740d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f29741e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29742f;

    /* renamed from: g, reason: collision with root package name */
    public int f29743g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$registerMetadataSchema$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$registerMetadataSchema$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29742f = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29741e = obj;
        this.f29743g |= Integer.MIN_VALUE;
        return this.f29742f.F(null, this);
    }
}
