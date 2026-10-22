package androidx.core.app;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class MultiWindowModeChangedInfo {
    private final boolean mIsInMultiWindowMode;
    private final Configuration mNewConfig;

    public MultiWindowModeChangedInfo(boolean r1) {
        this.mIsInMultiWindowMode = r1;
        this.mNewConfig = null;
    }

    public MultiWindowModeChangedInfo(boolean r1, Configuration r2) {
        this.mIsInMultiWindowMode = r1;
        this.mNewConfig = r2;
    }

    public boolean isInMultiWindowMode() {
        return this.mIsInMultiWindowMode;
    }

    public Configuration getNewConfig() {
        Configuration r1 = this.mNewConfig;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("MultiWindowModeChangedInfo must be constructed with the constructor that takes a Configuration to call getNewConfig(). Are you running on an API 26 or higher device that makes this information available?");
    }
}
