package com.stepos.alphame.data;

import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class DataSourceManager {
    private static final String TAG = "AlphaMe";
    private final HashMap<String, DataSource> mSources;

    public static class Instance {
        private static DataSourceManager INSTANCE = new DataSourceManager(0);

        private Instance() {
        }
    }

    public /* synthetic */ DataSourceManager(int i4) {
        this();
    }

    public static DataSourceManager getInstance() {
        return Instance.INSTANCE;
    }

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (this) {
            try {
                Iterator<DataSource> it = this.mSources.values().iterator();
                while (it.hasNext()) {
                    it.next().dump(fileDescriptor, printWriter, strArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public DataSource getDataSource(String str) {
        DataSource dataSource;
        synchronized (this) {
            dataSource = this.mSources.get(str);
        }
        return dataSource;
    }

    public boolean register(DataSource dataSource) {
        synchronized (this) {
            if (dataSource != null) {
                try {
                    if (!TextUtils.isEmpty(dataSource.getTag())) {
                        String tag = dataSource.getTag();
                        if (this.mSources.get(tag) == null) {
                            dataSource.onStart();
                            this.mSources.put(tag, dataSource);
                            return true;
                        }
                        Log.e(TAG, tag + " is registered");
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
                Iterator<DataSource> it = this.mSources.values().iterator();
                while (it.hasNext()) {
                    it.next().trimMemory();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean unregister(DataSource dataSource) {
        String tag = dataSource.getTag();
        synchronized (this) {
            try {
                if (this.mSources.get(tag) != dataSource) {
                    return false;
                }
                this.mSources.remove(tag);
                dataSource.onStop();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private DataSourceManager() {
        this.mSources = new HashMap<>();
    }
}
