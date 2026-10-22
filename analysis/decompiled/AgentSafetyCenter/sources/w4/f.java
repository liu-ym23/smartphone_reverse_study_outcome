package w4;

import android.security.keystore.KeyGenParameterSpec;
import com.fasterxml.jackson.core.ErrorReportConfiguration;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f15227a;

    static {
        new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH).build();
        f15227a = new Object();
    }
}
