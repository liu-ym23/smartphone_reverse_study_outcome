package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.k0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public final class e extends k0 implements NavViewModelStoreProvider {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f3839e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ViewModelProvider.Factory f3840f = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f3841d;

    public static final class a implements ViewModelProvider.Factory {
        public a() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10) {
            kotlin.jvm.internal.q.g(r10, "modelClass");
            return new e();
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public final e a(ViewModelStore r10) {
            kotlin.jvm.internal.q.g(r10, "viewModelStore");
            return (e) new ViewModelProvider(r10, e.f(), null, 4, null).a(e.class);
        }

        public b() {
        }
    }

    static {
        f3839e = new b(null);
        f3840f = new a();
    }

    public e() {
        this.f3841d = new LinkedHashMap();
    }

    public static final /* synthetic */ ViewModelProvider.Factory f() {
        return f3840f;
    }

    @Override // androidx.lifecycle.k0
    public void d() {
        Iterator r10 = this.f3841d.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((ViewModelStore) r10.next()).a();
        goto L4
    L6:
        this.f3841d.clear();
    }

    public final void g(String r10) {
        kotlin.jvm.internal.q.g(r10, "backStackEntryId");
        ViewModelStore r11 = (ViewModelStore) this.f3841d.remove(r10);
        if (r11 == null) goto L6;
        r11.a();
        return;
    }

    @Override // androidx.navigation.NavViewModelStoreProvider
    public ViewModelStore getViewModelStore(String r10) {
        kotlin.jvm.internal.q.g(r10, "backStackEntryId");
        ViewModelStore r11 = (ViewModelStore) this.f3841d.get(r10);
        if (r11 != null) goto L6;
        ViewModelStore r12 = new ViewModelStore();
        this.f3841d.put(r10, r12);
        return r12;
    L6:
        return r11;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("NavControllerViewModel{");
        r10.append(Integer.toHexString(System.identityHashCode(this)));
        r10.append("} ViewModelStores (");
        Iterator r11 = this.f3841d.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        r10.append((String) r11.next());
        if (r11.hasNext() == false) goto L4;
        r10.append(", ");
        goto L4
    L8:
        r10.append(')');
        String r12 = r10.toString();
        kotlin.jvm.internal.q.f(r12, "sb.toString()");
        return r12;
    }
}
