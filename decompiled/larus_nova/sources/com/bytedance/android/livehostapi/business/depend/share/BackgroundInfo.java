package com.bytedance.android.livehostapi.business.depend.share;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/share/BackgroundInfo;", "", "()V", "height", "", "getHeight", "()I", "setHeight", "(I)V", "outputHeight", "getOutputHeight", "setOutputHeight", "outputWidth", "getOutputWidth", "setOutputWidth", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "width", "getWidth", "setWidth", "x", "getX", "setX", "y", "getY", "setY", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BackgroundInfo {

    @SerializedName("shoot_height")
    private int height;

    @SerializedName("bg_height")
    private int outputHeight;

    @SerializedName("bg_width")
    private int outputWidth;

    @SerializedName("bg_url")
    private String url;

    @SerializedName("shoot_width")
    private int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private int f102934x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private int f102935y;

    public BackgroundInfo() {
        this.url = "";
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getOutputHeight() {
        return this.outputHeight;
    }

    public final int getOutputWidth() {
        return this.outputWidth;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getX() {
        return this.f102934x;
    }

    public final int getY() {
        return this.f102935y;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setOutputHeight(int r100) {
        this.outputHeight = r100;
    }

    public final void setOutputWidth(int r100) {
        this.outputWidth = r100;
    }

    public final void setUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.url = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public final void setX(int r100) {
        this.f102934x = r100;
    }

    public final void setY(int r100) {
        this.f102935y = r100;
    }
}
