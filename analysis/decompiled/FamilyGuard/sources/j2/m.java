package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.familyguard.R;
import com.stepos.widget.list.StepOSListGroup;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i0.C0756a;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17729a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f17730b;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSListItem f17731c;

    /* renamed from: d, reason: collision with root package name */
    public final StepOSListItem f17732d;

    /* renamed from: e, reason: collision with root package name */
    public final StepOSListGroup f17733e;

    /* renamed from: f, reason: collision with root package name */
    public final StepOSTitleBar f17734f;

    private m(LinearLayout linearLayout, TextView textView, StepOSListItem stepOSListItem, StepOSListItem stepOSListItem2, StepOSListGroup stepOSListGroup, StepOSTitleBar stepOSTitleBar) {
        this.f17729a = linearLayout;
        this.f17730b = textView;
        this.f17731c = stepOSListItem;
        this.f17732d = stepOSListItem2;
        this.f17733e = stepOSListGroup;
        this.f17734f = stepOSTitleBar;
    }

    public static m a(View view) {
        int i5 = R.id.app_des;
        TextView textView = (TextView) C0756a.a(view, R.id.app_des);
        if (textView != null) {
            i5 = R.id.item_close_digital_wellbeing;
            StepOSListItem stepOSListItem = (StepOSListItem) C0756a.a(view, R.id.item_close_digital_wellbeing);
            if (stepOSListItem != null) {
                i5 = R.id.item_privacy;
                StepOSListItem stepOSListItem2 = (StepOSListItem) C0756a.a(view, R.id.item_privacy);
                if (stepOSListItem2 != null) {
                    i5 = R.id.settings_group;
                    StepOSListGroup stepOSListGroup = (StepOSListGroup) C0756a.a(view, R.id.settings_group);
                    if (stepOSListGroup != null) {
                        i5 = R.id.title_bar;
                        StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C0756a.a(view, R.id.title_bar);
                        if (stepOSTitleBar != null) {
                            return new m((LinearLayout) view, textView, stepOSListItem, stepOSListItem2, stepOSListGroup, stepOSTitleBar);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.digital_wellbeing_settings_activity, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17729a;
    }
}
