package l9;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.stepos.agentsafetycenter.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import java.util.Iterator;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f7808c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f7809f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ boolean f7810g;

    @Override // xb.l
    public final Object invoke(Object obj) throws Resources.NotFoundException {
        String str = this.f7808c;
        int i = this.f7809f;
        boolean z10 = this.f7810g;
        StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) obj;
        stepOSTitleBar.getClass();
        stepOSTitleBar.setTitleTextColor(stepOSTitleBar.getContext().getColor(R.color.stepos_titlebar_title));
        stepOSTitleBar.setTitleCentered(true);
        stepOSTitleBar.getTitleView().setTypeface(Typeface.create(Typeface.SANS_SERIF, stepOSTitleBar.getResources().getInteger(R.integer.stepos_font_weight_regular), false));
        stepOSTitleBar.setTitle(str);
        stepOSTitleBar.setTopPadding(stepOSTitleBar.getResources().getDimensionPixelSize(R.dimen.stepos_titlebar_padding_top) + i);
        View viewFindViewWithTag = stepOSTitleBar.findViewWithTag("gongkong_titlebar_refresh");
        if (z10 && viewFindViewWithTag == null) {
            int dimensionPixelSize = stepOSTitleBar.getResources().getDimensionPixelSize(R.dimen.stepos_size_icon_m);
            ProgressBar progressBar = new ProgressBar(stepOSTitleBar.getContext());
            progressBar.setTag("gongkong_titlebar_refresh");
            progressBar.setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelSize, dimensionPixelSize));
            stepOSTitleBar.c(stepOSTitleBar.f2897f, progressBar);
        } else if (!z10 && viewFindViewWithTag != null) {
            fb.d dVarB = stepOSTitleBar.b(1);
            Iterator it = stepOSTitleBar.f2901k.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                if (StepOSTitleBar.j((View) next, dVarB)) {
                    it.remove();
                }
            }
            Iterator it2 = stepOSTitleBar.f2902l.iterator();
            it2.getClass();
            while (it2.hasNext()) {
                Object next2 = it2.next();
                next2.getClass();
                if (StepOSTitleBar.j((View) next2, dVarB)) {
                    it2.remove();
                }
            }
            Iterator it3 = stepOSTitleBar.f2903m.iterator();
            it3.getClass();
            while (it3.hasNext()) {
                Object next3 = it3.next();
                next3.getClass();
                if (StepOSTitleBar.j((View) next3, dVarB)) {
                    it3.remove();
                }
            }
            dVarB.removeAllViews();
            stepOSTitleBar.requestLayout();
        }
        return v.f6774a;
    }
}
