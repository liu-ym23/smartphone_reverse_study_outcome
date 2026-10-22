package Ra;

import Z8.AbstractC1163k;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"LRa/n;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LPa/c;", "LZ8/k;", "LRa/c;", C3081a.FOCUS_MAP_NAME, "<init>", "(LRa/c;)V", "element", "", "contains", "(Ljava/lang/Object;)Z", "", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_PKGNAME, "LRa/c;", "", "c", "()I", ContentDisposition.Parameters.Size, "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class n<K, V> extends AbstractC1163k<K> implements Pa.c<K> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final c<K, V> map;

    public n(c<K, V> map) {
        kotlin.jvm.internal.p.i(map, "map");
        this.map = map;
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c */
    public int getSize() {
        return this.map.size();
    }

    @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        return this.map.containsKey(element);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<K> iterator() {
        return new o(this.map);
    }
}
