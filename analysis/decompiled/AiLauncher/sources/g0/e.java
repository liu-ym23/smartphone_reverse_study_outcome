package g0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.z;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0010\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lg0/e;", ExifInterface.LONGITUDE_EAST, "Lg0/d;", "", "Lg0/c;", "builder", "<init>", "(Lg0/c;)V", "LY8/t;", "f", "()V", "e", "next", "()Ljava/lang/Object;", "remove", Const.INTENT_KEY_UMID, "Lg0/c;", "Ljava/lang/Object;", "lastIteratedElement", "", "Z", "nextWasInvoked", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "expectedModCount", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e<E> extends d<E> implements Iterator<E>, InterfaceC5162a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C4089c<E> builder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public E lastIteratedElement;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public boolean nextWasInvoked;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int expectedModCount;

    public e(C4089c<E> c4089c) {
        super(c4089c.getFirstElement(), c4089c.e());
        this.builder = c4089c;
        this.expectedModCount = c4089c.e().getModCount();
    }

    private final void e() {
        if (this.builder.e().getModCount() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void f() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    @Override // g0.d, java.util.Iterator
    public E next() {
        e();
        E e10 = (E) super.next();
        this.lastIteratedElement = e10;
        this.nextWasInvoked = true;
        return e10;
    }

    @Override // g0.d, java.util.Iterator
    public void remove() {
        f();
        z.a(this.builder).remove(this.lastIteratedElement);
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.e().getModCount();
        c(getIndex() - 1);
    }
}
