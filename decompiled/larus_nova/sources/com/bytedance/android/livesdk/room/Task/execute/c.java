package com.bytedance.android.livesdk.room.Task.execute;

import com.bytedance.android.livesdk.room.Task.api.LiveTaskType;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f157605a = null;

    static {
        int[] r100 = new int[LiveTaskType.values().length];
        f157605a = r100;
        r100[LiveTaskType.BOOT.ordinal()] = 1;
        r100[LiveTaskType.MAIN.ordinal()] = 2;
        r100[LiveTaskType.ASYNC.ordinal()] = 3;
        r100[LiveTaskType.POST.ordinal()] = 4;
    }
}
