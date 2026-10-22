package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Map;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public final class a extends SchedulerConfig {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4936a f19391a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Priority, SchedulerConfig.b> f19392b;

    public a(InterfaceC4936a interfaceC4936a, Map<Priority, SchedulerConfig.b> map) {
        if (interfaceC4936a == null) {
            throw new NullPointerException("Null clock");
        }
        this.f19391a = interfaceC4936a;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f19392b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public InterfaceC4936a e() {
        return this.f19391a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig) {
            SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
            if (this.f19391a.equals(schedulerConfig.e()) && this.f19392b.equals(schedulerConfig.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    public Map<Priority, SchedulerConfig.b> h() {
        return this.f19392b;
    }

    public int hashCode() {
        return this.f19392b.hashCode() ^ ((this.f19391a.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f19391a + ", values=" + this.f19392b + "}";
    }
}
