package com.bytedance.location.protobuf;

/* JADX INFO: loaded from: classes3.dex */
@CheckReturnValue
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = null;

    public abstract AllocatedBuffer allocateDirectBuffer(int r1);

    public abstract AllocatedBuffer allocateHeapBuffer(int r1);

    BufferAllocator() {
    }

    static {
        UNPOOLED = new AnonymousClass1();
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
