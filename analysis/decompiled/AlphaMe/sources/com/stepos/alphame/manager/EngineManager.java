package com.stepos.alphame.manager;

import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.engine.EngineBase;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EngineManager {
    private static final String TAG = "EngineManager";
    private final HashMap<String, EngineBase> mEngines;

    public static class Instance {
        private static EngineManager INSTANCE = new EngineManager(0);

        private Instance() {
        }
    }

    public /* synthetic */ EngineManager(int i4) {
        this();
    }

    public static EngineManager getInstance() {
        return Instance.INSTANCE;
    }

    public EngineBase getEngine(String str) {
        EngineBase engineBase;
        synchronized (this) {
            engineBase = this.mEngines.get(str);
        }
        return engineBase;
    }

    public boolean register(EngineBase engineBase) {
        synchronized (this) {
            if (engineBase != null) {
                try {
                    if (!TextUtils.isEmpty(engineBase.getName())) {
                        if (getEngine(engineBase.getName()) == null) {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            engineBase.start();
                            Log.i(TAG, String.format("Start engine %s cost %d ms", engineBase.getName(), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                            this.mEngines.put(engineBase.getName(), engineBase);
                            return true;
                        }
                        Log.e(TAG, "Engine " + engineBase.getName() + " is already registered ");
                        return false;
                    }
                } finally {
                }
            }
            return false;
        }
    }

    public void trimMemory() {
        synchronized (this) {
            try {
                Iterator<EngineBase> it = this.mEngines.values().iterator();
                while (it.hasNext()) {
                    it.next().trimMemory();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean unregister(String str) {
        synchronized (this) {
            try {
                EngineBase engineBase = this.mEngines.get(str);
                if (engineBase == null) {
                    return false;
                }
                engineBase.stop();
                this.mEngines.remove(str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private EngineManager() {
        this.mEngines = new HashMap<>();
    }

    public boolean unregister(EngineBase engineBase) {
        return unregister(engineBase.getName());
    }
}
