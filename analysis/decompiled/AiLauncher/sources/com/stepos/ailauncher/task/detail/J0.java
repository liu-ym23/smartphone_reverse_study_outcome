package com.stepos.ailauncher.task.detail;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import o6.C5009a;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/task/detail/J0;", "", "<init>", "()V", "", "sessionId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "LY8/t;", "c", "(Ljava/lang/String;)V", Const.INTENT_KEY_PKGNAME, "MMKV_ID", "Ljava/lang/String;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class J0 {
    public static final J0 INSTANCE = new J0();
    private static final String MMKV_ID = "task_detail_chip_read";

    public final boolean a(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return false;
        }
        return C5009a.INSTANCE.h(MMKV_ID, sessionId, false);
    }

    public final void b(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        C5009a.INSTANCE.J(MMKV_ID, sessionId);
    }

    public final void c(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        if (sessionId.length() == 0) {
            return;
        }
        C5009a.INSTANCE.z(MMKV_ID, sessionId, true);
    }
}
