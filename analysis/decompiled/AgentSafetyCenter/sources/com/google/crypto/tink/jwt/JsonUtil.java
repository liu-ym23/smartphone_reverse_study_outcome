package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.JsonParser;
import java.io.IOException;
import m7.f;
import m7.j;
import m7.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class JsonUtil {
    private JsonUtil() {
    }

    public static boolean isValidString(String str) {
        return JsonParser.isValidString(str);
    }

    public static j parseJson(String str) throws JwtInvalidException {
        try {
            return JsonParser.parse(str).e();
        } catch (IOException | IllegalStateException | k e10) {
            throw new JwtInvalidException("invalid JSON: " + e10);
        }
    }

    public static f parseJsonArray(String str) throws JwtInvalidException {
        try {
            return JsonParser.parse(str).d();
        } catch (IOException | IllegalStateException | k e10) {
            throw new JwtInvalidException("invalid JSON: " + e10);
        }
    }
}
