package com.byted.cast.mediacommon.render.parameters;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum CodecId extends Enum<CodecId> {
    private static final /* synthetic */ CodecId[] $VALUES = null;
    public static final CodecId AACELD = null;
    public static final CodecId AACLC = null;
    public static final CodecId ALAC = null;
    public static final CodecId H264 = null;
    public static final CodecId H265 = null;
    public static final CodecId PCM = null;

    static {
        CodecId r100 = new CodecId("H264", 0);
        H264 = r100;
        CodecId r101 = new CodecId("H265", 1);
        H265 = r101;
        CodecId r102 = new CodecId("PCM", 2);
        PCM = r102;
        CodecId r103 = new CodecId("ALAC", 3);
        ALAC = r103;
        CodecId r104 = new CodecId("AACLC", 4);
        AACLC = r104;
        CodecId r105 = new CodecId("AACELD", 5);
        AACELD = r105;
        $VALUES = new CodecId[]{r100, r101, r102, r103, r104, r105};
    }

    public static CodecId[] values() {
        return (CodecId[]) $VALUES.clone();
    }

    public static CodecId valueOf(String r100) {
        return (CodecId) a.a(CodecId.class, r100);
    }

    private CodecId(String r100, int r101) {
        super(r100, r101);
    }
}
