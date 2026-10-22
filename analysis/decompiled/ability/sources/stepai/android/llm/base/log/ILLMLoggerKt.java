package stepai.android.llm.base.log;

import B7.a;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\n\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "level", "", "tag", "childTag", "message", "LC7/r;", "logWithChunks", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "text", "log", "(ILjava/lang/String;Ljava/lang/String;)V", "MAX_LOG_LENGTH", "I", "llmbase_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ILLMLoggerKt {
    private static final int MAX_LOG_LENGTH = 3000;

    private static final void log(int i, String str, String str2) {
        if (i == 2) {
            Log.v(str, str2);
            return;
        }
        if (i == 3) {
            Log.d(str, str2);
            return;
        }
        if (i == 4) {
            Log.i(str, str2);
            return;
        }
        if (i == 5) {
            Log.w(str, str2);
        } else if (i != 6) {
            Log.println(i, str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void logWithChunks(int i, String str, String str2, String str3) {
        if (str3.length() == 0) {
            log(i, str, a.m("[", str2, "]:"));
            return;
        }
        String strM = a.m("[", str2, "]:");
        int iMax = Math.max(1, 3000 - strM.length());
        int i6 = 0;
        while (i6 < str3.length()) {
            int iMin = Math.min(str3.length(), i6 + iMax);
            String strSubstring = str3.substring(i6, iMin);
            k.e(strSubstring, "substring(...)");
            log(i, str, strM.concat(strSubstring));
            i6 = iMin;
        }
    }
}
