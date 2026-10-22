package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Text;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* loaded from: classes.dex */
public class BmTextMarker extends BmBaseMarker {

    /* renamed from: w, reason: collision with root package name */
    private String f8654w;

    /* renamed from: x, reason: collision with root package name */
    private BmTextStyle f8655x;

    /* renamed from: y, reason: collision with root package name */
    private Text f8656y;

    public BmTextMarker() {
        super(5, nativeCreate());
    }

    private static native long nativeCreate();

    private static native boolean nativeSetStyle(long j4, long j5);

    private static native boolean nativeSetText(long j4, String str);

    public void a(Text text) {
        this.f8656y = text;
    }

    public boolean b(String str) {
        this.f8654w = str;
        return nativeSetText(this.nativeInstance, str);
    }

    public Text d() {
        return this.f8656y;
    }

    public boolean a(BmTextStyle bmTextStyle) {
        this.f8655x = bmTextStyle;
        return bmTextStyle != null ? nativeSetStyle(this.nativeInstance, bmTextStyle.nativeInstance) : nativeSetStyle(this.nativeInstance, 0L);
    }
}
