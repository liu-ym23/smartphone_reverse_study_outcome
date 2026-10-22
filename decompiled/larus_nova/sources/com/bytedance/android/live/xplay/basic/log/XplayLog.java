package com.bytedance.android.live.xplay.basic.log;

import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class XplayLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f102848a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/xplay/basic/log/XplayLog$Severity;", "", "Debug", "Info", "Error", "livexplaygamebasic-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Severity extends Enum<Severity> {
        public static final Severity Debug = null;
        public static final Severity Error = null;
        public static final Severity Info = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Severity[] f102849a = null;

        static {
            Severity r100 = new Severity("Debug", 0);
            Debug = r100;
            Severity r101 = new Severity("Info", 1);
            Info = r101;
            Severity r102 = new Severity("Error", 2);
            Error = r102;
            f102849a = new Severity[]{r100, r101, r102};
        }

        public static Severity valueOf(String r100) {
            return (Severity) r27.a.a(Severity.class, r100);
        }

        public static Severity[] values() {
            return (Severity[]) f102849a.clone();
        }

        public Severity(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        d(Severity.Debug, r100, r101);
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        d(Severity.Error, r100, r101);
    }

    public static void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        d(Severity.Info, r100, r101);
    }

    public static void d(Severity r100, String r101, String r102) {
        String r103 = "[" + ThreadMethodProxy.currentThread().getName() + ':' + ThreadMethodProxy.currentThread().getId() + "] " + r102;
        int r104 = b.f102850a[r100.ordinal()];
        if (r104 != 1) goto L5;
        ALogger.d(r101, r103);
        return;
    L5:
        if (r104 != 2) goto L7;
        ALogger.i(r101, r103);
        return;
    L7:
        if (r104 != 3) goto L10;
        ALogger.e(r101, r103);
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
