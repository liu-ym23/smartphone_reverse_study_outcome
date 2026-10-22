package com.android.server.biometrics.sensors;

/* JADX INFO: loaded from: classes.dex */
public interface UserSwitchProvider<T, U> {
    StartUserClient<T, U> getStartUserClient(int r1);

    StopUserClient<U> getStopUserClient(int r1);
}
