package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
interface Filter {
    boolean matches(IntentFirewall r1, ComponentName r2, Intent r3, int r4, int r5, String r6, int r7);
}
