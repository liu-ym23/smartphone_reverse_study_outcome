package com.bytedance.android.live.room.api.messagewindow.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/container/MsgWindowPosition;", "", "BOTTOM_RIGHT", "TOP_LEFT", "TOP_RIGHT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MsgWindowPosition extends Enum<MsgWindowPosition> {
    public static final MsgWindowPosition BOTTOM_RIGHT = null;
    public static final MsgWindowPosition TOP_LEFT = null;
    public static final MsgWindowPosition TOP_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MsgWindowPosition[] f98986a = null;

    static {
        MsgWindowPosition r100 = new MsgWindowPosition("BOTTOM_RIGHT", 0);
        BOTTOM_RIGHT = r100;
        MsgWindowPosition r101 = new MsgWindowPosition("TOP_LEFT", 1);
        TOP_LEFT = r101;
        MsgWindowPosition r102 = new MsgWindowPosition("TOP_RIGHT", 2);
        TOP_RIGHT = r102;
        f98986a = new MsgWindowPosition[]{r100, r101, r102};
    }

    public static MsgWindowPosition valueOf(String r100) {
        return (MsgWindowPosition) a.a(MsgWindowPosition.class, r100);
    }

    public static MsgWindowPosition[] values() {
        return (MsgWindowPosition[]) f98986a.clone();
    }

    public MsgWindowPosition(String r100, int r101) {
        super(r100, r101);
    }
}
