package com.stepos.aiengine.memory;

import com.stepos.aicgroup.memory.MemorySnapshot;
import com.stepos.aicgroup.memory.PressureLevel;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final long f5831e = TimeUnit.SECONDS.toNanos(60);

    /* renamed from: a, reason: collision with root package name */
    public final l<PressureLevel, Long> f5832a;

    /* renamed from: b, reason: collision with root package name */
    public volatile PressureLevel f5833b = PressureLevel.NORMAL;

    /* renamed from: c, reason: collision with root package name */
    public long f5834c = -4611686018427387904L;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f5835d;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.aiengine.memory.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0038a {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.aiengine.memory.a$a$a, reason: collision with other inner class name */
        public static final class C0039a extends AbstractC0038a {

            /* renamed from: a, reason: collision with root package name */
            public final PressureLevel f5836a;

            /* renamed from: b, reason: collision with root package name */
            public final PressureLevel f5837b;

            /* renamed from: c, reason: collision with root package name */
            public final MemorySnapshot f5838c;

            public C0039a(PressureLevel from, PressureLevel target, MemorySnapshot snapshot) {
                g.f(from, "from");
                g.f(target, "target");
                g.f(snapshot, "snapshot");
                this.f5836a = from;
                this.f5837b = target;
                this.f5838c = snapshot;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0039a)) {
                    return false;
                }
                C0039a c0039a = (C0039a) obj;
                return this.f5836a == c0039a.f5836a && this.f5837b == c0039a.f5837b && g.b(this.f5838c, c0039a.f5838c);
            }

            public final int hashCode() {
                return this.f5838c.hashCode() + ((this.f5837b.hashCode() + (this.f5836a.hashCode() * 31)) * 31);
            }

            public final String toString() {
                return "Apply(from=" + this.f5836a + ", target=" + this.f5837b + ", snapshot=" + this.f5838c + ")";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.aiengine.memory.a$a$b */
        public static final class b extends AbstractC0038a {

            /* renamed from: a, reason: collision with root package name */
            public final PressureLevel f5839a;

            /* renamed from: b, reason: collision with root package name */
            public final PressureLevel f5840b;

            /* renamed from: c, reason: collision with root package name */
            public final MemorySnapshot f5841c;

            public b(PressureLevel current, PressureLevel pending, MemorySnapshot snapshot) {
                g.f(current, "current");
                g.f(pending, "pending");
                g.f(snapshot, "snapshot");
                this.f5839a = current;
                this.f5840b = pending;
                this.f5841c = snapshot;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return this.f5839a == bVar.f5839a && this.f5840b == bVar.f5840b && g.b(this.f5841c, bVar.f5841c);
            }

            public final int hashCode() {
                return this.f5841c.hashCode() + ((this.f5840b.hashCode() + (this.f5839a.hashCode() * 31)) * 31);
            }

            public final String toString() {
                return "HoldRecord(current=" + this.f5839a + ", pending=" + this.f5840b + ", snapshot=" + this.f5841c + ")";
            }
        }

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: com.stepos.aiengine.memory.a$a$c */
        public static final class c extends AbstractC0038a {

            /* renamed from: a, reason: collision with root package name */
            public final PressureLevel f5842a;

            public c(PressureLevel current) {
                g.f(current, "current");
                this.f5842a = current;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof c) && this.f5842a == ((c) obj).f5842a;
            }

            public final int hashCode() {
                return this.f5842a.hashCode();
            }

            public final String toString() {
                return "NoChange(current=" + this.f5842a + ")";
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(l<? super PressureLevel, Long> lVar) {
        this.f5832a = lVar;
    }
}
