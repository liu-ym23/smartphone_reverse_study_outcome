package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ2\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H¦@¢\u0006\u0002\u0010\bR\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "Lkotlin/coroutines/CoroutineContext$Element;", "onInfiniteOperation", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InfiniteAnimationPolicy extends CoroutineContext.Element {
    public static final Key Key = null;

    /* JADX INFO: renamed from: androidx.compose.ui.platform.InfiniteAnimationPolicy$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            Key r100 = InfiniteAnimationPolicy.Key;
        }

        public static CoroutineContext.Key $default$getKey(InfiniteAnimationPolicy r100) {
            return InfiniteAnimationPolicy.Key;
        }

        public static /* synthetic */ CoroutineContext.Key access$getKey$jd(InfiniteAnimationPolicy r100) {
            return $default$getKey(r100);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static CoroutineContext.Key<?> getKey(InfiniteAnimationPolicy r100) {
            return CC.access$getKey$jd(r100);
        }

        public static <E extends CoroutineContext.Element> E get(InfiniteAnimationPolicy r100, CoroutineContext.Key<E> r101) {
            return (E) CoroutineContext.Element.DefaultImpls.get(r100, r101);
        }

        public static CoroutineContext minusKey(InfiniteAnimationPolicy r100, CoroutineContext.Key<?> r101) {
            return CoroutineContext.Element.DefaultImpls.minusKey(r100, r101);
        }

        public static CoroutineContext plus(InfiniteAnimationPolicy r100, CoroutineContext r101) {
            return CoroutineContext.Element.DefaultImpls.plus(r100, r101);
        }

        public static <R> R fold(InfiniteAnimationPolicy r100, R r101, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r102) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/platform/InfiniteAnimationPolicy$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Landroidx/compose/ui/platform/InfiniteAnimationPolicy;", "<init>", "()V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<InfiniteAnimationPolicy> {
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

    <R> Object onInfiniteOperation(Function1<? super Continuation<? super R>, ? extends Object> r100, Continuation<? super R> r101);
}
