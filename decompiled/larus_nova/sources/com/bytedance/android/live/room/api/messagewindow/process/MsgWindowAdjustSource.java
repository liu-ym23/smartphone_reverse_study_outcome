package com.bytedance.android.live.room.api.messagewindow.process;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/process/MsgWindowAdjustSource;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "UNKNOWN", "VS_LANDSCAPE_MSG_BOARD", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MsgWindowAdjustSource extends Enum<MsgWindowAdjustSource> {
    public static final MsgWindowAdjustSource UNKNOWN = null;
    public static final MsgWindowAdjustSource VS_LANDSCAPE_MSG_BOARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MsgWindowAdjustSource[] f99027a = null;
    private final String description;

    static {
        MsgWindowAdjustSource r100 = new MsgWindowAdjustSource("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        MsgWindowAdjustSource r101 = new MsgWindowAdjustSource("VS_LANDSCAPE_MSG_BOARD", 1, "vsLandscapeMessageBoard");
        VS_LANDSCAPE_MSG_BOARD = r101;
        f99027a = new MsgWindowAdjustSource[]{r100, r101};
    }

    public static MsgWindowAdjustSource valueOf(String r100) {
        return (MsgWindowAdjustSource) a.a(MsgWindowAdjustSource.class, r100);
    }

    public static MsgWindowAdjustSource[] values() {
        return (MsgWindowAdjustSource[]) f99027a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public MsgWindowAdjustSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
