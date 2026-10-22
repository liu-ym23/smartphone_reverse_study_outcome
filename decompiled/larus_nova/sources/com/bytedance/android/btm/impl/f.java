package com.bytedance.android.btm.impl;

import com.bytedance.android.btm.impl.page.lifecycle.ResumeFilterReason;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f42156a = null;

    static {
        int[] r100 = new int[ResumeFilterReason.values().length];
        int[] r101 = new int[ResumeFilterReason.values().length];
        int[] r102 = new int[ResumeFilterReason.values().length];
        int[] r103 = new int[ResumeFilterReason.values().length];
        int[] r104 = new int[ResumeFilterReason.values().length];
        f42156a = r104;
        r104[ResumeFilterReason.AppBackground.ordinal()] = 1;
        r104[ResumeFilterReason.NotTopActivity.ordinal()] = 2;
        r104[ResumeFilterReason.FragmentNotAttach.ordinal()] = 3;
        r104[ResumeFilterReason.Invisible.ordinal()] = 4;
        r104[ResumeFilterReason.NativeStateError.ordinal()] = 5;
    }
}
