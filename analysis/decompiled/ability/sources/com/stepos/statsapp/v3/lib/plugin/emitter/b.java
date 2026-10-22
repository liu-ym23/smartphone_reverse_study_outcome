package com.stepos.statsapp.v3.lib.plugin.emitter;

import android.content.Context;
import android.content.SharedPreferences;
import com.zyql.common.utils.upload.TOSUploader;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3966a;
    public final EmitterConfig b;
    public final V5.a c;

    public b(Context context, String str, String str2) {
        this.f3966a = context;
        this.c = new V5.a(context, "com.stepos.statsapp.v3.emitterconfig");
        this.b = new EmitterConfig(str, str2);
        a();
    }

    public final void a() {
        V5.a aVar = this.c;
        boolean z10 = aVar.f1385a.getBoolean("active", true);
        EmitterConfig emitterConfig = this.b;
        emitterConfig.active = z10;
        emitterConfig.flushOnStart = aVar.f1385a.getBoolean("flushOnStart", true);
        emitterConfig.flushOnReconnect = aVar.f1385a.getBoolean("flushOnReconnect", true);
        emitterConfig.flushOnCharge = aVar.f1385a.getBoolean("flushOnCharge", true);
        emitterConfig.flushDelayInterval = aVar.f1385a.getLong("flushDelayInterval", TOSUploader.EXPIRED_TIMES);
        emitterConfig.flushCacheLimit = aVar.f1385a.getInt("flushCacheLimit", 50);
        emitterConfig.flushMobileTrafficLimit = aVar.f1385a.getLong("flushMobileTrafficLimit", 2097152L);
        emitterConfig.neartimeInterval = aVar.f1385a.getInt("neartimeInterval", 5);
    }

    public final void b(boolean z10, boolean z11, boolean z12, boolean z13, long j5, int i, long j6, int i6) {
        SharedPreferences.Editor editorEdit = this.c.f1385a.edit();
        editorEdit.putBoolean("active", z10);
        editorEdit.putBoolean("flushOnStart", z11);
        editorEdit.putBoolean("flushOnReconnect", z12);
        editorEdit.putBoolean("flushOnCharge", z13);
        editorEdit.putLong("flushDelayInterval", j5);
        editorEdit.putLong("flushMobileTrafficLimit", j6);
        editorEdit.putInt("flushCacheLimit", i);
        editorEdit.putInt("neartimeInterval", i6);
        editorEdit.apply();
        a();
    }
}
