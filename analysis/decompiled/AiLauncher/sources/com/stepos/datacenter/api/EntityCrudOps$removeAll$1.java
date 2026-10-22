package com.stepos.datacenter.api;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.api.EntityCrudOps", f = "EntityCrudOps.kt", l = {104}, m = "removeAll")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EntityCrudOps$removeAll$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f29854a;

    /* renamed from: b, reason: collision with root package name */
    public Object f29855b;

    /* renamed from: c, reason: collision with root package name */
    public Object f29856c;

    /* renamed from: d, reason: collision with root package name */
    public Object f29857d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f29858e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ EntityCrudOps f29859f;

    /* renamed from: g, reason: collision with root package name */
    public int f29860g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EntityCrudOps$removeAll$1(EntityCrudOps entityCrudOps, InterfaceC4014c<? super EntityCrudOps$removeAll$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f29859f = entityCrudOps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f29858e = obj;
        this.f29860g |= Integer.MIN_VALUE;
        return this.f29859f.c(null, null, this);
    }
}
