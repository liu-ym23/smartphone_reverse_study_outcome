package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomPublicScreenAttachments;", "", "()V", "anchorColdMsgShowOpt", "", "firstMessageShowOpt", "heightSetting", "hotMessageTray", "canShowHotMsgTray", "", "enableSettingHeight", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomPublicScreenAttachments implements h {
    public static final Companion Companion = null;
    public static final int STATUS_CLOSE = 2;
    public static final int STATUS_DEFAULT = 0;
    public static final int STATUS_OPEN = 1;

    @SerializedName("anchor_cold_message_show_opt")
    public int anchorColdMsgShowOpt;

    @SerializedName("first_message_show_opt")
    public int firstMessageShowOpt;

    @SerializedName("height_setting")
    public int heightSetting;

    @SerializedName("hot_message_tray")
    public int hotMessageTray;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomPublicScreenAttachments$Companion;", "", "()V", "STATUS_CLOSE", "", "STATUS_DEFAULT", "STATUS_OPEN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
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

    public RoomPublicScreenAttachments() {
    }

    public final boolean canShowHotMsgTray() {
        if (this.hotMessageTray == 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean enableSettingHeight() {
        if (this.heightSetting == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public RoomPublicScreenAttachments(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.hotMessageTray = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.heightSetting = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.firstMessageShowOpt = (int) r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.anchorColdMsgShowOpt = (int) r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
