package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aC\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0007¢\u0006\u0004\b\b\u0010\t\u001aK\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\"\u0010\u0007\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003H\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/d;", "context", "Lkotlin/Function2;", "LUa/M;", "Le9/c;", "", "block", Const.INTENT_KEY_APIKEY, "(Lkotlin/coroutines/d;Lp9/p;)Ljava/lang/Object;", "newContext", "LUa/e0;", "eventLoop", "c", "(Lkotlin/coroutines/d;LUa/e0;Lp9/p;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
/* renamed from: Ua.h, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final /* synthetic */ class C1058h {
    public static final <T> T a(kotlin.coroutines.d dVar, p9.p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar) throws InterruptedException {
        return (T) C1056g.h(dVar, pVar);
    }

    public static /* synthetic */ Object b(kotlin.coroutines.d dVar, p9.p pVar, int i10, Object obj) throws InterruptedException {
        if ((i10 & 1) != 0) {
            dVar = EmptyCoroutineContext.f34779a;
        }
        return C1056g.e(dVar, pVar);
    }

    public static final <T> T c(kotlin.coroutines.d dVar, AbstractC1053e0 abstractC1053e0, p9.p<? super M, ? super InterfaceC4014c<? super T>, ? extends Object> pVar) throws InterruptedException {
        C1052e c1052e = new C1052e(dVar, Thread.currentThread(), abstractC1053e0);
        c1052e.X0(CoroutineStart.DEFAULT, c1052e, pVar);
        return (T) c1052e.Z0();
    }
}
