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
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;
import w9.InterfaceC5755n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B5\u0012,\u0010\t\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R:\u0010\t\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b0\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lpb/t;", ExifInterface.GPS_DIRECTION_TRUE, "Lpb/B0;", "Lkotlin/Function2;", "Lw9/d;", "", "", "Lw9/n;", "Lkotlinx/serialization/KSerializer;", "compute", "<init>", "(Lp9/p;)V", "key", "types", "Lkotlin/Result;", Const.INTENT_KEY_APIKEY, "(Lw9/d;Ljava/util/List;)Ljava/lang/Object;", "Lp9/p;", "Lpb/u;", "Lpb/A0;", Const.INTENT_KEY_PKGNAME, "Lpb/u;", "classValue", "kotlinx-serialization-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: pb.t, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5121t<T> implements B0<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final p9.p<InterfaceC5745d<Object>, List<? extends InterfaceC5755n>, KSerializer<T>> compute;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5123u<A0<T>> classValue;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: pb.t$a */
    public static final class a implements InterfaceC5063a<T> {
        @Override // p9.InterfaceC5063a
        public final T invoke() {
            return (T) new A0();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C5121t(p9.p<? super InterfaceC5745d<Object>, ? super List<? extends InterfaceC5755n>, ? extends KSerializer<T>> compute) {
        kotlin.jvm.internal.p.i(compute, "compute");
        this.compute = compute;
        this.classValue = new C5123u<>();
    }

    @Override // pb.B0
    public Object a(InterfaceC5745d<Object> key, List<? extends InterfaceC5755n> types) {
        Object objB;
        kotlin.jvm.internal.p.i(key, "key");
        kotlin.jvm.internal.p.i(types, "types");
        A0<T> a02 = this.classValue.get(C5013a.b(key));
        kotlin.jvm.internal.p.h(a02, "get(...)");
        C5111n0 c5111n0 = (C5111n0) a02;
        T t10 = c5111n0.reference.get();
        if (t10 == null) {
            t10 = (T) c5111n0.a(new a());
        }
        A0 a03 = t10;
        List<? extends InterfaceC5755n> list = types;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Z((InterfaceC5755n) it.next()));
        }
        ConcurrentHashMap concurrentHashMap = a03.serializers;
        Object obj = concurrentHashMap.get(arrayList);
        if (obj == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(this.compute.invoke(key, types));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Result resultA = Result.a(objB);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList, resultA);
            obj = objPutIfAbsent == null ? resultA : objPutIfAbsent;
        }
        kotlin.jvm.internal.p.h(obj, "getOrPut(...)");
        return ((Result) obj).getValue();
    }
}
