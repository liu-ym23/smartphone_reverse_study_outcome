package kotlinx.coroutines.flow.internal;

import Xa.c;
import Y8.t;
import Za.J;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlin.coroutines.d;
import p9.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R0\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/internal/UndispatchedContextCollector;", ExifInterface.GPS_DIRECTION_TRUE, "LXa/c;", "downstream", "Lkotlin/coroutines/d;", "emitContext", "<init>", "(LXa/c;Lkotlin/coroutines/d;)V", UxipConstants.f30680s, "LY8/t;", "emit", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lkotlin/coroutines/d;", "", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "countOrElement", "Lkotlin/Function2;", "Le9/c;", "c", "Lp9/p;", "emitRef", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UndispatchedContextCollector<T> implements c<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d emitContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object countOrElement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final p<T, InterfaceC4014c<? super t>, Object> emitRef;

    public UndispatchedContextCollector(c<? super T> cVar, d dVar) {
        this.emitContext = dVar;
        this.countOrElement = J.g(dVar);
        this.emitRef = new UndispatchedContextCollector$emitRef$1(cVar, null);
    }

    @Override // Xa.c
    public Object emit(T t10, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objB = ChannelFlowKt.b(this.emitContext, t10, this.countOrElement, this.emitRef, interfaceC4014c);
        return objB == C4063a.g() ? objB : t.f7040a;
    }
}
