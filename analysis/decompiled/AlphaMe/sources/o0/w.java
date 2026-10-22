package o0;

import android.view.ViewGroup;
import com.stepos.alphame.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final C0795a f13771a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f13772b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f13773c;

    static {
        C0795a c0795a = new C0795a();
        c0795a.f13777C = false;
        c0795a.K(new C0801g(2));
        c0795a.K(new C0799e());
        c0795a.K(new C0801g(1));
        f13771a = c0795a;
        f13772b = new ThreadLocal();
        f13773c = new ArrayList();
    }

    public static void a(ViewGroup viewGroup, s sVar) {
        ArrayList arrayList = f13773c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (sVar == null) {
            sVar = f13771a;
        }
        s sVarClone = sVar.clone();
        ArrayList arrayList2 = (ArrayList) b().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((s) it.next()).x(viewGroup);
            }
        }
        sVarClone.h(viewGroup, true);
        B0.g.y(viewGroup.getTag(R.id.transition_current_scene));
        viewGroup.setTag(R.id.transition_current_scene, null);
        v vVar = new v();
        vVar.f13769a = sVarClone;
        vVar.f13770b = viewGroup;
        viewGroup.addOnAttachStateChangeListener(vVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(vVar);
    }

    public static q.f b() {
        q.f fVar;
        ThreadLocal threadLocal = f13772b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (fVar = (q.f) weakReference.get()) != null) {
            return fVar;
        }
        q.f fVar2 = new q.f();
        threadLocal.set(new WeakReference(fVar2));
        return fVar2;
    }
}
