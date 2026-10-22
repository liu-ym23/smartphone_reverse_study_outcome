package com.android.server.am;

import android.content.ComponentName;
import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes.dex */
public interface IZswBroadcastSkipPolicy {
    String shouldSkipMessage(BroadcastRecord r1, ResolveInfo r2, boolean r3, ComponentName r4);

    String shouldSkipMessage(BroadcastRecord r1, BroadcastFilter r2);
}
