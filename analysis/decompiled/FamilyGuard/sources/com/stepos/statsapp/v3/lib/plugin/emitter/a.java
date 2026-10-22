package com.stepos.statsapp.v3.lib.plugin.emitter;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.lib.plugin.emitter.remote.V3OfflineEmitter;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import f3.C0720b;
import g3.C0742e;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected Context f15889a;

    /* renamed from: b, reason: collision with root package name */
    protected EmitterConfig f15890b;

    /* renamed from: c, reason: collision with root package name */
    private final C0720b f15891c;

    public a(Context context, String str, String str2) {
        this.f15889a = context;
        this.f15891c = new C0720b(context, "com.stepos.statsapp.v3.emitterconfig");
        this.f15890b = new EmitterConfig(str, str2);
        h();
    }

    public static a f(Context context, String str, String str2) {
        V3OfflineEmitter v3OfflineEmitter = new V3OfflineEmitter(context, str, str2);
        C0742e.i("Emitter", "buildEmitter emitter is V3OfflineEmitter");
        return v3OfflineEmitter;
    }

    private void h() {
        this.f15890b.f15878a = this.f15891c.n("active", true);
        this.f15890b.f15880c = this.f15891c.n("flushOnStart", true);
        this.f15890b.f15882e = this.f15891c.n("flushOnReconnect", true);
        this.f15890b.f15881d = this.f15891c.n("flushOnCharge", true);
        this.f15890b.f15883f = this.f15891c.l("flushDelayInterval", 1800000L);
        this.f15890b.f15884g = this.f15891c.k("flushCacheLimit", 50);
        this.f15890b.f15885h = this.f15891c.l("flushMobileTrafficLimit", 2097152L);
        this.f15890b.f15886i = this.f15891c.k("neartimeInterval", 5);
    }

    public abstract void c(TrackerPayload trackerPayload);

    public abstract void d(TrackerPayload trackerPayload);

    public abstract void e(TrackerPayload trackerPayload);

    public abstract void g();

    public void i(boolean z5, boolean z6, boolean z7, boolean z8, long j5, int i5, long j6, int i6) {
        SharedPreferences.Editor editorH = this.f15891c.h();
        editorH.putBoolean("active", z5);
        editorH.putBoolean("flushOnStart", z6);
        editorH.putBoolean("flushOnReconnect", z7);
        editorH.putBoolean("flushOnCharge", z8);
        editorH.putLong("flushDelayInterval", j5);
        editorH.putLong("flushMobileTrafficLimit", j6);
        editorH.putInt("flushCacheLimit", i5);
        editorH.putInt("neartimeInterval", i6);
        editorH.apply();
        h();
    }

    public abstract void j(String str, String str2);
}
