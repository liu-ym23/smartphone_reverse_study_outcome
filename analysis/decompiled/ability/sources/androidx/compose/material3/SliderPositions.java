package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Stable
@C7.c
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR7\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/SliderPositions;", "", "LY7/b;", "", "initialActiveRange", "", "initialTickFractions", AppAgent.CONSTRUCT, "(LY7/b;[F)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "<set-?>", "activeRange$delegate", "Landroidx/compose/runtime/MutableState;", "getActiveRange", "()LY7/b;", "setActiveRange$material3_release", "(LY7/b;)V", "activeRange", "tickFractions$delegate", "getTickFractions", "()[F", "setTickFractions$material3_release", "([F)V", "tickFractions", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderPositions {
    public static final int $stable = 0;

    /* renamed from: activeRange$delegate, reason: from kotlin metadata */
    private final MutableState activeRange;

    /* renamed from: tickFractions$delegate, reason: from kotlin metadata */
    private final MutableState tickFractions;

    public SliderPositions() {
        this(null, null, 3, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SliderPositions)) {
            return false;
        }
        SliderPositions sliderPositions = (SliderPositions) other;
        return k.b(getActiveRange(), sliderPositions.getActiveRange()) && Arrays.equals(getTickFractions(), sliderPositions.getTickFractions());
    }

    public final Y7.b getActiveRange() {
        return (Y7.b) this.activeRange.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float[] getTickFractions() {
        return (float[]) this.tickFractions.getValue();
    }

    public int hashCode() {
        return Arrays.hashCode(getTickFractions()) + (getActiveRange().hashCode() * 31);
    }

    public final void setActiveRange$material3_release(Y7.b bVar) {
        this.activeRange.setValue(bVar);
    }

    public final void setTickFractions$material3_release(float[] fArr) {
        this.tickFractions.setValue(fArr);
    }

    public SliderPositions(Y7.b bVar, float[] fArr, int i, e eVar) {
        this((i & 1) != 0 ? new Y7.a(0.0f, 1.0f) : bVar, (i & 2) != 0 ? new float[0] : fArr);
    }

    public SliderPositions(Y7.b bVar, float[] fArr) {
        this.activeRange = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bVar, null, 2, null);
        this.tickFractions = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(fArr, null, 2, null);
    }
}
