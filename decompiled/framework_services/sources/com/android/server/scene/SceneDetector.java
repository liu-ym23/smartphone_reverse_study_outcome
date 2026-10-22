package com.android.server.scene;

import android.content.Context;
import android.os.Bundle;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SceneDetector {
    private static final String TAG = "Scene-Detector";
    protected Context mContext;
    protected final Object mLock;
    protected ArrayMap<Integer, ArrayList<SceneChangeListener>> mSceneChangeListenerMap;
    protected int mSceneType;

    protected abstract void reportData(Bundle r1);

    protected abstract void updateData(Bundle r1);

    SceneDetector(Context context, int type) {
        this.mLock = new Object();
        this.mSceneType = 0;
        this.mSceneChangeListenerMap = new ArrayMap();
        this.mContext = context;
        this.mSceneType = type;
    }

    public void registerSceneChangeListener(int registerSceneType, SceneChangeListener sceneListener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mSceneChangeListenerMap.get(Integer.valueOf(registerSceneType)) != null) goto L9;
        ArrayList<SceneChangeListener> listenerList = new ArrayList();     // Catch: Throwable -> L7
        this.mSceneChangeListenerMap.put(Integer.valueOf(registerSceneType), listenerList);     // Catch: Throwable -> L7
    L9:
        ArrayList<SceneChangeListener> listeners = this.mSceneChangeListenerMap.get(Integer.valueOf(registerSceneType));     // Catch: Throwable -> L7
        listeners.add(sceneListener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    protected ArrayList<SceneChangeListener> getSceneChangListener(int registerSceneType) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<SceneChangeListener> r1 = this.mSceneChangeListenerMap.get(Integer.valueOf(registerSceneType));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    protected void notifySceneChanged(int sceneType, Bundle data) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<SceneChangeListener> listeners = getSceneChangListener(sceneType);     // Catch: Throwable -> L12
        if (listeners != null) goto L7;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L7:
        if (listeners.isEmpty() == true) goto L14;
        Iterator<SceneChangeListener> r2 = listeners.iterator();     // Catch: Throwable -> L12
    L10:
        if (r2.hasNext() == false) goto L14;
        SceneChangeListener listener = r2.next();     // Catch: Throwable -> L12
        listener.notifySceneChanged(data);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
