package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public interface ItemTouchUIUtil {
    void clearView(View r100);

    void onDraw(Canvas r100, RecyclerView r101, View r102, float r103, float r104, int r105, boolean r106);

    void onDrawOver(Canvas r100, RecyclerView r101, View r102, float r103, float r104, int r105, boolean r106);

    void onSelected(View r100);
}
