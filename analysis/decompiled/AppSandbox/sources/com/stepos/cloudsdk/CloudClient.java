package com.stepos.cloudsdk;

/* loaded from: classes.dex */
public interface CloudClient {
    void addListener(ICloudListener iCloudListener);

    void addListener(String str, ICloudListener iCloudListener);

    void registerForUpdates();

    void removeAllListeners();

    void removeListener(ICloudListener iCloudListener);

    void removeListener(String str);

    void unregisterForUpdates();
}
