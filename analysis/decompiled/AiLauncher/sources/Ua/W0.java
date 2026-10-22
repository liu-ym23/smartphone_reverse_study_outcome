package Ua;

import Za.C1188h;
import Za.C1189i;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"LY8/t;", Const.INTENT_KEY_APIKEY, "(Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class W0 {
    public static final Object a(InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        Object objG;
        kotlin.coroutines.d context = interfaceC4014c.getContext();
        C1086v0.m(context);
        InterfaceC4014c interfaceC4014cD = IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c);
        C1188h c1188h = interfaceC4014cD instanceof C1188h ? (C1188h) interfaceC4014cD : null;
        if (c1188h == null) {
            objG = Y8.t.f7040a;
        } else {
            if (C1189i.d(c1188h.dispatcher, context)) {
                c1188h.o(context, Y8.t.f7040a);
            } else {
                V0 v02 = new V0();
                kotlin.coroutines.d dVarPlus = context.plus(v02);
                Y8.t tVar = Y8.t.f7040a;
                c1188h.o(dVarPlus, tVar);
                objG = (!v02.dispatcherWasUnconfined || C1189i.e(c1188h)) ? C4063a.g() : tVar;
            }
            objG = C4063a.g();
        }
        if (objG == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objG == C4063a.g() ? objG : Y8.t.f7040a;
    }
}
