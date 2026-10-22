package com.bytedance.android.livesdkapi.ktv;

import com.bytedance.android.livesdk.chatroom.model.f1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class KTVRoomFeedModel implements f1 {
    public String animatedBackground;
    public int bgType;
    public String effectAvatarTalk;
    public String emptyEndColor;
    public String emptyStartColor;
    public int enhanceMidiMode;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public long f162631id;
    public String imageColdBg;
    public String imageThumbnail;
    public int imageType;
    public String imageUri;
    public Map<String, Long> linkerMap;
    long ownerUserId;
    public String ownerUserIdString;
    public List<Long> playModes;
    public String publicScreenColorValue;
    public IRoom room;
    public long roomId;
    public String singleStaticBackground;
    public String statusColorValue;
    public int timeLimit;

    public KTVRoomFeedModel() {
        this.room = null;
        this.enhanceMidiMode = 0;
    }
}
