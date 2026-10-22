package androidx.window.embedding;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplitInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u0013\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Landroidx/window/embedding/SplitInfo;", "", "primaryActivityStack", "Landroidx/window/embedding/ActivityStack;", "secondaryActivityStack", "splitRatio", "", "(Landroidx/window/embedding/ActivityStack;Landroidx/window/embedding/ActivityStack;F)V", "getPrimaryActivityStack", "()Landroidx/window/embedding/ActivityStack;", "getSecondaryActivityStack", "getSplitRatio", "()F", "contains", "", "activity", "Landroid/app/Activity;", "equals", "other", "hashCode", "", "toString", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitInfo {
    private final ActivityStack primaryActivityStack;
    private final ActivityStack secondaryActivityStack;
    private final float splitRatio;

    public SplitInfo(ActivityStack r2, ActivityStack r3, float r4) {
        Intrinsics.checkNotNullParameter(r2, "primaryActivityStack");
        Intrinsics.checkNotNullParameter(r3, "secondaryActivityStack");
        this.primaryActivityStack = r2;
        this.secondaryActivityStack = r3;
        this.splitRatio = r4;
    }

    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public final boolean contains(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (this.primaryActivityStack.contains(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.secondaryActivityStack.contains(r2) == true) goto L8;
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SplitInfo) == true) goto L8;
        return false;
    L8:
        SplitInfo r6 = (SplitInfo) r5;
        if (Intrinsics.areEqual(this.primaryActivityStack, r6.primaryActivityStack) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secondaryActivityStack, r6.secondaryActivityStack) == true) goto L15;
        return false;
    L15:
        if (this.splitRatio != r6.splitRatio) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == true) goto L20;
        return false;
    L20:
        return true;
    L17:
        r4 = false;
        goto L18
    }

    public int hashCode() {
        return (((this.primaryActivityStack.hashCode() * 31) + this.secondaryActivityStack.hashCode()) * 31) + Float.hashCode(this.splitRatio);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("SplitInfo:{");
        r0.append("primaryActivityStack=" + getPrimaryActivityStack() + ',');
        r0.append("secondaryActivityStack=" + getSecondaryActivityStack() + ',');
        r0.append("splitRatio=" + getSplitRatio() + '}');
        String r4 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    }
}
