package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuColors;", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "iconColor", "disabledTextColor", "disabledIconColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundColor-0d7_KjU", "()J", "J", "getTextColor-0d7_KjU", "getIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getDisabledIconColor-0d7_KjU", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuColors {
    public static final int $stable = 0;
    private final long backgroundColor;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long iconColor;
    private final long textColor;

    public /* synthetic */ ContextMenuColors(long r100, long r101, long r102, long r103, long r104, DefaultConstructorMarker r110) {
        this(r100, r101, r102, r103, r104);
    }

    public int hashCode() {
        return (((((((Color.m4834hashCodeimpl(this.backgroundColor) * 31) + Color.m4834hashCodeimpl(this.textColor)) * 31) + Color.m4834hashCodeimpl(this.iconColor)) * 31) + Color.m4834hashCodeimpl(this.disabledTextColor)) * 31) + Color.m4834hashCodeimpl(this.disabledIconColor);
    }

    public String toString() {
        return "ContextMenuColors(backgroundColor=" + Color.m4835toStringimpl(this.backgroundColor) + ", textColor=" + Color.m4835toStringimpl(this.textColor) + ", iconColor=" + Color.m4835toStringimpl(this.iconColor) + ", disabledTextColor=" + Color.m4835toStringimpl(this.disabledTextColor) + ", disabledIconColor=" + Color.m4835toStringimpl(this.disabledIconColor) + ')';
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m335getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: getDisabledIconColor-0d7_KjU, reason: not valid java name */
    public final long m336getDisabledIconColor0d7_KjU() {
        return this.disabledIconColor;
    }

    /* JADX INFO: renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name */
    public final long m337getDisabledTextColor0d7_KjU() {
        return this.disabledTextColor;
    }

    /* JADX INFO: renamed from: getIconColor-0d7_KjU, reason: not valid java name */
    public final long m338getIconColor0d7_KjU() {
        return this.iconColor;
    }

    /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
    public final long m339getTextColor0d7_KjU() {
        return this.textColor;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L26:
        return false;
    L8:
        if ((r100 instanceof ContextMenuColors) == false) goto L26;
        ContextMenuColors r101 = (ContextMenuColors) r100;
        if (Color.m4828equalsimpl0(this.backgroundColor, r101.backgroundColor) == true) goto L14;
        return false;
    L14:
        if (Color.m4828equalsimpl0(this.textColor, r101.textColor) == true) goto L17;
        return false;
    L17:
        if (Color.m4828equalsimpl0(this.iconColor, r101.iconColor) == true) goto L20;
        return false;
    L20:
        if (Color.m4828equalsimpl0(this.disabledTextColor, r101.disabledTextColor) == true) goto L23;
        return false;
    L23:
        if (Color.m4828equalsimpl0(this.disabledIconColor, r101.disabledIconColor) == true) goto L25;
        return false;
    L25:
        return true;
    }

    private ContextMenuColors(long r100, long r101, long r102, long r103, long r104) {
        this.backgroundColor = r100;
        this.textColor = r101;
        this.iconColor = r102;
        this.disabledTextColor = r103;
        this.disabledIconColor = r104;
    }
}
