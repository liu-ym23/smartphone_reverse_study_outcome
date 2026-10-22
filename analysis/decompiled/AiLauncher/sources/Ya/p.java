package Ya;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.InterfaceC4111c;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"LYa/p;", ExifInterface.GPS_DIRECTION_TRUE, "Le9/c;", "Lg9/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "uCont", "Lkotlin/coroutines/d;", "context", "<init>", "(Le9/c;Lkotlin/coroutines/d;)V", "Lkotlin/Result;", "result", "LY8/t;", "resumeWith", "(Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "Le9/c;", Const.INTENT_KEY_PKGNAME, "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "getCallerFrame", "()Lg9/c;", "callerFrame", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class p<T> implements InterfaceC4014c<T>, InterfaceC4111c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4014c<T> uCont;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final kotlin.coroutines.d context;

    /* JADX WARN: Multi-variable type inference failed */
    public p(InterfaceC4014c<? super T> interfaceC4014c, kotlin.coroutines.d dVar) {
        this.uCont = interfaceC4014c;
        this.context = dVar;
    }

    @Override // g9.InterfaceC4111c
    public InterfaceC4111c getCallerFrame() {
        InterfaceC4014c<T> interfaceC4014c = this.uCont;
        if (interfaceC4014c instanceof InterfaceC4111c) {
            return (InterfaceC4111c) interfaceC4014c;
        }
        return null;
    }

    @Override // e9.InterfaceC4014c
    public kotlin.coroutines.d getContext() {
        return this.context;
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) {
        this.uCont.resumeWith(result);
    }
}
