package com.bytedance.android.gamecp.common.track.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/common/track/model/GPTrackAction;", "", "", "", "getIntValue", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "SHOW", "CLICK", "DURATION", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GPTrackAction extends Enum<GPTrackAction> {
    public static final GPTrackAction CLICK = null;
    public static final GPTrackAction DURATION = null;
    public static final GPTrackAction SHOW = null;
    public static final GPTrackAction UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GPTrackAction[] f56807a = null;
    private final String value;

    static {
        GPTrackAction r100 = new GPTrackAction("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        GPTrackAction r101 = new GPTrackAction("SHOW", 1, "show");
        SHOW = r101;
        GPTrackAction r102 = new GPTrackAction("CLICK", 2, "click");
        CLICK = r102;
        GPTrackAction r103 = new GPTrackAction("DURATION", 3, "duration");
        DURATION = r103;
        f56807a = new GPTrackAction[]{r100, r101, r102, r103};
    }

    public static GPTrackAction valueOf(String r100) {
        return (GPTrackAction) a.a(GPTrackAction.class, r100);
    }

    public static GPTrackAction[] values() {
        return (GPTrackAction[]) f56807a.clone();
    }

    public int getIntValue() {
        if (this != SHOW) goto L6;
        return 1;
    L6:
        if (this != DURATION) goto L9;
        return 2;
    L9:
        if (this != CLICK) goto L11;
        return 4;
    L11:
        return 0;
    }

    public final String getValue() {
        return this.value;
    }

    public GPTrackAction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
