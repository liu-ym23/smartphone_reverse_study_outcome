package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.EntityCrudOps", f = "EntityCrudOps.kt", l = {95}, m = "saveAll")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntityCrudOps$saveAll$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29867a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29868b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29869c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29870d;

    /* renamed from: e, reason: collision with root package name */
    public Object f29871e;

    /* renamed from: f, reason: collision with root package name */
    public Object f29872f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f29873g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ EntityCrudOps f29874h;

    /* renamed from: i, reason: collision with root package name */
    public int f29875i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityCrudOps$saveAll$1(EntityCrudOps entityCrudOps, InterfaceC4014c<? super EntityCrudOps$saveAll$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29874h = entityCrudOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29873g = obj;
        this.f29875i |= Integer.MIN_VALUE;
        return this.f29874h.e(null, null, this);
    }
}
