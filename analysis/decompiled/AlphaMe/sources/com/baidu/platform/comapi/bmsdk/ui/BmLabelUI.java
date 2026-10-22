package com.baidu.platform.comapi.bmsdk.ui;

import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* loaded from: classes.dex */
public class BmLabelUI extends BmBaseUI {

    /* renamed from: g, reason: collision with root package name */
    private String f8726g;

    /* renamed from: h, reason: collision with root package name */
    private BmTextStyle f8727h;

    public BmLabelUI() {
        super(33, nativeCreate());
        this.f8726g = "";
    }

    private static native long nativeCreate();

    private static native boolean nativeSetMaxLines(long j4, int i4);

    private static native boolean nativeSetMinLines(long j4, int i4);

    private static native boolean nativeSetStyle(long j4, long j5);

    private static native boolean nativeSetText(long j4, String str);

    public boolean a(BmTextStyle bmTextStyle) {
        this.f8727h = bmTextStyle;
        return bmTextStyle != null ? nativeSetStyle(this.nativeInstance, bmTextStyle.getNativeInstance()) : nativeSetStyle(this.nativeInstance, 0L);
    }

    public boolean b(String str) {
        this.f8726g = str;
        return nativeSetText(this.nativeInstance, str);
    }

    public boolean j(int i4) {
        if (i4 <= 0) {
            return false;
        }
        return nativeSetMaxLines(this.nativeInstance, i4);
    }

    public String b() {
        return this.f8726g;
    }
}
