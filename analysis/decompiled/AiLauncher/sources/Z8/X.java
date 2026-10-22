package Z8;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collections;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.builders.SetBuilder;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\n\u001a\u00020\tH\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0001¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "element", "", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)Ljava/util/Set;", ExifInterface.LONGITUDE_EAST, "", Const.INTENT_KEY_PKGNAME, "()Ljava/util/Set;", "", "capacity", "c", "(I)Ljava/util/Set;", "builder", Const.INTENT_KEY_APIKEY, "(Ljava/util/Set;)Ljava/util/Set;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/collections/SetsKt")
/* loaded from: classes4.dex */
public class X {
    public static <E> Set<E> a(Set<E> builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        return ((SetBuilder) builder).c();
    }

    public static <E> Set<E> b() {
        return new SetBuilder();
    }

    public static <E> Set<E> c(int i10) {
        return new SetBuilder(i10);
    }

    public static <T> Set<T> d(T t10) {
        Set<T> setSingleton = Collections.singleton(t10);
        kotlin.jvm.internal.p.h(setSingleton, "singleton(...)");
        return setSingleton;
    }
}
