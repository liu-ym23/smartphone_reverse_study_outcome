package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/remote/dsl/LabelMode;", "", "Append", "Replace", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum LabelMode extends Enum<LabelMode> {
    public static final LabelMode Append = null;
    public static final LabelMode Replace = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LabelMode[] f38177a = null;

    static {
        LabelMode r100 = new LabelMode("Append", 0);
        Append = r100;
        LabelMode r101 = new LabelMode("Replace", 1);
        Replace = r101;
        f38177a = new LabelMode[]{r100, r101};
    }

    public static LabelMode valueOf(String r100) {
        return (LabelMode) r27.a.a(LabelMode.class, r100);
    }

    public static LabelMode[] values() {
        return (LabelMode[]) f38177a.clone();
    }

    public LabelMode(String r100, int r101) {
        super(r100, r101);
    }
}
