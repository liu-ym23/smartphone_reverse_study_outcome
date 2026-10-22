package com.stepos.scene;

import android.content.ContextExt;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.collector.scene.StepOSPerfSceneData;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import com.stepos.scene.ISceneManager;
import com.stepos.scene.entity.SceneState;
import com.stepos.scene.entity.SceneStatus;

/* loaded from: classes.dex */
public class StepOSSceneDonateClient {
    private static final String TAG = "StepOSSceneDonateClient";
    private static volatile StepOSSceneDonateClient sInstance;
    private volatile ISceneManager mSceneManager;

    public static StepOSSceneDonateClient get() {
        if (sInstance == null) {
            synchronized (StepOSSceneDonateClient.class) {
                if (sInstance == null) {
                    sInstance = new StepOSSceneDonateClient();
                }
            }
        }
        return sInstance;
    }

    private ISceneManager getSceneManager() {
        IBinder b;
        ISceneManager sm = this.mSceneManager;
        if (sm == null && (b = ServiceManager.getService(ContextExt.STEP_SCENE)) != null) {
            ISceneManager sm2 = ISceneManager.Stub.asInterface(b);
            this.mSceneManager = sm2;
            return sm2;
        }
        return sm;
    }

    private void donateSync(int sceneId, SceneStatus status, StepOSPerfSceneData data) {
        int sceneId2;
        RemoteException e;
        Slog.i(TAG, "donateSync: sceneId = " + sceneId + ", status = " + status);
        try {
            ISceneManager sm = getSceneManager();
            if (sm == null) {
                return;
            }
            sceneId2 = sceneId;
            try {
                sm.registerSceneState(sceneId2, new SceneState(sceneId2, status, System.currentTimeMillis(), data));
            } catch (RemoteException e2) {
                e = e2;
                Slog.e(TAG, "donateSync error for sceneId=" + sceneId2, e);
            }
        } catch (RemoteException e3) {
            sceneId2 = sceneId;
            e = e3;
        }
    }

    private void donateAsync(final int sceneId, final SceneStatus status, final StepOSPerfSceneData data) {
        Slog.i(TAG, "donateAsync: sceneId = " + sceneId + ", status = " + status);
        BackgroundThread.getExecutor().execute(new Runnable() { // from class: com.stepos.scene.StepOSSceneDonateClient$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$donateAsync$0(sceneId, status, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$donateAsync$0(int sceneId, SceneStatus status, StepOSPerfSceneData data) {
        int sceneId2;
        RemoteException e;
        try {
            ISceneManager sm = getSceneManager();
            if (sm == null) {
                return;
            }
            sceneId2 = sceneId;
            try {
                sm.registerSceneState(sceneId2, new SceneState(sceneId2, status, System.currentTimeMillis(), data));
            } catch (RemoteException e2) {
                e = e2;
                Slog.e(TAG, "donateAsync error for sceneId=" + sceneId2, e);
            }
        } catch (RemoteException e3) {
            sceneId2 = sceneId;
            e = e3;
        }
    }

    public void donateCpuHighLoadState(boolean enterHighLoad) {
        SceneStatus status = enterHighLoad ? SceneStatus.TRIGGERED : SceneStatus.EXITED;
        StepOSPerfSceneData data = new StepOSPerfSceneData(50030);
        donateSync(50030, status, data);
    }
}
