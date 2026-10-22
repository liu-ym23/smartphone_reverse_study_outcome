package androidx.window.embedding;

import android.graphics.Rect;
import android.os.Build;
import android.view.WindowMetrics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00182\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB/\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Landroidx/window/embedding/SplitRule;", "Landroidx/window/embedding/EmbeddingRule;", "minWidth", "", "minSmallestWidth", "splitRatio", "", "layoutDirection", "(IIFI)V", "getLayoutDirection", "()I", "getMinSmallestWidth", "getMinWidth", "getSplitRatio", "()F", "checkParentMetrics", "", "parentMetrics", "Landroid/view/WindowMetrics;", "equals", "other", "", "hashCode", "Api30Impl", "Companion", "LayoutDir", "SplitFinishBehavior", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SplitRule extends EmbeddingRule {
    public static final Companion Companion = null;
    public static final int FINISH_ADJACENT = 2;
    public static final int FINISH_ALWAYS = 1;
    public static final int FINISH_NEVER = 0;
    private final int layoutDirection;
    private final int minSmallestWidth;
    private final int minWidth;
    private final float splitRatio;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/SplitRule$Api30Impl;", "", "()V", "getBounds", "Landroid/graphics/Rect;", "windowMetrics", "Landroid/view/WindowMetrics;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = null;

        static {
            INSTANCE = new Api30Impl();
        }

        private Api30Impl() {
        }

        public final Rect getBounds(WindowMetrics r100) {
            Intrinsics.checkNotNullParameter(r100, "windowMetrics");
            return r100.getBounds();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/window/embedding/SplitRule$Companion;", "", "()V", "FINISH_ADJACENT", "", "FINISH_ALWAYS", "FINISH_NEVER", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/window/embedding/SplitRule$LayoutDir;", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface LayoutDir {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/window/embedding/SplitRule$SplitFinishBehavior;", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SplitFinishBehavior {
    }

    static {
        Companion = new Companion(null);
    }

    public SplitRule() {
        this(0, 0, 0.0f, 0, 15, null);
    }

    public int hashCode() {
        return (((((this.minWidth * 31) + this.minSmallestWidth) * 31) + Float.floatToIntBits(this.splitRatio)) * 31) + this.layoutDirection;
    }

    public final int getLayoutDirection() {
        return this.layoutDirection;
    }

    public final int getMinSmallestWidth() {
        return this.minSmallestWidth;
    }

    public final int getMinWidth() {
        return this.minWidth;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public final boolean checkParentMetrics(WindowMetrics r100) {
        Intrinsics.checkNotNullParameter(r100, "parentMetrics");
        if (Build.VERSION.SDK_INT > 30) goto L5;
        return false;
    L5:
        Rect r101 = Api30Impl.INSTANCE.getBounds(r100);
        if (this.minWidth != 0) goto L8;
    L11:
        boolean r102 = true;
    L13:
        if (this.minSmallestWidth != 0) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r102 == false) goto L23;
        if (r103 == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L15:
        if (Math.min(r101.width(), r101.height()) >= this.minSmallestWidth) goto L18;
        r103 = false;
        goto L19
    L8:
        if (r101.width() >= this.minWidth) goto L11;
        r102 = false;
        goto L13
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SplitRule) == true) goto L8;
        return false;
    L8:
        SplitRule r101 = (SplitRule) r100;
        if (this.minWidth == r101.minWidth) goto L12;
        return false;
    L12:
        if (this.minSmallestWidth == r101.minSmallestWidth) goto L15;
        return false;
    L15:
        if (this.splitRatio != r101.splitRatio) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == true) goto L21;
        return false;
    L21:
        if (this.layoutDirection == r101.layoutDirection) goto L23;
        return false;
    L23:
        return true;
    L17:
        r102 = false;
        goto L18
    }

    public SplitRule(int r100, int r101, float r102, int r103) {
        this.minWidth = r100;
        this.minSmallestWidth = r101;
        this.splitRatio = r102;
        this.layoutDirection = r103;
    }

    public /* synthetic */ SplitRule(int r100, int r101, float r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0.5f;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 3;
    L14:
        this(r100, r101, r102, r103);
    }
}
