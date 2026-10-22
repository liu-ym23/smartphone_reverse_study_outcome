package com.bytedance.ai.view.popup.anim;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/view/popup/anim/AnimationStyle;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", GXAnimation.STATE_START, GXAnimation.STATE_END, "LEFT", "RIGHT", "ZOOM", "SLIDE", "AUTO", UserProfileEvent.POSITION_NONE, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AnimationStyle extends Enum<AnimationStyle> {
    public static final AnimationStyle AUTO = null;
    public static final AnimationStyle END = null;
    public static final AnimationStyle LEFT = null;
    public static final AnimationStyle NONE = null;
    public static final AnimationStyle RIGHT = null;
    public static final AnimationStyle SLIDE = null;
    public static final AnimationStyle START = null;
    public static final AnimationStyle ZOOM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationStyle[] f37831a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f37832b = null;
    private final String value;

    public static EnumEntries<AnimationStyle> getEntries() {
        return f37832b;
    }

    static {
        AnimationStyle r100 = new AnimationStyle(GXAnimation.STATE_START, 0, "start");
        START = r100;
        AnimationStyle r101 = new AnimationStyle(GXAnimation.STATE_END, 1, "end");
        END = r101;
        AnimationStyle r102 = new AnimationStyle("LEFT", 2, "left");
        LEFT = r102;
        AnimationStyle r103 = new AnimationStyle("RIGHT", 3, "right");
        RIGHT = r103;
        AnimationStyle r104 = new AnimationStyle("ZOOM", 4, GestureAction.zoom);
        ZOOM = r104;
        AnimationStyle r105 = new AnimationStyle("SLIDE", 5, "slide");
        SLIDE = r105;
        AnimationStyle r110 = new AnimationStyle("AUTO", 6, "auto");
        AUTO = r110;
        AnimationStyle r111 = new AnimationStyle(UserProfileEvent.POSITION_NONE, 7, "none");
        NONE = r111;
        AnimationStyle[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f37831a = r112;
        f37832b = EnumEntriesKt.enumEntries(r112);
    }

    public static AnimationStyle[] values() {
        return (AnimationStyle[]) f37831a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AnimationStyle valueOf(String r100) {
        return (AnimationStyle) r27.a.a(AnimationStyle.class, r100);
    }

    public AnimationStyle(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
