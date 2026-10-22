package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "Key", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SnapshotContextElement extends CoroutineContext.Element {
    public static final Key Key = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <E extends CoroutineContext.Element> E get(SnapshotContextElement r100, CoroutineContext.Key<E> r101) {
            return (E) CoroutineContext.Element.DefaultImpls.get(r100, r101);
        }

        public static CoroutineContext minusKey(SnapshotContextElement r100, CoroutineContext.Key<?> r101) {
            return CoroutineContext.Element.DefaultImpls.minusKey(r100, r101);
        }

        public static CoroutineContext plus(SnapshotContextElement r100, CoroutineContext r101) {
            return CoroutineContext.Element.DefaultImpls.plus(r100, r101);
        }

        public static <R> R fold(SnapshotContextElement r100, R r101, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r102) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElement$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "<init>", "()V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<SnapshotContextElement> {
        static final /* synthetic */ Key $$INSTANCE = null;

        static {
            $$INSTANCE = new Key();
        }

        private Key() {
        }
    }

    static {
        Key = Key.$$INSTANCE;
    }
}
