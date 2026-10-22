package kb;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7384c;

    /* renamed from: f, reason: collision with root package name */
    public int f7385f;

    /* renamed from: g, reason: collision with root package name */
    public Object f7386g;

    public b(e eVar) {
        this.f7384c = 0;
        this.f7386g = eVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f7384c) {
            case 0:
                if (this.f7385f < ((e) this.f7386g).a()) {
                }
                break;
            case 1:
                if (this.f7385f < ((ViewGroup) this.f7386g).getChildCount()) {
                }
                break;
            default:
                if (this.f7385f < ((Object[]) this.f7386g).length) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f7384c) {
            case 0:
                if (!hasNext()) {
                    g5.f.k();
                    return null;
                }
                e eVar = (e) this.f7386g;
                int i = this.f7385f;
                this.f7385f = i + 1;
                return eVar.get(i);
            case 1:
                ViewGroup viewGroup = (ViewGroup) this.f7386g;
                int i3 = this.f7385f;
                this.f7385f = i3 + 1;
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
            default:
                try {
                    Object[] objArr = (Object[]) this.f7386g;
                    int i10 = this.f7385f;
                    this.f7385f = i10 + 1;
                    return objArr[i10];
                } catch (ArrayIndexOutOfBoundsException e10) {
                    this.f7385f--;
                    g5.f.m(e10.getMessage());
                    return null;
                }
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f7384c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                ViewGroup viewGroup = (ViewGroup) this.f7386g;
                int i = this.f7385f - 1;
                this.f7385f = i;
                viewGroup.removeViewAt(i);
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ b(int i) {
        this.f7384c = i;
    }
}
