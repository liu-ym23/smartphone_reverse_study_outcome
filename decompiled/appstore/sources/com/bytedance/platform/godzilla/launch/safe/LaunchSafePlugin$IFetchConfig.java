package com.bytedance.platform.godzilla.launch.safe;

import b6.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LaunchSafePlugin$IFetchConfig {
    void fixSuccessful(a r10, String r11, int r12);

    int getCrashLimit();

    List<a> getStrategy();

    long getWatchDogTime();

    void occurSerialCrash(String r10, int r11);
}
