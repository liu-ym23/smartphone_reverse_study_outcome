package com.stepos.policy.sdk;

import S.InterfaceC0103i;
import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f12123a = {Reflection.property1(new PropertyReference1Impl(b0.class, "policySdkDataStore", "getPolicySdkDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};

    /* renamed from: b, reason: collision with root package name */
    public static final U.c f12124b;

    /* renamed from: c, reason: collision with root package name */
    public static final V.f f12125c;

    /* renamed from: d, reason: collision with root package name */
    public static final V.f f12126d;

    /* renamed from: e, reason: collision with root package name */
    public static final V.f f12127e;

    /* renamed from: f, reason: collision with root package name */
    public static final V.f f12128f;

    /* renamed from: g, reason: collision with root package name */
    public static final V.f f12129g;

    static {
        d3.f scope = Z2.G.a(Z2.Q.f2190b.plus(Z2.I.b()));
        Intrinsics.checkNotNullParameter("policy_sdk_data", "name");
        U.a produceMigrations = U.a.f1875a;
        Intrinsics.checkNotNullParameter(produceMigrations, "produceMigrations");
        Intrinsics.checkNotNullParameter(scope, "scope");
        f12124b = new U.c(produceMigrations, scope);
        f12125c = com.airbnb.lottie.h.e("policyOperate");
        f12126d = com.airbnb.lottie.h.I("policyOperateRequestJson");
        f12127e = com.airbnb.lottie.h.s("readClipboardStatus");
        f12128f = com.airbnb.lottie.h.s("agreeStatus");
        f12129g = com.airbnb.lottie.h.I("commonDeleteInfoJson");
    }

    public static final InterfaceC0103i a(Context context) {
        return (InterfaceC0103i) f12124b.getValue(context, f12123a[0]);
    }
}
