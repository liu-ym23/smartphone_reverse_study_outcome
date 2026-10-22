package com.bytedance.android.shopping.api.video;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/api/video/CodecType;", "", "CODEC_TYPE_264", "CODEC_TYPE_265", "CODEC_TYPE_266", "CODEC_TYPE_AV1", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CodecType extends Enum<CodecType> {
    public static final CodecType CODEC_TYPE_264 = null;
    public static final CodecType CODEC_TYPE_265 = null;
    public static final CodecType CODEC_TYPE_266 = null;
    public static final CodecType CODEC_TYPE_AV1 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CodecType[] f170616a = null;

    static {
        CodecType r100 = new CodecType("CODEC_TYPE_264", 0);
        CODEC_TYPE_264 = r100;
        CodecType r101 = new CodecType("CODEC_TYPE_265", 1);
        CODEC_TYPE_265 = r101;
        CodecType r102 = new CodecType("CODEC_TYPE_266", 2);
        CODEC_TYPE_266 = r102;
        CodecType r103 = new CodecType("CODEC_TYPE_AV1", 3);
        CODEC_TYPE_AV1 = r103;
        f170616a = new CodecType[]{r100, r101, r102, r103};
    }

    public static CodecType valueOf(String r100) {
        return (CodecType) r27.a.a(CodecType.class, r100);
    }

    public static CodecType[] values() {
        return (CodecType[]) f170616a.clone();
    }

    public CodecType(String r100, int r101) {
        super(r100, r101);
    }
}
