package com.baidu.a;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private EnumC0004b f4634a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4635b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f4636c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<String> f4637d;

    public enum a {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* renamed from: com.baidu.a.b$b, reason: collision with other inner class name */
    public enum EnumC0004b {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public b(a aVar) {
        this.f4634a = EnumC0004b.RESOLVE_NONE;
        this.f4635b = aVar;
    }

    public EnumC0004b a() {
        return this.f4634a;
    }

    public a b() {
        return this.f4635b;
    }

    public ArrayList<String> c() {
        return this.f4636c;
    }

    public ArrayList<String> d() {
        return this.f4637d;
    }

    public b(EnumC0004b enumC0004b, a aVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        EnumC0004b enumC0004b2 = EnumC0004b.RESOLVE_NONE;
        this.f4634a = enumC0004b;
        this.f4635b = aVar;
        this.f4636c = arrayList;
        this.f4637d = arrayList2;
    }
}
