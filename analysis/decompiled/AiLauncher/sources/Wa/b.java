package Wa;

import Ua.G;
import Ua.M;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0087\u0001\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001e\b\u0002\u0010\f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\u0004\u0018\u0001`\u000b2(\u0010\u0011\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {ExifInterface.LONGITUDE_EAST, "LUa/M;", "Lkotlin/coroutines/d;", "context", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function1;", "", "LY8/t;", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "LWa/c;", "Le9/c;", "", "block", "LWa/s;", Const.INTENT_KEY_APIKEY, "(LUa/M;Lkotlin/coroutines/d;ILkotlinx/coroutines/CoroutineStart;Lp9/l;Lp9/p;)LWa/s;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b {
    public static final <E> s<E> a(M m10, kotlin.coroutines.d dVar, int i10, CoroutineStart coroutineStart, InterfaceC5074l<? super Throwable, Y8.t> interfaceC5074l, p9.p<? super c<E>, ? super InterfaceC4014c<? super Y8.t>, ? extends Object> pVar) {
        kotlin.coroutines.d dVarJ = G.j(m10, dVar);
        g gVarB = j.b(i10, null, null, 6, null);
        a nVar = coroutineStart.isLazy() ? new n(dVarJ, gVarB, pVar) : new a(dVarJ, gVarB, true);
        if (interfaceC5074l != null) {
            ((JobSupport) nVar).J(interfaceC5074l);
        }
        ((kotlinx.coroutines.a) nVar).X0(coroutineStart, nVar, pVar);
        return (s<E>) nVar;
    }

    public static /* synthetic */ s b(M m10, kotlin.coroutines.d dVar, int i10, CoroutineStart coroutineStart, InterfaceC5074l interfaceC5074l, p9.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        if ((i11 & 8) != 0) {
            interfaceC5074l = null;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        return a(m10, dVar, i10, coroutineStart2, interfaceC5074l, pVar);
    }
}
