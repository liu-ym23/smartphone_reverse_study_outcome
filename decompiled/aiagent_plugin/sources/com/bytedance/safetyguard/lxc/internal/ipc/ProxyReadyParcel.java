package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyReadyParcel implements Parcelable {
    public static final Parcelable.Creator<ProxyReadyParcel> CREATOR = null;
    private final long acceptedFeatureBitmap;
    private final int dataChunkSize;
    private final int maxFramePayload;
    private final int protocolVersion;
    private final boolean reused;
    private final String sessionId;
    private final int streamWindow;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ProxyReadyParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyReadyParcel createFromParcel(Parcel r10) {
            o.e(r10, "parcel");
            int r1 = r10.readInt();
            String r2 = r10.readString();
            if (r10.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            return new ProxyReadyParcel(r1, r2, r0, r10.readLong(), r10.readInt(), r10.readInt(), r10.readInt());
        L5:
            r0 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyReadyParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyReadyParcel[] newArray(int r1) {
            return new ProxyReadyParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyReadyParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ProxyReadyParcel copy$default(ProxyReadyParcel r9, int r10, String r11, boolean r12, long r13, int r15, int r16, int r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        int r1 = r9.protocolVersion;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = r9.sessionId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        boolean r3 = r9.reused;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r4 = r9.acceptedFeatureBitmap;
    L19:
        if ((r18 & 16) == 0) goto L21;
        int r6 = r9.maxFramePayload;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.dataChunkSize;
    L27:
        if ((r18 & 64) == 0) goto L29;
        int r8 = r9.streamWindow;
    L31:
        return r9.copy(r1, r2, r3, r4, r6, r7, r8);
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final boolean component3() {
        return this.reused;
    }

    public final long component4() {
        return this.acceptedFeatureBitmap;
    }

    public final int component5() {
        return this.maxFramePayload;
    }

    public final int component6() {
        return this.dataChunkSize;
    }

    public final int component7() {
        return this.streamWindow;
    }

    public final ProxyReadyParcel copy(int r11, String r12, boolean r13, long r14, int r16, int r17, int r18) {
        o.e(r12, ObricMemoryConstants.KEY_SESSION_ID);
        return new ProxyReadyParcel(r11, r12, r13, r14, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProxyReadyParcel.class) == true) goto L8;
        return false;
    L8:
        ProxyReadyParcel r10 = (ProxyReadyParcel) ZeusTransformUtils.preCheckCast(r9, ProxyReadyParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r10.protocolVersion) goto L12;
        return false;
    L12:
        if (o.a(this.sessionId, r10.sessionId) == true) goto L15;
        return false;
    L15:
        if (this.reused == r10.reused) goto L18;
        return false;
    L18:
        if (this.acceptedFeatureBitmap == r10.acceptedFeatureBitmap) goto L21;
        return false;
    L21:
        if (this.maxFramePayload == r10.maxFramePayload) goto L24;
        return false;
    L24:
        if (this.dataChunkSize == r10.dataChunkSize) goto L27;
        return false;
    L27:
        if (this.streamWindow == r10.streamWindow) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.protocolVersion) * 31) + this.sessionId.hashCode()) * 31) + Boolean.hashCode(this.reused)) * 31) + Long.hashCode(this.acceptedFeatureBitmap)) * 31) + Integer.hashCode(this.maxFramePayload)) * 31) + Integer.hashCode(this.dataChunkSize)) * 31) + Integer.hashCode(this.streamWindow);
    }

    public String toString() {
        return "ProxyReadyParcel(protocolVersion=" + this.protocolVersion + ", sessionId=" + this.sessionId + ", reused=" + this.reused + ", acceptedFeatureBitmap=" + this.acceptedFeatureBitmap + ", maxFramePayload=" + this.maxFramePayload + ", dataChunkSize=" + this.dataChunkSize + ", streamWindow=" + this.streamWindow + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "out");
        r3.writeInt(this.protocolVersion);
        r3.writeString(this.sessionId);
        r3.writeInt(this.reused ? 1 : 0);
        r3.writeLong(this.acceptedFeatureBitmap);
        r3.writeInt(this.maxFramePayload);
        r3.writeInt(this.dataChunkSize);
        r3.writeInt(this.streamWindow);
    }

    public ProxyReadyParcel(int r2, String r3, boolean r4, long r5, int r7, int r8, int r9) {
        o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        this.protocolVersion = r2;
        this.sessionId = r3;
        this.reused = r4;
        this.acceptedFeatureBitmap = r5;
        this.maxFramePayload = r7;
        this.dataChunkSize = r8;
        this.streamWindow = r9;
    }

    public /* synthetic */ ProxyReadyParcel(int r11, String r12, boolean r13, long r14, int r16, int r17, int r18, int r19, h r20) {
        if ((r19 & 1) == 0) goto L5;
        int r2 = 3;
    L6:
        this(r2, r12, r13, r14, r16, r17, r18);
        return;
    L5:
        r2 = r11;
        goto L6
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getReused() {
        return this.reused;
    }

    public final long getAcceptedFeatureBitmap() {
        return this.acceptedFeatureBitmap;
    }

    public final int getMaxFramePayload() {
        return this.maxFramePayload;
    }

    public final int getDataChunkSize() {
        return this.dataChunkSize;
    }

    public final int getStreamWindow() {
        return this.streamWindow;
    }
}
