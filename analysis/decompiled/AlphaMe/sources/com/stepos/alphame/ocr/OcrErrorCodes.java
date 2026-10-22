package com.stepos.alphame.ocr;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/ocr/OcrErrorCodes;", "", "()V", "BUSY", "", "DECODE_FAIL", "MAP_FAIL", "NOT_IMPLEMENTED", "NOT_READY", "OK", "RUN_FAIL", "TIMEOUT", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OcrErrorCodes {
    public static final int BUSY = -11;
    public static final int DECODE_FAIL = -12;

    @NotNull
    public static final OcrErrorCodes INSTANCE = new OcrErrorCodes();
    public static final int MAP_FAIL = -14;
    public static final int NOT_IMPLEMENTED = -16;
    public static final int NOT_READY = -10;
    public static final int OK = 1;
    public static final int RUN_FAIL = -13;
    public static final int TIMEOUT = -15;

    private OcrErrorCodes() {
    }
}
