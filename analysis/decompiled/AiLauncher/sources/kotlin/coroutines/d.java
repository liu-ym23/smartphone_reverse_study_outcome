package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001:\u0002\u0013\u0014J*\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H¦\u0002¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\nH&¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lkotlin/coroutines/d;", "", "Lkotlin/coroutines/d$b;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/d$c;", "key", "get", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lp9/p;)Ljava/lang/Object;", "context", "plus", "(Lkotlin/coroutines/d;)Lkotlin/coroutines/d;", "minusKey", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d;", "c", Const.INTENT_KEY_PKGNAME, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface d {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static d b(d dVar, d context) {
            p.i(context, "context");
            return context == EmptyCoroutineContext.f34779a ? dVar : (d) context.fold(dVar, new p9.p() { // from class: e9.e
                @Override // p9.p
                public final Object invoke(Object obj, Object obj2) {
                    return d.a.c((kotlin.coroutines.d) obj, (d.b) obj2);
                }
            });
        }

        public static d c(d acc, b element) {
            p.i(acc, "acc");
            p.i(element, "element");
            d dVarMinusKey = acc.minusKey(element.getKey());
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f34779a;
            if (dVarMinusKey == emptyCoroutineContext) {
                return element;
            }
            c.Companion bVar = kotlin.coroutines.c.INSTANCE;
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) dVarMinusKey.get(bVar);
            if (cVar == null) {
                return new CombinedContext(dVarMinusKey, element);
            }
            d dVarMinusKey2 = dVarMinusKey.minusKey(bVar);
            return dVarMinusKey2 == emptyCoroutineContext ? new CombinedContext(element, cVar) : new CombinedContext(new CombinedContext(dVarMinusKey2, element), cVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J*\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/coroutines/d$b;", "Lkotlin/coroutines/d;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/d$c;", "key", "get", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d$b;", "getKey", "()Lkotlin/coroutines/d$c;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b extends d {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class a {
            public static <R> R a(b bVar, R r10, p9.p<? super R, ? super b, ? extends R> operation) {
                p.i(operation, "operation");
                return operation.invoke(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> key) {
                p.i(key, "key");
                if (!p.d(bVar.getKey(), key)) {
                    return null;
                }
                p.g(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static d c(b bVar, c<?> key) {
                p.i(key, "key");
                return p.d(bVar.getKey(), key) ? EmptyCoroutineContext.f34779a : bVar;
            }

            public static d d(b bVar, d context) {
                p.i(context, "context");
                return a.b(bVar, context);
            }
        }

        @Override // kotlin.coroutines.d
        <E extends b> E get(c<E> key);

        c<?> getKey();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/d$c;", "Lkotlin/coroutines/d$b;", ExifInterface.LONGITUDE_EAST, "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface c<E extends b> {
    }

    <R> R fold(R initial, p9.p<? super R, ? super b, ? extends R> operation);

    <E extends b> E get(c<E> key);

    d minusKey(c<?> key);

    d plus(d context);
}
