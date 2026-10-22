package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.EntityCrudOps", f = "EntityCrudOps.kt", l = {36, 38, 42, 43}, m = "save")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntityCrudOps$save$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29861a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29862b;

    /* renamed from: c, reason: collision with root package name */
    public long f29863c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f29864d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ EntityCrudOps f29865e;

    /* renamed from: f, reason: collision with root package name */
    public int f29866f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityCrudOps$save$1(EntityCrudOps entityCrudOps, InterfaceC4014c<? super EntityCrudOps$save$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29865e = entityCrudOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29864d = obj;
        this.f29866f |= Integer.MIN_VALUE;
        return this.f29865e.d(null, null, this);
    }
}
