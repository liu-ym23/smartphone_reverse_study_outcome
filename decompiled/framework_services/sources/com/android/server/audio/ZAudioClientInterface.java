package com.android.server.audio;

/* JADX INFO: loaded from: classes.dex */
public interface ZAudioClientInterface {
    int getFlags();

    String getPackageName();

    int getPid();

    int getPortId();

    int getSessionId();

    int getUid();

    boolean isActive();

    String toString();
}
