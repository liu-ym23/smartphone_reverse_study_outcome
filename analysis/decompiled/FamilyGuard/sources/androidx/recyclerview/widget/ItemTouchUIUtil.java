package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* loaded from: classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f5, float f6, int i5, boolean z5);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f5, float f6, int i5, boolean z5);

    void onSelected(View view);
}
