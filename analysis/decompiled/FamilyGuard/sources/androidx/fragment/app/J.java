package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class J {

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f10474a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f10475b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ArrayList f10476c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f10477d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ArrayList f10478e;

        a(int i5, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f10474a = i5;
            this.f10475b = arrayList;
            this.f10476c = arrayList2;
            this.f10477d = arrayList3;
            this.f10478e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i5 = 0; i5 < this.f10474a; i5++) {
                androidx.core.view.H.D0((View) this.f10475b.get(i5), (String) this.f10476c.get(i5));
                androidx.core.view.H.D0((View) this.f10477d.get(i5), (String) this.f10478e.get(i5));
            }
        }
    }

    protected static void d(List<View> list, View view) {
        int size = list.size();
        if (g(list, view, size)) {
            return;
        }
        if (androidx.core.view.H.F(view) != null) {
            list.add(view);
        }
        for (int i5 = size; i5 < list.size(); i5++) {
            View view2 = list.get(i5);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = viewGroup.getChildAt(i6);
                    if (!g(list, childAt, size) && androidx.core.view.H.F(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean g(List<View> list, View view, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (list.get(i6) == view) {
                return true;
            }
        }
        return false;
    }

    protected static boolean i(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    protected void h(View view, Rect rect) {
        if (androidx.core.view.H.P(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r0[0], r0[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract Object k(Object obj, Object obj2, Object obj3);

    ArrayList<String> l(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = arrayList.get(i5);
            arrayList2.add(androidx.core.view.H.F(view));
            androidx.core.view.H.D0(view, null);
        }
        return arrayList2;
    }

    public abstract void m(Object obj, View view, ArrayList<View> arrayList);

    public abstract void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void o(Object obj, Rect rect);

    public abstract void p(Object obj, View view);

    public void q(ComponentCallbacksC0511f componentCallbacksC0511f, Object obj, androidx.core.os.c cVar, Runnable runnable) {
        runnable.run();
    }

    void r(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i5 = 0; i5 < size; i5++) {
            View view2 = arrayList.get(i5);
            String strF = androidx.core.view.H.F(view2);
            arrayList4.add(strF);
            if (strF != null) {
                androidx.core.view.H.D0(view2, null);
                String str = map.get(strF);
                int i6 = 0;
                while (true) {
                    if (i6 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i6))) {
                        androidx.core.view.H.D0(arrayList2.get(i6), strF);
                        break;
                    }
                    i6++;
                }
            }
        }
        androidx.core.view.A.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void s(Object obj, View view, ArrayList<View> arrayList);

    public abstract void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object u(Object obj);
}
