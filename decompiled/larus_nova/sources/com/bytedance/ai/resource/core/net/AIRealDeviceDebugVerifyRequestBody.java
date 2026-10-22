package com.bytedance.ai.resource.core.net;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/resource/core/net/AIRealDeviceDebugVerifyRequestBody;", "", "source", "", "debugToken", "", "encryptedDebugPayload", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getSource", "()I", "getDebugToken", "()Ljava/lang/String;", "getEncryptedDebugPayload", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIRealDeviceDebugVerifyRequestBody {
    private static final a Companion = null;
    public static final int DEVICE_SOURCE = 2;

    @SerializedName("debug_token")
    private final String debugToken;

    @SerializedName("encrypted_debug_payload")
    private final String encryptedDebugPayload;
    private final int source;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ AIRealDeviceDebugVerifyRequestBody copy$default(AIRealDeviceDebugVerifyRequestBody r100, int r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.source;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.debugToken;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.encryptedDebugPayload;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.source;
    }

    public final String component2() {
        return this.debugToken;
    }

    public final String component3() {
        return this.encryptedDebugPayload;
    }

    public final AIRealDeviceDebugVerifyRequestBody copy(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "debugToken");
        Intrinsics.checkNotNullParameter(r102, "encryptedDebugPayload");
        return new AIRealDeviceDebugVerifyRequestBody(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIRealDeviceDebugVerifyRequestBody) == true) goto L8;
        return false;
    L8:
        AIRealDeviceDebugVerifyRequestBody r101 = (AIRealDeviceDebugVerifyRequestBody) r100;
        if (this.source == r101.source) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.debugToken, r101.debugToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.encryptedDebugPayload, r101.encryptedDebugPayload) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.source * 31) + this.debugToken.hashCode()) * 31) + this.encryptedDebugPayload.hashCode();
    }

    public String toString() {
        return "AIRealDeviceDebugVerifyRequestBody(source=" + this.source + ", debugToken=" + this.debugToken + ", encryptedDebugPayload=" + this.encryptedDebugPayload + ')';
    }

    public final String getDebugToken() {
        return this.debugToken;
    }

    public final String getEncryptedDebugPayload() {
        return this.encryptedDebugPayload;
    }

    public final int getSource() {
        return this.source;
    }

    public AIRealDeviceDebugVerifyRequestBody(int r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "debugToken");
        Intrinsics.checkNotNullParameter(r102, "encryptedDebugPayload");
        this.source = r100;
        this.debugToken = r101;
        this.encryptedDebugPayload = r102;
    }

    public /* synthetic */ AIRealDeviceDebugVerifyRequestBody(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r100 = 2;
    L5:
        this(r100, r101, r102);
    }
}
