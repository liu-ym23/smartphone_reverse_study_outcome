package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes.dex */
public class BmTextStyle extends BmObject implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f8703a;

    /* renamed from: b, reason: collision with root package name */
    private int f8704b;

    /* renamed from: c, reason: collision with root package name */
    private int f8705c;

    /* renamed from: d, reason: collision with root package name */
    private int f8706d;

    /* renamed from: e, reason: collision with root package name */
    private int f8707e;

    public BmTextStyle() {
        super(54, nativeCreate());
        this.f8703a = -13421773;
        this.f8704b = 22;
        this.f8705c = 0;
        this.f8706d = 0;
        this.f8707e = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBorderColor(long j4, int i4);

    private static native boolean nativeSetBorderWidth(long j4, int i4);

    private static native boolean nativeSetFontOption(long j4, int i4);

    private static native boolean nativeSetTextColor(long j4, int i4);

    private static native boolean nativeSetTextSize(long j4, int i4);

    public boolean a(int i4) {
        this.f8705c = i4;
        return nativeSetBorderColor(this.nativeInstance, a.a(i4));
    }

    public boolean b(int i4) {
        this.f8706d = i4;
        return nativeSetBorderWidth(this.nativeInstance, i4);
    }

    public boolean c(int i4) {
        this.f8707e = i4;
        return nativeSetFontOption(this.nativeInstance, i4);
    }

    public boolean d(int i4) {
        this.f8703a = i4;
        return nativeSetTextColor(this.nativeInstance, a.a(i4));
    }

    public boolean e(int i4) {
        this.f8704b = i4;
        return nativeSetTextSize(this.nativeInstance, i4);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BmTextStyle clone() {
        BmTextStyle bmTextStyle = new BmTextStyle();
        bmTextStyle.d(this.f8703a);
        bmTextStyle.e(this.f8704b);
        bmTextStyle.a(this.f8705c);
        bmTextStyle.b(this.f8706d);
        bmTextStyle.c(this.f8707e);
        return bmTextStyle;
    }
}
