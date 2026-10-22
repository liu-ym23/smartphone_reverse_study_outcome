package com.obric.common.upgrade.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SharedPreferencesUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32654a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile f f32655d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f32656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SharedPreferences.Editor f32657c;

    /* JADX INFO: compiled from: SharedPreferencesUtils.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final f a(Context r3, String r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r5, "context");
            o.e(r4, "name");
            f r0 = f.a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = f.a();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new f(r5, r4, null);     // Catch: Throwable -> L10
            a r6 = f.f32654a;     // Catch: Throwable -> L10
            f.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        f32654a = new a(null);
    }

    public /* synthetic */ f(Context r2, String r3, d.h.b.h r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3);
    }

    private f(Context r3, String r4) {
        SharedPreferences r5 = ((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSharedPreferences(r4, 0);
        o.c(r5, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.f32656b = r5;
        SharedPreferences.Editor r6 = r5.edit();
        o.c(r6, "sharedPreferences.edit()");
        this.f32657c = r6;
    }

    public static final /* synthetic */ f a() {
        return f32655d;
    }

    public static final /* synthetic */ void a(f r0) {
        f32655d = r0;
    }

    public final boolean a(String r2, boolean r3) {
        o.e(r2, "key");
        return this.f32656b.getBoolean(r2, r3);
    }

    public final void a(String r2, long r3) {
        o.e(r2, "key");
        this.f32657c.putLong(r2, r3).apply();
    }

    public final long b(String r2, long r3) {
        o.e(r2, "key");
        return this.f32656b.getLong(r2, r3);
    }
}
