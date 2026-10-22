package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J8\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "", "handle", "Landroidx/compose/foundation/text/Handle;", "position", "Landroidx/compose/ui/geometry/Offset;", "anchor", "Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "visible", "", "<init>", "(Landroidx/compose/foundation/text/Handle;JLandroidx/compose/foundation/text/selection/SelectionHandleAnchor;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHandle", "()Landroidx/compose/foundation/text/Handle;", "getPosition-F1C5BW0", "()J", "J", "getAnchor", "()Landroidx/compose/foundation/text/selection/SelectionHandleAnchor;", "getVisible", "()Z", "component1", "component2", "component2-F1C5BW0", "component3", "component4", "copy", "copy-ubNVwUQ", "(Landroidx/compose/foundation/text/Handle;JLandroidx/compose/foundation/text/selection/SelectionHandleAnchor;Z)Landroidx/compose/foundation/text/selection/SelectionHandleInfo;", "equals", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionHandleInfo {
    public static final int $stable = 0;
    private final SelectionHandleAnchor anchor;
    private final Handle handle;
    private final long position;
    private final boolean visible;

    public /* synthetic */ SelectionHandleInfo(Handle r100, long r101, SelectionHandleAnchor r102, boolean r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: copy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ SelectionHandleInfo m1456copyubNVwUQ$default(SelectionHandleInfo r100, Handle r101, long r102, SelectionHandleAnchor r103, boolean r104, int r105, Object r110) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.handle;
    L6:
        if ((r105 & 2) == 0) goto L8;
        r102 = r100.position;
    L8:
        long r106 = r102;
        if ((r105 & 4) == 0) goto L11;
        r103 = r100.anchor;
    L11:
        SelectionHandleAnchor r111 = r103;
        if ((r105 & 8) == 0) goto L14;
        r104 = r100.visible;
    L14:
        Handle r107 = r101;
        return r100.m1458copyubNVwUQ(r107, r106, r111, r104);
    }

    public final Handle component1() {
        return this.handle;
    }

    /* JADX INFO: renamed from: component2-F1C5BW0, reason: not valid java name */
    public final long m1457component2F1C5BW0() {
        return this.position;
    }

    public final SelectionHandleAnchor component3() {
        return this.anchor;
    }

    public final boolean component4() {
        return this.visible;
    }

    /* JADX INFO: renamed from: copy-ubNVwUQ, reason: not valid java name */
    public final SelectionHandleInfo m1458copyubNVwUQ(Handle r100, long r110, SelectionHandleAnchor r111, boolean r112) {
        return new SelectionHandleInfo(r100, r110, r111, r112, null);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SelectionHandleInfo) == true) goto L8;
        return false;
    L8:
        SelectionHandleInfo r101 = (SelectionHandleInfo) r100;
        if (this.handle == r101.handle) goto L12;
        return false;
    L12:
        if (Offset.m4579equalsimpl0(this.position, r101.position) == true) goto L15;
        return false;
    L15:
        if (this.anchor == r101.anchor) goto L18;
        return false;
    L18:
        if (this.visible == r101.visible) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.handle.hashCode() * 31) + Offset.m4584hashCodeimpl(this.position)) * 31) + this.anchor.hashCode()) * 31;
        if (this.visible == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "SelectionHandleInfo(handle=" + this.handle + ", position=" + Offset.m4590toStringimpl(this.position) + ", anchor=" + this.anchor + ", visible=" + this.visible + ')';
    }

    public final SelectionHandleAnchor getAnchor() {
        return this.anchor;
    }

    public final Handle getHandle() {
        return this.handle;
    }

    /* JADX INFO: renamed from: getPosition-F1C5BW0, reason: not valid java name */
    public final long m1459getPositionF1C5BW0() {
        return this.position;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    private SelectionHandleInfo(Handle r100, long r101, SelectionHandleAnchor r102, boolean r103) {
        this.handle = r100;
        this.position = r101;
        this.anchor = r102;
        this.visible = r103;
    }
}
