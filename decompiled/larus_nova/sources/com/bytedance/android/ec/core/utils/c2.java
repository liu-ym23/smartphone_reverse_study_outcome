package com.bytedance.android.ec.core.utils;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f45564h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f45566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f45567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f45568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f45569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f45570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f45571g;

    public static final class a {
        @JvmStatic
        public static c2 a(Context r100, long r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            c2 r101 = new c2();
            String r102 = null;
            if (r110 <= 0) goto L27;
            int r103 = (((int) r110) % 1000) / 100;
            long r112 = r110 / ((long) 1000);
            int r104 = ((int) r112) % 60;
            long r105 = 60;
            long r113 = r112 / r105;
            int r106 = ((int) r113) % 60;
            int r114 = (int) (r113 / r105);
            int r115 = r114 % 24;
            int r116 = r114 / 24;
            r101.f45565a = r116;
            if (r116 <= 0) goto L8;
            r102 = String.valueOf(r116);
        L8:
            r101.f45566b = r102;
            if (r115 >= 10) goto L11;
            String r117 = th.a.h(r100, R.string.shopping_sec_kill_zero_placeholder, new Object[]{Integer.valueOf(r115)});
        L12:
            r101.f45567c = r117;
            if (r106 >= 10) goto L15;
            String r118 = th.a.h(r100, R.string.shopping_sec_kill_zero_placeholder, new Object[]{Integer.valueOf(r106)});
        L16:
            r101.f45568d = r118;
            if (r104 >= 10) goto L19;
            String r119 = th.a.h(r100, R.string.shopping_sec_kill_zero_placeholder, new Object[]{Integer.valueOf(r104)});
        L20:
            r101.f45569e = r119;
            String r120 = String.valueOf(r103);
            r101.f45570f = r120;
            if (r116 <= 0) goto L23;
            String r107 = th.a.h(r100, R.string.shopping_sec_kill_day_placeholder, new Object[]{Integer.valueOf(r116), r101.f45567c, r101.f45568d, r101.f45569e});
        L26:
            r101.f45571g = r107;
        L28:
            return r101;
        L23:
            if (r111 == false) goto L25;
            r107 = th.a.h(r100, R.string.shopping_sec_kill_time_with_ten_second_placeholder, new Object[]{r101.f45567c, r101.f45568d, r101.f45569e, r120});
            goto L26
        L25:
            r107 = th.a.h(r100, R.string.shopping_sec_kill_time_placeholder, new Object[]{r101.f45567c, r101.f45568d, r101.f45569e});
            goto L26
        L19:
            r119 = String.valueOf(r104);
            goto L20
        L15:
            r118 = String.valueOf(r106);
            goto L16
        L11:
            r117 = String.valueOf(r115);
            goto L12
        L27:
            r101.f45565a = 0;
            r101.f45566b = null;
            r101.f45567c = th.a.g(r100, R.string.shopping_sec_kill_time_error);
            r101.f45568d = th.a.g(r100, R.string.shopping_sec_kill_time_error);
            r101.f45569e = th.a.g(r100, R.string.shopping_sec_kill_time_error);
            goto L28
        }
    }

    static {
    }

    public c2() {
    }
}
