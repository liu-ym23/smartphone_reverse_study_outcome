package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum LogoPosition extends Enum<LogoPosition> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ LogoPosition[] f31013a = null;
    public static final LogoPosition logoPostionCenterBottom = null;
    public static final LogoPosition logoPostionCenterTop = null;
    public static final LogoPosition logoPostionRightBottom = null;
    public static final LogoPosition logoPostionRightTop = null;
    public static final LogoPosition logoPostionleftBottom = null;
    public static final LogoPosition logoPostionleftTop = null;

    static {
        LogoPosition r100 = new LogoPosition("logoPostionleftBottom", 0);
        logoPostionleftBottom = r100;
        LogoPosition r101 = new LogoPosition("logoPostionleftTop", 1);
        logoPostionleftTop = r101;
        LogoPosition r102 = new LogoPosition("logoPostionCenterBottom", 2);
        logoPostionCenterBottom = r102;
        LogoPosition r103 = new LogoPosition("logoPostionCenterTop", 3);
        logoPostionCenterTop = r103;
        LogoPosition r104 = new LogoPosition("logoPostionRightBottom", 4);
        logoPostionRightBottom = r104;
        LogoPosition r105 = new LogoPosition("logoPostionRightTop", 5);
        logoPostionRightTop = r105;
        f31013a = new LogoPosition[]{r100, r101, r102, r103, r104, r105};
    }

    public static LogoPosition[] values() {
        return (LogoPosition[]) f31013a.clone();
    }

    public static LogoPosition valueOf(String r100) {
        return (LogoPosition) r27.a.a(LogoPosition.class, r100);
    }

    private LogoPosition(String r100, int r101) {
        super(r100, r101);
    }
}
