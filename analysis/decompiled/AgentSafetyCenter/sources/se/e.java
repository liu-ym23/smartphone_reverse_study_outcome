package se;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.stepos.agentsafetycenter.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.HashMap;
import java.util.List;
import stepos.support.v7.widget.PermissionScrollView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public Context f12206a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f12207b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f12208c;

    /* renamed from: d, reason: collision with root package name */
    public View f12209d;

    /* renamed from: e, reason: collision with root package name */
    public PermissionScrollView f12210e;

    /* renamed from: f, reason: collision with root package name */
    public StepOSNestedScrollView f12211f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f12212g;

    /* renamed from: h, reason: collision with root package name */
    public StepOSScrollBarView f12213h;
    public TextView i;

    /* renamed from: j, reason: collision with root package name */
    public View f12214j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f12215k;

    /* renamed from: l, reason: collision with root package name */
    public CheckBox f12216l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f12217m;

    /* renamed from: n, reason: collision with root package name */
    public List f12218n;

    /* renamed from: o, reason: collision with root package name */
    public qe.d f12219o;

    /* renamed from: p, reason: collision with root package name */
    public LayoutInflater f12220p;

    /* renamed from: q, reason: collision with root package name */
    public HashMap f12221q;

    public static void a(e eVar, View view, View view2, View view3) {
        eVar.getClass();
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public final void b(LinearLayout linearLayout, String str, String str2) {
        Context context = this.f12206a;
        LayoutInflater layoutInflater = this.f12220p;
        if (linearLayout.getChildCount() != 0) {
            linearLayout.addView(new Space(context), new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, (float) 22.0d, context.getResources().getDisplayMetrics())));
        }
        View viewInflate = layoutInflater.inflate(R.layout.stepos_permission_dialog_item, (ViewGroup) linearLayout, false);
        TextView textView = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_item_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_item_summary);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        linearLayout.addView(viewInflate);
    }
}
