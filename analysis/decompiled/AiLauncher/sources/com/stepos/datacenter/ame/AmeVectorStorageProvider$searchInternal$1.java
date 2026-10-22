package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {1027, 526}, m = "searchInternal")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$searchInternal$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29744a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29745b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29746c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29747d;

    /* renamed from: e, reason: collision with root package name */
    public int f29748e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f29749f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29750g;

    /* renamed from: h, reason: collision with root package name */
    public int f29751h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$searchInternal$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$searchInternal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29750g = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29749f = obj;
        this.f29751h |= Integer.MIN_VALUE;
        return this.f29750g.I(null, 0, null, this);
    }
}
