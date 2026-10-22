package com.bytedance.android.live.livepkaudience.service;

import com.bytedance.android.live.livepkaudience.PkGuestRtcLinkerContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes46.dex */
public interface f {

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final a f82256z0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f82257a = null;

        public a() {
        }

        static {
            f82257a = new a();
        }

        public static f a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("pk_guest_rtc_linker_service");
            if ((r100 instanceof PkGuestRtcLinkerContext) == true) goto L5;
            r100 = null;
        L5:
            PkGuestRtcLinkerContext r101 = (PkGuestRtcLinkerContext) r100;
            if (r101 == null) goto L11;
            j<f> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f82256z0 = a.f82257a;
    }

    com.bytedance.android.live.livepkaudience.rtc.a P2();
}
