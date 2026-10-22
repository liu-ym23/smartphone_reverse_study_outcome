package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public final enum FileWriteMode extends Enum<FileWriteMode> {
    private static final /* synthetic */ FileWriteMode[] $VALUES = null;
    public static final FileWriteMode APPEND = null;

    static {
        FileWriteMode r10 = new FileWriteMode("APPEND", 0);
        APPEND = r10;
        $VALUES = new FileWriteMode[]{r10};
    }

    private FileWriteMode(String r10, int r11) {
        super(r10, r11);
    }

    public static FileWriteMode valueOf(String r10) {
        return (FileWriteMode) Enum.valueOf(FileWriteMode.class, r10);
    }

    public static FileWriteMode[] values() {
        return (FileWriteMode[]) $VALUES.clone();
    }
}
