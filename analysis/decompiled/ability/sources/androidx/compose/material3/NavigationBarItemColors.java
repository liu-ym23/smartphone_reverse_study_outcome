package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJV\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u001a\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001a\u0010'\u001a\u00020\u00028@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b&\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/material3/NavigationBarItemColors;", "", "Landroidx/compose/ui/graphics/Color;", "selectedIconColor", "selectedTextColor", "selectedIndicatorColor", "unselectedIconColor", "unselectedTextColor", "disabledIconColor", "disabledTextColor", AppAgent.CONSTRUCT, "(JJJJJJJLkotlin/jvm/internal/e;)V", "copy-4JmcsL4", "(JJJJJJJ)Landroidx/compose/material3/NavigationBarItemColors;", "copy", "", "selected", "enabled", "iconColor-WaAFU9c$material3_release", "(ZZ)J", "iconColor", "textColor-WaAFU9c$material3_release", "textColor", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getSelectedIconColor-0d7_KjU", "()J", "getSelectedTextColor-0d7_KjU", "getSelectedIndicatorColor-0d7_KjU", "getUnselectedIconColor-0d7_KjU", "getUnselectedTextColor-0d7_KjU", "getDisabledIconColor-0d7_KjU", "getDisabledTextColor-0d7_KjU", "getIndicatorColor-0d7_KjU$material3_release", "indicatorColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationBarItemColors {
    public static final int $stable = 0;
    private final long disabledIconColor;
    private final long disabledTextColor;
    private final long selectedIconColor;
    private final long selectedIndicatorColor;
    private final long selectedTextColor;
    private final long unselectedIconColor;
    private final long unselectedTextColor;

    public /* synthetic */ NavigationBarItemColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14);
    }

    /* renamed from: copy-4JmcsL4, reason: not valid java name */
    public final NavigationBarItemColors m2022copy4JmcsL4(long selectedIconColor, long selectedTextColor, long selectedIndicatorColor, long unselectedIconColor, long unselectedTextColor, long disabledIconColor, long disabledTextColor) {
        return new NavigationBarItemColors(selectedIconColor != 16 ? selectedIconColor : this.selectedIconColor, selectedTextColor != 16 ? selectedTextColor : this.selectedTextColor, selectedIndicatorColor != 16 ? selectedIndicatorColor : this.selectedIndicatorColor, unselectedIconColor != 16 ? unselectedIconColor : this.unselectedIconColor, unselectedTextColor != 16 ? unselectedTextColor : this.unselectedTextColor, disabledIconColor != 16 ? disabledIconColor : this.disabledIconColor, disabledTextColor != 16 ? disabledTextColor : this.disabledTextColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof NavigationBarItemColors)) {
            return false;
        }
        NavigationBarItemColors navigationBarItemColors = (NavigationBarItemColors) other;
        return Color.m4140equalsimpl0(this.selectedIconColor, navigationBarItemColors.selectedIconColor) && Color.m4140equalsimpl0(this.unselectedIconColor, navigationBarItemColors.unselectedIconColor) && Color.m4140equalsimpl0(this.selectedTextColor, navigationBarItemColors.selectedTextColor) && Color.m4140equalsimpl0(this.unselectedTextColor, navigationBarItemColors.unselectedTextColor) && Color.m4140equalsimpl0(this.selectedIndicatorColor, navigationBarItemColors.selectedIndicatorColor) && Color.m4140equalsimpl0(this.disabledIconColor, navigationBarItemColors.disabledIconColor) && Color.m4140equalsimpl0(this.disabledTextColor, navigationBarItemColors.disabledTextColor);
    }

    /* renamed from: getDisabledIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledIconColor() {
        return this.disabledIconColor;
    }

    /* renamed from: getDisabledTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledTextColor() {
        return this.disabledTextColor;
    }

    /* renamed from: getIndicatorColor-0d7_KjU$material3_release, reason: not valid java name and from getter */
    public final long getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    /* renamed from: getSelectedIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedIconColor() {
        return this.selectedIconColor;
    }

    /* renamed from: getSelectedIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m2027getSelectedIndicatorColor0d7_KjU() {
        return this.selectedIndicatorColor;
    }

    /* renamed from: getSelectedTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getSelectedTextColor() {
        return this.selectedTextColor;
    }

    /* renamed from: getUnselectedIconColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedIconColor() {
        return this.unselectedIconColor;
    }

    /* renamed from: getUnselectedTextColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getUnselectedTextColor() {
        return this.unselectedTextColor;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.disabledTextColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.selectedIconColor) * 31, 31, this.unselectedIconColor), 31, this.selectedTextColor), 31, this.unselectedTextColor), 31, this.selectedIndicatorColor), 31, this.disabledIconColor);
    }

    @Stable
    /* renamed from: iconColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2031iconColorWaAFU9c$material3_release(boolean selected, boolean enabled) {
        return !enabled ? this.disabledIconColor : selected ? this.selectedIconColor : this.unselectedIconColor;
    }

    @Stable
    /* renamed from: textColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2032textColorWaAFU9c$material3_release(boolean selected, boolean enabled) {
        return !enabled ? this.disabledTextColor : selected ? this.selectedTextColor : this.unselectedTextColor;
    }

    private NavigationBarItemColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14) {
        this.selectedIconColor = j5;
        this.selectedTextColor = j6;
        this.selectedIndicatorColor = j10;
        this.unselectedIconColor = j11;
        this.unselectedTextColor = j12;
        this.disabledIconColor = j13;
        this.disabledTextColor = j14;
    }
}
