package com.bytedance.android.anniex.scene.next;

import com.bytedance.android.anniex.scene.next.base.PredictElementType;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PredictElementType f41287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<xa.b<?>> f41288b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f41287a == r101.f41287a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f41288b, r101.f41288b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f41287a.hashCode() * 31) + this.f41288b.hashCode();
    }

    public final String toString() {
        return "StrategyPredictionSet(elementType=" + this.f41287a + ", predictions=" + this.f41288b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(PredictElementType r100, List<? extends xa.b<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "elementType");
        Intrinsics.checkNotNullParameter(r101, "predictions");
        this.f41287a = r100;
        this.f41288b = r101;
    }
}
