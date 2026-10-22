package com.mdisdk.observer;

import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\n¨\u0006 "}, d2 = {"Lcom/mdisdk/observer/WindowBounds;", "", "left", "", "top", "right", "bottom", AppAgent.CONSTRUCT, "(IIII)V", "getLeft", "()I", "getTop", "getRight", "getBottom", "width", "getWidth", "height", "getHeight", "contains", "", "x", "y", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WindowBounds {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public WindowBounds(int i, int i6, int i10, int i11) {
        this.left = i;
        this.top = i6;
        this.right = i10;
        this.bottom = i11;
    }

    public static /* synthetic */ WindowBounds copy$default(WindowBounds windowBounds, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = windowBounds.left;
        }
        if ((i12 & 2) != 0) {
            i6 = windowBounds.top;
        }
        if ((i12 & 4) != 0) {
            i10 = windowBounds.right;
        }
        if ((i12 & 8) != 0) {
            i11 = windowBounds.bottom;
        }
        return windowBounds.copy(i, i6, i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLeft() {
        return this.left;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTop() {
        return this.top;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRight() {
        return this.right;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBottom() {
        return this.bottom;
    }

    public final boolean contains(int x10, int y) {
        int i = this.left;
        if (x10 > this.right || i > x10) {
            return false;
        }
        return y <= this.bottom && this.top <= y;
    }

    public final WindowBounds copy(int left, int top, int right, int bottom) {
        return new WindowBounds(left, top, right, bottom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WindowBounds)) {
            return false;
        }
        WindowBounds windowBounds = (WindowBounds) other;
        return this.left == windowBounds.left && this.top == windowBounds.top && this.right == windowBounds.right && this.bottom == windowBounds.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.bottom - this.top;
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

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return Integer.hashCode(this.bottom) + a.a(this.right, a.a(this.top, Integer.hashCode(this.left) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WindowBounds(left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", right=");
        sb.append(this.right);
        sb.append(", bottom=");
        return B7.a.o(sb, this.bottom, ')');
    }
}
