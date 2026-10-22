package c7;

import com.stepos.account.oauth.OAuthConstants;

/* loaded from: classes.dex */
public final class i extends Error {
    public i() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, int i2) {
        super(str);
        switch (i2) {
            case 3:
                q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
                super(str);
                break;
            default:
                q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
                break;
        }
    }
}
