package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {1027, 932, 1037, 943}, m = "collectionVectorCount")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$collectionVectorCount$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29672a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29673b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29674c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f29675d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29676e;

    /* renamed from: f, reason: collision with root package name */
    public int f29677f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$collectionVectorCount$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$collectionVectorCount$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29676e = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29675d = obj;
        this.f29677f |= Integer.MIN_VALUE;
        return this.f29676e.h(null, this);
    }
}
