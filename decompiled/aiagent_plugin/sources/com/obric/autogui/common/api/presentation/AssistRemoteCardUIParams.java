package com.obric.autogui.common.api.presentation;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: compiled from: AssistRemoteCardUIParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistRemoteCardUIParams implements Serializable {
    public static final Companion Companion = null;
    public static final int Finalize = 1;
    public static final int SAVE_SHORTCUT = 3;
    public static final int TIME_TASK_DELETE = 2;
    private final long doubaoMsgId;
    private final HashMap<String, Object> extras;
    private final String query;
    private final String sessionId;
    private final String sessionKey;
    private final int type;

    /* JADX INFO: compiled from: AssistRemoteCardUIParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AssistRemoteCardUIParams copy$default(AssistRemoteCardUIParams r5, int r6, String r7, String r8, String r9, long r10, HashMap r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.type;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.sessionId;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.sessionKey;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.query;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.doubaoMsgId;
    L17:
        long r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.extras;
    L20:
        int r11 = r6;
        return r5.copy(r11, r15, r0, r1, r2, r12);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final String component3() {
        return this.sessionKey;
    }

    public final String component4() {
        return this.query;
    }

    public final long component5() {
        return this.doubaoMsgId;
    }

    public final HashMap<String, Object> component6() {
        return this.extras;
    }

    public final AssistRemoteCardUIParams copy(int r9, String r10, String r11, String r12, long r13, HashMap<String, Object> r15) {
        o.e(r10, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r11, "sessionKey");
        o.e(r12, DownloadConstants.QUERY_KEY);
        return new AssistRemoteCardUIParams(r9, r10, r11, r12, r13, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AssistRemoteCardUIParams.class) == true) goto L8;
        return false;
    L8:
        AssistRemoteCardUIParams r10 = (AssistRemoteCardUIParams) ZeusTransformUtils.preCheckCast(r9, AssistRemoteCardUIParams.class, "com.obric.aiagent.plugin");
        if (this.type == r10.type) goto L12;
        return false;
    L12:
        if (o.a(this.sessionId, r10.sessionId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.sessionKey, r10.sessionKey) == true) goto L18;
        return false;
    L18:
        if (o.a(this.query, r10.query) == true) goto L21;
        return false;
    L21:
        if (this.doubaoMsgId == r10.doubaoMsgId) goto L24;
        return false;
    L24:
        if (o.a(this.extras, r10.extras) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((Integer.hashCode(this.type) * 31) + this.sessionId.hashCode()) * 31) + this.sessionKey.hashCode()) * 31) + this.query.hashCode()) * 31) + Long.hashCode(this.doubaoMsgId)) * 31;
        HashMap<String, Object> r3 = this.extras;
        if (r3 != null) goto L5;
        int r4 = 0;
    L7:
        return r0 + r4;
    L5:
        r4 = r3.hashCode();
        goto L7
    }

    public String toString() {
        return "AssistRemoteCardUIParams(type=" + this.type + ", sessionId=" + this.sessionId + ", sessionKey=" + this.sessionKey + ", query=" + this.query + ", doubaoMsgId=" + this.doubaoMsgId + ", extras=" + this.extras + ')';
    }

    public AssistRemoteCardUIParams(int r2, String r3, String r4, String r5, long r6, HashMap<String, Object> r8) {
        o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r4, "sessionKey");
        o.e(r5, DownloadConstants.QUERY_KEY);
        this.type = r2;
        this.sessionId = r3;
        this.sessionKey = r4;
        this.query = r5;
        this.doubaoMsgId = r6;
        this.extras = r8;
    }

    public /* synthetic */ AssistRemoteCardUIParams(int r10, String r11, String r12, String r13, long r14, HashMap r16, int r17, h r18) {
        if ((r17 & 32) == 0) goto L5;
        HashMap r8 = null;
    L6:
        this(r10, r11, r12, r13, r14, r8);
        return;
    L5:
        r8 = r16;
        goto L6
    }

    public final int getType() {
        return this.type;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionKey() {
        return this.sessionKey;
    }

    public final String getQuery() {
        return this.query;
    }

    public final long getDoubaoMsgId() {
        return this.doubaoMsgId;
    }

    public final HashMap<String, Object> getExtras() {
        return this.extras;
    }
}
