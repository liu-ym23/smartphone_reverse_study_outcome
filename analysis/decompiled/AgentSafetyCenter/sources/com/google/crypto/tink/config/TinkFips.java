package com.google.crypto.tink.config;

import com.google.crypto.tink.Registry;
import com.google.crypto.tink.config.internal.TinkFipsUtil;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class TinkFips {
    private TinkFips() {
    }

    public static void restrictToFips() {
        Registry.restrictToFipsIfEmpty();
    }

    public static boolean useOnlyFips() {
        return TinkFipsUtil.useOnlyFips();
    }
}
