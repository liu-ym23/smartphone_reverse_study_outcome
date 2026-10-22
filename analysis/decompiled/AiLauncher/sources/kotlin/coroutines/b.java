package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.coroutines.d.b;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B+\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0018\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlin/coroutines/b;", "Lkotlin/coroutines/d$b;", "B", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/d$c;", "baseKey", "Lkotlin/Function1;", "safeCast", "<init>", "(Lkotlin/coroutines/d$c;Lp9/l;)V", "element", Const.INTENT_KEY_PKGNAME, "(Lkotlin/coroutines/d$b;)Lkotlin/coroutines/d$b;", "key", "", Const.INTENT_KEY_APIKEY, "(Lkotlin/coroutines/d$c;)Z", "Lp9/l;", "Lkotlin/coroutines/d$c;", "topmostKey", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class b<B extends d.b, E extends B> implements d.c<E> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<d.b, E> safeCast;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final d.c<?> topmostKey;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.d$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, p9.l<? super kotlin.coroutines.d$b, ? extends E extends B>, p9.l<kotlin.coroutines.d$b, E extends B>] */
    public b(d.c<B> baseKey, InterfaceC5074l<? super d.b, ? extends E> safeCast) {
        p.i(baseKey, "baseKey");
        p.i(safeCast, "safeCast");
        this.safeCast = safeCast;
        this.topmostKey = baseKey instanceof b ? (d.c<B>) ((b) baseKey).topmostKey : baseKey;
    }

    public final boolean a(d.c<?> key) {
        p.i(key, "key");
        return key == this || this.topmostKey == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/d$b;)TE; */
    public final d.b b(d.b element) {
        p.i(element, "element");
        return (d.b) this.safeCast.invoke(element);
    }
}
