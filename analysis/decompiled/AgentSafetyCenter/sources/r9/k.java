package r9;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.stepos.agentsafetycenter.R;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements z3.f {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ View f10510a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ float f10511b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f10512c;

    @Override // z3.f
    public final void a(float f5) {
        float f10 = f5 / 100.0f;
        View view = this.f10510a;
        if (view.getTag(R.id.press_anim_tag) == null) {
            view.setScaleY(f10);
            view.setScaleX(f10);
            return;
        }
        int iIntValue = ((Integer) view.getTag(R.id.press_anim_tag)).intValue();
        if ((iIntValue & 1) != 0) {
            view.setScaleY(f10);
            view.setScaleX(f10);
        }
        if ((iIntValue & 2) != 0) {
            double d7 = this.f10511b;
            int i = this.f10512c;
            int iArgb = Color.argb((int) (((float) (((1.0f - f10) / 0.05d) * d7)) * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
            if (view instanceof ImageView) {
                ((ImageView) view).setColorFilter(iArgb, PorterDuff.Mode.SRC_ATOP);
            } else {
                Drawable background = view.getBackground();
                if (background != null) {
                    background.setColorFilter(iArgb, PorterDuff.Mode.SRC_ATOP);
                }
            }
        }
        if ((iIntValue & 4) != 0) {
            view.setAlpha(1.0f - ((float) (((1.0f - f10) / 0.05d) * 0.4000000059604645d)));
        }
    }
}
