package f0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Map;
import kotlin.Metadata;
import q9.e;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B+\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\f\u0010\rR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\b\u001a\u00028\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lf0/c;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lf0/b;", "", "Lf0/i;", "parentIterator", "key", UxipConstants.f30680s, "<init>", "(Lf0/i;Ljava/lang/Object;Ljava/lang/Object;)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "c", "Lf0/i;", Const.INTENT_KEY_UMID, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: f0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4030c<K, V> extends C4029b<K, V> implements Map.Entry<K, V>, e.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final i<K, V> parentIterator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public V value;

    public C4030c(i<K, V> iVar, K k10, V v10) {
        super(k10, v10);
        this.parentIterator = iVar;
        this.value = v10;
    }

    public void a(V v10) {
        this.value = v10;
    }

    @Override // f0.C4029b, java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // f0.C4029b, java.util.Map.Entry
    public V setValue(V newValue) {
        V value = getValue();
        a(newValue);
        this.parentIterator.b(getKey(), newValue);
        return value;
    }
}
