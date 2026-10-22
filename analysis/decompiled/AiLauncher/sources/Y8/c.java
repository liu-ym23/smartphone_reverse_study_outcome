package Y8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.C4847a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.z;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004BE\u00124\u0010\u0007\u001a0\b\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00028\u0001¢\u0006\u0004\b\u0012\u0010\u0013RH\u0010\u0016\u001a4\b\u0001\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u001e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"LY8/c;", ExifInterface.GPS_DIRECTION_TRUE, "R", "LY8/b;", "Le9/c;", "Lkotlin/Function3;", "", "block", UxipConstants.f30680s, "<init>", "(Lp9/q;Ljava/lang/Object;)V", "Lkotlin/Result;", "result", "LY8/t;", "resumeWith", "(Ljava/lang/Object;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "c", "()Ljava/lang/Object;", "Lkotlin/DeepRecursiveFunctionBlock;", "Lp9/q;", "function", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "Le9/c;", "cont", Const.INTENT_KEY_UMID, "Lkotlin/coroutines/d;", "getContext", "()Lkotlin/coroutines/d;", "context", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class c<T, R> extends b<T, R> implements InterfaceC4014c<R> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public p9.q<? super b<?, ?>, Object, ? super InterfaceC4014c<Object>, ? extends Object> function;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Object value;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public InterfaceC4014c<Object> cont;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Object result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p9.q<? super b<T, R>, ? super T, ? super InterfaceC4014c<? super R>, ? extends Object> block, T t10) {
        super(null);
        kotlin.jvm.internal.p.i(block, "block");
        this.function = block;
        this.value = t10;
        kotlin.jvm.internal.p.g(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = this;
        this.result = C4847a.f34706a;
    }

    @Override // Y8.b
    public Object a(T t10, InterfaceC4014c<? super R> interfaceC4014c) {
        kotlin.jvm.internal.p.g(interfaceC4014c, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.cont = interfaceC4014c;
        this.value = t10;
        Object objG = C4063a.g();
        if (objG == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objG;
    }

    public final R c() throws Throwable {
        while (true) {
            R r10 = (R) this.result;
            InterfaceC4014c<Object> interfaceC4014c = this.cont;
            if (interfaceC4014c == null) {
                C4849c.b(r10);
                return r10;
            }
            if (Result.d(C4847a.f34706a, r10)) {
                try {
                    p9.q<? super b<?, ?>, Object, ? super InterfaceC4014c<Object>, ? extends Object> qVar = this.function;
                    Object obj = this.value;
                    Object objF = !(qVar instanceof BaseContinuationImpl) ? IntrinsicsKt__IntrinsicsJvmKt.f(qVar, this, obj, interfaceC4014c) : ((p9.q) z.g(qVar, 3)).invoke(this, obj, interfaceC4014c);
                    if (objF != C4063a.g()) {
                        interfaceC4014c.resumeWith(Result.b(objF));
                    }
                } catch (Throwable th) {
                    Result.Companion companion = Result.INSTANCE;
                    interfaceC4014c.resumeWith(Result.b(C4849c.a(th)));
                }
            } else {
                this.result = C4847a.f34706a;
                interfaceC4014c.resumeWith(r10);
            }
        }
    }

    @Override // e9.InterfaceC4014c
    public kotlin.coroutines.d getContext() {
        return EmptyCoroutineContext.f34779a;
    }

    @Override // e9.InterfaceC4014c
    public void resumeWith(Object result) {
        this.cont = null;
        this.result = result;
    }
}
