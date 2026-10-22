package com.android.server.wm;

/* JADX INFO: loaded from: classes3.dex */
public interface IZteWindowManagerInternal {

    public interface IZteWindowManagerInternalExport {
        IZteWindowManagerInternal getZteInjectInstance();

        default boolean isFingerprintSensorIconShowing() {
            if (getZteInjectInstance() != null) goto L5;
            return false;
        L5:
            return getZteInjectInstance().isFingerprintSensorIconShowing();
        }
    }

    boolean isFingerprintSensorIconShowing();
}
