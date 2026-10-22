package com.bytedance.android.livesdk.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/utils/HTSLiveMaskBrightnessMode;", "", "", "value", "I", "getValue", "()I", "None", "Min", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HTSLiveMaskBrightnessMode extends Enum<HTSLiveMaskBrightnessMode> {
    public static final HTSLiveMaskBrightnessMode Min = null;
    public static final HTSLiveMaskBrightnessMode None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HTSLiveMaskBrightnessMode[] f158749a = null;
    private final int value;

    static {
        HTSLiveMaskBrightnessMode r100 = new HTSLiveMaskBrightnessMode("None", 0, 0);
        None = r100;
        HTSLiveMaskBrightnessMode r101 = new HTSLiveMaskBrightnessMode("Min", 1, 1);
        Min = r101;
        f158749a = new HTSLiveMaskBrightnessMode[]{r100, r101};
    }

    public static HTSLiveMaskBrightnessMode valueOf(String r100) {
        return (HTSLiveMaskBrightnessMode) r27.a.a(HTSLiveMaskBrightnessMode.class, r100);
    }

    public static HTSLiveMaskBrightnessMode[] values() {
        return (HTSLiveMaskBrightnessMode[]) f158749a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public HTSLiveMaskBrightnessMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
