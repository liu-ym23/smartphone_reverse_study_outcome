package Xa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.flow.DistinctFlowImpl;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\b\u001aY\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\u001c\u0010\u0006\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\f\u0010\r\"$\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"*\u0010\u0013\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LXa/b;", "e", "(LXa/b;)LXa/b;", "Lkotlin/Function2;", "", "areEquivalent", "f", "(LXa/b;Lp9/p;)LXa/b;", "Lkotlin/Function1;", "", "keySelector", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LXa/b;Lp9/l;Lp9/p;)LXa/b;", Const.INTENT_KEY_APIKEY, "Lp9/l;", "defaultKeySelector", Const.INTENT_KEY_PKGNAME, "Lp9/p;", "defaultAreEquivalent", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class i {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC5074l<Object, Object> f6895a = new InterfaceC5074l() { // from class: Xa.g
        @Override // p9.InterfaceC5074l
        public final Object invoke(Object obj) {
            return i.d(obj);
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final p9.p<Object, Object, Boolean> f6896b = new p9.p() { // from class: Xa.h
        @Override // p9.p
        public final Object invoke(Object obj, Object obj2) {
            return Boolean.valueOf(i.c(obj, obj2));
        }
    };

    public static final boolean c(Object obj, Object obj2) {
        return kotlin.jvm.internal.p.d(obj, obj2);
    }

    public static final Object d(Object obj) {
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> e(b<? extends T> bVar) {
        return bVar instanceof t ? bVar : g(bVar, f6895a, f6896b);
    }

    public static final <T> b<T> f(b<? extends T> bVar, p9.p<? super T, ? super T, Boolean> pVar) {
        InterfaceC5074l<Object, Object> interfaceC5074l = f6895a;
        kotlin.jvm.internal.p.g(pVar, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return g(bVar, interfaceC5074l, (p9.p) z.g(pVar, 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> g(b<? extends T> bVar, InterfaceC5074l<? super T, ? extends Object> interfaceC5074l, p9.p<Object, Object, Boolean> pVar) {
        if (bVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) bVar;
            if (distinctFlowImpl.keySelector == interfaceC5074l && distinctFlowImpl.areEquivalent == pVar) {
                return bVar;
            }
        }
        return new DistinctFlowImpl(bVar, interfaceC5074l, pVar);
    }
}
