package pb;

import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.serialization.KSerializer;
import o9.C5013a;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B5\u0012,\u0010\t\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R:\u0010\t\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R*\u0010\u0017\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lpb/y;", ExifInterface.GPS_DIRECTION_TRUE, "Lpb/B0;", "Lkotlin/Function2;", "Lw9/d;", "", "", "Lw9/n;", "Lkotlinx/serialization/KSerializer;", "compute", "<init>", "(Lp9/p;)V", "key", "types", "Lkotlin/Result;", Const.INTENT_KEY_APIKEY, "(Lw9/d;Ljava/util/List;)Ljava/lang/Object;", "Lp9/p;", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lpb/A0;", Const.INTENT_KEY_PKGNAME, "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.y, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5131y<T> implements B0<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p9.p<InterfaceC5745d<Object>, List<? extends InterfaceC5755n>, KSerializer<T>> compute;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentHashMap<Class<?>, A0<T>> cache;

    /* JADX WARN: Multi-variable type inference failed */
    public C5131y(p9.p<? super InterfaceC5745d<Object>, ? super List<? extends InterfaceC5755n>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.p.i(compute, "compute");
        this.compute = compute;
        this.cache = new ConcurrentHashMap<>();
    }

    @Override // pb.B0
    public Object a(InterfaceC5745d<Object> key, List<? extends InterfaceC5755n> types) {
        Object objB;
        A0<T> a0PutIfAbsent;
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(types, "types");
        ConcurrentHashMap<Class<?>, A0<T>> concurrentHashMap = this.cache;
        Class<?> clsB = C5013a.b(key);
        A0<T> a02 = concurrentHashMap.get(clsB);
        if (a02 == null && (a0PutIfAbsent = concurrentHashMap.putIfAbsent(clsB, (a02 = new A0<>()))) != null) {
            a02 = a0PutIfAbsent;
        }
        A0<T> a03 = a02;
        List<? extends InterfaceC5755n> list = types;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Z((InterfaceC5755n) it.next()));
        }
        ConcurrentHashMap concurrentHashMap2 = a03.serializers;
        Object obj = concurrentHashMap2.get(arrayList);
        if (obj == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(this.compute.invoke(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result resultA = Result.a(objB);
            Object objPutIfAbsent = concurrentHashMap2.putIfAbsent(arrayList, resultA);
            obj = objPutIfAbsent == null ? resultA : objPutIfAbsent;
        }
        kotlin.jvm.internal.p.h(obj, "getOrPut(...)");
        return ((Result) obj).getValue();
    }
}
