package Ra;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0010H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\fJ#\u0010\u0015\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"LRa/e;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LQa/a;", "", "LRa/d;", "builder", "<init>", "(LRa/d;)V", "element", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map$Entry;)Z", "LY8/t;", "clear", "()V", "", "iterator", "()Ljava/util/Iterator;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "e", Const.INTENT_KEY_APIKEY, "LRa/d;", "", Const.INTENT_KEY_PKGNAME, "()I", ContentDisposition.Parameters.Size, "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class e<K, V> extends Qa.a<Map.Entry<K, V>, K, V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d<K, V> builder;

    public e(d<K, V> builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        this.builder = builder;
    }

    @Override // Z8.AbstractC1162j
    public int b() {
        return this.builder.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.builder.clear();
    }

    @Override // Qa.a
    public boolean e(Map.Entry<? extends K, ? extends V> element) {
        kotlin.jvm.internal.p.i(element, "element");
        return Ta.d.f5920a.a(this.builder, element);
    }

    @Override // Qa.a
    public boolean i(Map.Entry<? extends K, ? extends V> element) {
        kotlin.jvm.internal.p.i(element, "element");
        return this.builder.remove(element.getKey(), element.getValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new f(this.builder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry<K, V> element) {
        kotlin.jvm.internal.p.i(element, "element");
        throw new UnsupportedOperationException();
    }
}
