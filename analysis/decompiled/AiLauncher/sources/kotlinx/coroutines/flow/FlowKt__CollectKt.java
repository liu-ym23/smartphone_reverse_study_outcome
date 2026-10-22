package kotlinx.coroutines.flow;

import Ua.C1060i;
import Ua.M;
import Xa.b;
import Xa.c;
import Xa.d;
import Xa.e;
import Y8.t;
import Ya.j;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlinx.coroutines.g;
import p9.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001aD\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000f\u001a.\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LXa/b;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(LXa/b;Le9/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/M;", "scope", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_UMID, "(LXa/b;LUa/M;)Lkotlinx/coroutines/g;", "Lkotlin/Function2;", "Le9/c;", "", "action", Const.INTENT_KEY_PKGNAME, "(LXa/b;Lp9/p;Le9/c;)Ljava/lang/Object;", "LXa/c;", "flow", "c", "(LXa/c;LXa/b;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(b<?> bVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objCollect = bVar.collect(j.f7050a, interfaceC4014c);
        return objCollect == C4063a.g() ? objCollect : t.f7040a;
    }

    public static final <T> Object b(b<? extends T> bVar, p<? super T, ? super InterfaceC4014c<? super t>, ? extends Object> pVar, InterfaceC4014c<? super t> interfaceC4014c) {
        Object objI = d.i(e.b(d.G(bVar, pVar), 0, null, 2, null), interfaceC4014c);
        return objI == C4063a.g() ? objI : t.f7040a;
    }

    public static final <T> Object c(c<? super T> cVar, b<? extends T> bVar, InterfaceC4014c<? super t> interfaceC4014c) {
        d.w(cVar);
        Object objCollect = bVar.collect(cVar, interfaceC4014c);
        return objCollect == C4063a.g() ? objCollect : t.f7040a;
    }

    public static final <T> g d(b<? extends T> bVar, M m10) {
        return C1060i.d(m10, null, null, new FlowKt__CollectKt$launchIn$1(bVar, null), 3, null);
    }
}
