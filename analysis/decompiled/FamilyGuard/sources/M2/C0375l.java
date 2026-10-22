package M2;

import L2.e;
import L2.j;
import android.content.Context;
import android.util.Log;
import android.view.View;

/* renamed from: M2.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0375l implements K2.B<C0378o> {

    /* renamed from: b, reason: collision with root package name */
    private static final a f4067b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f4068a = "blur";

    /* renamed from: M2.l$a */
    private static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    @Override // K2.B
    public boolean a(Context context) {
        j4.k.g(context, "context");
        return true;
    }

    @Override // K2.B
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public K2.s c(View view, C0378o c0378o) {
        j4.k.g(view, "view");
        j4.k.g(c0378o, "params");
        if (c0378o.b()) {
            e.c cVarF = L2.e.f3817a.f(view);
            if (cVarF != null) {
                V v5 = new V(cVarF);
                v5.c(c0378o);
                return v5;
            }
            Log.i("MotionKitBlur", "自研玻璃不可用，兜底为 tint 背景");
            b0 b0Var = new b0(view);
            b0Var.b(c0378o);
            return b0Var;
        }
        L2.j jVar = L2.j.f3840a;
        j.c cVarM = jVar.v() ? jVar.m(view) : null;
        if (cVarM != null) {
            H h5 = new H(cVarM);
            h5.c(c0378o);
            return h5;
        }
        Log.i("MotionKitBlur", "窗口内玻璃不可用，兜底为 tint 背景");
        b0 b0Var2 = new b0(view);
        b0Var2.b(c0378o);
        return b0Var2;
    }

    @Override // K2.B
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0378o b() {
        return new C0378o();
    }

    @Override // K2.B
    public String getId() {
        return this.f4068a;
    }
}
