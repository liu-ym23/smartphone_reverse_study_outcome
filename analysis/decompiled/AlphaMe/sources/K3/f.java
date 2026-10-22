package K3;

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
import com.stepos.alphame.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import com.stepos.common.widget.Switch;
import java.util.HashMap;
import java.util.List;
import stepos.support.v7.widget.PermissionScrollView;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1063a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f1064b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f1065c;

    /* renamed from: d, reason: collision with root package name */
    public View f1066d;

    /* renamed from: e, reason: collision with root package name */
    public PermissionScrollView f1067e;

    /* renamed from: f, reason: collision with root package name */
    public StepOSNestedScrollView f1068f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f1069g;

    /* renamed from: h, reason: collision with root package name */
    public StepOSScrollBarView f1070h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f1071i;

    /* renamed from: j, reason: collision with root package name */
    public View f1072j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f1073k;

    /* renamed from: l, reason: collision with root package name */
    public CheckBox f1074l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f1075m;

    /* renamed from: n, reason: collision with root package name */
    public List f1076n;

    /* renamed from: o, reason: collision with root package name */
    public final stepos.support.v7.permission.d f1077o;

    /* renamed from: p, reason: collision with root package name */
    public final LayoutInflater f1078p;

    /* renamed from: q, reason: collision with root package name */
    public final int f1079q;

    /* renamed from: r, reason: collision with root package name */
    public final int f1080r;

    /* renamed from: s, reason: collision with root package name */
    public final int f1081s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1082t;

    /* renamed from: u, reason: collision with root package name */
    public final HashMap f1083u = new HashMap();

    public f(Context context) {
        this.f1063a = context;
        this.f1079q = context.getResources().getColor(R.color.stepos_alert_dialog_title_color_dark);
        this.f1080r = context.getResources().getColor(R.color.stepos_permission_dialog_item_title_dark);
        this.f1081s = context.getResources().getColor(R.color.stepos_permission_dialog_item_summary_dark);
        this.f1077o = stepos.support.v7.permission.d.a(context);
        this.f1078p = LayoutInflater.from(context);
    }

    public static void a(f fVar, View view, View view2, View view3) {
        fVar.getClass();
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    public final void b(LinearLayout linearLayout, String str, String str2, boolean z4) {
        boolean z5 = this.f1082t;
        int i4 = this.f1081s;
        int i5 = this.f1080r;
        LayoutInflater layoutInflater = this.f1078p;
        if (!z5) {
            if (linearLayout.getChildCount() != 0) {
                Context context = this.f1063a;
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
            if (z4) {
                textView.setTextColor(i5);
                textView2.setTextColor(i4);
            }
            linearLayout.addView(viewInflate);
            return;
        }
        View viewInflate2 = layoutInflater.inflate(R.layout.stepos_permission_dialog_item_intl, (ViewGroup) linearLayout, false);
        TextView textView3 = (TextView) viewInflate2.findViewById(R.id.switch_title);
        TextView textView4 = (TextView) viewInflate2.findViewById(R.id.switch_info);
        Switch r7 = (Switch) viewInflate2.findViewById(R.id.switch1);
        viewInflate2.setOnClickListener(new com.stepos.policy.sdk.dialog.a(r7, 1));
        r7.setOnCheckedChangeListener(new com.stepos.policy.sdk.dialog.b(1, str, this));
        textView3.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView4.setVisibility(8);
        } else {
            textView4.setText(str2);
        }
        if (z4) {
            textView3.setTextColor(i5);
            textView4.setTextColor(i4);
        }
        this.f1083u.put(str, Boolean.valueOf(r7.isChecked()));
        linearLayout.addView(viewInflate2);
    }

    public final View c(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f1063a).inflate(R.layout.stepos_permission_dialog, viewGroup, false);
        this.f1069g = (RelativeLayout) viewInflate.findViewById(R.id.permission_relative_layout);
        this.f1064b = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_title);
        this.f1065c = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_container);
        this.f1066d = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_up);
        this.f1067e = (PermissionScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_view);
        this.f1070h = (StepOSScrollBarView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollbarview_vertical);
        this.f1068f = (StepOSNestedScrollView) viewInflate.findViewById(R.id.stepos_permission_dialog_scrollview);
        this.f1071i = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_reminder);
        this.f1072j = viewInflate.findViewById(R.id.stepos_permission_dialog_scroll_indicator_down);
        this.f1073k = (LinearLayout) viewInflate.findViewById(R.id.stepos_permission_dialog_content_layout);
        this.f1074l = (CheckBox) viewInflate.findViewById(R.id.stepos_permission_dialog_checkbox);
        this.f1075m = (TextView) viewInflate.findViewById(R.id.stepos_permission_dialog_terms);
        l2.g.a(this.f1068f, this.f1070h);
        return viewInflate;
    }
}
