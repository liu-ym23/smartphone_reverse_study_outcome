package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0088\u0001\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0018J%\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0018J\u001a\u0010 \u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010%\u001a\u0004\b(\u0010'R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b)\u0010'R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010%\u001a\u0004\b*\u0010'R\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010%\u001a\u0004\b+\u0010'R\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010%\u001a\u0004\b,\u0010'R\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010%\u001a\u0004\b-\u0010'R\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b.\u0010'R\u001d\u0010\u000b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b/\u0010'R\u001d\u0010\f\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b0\u0010'R\u001d\u0010\r\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\r\u0010%\u001a\u0004\b1\u0010'R\u001d\u0010\u000e\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b2\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/material3/SegmentedButtonColors;", "", "Landroidx/compose/ui/graphics/Color;", "activeContainerColor", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", AppAgent.CONSTRUCT, "(JJJJJJJJJJJJLkotlin/jvm/internal/e;)V", "copy-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material3/SegmentedButtonColors;", "copy", "", "enabled", "active", "borderColor-WaAFU9c$material3_release", "(ZZ)J", "borderColor", "checked", "contentColor-WaAFU9c$material3_release", "contentColor", "containerColor-WaAFU9c$material3_release", "containerColor", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getActiveContainerColor-0d7_KjU", "()J", "getActiveContentColor-0d7_KjU", "getActiveBorderColor-0d7_KjU", "getInactiveContainerColor-0d7_KjU", "getInactiveContentColor-0d7_KjU", "getInactiveBorderColor-0d7_KjU", "getDisabledActiveContainerColor-0d7_KjU", "getDisabledActiveContentColor-0d7_KjU", "getDisabledActiveBorderColor-0d7_KjU", "getDisabledInactiveContainerColor-0d7_KjU", "getDisabledInactiveContentColor-0d7_KjU", "getDisabledInactiveBorderColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedButtonColors {
    public static final int $stable = 0;
    private final long activeBorderColor;
    private final long activeContainerColor;
    private final long activeContentColor;
    private final long disabledActiveBorderColor;
    private final long disabledActiveContainerColor;
    private final long disabledActiveContentColor;
    private final long disabledInactiveBorderColor;
    private final long disabledInactiveContainerColor;
    private final long disabledInactiveContentColor;
    private final long inactiveBorderColor;
    private final long inactiveContainerColor;
    private final long inactiveContentColor;

    public /* synthetic */ SegmentedButtonColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19);
    }

    /* renamed from: copy-2qZNXz8$default, reason: not valid java name */
    public static /* synthetic */ SegmentedButtonColors m2199copy2qZNXz8$default(SegmentedButtonColors segmentedButtonColors, long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, int i, Object obj) {
        long j20;
        long j21;
        long j22 = (i & 1) != 0 ? segmentedButtonColors.activeContainerColor : j5;
        long j23 = (i & 2) != 0 ? segmentedButtonColors.activeContentColor : j6;
        long j24 = (i & 4) != 0 ? segmentedButtonColors.activeBorderColor : j10;
        long j25 = (i & 8) != 0 ? segmentedButtonColors.inactiveContainerColor : j11;
        long j26 = (i & 16) != 0 ? segmentedButtonColors.inactiveContentColor : j12;
        long j27 = (i & 32) != 0 ? segmentedButtonColors.inactiveBorderColor : j13;
        long j28 = (i & 64) != 0 ? segmentedButtonColors.disabledActiveContainerColor : j14;
        long j29 = j22;
        long j30 = (i & 128) != 0 ? segmentedButtonColors.disabledActiveContentColor : j15;
        long j31 = (i & 256) != 0 ? segmentedButtonColors.disabledActiveBorderColor : j16;
        long j32 = (i & 512) != 0 ? segmentedButtonColors.disabledInactiveContainerColor : j17;
        long j33 = (i & 1024) != 0 ? segmentedButtonColors.disabledInactiveContentColor : j18;
        if ((i & 2048) != 0) {
            j21 = j33;
            j20 = segmentedButtonColors.disabledInactiveBorderColor;
        } else {
            j20 = j19;
            j21 = j33;
        }
        return segmentedButtonColors.m2203copy2qZNXz8(j29, j23, j24, j25, j26, j27, j28, j30, j31, j32, j21, j20);
    }

    @Stable
    /* renamed from: borderColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2200borderColorWaAFU9c$material3_release(boolean enabled, boolean active) {
        return (enabled && active) ? this.activeBorderColor : (!enabled || active) ? (enabled || !active) ? this.disabledInactiveBorderColor : this.disabledActiveBorderColor : this.inactiveBorderColor;
    }

    @Stable
    /* renamed from: containerColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2201containerColorWaAFU9c$material3_release(boolean enabled, boolean active) {
        return (enabled && active) ? this.activeContainerColor : (!enabled || active) ? (enabled || !active) ? this.disabledInactiveContainerColor : this.disabledActiveContainerColor : this.inactiveContainerColor;
    }

    @Stable
    /* renamed from: contentColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2202contentColorWaAFU9c$material3_release(boolean enabled, boolean checked) {
        return (enabled && checked) ? this.activeContentColor : (!enabled || checked) ? (enabled || !checked) ? this.disabledInactiveContentColor : this.disabledActiveContentColor : this.inactiveContentColor;
    }

    /* renamed from: copy-2qZNXz8, reason: not valid java name */
    public final SegmentedButtonColors m2203copy2qZNXz8(long activeContainerColor, long activeContentColor, long activeBorderColor, long inactiveContainerColor, long inactiveContentColor, long inactiveBorderColor, long disabledActiveContainerColor, long disabledActiveContentColor, long disabledActiveBorderColor, long disabledInactiveContainerColor, long disabledInactiveContentColor, long disabledInactiveBorderColor) {
        return new SegmentedButtonColors(activeContainerColor != 16 ? activeContainerColor : this.activeContainerColor, activeContentColor != 16 ? activeContentColor : this.activeContentColor, activeBorderColor != 16 ? activeBorderColor : this.activeBorderColor, inactiveContainerColor != 16 ? inactiveContainerColor : this.inactiveContainerColor, inactiveContentColor != 16 ? inactiveContentColor : this.inactiveContentColor, inactiveBorderColor != 16 ? inactiveBorderColor : this.inactiveBorderColor, disabledActiveContainerColor != 16 ? disabledActiveContainerColor : this.disabledActiveContainerColor, disabledActiveContentColor != 16 ? disabledActiveContentColor : this.disabledActiveContentColor, disabledActiveBorderColor != 16 ? disabledActiveBorderColor : this.disabledActiveBorderColor, disabledInactiveContainerColor != 16 ? disabledInactiveContainerColor : this.disabledInactiveContainerColor, disabledInactiveContentColor != 16 ? disabledInactiveContentColor : this.disabledInactiveContentColor, disabledInactiveBorderColor != 16 ? disabledInactiveBorderColor : this.disabledInactiveBorderColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || SegmentedButtonColors.class != other.getClass()) {
            return false;
        }
        SegmentedButtonColors segmentedButtonColors = (SegmentedButtonColors) other;
        return Color.m4140equalsimpl0(this.activeBorderColor, segmentedButtonColors.activeBorderColor) && Color.m4140equalsimpl0(this.activeContentColor, segmentedButtonColors.activeContentColor) && Color.m4140equalsimpl0(this.activeContainerColor, segmentedButtonColors.activeContainerColor) && Color.m4140equalsimpl0(this.inactiveBorderColor, segmentedButtonColors.inactiveBorderColor) && Color.m4140equalsimpl0(this.inactiveContentColor, segmentedButtonColors.inactiveContentColor) && Color.m4140equalsimpl0(this.inactiveContainerColor, segmentedButtonColors.inactiveContainerColor) && Color.m4140equalsimpl0(this.disabledActiveBorderColor, segmentedButtonColors.disabledActiveBorderColor) && Color.m4140equalsimpl0(this.disabledActiveContentColor, segmentedButtonColors.disabledActiveContentColor) && Color.m4140equalsimpl0(this.disabledActiveContainerColor, segmentedButtonColors.disabledActiveContainerColor) && Color.m4140equalsimpl0(this.disabledInactiveBorderColor, segmentedButtonColors.disabledInactiveBorderColor) && Color.m4140equalsimpl0(this.disabledInactiveContentColor, segmentedButtonColors.disabledInactiveContentColor) && Color.m4140equalsimpl0(this.disabledInactiveContainerColor, segmentedButtonColors.disabledInactiveContainerColor);
    }

    /* renamed from: getActiveBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getActiveBorderColor() {
        return this.activeBorderColor;
    }

    /* renamed from: getActiveContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getActiveContainerColor() {
        return this.activeContainerColor;
    }

    /* renamed from: getActiveContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getActiveContentColor() {
        return this.activeContentColor;
    }

    /* renamed from: getDisabledActiveBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledActiveBorderColor() {
        return this.disabledActiveBorderColor;
    }

    /* renamed from: getDisabledActiveContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledActiveContainerColor() {
        return this.disabledActiveContainerColor;
    }

    /* renamed from: getDisabledActiveContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledActiveContentColor() {
        return this.disabledActiveContentColor;
    }

    /* renamed from: getDisabledInactiveBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledInactiveBorderColor() {
        return this.disabledInactiveBorderColor;
    }

    /* renamed from: getDisabledInactiveContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledInactiveContainerColor() {
        return this.disabledInactiveContainerColor;
    }

    /* renamed from: getDisabledInactiveContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledInactiveContentColor() {
        return this.disabledInactiveContentColor;
    }

    /* renamed from: getInactiveBorderColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getInactiveBorderColor() {
        return this.inactiveBorderColor;
    }

    /* renamed from: getInactiveContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getInactiveContainerColor() {
        return this.inactiveContainerColor;
    }

    /* renamed from: getInactiveContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getInactiveContentColor() {
        return this.inactiveContentColor;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.disabledInactiveContainerColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.activeBorderColor) * 31, 31, this.activeContentColor), 31, this.activeContainerColor), 31, this.inactiveBorderColor), 31, this.inactiveContentColor), 31, this.inactiveContainerColor), 31, this.disabledActiveBorderColor), 31, this.disabledActiveContentColor), 31, this.disabledActiveContainerColor), 31, this.disabledInactiveBorderColor), 31, this.disabledInactiveContentColor);
    }

    private SegmentedButtonColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19) {
        this.activeContainerColor = j5;
        this.activeContentColor = j6;
        this.activeBorderColor = j10;
        this.inactiveContainerColor = j11;
        this.inactiveContentColor = j12;
        this.inactiveBorderColor = j13;
        this.disabledActiveContainerColor = j14;
        this.disabledActiveContentColor = j15;
        this.disabledActiveBorderColor = j16;
        this.disabledInactiveContainerColor = j17;
        this.disabledInactiveContentColor = j18;
        this.disabledInactiveBorderColor = j19;
    }
}
