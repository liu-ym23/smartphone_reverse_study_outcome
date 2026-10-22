package com.stepos.statsapp.v3.lib.plugin.emitter.local.phone;

import android.content.Context;
import com.stepos.statsapp.v3.lib.plugin.emitter.Emitter;
import com.stepos.statsapp.v3.lib.plugin.payload.TrackerPayload;
import com.stepos.statsapp.v3.lib.plugin.sdk.UmidFetcher;
import com.stepos.statsapp.v3.utils.log.Logger;

/* loaded from: classes2.dex */
public class a extends Emitter {

    /* renamed from: b, reason: collision with root package name */
    private static final String f30693b = "LocalEmitter";

    /* renamed from: a, reason: collision with root package name */
    private b f30694a;

    public a(Context context) {
        super(context, "", "");
        this.f30694a = new b(context, this.emitterConfig);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void add(TrackerPayload trackerPayload) {
        Logger.d(f30693b, "add payload: " + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            this.f30694a.a(trackerPayload);
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void addNeartime(TrackerPayload trackerPayload) {
        Logger.d(f30693b, "addNeartime payload: " + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            this.f30694a.b(trackerPayload);
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void addRealtime(TrackerPayload trackerPayload) {
        Logger.d(f30693b, "addRealtime payload: " + trackerPayload.toString());
        if (this.emitterConfig.isActive()) {
            this.f30694a.c(trackerPayload);
        }
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void flush() {
        Logger.d(f30693b, "flush");
        this.f30694a.b();
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public String getUMID() {
        return UmidFetcher.getInstance().getUmId(this.mContext, false);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void init() {
        Logger.d(f30693b, "init");
        this.f30694a.c();
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void setEncrypt(boolean z10) {
        this.f30694a.a(z10);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void updateConfig(boolean z10, boolean z11, boolean z12, boolean z13, long j10, int i10, long j11, int i11) {
        super.updateConfig(z10, z11, z12, z13, j10, i10, j11, i11);
        this.f30694a.a(this.emitterConfig);
    }

    @Override // com.stepos.statsapp.v3.lib.plugin.emitter.Emitter
    public void updateEventSource(String str, String str2) {
        this.f30694a.a(str, str2);
    }
}
