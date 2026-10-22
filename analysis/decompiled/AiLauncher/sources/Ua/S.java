package Ua;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"LUa/S;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/a;", "LUa/Q;", "Lkotlin/coroutines/d;", "parentContext", "", "active", "<init>", "(Lkotlin/coroutines/d;Z)V", "m", "()Ljava/lang/Object;", SdCardDbCreator.FIELD_LASTLOC_ID, "(Le9/c;)Ljava/lang/Object;", "Lcb/f;", "D0", "()Lcb/f;", "onAwait", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public class S<T> extends kotlinx.coroutines.a<T> implements Q<T> {
    public S(kotlin.coroutines.d dVar, boolean z10) {
        super(dVar, true, z10);
    }

    public static /* synthetic */ <T> Object Z0(S<T> s10, InterfaceC4014c<? super T> interfaceC4014c) throws Throwable {
        Object objD = s10.D(interfaceC4014c);
        C4063a.g();
        return objD;
    }

    @Override // Ua.Q
    public cb.f<T> D0() {
        cb.f<T> fVar = (cb.f<T>) X();
        kotlin.jvm.internal.p.g(fVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectClause1<T of kotlinx.coroutines.DeferredCoroutine>");
        return fVar;
    }

    @Override // Ua.Q
    public Object a1(InterfaceC4014c<? super T> interfaceC4014c) {
        return Z0(this, interfaceC4014c);
    }

    @Override // Ua.Q
    public T m() {
        return (T) S();
    }
}
