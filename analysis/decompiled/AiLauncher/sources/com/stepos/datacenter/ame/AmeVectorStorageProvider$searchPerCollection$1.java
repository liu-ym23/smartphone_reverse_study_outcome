package com.stepos.datacenter.ame;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.ame.AmeVectorStorageProvider", f = "AmeVectorStorageProvider.kt", l = {1028, 457}, m = "searchPerCollection")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AmeVectorStorageProvider$searchPerCollection$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29758a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29759b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29760c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29761d;

    /* renamed from: e, reason: collision with root package name */
    public Object f29762e;

    /* renamed from: f, reason: collision with root package name */
    public int f29763f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f29764g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AmeVectorStorageProvider f29765h;

    /* renamed from: i, reason: collision with root package name */
    public int f29766i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmeVectorStorageProvider$searchPerCollection$1(AmeVectorStorageProvider ameVectorStorageProvider, InterfaceC4014c<? super AmeVectorStorageProvider$searchPerCollection$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29765h = ameVectorStorageProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29764g = obj;
        this.f29766i |= Integer.MIN_VALUE;
        return this.f29765h.J(null, null, 0, null, this);
    }
}
