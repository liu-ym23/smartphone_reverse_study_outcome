package com.stepos.stepclaw.memory.utils;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/memory/utils/TokenEstimator;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "estimate", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "text", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isCjk", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "c", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TokenEstimator {
    public static final TokenEstimator INSTANCE = new TokenEstimator();

    private TokenEstimator() {
    }

    private final boolean isCjk(char c3) {
        if (19968 <= c3 && c3 < 40960) {
            return true;
        }
        if (13312 <= c3 && c3 < 19904) {
            return true;
        }
        if (63744 <= c3 && c3 < 64256) {
            return true;
        }
        if (12352 <= c3 && c3 < 12448) {
            return true;
        }
        if (12448 > c3 || c3 >= 12544) {
            return 44032 <= c3 && c3 < 55296;
        }
        return true;
    }

    public final int estimate(String text) {
        p.e(text, "text");
        if (text.length() == 0) {
            return 0;
        }
        int length = text.length();
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            if (isCjk(text.charAt(i10))) {
                i8++;
            } else {
                i9++;
            }
        }
        return ((i9 + 3) / 4) + i8;
    }
}
