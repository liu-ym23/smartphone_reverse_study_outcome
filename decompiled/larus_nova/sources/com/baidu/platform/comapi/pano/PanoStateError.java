package com.baidu.platform.comapi.pano;

/* JADX INFO: loaded from: classes39.dex */
public final enum PanoStateError extends Enum<PanoStateError> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PanoStateError f33370a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PanoStateError f33371b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PanoStateError f33372c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final PanoStateError f33373d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ PanoStateError[] f33374e = null;

    static {
        PanoStateError r100 = new PanoStateError("PANO_NO_ERROR", 0);
        f33370a = r100;
        PanoStateError r101 = new PanoStateError("PANO_UID_ERROR", 1);
        f33371b = r101;
        PanoStateError r102 = new PanoStateError("PANO_NOT_FOUND", 2);
        f33372c = r102;
        PanoStateError r103 = new PanoStateError("PANO_NO_TOKEN", 3);
        f33373d = r103;
        f33374e = new PanoStateError[]{r100, r101, r102, r103};
    }

    public static PanoStateError[] values() {
        return (PanoStateError[]) f33374e.clone();
    }

    public static PanoStateError valueOf(String r100) {
        return (PanoStateError) r27.a.a(PanoStateError.class, r100);
    }

    private PanoStateError(String r100, int r101) {
        super(r100, r101);
    }
}
