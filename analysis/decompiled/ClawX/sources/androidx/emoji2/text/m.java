package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior;
import g.f1;
import j0.v0;
import j0.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class m implements i, k4.h, f1, f.o, f0.p, j1.c, r4.k, j0.f {

    /* renamed from: a, reason: collision with root package name */
    public Object f621a;

    public /* synthetic */ m(Object obj) {
        this.f621a = obj;
    }

    @Override // r4.k
    public Set a() {
        return ((r4.l) k4.z.o((k4.p) this.f621a)).a();
    }

    @Override // f.o
    public void b(f.j jVar, boolean z) {
        if (jVar instanceof f.t) {
            ((f.t) jVar).f2526v.j().c(false);
        }
        f.o oVar = ((g.i) this.f621a).f2715e;
        if (oVar != null) {
            oVar.b(jVar, z);
        }
    }

    @Override // f0.p
    public boolean c(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f621a;
        if (!swipeDismissBehavior.r(view)) {
            return false;
        }
        boolean z = view.getLayoutDirection() == 1;
        int i8 = swipeDismissBehavior.d;
        int width = (!(i8 == 0 && z) && (i8 != 1 || z)) ? view.getWidth() : -view.getWidth();
        int[] iArr = e0.a0.f2285a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        return true;
    }

    @Override // j0.f
    public Object d(p5.p pVar, f5.c cVar) {
        return ((j0.f) this.f621a).d(new c4.c(pVar, null), cVar);
    }

    @Override // androidx.emoji2.text.i
    public void e(b8.h hVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new k(this, hVar, threadPoolExecutor, 0));
    }

    @Override // k4.h
    public boolean f(k4.g contentType) {
        kotlin.jvm.internal.p.e(contentType, "contentType");
        return contentType.u((k4.g) this.f621a);
    }

    @Override // f.o
    public boolean g(f.j jVar) {
        g.i iVar = (g.i) this.f621a;
        if (jVar == iVar.f2714c) {
            return false;
        }
        ((f.t) jVar).f2527w.getClass();
        iVar.getClass();
        f.o oVar = iVar.f2715e;
        if (oVar != null) {
            return oVar.g(jVar);
        }
        return false;
    }

    @Override // g.f1
    public void h(f.j jVar, MenuItem menuItem) {
        ((f.g) this.f621a).f2430f.removeCallbacksAndMessages(jVar);
    }

    @Override // g.f1
    public void i(f.j jVar, f.k kVar) {
        f.g gVar = (f.g) this.f621a;
        Handler handler = gVar.f2430f;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = gVar.f2432h;
        int size = arrayList.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size) {
                i8 = -1;
                break;
            } else if (jVar == ((f.f) arrayList.get(i8)).f2425b) {
                break;
            } else {
                i8++;
            }
        }
        if (i8 == -1) {
            return;
        }
        int i9 = i8 + 1;
        handler.postAtTime(new f.e(this, i9 < arrayList.size() ? (f.f) arrayList.get(i9) : null, kVar, jVar), jVar, SystemClock.uptimeMillis() + 200);
    }

    @Override // r4.k
    public void j(String name, List values) {
        kotlin.jvm.internal.p.e(name, "name");
        kotlin.jvm.internal.p.e(values, "values");
        k4.p pVar = (k4.p) this.f621a;
        String strE = k4.b.e(name, false);
        ArrayList arrayList = new ArrayList(c5.o.n0(values, 10));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            kotlin.jvm.internal.p.e(str, "<this>");
            arrayList.add(k4.b.e(str, true));
        }
        pVar.j(strE, arrayList);
    }

    @Override // j0.f
    public d6.b k() {
        return ((j0.f) this.f621a).k();
    }

    public f0.g l(int i8) {
        return null;
    }

    public f0.g m(int i8) {
        return null;
    }

    public v0 n() {
        return (v0) ((d6.y) this.f621a).getValue();
    }

    public boolean o(int i8, int i9, Bundle bundle) {
        return false;
    }

    public void p(t1.f definition) {
        kotlin.jvm.internal.p.e(definition, "definition");
        a8.b.x(((t4.a) this.f621a).a(definition));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.emoji2.text.r] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q(j0.v0 r5) {
        /*
            r4 = this;
            java.lang.String r0 = "newState"
            kotlin.jvm.internal.p.e(r5, r0)
            java.lang.Object r4 = r4.f621a
            d6.y r4 = (d6.y) r4
        L9:
            java.lang.Object r0 = r4.getValue()
            r1 = r0
            j0.v0 r1 = (j0.v0) r1
            boolean r2 = r1 instanceof j0.o0
            if (r2 == 0) goto L16
            r2 = 1
            goto L1c
        L16:
            j0.w0 r2 = j0.w0.f3454b
            boolean r2 = kotlin.jvm.internal.p.a(r1, r2)
        L1c:
            if (r2 == 0) goto L1f
            goto L29
        L1f:
            boolean r2 = r1 instanceof j0.c
            if (r2 == 0) goto L2b
            int r2 = r5.f3448a
            int r3 = r1.f3448a
            if (r2 <= r3) goto L2f
        L29:
            r1 = r5
            goto L2f
        L2b:
            boolean r2 = r1 instanceof j0.m0
            if (r2 == 0) goto L3e
        L2f:
            androidx.emoji2.text.r r2 = e6.i.f2386a
            if (r0 != 0) goto L34
            r0 = r2
        L34:
            if (r1 != 0) goto L37
            r1 = r2
        L37:
            boolean r0 = r4.c(r0, r1)
            if (r0 == 0) goto L9
            return
        L3e:
            a6.w r4 = new a6.w
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.m.q(j0.v0):void");
    }

    public m(int i8) {
        switch (i8) {
            case 12:
                this.f621a = new AtomicInteger(0);
                break;
            case BERTags.RELATIVE_OID /* 13 */:
                this.f621a = d6.z.a(w0.f3454b);
                break;
            case 15:
                this.f621a = new t4.a();
                break;
            case 16:
                this.f621a = new LinkedHashMap(0, 0.75f, true);
                break;
            case BERTags.IA5_STRING /* 22 */:
                TimeUnit timeUnit = TimeUnit.MINUTES;
                kotlin.jvm.internal.p.e(timeUnit, "timeUnit");
                q6.d taskRunner = q6.d.f4879l;
                kotlin.jvm.internal.p.e(taskRunner, "taskRunner");
                this.f621a = new r6.q(taskRunner);
                break;
            case BERTags.UNRESTRICTED_STRING /* 29 */:
                this.f621a = new LinkedHashSet();
                break;
            default:
                this.f621a = new f0.h(this);
                break;
        }
    }
}
