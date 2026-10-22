package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/InputSectionType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "EMPTY", "SHADOW", "WORD_ASSOCIATE", "MENTION", "CHARGE", "CONTENT", "CONTROL_LANDSCAPE", "CONTROL_PORTRAIT", "KEYBOARD", "EMOJI", "QUICK_COMMENT", "DANMAKU", "AUDIO", "AUDIO2TEXT", "AUDIO_COMPOSE", "SEND_PORTRAIT", "VIDEO", "INTERACTIVITY_SHARE", "OGC_FIXED_INPUT", "FREQUENT_CHAT", "SECRET_CHAT", "MARK_HIGHLIGHT", "MORE", "INTEREST", "TRUTH", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InputSectionType extends Enum<InputSectionType> {
    public static final InputSectionType AUDIO = null;
    public static final InputSectionType AUDIO2TEXT = null;
    public static final InputSectionType AUDIO_COMPOSE = null;
    public static final InputSectionType CHARGE = null;
    public static final InputSectionType CONTENT = null;
    public static final InputSectionType CONTROL_LANDSCAPE = null;
    public static final InputSectionType CONTROL_PORTRAIT = null;
    public static final InputSectionType DANMAKU = null;
    public static final InputSectionType EMOJI = null;
    public static final InputSectionType EMPTY = null;
    public static final InputSectionType FREQUENT_CHAT = null;
    public static final InputSectionType INTERACTIVITY_SHARE = null;
    public static final InputSectionType INTEREST = null;
    public static final InputSectionType KEYBOARD = null;
    public static final InputSectionType MARK_HIGHLIGHT = null;
    public static final InputSectionType MENTION = null;
    public static final InputSectionType MORE = null;
    public static final InputSectionType NONE = null;
    public static final InputSectionType OGC_FIXED_INPUT = null;
    public static final InputSectionType QUICK_COMMENT = null;
    public static final InputSectionType SECRET_CHAT = null;
    public static final InputSectionType SEND_PORTRAIT = null;
    public static final InputSectionType SHADOW = null;
    public static final InputSectionType TRUTH = null;
    public static final InputSectionType VIDEO = null;
    public static final InputSectionType WORD_ASSOCIATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputSectionType[] f135444a = null;
    private final String typeName;

    public static InputSectionType valueOf(String r100) {
        return (InputSectionType) r27.a.a(InputSectionType.class, r100);
    }

    public static InputSectionType[] values() {
        return (InputSectionType[]) f135444a.clone();
    }

    static {
        InputSectionType r100 = new InputSectionType(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        InputSectionType r101 = new InputSectionType("EMPTY", 1, "empty");
        EMPTY = r101;
        InputSectionType r102 = new InputSectionType("SHADOW", 2, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
        SHADOW = r102;
        InputSectionType r103 = new InputSectionType("WORD_ASSOCIATE", 3, "word_associate");
        WORD_ASSOCIATE = r103;
        InputSectionType r104 = new InputSectionType("MENTION", 4, "mention");
        MENTION = r104;
        InputSectionType r105 = new InputSectionType("CHARGE", 5, "charge");
        CHARGE = r105;
        InputSectionType r106 = new InputSectionType("CONTENT", 6, "content");
        CONTENT = r106;
        InputSectionType r107 = new InputSectionType("CONTROL_LANDSCAPE", 7, "control_landscape");
        CONTROL_LANDSCAPE = r107;
        InputSectionType r108 = new InputSectionType("CONTROL_PORTRAIT", 8, "control_portrait");
        CONTROL_PORTRAIT = r108;
        InputSectionType r109 = new InputSectionType("KEYBOARD", 9, ObricActionBarTrackType.KEY_BOARD);
        KEYBOARD = r109;
        InputSectionType r110 = new InputSectionType("EMOJI", 10, "emoji");
        EMOJI = r110;
        InputSectionType r111 = new InputSectionType("QUICK_COMMENT", 11, "quick_comment");
        QUICK_COMMENT = r111;
        InputSectionType r112 = new InputSectionType("DANMAKU", 12, PbRequest.SwitchType.SCREEN_CHAT);
        DANMAKU = r112;
        InputSectionType r113 = new InputSectionType("AUDIO", 13, "audio");
        AUDIO = r113;
        InputSectionType r114 = new InputSectionType("AUDIO2TEXT", 14, "audio_to_text");
        AUDIO2TEXT = r114;
        InputSectionType r115 = new InputSectionType("AUDIO_COMPOSE", 15, "audio_compose");
        AUDIO_COMPOSE = r115;
        InputSectionType r116 = new InputSectionType("SEND_PORTRAIT", 16, "send_portrait");
        SEND_PORTRAIT = r116;
        InputSectionType r117 = new InputSectionType("VIDEO", 17, "video");
        VIDEO = r117;
        InputSectionType r118 = new InputSectionType("INTERACTIVITY_SHARE", 18, "interactivity_share");
        INTERACTIVITY_SHARE = r118;
        InputSectionType r119 = new InputSectionType("OGC_FIXED_INPUT", 19, "ogc_fixed_comment");
        OGC_FIXED_INPUT = r119;
        InputSectionType r120 = new InputSectionType("FREQUENT_CHAT", 20, "frequent_comment");
        FREQUENT_CHAT = r120;
        InputSectionType r121 = new InputSectionType("SECRET_CHAT", 21, IMessageResourcePreloadTask.Scene.SECRET_CHAT);
        SECRET_CHAT = r121;
        InputSectionType r122 = new InputSectionType("MARK_HIGHLIGHT", 22, "mark_highlight");
        MARK_HIGHLIGHT = r122;
        InputSectionType r123 = new InputSectionType("MORE", 23, "more");
        MORE = r123;
        InputSectionType r124 = new InputSectionType("INTEREST", 24, "interest");
        INTEREST = r124;
        InputSectionType r125 = new InputSectionType("TRUTH", 25, "truth");
        TRUTH = r125;
        f135444a = new InputSectionType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public InputSectionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
