package Ra;

import Z8.AbstractC1163k;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0005B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u000eH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"LRa/l;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LPa/c;", "", "LZ8/k;", "LRa/c;", C3081a.FOCUS_MAP_NAME, "<init>", "(LRa/c;)V", "element", "", "f", "(Ljava/util/Map$Entry;)Z", "", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_PKGNAME, "LRa/c;", "", "c", "()I", ContentDisposition.Parameters.Size, "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class l<K, V> extends AbstractC1163k<Map.Entry<? extends K, ? extends V>> implements Pa.c<Map.Entry<? extends K, ? extends V>> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final c<K, V> map;

    public l(c<K, V> map) {
        kotlin.jvm.internal.p.i(map, "map");
        this.map = map;
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c */
    public int getSize() {
        return this.map.size();
    }

    @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return f((Map.Entry) obj);
        }
        return false;
    }

    public boolean f(Map.Entry<? extends K, ? extends V> element) {
        kotlin.jvm.internal.p.i(element, "element");
        return Ta.d.f5920a.a(this.map, element);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new m(this.map);
    }
}
