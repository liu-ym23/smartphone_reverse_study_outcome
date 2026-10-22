package Ua;

import ab.C1278a;
import ab.C1279b;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aI\u0010\u000b\u001a\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\u000b\u0010\f\u001aU\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\r*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\u000f\u0010\u0010\u001aO\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"LUa/M;", "Lkotlin/coroutines/d;", "context", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Le9/c;", "LY8/t;", "", "block", "Lkotlinx/coroutines/g;", "c", "(LUa/M;Lkotlin/coroutines/d;Lkotlinx/coroutines/CoroutineStart;Lp9/p;)Lkotlinx/coroutines/g;", ExifInterface.GPS_DIRECTION_TRUE, "LUa/Q;", Const.INTENT_KEY_APIKEY, "(LUa/M;Lkotlin/coroutines/d;Lkotlinx/coroutines/CoroutineStart;Lp9/p;)LUa/Q;", "e", "(Lkotlin/coroutines/d;Lp9/p;Le9/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
/* renamed from: Ua.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C1060i {
    public static final <T> Q<T> a(M m10, kotlin.coroutines.d dVar, CoroutineStart coroutineStart, p9.p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar) {
        kotlin.coroutines.d dVarJ = G.j(m10, dVar);
        S y0Var = coroutineStart.isLazy() ? new y0(dVarJ, pVar) : new S(dVarJ, true);
        ((kotlinx.coroutines.a) y0Var).X0(coroutineStart, y0Var, pVar);
        return (Q<T>) y0Var;
    }

    public static /* synthetic */ Q b(M m10, kotlin.coroutines.d dVar, CoroutineStart coroutineStart, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C1056g.a(m10, dVar, coroutineStart, pVar);
    }

    public static final kotlinx.coroutines.g c(M m10, kotlin.coroutines.d dVar, CoroutineStart coroutineStart, p9.p<? super M, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        kotlin.coroutines.d dVarJ = G.j(m10, dVar);
        kotlinx.coroutines.a z0Var = coroutineStart.isLazy() ? new z0(dVarJ, pVar) : new I0(dVarJ, true);
        z0Var.X0(coroutineStart, z0Var, pVar);
        return z0Var;
    }

    public static /* synthetic */ kotlinx.coroutines.g d(M m10, kotlin.coroutines.d dVar, CoroutineStart coroutineStart, p9.p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        if ((i10 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return C1056g.c(m10, dVar, coroutineStart, pVar);
    }

    public static final <T> Object e(kotlin.coroutines.d dVar, p9.p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, InterfaceC4014c<? super T> interfaceC4014c) {
        Object objC1;
        kotlin.coroutines.d context = interfaceC4014c.getContext();
        kotlin.coroutines.d dVarK = G.k(context, dVar);
        C1086v0.m(dVarK);
        if (dVarK == context) {
            Za.y yVar = new Za.y(dVarK, interfaceC4014c);
            objC1 = C1279b.e(yVar, yVar, pVar);
        } else {
            c.Companion bVar = kotlin.coroutines.c.INSTANCE;
            if (kotlin.jvm.internal.p.d(dVarK.get(bVar), context.get(bVar))) {
                S0 s02 = new S0(dVarK, interfaceC4014c);
                kotlin.coroutines.d context2 = s02.getContext();
                Object objI = Za.J.i(context2, null);
                try {
                    Object objE = C1279b.e(s02, s02, pVar);
                    Za.J.f(context2, objI);
                    objC1 = objE;
                } catch (Throwable th) {
                    Za.J.f(context2, objI);
                    throw th;
                }
            } else {
                kotlinx.coroutines.e eVar = new kotlinx.coroutines.e(dVarK, interfaceC4014c);
                C1278a.d(pVar, eVar, eVar);
                objC1 = eVar.c1();
            }
        }
        if (objC1 == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC1;
    }
}
