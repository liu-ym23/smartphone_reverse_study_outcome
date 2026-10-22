package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.core.impl.Quirks;

/* JADX INFO: loaded from: classes2.dex */
public class SessionResetPolicy {
    private final boolean mNeedAbortCapture;

    public boolean needAbortCapture() {
        return this.mNeedAbortCapture;
    }

    public SessionResetPolicy(Quirks r100) {
        this.mNeedAbortCapture = r100.contains(Preview3AThreadCrashQuirk.class);
    }
}
