package androidx.fragment.app;

import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.view.ContextMenu;
import android.view.View;
import androidx.emoji2.text.p;
import androidx.lifecycle.SavedStateHandleAttacher;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.i0;
import androidx.lifecycle.l;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import androidx.lifecycle.v;
import androidx.savedstate.Recreator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class f implements ComponentCallbacks, View.OnCreateContextMenuListener, r, i0, androidx.lifecycle.h, w0.f {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f666k = null;

    /* renamed from: a, reason: collision with root package name */
    public final int f667a = -1;

    /* renamed from: b, reason: collision with root package name */
    public final String f668b = UUID.randomUUID().toString();

    /* renamed from: c, reason: collision with root package name */
    public final k f669c = new k();
    public final boolean d = true;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.lifecycle.m f670e = androidx.lifecycle.m.f717e;

    /* renamed from: f, reason: collision with root package name */
    public t f671f;

    /* renamed from: g, reason: collision with root package name */
    public p f672g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f673h;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.emoji2.text.m f674j;

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.r, java.lang.Object, w0.f] */
    public f() {
        Object obj;
        w0.d dVar;
        new v();
        new AtomicInteger();
        this.f673h = new ArrayList();
        this.f674j = new androidx.emoji2.text.m(this);
        this.f671f = new t(this);
        this.f672g = new p(this);
        ArrayList arrayList = this.f673h;
        androidx.emoji2.text.m mVar = this.f674j;
        if (arrayList.contains(mVar)) {
            return;
        }
        if (this.f667a < 0) {
            arrayList.add(mVar);
            return;
        }
        f fVar = (f) mVar.f621a;
        p pVar = fVar.f672g;
        ?? r12 = pVar.f623b;
        t tVarD = r12.d();
        if (tVarD.f724c != androidx.lifecycle.m.f715b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        tVarD.a(new Recreator(r12));
        final w0.e eVar = (w0.e) pVar.f624c;
        eVar.getClass();
        if (eVar.f6077b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        tVarD.a(new androidx.lifecycle.p() { // from class: w0.b
            @Override // androidx.lifecycle.p
            public final void a(r rVar, l lVar) {
                e this$0 = eVar;
                kotlin.jvm.internal.p.e(this$0, "this$0");
                if (lVar == l.ON_START) {
                    this$0.f6079e = true;
                } else if (lVar == l.ON_STOP) {
                    this$0.f6079e = false;
                }
            }
        });
        eVar.f6077b = true;
        androidx.lifecycle.m mVar2 = fVar.d().f724c;
        if (mVar2 != androidx.lifecycle.m.f715b && mVar2 != androidx.lifecycle.m.f716c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        w0.e eVarA = fVar.a();
        eVarA.getClass();
        Iterator it = eVarA.f6076a.iterator();
        while (true) {
            i.b bVar = (i.b) it;
            obj = null;
            if (!bVar.hasNext()) {
                dVar = null;
                break;
            }
            Map.Entry components = (Map.Entry) bVar.next();
            kotlin.jvm.internal.p.d(components, "components");
            String str = (String) components.getKey();
            dVar = (w0.d) components.getValue();
            if (kotlin.jvm.internal.p.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                break;
            }
        }
        if (dVar == null) {
            f0 f0Var = new f0(fVar.a(), fVar);
            i.f fVar2 = fVar.a().f6076a;
            i.c cVarF = fVar2.f("androidx.lifecycle.internal.SavedStateHandlesProvider");
            if (cVarF != null) {
                obj = cVarF.f3081b;
            } else {
                i.c cVar = new i.c("androidx.lifecycle.internal.SavedStateHandlesProvider", f0Var);
                fVar2.d++;
                i.c cVar2 = fVar2.f3087b;
                if (cVar2 == null) {
                    fVar2.f3086a = cVar;
                    fVar2.f3087b = cVar;
                } else {
                    cVar2.f3082c = cVar;
                    cVar.d = cVar2;
                    fVar2.f3087b = cVar;
                }
            }
            if (((w0.d) obj) != null) {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
            fVar.d().a(new SavedStateHandleAttacher(f0Var));
        }
    }

    @Override // w0.f
    public final w0.e a() {
        return (w0.e) this.f672g.f624c;
    }

    @Override // androidx.lifecycle.h
    public final f2.d b() {
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Override // androidx.lifecycle.i0
    public final d0 c() {
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @Override // androidx.lifecycle.r
    public final t d() {
        return this.f671f;
    }

    public final k e() {
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f668b);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
