package androidx.core.app;

import android.app.GrammaticalInflectionManager;
import android.content.Context;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes17.dex */
public final class GrammaticalInflectionManagerCompat {
    public static final int GRAMMATICAL_GENDER_FEMININE = 2;
    public static final int GRAMMATICAL_GENDER_MASCULINE = 3;
    public static final int GRAMMATICAL_GENDER_NEUTRAL = 1;
    public static final int GRAMMATICAL_GENDER_NOT_SPECIFIED = 0;

    public static class Api34Impl {
        private Api34Impl() {
        }

        public static int getApplicationGrammaticalGender(Context r100) {
            return getGrammaticalInflectionManager(r100).getApplicationGrammaticalGender();
        }

        private static GrammaticalInflectionManager getGrammaticalInflectionManager(Context r100) {
            return (GrammaticalInflectionManager) r100.getSystemService(GrammaticalInflectionManager.class);
        }

        public static void setRequestedApplicationGrammaticalGender(Context r100, int r101) {
            getGrammaticalInflectionManager(r100).setRequestedApplicationGrammaticalGender(r101);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface GrammaticalGender {
    }

    private GrammaticalInflectionManagerCompat() {
    }

    public static int getApplicationGrammaticalGender(Context r100) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return 0;
    L5:
        return Api34Impl.getApplicationGrammaticalGender(r100);
    }

    public static void setRequestedApplicationGrammaticalGender(Context r100, int r101) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34Impl.setRequestedApplicationGrammaticalGender(r100, r101);
        return;
    }
}
