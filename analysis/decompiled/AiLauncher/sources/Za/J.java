package Za;

import Ua.M0;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.d;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\u000f\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e\"*\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"2\u0010\u0017\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00150\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013\"&\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013¨\u0006\u001b"}, d2 = {"Lkotlin/coroutines/d;", "context", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lkotlin/coroutines/d;)Ljava/lang/Object;", "countOrElement", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lkotlin/coroutines/d;Ljava/lang/Object;)Ljava/lang/Object;", "oldState", "LY8/t;", "f", "(Lkotlin/coroutines/d;Ljava/lang/Object;)V", "LZa/C;", Const.INTENT_KEY_APIKEY, "LZa/C;", "NO_THREAD_ELEMENTS", "Lkotlin/Function2;", "Lkotlin/coroutines/d$b;", Const.INTENT_KEY_PKGNAME, "Lp9/p;", "countAll", "LUa/M0;", "c", "findOne", "LZa/P;", Const.INTENT_KEY_UMID, "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name */
    public static final C f7710a = new C("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    public static final p9.p<Object, d.b, Object> f7711b = new p9.p() { // from class: Za.G
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return J.d(obj, (d.b) obj2);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    public static final p9.p<M0<?>, d.b, M0<?>> f7712c = new p9.p() { // from class: Za.H
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return J.e((M0) obj, (d.b) obj2);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public static final p9.p<P, d.b, P> f7713d = new p9.p() { // from class: Za.I
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return J.h((P) obj, (d.b) obj2);
        }
    };

    public static final Object d(Object obj, d.b bVar) {
        if (!(bVar instanceof M0)) {
            return obj;
        }
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        int iIntValue = num != null ? num.intValue() : 1;
        return iIntValue == 0 ? bVar : Integer.valueOf(iIntValue + 1);
    }

    public static final M0<?> e(M0<?> m02, d.b bVar) {
        if (m02 != null) {
            return m02;
        }
        if (bVar instanceof M0) {
            return (M0) bVar;
        }
        return null;
    }

    public static final void f(kotlin.coroutines.d dVar, Object obj) {
        if (obj == f7710a) {
            return;
        }
        if (obj instanceof P) {
            ((P) obj).b(dVar);
            return;
        }
        Object objFold = dVar.fold(null, f7712c);
        kotlin.jvm.internal.p.g(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((M0) objFold).e0(dVar, obj);
    }

    public static final Object g(kotlin.coroutines.d dVar) {
        Object objFold = dVar.fold(0, f7711b);
        kotlin.jvm.internal.p.f(objFold);
        return objFold;
    }

    public static final P h(P p10, d.b bVar) {
        if (bVar instanceof M0) {
            M0<?> m02 = (M0) bVar;
            p10.a(m02, m02.f1(p10.context));
        }
        return p10;
    }

    public static final Object i(kotlin.coroutines.d dVar, Object obj) {
        if (obj == null) {
            obj = g(dVar);
        }
        if (obj == 0) {
            return f7710a;
        }
        if (obj instanceof Integer) {
            return dVar.fold(new P(dVar, ((Number) obj).intValue()), f7713d);
        }
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((M0) obj).f1(dVar);
    }
}
