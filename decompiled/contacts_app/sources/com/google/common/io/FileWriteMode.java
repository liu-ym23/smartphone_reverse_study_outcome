package com.google.common.io;

/* JADX INFO: loaded from: classes2.dex */
public final enum FileWriteMode extends Enum<FileWriteMode> {
    private static final /* synthetic */ FileWriteMode[] $VALUES = null;
    public static final FileWriteMode APPEND = null;

    private FileWriteMode(String r1, int r2) {
        super(r1, r2);
    }

    public static FileWriteMode valueOf(String r1) {
        return (FileWriteMode) Enum.valueOf(FileWriteMode.class, r1);
    }

    public static FileWriteMode[] values() {
        return (FileWriteMode[]) $VALUES.clone();
    }

    static {
        FileWriteMode r0 = new FileWriteMode("APPEND", 0);
        APPEND = r0;
        $VALUES = new FileWriteMode[]{r0};
    }
}
