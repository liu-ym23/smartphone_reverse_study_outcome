package com.obric.autogui.common.api.platform.account;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: LoggedInUserInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LoggedInUserInfo {
    private final Map<String, String> authHeaders;
    private final String userId;

    public static /* synthetic */ LoggedInUserInfo copy$default(LoggedInUserInfo r1, String r2, Map r3, int r4, Object r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.userId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.authHeaders;
    L9:
        return r1.copy(r2, r6);
    }

    public final String component1() {
        return this.userId;
    }

    public final Map<String, String> component2() {
        return this.authHeaders;
    }

    public final LoggedInUserInfo copy(String r2, Map<String, String> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r2, "userId");
        o.e(r1, "authHeaders");
        return new LoggedInUserInfo(r2, r1);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LoggedInUserInfo.class) == true) goto L8;
        return false;
    L8:
        LoggedInUserInfo r6 = (LoggedInUserInfo) ZeusTransformUtils.preCheckCast(r5, LoggedInUserInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.userId, r6.userId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.authHeaders, r6.authHeaders) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.authHeaders.hashCode();
    }

    public String toString() {
        return "LoggedInUserInfo(userId=" + this.userId + ", authHeaders=" + this.authHeaders + ')';
    }

    public LoggedInUserInfo(String r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "userId");
        o.e(r5, "authHeaders");
        this.userId = r3;
        this.authHeaders = r5;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Map<String, String> getAuthHeaders() {
        return this.authHeaders;
    }
}
