package j2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.stepos.familyguard.R;
import com.stepos.widget.list.StepOSListGroup;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i0.C0756a;

/* renamed from: j2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0786c {

    /* renamed from: a, reason: collision with root package name */
    private final LinearLayout f17688a;

    /* renamed from: b, reason: collision with root package name */
    public final StepOSListItem f17689b;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSListItem f17690c;

    /* renamed from: d, reason: collision with root package name */
    public final StepOSListItem f17691d;

    /* renamed from: e, reason: collision with root package name */
    public final StepOSListItem f17692e;

    /* renamed from: f, reason: collision with root package name */
    public final StepOSListGroup f17693f;

    /* renamed from: g, reason: collision with root package name */
    public final StepOSTitleBar f17694g;

    private C0786c(LinearLayout linearLayout, StepOSListItem stepOSListItem, StepOSListItem stepOSListItem2, StepOSListItem stepOSListItem3, StepOSListItem stepOSListItem4, StepOSListGroup stepOSListGroup, StepOSTitleBar stepOSTitleBar) {
        this.f17688a = linearLayout;
        this.f17689b = stepOSListItem;
        this.f17690c = stepOSListItem2;
        this.f17691d = stepOSListItem3;
        this.f17692e = stepOSListItem4;
        this.f17693f = stepOSListGroup;
        this.f17694g = stepOSTitleBar;
    }

    public static C0786c a(View view) {
        int i5 = R.id.item_child_privacy;
        StepOSListItem stepOSListItem = (StepOSListItem) C0756a.a(view, R.id.item_child_privacy);
        if (stepOSListItem != null) {
            i5 = R.id.item_personal_info_list;
            StepOSListItem stepOSListItem2 = (StepOSListItem) C0756a.a(view, R.id.item_personal_info_list);
            if (stepOSListItem2 != null) {
                i5 = R.id.item_privacy_policy;
                StepOSListItem stepOSListItem3 = (StepOSListItem) C0756a.a(view, R.id.item_privacy_policy);
                if (stepOSListItem3 != null) {
                    i5 = R.id.item_revoke_privacy;
                    StepOSListItem stepOSListItem4 = (StepOSListItem) C0756a.a(view, R.id.item_revoke_privacy);
                    if (stepOSListItem4 != null) {
                        i5 = R.id.privacy_group;
                        StepOSListGroup stepOSListGroup = (StepOSListGroup) C0756a.a(view, R.id.privacy_group);
                        if (stepOSListGroup != null) {
                            i5 = R.id.title_bar;
                            StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) C0756a.a(view, R.id.title_bar);
                            if (stepOSTitleBar != null) {
                                return new C0786c((LinearLayout) view, stepOSListItem, stepOSListItem2, stepOSListItem3, stepOSListItem4, stepOSListGroup, stepOSTitleBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i5)));
    }

    public static C0786c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static C0786c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z5) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_digital_wellbeing_privacy_settings, viewGroup, false);
        if (z5) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    public LinearLayout b() {
        return this.f17688a;
    }
}
