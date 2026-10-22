package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a+\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0007¨\u0006\b"}, d2 = {"getPolymorphicElement", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusPolymorphicKey", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CoroutineContextImplKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends CoroutineContext.Element> E getPolymorphicElement(CoroutineContext.Element r2, CoroutineContext.Key<E> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "key");
        if ((r3 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r4 = (AbstractCoroutineContextKey) r3;
        if (r4.isSubKey$kotlin_stdlib(r2.getKey()) == false) goto L15;
        E r5 = (E) r4.tryCast$kotlin_stdlib(r2);
        if ((r5 instanceof CoroutineContext.Element) == true) goto L9;
        return null;
    L9:
        return r5;
    L15:
        return null;
    L11:
        if (r2.getKey() != r3) goto L14;
        return r2;
    L14:
        return null;
    }

    public static final CoroutineContext minusPolymorphicKey(CoroutineContext.Element r1, CoroutineContext.Key<?> r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "key");
        if ((r2 instanceof AbstractCoroutineContextKey) == false) goto L11;
        AbstractCoroutineContextKey r3 = (AbstractCoroutineContextKey) r2;
        boolean r0 = r3.isSubKey$kotlin_stdlib(r1.getKey());
        CoroutineContext r4 = r1;
        if (r0 == false) goto L10;
        CoroutineContext.Element r5 = r3.tryCast$kotlin_stdlib(r1);
        r4 = r1;
        if (r5 == null) goto L10;
        r4 = EmptyCoroutineContext.INSTANCE;
    L10:
        return r4;
    L11:
        CoroutineContext.Key<?> r6 = r1.getKey();
        CoroutineContext r7 = r1;
        if (r6 != r2) goto L15;
        r7 = EmptyCoroutineContext.INSTANCE;
    L15:
        return r7;
    }
}
