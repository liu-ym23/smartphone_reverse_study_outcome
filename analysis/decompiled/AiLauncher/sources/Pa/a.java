package Pa;

import Pa.d;
import Pa.e;
import Sa.g;
import Z8.A;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u001a4\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aH\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u0007¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {ExifInterface.LONGITUDE_EAST, "LPa/e;", "", "elements", "c", "(LPa/e;Ljava/lang/Iterable;)LPa/e;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LPa/d;", "keys", Const.INTENT_KEY_APIKEY, "(LPa/d;Ljava/lang/Iterable;)LPa/d;", Const.INTENT_KEY_PKGNAME, "()LPa/d;", ExifInterface.GPS_DIRECTION_TRUE, Const.INTENT_KEY_UMID, "(Ljava/lang/Iterable;)LPa/e;", "kotlinx-collections-immutable"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a {
    public static final <K, V> d<K, V> a(d<? extends K, ? extends V> dVar, Iterable<? extends K> keys) {
        p.i(dVar, "<this>");
        p.i(keys, "keys");
        d.a<? extends K, ? extends V> aVarBuilder = dVar.builder();
        A.K(aVarBuilder.keySet(), keys);
        return aVarBuilder.build();
    }

    public static final <K, V> d<K, V> b() {
        return Ra.c.INSTANCE.a();
    }

    public static final <E> e<E> c(e<? extends E> eVar, Iterable<? extends E> elements) {
        p.i(eVar, "<this>");
        p.i(elements, "elements");
        if (elements instanceof Collection) {
            return eVar.addAll((Collection<? extends Object>) elements);
        }
        e.a<? extends E> aVarBuilder = eVar.builder();
        A.E(aVarBuilder, elements);
        return aVarBuilder.build();
    }

    public static final <T> e<T> d(Iterable<? extends T> iterable) {
        p.i(iterable, "<this>");
        Sa.d dVar = iterable instanceof Sa.d ? (Sa.d) iterable : null;
        if (dVar != null) {
            return dVar;
        }
        g gVar = iterable instanceof g ? (g) iterable : null;
        e<T> eVarBuild = gVar != null ? gVar.build() : null;
        return eVarBuild == null ? c(Sa.d.INSTANCE.a(), iterable) : eVarBuild;
    }
}
