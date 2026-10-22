package androidx.compose.runtime;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/a;", "", "", UxipConstants.f30680s, "getValue", "()Ljava/lang/Double;", "setValue", "(D)V", "getDoubleValue", "()D", "setDoubleValue", "doubleValue", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface a {
    double getDoubleValue();

    void setDoubleValue(double d10);

    /* bridge */ /* synthetic */ default void setValue(Object obj) {
        setValue(((Number) obj).doubleValue());
    }

    @Override // 
    /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
    default Double mo1getValue() {
        return Double.valueOf(getDoubleValue());
    }

    default void setValue(double d10) {
        setDoubleValue(d10);
    }
}
