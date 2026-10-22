package bfa;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.AuthenticationType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J[\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011¨\u0006!"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/result/SessionAuthStatusResult;", "", "sessionId", "", "isAuthenticationPass", "", "authenticationType", "", "isVoicePrintPass", "isBiometricPass", "isKeyguardLocked", "isDeviceLocked", "isDeviceSecure", "<init>", "(Ljava/lang/String;ZIZZZZZ)V", "getSessionId", "()Ljava/lang/String;", "()Z", "getAuthenticationType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("authenticationType")
    private final int authenticationType;

    @SerializedName("isAuthenticationPass")
    private final boolean isAuthenticationPass;

    @SerializedName("isBiometricPass")
    private final boolean isBiometricPass;

    @SerializedName("isDeviceLocked")
    private final boolean isDeviceLocked;

    @SerializedName("isDeviceSecure")
    private final boolean isDeviceSecure;

    @SerializedName("isKeyguardLocked")
    private final boolean isKeyguardLocked;

    @SerializedName("isVoicePrintPass")
    private final boolean isVoicePrintPass;

    @SerializedName("sessionId")
    private final String sessionId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L12;
        return false;
    L12:
        if (this.isAuthenticationPass == r101.isAuthenticationPass) goto L15;
        return false;
    L15:
        if (this.authenticationType == r101.authenticationType) goto L18;
        return false;
    L18:
        if (this.isVoicePrintPass == r101.isVoicePrintPass) goto L21;
        return false;
    L21:
        if (this.isBiometricPass == r101.isBiometricPass) goto L24;
        return false;
    L24:
        if (this.isKeyguardLocked == r101.isKeyguardLocked) goto L27;
        return false;
    L27:
        if (this.isDeviceLocked == r101.isDeviceLocked) goto L30;
        return false;
    L30:
        if (this.isDeviceSecure == r101.isDeviceSecure) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.sessionId;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.isAuthenticationPass == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r102 + r104) * 31) + this.authenticationType) * 31;
        if (this.isVoicePrintPass == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.isBiometricPass == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.isKeyguardLocked == false) goto L21;
        int r110 = 1231;
    L22:
        int r111 = (r109 + r110) * 31;
        if (this.isDeviceLocked == false) goto L25;
        int r112 = 1231;
    L26:
        int r113 = (r111 + r112) * 31;
        if (this.isDeviceSecure == true) goto L31;
        r103 = 1237;
    L31:
        return r113 + r103;
    L25:
        r112 = 1237;
        goto L26
    L21:
        r110 = 1237;
        goto L22
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SessionAuthStatusResult(sessionId=" + this.sessionId + ", isAuthenticationPass=" + this.isAuthenticationPass + ", authenticationType=" + this.authenticationType + ", isVoicePrintPass=" + this.isVoicePrintPass + ", isBiometricPass=" + this.isBiometricPass + ", isKeyguardLocked=" + this.isKeyguardLocked + ", isDeviceLocked=" + this.isDeviceLocked + ", isDeviceSecure=" + this.isDeviceSecure + ')';
    }

    public c() {
        this("", false, AuthenticationType.INVALID.getType(), false, false, false, false, false);
    }

    public c(String r100, boolean r101, int r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        this.sessionId = r100;
        this.isAuthenticationPass = r101;
        this.authenticationType = r102;
        this.isVoicePrintPass = r103;
        this.isBiometricPass = r104;
        this.isKeyguardLocked = r105;
        this.isDeviceLocked = r106;
        this.isDeviceSecure = r107;
    }
}
