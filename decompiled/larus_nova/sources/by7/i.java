package by7;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class i {
    /* JADX WARN: Multi-variable type inference failed */
    public static final e a(View r100) {
        View r101 = r100;
    L3:
        ViewParent r102 = null;
        if (r101 == 0) goto L16;
        e r103 = h.b(r101);
        if (r103 != null) goto L7;
        ViewParent r104 = r101.getParent();
        if ((r104 instanceof View) == false) goto L12;
        r102 = r104;
    L12:
        r101 = (View) r102;
        if ((r101 instanceof e) == false) goto L3;
        return (e) r101;
    L7:
        return r103;
    L16:
        Context r105 = r100.getContext();
        if (r105 != null) goto L19;
        return null;
    L19:
        return h.f(r105);
    }

    public static final e b(Fragment r100) {
        ActivityResultCaller r101 = r100.getParentFragment();
        FragmentActivity r102 = null;
        if ((r101 instanceof e) == true) goto L5;
        r101 = null;
    L5:
        e r103 = (e) r101;
        if (r103 != null) goto L14;
        FragmentActivity r104 = r100.getActivity();
        if ((r104 instanceof e) == false) goto L13;
        r102 = r104;
    L13:
        return (e) r102;
    L14:
        return r103;
    }

    public static final e c(Object r100) {
        if ((r100 instanceof View) == true) goto L41;
        e r101 = null;
        if ((r100 instanceof RecyclerView.ViewHolder) == false) goto L37;
        RecyclerView.ViewHolder r102 = (RecyclerView.ViewHolder) r100;
        e r103 = h.b(r102.itemView);
        if (r103 == null) goto L11;
        if (r103 == r102) goto L11;
    L42:
        return r103;
    L11:
        ViewParent r104 = r102.itemView.getParent();
        if ((r104 instanceof e) == true) goto L14;
        r104 = null;
    L14:
        r103 = (e) r104;
        if (r103 != null) goto L28;
        ViewParent r105 = r102.itemView.getParent();
        if ((r105 instanceof RecyclerView) == true) goto L20;
        r105 = null;
    L20:
        RecyclerView r106 = (RecyclerView) r105;
        if (r106 == null) goto L23;
        Object r107 = r106.getAdapter();
    L25:
        if ((r107 instanceof e) == true) goto L27;
        r107 = null;
    L27:
        r103 = (e) r107;
        goto L28
    L23:
        r107 = null;
    L28:
        if (r103 != null) goto L42;
        Object r108 = r102.itemView.getParent();
        if ((r108 instanceof View) == true) goto L33;
        r108 = null;
    L33:
        View r109 = (View) r108;
        if (r109 == null) goto L40;
        r101 = a(r109);
    L40:
        return r101;
    L37:
        if ((r100 instanceof Fragment) == false) goto L40;
        return b((Fragment) r100);
    L41:
        return a((View) r100);
    }
}
