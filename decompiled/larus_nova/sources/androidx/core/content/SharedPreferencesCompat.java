package androidx.core.content;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes17.dex */
public final class SharedPreferencesCompat {

    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper;

        public static class Helper {
            public Helper() {
            }

            public void apply(SharedPreferences.Editor r100) {
                r100.apply();     // Catch: AbstractMethodError -> L4
                return;
            L4:
                r100.commit();
            }
        }

        public static EditorCompat getInstance() {
            if (sInstance != null) goto L6;
            sInstance = new EditorCompat();
        L6:
            return sInstance;
        }

        private EditorCompat() {
            this.mHelper = new Helper();
        }

        public void apply(SharedPreferences.Editor r100) {
            this.mHelper.apply(r100);
        }
    }

    private SharedPreferencesCompat() {
    }
}
