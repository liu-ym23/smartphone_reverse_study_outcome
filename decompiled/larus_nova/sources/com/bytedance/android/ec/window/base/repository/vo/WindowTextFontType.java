package com.bytedance.android.ec.window.base.repository.vo;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/WindowTextFontType;", "", "", "type", "I", "getType", "()I", "DEFAULT", "DOUYIN_TEXT", "DOUYIN_NUMBER", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowTextFontType extends Enum<WindowTextFontType> {
    public static final WindowTextFontType DEFAULT = null;
    public static final WindowTextFontType DOUYIN_NUMBER = null;
    public static final WindowTextFontType DOUYIN_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowTextFontType[] f49461a = null;
    private final int type;

    static {
        WindowTextFontType r100 = new WindowTextFontType("DEFAULT", 0, 0);
        DEFAULT = r100;
        WindowTextFontType r101 = new WindowTextFontType("DOUYIN_TEXT", 1, 1);
        DOUYIN_TEXT = r101;
        WindowTextFontType r102 = new WindowTextFontType("DOUYIN_NUMBER", 2, 2);
        DOUYIN_NUMBER = r102;
        f49461a = new WindowTextFontType[]{r100, r101, r102};
    }

    public static WindowTextFontType valueOf(String r100) {
        return (WindowTextFontType) r27.a.a(WindowTextFontType.class, r100);
    }

    public static WindowTextFontType[] values() {
        return (WindowTextFontType[]) f49461a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public WindowTextFontType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
