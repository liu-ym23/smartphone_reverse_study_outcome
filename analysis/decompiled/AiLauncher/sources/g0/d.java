package g0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R&\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001c\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\"\u0004\b\u0018\u0010\u001b¨\u0006\u001d"}, d2 = {"Lg0/d;", ExifInterface.LONGITUDE_EAST, "", "", "nextElement", "", "Lg0/a;", C3081a.FOCUS_MAP_NAME, "<init>", "(Ljava/lang/Object;Ljava/util/Map;)V", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "getMap$runtime", "()Ljava/util/Map;", "", "c", "I", "()I", "(I)V", "index", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class d<E> implements Iterator<E>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Object nextElement;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<E, C4087a> map;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int index;

    public d(Object obj, Map<E, C4087a> map) {
        this.nextElement = obj;
        this.map = map;
    }

    private final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    /* renamed from: b, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final void c(int i10) {
        this.index = i10;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.map.size();
    }

    @Override // java.util.Iterator
    public E next() {
        a();
        E e10 = (E) this.nextElement;
        this.index++;
        C4087a c4087a = this.map.get(e10);
        if (c4087a != null) {
            this.nextElement = c4087a.getNext();
            return e10;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + e10 + ") has changed after it was added to the persistent set.");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
