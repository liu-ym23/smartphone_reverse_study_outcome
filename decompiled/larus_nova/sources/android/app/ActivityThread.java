package android.app;

import android.content.pm.ProviderInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityThread {
    AppBindData mBoundApplication;

    public static final class AppBindData {
        List<ProviderInfo> providers;

        public AppBindData() {
        }
    }

    public ActivityThread() {
    }

    public static ActivityThread currentActivityThread() {
        throw new UnsupportedOperationException();
    }

    public final void installSystemProviders(List<ProviderInfo> r100) {
        throw new UnsupportedOperationException();
    }
}
