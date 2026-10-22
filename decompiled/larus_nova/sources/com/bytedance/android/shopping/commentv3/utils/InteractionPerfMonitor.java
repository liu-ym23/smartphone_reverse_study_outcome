package com.bytedance.android.shopping.commentv3.utils;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import jd3.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import t53.e;

/* JADX INFO: loaded from: classes13.dex */
public final class InteractionPerfMonitor {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f172917i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f172918j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f172919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f172920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f172921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f172922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f172923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f172924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f172925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f172926h;

    public static final class a {
        public a() {
        }

        public static InteractionPerfMonitor a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Lazy r101 = InteractionPerfMonitor.f172917i;
            if (((Map) r101.getValue()).containsKey(r100) == false) goto L7;
            InteractionPerfMonitor r102 = (InteractionPerfMonitor) ((Map) r101.getValue()).get(r100);
            if (r102 == null) goto L7;
            return r102;
        L7:
            InteractionPerfMonitor r103 = new InteractionPerfMonitor();
            ((Map) r101.getValue()).put(r100, r103);
            return r103;
        }
    }

    static {
        f172918j = new a();
        f172917i = LazyKt.lazy(InteractionPerfMonitor$Companion$monitors$2.INSTANCE);
    }

    public InteractionPerfMonitor() {
        this.f172919a = "";
        this.f172920b = "";
    }

    public final void a(int r110, String r111, Context r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r113, "key");
        long r100 = System.currentTimeMillis();
        long r101 = this.f172921c;
        long r102 = r100 - r101;
        if (r101 > 0) goto L5;
        return;
    L5:
        if (r102 <= 0) goto L10;
        k r103 = new k();
        r103.f498364a = r110;
        String r114 = this.f172919a;
        Intrinsics.checkNotNullParameter(r114, "<set-?>");
        r103.f498365b = r114;
        String r115 = this.f172920b;
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r103.f498366c = r115;
        r103.f498367d = r100 - this.f172921c;
        r103.f498369f = this.f172923e - this.f172922d;
        r103.f498370g = this.f172925g - this.f172924f;
        r103.f498371h = r100 - this.f172926h;
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r103.f498372i = r111;
        e.c(r103, r112, null);
        f172918j.getClass();
        ((Map) f172917i.getValue()).remove(r113);
        return;
    }
}
