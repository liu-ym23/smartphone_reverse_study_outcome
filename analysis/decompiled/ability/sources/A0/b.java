package A0;

import H4.o;
import H8.AbstractC0244e;
import H8.w;
import Va.A;
import Va.n;
import a.AbstractC0291a;
import a5.k;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.core.os.EnvironmentCompat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stepos.common.widget.SimpleAdaptiveTextView;
import com.volcengine.tos.TosClientException;
import com.volcengine.tos.TosServerException;
import com.volcengine.tos.UnexpectedStatusCodeException;
import com.volcengine.tos.internal.TosResponse;
import g1.AbstractC1451a;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import m9.C1718k;
import org.json.JSONObject;
import qa.InterfaceC1852d;
import qa.InterfaceC1855g;
import qa.L;
import stepos.support.v7.app.AbstractC1975y;
import stepos.support.v7.app.C1974x;

/* loaded from: classes2.dex */
public final class b implements B0.b, k, InterfaceC1855g, A, A.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f68a;
    public Object b;

    public /* synthetic */ b(Object obj, int i) {
        this.f68a = i;
        this.b = obj;
    }

    public static void u(int i, String str, String str2) {
        if (!AbstractC0291a.y(str)) {
            if (i == 404) {
                throw new TosServerException(i, "NotFound", "", str2, "");
            }
            if (i != 403) {
                throw new TosServerException(i, "", "", str2, "");
            }
            throw new TosServerException(i, "Forbidden", "", str2, "");
        }
        try {
            if (a7.f.b.readValue(str, new X6.e()) == null) {
                throw null;
            }
            throw new ClassCastException();
        } catch (JsonProcessingException unused) {
            if (i != 400) {
                throw new TosClientException(B7.a.k("tos: parse server exception failed", str), null);
            }
            throw new TosClientException(B7.a.k("tos: bad request", str), null);
        }
    }

    public static void v(TosResponse tosResponse) throws IOException {
        if (tosResponse.f4236a < 300) {
            return;
        }
        u(tosResponse.f4236a, AbstractC0291a.I(tosResponse.d, "response body"), tosResponse.f());
        throw null;
    }

    @Override // B0.b
    public void a() {
        ((B0.b) this.b).a();
    }

    @Override // B0.b
    public void b(String str) {
        ((B0.b) this.b).b(str);
    }

    @Override // B0.b
    public Map c(String str) {
        return ((B0.b) this.b).c(str);
    }

    @Override // B0.b
    public void clear() {
        ((B0.b) this.b).clear();
    }

    @Override // B0.b
    public Map d() {
        return ((B0.b) this.b).d();
    }

    @Override // A.b
    public void e(long j5) {
        ((ConcurrentHashMap) ((u1.d) this.b).b).put(cc.dd.aa.cc.cc.b.b, Long.valueOf(j5));
    }

    @Override // B0.b
    public Map f() {
        return ((B0.b) this.b).f();
    }

    @Override // B0.b
    public Map g() {
        return ((B0.b) this.b).g();
    }

    @Override // B0.b
    public Map h() {
        return ((B0.b) this.b).h();
    }

    @Override // a5.k
    public void i(TextView textView, int i, int i6) {
        SimpleAdaptiveTextView.a((SimpleAdaptiveTextView) this.b, i, i6);
    }

    @Override // qa.InterfaceC1855g
    public void j(InterfaceC1852d interfaceC1852d, L l) {
        ((C1718k) this.b).resumeWith(l);
    }

    @Override // B0.b
    public void k(long j5, String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2) {
        if (H.h.b) {
            o.r("APM-Traffic-Detail", "BizTrafficStats.trafficStats " + j5 + ", " + str + ", " + str2);
        }
        ((B0.b) this.b).k(j5, str, str2, str3, jSONObject, jSONObject2);
    }

    @Override // B0.b
    public void l(String str) {
        ((B0.b) this.b).l(str);
    }

    @Override // B0.b
    public void m(double d) {
        ((B0.b) this.b).m(d);
    }

    @Override // Va.A
    public boolean n(n nVar) {
        Window.Callback callback;
        AbstractC1975y abstractC1975y = (AbstractC1975y) this.b;
        if (nVar != null || !abstractC1975y.h || (callback = abstractC1975y.b.getCallback()) == null || abstractC1975y.o) {
            return true;
        }
        callback.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, nVar);
        return true;
    }

    @Override // B0.b
    public void o(double d) {
        ((B0.b) this.b).o(d);
    }

    @Override // a5.k
    public void p(TextView textView, float f) {
        SimpleAdaptiveTextView.b((SimpleAdaptiveTextView) this.b, f);
    }

    @Override // B0.b
    public Map q() {
        return ((B0.b) this.b).q();
    }

    @Override // qa.InterfaceC1855g
    public void r(InterfaceC1852d interfaceC1852d, Throwable th) {
        ((C1718k) this.b).resumeWith(kotlin.b.a(th));
    }

    @Override // B0.b
    public void s(String str, JSONObject jSONObject) {
        ((B0.b) this.b).s(str, jSONObject);
    }

    public Q.a t() {
        String strReplace;
        boolean zBooleanValue;
        String strReplace2;
        String str;
        Q.a aVar = new Q.a(4);
        aVar.b = new HashMap();
        String strReplace3 = Build.MODEL;
        aVar.b("device", !TextUtils.isEmpty(strReplace3) ? strReplace3.replace("\n", "").replace("\r", "") : strReplace3);
        if (!TextUtils.isEmpty(strReplace3)) {
            strReplace3 = strReplace3.replace("\n", "").replace("\r", "");
        }
        aVar.b("product_model", strReplace3);
        if (TextUtils.isEmpty(T5.b.c)) {
            T5.b.c = AbstractC0291a.u("ro.build.mask.id");
        }
        String strReplace4 = T5.b.c;
        if (!TextUtils.isEmpty(strReplace4)) {
            strReplace4 = strReplace4.replace("\n", "").replace("\r", "");
        }
        aVar.b("build_mask", strReplace4);
        aVar.b("os_type", AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME);
        if (TextUtils.isEmpty(T5.b.e)) {
            String strV = AbstractC0291a.v("ro.product.other.brand", EnvironmentCompat.MEDIA_UNKNOWN);
            if (EnvironmentCompat.MEDIA_UNKNOWN.equals(strV)) {
                T5.b.e = Build.BRAND;
            } else {
                T5.b.e = strV;
            }
            strReplace = T5.b.e;
        } else {
            strReplace = T5.b.e;
        }
        if (!TextUtils.isEmpty(strReplace)) {
            strReplace = strReplace.replace("\n", "").replace("\r", "");
        }
        aVar.b("brand", strReplace);
        String strReplace5 = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(strReplace5)) {
            strReplace5 = strReplace5.replace("\n", "").replace("\r", "");
        }
        aVar.b("os_version", strReplace5);
        aVar.b("os", "StepOS");
        if (T5.b.f1209j != null) {
            W5.c.a("StepOSUtils", "isInternational = " + T5.b.f1209j);
            zBooleanValue = T5.b.f1209j.booleanValue();
        } else {
            try {
                T5.b.f1209j = Boolean.valueOf(("zh".equalsIgnoreCase(AbstractC0291a.u("ro.product.locale.language")) && "CN".equalsIgnoreCase(AbstractC0291a.u("ro.product.locale.region")) && !"zh-CN".equalsIgnoreCase(AbstractC0291a.u("ro.product.locale"))) ? false : true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            zBooleanValue = T5.b.f1209j.booleanValue();
        }
        ((HashMap) aVar.b).put("international", Boolean.valueOf(zBooleanValue));
        W5.c.d("DeviceInfo", "setDevicePersonalInfo start");
        aVar.b("imsi1", "");
        aVar.b("imsi2", "");
        aVar.b("andro_id", "");
        aVar.b("android_ad_id", "");
        aVar.b("mac_address", "");
        ((HashMap) aVar.b).put("root", Boolean.FALSE);
        aVar.b("udid", "");
        aVar.b("oaid", AbstractC1451a.H());
        aVar.b("vaid", "");
        aVar.b("aaid", "");
        Context context = (Context) this.b;
        if (context != null) {
            if (TextUtils.isEmpty(T5.b.f)) {
                try {
                    if (context.getResources().getConfiguration() != null && context.getResources().getConfiguration().locale != null) {
                        T5.b.f = context.getResources().getConfiguration().locale.getCountry();
                    }
                } catch (Exception e6) {
                    W5.c.b("StepOSUtils", "Exception: " + e6.getMessage() + " - Cause: " + e6.getCause());
                }
                strReplace2 = T5.b.f;
            } else {
                strReplace2 = T5.b.f;
            }
            if (!TextUtils.isEmpty(strReplace2)) {
                strReplace2 = strReplace2.replace("\n", "").replace("\r", "");
            }
            aVar.b("country", strReplace2);
            Context context2 = (Context) this.b;
            if (TextUtils.isEmpty(T5.b.d)) {
                try {
                    DisplayManager displayManager = (DisplayManager) context2.getSystemService("display");
                    Display display = displayManager != null ? displayManager.getDisplay(0) : null;
                    if (display != null) {
                        Point point = new Point();
                        display.getRealSize(point);
                        int i = point.x;
                        int i6 = point.y;
                        if (i > 0 && i6 > 0) {
                            T5.b.d = i + "." + i6;
                        }
                    }
                } catch (Exception e9) {
                    W5.c.b("StepOSUtils", "getDisplaySize error, " + e9.getMessage());
                }
                str = T5.b.d;
            } else {
                str = T5.b.d;
            }
            aVar.b("sre", str);
            ((HashMap) aVar.b).put("ter_type", 1);
        }
        W5.c.e("DeviceInfo", "DeviceInfo created successfully.");
        return aVar;
    }

    public String toString() {
        switch (this.f68a) {
            case 5:
                return (String) this.b;
            default:
                return super.toString();
        }
    }

    public void w(AbstractC0244e abstractC0244e) {
        if (!abstractC0244e.h()) {
            if (!(abstractC0244e instanceof w)) {
                String strValueOf = String.valueOf(abstractC0244e.getClass());
                throw new IllegalArgumentException(B7.a.q(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
            }
            w wVar = (w) abstractC0244e;
            w(wVar.c);
            w(wVar.d);
            return;
        }
        int size = abstractC0244e.size();
        int[] iArr = w.h;
        int iBinarySearch = Arrays.binarySearch(iArr, size);
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int i = iArr[iBinarySearch + 1];
        Stack stack = (Stack) this.b;
        if (stack.isEmpty() || ((AbstractC0244e) stack.peek()).size() >= i) {
            stack.push(abstractC0244e);
            return;
        }
        int i6 = iArr[iBinarySearch];
        AbstractC0244e wVar2 = (AbstractC0244e) stack.pop();
        while (!stack.isEmpty() && ((AbstractC0244e) stack.peek()).size() < i6) {
            wVar2 = new w((AbstractC0244e) stack.pop(), wVar2);
        }
        w wVar3 = new w(wVar2, abstractC0244e);
        while (!stack.isEmpty()) {
            int[] iArr2 = w.h;
            int iBinarySearch2 = Arrays.binarySearch(iArr2, wVar3.b);
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (((AbstractC0244e) stack.peek()).size() >= iArr2[iBinarySearch2 + 1]) {
                break;
            } else {
                wVar3 = new w((AbstractC0244e) stack.pop(), wVar3);
            }
        }
        stack.push(wVar3);
    }

    public TosResponse x(X6.n nVar) throws IOException {
        InputStream inputStream;
        try {
            try {
                TosResponse tosResponseK = ((B1.b) this.b).k(nVar);
                if (inputStream != null) {
                    try {
                        return tosResponseK;
                    } catch (IOException e) {
                    }
                }
                return tosResponseK;
            } catch (IOException e6) {
                throw new TosClientException("tos: request exception", e6);
            }
        } finally {
            inputStream = nVar.k;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    a7.f.e.j(e9.toString(), "tos: close request body failed, {}");
                }
            }
        }
    }

    public TosResponse y(X6.n nVar, ArrayList arrayList) throws IOException {
        TosResponse tosResponseX = x(nVar);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (tosResponseX.f4236a == ((Integer) it.next()).intValue()) {
                return tosResponseX;
            }
        }
        v(tosResponseX);
        int i = tosResponseX.f4236a;
        String strF = tosResponseX.f();
        UnexpectedStatusCodeException unexpectedStatusCodeException = new UnexpectedStatusCodeException();
        ArrayList arrayList2 = new ArrayList();
        unexpectedStatusCodeException.b = arrayList2;
        unexpectedStatusCodeException.f4217a = i;
        arrayList2.addAll(arrayList);
        unexpectedStatusCodeException.c = strF;
        throw unexpectedStatusCodeException;
    }

    public Object z(X6.n nVar, int i, X6.a aVar) {
        try {
            TosResponse tosResponseX = x(nVar);
            try {
                if (tosResponseX.f4236a != i) {
                    v(tosResponseX);
                    throw new UnexpectedStatusCodeException(tosResponseX.f4236a, i, tosResponseX.f());
                }
                Object objC = aVar.c(tosResponseX);
                tosResponseX.close();
                return objC;
            } finally {
            }
        } catch (IOException e) {
            throw new TosClientException("tos: close body failed", e);
        }
    }

    public b(int i) {
        this.f68a = i;
        switch (i) {
            case 1:
                this.b = new Stack();
                break;
            case 2:
                this.b = null;
                break;
            case 9:
                break;
            default:
                if (!H.h.g()) {
                    this.b = new B0.f(0);
                    break;
                } else {
                    B0.d dVar = new B0.d();
                    dVar.i = 0L;
                    dVar.k = 102400.0d;
                    dVar.l = new B0.c(dVar, 0);
                    this.b = dVar;
                    break;
                }
        }
    }

    @Override // B0.b
    public long b() {
        return ((B0.b) this.b).b();
    }

    @Override // B0.b
    public Map c() {
        return ((B0.b) this.b).c();
    }

    @Override // Va.A
    public void f(n nVar, boolean z10) {
        C1974x c1974x;
        AbstractC1975y abstractC1975y = (AbstractC1975y) this.b;
        n nVarK = nVar.k();
        int i = 0;
        boolean z11 = nVarK != nVar;
        if (z11) {
            nVar = nVarK;
        }
        C1974x[] c1974xArr = abstractC1975y.f6350F;
        int length = c1974xArr != null ? c1974xArr.length : 0;
        while (true) {
            if (i < length) {
                c1974x = c1974xArr[i];
                if (c1974x != null && c1974x.h == nVar) {
                    break;
                } else {
                    i++;
                }
            } else {
                c1974x = null;
                break;
            }
        }
        if (c1974x != null) {
            if (!z11) {
                abstractC1975y.s(c1974x, z10);
            } else {
                abstractC1975y.q(c1974x.f6343a, c1974x, nVarK);
                abstractC1975y.s(c1974x, true);
            }
        }
    }

    @Override // B0.b
    public void c(JSONObject jSONObject) {
        ((B0.b) this.b).c(jSONObject);
    }
}
