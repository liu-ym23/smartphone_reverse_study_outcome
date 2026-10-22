package com.stepos.policy.sdk;

import O.d;
import android.content.Context;
import j4.w;
import m4.InterfaceC0868a;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ p4.h<Object>[] f15772a = {w.e(new j4.q(d.class, "policySdkDataStore", "getPolicySdkDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};

    /* renamed from: b, reason: collision with root package name */
    private static final InterfaceC0868a f15773b = N.a.b("policy_sdk_data", null, null, null, 14, null);

    /* renamed from: c, reason: collision with root package name */
    private static d.a<Boolean> f15774c = O.f.a("policyOperate");

    /* renamed from: d, reason: collision with root package name */
    private static d.a<String> f15775d = O.f.f("policyOperateRequestJson");

    /* renamed from: e, reason: collision with root package name */
    private static d.a<Integer> f15776e = O.f.d("agreeStatus");

    /* renamed from: f, reason: collision with root package name */
    private static d.a<String> f15777f = O.f.f("commonDeleteInfoJson");

    /* renamed from: g, reason: collision with root package name */
    private static d.a<String> f15778g = O.f.f("cloudPolicyUidCategoryMap");

    public static final d.a<Integer> b() {
        return f15776e;
    }

    public static final d.a<String> c() {
        return f15778g;
    }

    public static final d.a<String> d() {
        return f15777f;
    }

    public static final d.a<Boolean> e() {
        return f15774c;
    }

    public static final d.a<String> f() {
        return f15775d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final L.f<O.d> g(Context context) {
        return (L.f) f15773b.a(context, f15772a[0]);
    }
}
