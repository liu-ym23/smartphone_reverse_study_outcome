package av9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/settings/provider/login/OnekeyLoginConfig;", "", "enablePhoneLoginWithoutSms", "", "getMaskPhoneTimeOutInterval", "", "<init>", "(ZI)V", "getEnablePhoneLoginWithoutSms", "()Z", "getGetMaskPhoneTimeOutInterval", "()I", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class f {

    @SerializedName("enable_phone_login_without_sms")
    private final boolean enablePhoneLoginWithoutSms;

    @SerializedName("get_mask_phone_timeout_interval")
    private final int getMaskPhoneTimeOutInterval;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.enablePhoneLoginWithoutSms == r101.enablePhoneLoginWithoutSms) goto L12;
        return false;
    L12:
        if (this.getMaskPhoneTimeOutInterval == r101.getMaskPhoneTimeOutInterval) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.enablePhoneLoginWithoutSms == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.getMaskPhoneTimeOutInterval;
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "OnekeyLoginConfig(enablePhoneLoginWithoutSms=" + this.enablePhoneLoginWithoutSms + ", getMaskPhoneTimeOutInterval=" + this.getMaskPhoneTimeOutInterval + ')';
    }

    public final boolean a() {
        return this.enablePhoneLoginWithoutSms;
    }

    public final int b() {
        return this.getMaskPhoneTimeOutInterval;
    }

    public f(int r100) {
        this.enablePhoneLoginWithoutSms = false;
        this.getMaskPhoneTimeOutInterval = 2;
    }
}
