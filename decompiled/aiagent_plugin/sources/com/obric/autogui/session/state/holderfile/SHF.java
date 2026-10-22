package com.obric.autogui.session.state.holderfile;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SHF.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SHF {
    private final String attestationString;
    private final String deviceId;
    private final Long doubaoMsgId;
    private final String query;
    private final String sessionId;
    private final String sessionKey;
    private final int sessionOrigin;

    public static /* synthetic */ SHF copy$default(SHF r5, String r6, String r7, int r8, String r9, Long r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.sessionId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.sessionKey;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.sessionOrigin;
    L11:
        int r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.query;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.doubaoMsgId;
    L17:
        Long r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.deviceId;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.attestationString;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.sessionKey;
    }

    public final int component3() {
        return this.sessionOrigin;
    }

    public final String component4() {
        return this.query;
    }

    public final Long component5() {
        return this.doubaoMsgId;
    }

    public final String component6() {
        return this.deviceId;
    }

    public final String component7() {
        return this.attestationString;
    }

    public final SHF copy(String r9, String r10, int r11, String r12, Long r13, String r14, String r15) {
        o.e(r9, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r10, "sessionKey");
        o.e(r12, DownloadConstants.QUERY_KEY);
        return new SHF(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SHF.class) == true) goto L8;
        return false;
    L8:
        SHF r6 = (SHF) ZeusTransformUtils.preCheckCast(r5, SHF.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionId, r6.sessionId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.sessionKey, r6.sessionKey) == true) goto L15;
        return false;
    L15:
        if (this.sessionOrigin == r6.sessionOrigin) goto L18;
        return false;
    L18:
        if (o.a(this.query, r6.query) == true) goto L21;
        return false;
    L21:
        if (o.a(this.doubaoMsgId, r6.doubaoMsgId) == true) goto L24;
        return false;
    L24:
        if (o.a(this.deviceId, r6.deviceId) == true) goto L27;
        return false;
    L27:
        if (o.a(this.attestationString, r6.attestationString) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.sessionId.hashCode() * 31) + this.sessionKey.hashCode()) * 31) + Integer.hashCode(this.sessionOrigin)) * 31) + this.query.hashCode()) * 31;
        Long r1 = this.doubaoMsgId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.deviceId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.attestationString;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SHF(sessionId=" + this.sessionId + ", sessionKey=" + this.sessionKey + ", sessionOrigin=" + this.sessionOrigin + ", query=" + this.query + ", doubaoMsgId=" + this.doubaoMsgId + ", deviceId=" + this.deviceId + ", attestationString=" + this.attestationString + ')';
    }

    public SHF(String r2, String r3, int r4, String r5, Long r6, String r7, String r8) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r3, "sessionKey");
        o.e(r5, DownloadConstants.QUERY_KEY);
        this.sessionId = r2;
        this.sessionKey = r3;
        this.sessionOrigin = r4;
        this.query = r5;
        this.doubaoMsgId = r6;
        this.deviceId = r7;
        this.attestationString = r8;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final int getSessionOrigin() {
        return this.sessionOrigin;
    }

    public final String getQuery() {
        return this.query;
    }

    public final Long getDoubaoMsgId() {
        return this.doubaoMsgId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getAttestationString() {
        return this.attestationString;
    }
}
