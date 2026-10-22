package com.bytedance.android.livehostapi.foundation.depend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livehostapi/foundation/depend/HostLargeFontParam;", "", "isViewZoomEnable", "", "isLargeFontMode", "viewZoom", "", "fontScale", "(ZZFF)V", "getFontScale", "()F", "setFontScale", "(F)V", "()Z", "setLargeFontMode", "(Z)V", "setViewZoomEnable", "getViewZoom", "setViewZoom", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HostLargeFontParam {
    private float fontScale;
    private boolean isLargeFontMode;
    private boolean isViewZoomEnable;
    private float viewZoom;

    public HostLargeFontParam() {
        this(false, false, 0.0f, 0.0f, 15, null);
    }

    public final float getFontScale() {
        return this.fontScale;
    }

    public final float getViewZoom() {
        return this.viewZoom;
    }

    public final boolean isLargeFontMode() {
        return this.isLargeFontMode;
    }

    public final boolean isViewZoomEnable() {
        return this.isViewZoomEnable;
    }

    public final void setFontScale(float r100) {
        this.fontScale = r100;
    }

    public final void setLargeFontMode(boolean r100) {
        this.isLargeFontMode = r100;
    }

    public final void setViewZoom(float r100) {
        this.viewZoom = r100;
    }

    public final void setViewZoomEnable(boolean r100) {
        this.isViewZoomEnable = r100;
    }

    public HostLargeFontParam(boolean r100, boolean r101, float r102, float r103) {
        this.isViewZoomEnable = r100;
        this.isLargeFontMode = r101;
        this.viewZoom = r102;
        this.fontScale = r103;
    }

    public /* synthetic */ HostLargeFontParam(boolean r100, boolean r101, float r102, float r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1.0f;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 1.0f;
    L14:
        this(r100, r101, r102, r103);
    }
}
