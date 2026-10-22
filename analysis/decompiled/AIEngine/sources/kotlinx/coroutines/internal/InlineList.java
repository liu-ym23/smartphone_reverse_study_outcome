package kotlinx.coroutines.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InlineList<E> {
    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static /* synthetic */ Object m171constructorimpl$default(Object obj, int i10, e eVar) {
        if ((i10 & 1) != 0) {
            obj = null;
        }
        return m170constructorimpl(obj);
    }

    /* renamed from: plus-FjFbRPM, reason: not valid java name */
    public static final Object m172plusFjFbRPM(Object obj, E e10) {
        if (obj == null) {
            return m170constructorimpl(e10);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e10);
            return m170constructorimpl(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e10);
        return m170constructorimpl(arrayList);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <E> Object m170constructorimpl(Object obj) {
        return obj;
    }
}
