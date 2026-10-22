package d2;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.stepos.aiengine.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final d2.a f8316a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<WeakReference<p.a<ViewGroup, ArrayList<i>>>> f8317b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList<ViewGroup> f8318c;

    static {
        d2.a aVar = new d2.a();
        aVar.F = false;
        aVar.J(new c(2));
        aVar.J(new b());
        aVar.J(new c(1));
        f8316a = aVar;
        f8317b = new ThreadLocal<>();
        f8318c = new ArrayList<>();
    }

    public static void a(ViewGroup viewGroup, i iVar) {
        ArrayList<ViewGroup> arrayList = f8318c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (iVar == null) {
            iVar = f8316a;
        }
        i iVarClone = iVar.clone();
        ArrayList<i> arrayList2 = b().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i10 = 0;
            while (i10 < size) {
                i iVar2 = arrayList2.get(i10);
                i10++;
                iVar2.w(viewGroup);
            }
        }
        iVarClone.i(viewGroup, true);
        if (((h) viewGroup.getTag(R.id.transition_current_scene)) != null) {
            throw null;
        }
        viewGroup.setTag(R.id.transition_current_scene, null);
        a aVar = new a();
        aVar.f8319a = iVarClone;
        aVar.f8320b = viewGroup;
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static p.a<ViewGroup, ArrayList<i>> b() {
        p.a<ViewGroup, ArrayList<i>> aVar;
        ThreadLocal<WeakReference<p.a<ViewGroup, ArrayList<i>>>> threadLocal = f8317b;
        WeakReference<p.a<ViewGroup, ArrayList<i>>> weakReference = threadLocal.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        p.a<ViewGroup, ArrayList<i>> aVar2 = new p.a<>();
        threadLocal.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public i f8319a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f8320b;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: d2.m$a$a, reason: collision with other inner class name */
        public class C0073a extends l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p.a f8321a;

            public C0073a(p.a aVar) {
                this.f8321a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // d2.i.d
            public final void c(i iVar) {
                ((ArrayList) this.f8321a.get(a.this.f8320b)).remove(iVar);
                iVar.x(this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:106:0x0234  */
        /* JADX WARN: Removed duplicated region for block: B:133:0x01e0 A[EDGE_INSN: B:133:0x01e0->B:89:0x01e0 BREAK  A[LOOP:1: B:18:0x0084->B:88:0x01d9], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:92:0x01e7  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0208  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onPreDraw() {
            /*
                Method dump skipped, instructions count: 687
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: d2.m.a.onPreDraw():boolean");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.f8320b;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            m.f8318c.remove(viewGroup);
            ArrayList<i> arrayList = m.b().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    i iVar = arrayList.get(i10);
                    i10++;
                    iVar.z(viewGroup);
                }
            }
            this.f8319a.j(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }
}
