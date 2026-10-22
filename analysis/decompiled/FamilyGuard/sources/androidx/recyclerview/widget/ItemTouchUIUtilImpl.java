package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.H;
import androidx.recyclerview.R;

/* loaded from: classes.dex */
class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    private static float findMaxElevation(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f5 = 0.0f;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = recyclerView.getChildAt(i5);
            if (childAt != view) {
                float fT = H.t(childAt);
                if (fT > f5) {
                    f5 = fT;
                }
            }
        }
        return f5;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View view) {
        int i5 = R.id.item_touch_helper_previous_elevation;
        Object tag = view.getTag(i5);
        if (tag instanceof Float) {
            H.r0(view, ((Float) tag).floatValue());
        }
        view.setTag(i5, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f5, float f6, int i5, boolean z5) {
        if (z5) {
            int i6 = R.id.item_touch_helper_previous_elevation;
            if (view.getTag(i6) == null) {
                Float fValueOf = Float.valueOf(H.t(view));
                H.r0(view, findMaxElevation(recyclerView, view) + 1.0f);
                view.setTag(i6, fValueOf);
            }
        }
        view.setTranslationX(f5);
        view.setTranslationY(f6);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f5, float f6, int i5, boolean z5) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View view) {
    }
}
