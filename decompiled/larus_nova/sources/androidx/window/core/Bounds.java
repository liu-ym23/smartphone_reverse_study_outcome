package androidx.window.core;

import android.graphics.Rect;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0006\u0010\u001b\u001a\u00020\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\fR\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\f¨\u0006\u001e"}, d2 = {"Landroidx/window/core/Bounds;", "", SVGRenderEngine.RECT, "Landroid/graphics/Rect;", "(Landroid/graphics/Rect;)V", "left", "", "top", "right", "bottom", "(IIII)V", "getBottom", "()I", "height", "getHeight", "isEmpty", "", "()Z", "isZero", "getLeft", "getRight", "getTop", "width", "getWidth", "equals", "other", "hashCode", "toRect", "toString", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Bounds {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final Rect toRect() {
        return new Rect(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        return "Bounds { [" + this.left + ',' + this.top + ',' + this.right + ',' + this.bottom + "] }";
    }

    public final boolean isEmpty() {
        if (getHeight() != 0) goto L5;
    L8:
        return true;
    L5:
        if (getWidth() == 0) goto L8;
        return false;
    }

    public final boolean isZero() {
        if (getHeight() == 0) goto L5;
    L7:
        return false;
    L5:
        if (getWidth() != 0) goto L7;
        return true;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public Bounds(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        this(r100.left, r100.top, r100.right, r100.bottom);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(Bounds.class, r101) == true) goto L12;
        return false;
    L12:
        if (r100 == null) goto L27;
        Bounds r102 = (Bounds) r100;
        if (this.left == r102.left) goto L17;
        return false;
    L17:
        if (this.top == r102.top) goto L20;
        return false;
    L20:
        if (this.right == r102.right) goto L23;
        return false;
    L23:
        if (this.bottom == r102.bottom) goto L25;
        return false;
    L25:
        return true;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
    L8:
        r101 = null;
        goto L10
    }

    public Bounds(int r100, int r101, int r102, int r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }
}
