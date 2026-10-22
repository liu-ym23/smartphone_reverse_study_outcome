package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {1027, 171}, m = "storePerCollection")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$storePerCollection$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29784a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29785b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29786c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f29787d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29788e;

    /* renamed from: f, reason: collision with root package name */
    public int f29789f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$storePerCollection$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$storePerCollection$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29788e = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29787d = obj;
        this.f29789f |= Integer.MIN_VALUE;
        return this.f29788e.L(null, this);
    }
}
