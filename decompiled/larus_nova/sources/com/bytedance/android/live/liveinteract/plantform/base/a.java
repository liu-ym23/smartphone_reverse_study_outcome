package com.bytedance.android.live.liveinteract.plantform.base;

import com.bytedance.android.live.liveinteract.plantform.AnchorRtcLinkerContext;
import com.bytedance.live.datacontext.DataContext;

/* JADX INFO: loaded from: classes46.dex */
public interface a {

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final C1183a f75481g0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.plantform.base.a$a, reason: collision with other inner class name */
    public static final class C1183a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1183a f75482a = null;

        public C1183a() {
        }

        static {
            f75482a = new C1183a();
        }

        public static a a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("rtc_anchor_linker_service");
            if ((r100 instanceof AnchorRtcLinkerContext) == true) goto L5;
            r100 = null;
        L5:
            AnchorRtcLinkerContext r101 = (AnchorRtcLinkerContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<a> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        f75481g0 = C1183a.f75482a;
    }

    hg6.g R1();
}
