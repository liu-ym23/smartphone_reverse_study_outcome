package com.stepos.policy.sdk;

import Z7.t;
import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ t[] f3954a = {kotlin.jvm.internal.m.f4928a.g(new PropertyReference1Impl(m.class, "policySdkDataStore", "getPolicySdkDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1))};
    public static final V7.b b = PreferenceDataStoreDelegateKt.preferencesDataStore$default("policy_sdk_data", null, null, null, 14, null);
    public static final Preferences.Key c = PreferencesKeys.booleanKey("policyOperate");
    public static final Preferences.Key d = PreferencesKeys.stringKey("policyOperateRequestJson");
    public static final Preferences.Key e = PreferencesKeys.intKey("readClipboardStatus");
    public static final Preferences.Key f = PreferencesKeys.intKey("agreeStatus");
    public static final Preferences.Key g = PreferencesKeys.stringKey("commonDeleteInfoJson");
    public static final Preferences.Key h = PreferencesKeys.stringKey("cloudPolicyUidCategoryMap");

    public static final DataStore a(Context context) {
        return (DataStore) b.getValue(context, f3954a[0]);
    }
}
