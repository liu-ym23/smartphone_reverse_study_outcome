package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameDetailInfoWidget f53734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f53735b;

    public j(AudienceGameDetailInfoWidget r100, int r101) {
        this.f53734a = r100;
        this.f53735b = r101;
    }

    public final void a() {
        float[] r100 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        ShapeDrawable r101 = new ShapeDrawable(new RoundRectShape(r100, new RectF(0.0f, 0.0f, 0.0f, 0.0f), r100));
        r101.getPaint().setColor(this.f53735b);
        ConstraintLayout r102 = this.f53734a.f53528r;
        if (r102 == null) goto L5;
        int r103 = r102.getWidth();
    L6:
        ConstraintLayout r104 = this.f53734a.f53528r;
        if (r104 == null) goto L9;
        int r105 = r104.getHeight();
    L10:
        r101.setBounds(new Rect(0, 0, r103, r105));
        AudienceGameDetailInfoWidget r106 = this.f53734a;
        r106.f53535y = r101;
        View r107 = r106.f53527q;
        if (r107 == null) goto L13;
        r107.setBackground(r101);
    L13:
        ConstraintLayout r108 = this.f53734a.f53528r;
        if (r108 == null) goto L17;
        r108.setBackground(r101);
        return;
    L17:
        return;
    L9:
        r105 = 136;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
