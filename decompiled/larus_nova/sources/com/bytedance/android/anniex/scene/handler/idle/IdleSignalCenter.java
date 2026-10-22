package com.bytedance.android.anniex.scene.handler.idle;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class IdleSignalCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IdleSignalCenter f41188a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<a> f41189b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f41190c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f41191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f41193c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f41191a, r101.f41191a) == true) goto L12;
            return false;
        L12:
            if (this.f41192b == r101.f41192b) goto L15;
            return false;
        L15:
            if (this.f41193c == r101.f41193c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f41191a.hashCode() * 31) + this.f41192b) * 31;
            long r101 = this.f41193c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "Signal(source=" + this.f41191a + ", level=" + this.f41192b + ", expiryTime=" + this.f41193c + ')';
        }

        public a(long r100) {
            Intrinsics.checkNotNullParameter("page_switch", "source");
            this.f41191a = "page_switch";
            this.f41192b = 1;
            this.f41193c = r100;
        }
    }

    public IdleSignalCenter() {
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        boolean r100 = ((ArrayList) f41189b).isEmpty();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() {
        monitor-enter(this);
        final long r100 = System.currentTimeMillis();     // Catch: Throwable -> L6
        CollectionsKt.removeAll(f41189b, new IdleSignalCenter$removeExpiredSignals$1(r100));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f41188a = new IdleSignalCenter();
        f41189b = new ArrayList();
        f41190c = new Handler(Looper.getMainLooper());
    }
}
