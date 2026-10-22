package com.bytedance.android.livesdk.performance.degrade.ability;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements com.bytedance.android.live.core.log.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f154534a;

    public c() {
        this.f154534a = "gpu_monitor_schedule_ability";
    }

    @Override // com.bytedance.android.live.core.log.c
    public final String generate() {
        return "setPerformanceAtomicAbilityCallback " + this.f154534a;
    }
}
