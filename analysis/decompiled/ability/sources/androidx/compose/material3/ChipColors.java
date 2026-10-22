package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ`\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u001d\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\u001a\u0010\u0018\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u001d\u0010\t\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001d\u0010\n\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b&\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Landroidx/compose/material3/ChipColors;", "", "Landroidx/compose/ui/graphics/Color;", "containerColor", "labelColor", "leadingIconContentColor", "trailingIconContentColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconContentColor", "disabledTrailingIconContentColor", AppAgent.CONSTRUCT, "(JJJJJJJJLkotlin/jvm/internal/e;)V", "copy-FD3wquc", "(JJJJJJJJ)Landroidx/compose/material3/ChipColors;", "copy", "", "enabled", "containerColor-vNxB06k$material3_release", "(Z)J", "labelColor-vNxB06k$material3_release", "leadingIconContentColor-vNxB06k$material3_release", "trailingIconContentColor-vNxB06k$material3_release", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getContainerColor-0d7_KjU", "()J", "getLabelColor-0d7_KjU", "getLeadingIconContentColor-0d7_KjU", "getTrailingIconContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledLabelColor-0d7_KjU", "getDisabledLeadingIconContentColor-0d7_KjU", "getDisabledTrailingIconContentColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconContentColor;
    private final long disabledTrailingIconContentColor;
    private final long labelColor;
    private final long leadingIconContentColor;
    private final long trailingIconContentColor;

    public /* synthetic */ ChipColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14, j15);
    }

    /* renamed from: copy-FD3wquc$default, reason: not valid java name */
    public static /* synthetic */ ChipColors m1598copyFD3wquc$default(ChipColors chipColors, long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, int i, Object obj) {
        long j16;
        long j17;
        long j18 = (i & 1) != 0 ? chipColors.containerColor : j5;
        long j19 = (i & 2) != 0 ? chipColors.labelColor : j6;
        long j20 = (i & 4) != 0 ? chipColors.leadingIconContentColor : j10;
        long j21 = (i & 8) != 0 ? chipColors.trailingIconContentColor : j11;
        long j22 = (i & 16) != 0 ? chipColors.disabledContainerColor : j12;
        long j23 = (i & 32) != 0 ? chipColors.disabledLabelColor : j13;
        long j24 = (i & 64) != 0 ? chipColors.disabledLeadingIconContentColor : j14;
        if ((i & 128) != 0) {
            j16 = chipColors.disabledTrailingIconContentColor;
            j17 = j18;
        } else {
            j16 = j15;
            j17 = j18;
        }
        return chipColors.m1600copyFD3wquc(j17, j19, j20, j21, j22, j23, j24, j16);
    }

    @Stable
    /* renamed from: containerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1599containerColorvNxB06k$material3_release(boolean enabled) {
        return enabled ? this.containerColor : this.disabledContainerColor;
    }

    /* renamed from: copy-FD3wquc, reason: not valid java name */
    public final ChipColors m1600copyFD3wquc(long containerColor, long labelColor, long leadingIconContentColor, long trailingIconContentColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconContentColor, long disabledTrailingIconContentColor) {
        return new ChipColors(containerColor != 16 ? containerColor : this.containerColor, labelColor != 16 ? labelColor : this.labelColor, leadingIconContentColor != 16 ? leadingIconContentColor : this.leadingIconContentColor, trailingIconContentColor != 16 ? trailingIconContentColor : this.trailingIconContentColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, disabledLabelColor != 16 ? disabledLabelColor : this.disabledLabelColor, disabledLeadingIconContentColor != 16 ? disabledLeadingIconContentColor : this.disabledLeadingIconContentColor, disabledTrailingIconContentColor != 16 ? disabledTrailingIconContentColor : this.disabledTrailingIconContentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof ChipColors)) {
            return false;
        }
        ChipColors chipColors = (ChipColors) other;
        return Color.m4140equalsimpl0(this.containerColor, chipColors.containerColor) && Color.m4140equalsimpl0(this.labelColor, chipColors.labelColor) && Color.m4140equalsimpl0(this.leadingIconContentColor, chipColors.leadingIconContentColor) && Color.m4140equalsimpl0(this.trailingIconContentColor, chipColors.trailingIconContentColor) && Color.m4140equalsimpl0(this.disabledContainerColor, chipColors.disabledContainerColor) && Color.m4140equalsimpl0(this.disabledLabelColor, chipColors.disabledLabelColor) && Color.m4140equalsimpl0(this.disabledLeadingIconContentColor, chipColors.disabledLeadingIconContentColor) && Color.m4140equalsimpl0(this.disabledTrailingIconContentColor, chipColors.disabledTrailingIconContentColor);
    }

    /* renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    /* renamed from: getDisabledLabelColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledLabelColor() {
        return this.disabledLabelColor;
    }

    /* renamed from: getDisabledLeadingIconContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledLeadingIconContentColor() {
        return this.disabledLeadingIconContentColor;
    }

    /* renamed from: getDisabledTrailingIconContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledTrailingIconContentColor() {
        return this.disabledTrailingIconContentColor;
    }

    /* renamed from: getLabelColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getLabelColor() {
        return this.labelColor;
    }

    /* renamed from: getLeadingIconContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getLeadingIconContentColor() {
        return this.leadingIconContentColor;
    }

    /* renamed from: getTrailingIconContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTrailingIconContentColor() {
        return this.trailingIconContentColor;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.disabledTrailingIconContentColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.containerColor) * 31, 31, this.labelColor), 31, this.leadingIconContentColor), 31, this.trailingIconContentColor), 31, this.disabledContainerColor), 31, this.disabledLabelColor), 31, this.disabledLeadingIconContentColor);
    }

    @Stable
    /* renamed from: labelColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1609labelColorvNxB06k$material3_release(boolean enabled) {
        return enabled ? this.labelColor : this.disabledLabelColor;
    }

    @Stable
    /* renamed from: leadingIconContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1610leadingIconContentColorvNxB06k$material3_release(boolean enabled) {
        return enabled ? this.leadingIconContentColor : this.disabledLeadingIconContentColor;
    }

    @Stable
    /* renamed from: trailingIconContentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m1611trailingIconContentColorvNxB06k$material3_release(boolean enabled) {
        return enabled ? this.trailingIconContentColor : this.disabledTrailingIconContentColor;
    }

    private ChipColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15) {
        this.containerColor = j5;
        this.labelColor = j6;
        this.leadingIconContentColor = j10;
        this.trailingIconContentColor = j11;
        this.disabledContainerColor = j12;
        this.disabledLabelColor = j13;
        this.disabledLeadingIconContentColor = j14;
        this.disabledTrailingIconContentColor = j15;
    }
}
