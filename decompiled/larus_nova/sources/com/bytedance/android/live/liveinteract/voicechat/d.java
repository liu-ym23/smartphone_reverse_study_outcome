package com.bytedance.android.live.liveinteract.voicechat;

import android.content.Context;
import com.bytedance.android.live.liveinteract.linkbase.api.MediaOperation;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes46.dex */
public interface d extends IVoiceChatAdminService {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final a f80030s0 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f80031a = null;

        public a() {
        }

        static {
            f80031a = new a();
        }

        public static d a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d("audio_talk_context");
            if ((r100 instanceof VoiceChatAnchorDataContext) == true) goto L5;
            r100 = null;
        L5:
            VoiceChatAnchorDataContext r101 = (VoiceChatAnchorDataContext) r100;
            if (r101 == null) goto L11;
            com.bytedance.live.datacontext.j<d> r102 = r101.getService();
            if (r102 != null) goto L10;
            return null;
        L10:
            return r102.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(d r100) {
            r100.finishAudioTalk("link_icon");
        }
    }

    static {
        f80030s0 = a.f80031a;
    }

    void Gn();

    void Mi(int r100);

    com.bytedance.android.live.pushstream.d Ri();

    void Yi(v1 r100, String r101, String r102);

    tf0.o commonWindowManager();

    void continueAnchorLinkMic(int r100, com.bytedance.android.livesdk.message.linker.h r101);

    String currentCPositionChangeTrackData();

    int currentCPositionOpenSource();

    ILinkPlayerInfoBridge currentCPositionUser();

    String currentCPositionUserType();

    void finishAudioTalk(String r100);

    int getAnchorManualUiLayout();

    int getCurrentScene();

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    com.bytedance.android.live.liveinteract.voicechat.util.k getLogger();

    MixStreamType getMixStreamType();

    qj0.a getMultiLinkAudioLayoutService();

    int getSelfSilenceType();

    tf0.m getSwitchLayoutStatisticsUtils();

    JsonObject getTopLeftSeatFrameInfo();

    boolean isNewWidget();

    void onVoiceAnchorAvatarClicked();

    void replyCPosition(long r100, String r101, boolean r102);

    void switchVoiceSceneWithCheck(Context r100, String r101);

    void updateFullScreenDialogShowStatus(boolean r100);

    void updateSelfMuteStatus(boolean r100, boolean r101, MediaOperation.a r102);

    boolean userIsCPosition(String r100);

    rj0.h videoStylePaidLinkManager();
}
