package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.CollectionOps", f = "CollectionOps.kt", l = {30}, m = "create")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CollectionOps$create$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29810a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29811b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29812c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CollectionOps f29813d;

    /* renamed from: e, reason: collision with root package name */
    public int f29814e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionOps$create$1(CollectionOps collectionOps, InterfaceC4014c<? super CollectionOps$create$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29813d = collectionOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29812c = obj;
        this.f29814e |= Integer.MIN_VALUE;
        return this.f29813d.a(null, this);
    }
}
