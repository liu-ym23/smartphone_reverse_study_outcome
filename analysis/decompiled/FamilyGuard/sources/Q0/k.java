package Q0;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import v0.ComponentCallbacks2C1180c;

@Deprecated
/* loaded from: classes.dex */
public class k extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private final Q0.a f4876a;

    /* renamed from: b, reason: collision with root package name */
    private final m f4877b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<k> f4878c;

    /* renamed from: d, reason: collision with root package name */
    private v0.j f4879d;

    /* renamed from: e, reason: collision with root package name */
    private k f4880e;

    /* renamed from: f, reason: collision with root package name */
    private Fragment f4881f;

    private class a implements m {
        a() {
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new Q0.a());
    }

    private void a(k kVar) {
        this.f4878c.add(kVar);
    }

    private Fragment c() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f4881f;
    }

    private void f(Activity activity) {
        j();
        k kVarG = ComponentCallbacks2C1180c.c(activity).k().g(activity);
        this.f4880e = kVarG;
        if (equals(kVarG)) {
            return;
        }
        this.f4880e.a(this);
    }

    private void g(k kVar) {
        this.f4878c.remove(kVar);
    }

    private void j() {
        k kVar = this.f4880e;
        if (kVar != null) {
            kVar.g(this);
            this.f4880e = null;
        }
    }

    Q0.a b() {
        return this.f4876a;
    }

    public v0.j d() {
        return this.f4879d;
    }

    public m e() {
        return this.f4877b;
    }

    void h(Fragment fragment) {
        this.f4881f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        f(fragment.getActivity());
    }

    public void i(v0.j jVar) {
        this.f4879d = jVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            f(activity);
        } catch (IllegalStateException e6) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e6);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f4876a.c();
        j();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        j();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f4876a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f4876a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + c() + "}";
    }

    k(Q0.a aVar) {
        this.f4877b = new a();
        this.f4878c = new HashSet();
        this.f4876a = aVar;
    }
}
