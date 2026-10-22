package com.bytedance.android.livesdk.interactivity.comment.input.framework;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/framework/PanelType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "KEYBOARD", "RIGHTS", "EMOJI", "SCREEN_CHAT", "RECOMMEND_EMOJI", "VIDEO_COMMENT", "AUDIO_COMMENT", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelType extends Enum<PanelType> {
    public static final PanelType AUDIO_COMMENT = null;
    public static final PanelType EMOJI = null;
    public static final PanelType KEYBOARD = null;
    public static final PanelType NONE = null;
    public static final PanelType RECOMMEND_EMOJI = null;
    public static final PanelType RIGHTS = null;
    public static final PanelType SCREEN_CHAT = null;
    public static final PanelType VIDEO_COMMENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelType[] f135165a = null;
    private final String typeName;

    public static PanelType valueOf(String r100) {
        return (PanelType) a.a(PanelType.class, r100);
    }

    public static PanelType[] values() {
        return (PanelType[]) f135165a.clone();
    }

    static {
        PanelType r100 = new PanelType(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        PanelType r101 = new PanelType("KEYBOARD", 1, ObricActionBarTrackType.KEY_BOARD);
        KEYBOARD = r101;
        PanelType r102 = new PanelType("RIGHTS", 2, "rights");
        RIGHTS = r102;
        PanelType r103 = new PanelType("EMOJI", 3, "emoji");
        EMOJI = r103;
        PanelType r104 = new PanelType("SCREEN_CHAT", 4, PbRequest.SwitchType.SCREEN_CHAT);
        SCREEN_CHAT = r104;
        PanelType r105 = new PanelType("RECOMMEND_EMOJI", 5, "recommend emoji");
        RECOMMEND_EMOJI = r105;
        PanelType r106 = new PanelType("VIDEO_COMMENT", 6, "video_comment");
        VIDEO_COMMENT = r106;
        PanelType r107 = new PanelType("AUDIO_COMMENT", 7, "audio_comment");
        AUDIO_COMMENT = r107;
        f135165a = new PanelType[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public PanelType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
