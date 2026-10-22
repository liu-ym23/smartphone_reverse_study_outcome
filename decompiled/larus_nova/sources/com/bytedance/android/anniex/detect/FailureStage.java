package com.bytedance.android.anniex.detect;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/anniex/detect/FailureStage;", "", "PixelCopy", "PureColorDetection", "PartialBlankDetection", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum FailureStage extends Enum<FailureStage> {
    public static final FailureStage PartialBlankDetection = null;
    public static final FailureStage PixelCopy = null;
    public static final FailureStage PureColorDetection = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FailureStage[] f40643a = null;

    public static FailureStage valueOf(String r100) {
        return (FailureStage) r27.a.a(FailureStage.class, r100);
    }

    public static FailureStage[] values() {
        return (FailureStage[]) f40643a.clone();
    }

    static {
        FailureStage r100 = new FailureStage("PixelCopy", 0);
        PixelCopy = r100;
        FailureStage r101 = new FailureStage("PureColorDetection", 1);
        PureColorDetection = r101;
        FailureStage r102 = new FailureStage("PartialBlankDetection", 2);
        PartialBlankDetection = r102;
        f40643a = new FailureStage[]{r100, r101, r102};
    }

    public FailureStage(String r100, int r101) {
        super(r100, r101);
    }
}
