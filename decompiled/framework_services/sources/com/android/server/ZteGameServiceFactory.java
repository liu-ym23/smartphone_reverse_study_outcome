package com.android.server;

import android.content.Context;
import android.util.Slog;
import com.android.server.common.IGameAssistSerivce;
import com.android.server.common.IGameScreenSaver;
import com.android.server.display.DisplayMirrorStub;
import com.android.server.game.KeyMouseStub;
import com.android.server.wm.IGameRatioStub;
import com.zte.game.Feature;
import dalvik.system.PathClassLoader;

/* JADX INFO: loaded from: classes.dex */
public class ZteGameServiceFactory {
    private static final String TAG = "ZteGameServiceFactory";
    private static PathClassLoader sClassLoader;
    private static ZteGameServiceFactory sInstance;
    private IGameRatioStub mIGameRatioStub;
    private KeyMouseStub mKeyMouseStub;

    public ZteGameServiceFactory() {
    }

    public static ZteGameServiceFactory getInstance() {
        monitor-enter(ZteGameServiceFactory.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L17;
        String classPackage = "/system_ext/framework/zte-game-services.jar";
        if (Feature.ZTE_GAME_BYTE_DANCE == false) goto L24;
        classPackage = "/system/framework/zte-game-services.jar";
    L24:
        sClassLoader = new PathClassLoader(classPackage, ZteGameServiceFactory.class.getClassLoader());     // Catch: Throwable -> L10 Exception -> L15
        Class<?> clazz = Class.forName("com.android.server.ZteGameServiceFactoryImpl", false, sClassLoader);     // Catch: Throwable -> L10 Exception -> L15
        sInstance = (ZteGameServiceFactory) clazz.getConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Throwable -> L10 Exception -> L15
        Slog.d(TAG, "getInstance: " + sInstance);     // Catch: Throwable -> L10 Exception -> L15
    L15:
        e = move-exception;
        Slog.e(TAG, "getInstance: " + e.toString());     // Catch: Throwable -> L10
        sInstance = new ZteGameServiceFactory();     // Catch: Throwable -> L10
    L17:
        ZteGameServiceFactory r1 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(ZteGameServiceFactory.class);     // Catch: Throwable -> L10
        return r1;
    }

    public DisplayMirrorStub makeDisplayMirrorStub() {
        return new DisplayMirrorStub();
    }

    public void startGameAssistService(Context context) {
        LocalServices.addService(IGameAssistSerivce.class, new AnonymousClass1(this));
        LocalServices.addService(IGameScreenSaver.class, new AnonymousClass2(this));
    }

    public KeyMouseStub makeKeyMouseStub(Context context) {
        if (this.mKeyMouseStub != null) goto L6;
        this.mKeyMouseStub = new KeyMouseStub();
    L6:
        return this.mKeyMouseStub;
    }

    public IGameRatioStub makeIGameRatioStub(Context context) {
        if (this.mIGameRatioStub != null) goto L6;
        this.mIGameRatioStub = new IGameRatioStub();
    L6:
        return this.mIGameRatioStub;
    }
}
