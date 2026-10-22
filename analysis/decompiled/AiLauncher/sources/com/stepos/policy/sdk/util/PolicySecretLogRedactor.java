package com.stepos.policy.sdk.util;

import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stepos/policy/sdk/util/PolicySecretLogRedactor;", "", "()V", "JSON_SECRET", "Lkotlin/text/Regex;", "redact", "", "message", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicySecretLogRedactor {
    public static final PolicySecretLogRedactor INSTANCE = new PolicySecretLogRedactor();
    private static final Regex JSON_SECRET = new Regex("\"secret\"\\s*:\\s*\"[^\"]*\"", RegexOption.IGNORE_CASE);

    private PolicySecretLogRedactor() {
    }

    public static final String redact(String message) {
        p.i(message, "message");
        return message.length() == 0 ? message : JSON_SECRET.l(message, "\"secret\":\"***\"");
    }
}
