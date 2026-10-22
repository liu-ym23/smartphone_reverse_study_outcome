package com.bytedance.android.livesdkapi.minigame;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/PushParams;", "Ljava/io/Serializable;", "width", "", "height", "defaultBitrate", "minBitrate", "maxBitrate", "fps", "gopSec", "", "(IIIIIIF)V", "getDefaultBitrate", "()I", "setDefaultBitrate", "(I)V", "getFps", "setFps", "getGopSec", "()F", "setGopSec", "(F)V", "getHeight", "setHeight", "getMaxBitrate", "setMaxBitrate", "getMinBitrate", "setMinBitrate", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PushParams implements Serializable {

    @SerializedName("defaultBitrate")
    private int defaultBitrate;

    @SerializedName("fps")
    private int fps;

    @SerializedName("gopSec")
    private float gopSec;

    @SerializedName("height")
    private int height;

    @SerializedName("maxBitrate")
    private int maxBitrate;

    @SerializedName("minBitrate")
    private int minBitrate;

    @SerializedName("width")
    private int width;

    public PushParams() {
        this(0, 0, 0, 0, 0, 0, 0.0f, 127, null);
    }

    public static /* synthetic */ PushParams copy$default(PushParams r100, int r101, int r102, int r103, int r104, int r110, int r111, float r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        int r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.defaultBitrate;
    L11:
        int r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.minBitrate;
    L14:
        int r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.maxBitrate;
    L17:
        int r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.fps;
    L20:
        int r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.gopSec;
    L23:
        int r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.defaultBitrate;
    }

    public final int component4() {
        return this.minBitrate;
    }

    public final int component5() {
        return this.maxBitrate;
    }

    public final int component6() {
        return this.fps;
    }

    public final float component7() {
        return this.gopSec;
    }

    public final PushParams copy(int r110, int r111, int r112, int r113, int r114, int r115, float r116) {
        return new PushParams(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PushParams) == false) goto L20;
        PushParams r101 = (PushParams) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (this.defaultBitrate == r101.defaultBitrate) goto L12;
        return false;
    L12:
        if (this.minBitrate == r101.minBitrate) goto L14;
        return false;
    L14:
        if (this.maxBitrate == r101.maxBitrate) goto L16;
        return false;
    L16:
        if (this.fps == r101.fps) goto L18;
        return false;
    L18:
        if (Float.compare(this.gopSec, r101.gopSec) == 0) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        return (((((((((((this.width * 31) + this.height) * 31) + this.defaultBitrate) * 31) + this.minBitrate) * 31) + this.maxBitrate) * 31) + this.fps) * 31) + Float.floatToIntBits(this.gopSec);
    }

    public String toString() {
        return "PushParams(width=" + this.width + ", height=" + this.height + ", defaultBitrate=" + this.defaultBitrate + ", minBitrate=" + this.minBitrate + ", maxBitrate=" + this.maxBitrate + ", fps=" + this.fps + ", gopSec=" + this.gopSec + ")";
    }

    public final int getDefaultBitrate() {
        return this.defaultBitrate;
    }

    public final int getFps() {
        return this.fps;
    }

    public final float getGopSec() {
        return this.gopSec;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getMaxBitrate() {
        return this.maxBitrate;
    }

    public final int getMinBitrate() {
        return this.minBitrate;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setDefaultBitrate(int r100) {
        this.defaultBitrate = r100;
    }

    public final void setFps(int r100) {
        this.fps = r100;
    }

    public final void setGopSec(float r100) {
        this.gopSec = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setMaxBitrate(int r100) {
        this.maxBitrate = r100;
    }

    public final void setMinBitrate(int r100) {
        this.minBitrate = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public PushParams(int r100, int r101, int r102, int r103, int r104, int r105, float r106) {
        this.width = r100;
        this.height = r101;
        this.defaultBitrate = r102;
        this.minBitrate = r103;
        this.maxBitrate = r104;
        this.fps = r105;
        this.gopSec = r106;
    }

    public /* synthetic */ PushParams(int r100, int r101, int r102, int r103, int r110, int r111, float r112, int r113, DefaultConstructorMarker r114) {
        int r104 = 0;
        if ((r113 & 1) == 0) goto L5;
        int r115 = 0;
    L7:
        if ((r113 & 2) == 0) goto L9;
        int r105 = 0;
    L11:
        if ((r113 & 4) == 0) goto L13;
        int r106 = 0;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r107 = 0;
    L19:
        if ((r113 & 16) == 0) goto L21;
        int r108 = 0;
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        float r116 = 0.0f;
    L30:
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
