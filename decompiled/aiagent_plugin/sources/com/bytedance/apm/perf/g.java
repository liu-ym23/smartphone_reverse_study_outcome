package com.bytedance.apm.perf;

import android.content.IntentFilter;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;

/* JADX INFO: compiled from: TemperatureDataManager.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PluginBroadcastReceiver f4827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IntentFilter f4828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f4829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4831e;

    /* JADX INFO: compiled from: TemperatureDataManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f4833a = null;

        static /* synthetic */ g a() {
            return f4833a;
        }

        static {
            f4833a = new g(null);
        }
    }

    /* synthetic */ g(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ float a(g r0, float r1) {
        r0.f4829c = r1;
        return r1;
    }

    static /* synthetic */ int a(g r0, int r1) {
        r0.f4830d = r1;
        return r1;
    }

    static /* synthetic */ int b(g r0, int r1) {
        r0.f4831e = r1;
        return r1;
    }

    private g() {
        d();
    }

    public static g a() {
        return a.a();
    }

    private void d() {
        this.f4827a = new AnonymousClass1(this);
        this.f4828b = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public float b() {
        return this.f4829c;
    }

    public int c() {
        return this.f4830d;
    }
}
