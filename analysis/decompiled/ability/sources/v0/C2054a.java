package v0;

import A.b;
import H.h;
import W8.i;
import X8.w;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.apm.insight.ApmInsight;
import com.bytedance.apm.insight.IDynamicParams;
import com.stepos.ability.R;
import e2.C1404a;
import g9.InterfaceC1474a;
import h8.InterfaceC1522e;
import h8.InterfaceC1524g;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.KotlinNullPointerException;
import kotlin.jvm.internal.k;
import m9.C1718k;
import o0.RunnableC1754a;
import org.json.JSONObject;
import qa.C1865q;
import qa.InterfaceC1852d;
import qa.InterfaceC1855g;
import qa.L;
import retrofit2.HttpException;
import stepos.support.v7.app.AbstractC1975y;
import stepos.support.v7.app.e0;
import stepos.support.v7.widget.ActionBarContextView;
import stepos.support.v7.widget.I0;
import u1.d;
import u8.j;
import z.AbstractC2152a;

/* renamed from: v0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2054a implements InterfaceC1474a, L.a, InterfaceC1855g, OnApplyWindowInsetsListener, ViewPropertyAnimatorUpdateListener, b {
    public static volatile C2054a b;

    /* renamed from: a, reason: collision with root package name */
    public Object f6763a;

    public /* synthetic */ C2054a(Object obj) {
        this.f6763a = obj;
    }

    public static C2054a d() {
        if (b == null) {
            synchronized (C2054a.class) {
                try {
                    if (b == null) {
                        C2054a c2054a = new C2054a();
                        c2054a.f6763a = new CopyOnWriteArraySet();
                        b = c2054a;
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Override // L.a
    public String a() {
        IDynamicParams iDynamicParams = ((RunnableC1754a) this.f6763a).d;
        return iDynamicParams != null ? iDynamicParams.getAbSdkVersion() : "";
    }

    @Override // L.a
    public String b() {
        IDynamicParams iDynamicParams = ((RunnableC1754a) this.f6763a).d;
        return iDynamicParams != null ? iDynamicParams.getUserUniqueID() : "";
    }

    @Override // L.a
    public String c() {
        IDynamicParams iDynamicParams = ((RunnableC1754a) this.f6763a).d;
        return iDynamicParams != null ? iDynamicParams.getSsid() : "";
    }

    @Override // A.b
    public void e(long j5) {
        ((ConcurrentHashMap) ((d) this.f6763a).b).put(cc.dd.aa.cc.cc.b.f2129a, Long.valueOf(j5));
    }

    public void f(String str, JSONObject jSONObject) {
        ArrayList arrayList = (ArrayList) this.f6763a;
        if (S0.b.r0(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        d dVar = AbstractC2152a.f6923a;
        H2.a aVar = new H2.a(jSONObject, str, arrayList2);
        dVar.getClass();
        try {
            dVar.h(aVar).b(aVar);
        } catch (Throwable unused) {
        }
    }

    @Override // L.a
    public String getDid() {
        RunnableC1754a runnableC1754a = (RunnableC1754a) this.f6763a;
        IDynamicParams iDynamicParams = runnableC1754a.d;
        if (iDynamicParams == null) {
            ApmInsight apmInsight = runnableC1754a.e;
            String aid = runnableC1754a.b.getAid();
            apmInsight.getClass();
            return C1404a.c(aid) != null ? C1404a.c(aid).b() : "";
        }
        if (!TextUtils.isEmpty(iDynamicParams.getDid())) {
            return runnableC1754a.d.getDid();
        }
        ApmInsight apmInsight2 = runnableC1754a.e;
        String aid2 = runnableC1754a.b.getAid();
        apmInsight2.getClass();
        return C1404a.c(aid2) != null ? C1404a.c(aid2).b() : "";
    }

    @Override // L.a
    public String getUserId() {
        IDynamicParams iDynamicParams = ((RunnableC1754a) this.f6763a).d;
        String userId = iDynamicParams != null ? iDynamicParams.getUserId() : "";
        try {
            h.b("user_id", userId);
        } catch (Exception unused) {
        }
        return userId;
    }

    @Override // qa.InterfaceC1855g
    public void j(InterfaceC1852d interfaceC1852d, L l) {
        C1718k c1718k = (C1718k) this.f6763a;
        if (!l.f5644a.c()) {
            c1718k.resumeWith(kotlin.b.a(new HttpException(l)));
            return;
        }
        Object obj = l.b;
        if (obj != null) {
            c1718k.resumeWith(obj);
            return;
        }
        Object objCast = C1865q.class.cast(interfaceC1852d.i().e.get(C1865q.class));
        k.c(objCast);
        C1865q c1865q = (C1865q) objCast;
        c1718k.resumeWith(kotlin.b.a(new KotlinNullPointerException("Response from " + c1865q.f5658a.getName() + '.' + c1865q.c.getName() + " was null but response body type was declared as non-null")));
    }

    @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
    public void onAnimationUpdate(View view) {
        ((View) ((e0) this.f6763a).d.getParent()).invalidate();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i;
        boolean z10;
        boolean z11;
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        AbstractC1975y abstractC1975y = (AbstractC1975y) this.f6763a;
        Context context = abstractC1975y.f6316a;
        ActionBarContextView actionBarContextView = abstractC1975y.u;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i = systemWindowInsetTop;
            z10 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) abstractC1975y.u.getLayoutParams();
            if (abstractC1975y.u.isShown()) {
                if (abstractC1975y.f6357Q == null) {
                    abstractC1975y.f6357Q = new Rect();
                    abstractC1975y.f6358R = new Rect();
                }
                Rect rect = abstractC1975y.f6357Q;
                Rect rect2 = abstractC1975y.f6358R;
                rect.set(0, systemWindowInsetTop, 0, 0);
                ViewGroup viewGroup = abstractC1975y.f6369z;
                Method method = I0.f6469a;
                if (method != null) {
                    try {
                        ((Boolean) method.invoke(viewGroup, rect, rect2)).getClass();
                    } catch (Exception e) {
                        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                    }
                }
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? systemWindowInsetTop : 0)) {
                    marginLayoutParams.topMargin = systemWindowInsetTop;
                    View view2 = abstractC1975y.f6347B;
                    if (view2 == null) {
                        View view3 = new View(context);
                        abstractC1975y.f6347B = view3;
                        view3.setBackgroundColor(context.getResources().getColor(R.color.stepos_background_light));
                        abstractC1975y.f6369z.addView(abstractC1975y.f6347B, -1, new ViewGroup.LayoutParams(-1, systemWindowInsetTop));
                    } else {
                        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                        if (layoutParams.height != systemWindowInsetTop) {
                            layoutParams.height = systemWindowInsetTop;
                            abstractC1975y.f6347B.setLayoutParams(layoutParams);
                        }
                    }
                    z11 = true;
                } else {
                    z11 = false;
                }
                z = abstractC1975y.f6347B != null;
                i = (abstractC1975y.f6317j || !z) ? systemWindowInsetTop : 0;
                boolean z12 = z;
                z = z11;
                z10 = z12;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i = systemWindowInsetTop;
                z10 = false;
            } else {
                i = systemWindowInsetTop;
                z10 = false;
                z = false;
            }
            if (z) {
                abstractC1975y.u.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = abstractC1975y.f6347B;
        if (view4 != null) {
            view4.setVisibility(z10 ? 0 : 8);
        }
        if (systemWindowInsetTop != i) {
            windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), i, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        }
        return ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
    }

    @Override // qa.InterfaceC1855g
    public void r(InterfaceC1852d interfaceC1852d, Throwable th) {
        ((C1718k) this.f6763a).resumeWith(kotlin.b.a(th));
    }

    public C2054a(Application application) {
        if (((SharedPreferences) this.f6763a) == null) {
            synchronized (this) {
                try {
                    if (((SharedPreferences) this.f6763a) == null) {
                        this.f6763a = application.getSharedPreferences("monitor_downgrade", 0);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // g9.InterfaceC1474a
    public Iterable c(Object obj) {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.b bVar = (kotlin.reflect.jvm.internal.impl.builtins.jvm.b) this.f6763a;
        Collection collectionE = ((InterfaceC1522e) obj).m().e();
        k.e(collectionE, "getSupertypes(...)");
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionE.iterator();
        while (it.hasNext()) {
            InterfaceC1524g interfaceC1524gD = ((w) it.next()).Q().d();
            j jVarF = null;
            InterfaceC1524g interfaceC1524gA = interfaceC1524gD != null ? interfaceC1524gD.a() : null;
            InterfaceC1522e interfaceC1522e = interfaceC1524gA instanceof InterfaceC1522e ? (InterfaceC1522e) interfaceC1524gA : null;
            if (interfaceC1522e != null && (jVarF = bVar.f(interfaceC1522e)) == null) {
                jVarF = interfaceC1522e;
            }
            if (jVarF != null) {
                arrayList.add(jVarF);
            }
        }
        return arrayList;
    }

    public C2054a(i iVar, Iterable samWithReceiverResolvers) {
        k.f(samWithReceiverResolvers, "samWithReceiverResolvers");
        this.f6763a = samWithReceiverResolvers;
        String str = i.d;
        new ConcurrentHashMap(3, 1.0f, 2);
    }

    public C2054a(int i) {
        switch (i) {
            case 11:
                this.f6763a = new ConcurrentHashMap();
                break;
            default:
                this.f6763a = new LinkedHashMap();
                break;
        }
    }
}
