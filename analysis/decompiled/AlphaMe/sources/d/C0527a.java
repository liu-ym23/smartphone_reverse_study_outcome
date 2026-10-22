package d;

import K.C0092y;
import K.InterfaceC0071c;
import K.InterfaceC0088u;
import K.S;
import K.g0;
import K.z0;
import Z.i;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsetsController;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.appcompat.app.N;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0217o;
import androidx.appcompat.widget.H0;
import androidx.appcompat.widget.InterfaceC0194c0;
import androidx.appcompat.widget.a1;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.datastore.preferences.protobuf.AbstractC0247b;
import androidx.datastore.preferences.protobuf.AbstractC0259h;
import androidx.datastore.preferences.protobuf.AbstractC0268o;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.InterfaceC0262i0;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.airbnb.lottie.h;
import g0.InterfaceC0564d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import k.C0654h;
import k.C0661o;
import k.C0663q;
import k.InterfaceC0659m;
import k.InterfaceC0672z;
import k.RunnableC0653g;
import k.SubMenuC0646G;
import k.ViewOnKeyListenerC0655i;

/* renamed from: d.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0527a implements g0, H0, InterfaceC0071c, InterfaceC0672z, InterfaceC0659m, InterfaceC0194c0, InterfaceC0088u, InterfaceC0564d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12409a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12410b;

    public /* synthetic */ C0527a(int i4, Object obj) {
        this.f12409a = i4;
        this.f12410b = obj;
    }

    public final void A(int i4, InterfaceC0262i0 interfaceC0262i0, Object obj) {
        ((AbstractC0268o) this.f12410b).T(i4, (AbstractC0247b) obj, interfaceC0262i0);
    }

    public final void B(int i4, int i5) {
        ((AbstractC0268o) this.f12410b).N(i4, i5);
    }

    public final void C(int i4, long j4) {
        ((AbstractC0268o) this.f12410b).P(i4, j4);
    }

    public final void D(int i4, int i5) {
        ((AbstractC0268o) this.f12410b).Y(i4, (i5 >> 31) ^ (i5 << 1));
    }

    public final void E(int i4, long j4) {
        ((AbstractC0268o) this.f12410b).a0(i4, (j4 >> 63) ^ (j4 << 1));
    }

    public final void F(int i4, int i5) {
        ((AbstractC0268o) this.f12410b).Y(i4, i5);
    }

    public final void G(int i4, long j4) {
        ((AbstractC0268o) this.f12410b).a0(i4, j4);
    }

    @Override // androidx.appcompat.widget.H0
    public final void a(C0661o c0661o, C0663q c0663q) {
        ((ViewOnKeyListenerC0655i) this.f12410b).f13202g.removeCallbacksAndMessages(null);
        int size = ((ViewOnKeyListenerC0655i) this.f12410b).f13204i.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                i4 = -1;
                break;
            } else if (c0661o == ((C0654h) ((ViewOnKeyListenerC0655i) this.f12410b).f13204i.get(i4)).f13194b) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 == -1) {
            return;
        }
        int i5 = i4 + 1;
        ((ViewOnKeyListenerC0655i) this.f12410b).f13202g.postAtTime(new RunnableC0653g(0, this, i5 < ((ViewOnKeyListenerC0655i) this.f12410b).f13204i.size() ? (C0654h) ((ViewOnKeyListenerC0655i) this.f12410b).f13204i.get(i5) : null, c0663q, c0661o), c0661o, SystemClock.uptimeMillis() + 200);
    }

    @Override // k.InterfaceC0672z
    public final void b(C0661o c0661o, boolean z4) {
        if (c0661o instanceof SubMenuC0646G) {
            c0661o.k().c(false);
        }
        InterfaceC0672z interfaceC0672z = ((C0217o) this.f12410b).f3130e;
        if (interfaceC0672z != null) {
            interfaceC0672z.b(c0661o, z4);
        }
    }

    @Override // androidx.appcompat.widget.H0
    public final void c(C0661o c0661o, MenuItem menuItem) {
        ((ViewOnKeyListenerC0655i) this.f12410b).f13202g.removeCallbacksAndMessages(c0661o);
    }

    public void d(int i4) {
    }

    @Override // K.InterfaceC0088u
    public final z0 e(View view, z0 z0Var) {
        A.b bVar;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f12410b;
        if (!Objects.equals(coordinatorLayout.f3265o, z0Var)) {
            coordinatorLayout.f3265o = z0Var;
            boolean z4 = z0Var.d() > 0;
            coordinatorLayout.f3266p = z4;
            coordinatorLayout.setWillNotDraw(!z4 && coordinatorLayout.getBackground() == null);
            if (!z0Var.f1023a.j()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = coordinatorLayout.getChildAt(i4);
                    WeakHashMap weakHashMap = S.f939a;
                    if (childAt.getFitsSystemWindows() && (bVar = ((A.d) childAt.getLayoutParams()).f5a) != null) {
                        z0Var = bVar.onApplyWindowInsets(coordinatorLayout, childAt, z0Var);
                        if (z0Var.f1023a.j()) {
                            break;
                        }
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return z0Var;
    }

    @Override // k.InterfaceC0672z
    public final boolean f(C0661o c0661o) {
        Object obj = this.f12410b;
        if (c0661o == ((C0217o) obj).f3128c) {
            return false;
        }
        ((SubMenuC0646G) c0661o).f13161A.getClass();
        ((C0217o) obj).getClass();
        InterfaceC0672z interfaceC0672z = ((C0217o) this.f12410b).f3130e;
        if (interfaceC0672z != null) {
            return interfaceC0672z.f(c0661o);
        }
        return false;
    }

    @Override // g0.InterfaceC0564d
    public final void g() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // K.InterfaceC0071c
    public final void h() {
        C0661o c0661o = ((C0663q) this.f12410b).f13282n;
        c0661o.f13245h = true;
        c0661o.p(true);
    }

    @Override // k.InterfaceC0659m
    public final boolean i(C0661o c0661o, MenuItem menuItem) {
        Object obj = this.f12410b;
        return ((ActionMenuView) obj).f2786A != null && ((a1) ((ActionMenuView) obj).f2786A).f3052a.f2973G.a(menuItem);
    }

    @Override // g0.InterfaceC0564d
    public final void j(int i4, Object obj) {
        String str;
        switch (i4) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i4 == 6 || i4 == 7 || i4 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.f12410b).setResultCode(i4);
    }

    public void k(int i4) {
    }

    @Override // K.g0
    public final void l() {
        ((View) ((N) this.f12410b).f2562e.getParent()).invalidate();
    }

    public void m(int i4, float f4) {
    }

    @Override // k.InterfaceC0659m
    public final void n(C0661o c0661o) {
        InterfaceC0659m interfaceC0659m = ((ActionMenuView) this.f12410b).f2793v;
        if (interfaceC0659m != null) {
            interfaceC0659m.n(c0661o);
        }
    }

    public final long o() {
        return ((ByteBuffer) this.f12410b).getInt() & 4294967295L;
    }

    public final void p(int i4) {
        Object obj = this.f12410b;
        ((ByteBuffer) obj).position(((ByteBuffer) obj).position() + i4);
    }

    public final void q(int i4, boolean z4) {
        ((AbstractC0268o) this.f12410b).J(i4, z4);
    }

    public final void r(int i4, AbstractC0259h abstractC0259h) {
        ((AbstractC0268o) this.f12410b).L(i4, abstractC0259h);
    }

    public final void s(int i4, double d4) {
        AbstractC0268o abstractC0268o = (AbstractC0268o) this.f12410b;
        abstractC0268o.getClass();
        abstractC0268o.P(i4, Double.doubleToRawLongBits(d4));
    }

    public final void t(int i4, int i5) {
        ((AbstractC0268o) this.f12410b).R(i4, i5);
    }

    public final String toString() {
        switch (this.f12409a) {
            case 15:
                return "ContentInfoCompat{" + ((ContentInfo) this.f12410b) + "}";
            default:
                return super.toString();
        }
    }

    public final void u(int i4, int i5) {
        ((AbstractC0268o) this.f12410b).N(i4, i5);
    }

    public final void v(int i4, long j4) {
        ((AbstractC0268o) this.f12410b).P(i4, j4);
    }

    public final void w(float f4, int i4) {
        AbstractC0268o abstractC0268o = (AbstractC0268o) this.f12410b;
        abstractC0268o.getClass();
        abstractC0268o.N(i4, Float.floatToRawIntBits(f4));
    }

    public final void x(int i4, InterfaceC0262i0 interfaceC0262i0, Object obj) {
        AbstractC0268o abstractC0268o = (AbstractC0268o) this.f12410b;
        abstractC0268o.X(i4, 3);
        interfaceC0262i0.c((AbstractC0247b) obj, abstractC0268o.f3520c);
        abstractC0268o.X(i4, 4);
    }

    public final void y(int i4, int i5) {
        ((AbstractC0268o) this.f12410b).R(i4, i5);
    }

    public final void z(int i4, long j4) {
        ((AbstractC0268o) this.f12410b).a0(i4, j4);
    }

    public C0527a() {
        this.f12409a = 8;
        this.f12410b = new LinkedHashMap(0, 0.75f, true);
    }

    public C0527a(int i4) {
        this.f12409a = 12;
        this.f12410b = new ConcurrentHashMap();
    }

    public C0527a(View view) {
        this.f12409a = 16;
        C0092y c0092y = new C0092y(view);
        c0092y.f1017d = view;
        this.f12410b = c0092y;
    }

    public C0527a(AbstractC0268o abstractC0268o) {
        this.f12409a = 22;
        D.a(abstractC0268o, "output");
        this.f12410b = abstractC0268o;
        abstractC0268o.f3520c = this;
    }

    public C0527a(Context context) {
        this.f12409a = 21;
        this.f12410b = new OverScroller(context);
    }

    public C0527a(WindowInsetsController windowInsetsController) {
        this.f12409a = 16;
        C0092y c0092y = new C0092y(null);
        c0092y.f1018e = windowInsetsController;
        this.f12410b = c0092y;
    }

    public C0527a(TextView textView) {
        this.f12409a = 27;
        h.h(textView, "textView cannot be null");
        this.f12410b = new i(textView);
    }

    public C0527a(ByteBuffer byteBuffer) {
        this.f12409a = 26;
        this.f12410b = byteBuffer;
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
    }

    public C0527a(C.b bVar) {
        this.f12409a = 11;
        this.f12410b = bVar;
    }
}
