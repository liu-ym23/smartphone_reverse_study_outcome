package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {1027, 958}, m = "collectionPrimaryIndexId")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$collectionPrimaryIndexId$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29663a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29664b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29665c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f29666d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29667e;

    /* renamed from: f, reason: collision with root package name */
    public int f29668f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$collectionPrimaryIndexId$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$collectionPrimaryIndexId$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29667e = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29666d = obj;
        this.f29668f |= Integer.MIN_VALUE;
        return this.f29667e.f(null, this);
    }
}
