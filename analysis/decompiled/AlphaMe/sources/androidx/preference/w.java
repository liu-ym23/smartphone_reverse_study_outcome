package androidx.preference;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class w extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public Drawable f4168a;

    /* renamed from: b, reason: collision with root package name */
    public int f4169b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4170c = true;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ y f4171d;

    public w(y yVar) {
        this.f4171d = yVar;
    }

    public final boolean a(RecyclerView recyclerView, View view) {
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(view);
        boolean z4 = false;
        if (!(childViewHolder instanceof K) || !((K) childViewHolder).f4040e) {
            return false;
        }
        boolean z5 = this.f4170c;
        int iIndexOfChild = recyclerView.indexOfChild(view);
        if (iIndexOfChild >= recyclerView.getChildCount() - 1) {
            return z5;
        }
        RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(recyclerView.getChildAt(iIndexOfChild + 1));
        if ((childViewHolder2 instanceof K) && ((K) childViewHolder2).f4039d) {
            z4 = true;
        }
        return z4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (a(recyclerView, view)) {
            rect.bottom = this.f4169b;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f4168a == null) {
            return;
        }
        int childCount = recyclerView.getChildCount();
        int width = recyclerView.getWidth();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            if (a(recyclerView, childAt)) {
                int height = childAt.getHeight() + ((int) childAt.getY());
                this.f4168a.setBounds(0, height, width, this.f4169b + height);
                this.f4168a.draw(canvas);
            }
        }
    }
}
