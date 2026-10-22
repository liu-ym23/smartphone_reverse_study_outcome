package io.ktor.http;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "key", UxipConstants.f30680s, "encodeContentDispositionAttribute", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContentDispositionKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodeContentDispositionAttribute(String str, String str2) {
        if (!kotlin.jvm.internal.p.d(str, ContentDisposition.Parameters.FileNameAsterisk) || La.D.V(str2, "utf-8''", true)) {
            return str2;
        }
        for (int i10 = 0; i10 < str2.length(); i10++) {
            if (!CodecsKt.getATTRIBUTE_CHARACTERS().contains(Character.valueOf(str2.charAt(i10)))) {
                return "utf-8''" + CodecsKt.percentEncode(str2, CodecsKt.getATTRIBUTE_CHARACTERS());
            }
        }
        return str2;
    }
}
