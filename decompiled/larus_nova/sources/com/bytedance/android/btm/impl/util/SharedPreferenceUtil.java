package com.bytedance.android.btm.impl.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class SharedPreferenceUtil {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function0<Boolean> f42492d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f42493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f42494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f42495c;

    public static final class a {
    }

    public final SharedPreferences.Editor b() {
        return (SharedPreferences.Editor) this.f42494b.getValue();
    }

    static {
        f42492d = SharedPreferenceUtil$Companion$useKevaProvider$1.INSTANCE;
    }

    public static boolean d() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(Boolean.valueOf(f42492d.invoke().booleanValue()));     // Catch: Throwable -> L4
    L6:
        Boolean r102 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = r102;
    L10:
        return ((Boolean) r101).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public SharedPreferenceUtil(Context r100, final String r101) {
        this.f42493a = r100.getSharedPreferences(r101, 0);
        this.f42494b = LazyKt.lazy(new SharedPreferenceUtil$editor$2(this));
        this.f42495c = LazyKt.lazy(new SharedPreferenceUtil$keva$2(r101));
    }

    public final void a(String r100, String r101) {
        if (d() == false) goto L5;
        ((Keva) this.f42495c.getValue()).storeString(r100, r101);
        return;
    L5:
        b().putString(r100, r101);
        b().commit();
    }

    public final String c(String r100, String r101) {
        if (d() == false) goto L6;
        return ((Keva) this.f42495c.getValue()).getString(r100, r101);
    L6:
        return this.f42493a.getString(r100, r101);
    }
}
