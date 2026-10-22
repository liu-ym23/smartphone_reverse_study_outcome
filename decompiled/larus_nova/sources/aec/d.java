package aec;

import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<Pair<Integer, e>> f3130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray<Pair<Integer, aec.a>> f3131d;

    public class a implements ViewStub.OnInflateListener {
        public a() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public final void onInflate(ViewStub r100, View r101) {
            r101.setId(r100.getId());
        }
    }

    public d() {
        this.f3130c = new SparseArray();
        this.f3131d = new SparseArray();
    }

    @Override // aec.e
    public final void g(View r110) {
        if ((r110 instanceof ViewGroup) == false) goto L29;
        int r100 = this.f3131d.size();
        int r101 = 0;
    L5:
        if (r101 >= r100) goto L27;
        int r102 = this.f3131d.keyAt(r101);
        Pair<Integer, aec.a> r103 = this.f3131d.valueAt(r101);
        aec.a r104 = (aec.a) r103.second;
        int r105 = ((Integer) r103.first).intValue();
        if ((r104 instanceof c) == true) goto L26;
        View r106 = r110.findViewById(r105);
        e r107 = r104.f();
        r107.f3133b = this.f3133b;
        if ((r106 instanceof ViewGroup) == false) goto L22;
        ViewGroup r108 = (ViewGroup) r106;
        View r109 = r104.a(r108);
        if (r109 == null) goto L18;
        ViewGroup.LayoutParams r111 = r109.getLayoutParams();
        ViewGroup r112 = (ViewGroup) r109.getParent();
        if (r112 == null) goto L15;
        r112.removeView(r109);
    L15:
        if (r111 == null) goto L17;
        r108.addView(r109, r111);
        goto L18
    L17:
        r108.addView(r109);
    L18:
        if (r109 == null) goto L20;
        r107.f(r109);
    L24:
        this.f3130c.put(r102, new Pair(Integer.valueOf(r105), r107));
        r101 = r101 + 1;
        goto L5
    L20:
        r107.f(r106);
        goto L24
    L22:
        if ((r106 instanceof ViewStub) == false) goto L24;
        ((ViewStub) r106).setOnInflateListener(new a());
        r107.f(r106);
        goto L24
    L26:
        throw new IllegalStateException("do not support nested group component");
    L27:
        return;
    L29:
        throw new IllegalStateException("The layout provided to GroupComponent must be a ViewGroup");
    }
}
