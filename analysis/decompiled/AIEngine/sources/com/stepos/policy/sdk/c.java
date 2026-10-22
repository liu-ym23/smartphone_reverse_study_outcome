package com.stepos.policy.sdk;

import android.content.Context;
import ec.f;
import g1.a;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ f<Object>[] f7964a;

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.datastore.preferences.b f7965b;

    /* renamed from: c, reason: collision with root package name */
    public static final a.C0083a<Boolean> f7966c;

    /* renamed from: d, reason: collision with root package name */
    public static final a.C0083a<String> f7967d;

    /* renamed from: e, reason: collision with root package name */
    public static final a.C0083a<Integer> f7968e;

    /* renamed from: f, reason: collision with root package name */
    public static final a.C0083a<String> f7969f;

    /* renamed from: g, reason: collision with root package name */
    public static final a.C0083a<String> f7970g;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(c.class, "policySdkDataStore", "getPolicySdkDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        i.f10086a.getClass();
        f7964a = new f[]{propertyReference1Impl};
        f7965b = androidx.datastore.preferences.a.a();
        f7966c = new a.C0083a<>("policyOperate");
        f7967d = a4.a.v("policyOperateRequestJson");
        f7968e = new a.C0083a<>("agreeStatus");
        f7969f = a4.a.v("commonDeleteInfoJson");
        f7970g = a4.a.v("cloudPolicyUidCategoryMap");
    }

    public static final d1.c a(Context context) {
        return f7965b.a(context, f7964a[0]);
    }
}
