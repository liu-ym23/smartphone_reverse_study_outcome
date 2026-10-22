package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum BMTrackType extends Enum<BMTrackType> {
    public static final BMTrackType Default3D = null;
    public static final BMTrackType Surface = null;
    public static final BMTrackType Track = null;
    public static final BMTrackType TrackGradient = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ BMTrackType[] f30660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30661b;

    static {
        BMTrackType r100 = new BMTrackType("Surface", 0, 3);
        Surface = r100;
        BMTrackType r101 = new BMTrackType("Default3D", 1, 4);
        Default3D = r101;
        BMTrackType r102 = new BMTrackType("Track", 2, 5);
        Track = r102;
        BMTrackType r103 = new BMTrackType("TrackGradient", 3, 6);
        TrackGradient = r103;
        f30660a = new BMTrackType[]{r100, r101, r102, r103};
    }

    public static BMTrackType[] values() {
        return (BMTrackType[]) f30660a.clone();
    }

    public int getType() {
        return this.f30661b;
    }

    public static BMTrackType valueOf(String r100) {
        return (BMTrackType) r27.a.a(BMTrackType.class, r100);
    }

    private BMTrackType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f30661b = r102;
    }
}
