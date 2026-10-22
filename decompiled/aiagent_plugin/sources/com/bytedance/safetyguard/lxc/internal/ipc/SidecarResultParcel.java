package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarResultParcel implements Parcelable {
    public static final Parcelable.Creator<SidecarResultParcel> CREATOR = null;
    private final long accessTokenExpiresAtMillis;
    private final String appId;
    private final int brand;
    private final int code;
    private final String currentUserName;
    private final long expiresAtMillis;
    private final boolean hasBotToken;
    private final boolean hasSubcode;
    private final boolean hasUserToken;
    private final String hint;
    private final boolean loggedIn;
    private final String message;
    private final String operationId;
    private final int protocolVersion;
    private final String proxyKey;
    private final long refreshTokenExpiresAtMillis;
    private final int resultType;
    private final List<String> scopes;
    private final String sessionId;
    private final int subcode;
    private final String subtype;
    private final boolean success;
    private final String type;
    private final String userOpenId;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<SidecarResultParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SidecarResultParcel createFromParcel(Parcel r34) {
            o.e(r34, "parcel");
            int r3 = r34.readInt();
            String r4 = r34.readString();
            int r5 = r34.readInt();
            if (r34.readInt() == 0) goto L5;
            boolean r8 = true;
        L6:
            int r9 = r34.readInt();
            String r10 = r34.readString();
            String r11 = r34.readString();
            String r12 = r34.readString();
            String r13 = r34.readString();
            String r14 = r34.readString();
            String r15 = r34.readString();
            String r16 = r34.readString();
            int r17 = r34.readInt();
            List r19 = (List) ZeusTransformUtils.preCheckCast(r34.createStringArrayList(), List.class, "com.obric.aiagent.plugin");
            int r20 = r34.readInt();
            if (r34.readInt() == 0) goto L9;
            boolean r21 = true;
        L11:
            if (r34.readInt() == 0) goto L13;
            boolean r30 = true;
        L15:
            if (r34.readInt() == 0) goto L17;
            boolean r31 = true;
        L19:
            if (r34.readInt() == 0) goto L21;
            boolean r32 = true;
        L22:
            boolean r6 = r8;
            boolean r18 = r21;
            boolean r110 = r30;
            boolean r22 = r31;
            boolean r23 = r32;
            return new SidecarResultParcel(r3, r4, r5, r6, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r20, r18, r110, r22, r23, r34.readLong(), r34.readLong(), r34.readString(), r34.readLong(), r34.readString());
        L21:
            r32 = false;
            goto L22
        L17:
            r31 = false;
            goto L19
        L13:
            r30 = false;
            goto L15
        L9:
            r21 = false;
            goto L11
        L5:
            r8 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SidecarResultParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SidecarResultParcel[] newArray(int r1) {
            return new SidecarResultParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SidecarResultParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ SidecarResultParcel copy$default(SidecarResultParcel r17, int r18, String r19, int r20, boolean r21, int r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, int r30, List r31, int r32, boolean r33, boolean r34, boolean r35, boolean r36, long r37, long r39, String r41, long r42, String r44, int r45, Object r46) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        if ((r45 & 1) == 0) goto L5;
        int r3 = r17.protocolVersion;
    L7:
        if ((r45 & 2) == 0) goto L9;
        String r4 = r17.operationId;
    L11:
        if ((r45 & 4) == 0) goto L13;
        int r5 = r17.resultType;
    L15:
        if ((r45 & 8) == 0) goto L17;
        boolean r6 = r17.success;
    L19:
        if ((r45 & 16) == 0) goto L21;
        int r7 = r17.code;
    L23:
        if ((r45 & 32) == 0) goto L25;
        String r8 = r17.type;
    L27:
        if ((r45 & 64) == 0) goto L29;
        String r9 = r17.subtype;
    L31:
        if ((r45 & 128) == 0) goto L33;
        String r10 = r17.message;
    L35:
        if ((r45 & 256) == 0) goto L37;
        String r11 = r17.hint;
    L39:
        if ((r45 & 512) == 0) goto L41;
        String r12 = r17.appId;
    L43:
        if ((r45 & 1024) == 0) goto L45;
        String r13 = r17.userOpenId;
    L47:
        if ((r45 & 2048) == 0) goto L49;
        String r14 = r17.currentUserName;
    L51:
        if ((r45 & 4096) == 0) goto L53;
        int r15 = r17.brand;
    L55:
        if ((r45 & 8192) == 0) goto L57;
        List<String> r16 = r17.scopes;
    L58:
        List<String> r38 = r16;
        if ((r45 & 16384) == 0) goto L61;
        int r40 = r17.subcode;
    L62:
        int r310 = r40;
        if ((r45 & 32768) == 0) goto L65;
        boolean r43 = r17.hasSubcode;
    L66:
        boolean r311 = r43;
        if ((r45 & 65536) == 0) goto L69;
        boolean r47 = r17.loggedIn;
    L70:
        boolean r312 = r47;
        if ((r45 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
        boolean r48 = r17.hasUserToken;
    L74:
        boolean r313 = r48;
        if ((r45 & 262144) == 0) goto L77;
        boolean r49 = r17.hasBotToken;
    L78:
        String r210 = r14;
        int r314 = r15;
        if ((r45 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
        long r110 = r17.accessTokenExpiresAtMillis;
    L82:
        long r315 = r110;
        if ((r45 & 1048576) == 0) goto L85;
        long r111 = r17.refreshTokenExpiresAtMillis;
    L86:
        long r316 = r111;
        if ((r45 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
        String r112 = r17.sessionId;
    L90:
        String r410 = r112;
        if ((4194304 & r45) == 0) goto L93;
        long r113 = r17.expiresAtMillis;
    L95:
        if ((r45 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
        String r1 = r17.proxyKey;
    L99:
        return r17.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r210, r314, r38, r310, r311, r312, r313, r49, r315, r316, r410, r113, r1);
    L97:
        r1 = r44;
        goto L99
    L93:
        r113 = r42;
        goto L95
    L89:
        r112 = r41;
        goto L90
    L85:
        r111 = r39;
        goto L86
    L81:
        r110 = r37;
        goto L82
    L77:
        r49 = r36;
        goto L78
    L73:
        r48 = r35;
        goto L74
    L69:
        r47 = r34;
        goto L70
    L65:
        r43 = r33;
        goto L66
    L61:
        r40 = r32;
        goto L62
    L57:
        r16 = r2;
        goto L58
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public final int component1() {
        return this.protocolVersion;
    }

    public final String component10() {
        return this.appId;
    }

    public final String component11() {
        return this.userOpenId;
    }

    public final String component12() {
        return this.currentUserName;
    }

    public final int component13() {
        return this.brand;
    }

    public final List<String> component14() {
        return this.scopes;
    }

    public final int component15() {
        return this.subcode;
    }

    public final boolean component16() {
        return this.hasSubcode;
    }

    public final boolean component17() {
        return this.loggedIn;
    }

    public final boolean component18() {
        return this.hasUserToken;
    }

    public final boolean component19() {
        return this.hasBotToken;
    }

    public final String component2() {
        return this.operationId;
    }

    public final long component20() {
        return this.accessTokenExpiresAtMillis;
    }

    public final long component21() {
        return this.refreshTokenExpiresAtMillis;
    }

    public final String component22() {
        return this.sessionId;
    }

    public final long component23() {
        return this.expiresAtMillis;
    }

    public final String component24() {
        return this.proxyKey;
    }

    public final int component3() {
        return this.resultType;
    }

    public final boolean component4() {
        return this.success;
    }

    public final int component5() {
        return this.code;
    }

    public final String component6() {
        return this.type;
    }

    public final String component7() {
        return this.subtype;
    }

    public final String component8() {
        return this.message;
    }

    public final String component9() {
        return this.hint;
    }

    public final SidecarResultParcel copy(int r30, String r31, int r32, boolean r33, int r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, int r42, List<String> r43, int r44, boolean r45, boolean r46, boolean r47, boolean r48, long r49, long r51, String r53, long r54, String r56) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.aiagent.plugin");
        o.e(r31, "operationId");
        o.e(r37, "message");
        o.e(r0, "scopes");
        return new SidecarResultParcel(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r0, r44, r45, r46, r47, r48, r49, r51, r53, r54, r56);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SidecarResultParcel.class) == true) goto L8;
        return false;
    L8:
        SidecarResultParcel r10 = (SidecarResultParcel) ZeusTransformUtils.preCheckCast(r9, SidecarResultParcel.class, "com.obric.aiagent.plugin");
        if (this.protocolVersion == r10.protocolVersion) goto L12;
        return false;
    L12:
        if (o.a(this.operationId, r10.operationId) == true) goto L15;
        return false;
    L15:
        if (this.resultType == r10.resultType) goto L18;
        return false;
    L18:
        if (this.success == r10.success) goto L21;
        return false;
    L21:
        if (this.code == r10.code) goto L24;
        return false;
    L24:
        if (o.a(this.type, r10.type) == true) goto L27;
        return false;
    L27:
        if (o.a(this.subtype, r10.subtype) == true) goto L30;
        return false;
    L30:
        if (o.a(this.message, r10.message) == true) goto L33;
        return false;
    L33:
        if (o.a(this.hint, r10.hint) == true) goto L36;
        return false;
    L36:
        if (o.a(this.appId, r10.appId) == true) goto L39;
        return false;
    L39:
        if (o.a(this.userOpenId, r10.userOpenId) == true) goto L42;
        return false;
    L42:
        if (o.a(this.currentUserName, r10.currentUserName) == true) goto L45;
        return false;
    L45:
        if (this.brand == r10.brand) goto L48;
        return false;
    L48:
        if (o.a(this.scopes, r10.scopes) == true) goto L51;
        return false;
    L51:
        if (this.subcode == r10.subcode) goto L54;
        return false;
    L54:
        if (this.hasSubcode == r10.hasSubcode) goto L57;
        return false;
    L57:
        if (this.loggedIn == r10.loggedIn) goto L60;
        return false;
    L60:
        if (this.hasUserToken == r10.hasUserToken) goto L63;
        return false;
    L63:
        if (this.hasBotToken == r10.hasBotToken) goto L66;
        return false;
    L66:
        if (this.accessTokenExpiresAtMillis == r10.accessTokenExpiresAtMillis) goto L69;
        return false;
    L69:
        if (this.refreshTokenExpiresAtMillis == r10.refreshTokenExpiresAtMillis) goto L72;
        return false;
    L72:
        if (o.a(this.sessionId, r10.sessionId) == true) goto L75;
        return false;
    L75:
        if (this.expiresAtMillis == r10.expiresAtMillis) goto L78;
        return false;
    L78:
        if (o.a(this.proxyKey, r10.proxyKey) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((Integer.hashCode(this.protocolVersion) * 31) + this.operationId.hashCode()) * 31) + Integer.hashCode(this.resultType)) * 31) + Boolean.hashCode(this.success)) * 31) + Integer.hashCode(this.code)) * 31;
        String r1 = this.type;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.subtype;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.message.hashCode()) * 31;
        String r8 = this.hint;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.appId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.userOpenId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.currentUserName;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((((((((((((((((((r16 + r18) * 31) + Integer.hashCode(this.brand)) * 31) + this.scopes.hashCode()) * 31) + Integer.hashCode(this.subcode)) * 31) + Boolean.hashCode(this.hasSubcode)) * 31) + Boolean.hashCode(this.loggedIn)) * 31) + Boolean.hashCode(this.hasUserToken)) * 31) + Boolean.hashCode(this.hasBotToken)) * 31) + Long.hashCode(this.accessTokenExpiresAtMillis)) * 31) + Long.hashCode(this.refreshTokenExpiresAtMillis)) * 31;
        String r20 = this.sessionId;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((r19 + r21) * 31) + Long.hashCode(this.expiresAtMillis)) * 31;
        String r23 = this.proxyKey;
        if (r23 == null) goto L35;
        r2 = r23.hashCode();
    L35:
        return r22 + r2;
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SidecarResultParcel(protocolVersion=").append(this.protocolVersion).append(", operationId=").append(this.operationId).append(", resultType=").append(this.resultType).append(", success=").append(this.success).append(", code=").append(this.code).append(", type=").append(this.type).append(", subtype=").append(this.subtype).append(", message=").append(this.message).append(", hint=").append(this.hint).append(", appId=").append(this.appId).append(", userOpenId=").append(this.userOpenId).append(", currentUserName=");
        r0.append(this.currentUserName).append(", brand=").append(this.brand).append(", scopes=").append(this.scopes).append(", subcode=").append(this.subcode).append(", hasSubcode=").append(this.hasSubcode).append(", loggedIn=").append(this.loggedIn).append(", hasUserToken=").append(this.hasUserToken).append(", hasBotToken=").append(this.hasBotToken).append(", accessTokenExpiresAtMillis=").append(this.accessTokenExpiresAtMillis).append(", refreshTokenExpiresAtMillis=").append(this.refreshTokenExpiresAtMillis).append(", sessionId=").append(this.sessionId).append(", expiresAtMillis=").append(this.expiresAtMillis);
        r0.append(", proxyKey=").append(this.proxyKey).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "out");
        r3.writeInt(this.protocolVersion);
        r3.writeString(this.operationId);
        r3.writeInt(this.resultType);
        r3.writeInt(this.success ? 1 : 0);
        r3.writeInt(this.code);
        r3.writeString(this.type);
        r3.writeString(this.subtype);
        r3.writeString(this.message);
        r3.writeString(this.hint);
        r3.writeString(this.appId);
        r3.writeString(this.userOpenId);
        r3.writeString(this.currentUserName);
        r3.writeInt(this.brand);
        r3.writeStringList(this.scopes);
        r3.writeInt(this.subcode);
        r3.writeInt(this.hasSubcode ? 1 : 0);
        r3.writeInt(this.loggedIn ? 1 : 0);
        r3.writeInt(this.hasUserToken ? 1 : 0);
        r3.writeInt(this.hasBotToken ? 1 : 0);
        r3.writeLong(this.accessTokenExpiresAtMillis);
        r3.writeLong(this.refreshTokenExpiresAtMillis);
        r3.writeString(this.sessionId);
        r3.writeLong(this.expiresAtMillis);
        r3.writeString(this.proxyKey);
    }

    public SidecarResultParcel(int r7, String r8, int r9, boolean r10, int r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19, List<String> r20, int r21, boolean r22, boolean r23, boolean r24, boolean r25, long r26, long r28, String r30, long r31, String r33) {
        List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        o.e(r8, "operationId");
        o.e(r14, "message");
        o.e(r3, "scopes");
        this.protocolVersion = r7;
        this.operationId = r8;
        this.resultType = r9;
        this.success = r10;
        this.code = r11;
        this.type = r12;
        this.subtype = r13;
        this.message = r14;
        this.hint = r15;
        this.appId = r16;
        this.userOpenId = r17;
        this.currentUserName = r18;
        this.brand = r19;
        this.scopes = r3;
        this.subcode = r21;
        this.hasSubcode = r22;
        this.loggedIn = r23;
        this.hasUserToken = r24;
        this.hasBotToken = r25;
        this.accessTokenExpiresAtMillis = r26;
        this.refreshTokenExpiresAtMillis = r28;
        this.sessionId = r30;
        this.expiresAtMillis = r31;
        this.proxyKey = r33;
    }

    public final int getProtocolVersion() {
        return this.protocolVersion;
    }

    public final String getOperationId() {
        return this.operationId;
    }

    public final int getResultType() {
        return this.resultType;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSubtype() {
        return this.subtype;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getUserOpenId() {
        return this.userOpenId;
    }

    public final String getCurrentUserName() {
        return this.currentUserName;
    }

    public final int getBrand() {
        return this.brand;
    }

    public /* synthetic */ SidecarResultParcel(int r32, String r33, int r34, boolean r35, int r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, int r44, List r45, int r46, boolean r47, boolean r48, boolean r49, boolean r50, long r51, long r53, String r55, long r56, String r58, int r59, h r60) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r45, List.class, "com.obric.aiagent.plugin");
        if ((r59 & 1) == 0) goto L5;
        int r4 = 3;
    L7:
        if ((r59 & 4) == 0) goto L9;
        int r6 = 1;
    L11:
        if ((r59 & 32) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r59 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r59 & 256) == 0) goto L21;
        String r12 = null;
    L23:
        if ((r59 & 512) == 0) goto L25;
        String r13 = null;
    L27:
        if ((r59 & 1024) == 0) goto L29;
        String r14 = null;
    L31:
        if ((r59 & 2048) == 0) goto L33;
        String r15 = null;
    L35:
        if ((r59 & 4096) == 0) goto L37;
        int r16 = -1;
    L39:
        if ((r59 & 8192) == 0) goto L41;
        r1 = p.b();
    L41:
        List r17 = r1;
        if ((r59 & 16384) == 0) goto L44;
        int r18 = 0;
    L46:
        if ((32768 & r59) == 0) goto L48;
        boolean r19 = false;
    L50:
        if ((65536 & r59) == 0) goto L52;
        boolean r20 = false;
    L54:
        if ((131072 & r59) == 0) goto L56;
        boolean r21 = false;
    L58:
        if ((262144 & r59) == 0) goto L60;
        boolean r22 = false;
    L62:
        if ((524288 & r59) == 0) goto L64;
        long r23 = -1;
    L66:
        if ((1048576 & r59) == 0) goto L68;
        long r25 = -1;
    L70:
        if ((2097152 & r59) == 0) goto L72;
        String r27 = null;
    L74:
        if ((4194304 & r59) == 0) goto L76;
        long r28 = 0;
    L78:
        if ((r59 & UiType.FLAG_APPLET_CARD) == 0) goto L80;
        String r30 = null;
    L81:
        this(r4, r33, r6, r35, r36, r9, r10, r39, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r27, r28, r30);
        return;
    L80:
        r30 = r58;
        goto L81
    L76:
        r28 = r56;
        goto L78
    L72:
        r27 = r55;
        goto L74
    L68:
        r25 = r53;
        goto L70
    L64:
        r23 = r51;
        goto L66
    L60:
        r22 = r50;
        goto L62
    L56:
        r21 = r49;
        goto L58
    L52:
        r20 = r48;
        goto L54
    L48:
        r19 = r47;
        goto L50
    L44:
        r18 = r46;
        goto L46
    L37:
        r16 = r44;
        goto L39
    L33:
        r15 = r43;
        goto L35
    L29:
        r14 = r42;
        goto L31
    L25:
        r13 = r41;
        goto L27
    L21:
        r12 = r40;
        goto L23
    L17:
        r10 = r38;
        goto L19
    L13:
        r9 = r37;
        goto L15
    L9:
        r6 = r34;
        goto L11
    L5:
        r4 = r32;
        goto L7
    }

    public final List<String> getScopes() {
        return this.scopes;
    }

    public final int getSubcode() {
        return this.subcode;
    }

    public final boolean getHasSubcode() {
        return this.hasSubcode;
    }

    public final boolean getLoggedIn() {
        return this.loggedIn;
    }

    public final boolean getHasUserToken() {
        return this.hasUserToken;
    }

    public final boolean getHasBotToken() {
        return this.hasBotToken;
    }

    public final long getAccessTokenExpiresAtMillis() {
        return this.accessTokenExpiresAtMillis;
    }

    public final long getRefreshTokenExpiresAtMillis() {
        return this.refreshTokenExpiresAtMillis;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getExpiresAtMillis() {
        return this.expiresAtMillis;
    }

    public final String getProxyKey() {
        return this.proxyKey;
    }
}
