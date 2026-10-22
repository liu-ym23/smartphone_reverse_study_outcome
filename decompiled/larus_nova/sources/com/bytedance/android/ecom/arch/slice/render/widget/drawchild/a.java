package com.bytedance.android.ecom.arch.slice.render.widget.drawchild;

import android.graphics.Canvas;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;

/* JADX INFO: loaded from: classes44.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.android.ecom.arch.slice.render.widget.drawchild.a$a, reason: collision with other inner class name */
    public interface InterfaceC0866a {
        a getSlcDrawChild();
    }

    void a();

    void b(View r100, int r101);

    boolean c(Canvas r100);

    void d(BaseSlcViewManager<?> r100, int r101);

    void e();

    int getChildDrawingOrder(int r100, int r101);

    void removeView(View r100);
}
