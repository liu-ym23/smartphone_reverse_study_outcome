package f0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u001e\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u001d\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J7\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001a\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00192\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001e\u0010\u000fR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lf0/g;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "Lf0/e;", "Lf0/f;", "builder", "", "Lf0/u;", "path", "<init>", "(Lf0/f;[Lf0/u;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "next", "()Ljava/lang/Object;", "remove", "key", "newValue", "l", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "keyHash", "Lf0/t;", "node", "pathIndex", "k", "(ILf0/t;Ljava/lang/Object;I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_UMID, "Lf0/f;", "e", "Ljava/lang/Object;", "lastIteratedKey", "", "f", "Z", "nextWasInvoked", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "expectedModCount", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class g<K, V, T> extends e<K, V, T> implements Iterator<T>, InterfaceC5162a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f<K, V> builder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public K lastIteratedKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean nextWasInvoked;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int expectedModCount;

    public g(f<K, V> fVar, u<K, V, T>[] uVarArr) {
        super(fVar.l(), uVarArr);
        this.builder = fVar;
        this.expectedModCount = fVar.getModCount();
    }

    private final void i() {
        if (this.builder.getModCount() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    public final void j() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    public final void k(int keyHash, t<?, ?> node, K key, int pathIndex) {
        int i10 = pathIndex * 5;
        if (i10 > 30) {
            e()[pathIndex].l(node.getBuffer(), node.getBuffer().length, 0);
            while (!kotlin.jvm.internal.p.d(e()[pathIndex].a(), key)) {
                e()[pathIndex].i();
            }
            g(pathIndex);
            return;
        }
        int iF = 1 << x.f(keyHash, i10);
        if (node.q(iF)) {
            e()[pathIndex].l(node.getBuffer(), node.m() * 2, node.n(iF));
            g(pathIndex);
        } else {
            int iO = node.O(iF);
            t<?, ?> tVarN = node.N(iO);
            e()[pathIndex].l(node.getBuffer(), node.m() * 2, iO);
            k(keyHash, tVarN, key, pathIndex + 1);
        }
    }

    public final void l(K key, V newValue) {
        if (this.builder.containsKey(key)) {
            if (getHasNext()) {
                K kB = b();
                this.builder.put(key, newValue);
                k(kB != null ? kB.hashCode() : 0, this.builder.l(), kB, 0);
            } else {
                this.builder.put(key, newValue);
            }
            this.expectedModCount = this.builder.getModCount();
        }
    }

    @Override // f0.e, java.util.Iterator
    public T next() {
        i();
        this.lastIteratedKey = b();
        this.nextWasInvoked = true;
        return (T) super.next();
    }

    @Override // f0.e, java.util.Iterator
    public void remove() {
        j();
        if (getHasNext()) {
            K kB = b();
            kotlin.jvm.internal.z.d(this.builder).remove(this.lastIteratedKey);
            k(kB != null ? kB.hashCode() : 0, this.builder.l(), kB, 0);
        } else {
            kotlin.jvm.internal.z.d(this.builder).remove(this.lastIteratedKey);
        }
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount();
    }
}
