package com.obric.livecard.api.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Arrays;

/* JADX INFO: compiled from: IslandImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IslandTask {
    private final b<d<? super x>, Object> block;
    private final StackTraceElement[] creationStack;

    public static /* synthetic */ IslandTask copy$default(IslandTask r1, StackTraceElement[] r2, b r3, int r4, Object r5) {
        b<d<? super x>, Object> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = r1.creationStack;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r6 = r1.block;
    L9:
        return r1.copy(r2, r6);
    }

    public final StackTraceElement[] component1() {
        return this.creationStack;
    }

    public final b<d<? super x>, Object> component2() {
        return this.block;
    }

    public final IslandTask copy(StackTraceElement[] r2, b<? super d<? super x>, ? extends Object> r3) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        o.e(r1, "block");
        return new IslandTask(r2, r1);
    }

    public String toString() {
        return "IslandTask(creationStack=" + Arrays.toString(this.creationStack) + ", block=" + this.block + ')';
    }

    public IslandTask(StackTraceElement[] r3, b<? super d<? super x>, ? extends Object> r4) {
        b<d<? super x>, Object> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        o.e(r5, "block");
        this.creationStack = r3;
        this.block = r5;
    }

    public /* synthetic */ IslandTask(StackTraceElement[] r2, b r3, int r4, h r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = Thread.currentThread().getStackTrace();
    L5:
        this(r2, r6);
    }

    public final StackTraceElement[] getCreationStack() {
        return this.creationStack;
    }

    public final b<d<? super x>, Object> getBlock() {
        return this.block;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        Class<?> r1 = getClass();
        if (r4 == null) goto L9;
        Class<?> r2 = r4.getClass();
    L11:
        if (o.a(r1, r2) == true) goto L14;
        return false;
    L14:
        o.a(r4, "null cannot be cast to non-null type com.obric.livecard.api.impl.IslandTask");
        IslandTask r3 = (IslandTask) ZeusTransformUtils.preCheckCast(r4, IslandTask.class, "com.obric.aiagent.plugin");
        return o.a(this.block, ((IslandTask) ZeusTransformUtils.preCheckCast(r4, IslandTask.class, "com.obric.aiagent.plugin")).block);
    L9:
        r2 = null;
        goto L11
    }

    public int hashCode() {
        return this.block.hashCode();
    }
}
