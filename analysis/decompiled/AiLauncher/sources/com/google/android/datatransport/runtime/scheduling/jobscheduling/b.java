package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* loaded from: classes2.dex */
public final class b extends SchedulerConfig.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f19393a;

    /* renamed from: b, reason: collision with root package name */
    public final long f19394b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<SchedulerConfig.Flag> f19395c;

    /* renamed from: com.google.android.datatransport.runtime.scheduling.jobscheduling.b$b, reason: collision with other inner class name */
    public static final class C0223b extends SchedulerConfig.b.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f19396a;

        /* renamed from: b, reason: collision with root package name */
        public Long f19397b;

        /* renamed from: c, reason: collision with root package name */
        public Set<SchedulerConfig.Flag> f19398c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.f19396a == null) {
                str = " delta";
            }
            if (this.f19397b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f19398c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new b(this.f19396a.longValue(), this.f19397b.longValue(), this.f19398c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j10) {
            this.f19396a = Long.valueOf(j10);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set<SchedulerConfig.Flag> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f19398c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j10) {
            this.f19397b = Long.valueOf(j10);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long b() {
        return this.f19393a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public Set<SchedulerConfig.Flag> c() {
        return this.f19395c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    public long d() {
        return this.f19394b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SchedulerConfig.b) {
            SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
            if (this.f19393a == bVar.b() && this.f19394b == bVar.d() && this.f19395c.equals(bVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f19393a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003;
        long j11 = this.f19394b;
        return this.f19395c.hashCode() ^ ((i10 ^ ((int) ((j11 >>> 32) ^ j11))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f19393a + ", maxAllowedDelay=" + this.f19394b + ", flags=" + this.f19395c + "}";
    }

    public b(long j10, long j11, Set<SchedulerConfig.Flag> set) {
        this.f19393a = j10;
        this.f19394b = j11;
        this.f19395c = set;
    }
}
