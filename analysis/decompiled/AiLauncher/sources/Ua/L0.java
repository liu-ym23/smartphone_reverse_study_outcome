package Ua;

import ab.C1279b;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/g;", "parent", "LUa/x;", Const.INTENT_KEY_APIKEY, "(Lkotlinx/coroutines/g;)LUa/x;", "R", "Lkotlin/Function2;", "LUa/M;", "Le9/c;", "", "block", "c", "(Lp9/p;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class L0 {
    public static final InterfaceC1089x a(kotlinx.coroutines.g gVar) {
        return new K0(gVar);
    }

    public static /* synthetic */ InterfaceC1089x b(kotlinx.coroutines.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = null;
        }
        return a(gVar);
    }

    public static final <R> Object c(p9.p<? super M, ? super InterfaceC4014c<? super R>, ? extends Object> pVar, InterfaceC4014c<? super R> interfaceC4014c) {
        J0 j02 = new J0(interfaceC4014c.getContext(), interfaceC4014c);
        Object objE = C1279b.e(j02, j02, pVar);
        if (objE == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objE;
    }
}
