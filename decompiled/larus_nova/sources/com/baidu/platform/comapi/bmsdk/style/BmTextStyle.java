package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.platform.comapi.bmsdk.BmObject;

/* JADX INFO: loaded from: classes39.dex */
public class BmTextStyle extends BmObject implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32847f;

    private static native long nativeCreate();

    private static native boolean nativeSetBorderColor(long r100, int r101);

    private static native boolean nativeSetBorderWidth(long r100, int r101);

    private static native boolean nativeSetFontOption(long r100, int r101);

    private static native boolean nativeSetTextColor(long r100, int r101);

    private static native boolean nativeSetTextSize(long r100, int r101);

    public BmTextStyle a() {
        BmTextStyle r100 = new BmTextStyle();
        r100.d(this.f32842a);
        r100.e(this.f32844c);
        r100.a(this.f32845d);
        r100.b(this.f32846e);
        r100.c(this.f32847f);
        return r100;
    }

    public BmTextStyle() {
        super(54, nativeCreate());
        this.f32842a = -13421773;
        this.f32843b = 0;
        this.f32844c = 22;
        this.f32845d = 0;
        this.f32846e = 0;
        this.f32847f = 1;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public boolean a(int r100) {
        this.f32845d = r100;
        return nativeSetBorderColor(this.nativeInstance, a.a(r100));
    }

    public boolean b(int r100) {
        this.f32846e = r100;
        return nativeSetBorderWidth(this.nativeInstance, r100);
    }

    public boolean c(int r100) {
        this.f32847f = r100;
        return nativeSetFontOption(this.nativeInstance, r100);
    }

    public boolean d(int r100) {
        this.f32842a = r100;
        return nativeSetTextColor(this.nativeInstance, a.a(r100));
    }

    public boolean e(int r100) {
        int r101 = this.f32843b;
        if (r101 != 0) goto L5;
        this.f32844c = r100;
    L10:
        return nativeSetTextSize(this.nativeInstance, this.f32844c);
    L5:
        if (r101 != 1) goto L10;
        this.f32844c = (int) ((r100 * 310.0f) / SysOSUtil.getDensityDpi());
        goto L10
    }

    public boolean f(int r100) {
        if (r100 == 0) goto L7;
        if (r100 == 1) goto L7;
        return false;
    L7:
        this.f32843b = r100;
        return true;
    }
}
