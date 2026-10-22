package com.obric.matrix.platform.sdk.ones.account;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\bH\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007¢\u0006\u0002\u0010\u0019J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0007HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0017HÆ\u0003J\t\u0010Q\u001a\u00020\u0007HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0007HÆ\u0003J\t\u0010T\u001a\u00020\u0007HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J\t\u0010X\u001a\u00020\u0007HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003JÇ\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0007HÆ\u0001J\u0013\u0010[\u001a\u00020\u00032\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\u0005HÖ\u0001J\t\u0010^\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001dR\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010#\"\u0004\b(\u0010%R\u001a\u0010\u0018\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010#\"\u0004\b,\u0010%R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001f\"\u0004\b4\u0010!R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001b\"\u0004\b6\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001dR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001b\"\u0004\b>\u0010\u001dR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u001b\"\u0004\b@\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u001b\"\u0004\bB\u0010\u001dR\u001a\u0010\u0015\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010\u001d¨\u0006_"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/AccountInfo;", "", AccountInfoBundleKey.LOGIN_STATE, "", AccountInfoBundleKey.LOGOUT_SCENE, "", AccountInfoBundleKey.SEC_USER_ID, "", AccountInfoBundleKey.USER_ID, AccountInfoBundleKey.ODIN_USER_TYPE, "xTTToken", "innerSSOToken", AccountInfoBundleKey.AVATAR_URL, AccountInfoBundleKey.COUNTRY_CODE, AccountInfoBundleKey.USER_NAME, AccountInfoBundleKey.SCREEN_NAME, AccountInfoBundleKey.USER_EMAIL, AccountInfoBundleKey.USER_MOBILE, AccountInfoBundleKey.HAS_PASSWORD, AccountInfoBundleKey.USER_GENDER, AccountInfoBundleKey.IS_NEW_USER, AccountInfoBundleKey.USER_SESSION, AccountInfoBundleKey.LOGIN_UTC_TIME, "", AccountInfoBundleKey.LOGIN_PHONE_NUMBER, "(ZILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIZLjava/lang/String;JLjava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "getCountryCode", "()I", "setCountryCode", "(I)V", "getHasPassword", "()Z", "setHasPassword", "(Z)V", "getInnerSSOToken", "setInnerSSOToken", "setNewUser", "getLoginPhoneNumber", AccountConst.METHOD_SET_LOGIN_PHONE_NUMBER, "getLoginState", "setLoginState", "getLoginUtcTime", "()J", "setLoginUtcTime", "(J)V", "getLogoutScene", "setLogoutScene", "getOdinUserType", "setOdinUserType", "getScreenName", "setScreenName", "getSecUserId", "setSecUserId", "getUserEmail", "setUserEmail", "getUserGender", "setUserGender", "getUserId", "setUserId", "getUserMobile", "setUserMobile", "getUserName", "setUserName", "getUserSession", "setUserSession", "getXTTToken", "setXTTToken", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountInfo {
    private String avatarUrl;
    private int countryCode;
    private boolean hasPassword;
    private String innerSSOToken;
    private boolean isNewUser;
    private String loginPhoneNumber;
    private boolean loginState;
    private long loginUtcTime;
    private int logoutScene;
    private int odinUserType;
    private String screenName;
    private String secUserId;
    private String userEmail;
    private int userGender;
    private String userId;
    private String userMobile;
    private String userName;
    private String userSession;
    private String xTTToken;

    public AccountInfo() {
        this(false, 0, null, null, 0, null, null, null, 0, null, null, null, null, false, 0, false, null, 0, null, 524287, null);
    }

    public static /* synthetic */ AccountInfo copy$default(AccountInfo r17, boolean r18, int r19, String r20, String r21, int r22, String r23, String r24, String r25, int r26, String r27, String r28, String r29, String r30, boolean r31, int r32, boolean r33, String r34, long r35, String r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        boolean r2 = r17.loginState;
    L7:
        if ((r38 & 2) == 0) goto L9;
        int r3 = r17.logoutScene;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r4 = r17.secUserId;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = r17.userId;
    L19:
        if ((r38 & 16) == 0) goto L21;
        int r6 = r17.odinUserType;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r7 = r17.xTTToken;
    L27:
        if ((r38 & 64) == 0) goto L29;
        String r8 = r17.innerSSOToken;
    L31:
        if ((r38 & 128) == 0) goto L33;
        String r9 = r17.avatarUrl;
    L35:
        if ((r38 & 256) == 0) goto L37;
        int r10 = r17.countryCode;
    L39:
        if ((r38 & 512) == 0) goto L41;
        String r11 = r17.userName;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        String r12 = r17.screenName;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r13 = r17.userEmail;
    L51:
        if ((r38 & 4096) == 0) goto L53;
        String r14 = r17.userMobile;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        boolean r15 = r17.hasPassword;
    L58:
        boolean r36 = r15;
        if ((r38 & 16384) == 0) goto L61;
        int r16 = r17.userGender;
    L62:
        int r310 = r16;
        if ((r38 & 32768) == 0) goto L65;
        boolean r110 = r17.isNewUser;
    L66:
        boolean r311 = r110;
        if ((r38 & 65536) == 0) goto L69;
        String r111 = r17.userSession;
    L70:
        String r312 = r14;
        String r313 = r111;
        if ((r38 & 131072) == 0) goto L73;
        long r112 = r17.loginUtcTime;
    L75:
        if ((r38 & 262144) == 0) goto L77;
        String r1 = r17.loginPhoneNumber;
    L79:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r312, r36, r310, r311, r313, r112, r1);
    L77:
        r1 = r37;
        goto L79
    L73:
        r112 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final boolean component1() {
        return this.loginState;
    }

    public final String component10() {
        return this.userName;
    }

    public final String component11() {
        return this.screenName;
    }

    public final String component12() {
        return this.userEmail;
    }

    public final String component13() {
        return this.userMobile;
    }

    public final boolean component14() {
        return this.hasPassword;
    }

    public final int component15() {
        return this.userGender;
    }

    public final boolean component16() {
        return this.isNewUser;
    }

    public final String component17() {
        return this.userSession;
    }

    public final long component18() {
        return this.loginUtcTime;
    }

    public final String component19() {
        return this.loginPhoneNumber;
    }

    public final int component2() {
        return this.logoutScene;
    }

    public final String component3() {
        return this.secUserId;
    }

    public final String component4() {
        return this.userId;
    }

    public final int component5() {
        return this.odinUserType;
    }

    public final String component6() {
        return this.xTTToken;
    }

    public final String component7() {
        return this.innerSSOToken;
    }

    public final String component8() {
        return this.avatarUrl;
    }

    public final int component9() {
        return this.countryCode;
    }

    public final AccountInfo copy(boolean r23, int r24, String r25, String r26, int r27, String r28, String r29, String r30, int r31, String r32, String r33, String r34, String r35, boolean r36, int r37, boolean r38, String r39, long r40, String r42) {
        Intrinsics.checkNotNullParameter(r25, AccountInfoBundleKey.SEC_USER_ID);
        Intrinsics.checkNotNullParameter(r26, AccountInfoBundleKey.USER_ID);
        Intrinsics.checkNotNullParameter(r28, "xTTToken");
        Intrinsics.checkNotNullParameter(r29, "innerSSOToken");
        Intrinsics.checkNotNullParameter(r30, AccountInfoBundleKey.AVATAR_URL);
        Intrinsics.checkNotNullParameter(r32, AccountInfoBundleKey.USER_NAME);
        Intrinsics.checkNotNullParameter(r33, AccountInfoBundleKey.SCREEN_NAME);
        Intrinsics.checkNotNullParameter(r34, AccountInfoBundleKey.USER_EMAIL);
        Intrinsics.checkNotNullParameter(r35, AccountInfoBundleKey.USER_MOBILE);
        Intrinsics.checkNotNullParameter(r39, AccountInfoBundleKey.USER_SESSION);
        Intrinsics.checkNotNullParameter(r42, AccountInfoBundleKey.LOGIN_PHONE_NUMBER);
        return new AccountInfo(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AccountInfo) == true) goto L8;
        return false;
    L8:
        AccountInfo r9 = (AccountInfo) r8;
        if (this.loginState == r9.loginState) goto L12;
        return false;
    L12:
        if (this.logoutScene == r9.logoutScene) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.secUserId, r9.secUserId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.userId, r9.userId) == true) goto L21;
        return false;
    L21:
        if (this.odinUserType == r9.odinUserType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.xTTToken, r9.xTTToken) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.innerSSOToken, r9.innerSSOToken) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.avatarUrl, r9.avatarUrl) == true) goto L33;
        return false;
    L33:
        if (this.countryCode == r9.countryCode) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.userName, r9.userName) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.screenName, r9.screenName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.userEmail, r9.userEmail) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.userMobile, r9.userMobile) == true) goto L48;
        return false;
    L48:
        if (this.hasPassword == r9.hasPassword) goto L51;
        return false;
    L51:
        if (this.userGender == r9.userGender) goto L54;
        return false;
    L54:
        if (this.isNewUser == r9.isNewUser) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.userSession, r9.userSession) == true) goto L60;
        return false;
    L60:
        if (this.loginUtcTime == r9.loginUtcTime) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.loginPhoneNumber, r9.loginPhoneNumber) == true) goto L65;
        return false;
    L65:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r0v31, types: [int] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    public int hashCode() {
        boolean r0 = this.loginState;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = ((((((((((((((((((((((((r2 * 31) + Integer.hashCode(this.logoutScene)) * 31) + this.secUserId.hashCode()) * 31) + this.userId.hashCode()) * 31) + Integer.hashCode(this.odinUserType)) * 31) + this.xTTToken.hashCode()) * 31) + this.innerSSOToken.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + Integer.hashCode(this.countryCode)) * 31) + this.userName.hashCode()) * 31) + this.screenName.hashCode()) * 31) + this.userEmail.hashCode()) * 31) + this.userMobile.hashCode()) * 31;
        boolean r4 = this.hasPassword;
        ?? r5 = r4;
        if (r4 == false) goto L8;
        r5 = 1;
    L8:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.userGender)) * 31;
        boolean r7 = this.isNewUser;
        if (r7 == true) goto L13;
        r1 = r7;
    L13:
        return ((((((r6 + r1) * 31) + this.userSession.hashCode()) * 31) + Long.hashCode(this.loginUtcTime)) * 31) + this.loginPhoneNumber.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("AccountInfo(loginState=");
        r0.append(this.loginState).append(", logoutScene=").append(this.logoutScene).append(", secUserId=").append(this.secUserId).append(", userId=").append(this.userId).append(", odinUserType=").append(this.odinUserType).append(", xTTToken=").append(this.xTTToken).append(", innerSSOToken=").append(this.innerSSOToken).append(", avatarUrl=").append(this.avatarUrl).append(", countryCode=").append(this.countryCode).append(", userName=").append(this.userName).append(", screenName=").append(this.screenName).append(", userEmail=");
        r0.append(this.userEmail).append(", userMobile=").append(this.userMobile).append(", hasPassword=").append(this.hasPassword).append(", userGender=").append(this.userGender).append(", isNewUser=").append(this.isNewUser).append(", userSession=").append(this.userSession).append(", loginUtcTime=").append(this.loginUtcTime).append(", loginPhoneNumber=").append(this.loginPhoneNumber).append(')');
        return r0.toString();
    }

    public AccountInfo(boolean r14, int r15, String r16, String r17, int r18, String r19, String r20, String r21, int r22, String r23, String r24, String r25, String r26, boolean r27, int r28, boolean r29, String r30, long r31, String r33) {
        Intrinsics.checkNotNullParameter(r16, AccountInfoBundleKey.SEC_USER_ID);
        Intrinsics.checkNotNullParameter(r17, AccountInfoBundleKey.USER_ID);
        Intrinsics.checkNotNullParameter(r19, "xTTToken");
        Intrinsics.checkNotNullParameter(r20, "innerSSOToken");
        Intrinsics.checkNotNullParameter(r21, AccountInfoBundleKey.AVATAR_URL);
        Intrinsics.checkNotNullParameter(r23, AccountInfoBundleKey.USER_NAME);
        Intrinsics.checkNotNullParameter(r24, AccountInfoBundleKey.SCREEN_NAME);
        Intrinsics.checkNotNullParameter(r25, AccountInfoBundleKey.USER_EMAIL);
        Intrinsics.checkNotNullParameter(r26, AccountInfoBundleKey.USER_MOBILE);
        Intrinsics.checkNotNullParameter(r30, AccountInfoBundleKey.USER_SESSION);
        Intrinsics.checkNotNullParameter(r33, AccountInfoBundleKey.LOGIN_PHONE_NUMBER);
        this.loginState = r14;
        this.logoutScene = r15;
        this.secUserId = r16;
        this.userId = r17;
        this.odinUserType = r18;
        this.xTTToken = r19;
        this.innerSSOToken = r20;
        this.avatarUrl = r21;
        this.countryCode = r22;
        this.userName = r23;
        this.screenName = r24;
        this.userEmail = r25;
        this.userMobile = r26;
        this.hasPassword = r27;
        this.userGender = r28;
        this.isNewUser = r29;
        this.userSession = r30;
        this.loginUtcTime = r31;
        this.loginPhoneNumber = r33;
    }

    public /* synthetic */ AccountInfo(boolean r22, int r23, String r24, String r25, int r26, String r27, String r28, String r29, int r30, String r31, String r32, String r33, String r34, boolean r35, int r36, boolean r37, String r38, long r39, String r41, int r42, DefaultConstructorMarker r43) {
        if ((r42 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r42 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r42 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r42 & 16) == 0) goto L21;
        int r7 = 0;
    L23:
        if ((r42 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r42 & 64) == 0) goto L29;
        String r9 = "";
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r42 & 256) == 0) goto L37;
        int r11 = 86;
    L39:
        if ((r42 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r13 = "";
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r14 = "";
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r42 & 8192) == 0) goto L57;
        boolean r2 = false;
    L59:
        if ((r42 & 16384) == 0) goto L61;
        int r5 = 0;
    L63:
        if ((r42 & 32768) == 0) goto L65;
        boolean r16 = false;
    L67:
        if ((r42 & 65536) == 0) goto L69;
        String r17 = "";
    L71:
        if ((r42 & 131072) == 0) goto L73;
        long r18 = 0;
    L75:
        if ((r42 & 262144) == 0) goto L77;
        String r0 = "";
    L78:
        this(r1, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r5, r16, r17, r18, r0);
        return;
    L77:
        r0 = r41;
        goto L78
    L73:
        r18 = r39;
        goto L75
    L69:
        r17 = r38;
        goto L71
    L65:
        r16 = r37;
        goto L67
    L61:
        r5 = r36;
        goto L63
    L57:
        r2 = r35;
        goto L59
    L53:
        r15 = r34;
        goto L55
    L49:
        r14 = r33;
        goto L51
    L45:
        r13 = r32;
        goto L47
    L41:
        r12 = r31;
        goto L43
    L37:
        r11 = r30;
        goto L39
    L33:
        r10 = r29;
        goto L35
    L29:
        r9 = r28;
        goto L31
    L25:
        r8 = r27;
        goto L27
    L21:
        r7 = r26;
        goto L23
    L17:
        r6 = r25;
        goto L19
    L13:
        r4 = r24;
        goto L15
    L9:
        r3 = r23;
        goto L11
    L5:
        r1 = r22;
        goto L7
    }

    public final boolean getLoginState() {
        return this.loginState;
    }

    public final void setLoginState(boolean r1) {
        this.loginState = r1;
    }

    public final int getLogoutScene() {
        return this.logoutScene;
    }

    public final void setLogoutScene(int r1) {
        this.logoutScene = r1;
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final void setSecUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.secUserId = r2;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userId = r2;
    }

    public final int getOdinUserType() {
        return this.odinUserType;
    }

    public final void setOdinUserType(int r1) {
        this.odinUserType = r1;
    }

    public final String getXTTToken() {
        return this.xTTToken;
    }

    public final void setXTTToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.xTTToken = r2;
    }

    public final String getInnerSSOToken() {
        return this.innerSSOToken;
    }

    public final void setInnerSSOToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.innerSSOToken = r2;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final void setAvatarUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.avatarUrl = r2;
    }

    public final int getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode(int r1) {
        this.countryCode = r1;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userName = r2;
    }

    public final String getScreenName() {
        return this.screenName;
    }

    public final void setScreenName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.screenName = r2;
    }

    public final String getUserEmail() {
        return this.userEmail;
    }

    public final void setUserEmail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userEmail = r2;
    }

    public final String getUserMobile() {
        return this.userMobile;
    }

    public final void setUserMobile(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userMobile = r2;
    }

    public final boolean getHasPassword() {
        return this.hasPassword;
    }

    public final void setHasPassword(boolean r1) {
        this.hasPassword = r1;
    }

    public final int getUserGender() {
        return this.userGender;
    }

    public final void setUserGender(int r1) {
        this.userGender = r1;
    }

    public final boolean isNewUser() {
        return this.isNewUser;
    }

    public final void setNewUser(boolean r1) {
        this.isNewUser = r1;
    }

    public final String getUserSession() {
        return this.userSession;
    }

    public final void setUserSession(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.userSession = r2;
    }

    public final long getLoginUtcTime() {
        return this.loginUtcTime;
    }

    public final void setLoginUtcTime(long r1) {
        this.loginUtcTime = r1;
    }

    public final String getLoginPhoneNumber() {
        return this.loginPhoneNumber;
    }

    public final void setLoginPhoneNumber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.loginPhoneNumber = r2;
    }
}
