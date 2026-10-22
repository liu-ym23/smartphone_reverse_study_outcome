package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroid/view/ViewGroup;", "", "Landroid/view/View;", "c", "(Landroid/view/ViewGroup;)Ljava/util/Iterator;", "LKa/j;", Const.INTENT_KEY_APIKEY, "(Landroid/view/ViewGroup;)LKa/j;", "children", Const.INTENT_KEY_PKGNAME, "descendants", "core-ktx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Q {

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"androidx/core/view/Q$a", "LKa/j;", "Landroid/view/View;", "", "iterator", "()Ljava/util/Iterator;", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Ka.j<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f13132a;

        public a(ViewGroup viewGroup) {
            this.f13132a = viewGroup;
        }

        @Override // Ka.j
        public Iterator<View> iterator() {
            return Q.c(this.f13132a);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<View, Iterator<? extends View>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f13133a = new b();

        @Override // p9.InterfaceC5074l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Iterator<View> invoke(View view) {
            Ka.j<View> jVarA;
            ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
            if (viewGroup == null || (jVarA = Q.a(viewGroup)) == null) {
                return null;
            }
            return jVarA.iterator();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\f¨\u0006\u000e"}, d2 = {"androidx/core/view/Q$c", "", "Landroid/view/View;", "", "hasNext", "()Z", Const.INTENT_KEY_APIKEY, "()Landroid/view/View;", "LY8/t;", "remove", "()V", "", "I", "index", "core-ktx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements Iterator<View>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int index;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f13135b;

        public c(ViewGroup viewGroup) {
            this.f13135b = viewGroup;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public View next() {
            ViewGroup viewGroup = this.f13135b;
            int i10 = this.index;
            this.index = i10 + 1;
            View childAt = viewGroup.getChildAt(i10);
            if (childAt != null) {
                return childAt;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.f13135b.getChildCount();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup viewGroup = this.f13135b;
            int i10 = this.index - 1;
            this.index = i10;
            viewGroup.removeViewAt(i10);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"androidx/core/view/Q$d", "LKa/j;", "", "iterator", "()Ljava/util/Iterator;", "kotlin-stdlib"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements Ka.j<View> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f13136a;

        public d(ViewGroup viewGroup) {
            this.f13136a = viewGroup;
        }

        @Override // Ka.j
        public Iterator<View> iterator() {
            return new J(Q.a(this.f13136a).iterator(), b.f13133a);
        }
    }

    public static final Ka.j<View> a(ViewGroup viewGroup) {
        return new a(viewGroup);
    }

    public static final Ka.j<View> b(ViewGroup viewGroup) {
        return new d(viewGroup);
    }

    public static final Iterator<View> c(ViewGroup viewGroup) {
        return new c(viewGroup);
    }
}
