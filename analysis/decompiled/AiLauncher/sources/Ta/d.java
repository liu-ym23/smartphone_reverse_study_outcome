package Ta;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u000f\u001a\u00020\n\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u000e\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"LTa/d;", "", "<init>", "()V", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", C3081a.FOCUS_MAP_NAME, "", "element", "", Const.INTENT_KEY_APIKEY, "(Ljava/util/Map;Ljava/util/Map$Entry;)Z", "thisMap", "otherMap", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Map;Ljava/util/Map;)Z", "", "c", "(Ljava/util/Map;)I", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f5920a = new d();

    public final <K, V> boolean a(Map<K, ? extends V> map, Map.Entry<? extends K, ? extends V> element) {
        p.i(map, "map");
        p.i(element, "element");
        V v10 = map.get(element.getKey());
        return v10 != null ? p.d(v10, element.getValue()) : element.getValue() == null && map.containsKey(element.getKey());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> boolean b(Map<K, ? extends V> thisMap, Map<?, ?> otherMap) {
        p.i(thisMap, "thisMap");
        p.i(otherMap, "otherMap");
        if (thisMap.size() != otherMap.size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (otherMap.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<?, ?>> it = otherMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!f5920a.a(thisMap, it.next())) {
                return false;
            }
        }
        return true;
    }

    public final <K, V> int c(Map<K, ? extends V> map) {
        p.i(map, "map");
        return map.entrySet().hashCode();
    }
}
