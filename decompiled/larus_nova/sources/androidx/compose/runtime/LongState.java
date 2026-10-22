package androidx.compose.runtime;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/LongState;", "Landroidx/compose/runtime/State;", "", "value", "getValue", "()Ljava/lang/Long;", "longValue", "getLongValue", "()J", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LongState extends State<Long> {

    /* JADX INFO: renamed from: androidx.compose.runtime.LongState$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Long $default$getValue(LongState r100) {
            return Long.valueOf(r100.getLongValue());
        }

        public static /* synthetic */ long access$getValue$jd(LongState r100) {
            return $default$getValue(r100).longValue();
        }

        /* JADX INFO: renamed from: $default$getValue, reason: collision with other method in class */
        public static /* bridge */ /* synthetic */ Object m4118$default$getValue(LongState r100) {
            return r100.getValue();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Long getValue(LongState r100) {
            return Long.valueOf(CC.access$getValue$jd(r100));
        }
    }

    long getLongValue();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.runtime.State
    Long getValue();

    @Override // androidx.compose.runtime.State
    /* bridge */ /* synthetic */ Long getValue();
}
