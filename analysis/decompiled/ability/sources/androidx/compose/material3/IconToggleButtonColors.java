package androidx.compose.material3;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Immutable
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJL\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0014\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b \u0010\u001dR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b!\u0010\u001dR\u001d\u0010\b\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\"\u0010\u001d\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/material3/IconToggleButtonColors;", "", "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "disabledContainerColor", "disabledContentColor", "checkedContainerColor", "checkedContentColor", AppAgent.CONSTRUCT, "(JJJJJJLkotlin/jvm/internal/e;)V", "copy-tNS2XkQ", "(JJJJJJ)Landroidx/compose/material3/IconToggleButtonColors;", "copy", "", "enabled", "checked", "Landroidx/compose/runtime/State;", "containerColor$material3_release", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "contentColor$material3_release", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "J", "getContainerColor-0d7_KjU", "()J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "getCheckedContainerColor-0d7_KjU", "getCheckedContentColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconToggleButtonColors {
    public static final int $stable = 0;
    private final long checkedContainerColor;
    private final long checkedContentColor;
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ IconToggleButtonColors(long j5, long j6, long j10, long j11, long j12, long j13, e eVar) {
        this(j5, j6, j10, j11, j12, j13);
    }

    /* renamed from: copy-tNS2XkQ$default, reason: not valid java name */
    public static /* synthetic */ IconToggleButtonColors m1912copytNS2XkQ$default(IconToggleButtonColors iconToggleButtonColors, long j5, long j6, long j10, long j11, long j12, long j13, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = iconToggleButtonColors.containerColor;
        }
        return iconToggleButtonColors.m1913copytNS2XkQ(j5, (i & 2) != 0 ? iconToggleButtonColors.contentColor : j6, (i & 4) != 0 ? iconToggleButtonColors.disabledContainerColor : j10, (i & 8) != 0 ? iconToggleButtonColors.disabledContentColor : j11, (i & 16) != 0 ? iconToggleButtonColors.checkedContainerColor : j12, (i & 32) != 0 ? iconToggleButtonColors.checkedContentColor : j13);
    }

    @Composable
    public final State<Color> containerColor$material3_release(boolean z10, boolean z11, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1175394478, i, -1, "androidx.compose.material3.IconToggleButtonColors.containerColor (IconButton.kt:1239)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(!z10 ? this.disabledContainerColor : !z11 ? this.containerColor : this.checkedContainerColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateRememberUpdatedState;
    }

    @Composable
    public final State<Color> contentColor$material3_release(boolean z10, boolean z11, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1340854054, i, -1, "androidx.compose.material3.IconToggleButtonColors.contentColor (IconButton.kt:1256)");
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4129boximpl(!z10 ? this.disabledContentColor : !z11 ? this.contentColor : this.checkedContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return stateRememberUpdatedState;
    }

    /* renamed from: copy-tNS2XkQ, reason: not valid java name */
    public final IconToggleButtonColors m1913copytNS2XkQ(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor) {
        return new IconToggleButtonColors(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, disabledContentColor != 16 ? disabledContentColor : this.disabledContentColor, checkedContainerColor != 16 ? checkedContainerColor : this.checkedContainerColor, checkedContentColor != 16 ? checkedContentColor : this.checkedContentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof IconToggleButtonColors)) {
            return false;
        }
        IconToggleButtonColors iconToggleButtonColors = (IconToggleButtonColors) other;
        return Color.m4140equalsimpl0(this.containerColor, iconToggleButtonColors.containerColor) && Color.m4140equalsimpl0(this.contentColor, iconToggleButtonColors.contentColor) && Color.m4140equalsimpl0(this.disabledContainerColor, iconToggleButtonColors.disabledContainerColor) && Color.m4140equalsimpl0(this.disabledContentColor, iconToggleButtonColors.disabledContentColor) && Color.m4140equalsimpl0(this.checkedContainerColor, iconToggleButtonColors.checkedContainerColor) && Color.m4140equalsimpl0(this.checkedContentColor, iconToggleButtonColors.checkedContentColor);
    }

    /* renamed from: getCheckedContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedContainerColor() {
        return this.checkedContainerColor;
    }

    /* renamed from: getCheckedContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckedContentColor() {
        return this.checkedContentColor;
    }

    /* renamed from: getContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* renamed from: getContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    /* renamed from: getDisabledContainerColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    /* renamed from: getDisabledContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getDisabledContentColor() {
        return this.disabledContentColor;
    }

    public int hashCode() {
        return Color.m4146hashCodeimpl(this.checkedContentColor) + androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(androidx.compose.foundation.b.c(Color.m4146hashCodeimpl(this.containerColor) * 31, 31, this.contentColor), 31, this.disabledContainerColor), 31, this.disabledContentColor), 31, this.checkedContainerColor);
    }

    private IconToggleButtonColors(long j5, long j6, long j10, long j11, long j12, long j13) {
        this.containerColor = j5;
        this.contentColor = j6;
        this.disabledContainerColor = j10;
        this.disabledContentColor = j11;
        this.checkedContainerColor = j12;
        this.checkedContentColor = j13;
    }
}
