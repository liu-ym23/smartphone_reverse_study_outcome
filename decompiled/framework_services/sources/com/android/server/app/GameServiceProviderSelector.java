package com.android.server.app;

import com.android.server.SystemService;

/* JADX INFO: loaded from: classes.dex */
interface GameServiceProviderSelector {
    GameServiceConfiguration get(SystemService.TargetUser r1, String r2);
}
