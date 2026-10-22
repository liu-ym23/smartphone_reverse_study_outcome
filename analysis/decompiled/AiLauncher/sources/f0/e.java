package f0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b!\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B;\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u0018R2\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b0\u00078\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\"\u001a\u00020\u00128\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\f\n\u0004\b\u0017\u0010#\u0012\u0004\b$\u0010\u0018¨\u0006%"}, d2 = {"Lf0/e;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.GPS_DIRECTION_TRUE, "", "Lf0/t;", "node", "", "Lf0/u;", "path", "<init>", "(Lf0/t;[Lf0/u;)V", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", "", "hasNext", "()Z", "next", "", "pathIndex", "f", "(I)I", "LY8/t;", "c", "()V", Const.INTENT_KEY_APIKEY, "[Lf0/u;", "e", "()[Lf0/u;", "I", "getPathLastIndex", "()I", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)V", "pathLastIndex", "Z", "getHasNext$annotations", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class e<K, V, T> implements Iterator<T>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final u<K, V, T>[] path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int pathLastIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean hasNext = true;

    public e(t<K, V> tVar, u<K, V, T>[] uVarArr) {
        this.path = uVarArr;
        uVarArr[0].k(tVar.getBuffer(), tVar.m() * 2);
        this.pathLastIndex = 0;
        c();
    }

    public final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    public final K b() {
        a();
        return this.path[this.pathLastIndex].a();
    }

    public final void c() {
        if (this.path[this.pathLastIndex].f()) {
            return;
        }
        for (int i10 = this.pathLastIndex; -1 < i10; i10--) {
            int iF = f(i10);
            if (iF == -1 && this.path[i10].g()) {
                this.path[i10].j();
                iF = f(i10);
            }
            if (iF != -1) {
                this.pathLastIndex = iF;
                return;
            }
            if (i10 > 0) {
                this.path[i10 - 1].j();
            }
            this.path[i10].k(t.INSTANCE.a().getBuffer(), 0);
        }
        this.hasNext = false;
    }

    public final u<K, V, T>[] e() {
        return this.path;
    }

    public final int f(int pathIndex) {
        if (this.path[pathIndex].f()) {
            return pathIndex;
        }
        if (!this.path[pathIndex].g()) {
            return -1;
        }
        t<? extends K, ? extends V> tVarB = this.path[pathIndex].b();
        if (pathIndex == 6) {
            this.path[pathIndex + 1].k(tVarB.getBuffer(), tVarB.getBuffer().length);
        } else {
            this.path[pathIndex + 1].k(tVarB.getBuffer(), tVarB.m() * 2);
        }
        return f(pathIndex + 1);
    }

    public final void g(int i10) {
        this.pathLastIndex = i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public T next() {
        a();
        T next = this.path[this.pathLastIndex].next();
        c();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
