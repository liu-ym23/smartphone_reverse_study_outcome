package aw7;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

/* JADX INFO: loaded from: classes23.dex */
public final class h implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerViewExpandableItemManager f16591a;

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean r100) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView r100, MotionEvent r101) {
    }

    public h(RecyclerViewExpandableItemManager r100) {
        this.f16591a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView r110, MotionEvent r111) {
        RecyclerViewExpandableItemManager r100 = this.f16591a;
        if (r100.f276038c == null) goto L51;
        int r101 = r111.getActionMasked();
        if (r101 != 0) goto L8;
        RecyclerView.ViewHolder r112 = dw7.a.a(r110, r111.getX(), r111.getY());
        r100.f276042g = (int) (r111.getX() + 0.5f);
        r100.f276043h = (int) (r111.getY() + 0.5f);
        if ((r112 instanceof d) == false) goto L50;
        r100.f276040e = r112.getItemId();
        goto L51
    L50:
        r100.f276040e = -1;
        goto L51
    L8:
        if (r101 != 1) goto L10;
    L12:
        long r102 = r100.f276040e;
        int r103 = r100.f276042g;
        int r104 = r100.f276043h;
        r100.f276040e = -1;
        r100.f276042g = 0;
        r100.f276043h = 0;
        if (r102 == (-1)) goto L51;
        if (r111.getActionMasked() != 1) goto L51;
        if (r100.f276037b.isComputingLayout() == true) goto L51;
        int r105 = (int) (r111.getX() + 0.5f);
        int r106 = ((int) (r111.getY() + 0.5f)) - r104;
        if (Math.abs(r105 - r103) >= r100.f276041f) goto L51;
        if (Math.abs(r106) >= r100.f276041f) goto L51;
        RecyclerView.ViewHolder r113 = dw7.a.a(r110, r111.getX(), r111.getY());
        if (r113 == null) goto L51;
        if (r113.getItemId() != r102) goto L51;
        RecyclerView.Adapter r114 = r100.f276037b.getAdapter();
        int r107 = r113.getLayoutPosition();
        if (r107 == r113.getAdapterPosition()) goto L34;
        r107 = -1;
    L34:
        int r115 = dw7.c.b(r114, r100.f276038c, r107);
        if (r115 == (-1)) goto L51;
        View r108 = r113.itemView;
        r108.getTranslationX();
        r108.getTranslationY();
        r108.getLeft();
        r108.getTop();
        f r109 = r100.f276038c;
        if (r109.f16584c == null) goto L51;
        long r116 = r109.f16586e.d(r115);
        int r117 = b.b(r116);
        if (((int) (r116 >>> 32)) != (-1)) goto L51;
        boolean r118 = !r109.f16586e.f(r117);
        r109.f16584c.v2(r113);
        if (r118 == false) goto L46;
        r109.G2(r117, true);
        goto L51
    L46:
        r109.F2(r117, true);
        goto L51
    L10:
        if (r101 == 3) goto L12;
    L51:
        return false;
    }
}
