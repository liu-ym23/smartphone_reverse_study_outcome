package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public final enum TextureOption extends Enum<TextureOption> {
    public static final TextureOption Repeat = null;
    public static final TextureOption RepeatHalf = null;
    public static final TextureOption RoundHead = null;
    public static final TextureOption RoundTexture = null;
    public static final TextureOption ScaleTexture = null;
    public static final TextureOption SingleTexture = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ TextureOption[] f31461a = null;

    static {
        TextureOption r100 = new TextureOption("Repeat", 0);
        Repeat = r100;
        TextureOption r101 = new TextureOption("RoundHead", 1);
        RoundHead = r101;
        TextureOption r102 = new TextureOption("RoundTexture", 2);
        RoundTexture = r102;
        TextureOption r103 = new TextureOption("RepeatHalf", 3);
        RepeatHalf = r103;
        TextureOption r104 = new TextureOption("SingleTexture", 4);
        SingleTexture = r104;
        TextureOption r105 = new TextureOption("ScaleTexture", 5);
        ScaleTexture = r105;
        f31461a = new TextureOption[]{r100, r101, r102, r103, r104, r105};
    }

    public static TextureOption[] values() {
        return (TextureOption[]) f31461a.clone();
    }

    public static TextureOption valueOf(String r100) {
        return (TextureOption) r27.a.a(TextureOption.class, r100);
    }

    private TextureOption(String r100, int r101) {
        super(r100, r101);
    }
}
