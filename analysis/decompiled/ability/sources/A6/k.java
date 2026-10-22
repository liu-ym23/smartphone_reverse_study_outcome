package A6;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
import com.stepos.ability.R;
import com.stepos.common.widget.SmoothCornerView;
import com.stepos.widget.dialog.StepOSAlertDialogLayout;
import stepos.support.v7.widget.P;

/* loaded from: classes3.dex */
public final class k extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f150a;
    public final /* synthetic */ Object b;

    public /* synthetic */ k(Object obj, int i) {
        this.f150a = i;
        this.b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        float radius;
        switch (this.f150a) {
            case 0:
                kotlin.jvm.internal.k.f(view, "view");
                kotlin.jvm.internal.k.f(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ((StepOSAlertDialogLayout) this.b).getResources().getDimension(R.dimen.stepos_dialog_corner_radius));
                break;
            case 1:
                V2.d dVar = ((Chip) this.b).f2391a;
                if (dVar == null) {
                    outline.setAlpha(0.0f);
                    break;
                } else {
                    dVar.getOutline(outline);
                    break;
                }
            case 2:
                kotlin.jvm.internal.k.f(view, "view");
                kotlin.jvm.internal.k.f(outline, "outline");
                SmoothCornerView smoothCornerView = (SmoothCornerView) this.b;
                smoothCornerView.b(smoothCornerView.getAutoFitRadius(), false);
                outline.setPath(smoothCornerView.com.stepos.aiengine.args.SingleFileBundle.KEY_PATH java.lang.String);
                break;
            default:
                Drawable background = ((P) this.b).getBackground();
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
