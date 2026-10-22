package kotlinx.coroutines.flow;

import Xa.b;
import Xa.c;
import Xa.n;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import p9.p;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002(\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0004\b\b\u0010\t\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aC\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002(\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "LXa/c;", "Le9/c;", "LY8/t;", "", "block", "LXa/b;", "c", "(Lp9/p;)LXa/b;", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Iterable;)LXa/b;", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)LXa/b;", "LWa/p;", Const.INTENT_KEY_PKGNAME, "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__BuildersKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt$a", "LXa/b;", "LXa/c;", "collector", "LY8/t;", "collect", "(LXa/c;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f36392a;

        public a(Object obj) {
            this.f36392a = obj;
        }

        @Override // Xa.b
        public Object collect(c<? super T> cVar, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objEmit = cVar.emit((Object) this.f36392a, interfaceC4014c);
            return objEmit == C4063a.g() ? objEmit : t.f7040a;
        }
    }

    public static final <T> b<T> a(Iterable<? extends T> iterable) {
        return new FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3(iterable);
    }

    public static final <T> b<T> b(p<? super Wa.p<? super T>, ? super InterfaceC4014c<? super t>, ? extends Object> pVar) {
        return new CallbackFlowBuilder(pVar, null, 0, null, 14, null);
    }

    public static final <T> b<T> c(p<? super c<? super T>, ? super InterfaceC4014c<? super t>, ? extends Object> pVar) {
        return new n(pVar);
    }

    public static final <T> b<T> d(T t10) {
        return new a(t10);
    }
}
