package androidx.window.embedding;

import android.graphics.Rect;
import android.view.WindowMetrics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SplitRule.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B/\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/window/embedding/SplitRule;", "Landroidx/window/embedding/EmbeddingRule;", "minWidth", "", "minSmallestWidth", "splitRatio", "", "layoutDirection", "(IIFI)V", "getLayoutDirection", "()I", "getMinSmallestWidth", "getMinWidth", "getSplitRatio", "()F", "checkParentMetrics", "", "parentMetrics", "Landroid/view/WindowMetrics;", "equals", "other", "", "hashCode", "Api30Impl", "LayoutDir", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SplitRule extends EmbeddingRule {
    private final int layoutDirection;
    private final int minSmallestWidth;
    private final int minWidth;
    private final float splitRatio;

    /* JADX INFO: compiled from: SplitRule.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/SplitRule$Api30Impl;", "", "()V", "getBounds", "Landroid/graphics/Rect;", "windowMetrics", "Landroid/view/WindowMetrics;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = null;

        static {
            INSTANCE = new Api30Impl();
        }

        private Api30Impl() {
        }

        public final Rect getBounds(WindowMetrics r1) {
            Intrinsics.checkNotNullParameter(r1, "windowMetrics");
            Rect r0 = r1.getBounds();
            Intrinsics.checkNotNullExpressionValue(r0, "windowMetrics.bounds");
            return r0;
        }
    }

    /* JADX INFO: compiled from: SplitRule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/window/embedding/SplitRule$LayoutDir;", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutDir {
    }

    public SplitRule() {
        this(0, 0, 0.0f, 0, 15, null);
    }

    public /* synthetic */ SplitRule(int r2, int r3, float r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0.5f;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 3;
    L14:
        this(r2, r3, r4, r5);
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final int getMinSmallestWidth() {
        return this.minSmallestWidth;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public final int getLayoutDirection() {
        return this.layoutDirection;
    }

    public SplitRule(int r1, int r2, float r3, int r4) {
        this.minWidth = r1;
        this.minSmallestWidth = r2;
        this.splitRatio = r3;
        this.layoutDirection = r4;
    }

    public final boolean checkParentMetrics(WindowMetrics r5) {
        Intrinsics.checkNotNullParameter(r5, "parentMetrics");
        Rect r6 = Api30Impl.INSTANCE.getBounds(r5);
        if (this.minWidth != 0) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (this.minSmallestWidth != 0) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r0 == false) goto L20;
        if (r4 == true) goto L19;
        return false;
    L19:
        return true;
    L20:
        return false;
    L12:
        if (Math.min(r6.width(), r6.height()) >= this.minSmallestWidth) goto L15;
        r4 = false;
        goto L16
    L5:
        if (r6.width() >= this.minWidth) goto L8;
        r0 = false;
        goto L10
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SplitRule) == true) goto L8;
        return false;
    L8:
        SplitRule r6 = (SplitRule) r5;
        if (this.minWidth == r6.minWidth) goto L12;
        return false;
    L12:
        if (this.minSmallestWidth == r6.minSmallestWidth) goto L15;
        return false;
    L15:
        if (this.splitRatio != r6.splitRatio) goto L17;
        boolean r1 = true;
    L18:
        if (r1 == true) goto L21;
        return false;
    L21:
        if (this.layoutDirection == r6.layoutDirection) goto L23;
        return false;
    L23:
        return true;
    L17:
        r1 = false;
        goto L18
    }

    public int hashCode() {
        return (((((this.minWidth * 31) + this.minSmallestWidth) * 31) + Float.hashCode(this.splitRatio)) * 31) + this.layoutDirection;
    }
}
