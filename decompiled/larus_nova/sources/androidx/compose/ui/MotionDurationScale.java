package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/MotionDurationScale;", "Lkotlin/coroutines/CoroutineContext$Element;", "scaleFactor", "", "getScaleFactor", "()F", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MotionDurationScale extends CoroutineContext.Element {
    public static final Key Key = null;

    /* JADX INFO: renamed from: androidx.compose.ui.MotionDurationScale$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static CoroutineContext.Key $default$getKey(MotionDurationScale r100) {
            return MotionDurationScale.Key;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <E extends CoroutineContext.Element> E get(MotionDurationScale r100, CoroutineContext.Key<E> r101) {
            return (E) CoroutineContext.Element.DefaultImpls.get(r100, r101);
        }

        public static CoroutineContext minusKey(MotionDurationScale r100, CoroutineContext.Key<?> r101) {
            return CoroutineContext.Element.DefaultImpls.minusKey(r100, r101);
        }

        public static CoroutineContext plus(MotionDurationScale r100, CoroutineContext r101) {
            return CoroutineContext.Element.DefaultImpls.plus(r100, r101);
        }

        public static <R> R fold(MotionDurationScale r100, R r101, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r102) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/MotionDurationScale$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/MotionDurationScale;", "<init>", "()V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<MotionDurationScale> {
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

    @Override // kotlin.coroutines.CoroutineContext.Element
    CoroutineContext.Key<?> getKey();

    float getScaleFactor();
}
