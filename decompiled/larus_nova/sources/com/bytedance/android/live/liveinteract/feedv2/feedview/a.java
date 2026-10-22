package com.bytedance.android.live.liveinteract.feedv2.feedview;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.message.model.cj;
import com.bytedance.android.livesdk.message.model.qb;
import com.bytedance.android.livesdkapi.depend.message.RoomLinkMicSyncData;
import com.bytedance.android.livesdkapi.feed.data.IPreviewMultiLinkOuterConfigProvider;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public interface a {
    void b(String r100, Object r101);

    void e(String r100);

    void f(qb r100);

    String getFeedViewName();

    FrameLayout.LayoutParams getKtvComponentLayoutParams();

    View getViewCompat();

    void h(SeiAppData r100);

    void insertEffectView(View r100, int r101);

    void j(cj r100);

    void m(int r100, int r101, List<Integer> r102);

    void o(IPreviewMultiLinkOuterConfigProvider r100, te0.a r101);

    void onLivePlayerVideoSizeChanged();

    void onViewHolderPause();

    void onViewHolderResume();

    void onViewHolderSelected();

    void onViewHolderUnSelected();

    void release();

    void removeEffectView();

    void s();

    void updateMvControllerSei(String r100);

    void updatePreloadRoomLinkMicSyncData(RoomLinkMicSyncData r100);

    void updateRadioSei(JSONObject r100);

    void updateRadioTextSei(JSONObject r100);

    void updateSpeechRecognitionSei(String r100);

    void updateSpeechRhythmSei(String r100);

    void updateSubtitleSei(String r100);
}
