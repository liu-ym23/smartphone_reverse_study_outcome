package com.stepos.policy.sdk.util;

import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySecretLogRedactor {
    public static final PolicySecretLogRedactor INSTANCE = new PolicySecretLogRedactor();
    private static final Regex JSON_SECRET;

    static {
        RegexOption regexOption = RegexOption.f10095b;
        JSON_SECRET = new Regex("\"secret\"\\s*:\\s*\"[^\"]*\"", 0);
    }

    private PolicySecretLogRedactor() {
    }

    public static final String redact(String message) {
        kotlin.jvm.internal.g.f(message, "message");
        return message.length() == 0 ? message : JSON_SECRET.d(message, "\"secret\":\"***\"");
    }
}
