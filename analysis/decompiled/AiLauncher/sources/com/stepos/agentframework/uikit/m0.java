package com.stepos.agentframework.uikit;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/agentframework/uikit/m0;", "", "<init>", "()V", "", "incoming", "", "laidOutLen", "charsPerLine", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;II)I", "CHUNK_LINES", "I", "", "CHUNK_INTERVAL_MS", "J", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class m0 {
    public static final long CHUNK_INTERVAL_MS = 420;
    public static final int CHUNK_LINES = 5;
    public static final m0 INSTANCE = new m0();

    public final int a(String incoming, int laidOutLen, int charsPerLine) {
        kotlin.jvm.internal.p.i(incoming, "incoming");
        if (laidOutLen >= incoming.length()) {
            return incoming.length();
        }
        int iMin = Math.min(incoming.length(), (C5685n.f(charsPerLine, 1) * 5) + laidOutLen);
        String strSubstring = incoming.substring(laidOutLen, iMin);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        int iU0 = La.H.u0(strSubstring, "\n\n", 0, false, 6, null);
        if (iU0 >= 0) {
            return C5685n.j(laidOutLen + iU0 + 2, incoming.length());
        }
        int iA0 = La.H.A0(strSubstring, '\n', 0, false, 6, null);
        return iA0 >= C5685n.f(charsPerLine, 1) ? laidOutLen + iA0 + 1 : iMin;
    }
}
