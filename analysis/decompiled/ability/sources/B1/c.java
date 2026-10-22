package B1;

import Va.A;
import Va.n;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.stepos.deepbinder.core.constant.Constants;
import java.util.HashMap;
import qa.C1856h;
import qa.InterfaceC1852d;
import qa.InterfaceC1855g;
import qa.L;
import stepos.support.v7.app.a0;
import stepos.support.v7.app.b0;
import stepos.support.v7.widget.K;

/* loaded from: classes2.dex */
public class c implements OnApplyWindowInsetsListener, InterfaceC1855g, K, A {
    public static c b;

    /* renamed from: a, reason: collision with root package name */
    public Object f180a;

    public /* synthetic */ c(Object obj) {
        this.f180a = obj;
    }

    public b a(int i, int i6, long j5) {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            return cVar.a(i, i6, j5);
        }
        return null;
    }

    public void b() {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            cVar.b();
        }
    }

    public void c(int i, int i6, long j5, byte[] bArr) {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            cVar.c(i, i6, j5, bArr);
        }
    }

    public void d(int i, int i6, e[] eVarArr, int i10, long j5) {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            cVar.d(i, i6, eVarArr, i10, j5);
        }
    }

    public void e(int i, e eVar, int i6, e eVar2, int i10, long j5) {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            cVar.e(i, eVar, i6, eVar2, i10, j5);
        }
    }

    @Override // Va.A
    public void f(n nVar, boolean z10) {
        a0 a0Var = ((b0) this.f180a).c;
        if (a0Var != null) {
            a0Var.onPanelClosed(0, nVar);
        }
    }

    public void g(int i, String str, long j5) {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            cVar.g(i, str, j5);
        }
    }

    public void h(e eVar, e eVar2, e eVar3, e eVar4, int i, int i6, int i10, long j5) {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            cVar.h(eVar, eVar2, eVar3, eVar4, i, i6, i10, j5);
        }
    }

    public void i(e eVar, String str, int i, long j5) {
        c cVar = (c) this.f180a;
        if (cVar != null) {
            cVar.i(eVar, str, i, j5);
        }
    }

    @Override // qa.InterfaceC1855g
    public void j(InterfaceC1852d interfaceC1852d, L l) {
        ((C1856h) this.f180a).complete(l);
    }

    public boolean k() {
        HashMap map = (HashMap) this.f180a;
        return (map == null || map.isEmpty() || TextUtils.isEmpty((CharSequence) map.get("process_name")) || TextUtils.isEmpty((CharSequence) map.get("crash_thread_name")) || TextUtils.isEmpty((CharSequence) map.get(Constants.PARAM_PID)) || TextUtils.isEmpty((CharSequence) map.get("tid")) || TextUtils.isEmpty((CharSequence) map.get("start_time")) || TextUtils.isEmpty((CharSequence) map.get("crash_time")) || TextUtils.isEmpty((CharSequence) map.get("signal_line"))) ? false : true;
    }

    public String l(Context context) {
        if (((V5.a) this.f180a) == null) {
            this.f180a = new V5.a(context, "com.stepos.statsapp.v3.umid");
        }
        String string = ((V5.a) this.f180a).f1385a.getString("UMID", "");
        W5.c.a("UmidFetcher", "getLocalUmId umId:" + string);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b2 A[Catch: JSONException -> 0x01f7, TryCatch #2 {JSONException -> 0x01f7, blocks: (B:54:0x01a0, B:57:0x01b2, B:60:0x01ca, B:62:0x01e4, B:63:0x01ed), top: B:72:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String m(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B1.c.m(android.content.Context):java.lang.String");
    }

    @Override // Va.A
    public boolean n(n nVar) {
        a0 a0Var;
        if (nVar != null || (a0Var = ((b0) this.f180a).c) == null) {
            return true;
        }
        a0Var.onMenuOpened(0, nVar);
        return true;
    }

    public void o(int i) throws Resources.NotFoundException {
        ((Application) this.f180a).getResources().getResourceName(i);
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        AppBarLayout appBarLayout = (AppBarLayout) this.f180a;
        WindowInsetsCompat windowInsetsCompat2 = appBarLayout.getFitsSystemWindows() ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(appBarLayout.g, windowInsetsCompat2)) {
            appBarLayout.g = windowInsetsCompat2;
            appBarLayout.setWillNotDraw(!(appBarLayout.f2281x != null && appBarLayout.getTopInset() > 0));
            appBarLayout.requestLayout();
        }
        return windowInsetsCompat;
    }

    @Override // qa.InterfaceC1855g
    public void r(InterfaceC1852d interfaceC1852d, Throwable th) {
        ((C1856h) this.f180a).completeExceptionally(th);
    }
}
