package com.google.zxing;

import com.android.vcard.VCardConstants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final enum DecodeHintType extends Enum<DecodeHintType> {
    private static final /* synthetic */ DecodeHintType[] $VALUES = null;
    public static final DecodeHintType ALLOWED_EAN_EXTENSIONS = null;
    public static final DecodeHintType ALLOWED_LENGTHS = null;
    public static final DecodeHintType ASSUME_CODE_39_CHECK_DIGIT = null;
    public static final DecodeHintType ASSUME_GS1 = null;
    public static final DecodeHintType CHARACTER_SET = null;
    public static final DecodeHintType NEED_RESULT_POINT_CALLBACK = null;
    public static final DecodeHintType OTHER = null;
    public static final DecodeHintType POSSIBLE_FORMATS = null;
    public static final DecodeHintType PURE_BARCODE = null;
    public static final DecodeHintType RETURN_CODABAR_START_END = null;
    public static final DecodeHintType TRY_HARDER = null;
    private final Class<?> valueType;

    public static DecodeHintType valueOf(String r1) {
        return (DecodeHintType) Enum.valueOf(DecodeHintType.class, r1);
    }

    public static DecodeHintType[] values() {
        return (DecodeHintType[]) $VALUES.clone();
    }

    static {
        DecodeHintType r0 = new DecodeHintType(VCardConstants.PARAM_PHONE_EXTRA_TYPE_OTHER, 0, Object.class);
        OTHER = r0;
        DecodeHintType r1 = new DecodeHintType("PURE_BARCODE", 1, Void.class);
        PURE_BARCODE = r1;
        DecodeHintType r2 = new DecodeHintType("POSSIBLE_FORMATS", 2, List.class);
        POSSIBLE_FORMATS = r2;
        DecodeHintType r4 = new DecodeHintType("TRY_HARDER", 3, Void.class);
        TRY_HARDER = r4;
        DecodeHintType r6 = new DecodeHintType("CHARACTER_SET", 4, String.class);
        CHARACTER_SET = r6;
        DecodeHintType r8 = new DecodeHintType("ALLOWED_LENGTHS", 5, int[].class);
        ALLOWED_LENGTHS = r8;
        DecodeHintType r10 = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", 6, Void.class);
        ASSUME_CODE_39_CHECK_DIGIT = r10;
        DecodeHintType r14 = new DecodeHintType("ASSUME_GS1", 7, Void.class);
        ASSUME_GS1 = r14;
        DecodeHintType r12 = new DecodeHintType("RETURN_CODABAR_START_END", 8, Void.class);
        RETURN_CODABAR_START_END = r12;
        DecodeHintType r11 = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", 9, ResultPointCallback.class);
        NEED_RESULT_POINT_CALLBACK = r11;
        DecodeHintType r9 = new DecodeHintType("ALLOWED_EAN_EXTENSIONS", 10, int[].class);
        ALLOWED_EAN_EXTENSIONS = r9;
        $VALUES = new DecodeHintType[]{r0, r1, r2, r4, r6, r8, r10, r14, r12, r11, r9};
    }

    private DecodeHintType(String r1, int r2, Class r3) {
        super(r1, r2);
        this.valueType = r3;
    }

    public Class<?> getValueType() {
        return this.valueType;
    }
}
