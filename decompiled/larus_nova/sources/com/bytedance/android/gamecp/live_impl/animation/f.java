package com.bytedance.android.gamecp.live_impl.animation;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f57805a = null;

    static {
        int[] r100 = new int[CardAnimationEvent.State.values().length];
        f57805a = r100;
        r100[CardAnimationEvent.State.EVENT_START.ordinal()] = 1;
        r100[CardAnimationEvent.State.ENQUEUE.ordinal()] = 2;
        r100[CardAnimationEvent.State.DEQUEUE.ordinal()] = 3;
        r100[CardAnimationEvent.State.ANIMATION_TASK_START.ordinal()] = 4;
        r100[CardAnimationEvent.State.ANIMATION_TASK_END.ordinal()] = 5;
        r100[CardAnimationEvent.State.EVENT_END.ordinal()] = 6;
    }
}
