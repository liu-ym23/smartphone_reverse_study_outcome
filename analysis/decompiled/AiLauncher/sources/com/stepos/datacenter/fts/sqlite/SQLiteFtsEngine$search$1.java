package com.stepos.datacenter.fts.sqlite;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.datacenter.fts.sqlite.SQLiteFtsEngine", f = "SQLiteFtsEngine.kt", l = {282}, m = "search")
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SQLiteFtsEngine$search$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f30081a;

    /* renamed from: b, reason: collision with root package name */
    public Object f30082b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f30083c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SQLiteFtsEngine f30084d;

    /* renamed from: e, reason: collision with root package name */
    public int f30085e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SQLiteFtsEngine$search$1(SQLiteFtsEngine sQLiteFtsEngine, InterfaceC4014c<? super SQLiteFtsEngine$search$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.f30084d = sQLiteFtsEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f30083c = obj;
        this.f30085e |= Integer.MIN_VALUE;
        return this.f30084d.v(null, this);
    }
}
