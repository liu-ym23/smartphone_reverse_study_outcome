package com.bytedance.android.live.revlink.impl.rtc;

import com.bytedance.android.live.revlink.link.domain.anchorimpl.i;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import pc0.e;

/* JADX INFO: loaded from: classes47.dex */
public interface a extends i {
    public static final C1510a G0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.rtc.a$a, reason: collision with other inner class name */
    public static final class C1510a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C1510a f97512a = null;

        public C1510a() {
        }

        static {
            f97512a = new C1510a();
        }

        public static a a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("rtc_linker_service");
            if ((r100 instanceof RtcLinkerContext) == true) goto L5;
            r100 = null;
        L5:
            RtcLinkerContext r101 = (RtcLinkerContext) r100;
            if (r101 == null) goto L11;
            j<a> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        G0 = C1510a.f97512a;
    }

    e e();
}
