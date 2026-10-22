package com.stepos.stepclaw.gateway;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003¨\u0006\b"}, d2 = {"parseInvokeErrorMessage", "Lcom/stepos/stepclaw/gateway/ParsedInvokeError;", "raw", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "parseInvokeErrorFromThrowable", "err", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fallbackMessage", "step-runtime_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InvokeErrorParserKt {
    public static final ParsedInvokeError parseInvokeErrorFromThrowable(Throwable err, String fallbackMessage) {
        p.e(err, "err");
        p.e(fallbackMessage, "fallbackMessage");
        String message = err.getMessage();
        String string = message != null ? n.T1(message).toString() : null;
        String str = string == null || string.length() == 0 ? null : string;
        if (str != null) {
            fallbackMessage = str;
        }
        return parseInvokeErrorMessage(fallbackMessage);
    }

    public static /* synthetic */ ParsedInvokeError parseInvokeErrorFromThrowable$default(Throwable th, String str, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = "error";
        }
        return parseInvokeErrorFromThrowable(th, str);
    }

    public static final ParsedInvokeError parseInvokeErrorMessage(String raw) {
        p.e(raw, "raw");
        String string = n.T1(raw).toString();
        if (string.length() == 0) {
            return new ParsedInvokeError("UNAVAILABLE", "error", false);
        }
        List listG1 = n.G1(string, new String[]{":"}, 2, 2);
        if (listG1.size() == 2) {
            String string2 = n.T1((String) listG1.get(0)).toString();
            String string3 = n.T1((String) listG1.get(1)).toString();
            if (string2.length() > 0) {
                for (int i8 = 0; i8 < string2.length(); i8++) {
                    char cCharAt = string2.charAt(i8);
                    if (Character.isUpperCase(cCharAt) || cCharAt == '_') {
                    }
                }
                if (string3.length() != 0) {
                    string = string3;
                }
                return new ParsedInvokeError(string2, string, true);
            }
        }
        return new ParsedInvokeError("UNAVAILABLE", string, false);
    }
}
