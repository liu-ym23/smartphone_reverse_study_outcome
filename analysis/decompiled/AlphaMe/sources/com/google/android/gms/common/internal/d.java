package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import j1.C0633a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final Account f9795a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f9796b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f9797c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f9798d;

    /* renamed from: e, reason: collision with root package name */
    public final View f9799e;

    /* renamed from: f, reason: collision with root package name */
    public final String f9800f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9801g;

    /* renamed from: h, reason: collision with root package name */
    public final C0633a f9802h;

    /* renamed from: i, reason: collision with root package name */
    public Integer f9803i;

    public d(Account account, q.g gVar, String str, String str2, C0633a c0633a) {
        this.f9795a = account;
        Set setEmptySet = gVar == null ? Collections.emptySet() : Collections.unmodifiableSet(gVar);
        this.f9796b = setEmptySet;
        Map mapEmptyMap = Collections.emptyMap();
        this.f9798d = mapEmptyMap;
        this.f9800f = str;
        this.f9801g = str2;
        this.f9802h = c0633a == null ? C0633a.f13129a : c0633a;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = mapEmptyMap.values().iterator();
        if (it.hasNext()) {
            B0.g.y(it.next());
            throw null;
        }
        this.f9797c = Collections.unmodifiableSet(hashSet);
    }
}
