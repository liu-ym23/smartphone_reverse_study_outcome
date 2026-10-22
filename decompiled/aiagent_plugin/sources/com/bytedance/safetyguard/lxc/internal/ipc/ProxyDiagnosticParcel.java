package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyDiagnosticParcel implements Parcelable {
    public static final Parcelable.Creator<ProxyDiagnosticParcel> CREATOR = null;
    private final String attachmentId;
    private final String code;
    private final String message;
    private final int protocolVersion;
    private final int severity;
    private final long timestampMillis;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<ProxyDiagnosticParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyDiagnosticParcel createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            return new ProxyDiagnosticParcel(r9.readInt(), r9.readString(), r9.readInt(), r9.readString(), r9.readString(), r9.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyDiagnosticParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ProxyDiagnosticParcel[] newArray(int r1) {
            return new ProxyDiagnosticParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ProxyDiagnosticParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ ProxyDiagnosticParcel copy$default(ProxyDiagnosticParcel r5, int r6, String r7, int r8, String r9, String r10, long r11, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.protocolVersion;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.attachmentId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.severity;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.code;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.message;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.timestampMillis;
    L20:
        int r12 = r6;
        return r5.copy(r12, r15, r0, r1, r2, r11);
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final String component2() {
        return this.attachmentId;
    }

    public final int component3() {
        return this.severity;
    }

    public final String component4() {
        return this.code;
    }

    public final String component5() {
        return this.message;
    }

    public final long component6() {
        return this.timestampMillis;
    }

    public final ProxyDiagnosticParcel copy(int r9, String r10, int r11, String r12, String r13, long r14) {
        o.e(r12, MonitorConstants.CODE);
        o.e(r13, "message");
        return new ProxyDiagnosticParcel(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ProxyDiagnosticParcel.class) == true) goto L8;
        return false;
    L8:
        ProxyDiagnosticParcel r8 = (ProxyDiagnosticParcel) ZeusTransformUtils.preCheckCast(r7, ProxyDiagnosticParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r8.protocolVersion) goto L12;
        return false;
    L12:
        if (o.a(this.attachmentId, r8.attachmentId) == true) goto L15;
        return false;
    L15:
        if (this.severity == r8.severity) goto L18;
        return false;
    L18:
        if (o.a(this.code, r8.code) == true) goto L21;
        return false;
    L21:
        if (o.a(this.message, r8.message) == true) goto L24;
        return false;
    L24:
        if (this.timestampMillis == r8.timestampMillis) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.protocolVersion) * 31;
        String r1 = this.attachmentId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((r0 + r2) * 31) + Integer.hashCode(this.severity)) * 31) + this.code.hashCode()) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.timestampMillis);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ProxyDiagnosticParcel(protocolVersion=" + this.protocolVersion + ", attachmentId=" + this.attachmentId + ", severity=" + this.severity + ", code=" + this.code + ", message=" + this.message + ", timestampMillis=" + this.timestampMillis + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "out");
        r3.writeInt(this.protocolVersion);
        r3.writeString(this.attachmentId);
        r3.writeInt(this.severity);
        r3.writeString(this.code);
        r3.writeString(this.message);
        r3.writeLong(this.timestampMillis);
    }

    public ProxyDiagnosticParcel(int r2, String r3, int r4, String r5, String r6, long r7) {
        o.e(r5, MonitorConstants.CODE);
        o.e(r6, "message");
        this.protocolVersion = r2;
        this.attachmentId = r3;
        this.severity = r4;
        this.code = r5;
        this.message = r6;
        this.timestampMillis = r7;
    }

    public /* synthetic */ ProxyDiagnosticParcel(int r10, String r11, int r12, String r13, String r14, long r15, int r17, h r18) {
        if ((r17 & 1) == 0) goto L5;
        int r2 = 3;
    L7:
        if ((r17 & 2) == 0) goto L9;
        String r3 = null;
    L10:
        this(r2, r3, r12, r13, r14, r15);
        return;
    L9:
        r3 = r11;
        goto L10
    L5:
        r2 = r10;
        goto L7
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getAttachmentId() {
        return this.attachmentId;
    }

    public final int getSeverity() {
        return this.severity;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getTimestampMillis() {
        return this.timestampMillis;
    }
}
