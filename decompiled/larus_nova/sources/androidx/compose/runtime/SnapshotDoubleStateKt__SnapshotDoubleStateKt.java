package androidx.compose.runtime;

import com.facebook.keyframes.model.KFAnimation;
import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n¨\u0006\f"}, d2 = {"mutableDoubleStateOf", "Landroidx/compose/runtime/MutableDoubleState;", "value", "", "getValue", "Landroidx/compose/runtime/DoubleState;", "thisObj", "", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lkotlin/reflect/KProperty;", "setValue", "", "runtime"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotDoubleStateKt")
final /* synthetic */ class SnapshotDoubleStateKt__SnapshotDoubleStateKt {
    public static final MutableDoubleState mutableDoubleStateOf(double r100) {
        return SnapshotDoubleState_androidKt.createSnapshotMutableDoubleState(r100);
    }

    public static final double getValue(DoubleState r100, Object r101, KProperty<?> r102) {
        return r100.getDoubleValue();
    }

    public static final void setValue(MutableDoubleState r100, Object r101, KProperty<?> r102, double r103) {
        r100.setDoubleValue(r103);
    }
}
