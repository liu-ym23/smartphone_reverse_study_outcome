package com.baidu.platform.comapi.bmsdk;

import com.baidu.mapapi.map.Text;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;

/* JADX INFO: loaded from: classes39.dex */
public class BmTextMarker extends BmBaseMarker {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f32792w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private BmTextStyle f32793x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Text f32794y;

    private static native long nativeCreate();

    private static native boolean nativeSetStyle(long r100, long r101);

    private static native boolean nativeSetText(long r100, String r101);

    public BmTextMarker() {
        super(5, nativeCreate());
    }

    public Text d() {
        return this.f32794y;
    }

    public boolean a(BmTextStyle r100) {
        this.f32793x = r100;
        if (r100 == null) goto L7;
        return nativeSetStyle(this.nativeInstance, r100.nativeInstance);
    L7:
        return nativeSetStyle(this.nativeInstance, 0);
    }

    public boolean b(String r100) {
        this.f32792w = r100;
        return nativeSetText(this.nativeInstance, r100);
    }

    public void a(Text r100) {
        this.f32794y = r100;
    }
}
