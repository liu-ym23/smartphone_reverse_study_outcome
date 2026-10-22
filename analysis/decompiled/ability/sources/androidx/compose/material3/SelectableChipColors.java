package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0092\u0001\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J%\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J%\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0019J\u001a\u0010 \u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u001a\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010%R\u001a\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0004\u0010%R\u001a\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010%R\u001a\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0006\u0010%R\u001a\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u001a\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\b\u0010%R\u001a\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\t\u0010%R\u001a\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\n\u0010%R\u001a\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000b\u0010%R\u001a\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\f\u0010%R\u001a\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\r\u0010%R\u001a\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000e\u0010%R\u001a\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000f\u0010%\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/SelectableChipColors;", "", "Landroidx/compose/ui/graphics/Color;", "containerColor", "labelColor", "leadingIconColor", "trailingIconColor", "disabledContainerColor", "disabledLabelColor", "disabledLeadingIconColor", "disabledTrailingIconColor", "selectedContainerColor", "disabledSelectedContainerColor", "selectedLabelColor", "selectedLeadingIconColor", "selectedTrailingIconColor", AppAgent.CONSTRUCT, "(JJJJJJJJJJJJJLkotlin/jvm/internal/e;)V", "copy-daRQuJA", "(JJJJJJJJJJJJJ)Landroidx/compose/material3/SelectableChipColors;", "copy", "", "enabled", "selected", "containerColor-WaAFU9c$material3_release", "(ZZ)J", "labelColor-WaAFU9c$material3_release", "leadingIconContentColor-WaAFU9c$material3_release", "leadingIconContentColor", "trailingIconContentColor-WaAFU9c$material3_release", "trailingIconContentColor", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SelectableChipColors {
    public static final int $stable = 0;
    private final long containerColor;
    private final long disabledContainerColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledSelectedContainerColor;
    private final long disabledTrailingIconColor;
    private final long labelColor;
    private final long leadingIconColor;
    private final long selectedContainerColor;
    private final long selectedLabelColor;
    private final long selectedLeadingIconColor;
    private final long selectedTrailingIconColor;
    private final long trailingIconColor;

    public /* synthetic */ SelectableChipColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, e eVar) {
        this(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20);
    }

    /* renamed from: copy-daRQuJA$default, reason: not valid java name */
    public static /* synthetic */ SelectableChipColors m2224copydaRQuJA$default(SelectableChipColors selectableChipColors, long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, int i, Object obj) {
        long j21;
        long j22;
        long j23 = (i & 1) != 0 ? selectableChipColors.containerColor : j5;
        long j24 = (i & 2) != 0 ? selectableChipColors.labelColor : j6;
        long j25 = (i & 4) != 0 ? selectableChipColors.leadingIconColor : j10;
        long j26 = (i & 8) != 0 ? selectableChipColors.trailingIconColor : j11;
        long j27 = (i & 16) != 0 ? selectableChipColors.disabledContainerColor : j12;
        long j28 = (i & 32) != 0 ? selectableChipColors.disabledLabelColor : j13;
        long j29 = (i & 64) != 0 ? selectableChipColors.disabledLeadingIconColor : j14;
        long j30 = j23;
        long j31 = (i & 128) != 0 ? selectableChipColors.disabledTrailingIconColor : j15;
        long j32 = (i & 256) != 0 ? selectableChipColors.selectedContainerColor : j16;
        long j33 = (i & 512) != 0 ? selectableChipColors.disabledSelectedContainerColor : j17;
        long j34 = (i & 1024) != 0 ? selectableChipColors.selectedLabelColor : j18;
        long j35 = (i & 2048) != 0 ? selectableChipColors.selectedLeadingIconColor : j19;
        if ((i & 4096) != 0) {
            j22 = j35;
            j21 = selectableChipColors.selectedTrailingIconColor;
        } else {
            j21 = j20;
            j22 = j35;
        }
        return selectableChipColors.m2226copydaRQuJA(j30, j24, j25, j26, j27, j28, j29, j31, j32, j33, j34, j22, j21);
    }

    @Stable
    /* renamed from: containerColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2225containerColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? selected ? this.disabledSelectedContainerColor : this.disabledContainerColor : !selected ? this.containerColor : this.selectedContainerColor;
    }

    /* renamed from: copy-daRQuJA, reason: not valid java name */
    public final SelectableChipColors m2226copydaRQuJA(long containerColor, long labelColor, long leadingIconColor, long trailingIconColor, long disabledContainerColor, long disabledLabelColor, long disabledLeadingIconColor, long disabledTrailingIconColor, long selectedContainerColor, long disabledSelectedContainerColor, long selectedLabelColor, long selectedLeadingIconColor, long selectedTrailingIconColor) {
        return new SelectableChipColors(containerColor != 16 ? containerColor : this.containerColor, labelColor != 16 ? labelColor : this.labelColor, leadingIconColor != 16 ? leadingIconColor : this.leadingIconColor, trailingIconColor != 16 ? trailingIconColor : this.trailingIconColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, disabledLabelColor != 16 ? disabledLabelColor : this.disabledLabelColor, disabledLeadingIconColor != 16 ? disabledLeadingIconColor : this.disabledLeadingIconColor, disabledTrailingIconColor != 16 ? disabledTrailingIconColor : this.disabledTrailingIconColor, selectedContainerColor != 16 ? selectedContainerColor : this.selectedContainerColor, disabledSelectedContainerColor != 16 ? disabledSelectedContainerColor : this.disabledSelectedContainerColor, selectedLabelColor != 16 ? selectedLabelColor : this.selectedLabelColor, selectedLeadingIconColor != 16 ? selectedLeadingIconColor : this.selectedLeadingIconColor, selectedTrailingIconColor != 16 ? selectedTrailingIconColor : this.selectedTrailingIconColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof SelectableChipColors)) {
            return false;
        }
        SelectableChipColors selectableChipColors = (SelectableChipColors) other;
        return Color.m4140equalsimpl0(this.containerColor, selectableChipColors.containerColor) && Color.m4140equalsimpl0(this.labelColor, selectableChipColors.labelColor) && Color.m4140equalsimpl0(this.leadingIconColor, selectableChipColors.leadingIconColor) && Color.m4140equalsimpl0(this.trailingIconColor, selectableChipColors.trailingIconColor) && Color.m4140equalsimpl0(this.disabledContainerColor, selectableChipColors.disabledContainerColor) && Color.m4140equalsimpl0(this.disabledLabelColor, selectableChipColors.disabledLabelColor) && Color.m4140equalsimpl0(this.disabledLeadingIconColor, selectableChipColors.disabledLeadingIconColor) && Color.m4140equalsimpl0(this.disabledTrailingIconColor, selectableChipColors.disabledTrailingIconColor) && Color.m4140equalsimpl0(this.selectedContainerColor, selectableChipColors.selectedContainerColor) && Color.m4140equalsimpl0(this.disabledSelectedContainerColor, selectableChipColors.disabledSelectedContainerColor) && Color.m4140equalsimpl0(this.selectedLabelColor, selectableChipColors.selectedLabelColor) && Color.m4140equalsimpl0(this.selectedLeadingIconColor, selectableChipColors.selectedLeadingIconColor) && Color.m4140equalsimpl0(this.selectedTrailingIconColor, selectableChipColors.selectedTrailingIconColor);
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.selectedTrailingIconColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.containerColor) * 31, 31, this.labelColor), 31, this.leadingIconColor), 31, this.trailingIconColor), 31, this.disabledContainerColor), 31, this.disabledLabelColor), 31, this.disabledLeadingIconColor), 31, this.disabledTrailingIconColor), 31, this.selectedContainerColor), 31, this.disabledSelectedContainerColor), 31, this.selectedLabelColor), 31, this.selectedLeadingIconColor);
    }

    @Stable
    /* renamed from: labelColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2227labelColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? this.disabledLabelColor : !selected ? this.labelColor : this.selectedLabelColor;
    }

    @Stable
    /* renamed from: leadingIconContentColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2228leadingIconContentColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? this.disabledLeadingIconColor : !selected ? this.leadingIconColor : this.selectedLeadingIconColor;
    }

    @Stable
    /* renamed from: trailingIconContentColor-WaAFU9c$material3_release, reason: not valid java name */
    public final long m2229trailingIconContentColorWaAFU9c$material3_release(boolean enabled, boolean selected) {
        return !enabled ? this.disabledTrailingIconColor : !selected ? this.trailingIconColor : this.selectedTrailingIconColor;
    }

    private SelectableChipColors(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20) {
        this.containerColor = j5;
        this.labelColor = j6;
        this.leadingIconColor = j10;
        this.trailingIconColor = j11;
        this.disabledContainerColor = j12;
        this.disabledLabelColor = j13;
        this.disabledLeadingIconColor = j14;
        this.disabledTrailingIconColor = j15;
        this.selectedContainerColor = j16;
        this.disabledSelectedContainerColor = j17;
        this.selectedLabelColor = j18;
        this.selectedLeadingIconColor = j19;
        this.selectedTrailingIconColor = j20;
    }
}
