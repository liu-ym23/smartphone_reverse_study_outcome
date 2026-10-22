package com.bytedance.android.livesdkapi.minigame;

import java.io.Serializable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdkapi/minigame/AudioFrame;", "Ljava/io/Serializable;", "sampleHZ", "", "channel", "bitWidth", "sampleCount", "timestamp", "", "data", "Ljava/nio/ByteBuffer;", "(IIIIJLjava/nio/ByteBuffer;)V", "getBitWidth", "()I", "setBitWidth", "(I)V", "getChannel", "setChannel", "getData", "()Ljava/nio/ByteBuffer;", "setData", "(Ljava/nio/ByteBuffer;)V", "getSampleCount", "setSampleCount", "getSampleHZ", "setSampleHZ", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioFrame implements Serializable {
    private int bitWidth;
    private int channel;
    private ByteBuffer data;
    private int sampleCount;
    private int sampleHZ;
    private long timestamp;

    public static /* synthetic */ AudioFrame copy$default(AudioFrame r100, int r101, int r102, int r103, int r104, long r110, ByteBuffer r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L6;
        r101 = r100.sampleHZ;
    L6:
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.channel;
    L8:
        int r114 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.bitWidth;
    L11:
        int r105 = r103;
        if ((r112 & 8) == 0) goto L14;
        r104 = r100.sampleCount;
    L14:
        int r106 = r104;
        if ((r112 & 16) == 0) goto L17;
        r110 = r100.timestamp;
    L17:
        long r107 = r110;
        if ((r112 & 32) == 0) goto L20;
        r111 = r100.data;
    L20:
        int r108 = r101;
        return r100.copy(r108, r114, r105, r106, r107, r111);
    }

    public final int component1() {
        return this.sampleHZ;
    }

    public final int component2() {
        return this.channel;
    }

    public final int component3() {
        return this.bitWidth;
    }

    public final int component4() {
        return this.sampleCount;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final ByteBuffer component6() {
        return this.data;
    }

    public final AudioFrame copy(int r110, int r111, int r112, int r113, long r114, ByteBuffer r115) {
        Intrinsics.checkNotNullParameter(r115, "data");
        return new AudioFrame(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AudioFrame) == false) goto L18;
        AudioFrame r101 = (AudioFrame) r100;
        if (this.sampleHZ == r101.sampleHZ) goto L8;
        return false;
    L8:
        if (this.channel == r101.channel) goto L10;
        return false;
    L10:
        if (this.bitWidth == r101.bitWidth) goto L12;
        return false;
    L12:
        if (this.sampleCount == r101.sampleCount) goto L14;
        return false;
    L14:
        if (this.timestamp == r101.timestamp) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r100 = ((((((this.sampleHZ * 31) + this.channel) * 31) + this.bitWidth) * 31) + this.sampleCount) * 31;
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
        return "AudioFrame(sampleHZ=" + this.sampleHZ + ", channel=" + this.channel + ", bitWidth=" + this.bitWidth + ", sampleCount=" + this.sampleCount + ", timestamp=" + this.timestamp + ", data=" + this.data + ")";
    }

    public final int getBitWidth() {
        return this.bitWidth;
    }

    public final int getChannel() {
        return this.channel;
    }

    public final ByteBuffer getData() {
        return this.data;
    }

    public final int getSampleCount() {
        return this.sampleCount;
    }

    public final int getSampleHZ() {
        return this.sampleHZ;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setBitWidth(int r100) {
        this.bitWidth = r100;
    }

    public final void setChannel(int r100) {
        this.channel = r100;
    }

    public final void setData(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }

    public final void setSampleCount(int r100) {
        this.sampleCount = r100;
    }

    public final void setSampleHZ(int r100) {
        this.sampleHZ = r100;
    }

    public final void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public AudioFrame(int r100, int r101, int r102, int r103, long r104, ByteBuffer r105) {
        Intrinsics.checkNotNullParameter(r105, "data");
        this.sampleHZ = r100;
        this.channel = r101;
        this.bitWidth = r102;
        this.sampleCount = r103;
        this.timestamp = r104;
        this.data = r105;
    }

    public /* synthetic */ AudioFrame(int r110, int r111, int r112, int r113, long r114, ByteBuffer r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        int r100 = 0;
    L7:
        if ((r116 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r116 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r116 & 8) == 0) goto L17;
        int r103 = 0;
    L19:
        if ((r116 & 16) == 0) goto L21;
        long r104 = 0;
    L22:
        this(r100, r101, r102, r103, r104, r115);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
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
