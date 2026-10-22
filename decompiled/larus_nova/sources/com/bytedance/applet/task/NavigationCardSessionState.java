package com.bytedance.applet.task;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class NavigationCardSessionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f192201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f192202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Phase f192203c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/applet/task/NavigationCardSessionState$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "WAITING_FOR_START", "STARTING", "ACTIVE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase ACTIVE = null;
        public static final Phase IDLE = null;
        public static final Phase STARTING = null;
        public static final Phase WAITING_FOR_START = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Phase[] f192204a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f192205b = null;

        public static EnumEntries<Phase> getEntries() {
            return f192205b;
        }

        static {
            Phase r100 = new Phase("IDLE", 0);
            IDLE = r100;
            Phase r101 = new Phase("WAITING_FOR_START", 1);
            WAITING_FOR_START = r101;
            Phase r102 = new Phase("STARTING", 2);
            STARTING = r102;
            Phase r103 = new Phase("ACTIVE", 3);
            ACTIVE = r103;
            Phase[] r104 = {r100, r101, r102, r103};
            f192204a = r104;
            f192205b = EnumEntriesKt.enumEntries(r104);
        }

        public static Phase[] values() {
            return (Phase[]) f192204a.clone();
        }

        public static Phase valueOf(String r100) {
            return (Phase) r27.a.a(Phase.class, r100);
        }

        public Phase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f192206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f192207b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f192206a == r101.f192206a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f192207b, r101.f192207b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f192206a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f192207b;
            if (r102 != null) goto L5;
            int r103 = 0;
        L7:
            return r101 + r103;
        L5:
            r103 = r102.hashCode();
            goto L7
        }

        public final String toString() {
            return "Owner(generation=" + this.f192206a + ", navigationId=" + this.f192207b + ')';
        }

        public a(long r100, String r101) {
            this.f192206a = r100;
            this.f192207b = r101;
        }
    }

    public NavigationCardSessionState() {
        this.f192203c = Phase.IDLE;
    }

    public final synchronized boolean a(a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "expected");     // Catch: Throwable -> L6
        boolean r101 = Intrinsics.areEqual(this.f192202b, r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
