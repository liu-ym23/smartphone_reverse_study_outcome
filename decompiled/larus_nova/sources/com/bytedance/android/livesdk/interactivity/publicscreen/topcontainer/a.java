package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f139699a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f139700b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f139701c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f139702d = null;

    static {
        int[] r100 = new int[ConflictStrategy.values().length];
        f139699a = r100;
        ConflictStrategy r101 = ConflictStrategy.QUEUE;
        r100[r101.ordinal()] = 1;
        ConflictStrategy r102 = ConflictStrategy.INTERRUPT;
        r100[r102.ordinal()] = 2;
        ConflictStrategy r103 = ConflictStrategy.DISCARD;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[ConflictStrategy.values().length];
        f139700b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[ConflictStrategy.values().length];
        f139701c = r105;
        r105[r101.ordinal()] = 1;
        r105[r103.ordinal()] = 2;
        r105[r102.ordinal()] = 3;
        int[] r106 = new int[CleanStrategy.values().length];
        f139702d = r106;
        r106[CleanStrategy.NONE.ordinal()] = 1;
        r106[CleanStrategy.REMOVE_VIEWS.ordinal()] = 2;
        r106[CleanStrategy.REMOVE_WRAP_VIEW.ordinal()] = 3;
    }
}
