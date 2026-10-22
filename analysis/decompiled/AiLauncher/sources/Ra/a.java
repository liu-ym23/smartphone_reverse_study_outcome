package Ra;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\tJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\fR\u0017\u0010\u0003\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0019¨\u0006\u001c"}, d2 = {"LRa/a;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", UxipConstants.f30680s, "previous", "next", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "(Ljava/lang/Object;)V", "(Ljava/lang/Object;Ljava/lang/Object;)V", "newValue", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;)LRa/a;", "newPrevious", Const.INTENT_KEY_BACKGROUND_COMMAND, "newNext", "f", Const.INTENT_KEY_APIKEY, "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "c", "", "()Z", "hasNext", "hasPrevious", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class a<V> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final V value;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object previous;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object next;

    public a(V v10, Object obj, Object obj2) {
        this.value = v10;
        this.previous = obj;
        this.next = obj2;
    }

    public final boolean a() {
        return this.next != Ta.c.f5919a;
    }

    public final boolean b() {
        return this.previous != Ta.c.f5919a;
    }

    /* renamed from: c, reason: from getter */
    public final Object getNext() {
        return this.next;
    }

    /* renamed from: d, reason: from getter */
    public final Object getPrevious() {
        return this.previous;
    }

    public final V e() {
        return this.value;
    }

    public final a<V> f(Object newNext) {
        return new a<>(this.value, this.previous, newNext);
    }

    public final a<V> g(Object newPrevious) {
        return new a<>(this.value, newPrevious, this.next);
    }

    public final a<V> h(V newValue) {
        return new a<>(newValue, this.previous, this.next);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(V v10) {
        Ta.c cVar = Ta.c.f5919a;
        this(v10, cVar, cVar);
    }

    public a(V v10, Object obj) {
        this(v10, obj, Ta.c.f5919a);
    }
}
