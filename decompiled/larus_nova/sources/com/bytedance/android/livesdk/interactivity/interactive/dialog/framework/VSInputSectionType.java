package com.bytedance.android.livesdk.interactivity.interactive.dialog.framework;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.trace.ObricActionBarTrackType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/dialog/framework/VSInputSectionType;", "", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "EMPTY", "SHADOW", "CONTENT", "PUBLISH", "CONTROL_PORTRAIT", "KEYBOARD", "EMOJI", "PAID_LIVE_PACKAGE", "BOTTOM_TIP", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VSInputSectionType extends Enum<VSInputSectionType> {
    public static final VSInputSectionType BOTTOM_TIP = null;
    public static final VSInputSectionType CONTENT = null;
    public static final VSInputSectionType CONTROL_PORTRAIT = null;
    public static final VSInputSectionType EMOJI = null;
    public static final VSInputSectionType EMPTY = null;
    public static final VSInputSectionType KEYBOARD = null;
    public static final VSInputSectionType NONE = null;
    public static final VSInputSectionType PAID_LIVE_PACKAGE = null;
    public static final VSInputSectionType PUBLISH = null;
    public static final VSInputSectionType SHADOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VSInputSectionType[] f137232a = null;
    private final String typeName;

    public static VSInputSectionType valueOf(String r100) {
        return (VSInputSectionType) a.a(VSInputSectionType.class, r100);
    }

    public static VSInputSectionType[] values() {
        return (VSInputSectionType[]) f137232a.clone();
    }

    static {
        VSInputSectionType r100 = new VSInputSectionType(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        VSInputSectionType r101 = new VSInputSectionType("EMPTY", 1, "empty");
        EMPTY = r101;
        VSInputSectionType r102 = new VSInputSectionType("SHADOW", 2, GXViewKey.VIEW_TYPE_SHADOW_LAYOUT);
        SHADOW = r102;
        VSInputSectionType r103 = new VSInputSectionType("CONTENT", 3, "content");
        CONTENT = r103;
        VSInputSectionType r104 = new VSInputSectionType("PUBLISH", 4, "publish");
        PUBLISH = r104;
        VSInputSectionType r105 = new VSInputSectionType("CONTROL_PORTRAIT", 5, "control_portrait");
        CONTROL_PORTRAIT = r105;
        VSInputSectionType r106 = new VSInputSectionType("KEYBOARD", 6, ObricActionBarTrackType.KEY_BOARD);
        KEYBOARD = r106;
        VSInputSectionType r107 = new VSInputSectionType("EMOJI", 7, "emoji");
        EMOJI = r107;
        VSInputSectionType r108 = new VSInputSectionType("PAID_LIVE_PACKAGE", 8, "paid_live_package");
        PAID_LIVE_PACKAGE = r108;
        VSInputSectionType r109 = new VSInputSectionType("BOTTOM_TIP", 9, "bottom_tip");
        BOTTOM_TIP = r109;
        f137232a = new VSInputSectionType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public VSInputSectionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
