package Ra;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;
import q9.e;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B7\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u0005\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00028\u00012\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eR&\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"LRa/b;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "LQa/b;", "", "", "LRa/a;", "mutableMap", "key", "links", "<init>", "(Ljava/util/Map;Ljava/lang/Object;LRa/a;)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "c", "Ljava/util/Map;", Const.INTENT_KEY_UMID, "LRa/a;", "getValue", "()Ljava/lang/Object;", UxipConstants.f30680s, "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b<K, V> extends Qa.b<K, V> implements Map.Entry<K, V>, e.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<K, a<V>> mutableMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public a<V> links;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Map<K, a<V>> mutableMap, K k10, a<V> links) {
        super(k10, links.e());
        kotlin.jvm.internal.p.i(mutableMap, "mutableMap");
        kotlin.jvm.internal.p.i(links, "links");
        this.mutableMap = mutableMap;
        this.links = links;
    }

    @Override // Qa.b, java.util.Map.Entry
    public V getValue() {
        return this.links.e();
    }

    @Override // Qa.b, java.util.Map.Entry
    public V setValue(V newValue) {
        V vE = this.links.e();
        this.links = this.links.h(newValue);
        this.mutableMap.put(getKey(), this.links);
        return vE;
    }
}
