package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.liveinteract.plantform.GuestRtcLinkerContext;
import com.bytedance.live.datacontext.DataContext;
import hh1.v0;

/* JADX INFO: loaded from: classes46.dex */
public interface b {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final a f75483h0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f75484a = null;

        public a() {
        }

        static {
            f75484a = new a();
        }

        public static b a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("guest_rtc_linker_service");
            if ((r100 instanceof GuestRtcLinkerContext) == true) goto L5;
            r100 = null;
        L5:
            GuestRtcLinkerContext r101 = (GuestRtcLinkerContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<b> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f75483h0 = a.f75484a;
    }

    hg6.g P2();

    ei6.a V0();

    v0 getLiveVideoClientFactory();
}
