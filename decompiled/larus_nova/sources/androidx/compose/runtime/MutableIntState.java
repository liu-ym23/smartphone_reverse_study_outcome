package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/MutableState;", "", "value", "getValue", "()Ljava/lang/Integer;", "setValue", "(I)V", "intValue", "getIntValue", "()I", "setIntValue", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MutableIntState extends IntState, MutableState<Integer> {

    /* JADX INFO: renamed from: androidx.compose.runtime.MutableIntState$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Integer $default$getValue(MutableIntState r100) {
            return Integer.valueOf(r100.getIntValue());
        }

        public static /* synthetic */ int access$getValue$jd(MutableIntState r100) {
            return $default$getValue(r100).intValue();
        }

        /* JADX INFO: renamed from: $default$getValue, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ Object m4121$default$getValue(MutableIntState r100) {
            return r100.getValue();
        }

        public static /* bridge */ /* synthetic */ void $default$setValue(MutableIntState r100, Object r101) {
            r100.setValue(((Number) r101).intValue());
        }

        public static /* synthetic */ void access$setValue$jd(MutableIntState r100, int r101) {
            $default$setValue(r100, r101);
        }

        public static void $default$setValue(MutableIntState r100, int r101) {
            r100.setIntValue(r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Integer getValue(MutableIntState r100) {
            return Integer.valueOf(CC.access$getValue$jd(r100));
        }

        public static void setValue(MutableIntState r100, int r101) {
            CC.access$setValue$jd(r100, r101);
        }
    }

    @Override // androidx.compose.runtime.IntState
    int getIntValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.IntState, androidx.compose.runtime.State
    Integer getValue();

    @Override // androidx.compose.runtime.IntState, androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Integer getValue();

    void setIntValue(int r100);

    void setValue(int r100);

    @Override // androidx.compose.runtime.MutableState
    /* bridge */ /* synthetic */ void setValue(Integer r100);
}
