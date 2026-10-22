package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/T;", "", "<init>", "()V", "", "fileId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "sessionId", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "MMKV_ID", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class T {
    public static final T INSTANCE = new T();
    private static final String MMKV_ID = "session_mapping";

    public final String a(String fileId) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        if (fileId.length() == 0) {
            return null;
        }
        String strV = C5009a.v(C5009a.INSTANCE, MMKV_ID, fileId, null, 4, null);
        if (strV.length() > 0) {
            return strV;
        }
        return null;
    }

    public final void b(String fileId, String sessionId) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (fileId.length() == 0 || sessionId.length() == 0) {
            return;
        }
        C5009a.INSTANCE.H(MMKV_ID, fileId, sessionId);
    }
}
