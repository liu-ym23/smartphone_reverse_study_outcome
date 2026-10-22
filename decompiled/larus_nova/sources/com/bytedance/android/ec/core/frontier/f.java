package com.bytedance.android.ec.core.frontier;

import android.os.SystemClock;
import android.util.SparseArray;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f44045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Long f44046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f44047c = null;

    public static final class a {
        public a() {
        }

        public static void a(boolean r100) {
            JSONObject r101 = new JSONObject();
            if (r100 == false) goto L5;
            int r102 = 200;
        L6:
            r101.put("status", r102);
            Unit r103 = Unit.INSTANCE;
            JSONObject r104 = new JSONObject();
            if (f.f44046b == null) goto L9;
            long r105 = SystemClock.elapsedRealtime();
            Long r106 = f.f44046b;
            Intrinsics.checkNotNull(r106);
            r104.put("duration", r105 - r106.longValue());
            f.f44046b = null;
        L9:
            int r107 = ECMonitorService.f45110b;
            ECMonitorService.a.a("ec_ws_connection", r101, r104, null);
            f.f44045a = false;
            return;
        L5:
            r102 = 100;
            goto L6
        }
    }

    static {
        f44047c = new a();
        new SparseArray();
    }
}
