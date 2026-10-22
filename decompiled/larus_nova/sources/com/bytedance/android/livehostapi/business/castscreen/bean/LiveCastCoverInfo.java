package com.bytedance.android.livehostapi.business.castscreen.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastCoverInfo;", "", "()V", "blurDefaultColor", "", "getBlurDefaultColor", "()Ljava/lang/String;", "setBlurDefaultColor", "(Ljava/lang/String;)V", "blurUrl", "getBlurUrl", "setBlurUrl", "coverUrl", "getCoverUrl", "setCoverUrl", "height", "", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "toString", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCastCoverInfo {
    private String blurDefaultColor;
    private String blurUrl;
    private String coverUrl;
    private int height;
    private int width;

    public String toString() {
        return "LiveCastCoverInfo(coverUrl=" + this.coverUrl + ", width=" + this.width + ", height=" + this.height + ", blurUrl=" + this.blurUrl + ", blurDefaultColor=" + this.blurDefaultColor + ')';
    }

    public LiveCastCoverInfo() {
        this.coverUrl = "";
        this.blurUrl = "";
        this.blurDefaultColor = "";
    }

    public final String getBlurDefaultColor() {
        return this.blurDefaultColor;
    }

    public final String getBlurUrl() {
        return this.blurUrl;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setBlurDefaultColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.blurDefaultColor = r100;
    }

    public final void setBlurUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.blurUrl = r100;
    }

    public final void setCoverUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverUrl = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }
}
