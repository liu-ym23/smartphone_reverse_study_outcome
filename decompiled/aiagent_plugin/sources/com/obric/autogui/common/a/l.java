package com.obric.autogui.common.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConfigTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SharedPreferences f28994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private T f28997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28998e;

    public l(String r2, int r3, T r4) {
        o.e(r2, "prefKey");
        this.f28995b = r2;
        this.f28996c = r3;
        this.f28997d = r4;
        this.f28998e = "vlm_config";
    }

    public final String b() {
        return this.f28995b;
    }

    public final int c() {
        return this.f28996c;
    }

    public final void a(T r1) {
        this.f28997d = r1;
    }

    public final T d() {
        return this.f28997d;
    }

    public final void a(SharedPreferences r3) {
        SharedPreferences r4 = (SharedPreferences) ZeusTransformUtils.wrapperContextForParams(r3, SharedPreferences.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.f28994a = r4;
    }

    public final SharedPreferences e() {
        SharedPreferences r0 = this.f28994a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        o.c("sharedPref");
        return null;
    }

    public final void b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        SharedPreferences r0 = r4.getSharedPreferences(this.f28998e, 0);
        o.c(r0, "getSharedPreferences(...)");
        a(r0);
        a(r4);
        a();
    }

    public String toString() {
        return String.valueOf(this.f28997d);
    }
}
