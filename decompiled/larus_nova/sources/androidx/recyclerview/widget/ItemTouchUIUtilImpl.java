package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = null;

    public ItemTouchUIUtilImpl() {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas r100, RecyclerView r101, View r102, float r103, float r104, int r105, boolean r106) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View r100) {
    }

    static {
        INSTANCE = new ItemTouchUIUtilImpl();
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View r100) {
        Object r101 = r100.getTag(R.id.item_touch_helper_previous_elevation);
        if ((r101 instanceof Float) == false) goto L5;
        ViewCompat.setElevation(r100, ((Float) r101).floatValue());
    L5:
        r100.setTag(R.id.item_touch_helper_previous_elevation, null);
        r100.setTranslationX(0.0f);
        r100.setTranslationY(0.0f);
    }

    private static float findMaxElevation(RecyclerView r100, View r101) {
        int r102 = r100.getChildCount();
        float r103 = 0.0f;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L11;
        View r105 = r100.getChildAt(r104);
        if (r105 == r101) goto L10;
        float r106 = ViewCompat.getElevation(r105);
        if (r106 <= r103) goto L10;
        r103 = r106;
    L10:
        r104 = r104 + 1;
        goto L3
    L11:
        return r103;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas r100, RecyclerView r101, View r102, float r103, float r104, int r105, boolean r106) {
        if (r106 == true) goto L4;
    L6:
        r102.setTranslationX(r103);
        r102.setTranslationY(r104);
        return;
    L4:
        if (r102.getTag(R.id.item_touch_helper_previous_elevation) != null) goto L6;
        Float r107 = Float.valueOf(ViewCompat.getElevation(r102));
        ViewCompat.setElevation(r102, findMaxElevation(r101, r102) + 1.0f);
        r102.setTag(R.id.item_touch_helper_previous_elevation, r107);
        goto L6
    }
}
