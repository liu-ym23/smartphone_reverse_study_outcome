package r1;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
import com.stepos.alphame.utils.Property;
import com.stepos.common.widget.SmoothCornerView;
import kotlin.jvm.internal.Intrinsics;
import stepos.support.v7.widget.K;

/* loaded from: classes.dex */
public final class c extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14009a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14010b;

    public /* synthetic */ c(int i4, Object obj) {
        this.f14009a = i4;
        this.f14010b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        int i4 = this.f14009a;
        float radius = Property.DEFAULT_FLOAT_VALUE;
        Object obj = this.f14010b;
        switch (i4) {
            case 0:
                f fVar = ((Chip) obj).f10574e;
                if (fVar == null) {
                    outline.setAlpha(Property.DEFAULT_FLOAT_VALUE);
                    break;
                } else {
                    fVar.getOutline(outline);
                    break;
                }
            case 1:
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                SmoothCornerView smoothCornerView = (SmoothCornerView) obj;
                smoothCornerView.c(smoothCornerView.getAutoFitRadius(), false);
                outline.setPath(smoothCornerView.path);
                break;
            default:
                Drawable background = ((K) obj).f2846z.getBackground();
                if (background != null) {
                    Outline outline2 = new Outline();
                    background.getOutline(outline2);
                    radius = outline2.getRadius();
                }
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), radius);
                break;
        }
    }
}
