package com.stepos.config.dag.cloud;

import android.util.Log;
import com.stepos.config.dag.cloud.CloudConfigSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class CloudConfigBridge {
    private static final Map<String, CloudConfigSource.Callback> PENDING = new ConcurrentHashMap();
    private static final String TAG = "CloudConfigBridge";
    private static volatile CloudConfigSource source;

    private CloudConfigBridge() {
        throw new AssertionError("no instances");
    }

    public static synchronized void setSource(CloudConfigSource s) {
        if (source != null && source != s) {
            Log.w(TAG, "CloudConfigSource replaced");
        }
        source = s;
        if (s != null && !PENDING.isEmpty()) {
            for (Map.Entry<String, CloudConfigSource.Callback> e : PENDING.entrySet()) {
                try {
                    s.subscribe(e.getKey(), e.getValue());
                } catch (Throwable t) {
                    Log.e(TAG, "flush pending subscribe failed, key=" + e.getKey(), t);
                }
            }
            PENDING.clear();
            Log.i(TAG, "CloudConfigSource bound, pending flushed");
        }
    }

    public static CloudConfigSource getSource() {
        return source;
    }

    public static boolean isBound() {
        return source != null;
    }

    public static void subscribe(String key, CloudConfigSource.Callback callback) {
        if (key == null || key.isEmpty() || callback == null) {
            Log.w(TAG, "subscribe: invalid args, key=" + key);
            return;
        }
        synchronized (CloudConfigBridge.class) {
            CloudConfigSource s = source;
            if (s == null) {
                PENDING.put(key, callback);
                Log.d(TAG, "subscribe: source not bound yet, buffered key=" + key);
            } else {
                s.subscribe(key, callback);
            }
        }
    }

    public static void unsubscribe(String key) {
        if (key == null || key.isEmpty()) {
            return;
        }
        PENDING.remove(key);
        CloudConfigSource s = source;
        if (s != null) {
            s.unsubscribe(key);
        }
    }
}
