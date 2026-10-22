package com.stepos.cloud.securedata;

import a1.a;
import com.stepos.cloud.securedata.SecureDataLogSanitizer;
import d7.h0;
import ga.g;
import ga.h;
import ga.i;
import kotlin.Metadata;
import p7.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/cloud/securedata/SecureDataLogSanitizer;", "", "", "value", "", "maxLength", "previewValue", "(Ljava/lang/String;I)Ljava/lang/String;", "body", "sanitizeJsonBody", "(Ljava/lang/String;)Ljava/lang/String;", "", "a", "Z", "getFullValueLoggingEnabled", "()Z", "setFullValueLoggingEnabled", "(Z)V", "fullValueLoggingEnabled", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SecureDataLogSanitizer {
    public static final SecureDataLogSanitizer INSTANCE = new SecureDataLogSanitizer();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static volatile boolean fullValueLoggingEnabled;

    public static String a(String str, String str2, final int i2) {
        return new i(a.j("(\"", str2, "\"\\s*:\\s*\")([^\"]*)(\")")).d(str, new k() { // from class: v6.a
            @Override // p7.k
            public final Object invoke(Object obj) {
                return SecureDataLogSanitizer.a(i2, (g) obj);
            }
        });
    }

    public static /* synthetic */ String previewValue$default(SecureDataLogSanitizer secureDataLogSanitizer, String str, int i2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i2 = 120;
        }
        return secureDataLogSanitizer.previewValue(str, i2);
    }

    public final boolean getFullValueLoggingEnabled() {
        return fullValueLoggingEnabled;
    }

    public final String previewValue(String value, int maxLength) {
        q7.k.e(value, "value");
        if (fullValueLoggingEnabled || value.length() <= maxLength) {
            return value;
        }
        return ga.k.L0(maxLength, value) + "...(" + value.length() + " chars)";
    }

    public final String sanitizeJsonBody(String body) {
        q7.k.e(body, "body");
        if (fullValueLoggingEnabled) {
            return body;
        }
        String strA = a(body, "encryptedAesKey", 32);
        INSTANCE.getClass();
        return a(a(a(a(strA, "publicKey", 64), "token", 16), "ciphertext", 64), "plaintext", 120);
    }

    public final void setFullValueLoggingEnabled(boolean z4) {
        fullValueLoggingEnabled = z4;
    }

    public static final CharSequence a(int i2, g gVar) {
        q7.k.e(gVar, "match");
        h hVar = (h) gVar;
        String strPreviewValue = INSTANCE.previewValue((String) ((h0) hVar.a()).get(2), i2);
        return ((h0) hVar.a()).get(1) + strPreviewValue + ((h0) hVar.a()).get(3);
    }
}
