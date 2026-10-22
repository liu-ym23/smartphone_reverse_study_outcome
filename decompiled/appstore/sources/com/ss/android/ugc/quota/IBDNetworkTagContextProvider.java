package com.ss.android.ugc.quota;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface IBDNetworkTagContextProvider {
    Map<String, Object> extra();

    int launchType();

    boolean markAsNewUser();

    int triggerType();
}
