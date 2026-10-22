package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.EntityCrudOps", f = "EntityCrudOps.kt", l = {70, 73, 79, 86}, m = "remove")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntityCrudOps$remove$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29849a;

    /* renamed from: b, reason: collision with root package name */
    public long f29850b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f29851c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EntityCrudOps f29852d;

    /* renamed from: e, reason: collision with root package name */
    public int f29853e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityCrudOps$remove$1(EntityCrudOps entityCrudOps, InterfaceC4014c<? super EntityCrudOps$remove$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29852d = entityCrudOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29851c = obj;
        this.f29853e |= Integer.MIN_VALUE;
        return this.f29852d.b(null, null, this);
    }
}
