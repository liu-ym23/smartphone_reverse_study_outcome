package androidx.compose.ui.semantics;

import S7.a;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/semantics/ScrollAxisRange;", "", "Lkotlin/Function0;", "", "value", "maxValue", "", "reverseScrolling", AppAgent.CONSTRUCT, "(LS7/a;LS7/a;Z)V", "", "toString", "()Ljava/lang/String;", "LS7/a;", "getValue", "()LS7/a;", "getMaxValue", "Z", "getReverseScrolling", "()Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollAxisRange {
    public static final int $stable = 0;
    private final a maxValue;
    private final boolean reverseScrolling;
    private final a value;

    public ScrollAxisRange(a aVar, a aVar2, boolean z10) {
        this.value = aVar;
        this.maxValue = aVar2;
        this.reverseScrolling = z10;
    }

    public final a getMaxValue() {
        return this.maxValue;
    }

    public final boolean getReverseScrolling() {
        return this.reverseScrolling;
    }

    public final a getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ScrollAxisRange(value=");
        sb.append(((Number) this.value.invoke()).floatValue());
        sb.append(", maxValue=");
        sb.append(((Number) this.maxValue.invoke()).floatValue());
        sb.append(", reverseScrolling=");
        return androidx.appfunctions.metadata.a.r(sb, this.reverseScrolling, ')');
    }

    public /* synthetic */ ScrollAxisRange(a aVar, a aVar2, boolean z10, int i, e eVar) {
        this(aVar, aVar2, (i & 4) != 0 ? false : z10);
    }
}
