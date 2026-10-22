package a1;

import android.widget.FrameLayout;
import com.stepos.stepclaw.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final a f66a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f67b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f68c;

    static {
        a aVar = new a();
        aVar.B = new ArrayList();
        aVar.E = false;
        aVar.F = 0;
        aVar.C = false;
        aVar.I(new h(2));
        aVar.I(new f());
        aVar.I(new h(1));
        f66a = aVar;
        f67b = new ThreadLocal();
        f68c = new ArrayList();
    }

    public static void a(FrameLayout frameLayout, o oVar) {
        ArrayList arrayList = f68c;
        if (arrayList.contains(frameLayout) || !frameLayout.isLaidOut()) {
            return;
        }
        arrayList.add(frameLayout);
        if (oVar == null) {
            oVar = f66a;
        }
        o oVarClone = oVar.clone();
        ArrayList arrayList2 = (ArrayList) b().get(frameLayout);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i8 = 0;
            while (i8 < size) {
                Object obj = arrayList2.get(i8);
                i8++;
                ((o) obj).w(frameLayout);
            }
        }
        oVarClone.h(frameLayout, true);
        if (frameLayout.getTag(R.id.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        frameLayout.setTag(R.id.transition_current_scene, null);
        r rVar = new r();
        rVar.f64a = oVarClone;
        rVar.f65b = frameLayout;
        frameLayout.addOnAttachStateChangeListener(rVar);
        frameLayout.getViewTreeObserver().addOnPreDrawListener(rVar);
    }

    public static j.e b() {
        j.e eVar;
        ThreadLocal threadLocal = f67b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (eVar = (j.e) weakReference.get()) != null) {
            return eVar;
        }
        j.e eVar2 = new j.e(0);
        threadLocal.set(new WeakReference(eVar2));
        return eVar2;
    }
}
