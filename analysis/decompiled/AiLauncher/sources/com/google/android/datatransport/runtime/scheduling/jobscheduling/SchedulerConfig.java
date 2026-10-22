package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import n2.InterfaceC4936a;

/* loaded from: classes2.dex */
public abstract class SchedulerConfig {

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC4936a f19389a;

        /* renamed from: b, reason: collision with root package name */
        public Map<Priority, b> f19390b = new HashMap();

        public a a(Priority priority, b bVar) {
            this.f19390b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig b() {
            if (this.f19389a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f19390b.keySet().size() < Priority.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map<Priority, b> map = this.f19390b;
            this.f19390b = new HashMap();
            return SchedulerConfig.d(this.f19389a, map);
        }

        public a c(InterfaceC4936a interfaceC4936a) {
            this.f19389a = interfaceC4936a;
            return this;
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract b a();

            public abstract a b(long j10);

            public abstract a c(Set<Flag> set);

            public abstract a d(long j10);
        }

        public static a a() {
            return new b.C0223b().c(Collections.EMPTY_SET);
        }

        public abstract long b();

        public abstract Set<Flag> c();

        public abstract long d();
    }

    public static a b() {
        return new a();
    }

    public static SchedulerConfig d(InterfaceC4936a interfaceC4936a, Map<Priority, b> map) {
        return new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(interfaceC4936a, map);
    }

    public static SchedulerConfig f(InterfaceC4936a interfaceC4936a) {
        return b().a(Priority.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)).a()).c(interfaceC4936a).b();
    }

    public static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    public final long a(int i10, long j10) {
        return (long) (Math.pow(3.0d, i10 - 1) * j10 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j10 > 1 ? j10 : 2L) * r7)));
    }

    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j10, int i10) {
        builder.setMinimumLatency(g(priority, j10, i10));
        j(builder, h().get(priority).c());
        return builder;
    }

    public abstract InterfaceC4936a e();

    public long g(Priority priority, long j10, int i10) {
        long jA = j10 - e().a();
        b bVar = h().get(priority);
        return Math.min(Math.max(a(i10, bVar.b()), jA), bVar.d());
    }

    public abstract Map<Priority, b> h();

    public final void j(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }
}
