package com.stepos.scene;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.stepos.scene.ISceneCallback;
import com.stepos.scene.entity.SceneState;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class SceneManager {
    private final Context mContext;
    private final ISceneManager mService;
    private final Map<SceneCallback, SceneCallbackWrapper> mSubscriptionCallbacks = new HashMap();

    public interface SceneCallback {
        void onSceneStateUpdate(SceneState sceneState);
    }

    public SceneManager(Context context, ISceneManager service) {
        this.mContext = context;
        this.mService = service;
    }

    public boolean registerSceneListener(int sceneId, SceneCallback callback) {
        if (this.mService == null) {
            return false;
        }
        try {
            SceneCallbackWrapper wrapper = new SceneCallbackWrapper(callback);
            this.mSubscriptionCallbacks.put(callback, wrapper);
            return this.mService.registerSceneListener(sceneId, wrapper);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean unregisterSceneListener(int sceneId, SceneCallback callback) {
        if (this.mService == null) {
            return false;
        }
        try {
            SceneCallbackWrapper wrapper = new SceneCallbackWrapper(callback);
            this.mSubscriptionCallbacks.remove(callback, wrapper);
            return this.mService.unregisterSceneListener(sceneId, wrapper);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public int removeSceneListeners(int sceneId) {
        if (this.mService == null) {
            return -1;
        }
        try {
            return this.mService.removeSceneListeners(sceneId);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public SceneState getSceneState(int sceneId) {
        if (this.mService == null) {
            return null;
        }
        try {
            return this.mService.getSceneState(sceneId);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean registerSceneState(int sceneId, SceneState state) {
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.registerSceneState(sceneId, state);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void donateTimedScene(int sceneId, SceneState state, long timeoutMs) {
        Objects.requireNonNull(state, "state must not be null");
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.donateTimedScene(sceneId, state, timeoutMs);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean openSceneDonor(IBinder clientToken) {
        Objects.requireNonNull(clientToken, "clientToken must not be null");
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.openSceneDonor(clientToken);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public boolean donateScene(IBinder clientToken, int sceneId, SceneState state) {
        Objects.requireNonNull(clientToken, "clientToken must not be null");
        Objects.requireNonNull(state, "state must not be null");
        if (this.mService == null) {
            return false;
        }
        try {
            return this.mService.donateScene(clientToken, sceneId, state);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public void closeSceneDonor(IBinder clientToken) {
        Objects.requireNonNull(clientToken, "clientToken must not be null");
        if (this.mService == null) {
            return;
        }
        try {
            this.mService.closeSceneDonor(clientToken);
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    private static class SceneCallbackWrapper extends ISceneCallback.Stub {
        private final SceneCallback mCallback;

        SceneCallbackWrapper(SceneCallback callback) {
            this.mCallback = callback;
        }

        @Override // com.stepos.scene.ISceneCallback
        public void onSceneStateUpdate(SceneState state) throws RemoteException {
            this.mCallback.onSceneStateUpdate(state);
        }
    }
}
