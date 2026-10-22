package kotlinx.coroutines.flow.internal;

import Ua.M;
import Xa.b;
import Xa.c;
import Y8.t;
import Ya.f;
import ab.C1279b;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import p9.p;
import p9.q;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a:\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0080@¢\u0006\u0004\b\u0006\u0010\u0007\u001aK\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002.\u0010\u0005\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"R", "Lkotlin/Function2;", "LUa/M;", "Le9/c;", "", "block", Const.INTENT_KEY_APIKEY, "(Lp9/p;Le9/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "LXa/c;", "LY8/t;", "LXa/b;", Const.INTENT_KEY_PKGNAME, "(Lp9/q;)LXa/b;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowCoroutineKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/FlowCoroutineKt$a", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<R> implements b<R> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f36751a;

        public a(q qVar) {
            this.f36751a = qVar;
        }

        @Override // Xa.b
        public Object collect(c<? super R> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objA = FlowCoroutineKt.a(new FlowCoroutineKt$scopedFlow$1$1(this.f36751a, cVar, null), interfaceC4014c);
            return objA == C4063a.g() ? objA : t.f7040a;
        }
    }

    public static final <R> Object a(p<? super M, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        f fVar = new f(interfaceC4014c.getContext(), interfaceC4014c);
        Object objE = C1279b.e(fVar, fVar, pVar);
        if (objE == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objE;
    }

    public static final <R> b<R> b(q<? super M, ? super c<? super R>, ? super InterfaceC4014c<? super t>, ? extends Object> qVar) {
        return new a(qVar);
    }
}
