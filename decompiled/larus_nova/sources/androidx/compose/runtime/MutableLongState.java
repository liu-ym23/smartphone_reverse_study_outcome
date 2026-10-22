package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/MutableLongState;", "Landroidx/compose/runtime/LongState;", "Landroidx/compose/runtime/MutableState;", "", "value", "getValue", "()Ljava/lang/Long;", "setValue", "(J)V", "longValue", "getLongValue", "()J", "setLongValue", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MutableLongState extends LongState, MutableState<Long> {

    /* JADX INFO: renamed from: androidx.compose.runtime.MutableLongState$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Long $default$getValue(MutableLongState r100) {
            return Long.valueOf(r100.getLongValue());
        }

        public static /* synthetic */ long access$getValue$jd(MutableLongState r100) {
            return $default$getValue(r100).longValue();
        }

        /* JADX INFO: renamed from: $default$getValue, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ Object m4122$default$getValue(MutableLongState r100) {
            return r100.getValue();
        }

        public static /* bridge */ /* synthetic */ void $default$setValue(MutableLongState r100, Object r101) {
            r100.setValue(((Number) r101).longValue());
        }

        public static /* synthetic */ void access$setValue$jd(MutableLongState r100, long r101) {
            $default$setValue(r100, r101);
        }

        public static void $default$setValue(MutableLongState r100, long r101) {
            r100.setLongValue(r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Long getValue(MutableLongState r100) {
            return Long.valueOf(CC.access$getValue$jd(r100));
        }

        public static void setValue(MutableLongState r100, long r101) {
            CC.access$setValue$jd(r100, r101);
        }
    }

    @Override // androidx.compose.runtime.LongState
    long getLongValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.LongState, androidx.compose.runtime.State
    Long getValue();

    @Override // androidx.compose.runtime.LongState, androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Long getValue();

    void setLongValue(long r100);

    void setValue(long r100);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ void setValue(Long r100);
}
