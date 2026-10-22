package stepos.support.v7.app.palette;

import ad.t;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.e1;
import com.google.gson.JsonIOException;
import com.stepos.aiengine.R;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.tonyodev.fetch2.database.DownloadInfo;
import f5.g;
import f5.m;
import gc.o;
import gc.q;
import hb.h;
import i2.k;
import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Response;
import stepos.support.v7.app.AppCompatDelegateImplV7;
import stepos.support.v7.widget.g0;
import uc.l;
import v0.e0;
import v0.h0;
import v0.m0;
import v0.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements r, h, g, xd.d {

    /* renamed from: i, reason: collision with root package name */
    public static b f12249i;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f12250g;
    public Object h;

    public /* synthetic */ b(Object obj, int i10) {
        this.f12250g = i10;
        this.h = obj;
    }

    public static final o8.f e(b bVar, Response response) throws FileStorageException.TosPutFailed {
        int i10 = response.f10891d;
        t tVar = response.f10893j;
        String strC = tVar != null ? tVar.C() : null;
        if (strC == null) {
            strC = "";
        }
        if (200 > i10 || i10 >= 300) {
            throw new FileStorageException.TosPutFailed(i10, a0.a.g("TOS PUT HTTP ", i10, ": ", gc.r.R0(256, strC)), null);
        }
        if (q.t0(strC)) {
            return new o8.f();
        }
        try {
            l lVar = n8.d.f10653a;
            lVar.getClass();
            return (o8.f) lVar.a(strC, o8.f.Companion.serializer());
        } catch (Throwable th) {
            throw new FileStorageException.TosPutFailed(i10, "TOS PUT response not parseable: ".concat(gc.r.R0(256, strC)), th);
        }
    }

    public static synchronized b h() {
        try {
            if (f12249i == null) {
                f12249i = new b(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f12249i;
    }

    @Override // xd.d
    public void a(xd.b bVar, Throwable th) {
        ((CancellableContinuationImpl) this.h).resumeWith(kotlin.c.a(th));
    }

    @Override // xd.d
    public void b(xd.b bVar, xd.r rVar) {
        ((CancellableContinuationImpl) this.h).resumeWith(rVar);
    }

    @Override // f5.g
    public Object c() {
        switch (this.f12250g) {
            case 7:
                Class cls = (Class) this.h;
                try {
                    return m.f8759a.a(cls);
                } catch (Exception e10) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
                }
            default:
                Type type = (Type) this.h;
                if (!(type instanceof ParameterizedType)) {
                    throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                }
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
    }

    @Override // hb.h
    public boolean d() {
        switch (this.f12250g) {
            case 3:
                return ((bb.c) this.h).f3184m;
            default:
                return ((bb.d) this.h).f3203l;
        }
    }

    public void f() {
        File[] fileArrListFiles;
        File file = (File) this.h;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    kotlin.jvm.internal.g.c(name);
                    boolean z = o.k0(name, "marker_", false) && o.e0(name, ".txt", false);
                    boolean z3 = o.k0(name, "dmp_", false) && o.e0(name, ".bin", false);
                    if (z || z3) {
                        try {
                            file2.delete();
                        } catch (Throwable th) {
                            kotlin.c.a(th);
                        }
                    }
                }
            }
        }
    }

    @Override // v0.r
    public m0 g(View view, m0 m0Var) {
        boolean z;
        boolean z3;
        boolean z10;
        int i10;
        boolean z11;
        boolean z12;
        boolean z13;
        switch (this.f12250g) {
            case 1:
                int iD = m0Var.d();
                AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) this.h;
                Context context = appCompatDelegateImpl.f271n;
                int iD2 = m0Var.d();
                ActionBarContextView actionBarContextView = appCompatDelegateImpl.f281y;
                if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    z = false;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.f281y.getLayoutParams();
                    if (appCompatDelegateImpl.f281y.isShown()) {
                        if (appCompatDelegateImpl.f265g0 == null) {
                            appCompatDelegateImpl.f265g0 = new Rect();
                            appCompatDelegateImpl.f266h0 = new Rect();
                        }
                        Rect rect = appCompatDelegateImpl.f265g0;
                        Rect rect2 = appCompatDelegateImpl.f266h0;
                        rect.set(m0Var.b(), m0Var.d(), m0Var.c(), m0Var.a());
                        e1.a(appCompatDelegateImpl.E, rect, rect2);
                        int i11 = rect.top;
                        int i12 = rect.left;
                        int i13 = rect.right;
                        ViewGroup viewGroup = appCompatDelegateImpl.E;
                        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                        m0 m0VarA = e0.e.a(viewGroup);
                        int iB = m0VarA == null ? 0 : m0VarA.b();
                        int iC = m0VarA == null ? 0 : m0VarA.c();
                        if (marginLayoutParams.topMargin == i11 && marginLayoutParams.leftMargin == i12 && marginLayoutParams.rightMargin == i13) {
                            z10 = false;
                        } else {
                            marginLayoutParams.topMargin = i11;
                            marginLayoutParams.leftMargin = i12;
                            marginLayoutParams.rightMargin = i13;
                            z10 = true;
                        }
                        if (i11 <= 0 || appCompatDelegateImpl.G != null) {
                            View view2 = appCompatDelegateImpl.G;
                            if (view2 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                                int i14 = marginLayoutParams2.height;
                                int i15 = marginLayoutParams.topMargin;
                                if (i14 != i15 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                                    marginLayoutParams2.height = i15;
                                    marginLayoutParams2.leftMargin = iB;
                                    marginLayoutParams2.rightMargin = iC;
                                    appCompatDelegateImpl.G.setLayoutParams(marginLayoutParams2);
                                }
                            }
                        } else {
                            View view3 = new View(context);
                            appCompatDelegateImpl.G = view3;
                            view3.setVisibility(8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                            layoutParams.leftMargin = iB;
                            layoutParams.rightMargin = iC;
                            appCompatDelegateImpl.E.addView(appCompatDelegateImpl.G, -1, layoutParams);
                        }
                        View view4 = appCompatDelegateImpl.G;
                        z = view4 != null;
                        if (z && view4.getVisibility() != 0) {
                            View view5 = appCompatDelegateImpl.G;
                            view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? context.getColor(R.color.abc_decor_view_status_guard_light) : context.getColor(R.color.abc_decor_view_status_guard));
                        }
                        if (!appCompatDelegateImpl.L && z) {
                            iD2 = 0;
                        }
                        z3 = z10;
                    } else if (marginLayoutParams.topMargin != 0) {
                        marginLayoutParams.topMargin = 0;
                        z = false;
                        z3 = true;
                    } else {
                        z3 = false;
                        z = false;
                    }
                    if (z3) {
                        appCompatDelegateImpl.f281y.setLayoutParams(marginLayoutParams);
                    }
                }
                View view6 = appCompatDelegateImpl.G;
                if (view6 != null) {
                    view6.setVisibility(z ? 0 : 8);
                }
                return e0.f(view, iD != iD2 ? m0Var.f(m0Var.b(), iD2, m0Var.c(), m0Var.a()) : m0Var);
            default:
                int iD3 = m0Var.d();
                AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) this.h;
                Context context2 = appCompatDelegateImplV7.f12125a;
                stepos.support.v7.widget.ActionBarContextView actionBarContextView2 = appCompatDelegateImplV7.f11993u;
                if (actionBarContextView2 == null || !(actionBarContextView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    i10 = iD3;
                    z11 = false;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) appCompatDelegateImplV7.f11993u.getLayoutParams();
                    if (appCompatDelegateImplV7.f11993u.isShown()) {
                        if (appCompatDelegateImplV7.M == null) {
                            appCompatDelegateImplV7.M = new Rect();
                            appCompatDelegateImplV7.N = new Rect();
                        }
                        Rect rect3 = appCompatDelegateImplV7.M;
                        Rect rect4 = appCompatDelegateImplV7.N;
                        rect3.set(0, iD3, 0, 0);
                        ViewGroup viewGroup2 = appCompatDelegateImplV7.z;
                        Method method = g0.f12796a;
                        if (method != null) {
                            try {
                                ((Boolean) method.invoke(viewGroup2, rect3, rect4)).getClass();
                            } catch (Exception e10) {
                                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e10);
                            }
                        }
                        if (marginLayoutParams3.topMargin != (rect4.top == 0 ? iD3 : 0)) {
                            marginLayoutParams3.topMargin = iD3;
                            View view7 = appCompatDelegateImplV7.B;
                            if (view7 == null) {
                                View view8 = new View(context2);
                                appCompatDelegateImplV7.B = view8;
                                view8.setBackgroundColor(context2.getResources().getColor(R.color.stepos_background_light));
                                appCompatDelegateImplV7.z.addView(appCompatDelegateImplV7.B, -1, new ViewGroup.LayoutParams(-1, iD3));
                            } else {
                                ViewGroup.LayoutParams layoutParams2 = view7.getLayoutParams();
                                if (layoutParams2.height != iD3) {
                                    layoutParams2.height = iD3;
                                    appCompatDelegateImplV7.B.setLayoutParams(layoutParams2);
                                }
                            }
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        boolean z14 = appCompatDelegateImplV7.B != null;
                        i10 = (appCompatDelegateImplV7.f12133j || !z14) ? iD3 : 0;
                        boolean z15 = z14;
                        z12 = z13;
                        z11 = z15;
                    } else if (marginLayoutParams3.topMargin != 0) {
                        marginLayoutParams3.topMargin = 0;
                        i10 = iD3;
                        z11 = false;
                        z12 = true;
                    } else {
                        i10 = iD3;
                        z11 = false;
                        z12 = false;
                    }
                    if (z12) {
                        appCompatDelegateImplV7.f11993u.setLayoutParams(marginLayoutParams3);
                    }
                }
                View view9 = appCompatDelegateImplV7.B;
                if (view9 != null) {
                    view9.setVisibility(z11 ? 0 : 8);
                }
                return e0.f(view, iD3 != i10 ? m0Var.f(m0Var.b(), i10, m0Var.c(), m0Var.a()) : m0Var);
        }
    }

    public k i(q2.k id2) {
        kotlin.jvm.internal.g.f(id2, "id");
        return (k) ((LinkedHashMap) this.h).remove(id2);
    }

    public List j(String workSpecId) {
        kotlin.jvm.internal.g.f(workSpecId, "workSpecId");
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.h;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (kotlin.jvm.internal.g.b(((q2.k) entry.getKey()).f11498a, workSpecId)) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap2.keySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.remove((q2.k) it.next());
        }
        return kotlin.collections.a.O0(linkedHashMap2.values());
    }

    public void k(int i10) {
        ArrayList arrayList = (ArrayList) this.h;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((a) obj).a(i10);
        }
    }

    public k l(q2.k kVar) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.h;
        Object kVar2 = linkedHashMap.get(kVar);
        if (kVar2 == null) {
            kVar2 = new k(kVar);
            linkedHashMap.put(kVar, kVar2);
        }
        return (k) kVar2;
    }

    public void m(DownloadInfo downloadInfo) {
        kotlin.jvm.internal.g.f(downloadInfo, "downloadInfo");
        ((za.g) this.h).d(downloadInfo);
    }

    public b(int i10) {
        this.f12250g = i10;
        switch (i10) {
            case 2:
                break;
            case 6:
                this.h = new LinkedHashSet();
                break;
            case 9:
                this.h = new LinkedHashMap();
                break;
            default:
                this.h = new ArrayList();
                break;
        }
    }
}
