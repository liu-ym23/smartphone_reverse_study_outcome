package e0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import q9.InterfaceC5162a;
import v9.C5685n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u000f\u0010\u0017\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001b¨\u0006#"}, d2 = {"Le0/j;", ExifInterface.GPS_DIRECTION_TRUE, "", "Le0/a;", "Le0/h;", "builder", "", "index", "<init>", "(Le0/h;I)V", "previous", "()Ljava/lang/Object;", "next", "element", "LY8/t;", "add", "(Ljava/lang/Object;)V", "remove", "()V", "set", "k", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "c", "Le0/h;", Const.INTENT_KEY_UMID, "I", "expectedModCount", "Le0/m;", "e", "Le0/m;", "trieIterator", "f", "lastIteratedIndex", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class j<T> extends AbstractC3970a<T> implements ListIterator<T>, InterfaceC5162a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final h<T> builder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int expectedModCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public m<? extends T> trieIterator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int lastIteratedIndex;

    public j(h<T> hVar, int i10) {
        super(i10, hVar.size());
        this.builder = hVar;
        this.expectedModCount = hVar.j();
        this.lastIteratedIndex = -1;
        l();
    }

    @Override // e0.AbstractC3970a, java.util.ListIterator
    public void add(T element) {
        i();
        this.builder.add(getIndex(), element);
        f(getIndex() + 1);
        k();
    }

    public final void i() {
        if (this.expectedModCount != this.builder.j()) {
            throw new ConcurrentModificationException();
        }
    }

    public final void j() {
        if (this.lastIteratedIndex == -1) {
            throw new IllegalStateException();
        }
    }

    public final void k() {
        g(this.builder.size());
        this.expectedModCount = this.builder.j();
        this.lastIteratedIndex = -1;
        l();
    }

    public final void l() {
        Object[] objArrK = this.builder.getCom.stepos.statsapp.v3.lib.plugin.constants.Parameters.ROOT java.lang.String();
        if (objArrK == null) {
            this.trieIterator = null;
            return;
        }
        int iD = n.d(this.builder.size());
        int iJ = C5685n.j(getIndex(), iD);
        int iL = (this.builder.getRootShift() / 5) + 1;
        m<? extends T> mVar = this.trieIterator;
        if (mVar == null) {
            this.trieIterator = new m<>(objArrK, iJ, iD, iL);
        } else {
            p.f(mVar);
            mVar.l(objArrK, iJ, iD, iL);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        i();
        a();
        this.lastIteratedIndex = getIndex();
        m<? extends T> mVar = this.trieIterator;
        if (mVar == null) {
            Object[] objArrM = this.builder.getTail();
            int index = getIndex();
            f(index + 1);
            return (T) objArrM[index];
        }
        if (mVar.hasNext()) {
            f(getIndex() + 1);
            return mVar.next();
        }
        Object[] objArrM2 = this.builder.getTail();
        int index2 = getIndex();
        f(index2 + 1);
        return (T) objArrM2[index2 - mVar.getSize()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        i();
        b();
        this.lastIteratedIndex = getIndex() - 1;
        m<? extends T> mVar = this.trieIterator;
        if (mVar == null) {
            Object[] objArrM = this.builder.getTail();
            f(getIndex() - 1);
            return (T) objArrM[getIndex()];
        }
        if (getIndex() <= mVar.getSize()) {
            f(getIndex() - 1);
            return mVar.previous();
        }
        Object[] objArrM2 = this.builder.getTail();
        f(getIndex() - 1);
        return (T) objArrM2[getIndex() - mVar.getSize()];
    }

    @Override // e0.AbstractC3970a, java.util.ListIterator, java.util.Iterator
    public void remove() {
        i();
        j();
        this.builder.remove(this.lastIteratedIndex);
        if (this.lastIteratedIndex < getIndex()) {
            f(this.lastIteratedIndex);
        }
        k();
    }

    @Override // e0.AbstractC3970a, java.util.ListIterator
    public void set(T element) {
        i();
        j();
        this.builder.set(this.lastIteratedIndex, element);
        this.expectedModCount = this.builder.j();
        l();
    }
}
