package com.stepos.policy.sdk;

import M0.a;
import android.content.Context;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.t;
import s9.InterfaceC5452d;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\"%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\"(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000f\"(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u0017\u0010\u000f\"(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0019\u0010\u000f\"(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001d"}, d2 = {"Landroid/content/Context;", "LJ0/d;", "LM0/a;", Const.INTENT_KEY_PKGNAME, "Ls9/d;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)LJ0/d;", "policySdkDataStore", "LM0/a$a;", "", "c", "LM0/a$a;", "e", "()LM0/a$a;", "setKEY_POLICY_OPERATE", "(LM0/a$a;)V", "KEY_POLICY_OPERATE", "", Const.INTENT_KEY_UMID, "f", "setKEY_POLICY_OPERATE_JSON", "KEY_POLICY_OPERATE_JSON", "", "setKEY_AGREE_STATUS", "KEY_AGREE_STATUS", "setKEY_COMMON_DELETE_INFO_JSON", "KEY_COMMON_DELETE_INFO_JSON", "setKEY_CLOUD_POLICY_UID_CATEGORY_MAP", "KEY_CLOUD_POLICY_UID_CATEGORY_MAP", "policysdk_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC5752k<Object>[] f30588a = {t.i(new PropertyReference1Impl(d.class, "policySdkDataStore", "getPolicySdkDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};

    /* renamed from: b, reason: collision with root package name */
    public static final InterfaceC5452d f30589b = PreferenceDataStoreDelegateKt.b("policy_sdk_data", null, null, null, 14, null);

    /* renamed from: c, reason: collision with root package name */
    public static a.C0079a<Boolean> f30590c = M0.c.a("policyOperate");

    /* renamed from: d, reason: collision with root package name */
    public static a.C0079a<String> f30591d = M0.c.f("policyOperateRequestJson");

    /* renamed from: e, reason: collision with root package name */
    public static a.C0079a<Integer> f30592e = M0.c.d("agreeStatus");

    /* renamed from: f, reason: collision with root package name */
    public static a.C0079a<String> f30593f = M0.c.f("commonDeleteInfoJson");

    /* renamed from: g, reason: collision with root package name */
    public static a.C0079a<String> f30594g = M0.c.f("cloudPolicyUidCategoryMap");

    public static final a.C0079a<Integer> b() {
        return f30592e;
    }

    public static final a.C0079a<String> c() {
        return f30594g;
    }

    public static final a.C0079a<String> d() {
        return f30593f;
    }

    public static final a.C0079a<Boolean> e() {
        return f30590c;
    }

    public static final a.C0079a<String> f() {
        return f30591d;
    }

    public static final J0.d<M0.a> g(Context context) {
        return (J0.d) f30589b.getValue(context, f30588a[0]);
    }
}
