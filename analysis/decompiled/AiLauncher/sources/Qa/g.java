package Qa;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005B;\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u001e\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u000fJ\u001d\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0001¢\u0006\u0004\b\u0016\u0010\u0017JK\u0010 \u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001a2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"LQa/g;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "LQa/e;", "LQa/f;", "builder", "", "LQa/u;", "path", "<init>", "(LQa/f;[LQa/u;)V", "LY8/t;", "k", "()V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "next", "()Ljava/lang/Object;", "remove", "key", "newValue", "n", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "keyHash", "LQa/t;", "node", "pathIndex", "removedKeyHash", "", "afterRemove", "l", "(ILQa/t;Ljava/lang/Object;IIZ)V", Const.INTENT_KEY_UMID, "LQa/f;", "e", "Ljava/lang/Object;", "lastIteratedKey", "f", "Z", "nextWasInvoked", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "expectedModCount", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class g<K, V, T> extends e<K, V, T> implements Iterator<T>, InterfaceC5162a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f<K, V> builder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public K lastIteratedKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean nextWasInvoked;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int expectedModCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f<K, V> builder, u<K, V, T>[] path) {
        super(builder.m(), path);
        kotlin.jvm.internal.p.i(builder, "builder");
        kotlin.jvm.internal.p.i(path, "path");
        this.builder = builder;
        this.expectedModCount = builder.getModCount();
    }

    private final void j() {
        if (this.builder.getModCount() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void k() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    public static /* synthetic */ void m(g gVar, int i10, t tVar, Object obj, int i11, int i12, boolean z10, int i13, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resetPath");
        }
        if ((i13 & 16) != 0) {
            i12 = 0;
        }
        if ((i13 & 32) != 0) {
            z10 = false;
        }
        gVar.l(i10, tVar, obj, i11, i12, z10);
    }

    public final void l(int keyHash, t<?, ?> node, K key, int pathIndex, int removedKeyHash, boolean afterRemove) {
        int i10 = pathIndex * 5;
        if (i10 > 30) {
            e()[pathIndex].l(node.getBuffer(), node.getBuffer().length, 0);
            while (!kotlin.jvm.internal.p.d(e()[pathIndex].a(), key)) {
                e()[pathIndex].i();
            }
            i(pathIndex);
            return;
        }
        int iF = 1 << x.f(keyHash, i10);
        if (!node.s(iF)) {
            int iP = node.P(iF);
            t<?, ?> tVarO = node.O(iP);
            e()[pathIndex].l(node.getBuffer(), node.n() * 2, iP);
            l(keyHash, tVarO, key, pathIndex + 1, removedKeyHash, afterRemove);
            return;
        }
        int iO = node.o(iF);
        if (iF == (afterRemove ? 1 << x.f(removedKeyHash, i10) : 0) && pathIndex < getPathLastIndex()) {
            e()[getPathLastIndex()].k(new Object[]{node.getBuffer()[iO], node.getBuffer()[iO + 1]}, 2);
        } else {
            e()[pathIndex].l(node.getBuffer(), node.n() * 2, iO);
            i(pathIndex);
        }
    }

    public final void n(K key, V newValue) {
        g<K, V, T> gVar;
        if (this.builder.containsKey(key)) {
            if (getHasNext()) {
                K kB = b();
                this.builder.put(key, newValue);
                gVar = this;
                m(gVar, kB != null ? kB.hashCode() : 0, this.builder.m(), kB, 0, 0, false, 48, null);
            } else {
                gVar = this;
                gVar.builder.put(key, newValue);
            }
            gVar.expectedModCount = gVar.builder.getModCount();
        }
    }

    @Override // Qa.e, java.util.Iterator
    public T next() {
        j();
        this.lastIteratedKey = b();
        this.nextWasInvoked = true;
        return (T) super.next();
    }

    @Override // Qa.e, java.util.Iterator
    public void remove() {
        g<K, V, T> gVar;
        k();
        if (getHasNext()) {
            K kB = b();
            kotlin.jvm.internal.z.d(this.builder).remove(this.lastIteratedKey);
            int iHashCode = kB != null ? kB.hashCode() : 0;
            t<?, ?> tVarM = this.builder.m();
            K k10 = this.lastIteratedKey;
            gVar = this;
            gVar.l(iHashCode, tVarM, kB, 0, k10 != null ? k10.hashCode() : 0, true);
        } else {
            gVar = this;
            kotlin.jvm.internal.z.d(gVar.builder).remove(gVar.lastIteratedKey);
        }
        gVar.lastIteratedKey = null;
        gVar.nextWasInvoked = false;
        gVar.expectedModCount = gVar.builder.getModCount();
    }
}
