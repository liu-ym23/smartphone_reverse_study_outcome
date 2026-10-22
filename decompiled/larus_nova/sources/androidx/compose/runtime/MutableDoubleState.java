package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/MutableDoubleState;", "Landroidx/compose/runtime/DoubleState;", "Landroidx/compose/runtime/MutableState;", "", "value", "getValue", "()Ljava/lang/Double;", "setValue", "(D)V", "doubleValue", "getDoubleValue", "()D", "setDoubleValue", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MutableDoubleState extends DoubleState, MutableState<Double> {

    /* JADX INFO: renamed from: androidx.compose.runtime.MutableDoubleState$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Double $default$getValue(MutableDoubleState r100) {
            return Double.valueOf(r100.getDoubleValue());
        }

        public static /* synthetic */ double access$getValue$jd(MutableDoubleState r100) {
            return $default$getValue(r100).doubleValue();
        }

        /* JADX INFO: renamed from: $default$getValue, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ Object m4119$default$getValue(MutableDoubleState r100) {
            return r100.getValue();
        }

        public static /* bridge */ /* synthetic */ void $default$setValue(MutableDoubleState r100, Object r101) {
            r100.setValue(((Number) r101).doubleValue());
        }

        public static /* synthetic */ void access$setValue$jd(MutableDoubleState r100, double r101) {
            $default$setValue(r100, r101);
        }

        public static void $default$setValue(MutableDoubleState r100, double r101) {
            r100.setDoubleValue(r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Double getValue(MutableDoubleState r100) {
            return Double.valueOf(CC.access$getValue$jd(r100));
        }

        public static void setValue(MutableDoubleState r100, double r101) {
            CC.access$setValue$jd(r100, r101);
        }
    }

    @Override // androidx.compose.runtime.DoubleState
    double getDoubleValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.DoubleState, androidx.compose.runtime.State
    Double getValue();

    @Override // androidx.compose.runtime.DoubleState, androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Double getValue();

    void setDoubleValue(double r100);

    void setValue(double r100);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ void setValue(Double r100);
}
