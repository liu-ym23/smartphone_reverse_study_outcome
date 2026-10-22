package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: loaded from: classes39.dex */
public class BmLabelUI extends BmBaseUI {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f32866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private BmTextStyle f32867h;

    private static native long nativeCreate();

    private static native boolean nativeSetMaxLines(long r100, int r101);

    private static native boolean nativeSetMinLines(long r100, int r101);

    private static native boolean nativeSetStyle(long r100, long r101);

    private static native boolean nativeSetText(long r100, String r101);

    public BmLabelUI() {
        super(33, nativeCreate());
        this.f32866g = "";
    }

    public String b() {
        return this.f32866g;
    }

    public boolean a(BmTextStyle r100) {
        this.f32867h = r100;
        if (r100 == null) goto L7;
        return nativeSetStyle(this.nativeInstance, r100.getNativeInstance());
    L7:
        return nativeSetStyle(this.nativeInstance, 0);
    }

    public boolean b(String r100) {
        this.f32866g = r100;
        return nativeSetText(this.nativeInstance, r100);
    }

    public boolean j(int r100) {
        if (r100 > 0) goto L6;
        return false;
    L6:
        return nativeSetMaxLines(this.nativeInstance, r100);
    }
}
