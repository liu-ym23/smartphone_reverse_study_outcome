package androidx.compose.runtime.internal;

import android.util.Log;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "message", "", "e", "LC7/r;", "logError", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "LogTag", "Ljava/lang/String;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Utils_androidKt {
    private static final String LogTag = "ComposeInternal";

    public static final void logError(String str, Throwable th) {
        Log.e(LogTag, str, th);
    }
}
