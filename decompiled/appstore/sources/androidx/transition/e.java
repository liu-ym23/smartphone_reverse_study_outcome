package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f5057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5058b;

    public e(ViewGroup r10) {
        super(r10.getContext());
        setClipChildren(false);
        this.f5057a = r10;
        r10.setTag(R$id.ghost_view_holder, this);
        w.b(this.f5057a).add(this);
        this.f5058b = true;
    }

    public static e b(ViewGroup r10) {
        return (e) r10.getTag(R$id.ghost_view_holder);
    }

    public static void d(View r10, ArrayList r11) {
        Object r12 = r10.getParent();
        if ((r12 instanceof ViewGroup) == false) goto L5;
        d((View) r12, r11);
    L5:
        r11.add(r10);
    }

    public static boolean e(View r10, View r11) {
        ViewGroup r12 = (ViewGroup) r10.getParent();
        int r13 = r12.getChildCount();
        if (r10.getZ() != r11.getZ()) goto L5;
        int r14 = 0;
    L9:
        if (r14 >= r13) goto L16;
        View r15 = r12.getChildAt(w.a(r12, r14));
        if (r15 == r10) goto L21;
        if (r15 == r11) goto L16;
        r14 = r14 + 1;
        goto L9
    L21:
        return false;
    L16:
        return true;
    L5:
        if (r10.getZ() > r11.getZ()) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean f(ArrayList r10, ArrayList r11) {
        if (r10.isEmpty() == false) goto L5;
        return true;
    L5:
        if (r11.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r10.get(0) != r11.get(0)) goto L25;
        int r12 = Math.min(r10.size(), r11.size());
        int r13 = 1;
    L10:
        if (r13 >= r12) goto L17;
        View r14 = (View) r10.get(r13);
        View r15 = (View) r11.get(r13);
        if (r14 != r15) goto L14;
        r13 = r13 + 1;
        goto L10
    L14:
        return e(r14, r15);
    L17:
        if (r11.size() != r12) goto L20;
        return true;
    L20:
        return false;
    L25:
        return true;
    }

    public void a(f r10) {
        ArrayList r11 = new ArrayList();
        d(r10.f5061c, r11);
        int r12 = c(r11);
        if (r12 >= 0) goto L5;
    L8:
        addView(r10);
        return;
    L5:
        if (r12 >= getChildCount()) goto L8;
        addView(r10, r12);
    }

    public final int c(ArrayList r10) {
        ArrayList r11 = new ArrayList();
        int r12 = getChildCount() - 1;
        int r13 = 0;
    L3:
        if (r13 > r12) goto L9;
        int r14 = (r13 + r12) / 2;
        d(((f) getChildAt(r14)).f5061c, r11);
        if (f(r10, r11) == false) goto L7;
        r13 = r14 + 1;
    L8:
        r11.clear();
        goto L3
    L7:
        r12 = r14 - 1;
        goto L8
    L9:
        return r13;
    }

    public void g() {
        if (this.f5058b == false) goto L7;
        w.b(this.f5057a).remove(this);
        w.b(this.f5057a).add(this);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r10) {
        if (this.f5058b == false) goto L7;
        super.onViewAdded(r10);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        if (getChildCount() != 1) goto L7;
        if (getChildAt(0) != r10) goto L7;
    L8:
        this.f5057a.setTag(R$id.ghost_view_holder, null);
        w.b(this.f5057a).remove(this);
        this.f5058b = false;
        return;
    L7:
        if (getChildCount() == 0) goto L8;
    }
}
