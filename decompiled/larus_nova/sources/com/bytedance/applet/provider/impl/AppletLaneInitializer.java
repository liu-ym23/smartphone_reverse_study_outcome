package com.bytedance.applet.provider.impl;

import com.bytedance.applet.impl.j1;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class AppletLaneInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<Phase> f192166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f192167b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f192168c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f192169d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicBoolean f192170e = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applet/provider/impl/AppletLaneInitializer$Phase;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RUNNING", "DONE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase DONE = null;
        public static final Phase IDLE = null;
        public static final Phase RUNNING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Phase[] f192171a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f192172b = null;

        public static EnumEntries<Phase> getEntries() {
            return f192172b;
        }

        static {
            Phase r100 = new Phase("IDLE", 0);
            IDLE = r100;
            Phase r101 = new Phase("RUNNING", 1);
            RUNNING = r101;
            Phase r102 = new Phase("DONE", 2);
            DONE = r102;
            Phase[] r103 = {r100, r101, r102};
            f192171a = r103;
            f192172b = EnumEntriesKt.enumEntries(r103);
        }

        public static Phase[] values() {
            return (Phase[]) f192171a.clone();
        }

        public static Phase valueOf(String r100) {
            return (Phase) r27.a.a(Phase.class, r100);
        }

        public Phase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192173a = null;

        static {
            int[] r100 = new int[Phase.values().length];
            r100[Phase.DONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Phase.IDLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Phase.RUNNING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f192173a = r100;
        }
    }

    static {
        f192166a = new AtomicReference(Phase.IDLE);
        f192167b = new AtomicBoolean(false);
        f192168c = new AtomicBoolean(false);
        f192169d = new AtomicBoolean(false);
        f192170e = new AtomicBoolean(false);
    }

    public static void a(j1 r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
    L3:
        AtomicReference<Phase> r101 = f192166a;
        Phase r102 = r101.get();
        if (r102 != null) goto L6;
        int r103 = -1;
    L7:
        boolean r104 = true;
        if (r103 == 1) goto L33;
        if (r103 != 2) goto L12;
        Phase r105 = Phase.IDLE;
        Phase r106 = Phase.RUNNING;
    L22:
        if (r101.compareAndSet(r105, r106) == true) goto L27;
        if (r101.get() == r105) goto L22;
        r104 = false;
    L27:
        if (r104 == false) goto L3;
        r100.invoke();     // Catch: Throwable -> L30
        f192166a.set(Phase.DONE);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        f192166a.set(Phase.IDLE);
        FLogger.f375446a.e("AppletLaneInitializer", "applet init failed, reset to IDLE for retry: " + th.getMessage());
        throw th;
    L12:
        if (r103 != 3) goto L19;
        Thread.sleep(5);     // Catch: InterruptedException -> L16
    L16:
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L19:
        throw new NoWhenBranchMatchedException();
    L33:
        return;
    L6:
        r103 = a.f192173a[r102.ordinal()];
        goto L7
    }
}
