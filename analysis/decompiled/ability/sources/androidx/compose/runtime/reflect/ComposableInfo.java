package androidx.compose.runtime.reflect;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/reflect/ComposableInfo;", "", "isComposable", "", "realParamsCount", "", "changedParams", "defaultParams", AppAgent.CONSTRUCT, "(ZIII)V", "()Z", "getRealParamsCount", "()I", "getChangedParams", "getDefaultParams", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ComposableInfo {
    public static final int $stable = 0;
    private final int changedParams;
    private final int defaultParams;
    private final boolean isComposable;
    private final int realParamsCount;

    public ComposableInfo(boolean z10, int i, int i6, int i10) {
        this.isComposable = z10;
        this.realParamsCount = i;
        this.changedParams = i6;
        this.defaultParams = i10;
    }

    public static /* synthetic */ ComposableInfo copy$default(ComposableInfo composableInfo, boolean z10, int i, int i6, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = composableInfo.isComposable;
        }
        if ((i11 & 2) != 0) {
            i = composableInfo.realParamsCount;
        }
        if ((i11 & 4) != 0) {
            i6 = composableInfo.changedParams;
        }
        if ((i11 & 8) != 0) {
            i10 = composableInfo.defaultParams;
        }
        return composableInfo.copy(z10, i, i6, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsComposable() {
        return this.isComposable;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRealParamsCount() {
        return this.realParamsCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getChangedParams() {
        return this.changedParams;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDefaultParams() {
        return this.defaultParams;
    }

    public final ComposableInfo copy(boolean isComposable, int realParamsCount, int changedParams, int defaultParams) {
        return new ComposableInfo(isComposable, realParamsCount, changedParams, defaultParams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComposableInfo)) {
            return false;
        }
        ComposableInfo composableInfo = (ComposableInfo) other;
        return this.isComposable == composableInfo.isComposable && this.realParamsCount == composableInfo.realParamsCount && this.changedParams == composableInfo.changedParams && this.defaultParams == composableInfo.defaultParams;
    }

    public final int getChangedParams() {
        return this.changedParams;
    }

    public final int getDefaultParams() {
        return this.defaultParams;
    }

    public final int getRealParamsCount() {
        return this.realParamsCount;
    }

    public int hashCode() {
        return Integer.hashCode(this.defaultParams) + a.a(this.changedParams, a.a(this.realParamsCount, Boolean.hashCode(this.isComposable) * 31, 31), 31);
    }

    public final boolean isComposable() {
        return this.isComposable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ComposableInfo(isComposable=");
        sb.append(this.isComposable);
        sb.append(", realParamsCount=");
        sb.append(this.realParamsCount);
        sb.append(", changedParams=");
        sb.append(this.changedParams);
        sb.append(", defaultParams=");
        return B7.a.o(sb, this.defaultParams, ')');
    }
}
