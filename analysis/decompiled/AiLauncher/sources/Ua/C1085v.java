package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;
import kotlinx.coroutines.JobSupport;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\r8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"LUa/v;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/JobSupport;", "LUa/u;", "Lkotlinx/coroutines/g;", "parent", "<init>", "(Lkotlinx/coroutines/g;)V", "m", "()Ljava/lang/Object;", SdCardDbCreator.FIELD_LASTLOC_ID, "(Le9/c;)Ljava/lang/Object;", UxipConstants.f30680s, "", "complete", "(Ljava/lang/Object;)Z", "", "exception", "e", "(Ljava/lang/Throwable;)Z", "Y", "()Z", "onCancelComplete", "Lcb/f;", "D0", "()Lcb/f;", "onAwait", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Ua.v, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C1085v<T> extends JobSupport implements InterfaceC1083u<T> {
    public C1085v(kotlinx.coroutines.g gVar) {
        super(true);
        i0(gVar);
    }

    @Override // Ua.Q
    public cb.f<T> D0() {
        cb.f<T> fVar = (cb.f<T>) X();
        kotlin.jvm.internal.p.g(fVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.CompletableDeferredImpl>");
        return fVar;
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean Y() {
        return true;
    }

    @Override // Ua.Q
    public Object a1(InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        Object objD = D(interfaceC4014c);
        C4063a.g();
        return objD;
    }

    @Override // Ua.InterfaceC1083u
    public boolean complete(T value) {
        return p0(value);
    }

    @Override // Ua.InterfaceC1083u
    public boolean e(Throwable exception) {
        return p0(new C1091z(exception, false, 2, null));
    }

    @Override // Ua.Q
    public T m() {
        return (T) S();
    }
}
