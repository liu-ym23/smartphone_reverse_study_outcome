package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R$id;

/* JADX INFO: loaded from: classes.dex */
public class f implements ItemTouchUIUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ItemTouchUIUtil f4412a = null;

    static {
        f4412a = new f();
    }

    public f() {
    }

    public static float a(RecyclerView r10, View r11) {
        int r12 = r10.getChildCount();
        float r13 = 0.0f;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L11;
        View r15 = r10.getChildAt(r14);
        if (r15 == r11) goto L10;
        float r16 = ViewCompat.v(r15);
        if (r16 <= r13) goto L10;
        r13 = r16;
    L10:
        r14 = r14 + 1;
        goto L3
    L11:
        return r13;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View r10) {
        int r11 = R$id.item_touch_helper_previous_elevation;
        Object r12 = r10.getTag(r11);
        if ((r12 instanceof Float) == false) goto L5;
        ViewCompat.x0(r10, ((Float) r12).floatValue());
    L5:
        r10.setTag(r11, null);
        r10.setTranslationX(0.0f);
        r10.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16) {
        if (r16 == false) goto L6;
        int r17 = R$id.item_touch_helper_previous_elevation;
        if (r12.getTag(r17) != null) goto L6;
        Float r18 = Float.valueOf(ViewCompat.v(r12));
        ViewCompat.x0(r12, a(r11, r12) + 1.0f);
        r12.setTag(r17, r18);
    L6:
        r12.setTranslationX(r13);
        r12.setTranslationY(r14);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas r10, RecyclerView r11, View r12, float r13, float r14, int r15, boolean r16) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View r10) {
    }
}
