package pb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import o9.C5013a;
import p9.InterfaceC5074l;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B'\u0012\u001e\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR,\u0010\u0006\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\rR*\u0010\u0013\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00100\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lpb/x;", ExifInterface.GPS_DIRECTION_TRUE, "Lpb/U0;", "Lkotlin/Function1;", "Lw9/d;", "Lkotlinx/serialization/KSerializer;", "compute", "<init>", "(Lp9/l;)V", "", "key", Const.INTENT_KEY_APIKEY, "(Lw9/d;)Lkotlinx/serialization/KSerializer;", "Lp9/l;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lpb/m;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.x, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5129x<T> implements U0<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<InterfaceC5745d<?>, KSerializer<T>> compute;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<Class<?>, C5108m<T>> cache;

    /* JADX WARN: Multi-variable type inference failed */
    public C5129x(InterfaceC5074l<? super InterfaceC5745d<?>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.p.i(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override // pb.U0
    public KSerializer<T> a(InterfaceC5745d<Object> key) {
        C5108m<T> c5108mPutIfAbsent;
        kotlin.jvm.internal.p.i(key, "key");
        ConcurrentHashMap<Class<?>, C5108m<T>> concurrentHashMap = this.cache;
        Class<?> clsB = C5013a.b(key);
        C5108m<T> c5108m = concurrentHashMap.get(clsB);
        if (c5108m == null && (c5108mPutIfAbsent = concurrentHashMap.putIfAbsent(clsB, (c5108m = new C5108m<>(this.compute.invoke(key))))) != null) {
            c5108m = c5108mPutIfAbsent;
        }
        return c5108m.serializer;
    }
}
