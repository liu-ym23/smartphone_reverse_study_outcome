package com.bytedance.android.livesdk.arch.task;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f103896a = null;

    static {
        int[] r100 = new int[RecordTask.Type.values().length];
        f103896a = r100;
        r100[RecordTask.Type.Pending.ordinal()] = 1;
        r100[RecordTask.Type.Show.ordinal()] = 2;
        r100[RecordTask.Type.Dismiss.ordinal()] = 3;
        r100[RecordTask.Type.Wait.ordinal()] = 4;
    }
}
