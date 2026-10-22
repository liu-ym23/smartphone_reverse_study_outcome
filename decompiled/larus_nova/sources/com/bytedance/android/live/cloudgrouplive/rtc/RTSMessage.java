package com.bytedance.android.live.cloudgrouplive.rtc;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/rtc/RTSMessage;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "UPDATE_AUDIO", "SYNC_VIEW_DISPLAY", "TRANSFER_VIEW", "UPDATE_VIEW_DISPLAY", "SYNC_STICKER", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RTSMessage extends Enum<RTSMessage> {
    public static final RTSMessage SYNC_STICKER = null;
    public static final RTSMessage SYNC_VIEW_DISPLAY = null;
    public static final RTSMessage TRANSFER_VIEW = null;
    public static final RTSMessage UPDATE_AUDIO = null;
    public static final RTSMessage UPDATE_VIEW_DISPLAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RTSMessage[] f64478a = null;
    private final String des;

    static {
        RTSMessage r100 = new RTSMessage("UPDATE_AUDIO", 0, "update_audio");
        UPDATE_AUDIO = r100;
        RTSMessage r101 = new RTSMessage("SYNC_VIEW_DISPLAY", 1, "sync_view_display");
        SYNC_VIEW_DISPLAY = r101;
        RTSMessage r102 = new RTSMessage("TRANSFER_VIEW", 2, "transfer_view");
        TRANSFER_VIEW = r102;
        RTSMessage r103 = new RTSMessage("UPDATE_VIEW_DISPLAY", 3, "update_view_display");
        UPDATE_VIEW_DISPLAY = r103;
        RTSMessage r104 = new RTSMessage("SYNC_STICKER", 4, "sync_sticker");
        SYNC_STICKER = r104;
        f64478a = new RTSMessage[]{r100, r101, r102, r103, r104};
    }

    public static RTSMessage valueOf(String r100) {
        return (RTSMessage) r27.a.a(RTSMessage.class, r100);
    }

    public static RTSMessage[] values() {
        return (RTSMessage[]) f64478a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public RTSMessage(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }
}
