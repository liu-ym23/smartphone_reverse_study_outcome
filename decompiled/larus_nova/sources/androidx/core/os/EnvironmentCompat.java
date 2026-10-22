package androidx.core.os;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes17.dex */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static String getExternalStorageState(File r100) {
            return Environment.getExternalStorageState(r100);
        }
    }

    private EnvironmentCompat() {
    }

    public static String getStorageState(File r100) {
        return Api21Impl.getExternalStorageState(r100);
    }
}
