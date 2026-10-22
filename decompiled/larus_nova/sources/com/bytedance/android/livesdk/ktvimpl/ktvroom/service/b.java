package com.bytedance.android.livesdk.ktvimpl.ktvroom.service;

import android.content.Context;
import com.bytedance.android.livesdk.message.linker.LinkmicInfoWithRtcInfoData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;

/* JADX INFO: loaded from: classes10.dex */
public interface b extends com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a {
    public static final a T0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f144834a = null;

        public a() {
        }

        static {
            f144834a = new a();
        }

        public static b a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("ktv_room_anchor_context");
            if ((r100 instanceof KtvAnchorDataContext) == true) goto L5;
            r100 = null;
        L5:
            KtvAnchorDataContext r101 = (KtvAnchorDataContext) r100;
            if (r101 == null) goto L11;
            j<b> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    static {
        T0 = a.f144834a;
    }

    void finishAudioTalk();

    int getSelfSilenceType();

    void j2(int r100, LinkmicInfoWithRtcInfoData r101);

    void switchScene(int r100, int r101, int r102, String r103);

    void switchVoiceSceneWithCheck(Context r100, String r101);
}
