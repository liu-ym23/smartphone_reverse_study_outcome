package com.stepos.common.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import stepos.support.v7.widget.j0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2724a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2725b;

    public /* synthetic */ l(Object obj, int i) {
        this.f2724a = i;
        this.f2725b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        float radius;
        switch (this.f2724a) {
            case 0:
                view.getClass();
                outline.getClass();
                SmoothCornerView smoothCornerView = (SmoothCornerView) this.f2725b;
                smoothCornerView.b(smoothCornerView.getAutoFitRadius(), false);
                outline.setPath(smoothCornerView.f2624c);
                break;
            default:
                Drawable background = ((j0) this.f2725b).D.getBackground();
                if (background != null) {
                    Outline outline2 = new Outline();
                    background.getOutline(outline2);
                    radius = outline2.getRadius();
                } else {
                    radius = 0.0f;
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
                break;
        }
    }
}
