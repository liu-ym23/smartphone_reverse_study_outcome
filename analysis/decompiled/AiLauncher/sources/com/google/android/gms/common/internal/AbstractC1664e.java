package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.InterfaceC1639e;
import com.google.android.gms.common.api.internal.InterfaceC1646l;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.common.internal.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1664e<T extends IInterface> extends AbstractC1662c<T> implements a.f {

    /* renamed from: F, reason: collision with root package name */
    public final C1663d f19820F;

    /* renamed from: G, reason: collision with root package name */
    public final Set f19821G;

    /* renamed from: H, reason: collision with root package name */
    public final Account f19822H;

    @Deprecated
    public AbstractC1664e(Context context, Looper looper, int i10, C1663d c1663d, d.a aVar, d.b bVar) {
        this(context, looper, i10, c1663d, (InterfaceC1639e) aVar, (InterfaceC1646l) bVar);
    }

    public Set<Scope> f0(Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> g() {
        return f() ? this.f19821G : Collections.EMPTY_SET;
    }

    public final Set g0(Set set) {
        Set<Scope> setF0 = f0(set);
        Iterator<Scope> it = setF0.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setF0;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final Account r() {
        return this.f19822H;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public Executor t() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final Set<Scope> z() {
        return this.f19821G;
    }

    public AbstractC1664e(Context context, Looper looper, int i10, C1663d c1663d, InterfaceC1639e interfaceC1639e, InterfaceC1646l interfaceC1646l) {
        this(context, looper, AbstractC1665f.b(context), com.google.android.gms.common.b.m(), i10, c1663d, (InterfaceC1639e) C1669j.k(interfaceC1639e), (InterfaceC1646l) C1669j.k(interfaceC1646l));
    }

    public AbstractC1664e(Context context, Looper looper, AbstractC1665f abstractC1665f, com.google.android.gms.common.b bVar, int i10, C1663d c1663d, InterfaceC1639e interfaceC1639e, InterfaceC1646l interfaceC1646l) {
        super(context, looper, abstractC1665f, bVar, i10, interfaceC1639e == null ? null : new C1682x(interfaceC1639e), interfaceC1646l != null ? new C1683y(interfaceC1646l) : null, c1663d.h());
        this.f19820F = c1663d;
        this.f19822H = c1663d.a();
        this.f19821G = g0(c1663d.c());
    }
}
