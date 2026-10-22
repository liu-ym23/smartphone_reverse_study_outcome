package com.android.ttcjpaysdk.ocr.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/data/OCRType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "DetectAndRecognize", "NativeRecognize", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum OCRType extends Enum<OCRType> {
    private static final /* synthetic */ OCRType[] $VALUES = null;
    public static final OCRType Default = null;
    public static final OCRType DetectAndRecognize = null;
    public static final OCRType NativeRecognize = null;
    private final int value;

    private static final /* synthetic */ OCRType[] $values() {
        return new OCRType[]{Default, DetectAndRecognize, NativeRecognize};
    }

    public static OCRType valueOf(String r100) {
        return (OCRType) a.a(OCRType.class, r100);
    }

    public static OCRType[] values() {
        return (OCRType[]) $VALUES.clone();
    }

    static {
        Default = new OCRType("Default", 0, 0);
        DetectAndRecognize = new OCRType("DetectAndRecognize", 1, 1);
        NativeRecognize = new OCRType("NativeRecognize", 2, 2);
        $VALUES = $values();
    }

    public final int getValue() {
        return this.value;
    }

    private OCRType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
