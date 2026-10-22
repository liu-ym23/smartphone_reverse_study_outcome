package com.bytedance.android.annie.service.debug;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/service/debug/DebugTatPosition;", "", "TOP_LEFT", "TOP_RIGHT", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum DebugTatPosition extends Enum<DebugTatPosition> {
    public static final DebugTatPosition TOP_LEFT = null;
    public static final DebugTatPosition TOP_RIGHT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DebugTatPosition[] f39874a = null;

    public static DebugTatPosition valueOf(String r100) {
        return (DebugTatPosition) a.a(DebugTatPosition.class, r100);
    }

    public static DebugTatPosition[] values() {
        return (DebugTatPosition[]) f39874a.clone();
    }

    static {
        DebugTatPosition r100 = new DebugTatPosition("TOP_LEFT", 0);
        TOP_LEFT = r100;
        DebugTatPosition r101 = new DebugTatPosition("TOP_RIGHT", 1);
        TOP_RIGHT = r101;
        f39874a = new DebugTatPosition[]{r100, r101};
    }

    public DebugTatPosition(String r100, int r101) {
        super(r100, r101);
    }
}
