package com.android.server.broadcastradio;

/* JADX INFO: loaded from: classes.dex */
public interface RadioServiceUserController {
    int getCallingUserId();

    int getCurrentUser();

    boolean isCurrentOrSystemUser();
}
