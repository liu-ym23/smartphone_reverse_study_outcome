package androidx.appsearch.app;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class AppSearchEnvironmentFactory {
    private static volatile AppSearchEnvironment sAppSearchEnvironment;

    private AppSearchEnvironmentFactory() {
    }

    public static AppSearchEnvironment getEnvironmentInstance() {
        AppSearchEnvironment jetpackAppSearchEnvironment;
        AppSearchEnvironment appSearchEnvironment = sAppSearchEnvironment;
        if (appSearchEnvironment != null) {
            return appSearchEnvironment;
        }
        synchronized (AppSearchEnvironmentFactory.class) {
            try {
                jetpackAppSearchEnvironment = sAppSearchEnvironment;
                if (jetpackAppSearchEnvironment == null) {
                    jetpackAppSearchEnvironment = new JetpackAppSearchEnvironment();
                    sAppSearchEnvironment = jetpackAppSearchEnvironment;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return jetpackAppSearchEnvironment;
    }

    @VisibleForTesting
    public static void setEnvironmentInstanceForTest(AppSearchEnvironment appSearchEnvironment) {
        synchronized (AppSearchEnvironmentFactory.class) {
            sAppSearchEnvironment = appSearchEnvironment;
        }
    }
}
