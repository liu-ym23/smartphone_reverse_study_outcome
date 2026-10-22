package com.stepos.stepclaw.base.util;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005¨\u0006\n"}, d2 = {"Lcom/stepos/stepclaw/base/util/SessionKeyUtils;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "normalizeMainKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "raw", "isCanonicalMainSessionKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "key", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SessionKeyUtils {
    public static final SessionKeyUtils INSTANCE = new SessionKeyUtils();

    private SessionKeyUtils() {
    }

    public final boolean isCanonicalMainSessionKey(String key) {
        p.e(key, "key");
        return key.equals("main");
    }

    public final String normalizeMainKey(String raw) {
        String string = raw != null ? n.T1(raw).toString() : null;
        if (string == null) {
            string = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if (string.length() == 0) {
            return null;
        }
        return string;
    }
}
