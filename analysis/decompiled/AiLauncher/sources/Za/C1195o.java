package Za;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0014j\b\u0012\u0004\u0012\u00028\u0000`\u00150\u00138\u0002X\u0082\u0004¨\u0006\u0017"}, d2 = {"LZa/o;", "", ExifInterface.LONGITUDE_EAST, "", "singleConsumer", "<init>", "(Z)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "element", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Z", "e", "()Ljava/lang/Object;", "", "c", "()I", ContentDisposition.Parameters.Size, "LOa/e;", "LZa/p;", "Lkotlinx/coroutines/internal/Core;", "_cur", "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Za.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C1195o<E> {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7747a = AtomicReferenceFieldUpdater.newUpdater(C1195o.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public C1195o(boolean z10) {
        this._cur$volatile = new C1196p(8, z10);
    }

    public final boolean a(E element) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7747a;
        while (true) {
            C1196p c1196p = (C1196p) atomicReferenceFieldUpdater.get(this);
            int iA = c1196p.a(element);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                f7747a.compareAndSet(this, c1196p, c1196p.l());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7747a;
        while (true) {
            C1196p c1196p = (C1196p) atomicReferenceFieldUpdater.get(this);
            if (c1196p.d()) {
                return;
            } else {
                f7747a.compareAndSet(this, c1196p, c1196p.l());
            }
        }
    }

    public final int c() {
        return ((C1196p) f7747a.get(this)).g();
    }

    public final E e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7747a;
        while (true) {
            C1196p c1196p = (C1196p) atomicReferenceFieldUpdater.get(this);
            E e10 = (E) c1196p.m();
            if (e10 != C1196p.f7751h) {
                return e10;
            }
            f7747a.compareAndSet(this, c1196p, c1196p.l());
        }
    }
}
