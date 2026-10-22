package com.airbnb.lottie.network;

/* JADX INFO: loaded from: classes.dex */
public final enum FileExtension extends Enum<FileExtension> {
    private static final /* synthetic */ FileExtension[] $VALUES = null;
    public static final FileExtension JSON = null;
    public static final FileExtension ZIP = null;
    public final String extension;

    private static /* synthetic */ FileExtension[] $values() {
        return new FileExtension[]{JSON, ZIP};
    }

    public static FileExtension valueOf(String r1) {
        return (FileExtension) Enum.valueOf(FileExtension.class, r1);
    }

    public static FileExtension[] values() {
        return (FileExtension[]) $VALUES.clone();
    }

    static {
        JSON = new FileExtension("JSON", 0, ".json");
        ZIP = new FileExtension("ZIP", 1, ".zip");
        $VALUES = $values();
    }

    private FileExtension(String r1, int r2, String r3) {
        super(r1, r2);
        this.extension = r3;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.extension;
    }
}
