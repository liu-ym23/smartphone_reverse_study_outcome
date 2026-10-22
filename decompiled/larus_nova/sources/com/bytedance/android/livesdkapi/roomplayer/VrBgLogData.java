package com.bytedance.android.livesdkapi.roomplayer;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/VrBgLogData;", "", "roomEntered", "", "firstFrameRendered", "bgRendered", "extra", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(ZZZLjava/util/HashMap;)V", "getBgRendered", "()Z", "getExtra", "()Ljava/util/HashMap;", "getFirstFrameRendered", "getRoomEntered", "toString", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VrBgLogData {
    public static final Companion Companion = null;
    public static final String KEY_1K_BG_RENDER_END_TIME = "1k_bg_render_end_time";
    public static final String KEY_ANCHOR_ID = "anchor_id";
    public static final String KEY_BG_RENDER_END_TIME = "bg_render_end_time";
    public static final String KEY_DURATION = "duration";
    public static final String KEY_DURATION_1K = "duration_1k";
    public static final String KEY_ENTER_DURATION = "enter_duration";
    public static final String KEY_ENTER_FROM_MERGE = "enter_from_merge";
    public static final String KEY_ENTER_FROM_PREVIEW = "enter_from_preview";
    public static final String KEY_ENTER_METHOD = "enter_method";
    public static final String KEY_IMAGE_TYPE = "image_type";
    public static final String KEY_IS_PREVIEW = "is_preview";
    public static final String KEY_PREVIEW_RENDER_START_TIME = "preview_render_start_time";
    public static final String KEY_ROOM_ID = "room_id";
    public static final String KEY_VR_SUB_TYPE = "vr_sub_type";
    public static final String KEY_VR_TYPE = "vr_type";
    public static final String KEY_VR_VIEW = "vr_view";
    public static final String VR_BG_EVENT_NAME = "livesdk_virtual_live_background_duration";
    private final boolean bgRendered;
    private final HashMap<String, String> extra;
    private final boolean firstFrameRendered;
    private final boolean roomEntered;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/VrBgLogData$Companion;", "", "()V", "KEY_1K_BG_RENDER_END_TIME", "", "KEY_ANCHOR_ID", "KEY_BG_RENDER_END_TIME", "KEY_DURATION", "KEY_DURATION_1K", "KEY_ENTER_DURATION", "KEY_ENTER_FROM_MERGE", "KEY_ENTER_FROM_PREVIEW", "KEY_ENTER_METHOD", "KEY_IMAGE_TYPE", "KEY_IS_PREVIEW", "KEY_PREVIEW_RENDER_START_TIME", "KEY_ROOM_ID", "KEY_VR_SUB_TYPE", "KEY_VR_TYPE", "KEY_VR_VIEW", "VR_BG_EVENT_NAME", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VrBgLogData() {
        this(false, false, false, null, 15, null);
    }

    public String toString() {
        return "VrBgLogData(roomEntered=" + this.roomEntered + ", firstFrameRendered=" + this.firstFrameRendered + ", bgRendered=" + this.bgRendered + ", extra=" + this.extra + ')';
    }

    public final boolean getBgRendered() {
        return this.bgRendered;
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final boolean getFirstFrameRendered() {
        return this.firstFrameRendered;
    }

    public final boolean getRoomEntered() {
        return this.roomEntered;
    }

    public VrBgLogData(boolean r100, boolean r101, boolean r102, HashMap<String, String> r103) {
        Intrinsics.checkNotNullParameter(r103, "extra");
        this.roomEntered = r100;
        this.firstFrameRendered = r101;
        this.bgRendered = r102;
        this.extra = r103;
    }

    public /* synthetic */ VrBgLogData(boolean r100, boolean r101, boolean r102, HashMap r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = new HashMap();
    L14:
        this(r100, r101, r102, r103);
    }
}
