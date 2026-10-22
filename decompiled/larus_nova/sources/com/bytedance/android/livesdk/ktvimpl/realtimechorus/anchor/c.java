package com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor;

import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessWidget;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget;
import com.bytedance.android.livesdk.message.linker.LinkmicInfoWithRtcInfoData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes10.dex */
public interface c extends com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b {
    public static final a W0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f146510a = null;

        public a() {
        }

        static {
            f146510a = new a();
        }

        public static c a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("real_time_chorus_anchor_context");
            if ((r100 instanceof RealTimeChorusAnchorDataContext) == true) goto L5;
            r100 = null;
        L5:
            RealTimeChorusAnchorDataContext r101 = (RealTimeChorusAnchorDataContext) r100;
            if (r101 == null) goto L11;
            j<c> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        W0 = a.f146510a;
    }

    void C3(RealTimeChorusBusinessWidget.h r100);

    void E4(RealTimeChorusBusinessWidget.h r100);

    void finishAudioTalk();

    int getSelfSilenceType();

    void j2(int r100, LinkmicInfoWithRtcInfoData r101);

    RealTimeChorusMainViewWidget u2();

    void zg(String r100, String r101);
}
