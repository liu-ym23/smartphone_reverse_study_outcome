package Ua;

import Ua.I;
import Za.C1188h;
import Za.C1189i;
import Za.C1191k;
import Za.C1192l;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H&¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0017¢\u0006\u0004\b\u0018\u0010\u0017J'\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00152\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b \u0010!¨\u0006#"}, d2 = {"LUa/I;", "Lkotlin/coroutines/a;", "Lkotlin/coroutines/c;", "<init>", "()V", "Lkotlin/coroutines/d;", "context", "", "l1", "(Lkotlin/coroutines/d;)Z", "", "parallelism", "", "name", "s1", "(ILjava/lang/String;)LUa/I;", "m1", "(I)LUa/I;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "LY8/t;", "h1", "(Lkotlin/coroutines/d;Ljava/lang/Runnable;)V", "k1", ExifInterface.GPS_DIRECTION_TRUE, "Le9/c;", "continuation", "interceptContinuation", "(Le9/c;)Le9/c;", "releaseInterceptedContinuation", "(Le9/c;)V", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class I extends kotlin.coroutines.a implements kotlin.coroutines.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"LUa/I$a;", "Lkotlin/coroutines/b;", "Lkotlin/coroutines/c;", "LUa/I;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: Ua.I$a, reason: from kotlin metadata */
    public static final class Companion extends kotlin.coroutines.b<kotlin.coroutines.c, I> {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final I d(d.b bVar) {
            if (bVar instanceof I) {
                return (I) bVar;
            }
            return null;
        }

        public Companion() {
            super(kotlin.coroutines.c.INSTANCE, new InterfaceC5074l() { // from class: Ua.H
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return I.Companion.d((d.b) obj);
                }
            });
        }
    }

    public I() {
        super(kotlin.coroutines.c.INSTANCE);
    }

    public static /* synthetic */ I t1(I i10, int i11, String str, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i12 & 2) != 0) {
            str = null;
        }
        return i10.s1(i11, str);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d.b, kotlin.coroutines.d
    public /* bridge */ <E extends d.b> E get(d.c<E> cVar) {
        return (E) c.a.b(this, cVar);
    }

    public abstract void h1(kotlin.coroutines.d context, Runnable block);

    @Override // kotlin.coroutines.c
    public final <T> InterfaceC4014c<T> interceptContinuation(InterfaceC4014c<? super T> continuation) {
        return new C1188h(this, continuation);
    }

    public void k1(kotlin.coroutines.d context, Runnable block) {
        C1189i.c(this, context, block);
    }

    public boolean l1(kotlin.coroutines.d context) {
        return true;
    }

    public /* synthetic */ I m1(int parallelism) {
        return s1(parallelism, null);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d
    public /* bridge */ kotlin.coroutines.d minusKey(d.c<?> cVar) {
        return c.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.c
    public final void releaseInterceptedContinuation(InterfaceC4014c<?> continuation) {
        kotlin.jvm.internal.p.g(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1188h) continuation).y();
    }

    public I s1(int parallelism, String name) {
        C1192l.a(parallelism);
        return new C1191k(this, parallelism, name);
    }

    public String toString() {
        return N.a(this) + '@' + N.b(this);
    }
}
