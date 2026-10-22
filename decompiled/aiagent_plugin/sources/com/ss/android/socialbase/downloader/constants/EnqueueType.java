package com.ss.android.socialbase.downloader.constants;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final enum EnqueueType extends Enum<EnqueueType> {
    private static final /* synthetic */ EnqueueType[] $VALUES = null;
    public static final EnqueueType ENQUEUE_HEAD = null;
    public static final EnqueueType ENQUEUE_NONE = null;
    public static final EnqueueType ENQUEUE_TAIL = null;
    public static final EnqueueType NEW_ENQUEUE_IMMEDIATE = null;
    public static final EnqueueType NEW_ENQUEUE_NORMAL = null;

    private EnqueueType(String r1, int r2) {
        super(r1, r2);
    }

    public static EnqueueType valueOf(String r2) {
        return (EnqueueType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnqueueType.class, r2), EnqueueType.class, "com.obric.aiagent.plugin");
    }

    public static EnqueueType[] values() {
        return (EnqueueType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EnqueueType[].class, "com.obric.aiagent.plugin");
    }

    static {
        EnqueueType r0 = new EnqueueType("ENQUEUE_NONE", 0);
        ENQUEUE_NONE = r0;
        EnqueueType r1 = new EnqueueType("ENQUEUE_HEAD", 1);
        ENQUEUE_HEAD = r1;
        EnqueueType r3 = new EnqueueType("ENQUEUE_TAIL", 2);
        ENQUEUE_TAIL = r3;
        EnqueueType r5 = new EnqueueType("NEW_ENQUEUE_NORMAL", 3);
        NEW_ENQUEUE_NORMAL = r5;
        EnqueueType r7 = new EnqueueType("NEW_ENQUEUE_IMMEDIATE", 4);
        NEW_ENQUEUE_IMMEDIATE = r7;
        $VALUES = new EnqueueType[]{r0, r1, r3, r5, r7};
    }
}
