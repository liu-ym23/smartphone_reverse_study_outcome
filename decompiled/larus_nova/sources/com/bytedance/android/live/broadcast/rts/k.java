package com.bytedance.android.live.broadcast.rts;

import com.ss.android.agilelogger.ALog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f59219a = 0;

    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            int r101 = com.bytedance.salamander.bdfoundation.a.f268546a;
            String r102 = "[ERROR]: " + r100;
            Intrinsics.checkNotNullParameter("rts_anchor_status_rts", "tag");
            Intrinsics.checkNotNullParameter(r102, "msg");
            ALog.e("rts_anchor_status_rts", r102);
        }

        public static void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            int r101 = com.bytedance.salamander.bdfoundation.a.f268546a;
            String r102 = "[I]: " + r100;
            Intrinsics.checkNotNullParameter("rts_anchor_status_rts", "tag");
            Intrinsics.checkNotNullParameter(r102, "msg");
            ALog.i("rts_anchor_status_rts", r102);
        }

        public static void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            int r101 = com.bytedance.salamander.bdfoundation.a.f268546a;
            String r102 = "[WARN]: " + r100;
            Intrinsics.checkNotNullParameter("rts_anchor_status_rts", "tag");
            Intrinsics.checkNotNullParameter(r102, "msg");
            ALog.w("rts_anchor_status_rts", r102);
        }
    }

    static {
    }
}
