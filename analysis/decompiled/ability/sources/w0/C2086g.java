package w0;

import F9.s;
import F9.t;
import Va.A;
import aa.InterfaceC0315b;
import android.app.Activity;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegate;
import com.stepos.common.widget.ScrollTextView;
import f1.C1431a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import k1.AbstractC1620b;
import m9.C1718k;
import qa.InterfaceC1852d;
import qa.InterfaceC1855g;
import qa.L;
import retrofit2.HttpException;
import stepos.support.v7.app.AbstractC1975y;

/* renamed from: w0.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2086g implements s, InterfaceC1855g, A, A.b {
    public static volatile C2086g b;

    /* renamed from: a, reason: collision with root package name */
    public Object f6811a;

    public /* synthetic */ C2086g(Object obj) {
        this.f6811a = obj;
    }

    public static C2086g b() {
        if (b == null) {
            synchronized (C2086g.class) {
                try {
                    if (b == null) {
                        C2086g c2086g = new C2086g();
                        c2086g.f6811a = new ConcurrentHashMap();
                        b = c2086g;
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public static String c() {
        WeakReference weakReference;
        Activity activity;
        C1431a c1431a = (C1431a) AbstractC1620b.a(C1431a.class);
        return (c1431a == null || (weakReference = c1431a.b) == null || (activity = (Activity) weakReference.get()) == null) ? "" : activity.getClass().getCanonicalName();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject a(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.Object r2 = r2.f6811a
            java.util.concurrent.ConcurrentHashMap r2 = (java.util.concurrent.ConcurrentHashMap) r2
            java.lang.Object r2 = r2.get(r3)
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            if (r2 != 0) goto Ld
            goto L18
        Ld:
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            java.util.Iterator r0 = r2.keys()
            if (r0 != 0) goto L1a
        L18:
            r2 = 0
            goto L3e
        L1a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L2a
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            r3.add(r1)
            goto L1a
        L2a:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3a
            r1 = 0
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L3a
            java.lang.Object[] r3 = r3.toArray(r1)     // Catch: java.lang.Exception -> L3a
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch: java.lang.Exception -> L3a
            r0.<init>(r2, r3)     // Catch: java.lang.Exception -> L3a
            r2 = r0
            goto L3e
        L3a:
            r3 = move-exception
            r3.printStackTrace()
        L3e:
            if (r2 != 0) goto L45
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.C2086g.a(java.lang.String):org.json.JSONObject");
    }

    public void d(int i) {
        ScrollTextView scrollTextView = (ScrollTextView) this.f6811a;
        ScrollTextView.c(scrollTextView, i);
        int height = scrollTextView.getHeight();
        int i6 = scrollTextView.l;
        if (i6 > height) {
            scrollTextView.l = height;
            scrollTextView.f3755j.d.forceFinished(true);
            return;
        }
        int i10 = -height;
        if (i6 < i10) {
            scrollTextView.l = i10;
            scrollTextView.f3755j.d.forceFinished(true);
        }
    }

    @Override // A.b
    public void e(long j5) {
        ((ConcurrentHashMap) ((u1.d) this.f6811a).b).put(cc.dd.aa.cc.cc.b.c, Long.valueOf(j5));
    }

    @Override // Va.A
    public void f(Va.n nVar, boolean z10) {
        ((AbstractC1975y) this.f6811a).r(nVar);
    }

    @Override // F9.s
    public t i(J9.i iVar) {
        InterfaceC0315b interfaceC0315b = (InterfaceC0315b) this.f6811a;
        X6.d dVar = new X6.d();
        dVar.b = -1L;
        dVar.c = -1L;
        dVar.d = -1L;
        dVar.e = -1L;
        dVar.f = -1L;
        dVar.g = -1L;
        dVar.h = -1L;
        dVar.i = -1L;
        dVar.f1508j = -1L;
        dVar.k = -1L;
        dVar.l = -1L;
        dVar.m = -1L;
        dVar.f1510r = interfaceC0315b;
        return dVar;
    }

    @Override // qa.InterfaceC1855g
    public void j(InterfaceC1852d interfaceC1852d, L l) {
        C1718k c1718k = (C1718k) this.f6811a;
        if (l.f5644a.c()) {
            c1718k.resumeWith(l.b);
        } else {
            c1718k.resumeWith(kotlin.b.a(new HttpException(l)));
        }
    }

    @Override // Va.A
    public boolean n(Va.n nVar) {
        Window.Callback callback = ((AbstractC1975y) this.f6811a).b.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR, nVar);
        return true;
    }

    @Override // qa.InterfaceC1855g
    public void r(InterfaceC1852d interfaceC1852d, Throwable th) {
        ((C1718k) this.f6811a).resumeWith(kotlin.b.a(th));
    }
}
