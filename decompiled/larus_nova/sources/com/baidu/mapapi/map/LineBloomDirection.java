package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum LineBloomDirection extends Enum<LineBloomDirection> {
    public static final LineBloomDirection BloomAround = null;
    public static final LineBloomDirection BloomLeft = null;
    public static final LineBloomDirection BloomRight = null;
    public static final LineBloomDirection BloomUp = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ LineBloomDirection[] f31007a = null;

    static {
        LineBloomDirection r100 = new LineBloomDirection("BloomAround", 0);
        BloomAround = r100;
        LineBloomDirection r101 = new LineBloomDirection("BloomLeft", 1);
        BloomLeft = r101;
        LineBloomDirection r102 = new LineBloomDirection("BloomRight", 2);
        BloomRight = r102;
        LineBloomDirection r103 = new LineBloomDirection("BloomUp", 3);
        BloomUp = r103;
        f31007a = new LineBloomDirection[]{r100, r101, r102, r103};
    }

    public static LineBloomDirection[] values() {
        return (LineBloomDirection[]) f31007a.clone();
    }

    public static LineBloomDirection valueOf(String r100) {
        return (LineBloomDirection) r27.a.a(LineBloomDirection.class, r100);
    }

    private LineBloomDirection(String r100, int r101) {
        super(r100, r101);
    }
}
