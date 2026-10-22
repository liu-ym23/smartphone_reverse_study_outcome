package com.bytedance.android.livesdkapi.minigame;

import java.io.Serializable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/VideoFrame;", "Ljava/io/Serializable;", "width", "", "height", "colorFormat", "timestamp", "", "data", "Ljava/nio/ByteBuffer;", "(IIIJLjava/nio/ByteBuffer;)V", "getColorFormat", "()I", "setColorFormat", "(I)V", "getData", "()Ljava/nio/ByteBuffer;", "setData", "(Ljava/nio/ByteBuffer;)V", "getHeight", "setHeight", "getTimestamp", "()J", "setTimestamp", "(J)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoFrame implements Serializable {
    private int colorFormat;
    private ByteBuffer data;
    private int height;
    private long timestamp;
    private int width;

    public static /* synthetic */ VideoFrame copy$default(VideoFrame r100, int r101, int r102, int r103, long r104, ByteBuffer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.width;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        int r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.colorFormat;
    L11:
        int r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.timestamp;
    L14:
        long r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.data;
    L17:
        int r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    public final int component3() {
        return this.colorFormat;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final ByteBuffer component5() {
        return this.data;
    }

    public final VideoFrame copy(int r100, int r110, int r111, long r112, ByteBuffer r113) {
        Intrinsics.checkNotNullParameter(r113, "data");
        return new VideoFrame(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof VideoFrame) == false) goto L16;
        VideoFrame r101 = (VideoFrame) r100;
        if (this.width == r101.width) goto L8;
        return false;
    L8:
        if (this.height == r101.height) goto L10;
        return false;
    L10:
        if (this.colorFormat == r101.colorFormat) goto L12;
        return false;
    L12:
        if (this.timestamp == r101.timestamp) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        int r100 = ((((this.width * 31) + this.height) * 31) + this.colorFormat) * 31;
        long r101 = this.timestamp;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        ByteBuffer r103 = this.data;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L7:
        return r102 + r104;
    L5:
        r104 = 0;
        goto L7
    }

    public String toString() {
        return "VideoFrame(width=" + this.width + ", height=" + this.height + ", colorFormat=" + this.colorFormat + ", timestamp=" + this.timestamp + ", data=" + this.data + ")";
    }

    public final int getColorFormat() {
        return this.colorFormat;
    }

    public final ByteBuffer getData() {
        return this.data;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setColorFormat(int r100) {
        this.colorFormat = r100;
    }

    public final void setData(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public VideoFrame(int r100, int r101, int r102, long r103, ByteBuffer r104) {
        Intrinsics.checkNotNullParameter(r104, "data");
        this.width = r100;
        this.height = r101;
        this.colorFormat = r102;
        this.timestamp = r103;
        this.data = r104;
    }

    public /* synthetic */ VideoFrame(int r110, int r111, int r112, long r113, ByteBuffer r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r115 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r115 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r115 & 8) == 0) goto L17;
        long r103 = 0;
    L18:
        this(r100, r101, r102, r103, r114);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
