package com.autonavi.base.ae.gmap;

/* JADX INFO: loaded from: classes39.dex */
public class GLEngineIDController {
    private static final String TAG = "GLEngineIDController";
    private static GLEngineIDController sController;
    private int engineIDIndex;

    public synchronized int generate() {
        monitor-enter(this);
        int r100 = this.engineIDIndex + 1;     // Catch: Throwable -> L6
        this.engineIDIndex = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        sController = new GLEngineIDController();
    }

    private GLEngineIDController() {
        this.engineIDIndex = 10000;
    }

    public static GLEngineIDController getController() {
        return sController;
    }
}
