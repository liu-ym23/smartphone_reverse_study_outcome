package a09;

import com.google.gson.annotations.SerializedName;
import com.larus.settings.value.e10;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010#\u001a\u00020$J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001fJV\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\nHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R(\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u0019\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00061"}, d2 = {"Lcom/larus/common/account/platform/larkauth/datamodel/AuthorizationDataModel;", "", "accessToken", "", "tokenType", "expiresIn", "", "expiresInV2", "requestTime", "errorCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)V", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getTokenType", "setTokenType", "getExpiresIn$annotations", "()V", "getExpiresIn", "()Ljava/lang/Long;", "setExpiresIn", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExpiresInV2", "setExpiresInV2", "getRequestTime", "setRequestTime", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isActExpired", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/larus/common/account/platform/larkauth/datamodel/AuthorizationDataModel;", "equals", "other", "hashCode", "toString", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("error_code")
    private Integer errorCode;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("expires_in_v2")
    private Long expiresInV2;

    @SerializedName("request_time")
    private Long requestTime;

    @SerializedName("auth_schema")
    private String tokenType;

    public a() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.accessToken, r101.accessToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tokenType, r101.tokenType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.expiresIn, r101.expiresIn) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.expiresInV2, r101.expiresInV2) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.requestTime, r101.requestTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errorCode, r101.errorCode) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.accessToken;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tokenType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.expiresIn;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.expiresInV2;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.requestTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.errorCode;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "AuthorizationDataModel(accessToken=" + this.accessToken + ", tokenType=" + this.tokenType + ", expiresIn=" + this.expiresIn + ", expiresInV2=" + this.expiresInV2 + ", requestTime=" + this.requestTime + ", errorCode=" + this.errorCode + ')';
    }

    public final boolean d() {
        Long r100 = this.expiresIn;
        if (r100 != null) goto L5;
    L10:
        Long r101 = this.expiresInV2;
        if (r101 == null) goto L18;
        long r102 = r101.longValue();
        Long r103 = this.requestTime;
        if (r103 == null) goto L18;
        long r104 = r103.longValue();
        e10 r105 = e10.f368561a;
        if ((r104 + ((r102 * (1 - e10.Z().getRefreshAt())) * 1000)) > System.currentTimeMillis()) goto L20;
        return true;
    L20:
        return false;
    L18:
        return true;
    L5:
        if (r100.longValue() <= 0) goto L10;
        if ((r100.longValue() - ((long) 5000)) > System.currentTimeMillis()) goto L19;
        return true;
    L19:
        return false;
    }

    public final String a() {
        return this.accessToken;
    }

    public final Integer b() {
        return this.errorCode;
    }

    public final String c() {
        return this.tokenType;
    }

    public final void e(String r100) {
        this.accessToken = r100;
    }

    public final void f(Long r100) {
        this.expiresInV2 = r100;
    }

    public final void g(Long r100) {
        this.requestTime = r100;
    }

    public final void h(String r100) {
        this.tokenType = r100;
    }

    public a(String r100, String r101, Long r102, Long r103, Integer r104, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r110 & 4) == 0) goto L11;
        Long r105 = 0L;
    L13:
        if ((r110 & 8) == 0) goto L16;
        r102 = 0L;
    L16:
        if ((r110 & 16) == 0) goto L19;
        r103 = 0L;
    L19:
        if ((r110 & 32) == 0) goto L21;
        r104 = 0;
    L21:
        this.accessToken = r100;
        this.tokenType = r101;
        this.expiresIn = r105;
        this.expiresInV2 = r102;
        this.requestTime = r103;
        this.errorCode = r104;
        return;
    L11:
        r105 = null;
        goto L13
    }
}
