package com.stepos.statsapp.v3.lib.plugin.emitter;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.core.download.ModelFlowMeta;
import com.stepos.core.ota.process.OtaIdleExitPolicy;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8003a;

    /* renamed from: b, reason: collision with root package name */
    public final EmitterConfig f8004b;

    /* renamed from: c, reason: collision with root package name */
    public final sa.a f8005c;

    public b(Context context, String str, String str2) {
        this.f8003a = context;
        this.f8005c = new sa.a(context, "com.stepos.statsapp.v3.emitterconfig");
        this.f8004b = new EmitterConfig(str, str2);
        a();
    }

    public final void a() {
        sa.a aVar = this.f8005c;
        boolean z = aVar.f11898a.getBoolean(ModelFlowMeta.KEY_ACTIVE, true);
        EmitterConfig emitterConfig = this.f8004b;
        emitterConfig.active = z;
        emitterConfig.flushOnStart = aVar.f11898a.getBoolean("flushOnStart", true);
        emitterConfig.flushOnReconnect = aVar.f11898a.getBoolean("flushOnReconnect", true);
        emitterConfig.flushOnCharge = aVar.f11898a.getBoolean("flushOnCharge", true);
        emitterConfig.flushDelayInterval = aVar.f11898a.getLong("flushDelayInterval", OtaIdleExitPolicy.TERMINAL_IDLE_MS);
        emitterConfig.flushCacheLimit = aVar.f11898a.getInt("flushCacheLimit", 50);
        emitterConfig.flushMobileTrafficLimit = aVar.f11898a.getLong("flushMobileTrafficLimit", 2097152L);
        emitterConfig.neartimeInterval = aVar.f11898a.getInt("neartimeInterval", 5);
    }

    public final void b(boolean z, boolean z3, boolean z10, boolean z11, long j10, int i10, long j11, int i11) {
        SharedPreferences.Editor editorEdit = this.f8005c.f11898a.edit();
        editorEdit.putBoolean(ModelFlowMeta.KEY_ACTIVE, z);
        editorEdit.putBoolean("flushOnStart", z3);
        editorEdit.putBoolean("flushOnReconnect", z10);
        editorEdit.putBoolean("flushOnCharge", z11);
        editorEdit.putLong("flushDelayInterval", j10);
        editorEdit.putLong("flushMobileTrafficLimit", j11);
        editorEdit.putInt("flushCacheLimit", i10);
        editorEdit.putInt("neartimeInterval", i11);
        editorEdit.apply();
        a();
    }
}
