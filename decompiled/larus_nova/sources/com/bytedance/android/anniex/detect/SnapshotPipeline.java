package com.bytedance.android.anniex.detect;

import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SnapshotPipeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<m> f40644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<k, Boolean> f40645b;

    public SnapshotPipeline() {
        throw null;
    }

    public SnapshotPipeline(List r100) {
        AnonymousClass1 r101 = AnonymousClass1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "steps");
        Intrinsics.checkNotNullParameter(r101, "shouldInterrupt");
        this.f40644a = r100;
        this.f40645b = r101;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:21:0x0068). Please report as a decompilation issue!!! */
    public final Object a(j r100, Continuation<? super k> r101) {
        if ((r101 instanceof SnapshotPipeline$run$1) == false) goto L7;
        SnapshotPipeline$run$1 r102 = (SnapshotPipeline$run$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        Iterator<m> r107 = (Iterator) r102.L$2;
        j r108 = (j) r102.L$1;
        SnapshotPipeline r109 = (SnapshotPipeline) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        k r110 = (k) r104;
        if (r109.f40645b.invoke(r110).booleanValue() == false) goto L24;
        return r110;
    L24:
        j r111 = r108;
    L16:
        if (r107.hasNext() == false) goto L26;
        m r112 = r107.next();
        r102.L$0 = r109;
        r102.L$1 = r111;
        r102.L$2 = r107;
        r102.label = 1;
        Object r113 = r112.a(r111, r102);
        if (r113 != r105) goto L20;
        return r105;
    L20:
        r108 = r111;
        r104 = r113;
        goto L21
    L26:
        return new k(true, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        Iterator<m> r114 = this.f40644a.iterator();
        r109 = this;
        r111 = r100;
        r107 = r114;
    L7:
        r102 = new SnapshotPipeline$run$1(this, r101);
        goto L8
    }
}
