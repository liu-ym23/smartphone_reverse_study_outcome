package w6;

import android.util.Log;
import com.stepos.account.oauth.OAuthConstants;
import com.stepos.cloud.securedata.SecureDataLogSanitizer;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f10810a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static volatile boolean f10811b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile boolean f10812c;

    public static void a(String str) {
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (f10812c) {
            Log.d("StepOSCloudSecureDataSdk", str);
        }
    }

    public static void logHttpError$default(m mVar, String str, Throwable th, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            th = null;
        }
        mVar.getClass();
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        if (f10811b) {
            if (th == null) {
                Log.e("StepOSCloudSecureDataSdk", str);
            } else {
                Log.e("StepOSCloudSecureDataSdk", str, th);
            }
        }
    }

    public static String previewValue$default(m mVar, String str, int i2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i2 = 120;
        }
        mVar.getClass();
        q7.k.e(str, "value");
        return SecureDataLogSanitizer.INSTANCE.previewValue(str, i2);
    }
}
