package afa;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJJ\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionParams;", "", "fastFailWhenAppBackground", "", "playTts", "allowBiometricUnlock", "autoPopupWindow", "skipWhenKeyguardDismissed", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getFastFailWhenAppBackground", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPlayTts", "getAllowBiometricUnlock", "getAutoPopupWindow", "getSkipWhenKeyguardDismissed", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/auth/DismissKeyguardActionParams;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("allowBiometricUnlock")
    private final Boolean allowBiometricUnlock;

    @SerializedName("autoPopupWindow")
    private final Boolean autoPopupWindow;

    @SerializedName("fastFailWhenAppBackground")
    private final Boolean fastFailWhenAppBackground;

    @SerializedName("playTts")
    private final Boolean playTts;

    @SerializedName("skipWhenKeyguardDismissed")
    private final Boolean skipWhenKeyguardDismissed;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.fastFailWhenAppBackground, r101.fastFailWhenAppBackground) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.playTts, r101.playTts) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.allowBiometricUnlock, r101.allowBiometricUnlock) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.autoPopupWindow, r101.autoPopupWindow) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.skipWhenKeyguardDismissed, r101.skipWhenKeyguardDismissed) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.fastFailWhenAppBackground;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.playTts;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.allowBiometricUnlock;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.autoPopupWindow;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.skipWhenKeyguardDismissed;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DismissKeyguardActionParams(fastFailWhenAppBackground=" + this.fastFailWhenAppBackground + ", playTts=" + this.playTts + ", allowBiometricUnlock=" + this.allowBiometricUnlock + ", autoPopupWindow=" + this.autoPopupWindow + ", skipWhenKeyguardDismissed=" + this.skipWhenKeyguardDismissed + ')';
    }

    public final Boolean a() {
        return this.allowBiometricUnlock;
    }

    public final Boolean b() {
        return this.autoPopupWindow;
    }

    public final Boolean c() {
        return this.fastFailWhenAppBackground;
    }

    public final Boolean d() {
        return this.playTts;
    }

    public final Boolean e() {
        return this.skipWhenKeyguardDismissed;
    }

    public c(int r100) {
        this.fastFailWhenAppBackground = null;
        this.playTts = null;
        this.allowBiometricUnlock = null;
        this.autoPopupWindow = null;
        this.skipWhenKeyguardDismissed = null;
    }
}
