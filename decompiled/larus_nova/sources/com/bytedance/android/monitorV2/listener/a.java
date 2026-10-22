package com.bytedance.android.monitorV2.listener;

import com.bytedance.android.monitorV2.ValidationReport;
import com.bytedance.android.monitorV2.event.HybridEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements g {

    /* JADX INFO: renamed from: com.bytedance.android.monitorV2.listener.a$a, reason: collision with other inner class name */
    public static final class C2494a {
    }

    static {
    }

    public a() {
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventCreated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ValidationReport.c(r100);
        nz2.b.a("EventDebugTools", r100.a() + " - " + r100.f163001a + " onEventCreate");
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventSampled(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ValidationReport.c(r100);
        nz2.b.a("EventDebugTools", r100.a() + " - " + r100.f163001a + " onEventSampled");
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventTerminated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ValidationReport.c(r100);
        nz2.b.a("EventDebugTools", r100.a() + " - " + r100.f163001a + " onEventTerminated eventPhase: + " + r100.f163004d.f163016a);
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventUpdated(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        nz2.b.a("EventDebugTools", r100.a() + " - " + r100.f163001a + " onEventUpdated");
    }

    @Override // com.bytedance.android.monitorV2.listener.g
    public void onEventUploaded(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ValidationReport.c(r100);
        nz2.b.a("EventDebugTools", r100.a() + " - " + r100.f163001a + " onEventUploaded");
    }
}
