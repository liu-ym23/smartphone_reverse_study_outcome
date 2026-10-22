package C2;

import androidx.fragment.app.DialogInterfaceOnCancelListenerC0510e;
import androidx.fragment.app.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class f {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final x f605a;

        /* renamed from: b, reason: collision with root package name */
        private final List<Object> f606b;

        public void a(String str) {
            DialogInterfaceOnCancelListenerC0510e dialogInterfaceOnCancelListenerC0510e = (DialogInterfaceOnCancelListenerC0510e) this.f605a.g0(str);
            if (dialogInterfaceOnCancelListenerC0510e != null) {
                dialogInterfaceOnCancelListenerC0510e.X1();
            }
        }

        public void b(String str, Q1.d<DialogInterfaceOnCancelListenerC0510e> dVar) {
            if (((DialogInterfaceOnCancelListenerC0510e) this.f605a.g0(str)) == null) {
                dVar.get().h2(this.f605a, str);
            }
        }

        private a(x xVar) {
            this.f605a = xVar;
            this.f606b = new ArrayList();
        }
    }

    public static a a(x xVar) {
        return new a(xVar);
    }
}
