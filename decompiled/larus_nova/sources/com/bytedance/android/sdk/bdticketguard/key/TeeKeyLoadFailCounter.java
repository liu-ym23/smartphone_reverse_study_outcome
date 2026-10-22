package com.bytedance.android.sdk.bdticketguard.key;

import android.content.SharedPreferences;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class TeeKeyLoadFailCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f163819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f163820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f163821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f163822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f163823e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f163824f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f163825g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TeeKeyLoadFailCounter f163826h = null;

    static {
        f163819a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TeeKeyLoadFailCounter.class), CloudControlInf.SP, "getSp()Landroid/content/SharedPreferences;"))};
        f163826h = new TeeKeyLoadFailCounter();
        f163823e = new AtomicBoolean(false);
        f163824f = LazyKt.lazy(TeeKeyLoadFailCounter$sp$2.INSTANCE);
        f163825g = new AtomicBoolean(false);
    }

    public TeeKeyLoadFailCounter() {
    }

    public static SharedPreferences a() {
        Lazy r100 = f163824f;
        KProperty r101 = f163819a[0];
        return (SharedPreferences) r100.getValue();
    }

    public static void d() {
        SharedPreferences r100 = a();
        if (r100 != null) goto L5;
        return;
    L5:
        if (f163825g.getAndSet(true) == true) goto L9;
        f163820b = r100.getInt("sp_key_tee_fail_count", 0);
        f163821c = r100.getInt("sp_key_accumulated_tee_fail_count", 0);
        f163822d = r100.getLong("sp_key_first_fail_timestamp", 0);
        return;
    }

    public static void b(int r100) {
        f163821c = r100;
        SharedPreferences r101 = a();
        if (r101 == null) goto L10;
        SharedPreferences.Editor r102 = r101.edit();
        if (r102 == null) goto L11;
        SharedPreferences.Editor r103 = r102.putInt("sp_key_accumulated_tee_fail_count", r100);
        if (r103 == null) goto L12;
        r103.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    public static void c(long r100) {
        f163822d = r100;
        SharedPreferences r101 = a();
        if (r101 == null) goto L10;
        SharedPreferences.Editor r102 = r101.edit();
        if (r102 == null) goto L11;
        SharedPreferences.Editor r103 = r102.putLong("sp_key_first_fail_timestamp", r100);
        if (r103 == null) goto L12;
        r103.apply();
        return;
    L12:
        return;
    L11:
        return;
    }
}
