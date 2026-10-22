package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.common.internal.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1663d {

    /* renamed from: a, reason: collision with root package name */
    public final Account f19805a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f19806b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f19807c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f19808d;

    /* renamed from: e, reason: collision with root package name */
    public final int f19809e;

    /* renamed from: f, reason: collision with root package name */
    public final View f19810f;

    /* renamed from: g, reason: collision with root package name */
    public final String f19811g;

    /* renamed from: h, reason: collision with root package name */
    public final String f19812h;

    /* renamed from: i, reason: collision with root package name */
    public final C2.a f19813i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f19814j;

    /* renamed from: com.google.android.gms.common.internal.d$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Account f19815a;

        /* renamed from: b, reason: collision with root package name */
        public androidx.collection.b f19816b;

        /* renamed from: c, reason: collision with root package name */
        public String f19817c;

        /* renamed from: d, reason: collision with root package name */
        public String f19818d;

        /* renamed from: e, reason: collision with root package name */
        public final C2.a f19819e = C2.a.f1683j;

        public C1663d a() {
            return new C1663d(this.f19815a, this.f19816b, null, 0, null, this.f19817c, this.f19818d, this.f19819e, false);
        }

        public a b(String str) {
            this.f19817c = str;
            return this;
        }

        public final a c(Collection collection) {
            if (this.f19816b == null) {
                this.f19816b = new androidx.collection.b();
            }
            this.f19816b.addAll(collection);
            return this;
        }

        public final a d(Account account) {
            this.f19815a = account;
            return this;
        }

        public final a e(String str) {
            this.f19818d = str;
            return this;
        }
    }

    public C1663d(Account account, Set set, Map map, int i10, View view, String str, String str2, C2.a aVar, boolean z10) {
        this.f19805a = account;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f19806b = setUnmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f19808d = map;
        this.f19810f = view;
        this.f19809e = i10;
        this.f19811g = str;
        this.f19812h = str2;
        this.f19813i = aVar == null ? C2.a.f1683j : aVar;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(((C1677s) it.next()).f19841a);
        }
        this.f19807c = Collections.unmodifiableSet(hashSet);
    }

    public Account a() {
        return this.f19805a;
    }

    public Account b() {
        Account account = this.f19805a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public Set<Scope> c() {
        return this.f19807c;
    }

    public String d() {
        return this.f19811g;
    }

    public Set<Scope> e() {
        return this.f19806b;
    }

    public final C2.a f() {
        return this.f19813i;
    }

    public final Integer g() {
        return this.f19814j;
    }

    public final String h() {
        return this.f19812h;
    }

    public final void i(Integer num) {
        this.f19814j = num;
    }
}
