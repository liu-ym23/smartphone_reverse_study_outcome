package com.stepos.policy.sdk.util;

import j4.k;
import r4.C1028k;
import r4.EnumC1030m;

/* loaded from: classes.dex */
public final class PolicySecretLogRedactor {
    public static final PolicySecretLogRedactor INSTANCE = new PolicySecretLogRedactor();
    private static final C1028k JSON_SECRET = new C1028k("\"secret\"\\s*:\\s*\"[^\"]*\"", EnumC1030m.f20116c);

    private PolicySecretLogRedactor() {
    }

    public static final String redact(String str) {
        k.g(str, "message");
        return str.length() == 0 ? str : JSON_SECRET.f(str, "\"secret\":\"***\"");
    }
}
