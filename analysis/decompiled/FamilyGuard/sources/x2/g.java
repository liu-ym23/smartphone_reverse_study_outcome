package x2;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.stepos.familyguard.R;
import com.stepos.widget.toolbar.StepOSTitleBar;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ void a(TextView textView, float f5) {
        textView.setTextAppearance(R.style.StepOSTextAppearance_TitleBar_DigitalHealth);
        textView.setTextSize(0, f5);
        textView.invalidate();
    }

    private static void b(StepOSTitleBar stepOSTitleBar) throws Resources.NotFoundException {
        final TextView titleView = stepOSTitleBar.getTitleView();
        stepOSTitleBar.setTitleTextAppearance(R.style.StepOSTextAppearance_TitleBar_DigitalHealth);
        if (titleView == null) {
            return;
        }
        final float dimension = stepOSTitleBar.getResources().getDimension(R.dimen.stepos_font_size_title_m);
        Runnable runnable = new Runnable() { // from class: x2.f
            @Override // java.lang.Runnable
            public final void run() {
                g.a(titleView, dimension);
            }
        };
        runnable.run();
        titleView.post(runnable);
    }

    public static void c(StepOSTitleBar stepOSTitleBar) {
        if (stepOSTitleBar == null) {
            return;
        }
        stepOSTitleBar.u(0);
        stepOSTitleBar.u(1);
    }

    public static void d(stepos.support.v7.app.d dVar) {
        stepos.support.v7.app.a supportActionBar;
        if (dVar == null || (supportActionBar = dVar.getSupportActionBar()) == null) {
            return;
        }
        supportActionBar.q();
    }

    public static void e(StepOSTitleBar stepOSTitleBar, CharSequence charSequence, View.OnClickListener onClickListener) throws Resources.NotFoundException {
        f(stepOSTitleBar, charSequence, onClickListener, 0, null, null);
    }

    public static void f(StepOSTitleBar stepOSTitleBar, CharSequence charSequence, View.OnClickListener onClickListener, int i5, CharSequence charSequence2, View.OnClickListener onClickListener2) throws Resources.NotFoundException {
        g(stepOSTitleBar, charSequence, onClickListener, i5, charSequence2, onClickListener2, true);
    }

    private static void g(StepOSTitleBar stepOSTitleBar, CharSequence charSequence, View.OnClickListener onClickListener, int i5, CharSequence charSequence2, View.OnClickListener onClickListener2, boolean z5) throws Resources.NotFoundException {
        if (stepOSTitleBar == null) {
            return;
        }
        c(stepOSTitleBar);
        if (charSequence != null) {
            stepOSTitleBar.setTitle(charSequence.toString());
        } else {
            stepOSTitleBar.setTitle(BuildConfig.FLAVOR);
        }
        stepOSTitleBar.setTitleGravity(1);
        stepOSTitleBar.setBackgroundColor(0);
        stepOSTitleBar.setGlassEnabled(z5);
        stepOSTitleBar.setIndividualActionGlassEnabled(true);
        stepOSTitleBar.k(R.drawable.stepos_icon_navigation_back, stepOSTitleBar.getResources().getString(R.string.abc_action_bar_up_description), onClickListener);
        if (i5 != 0 && onClickListener2 != null) {
            stepOSTitleBar.j(i5, charSequence2 != null ? charSequence2.toString() : stepOSTitleBar.getResources().getString(R.string.abc_searchview_description_search), onClickListener2);
        }
        b(stepOSTitleBar);
    }

    public static void h(StepOSTitleBar stepOSTitleBar, CharSequence charSequence, View.OnClickListener onClickListener) {
        g(stepOSTitleBar, charSequence, onClickListener, 0, null, null, true);
    }

    public static void i(StepOSTitleBar stepOSTitleBar, CharSequence charSequence, View.OnClickListener onClickListener, int i5, CharSequence charSequence2, View.OnClickListener onClickListener2) {
        g(stepOSTitleBar, charSequence, onClickListener, i5, charSequence2, onClickListener2, true);
    }
}
