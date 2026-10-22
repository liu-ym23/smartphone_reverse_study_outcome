package com.bytedance.apm.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.apm.c;
import com.bytedance.apm.core.MonitorSharedPreferences;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SpManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f4702a;

    /* JADX INFO: renamed from: com.bytedance.apm.internal.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpManager.java */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: compiled from: SpManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f4703a = null;

        static /* synthetic */ b a() {
            return f4703a;
        }

        static {
            f4703a = new b(null);
        }
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    private b() {
        this.f4702a = MonitorSharedPreferences.getSharedPreferences((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "monitor_config");
    }

    public static b a() {
        return a.a();
    }

    public String a(String r2) {
        return this.f4702a.getString(r2, null);
    }

    public int b(String r2) {
        return this.f4702a.getInt(r2, -1);
    }

    public long c(String r3) {
        return this.f4702a.getLong(r3, 0);
    }

    public void a(String r1, String r2) {
        this.f4702a.edit().putString(r1, r2).apply();
    }

    public void a(String r1, long r2) {
        this.f4702a.edit().putLong(r1, r2).apply();
    }

    public void a(String r1, int r2) {
        this.f4702a.edit().putInt(r1, r2).apply();
    }
}
