package fe;

import android.content.Context;
import android.content.res.Resources;
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
import com.stepos.aiengine.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.HashMap;
import java.util.List;
import stepos.support.v7.widget.PermissionScrollView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8861a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f8862b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f8863c;

    /* renamed from: d, reason: collision with root package name */
    public View f8864d;

    /* renamed from: e, reason: collision with root package name */
    public PermissionScrollView f8865e;

    /* renamed from: f, reason: collision with root package name */
    public StepOSNestedScrollView f8866f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f8867g;
    public StepOSScrollBarView h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f8868i;

    /* renamed from: j, reason: collision with root package name */
    public View f8869j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f8870k;

    /* renamed from: l, reason: collision with root package name */
    public CheckBox f8871l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f8872m;

    /* renamed from: n, reason: collision with root package name */
    public List<stepos.support.v7.permission.d> f8873n;

    /* renamed from: o, reason: collision with root package name */
    public final stepos.support.v7.permission.e f8874o;

    /* renamed from: p, reason: collision with root package name */
    public final LayoutInflater f8875p;

    /* renamed from: q, reason: collision with root package name */
    public final HashMap f8876q = new HashMap();

    public f(Context context) throws Resources.NotFoundException {
        this.f8861a = context;
        context.getResources().getColor(R.color.stepos_alert_dialog_title_color_dark);
        context.getResources().getColor(R.color.stepos_permission_dialog_item_title_dark);
        context.getResources().getColor(R.color.stepos_permission_dialog_item_summary_dark);
        this.f8874o = stepos.support.v7.permission.e.a(context);
        this.f8875p = LayoutInflater.from(context);
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

    public final void b(LinearLayout linearLayout, String str, String str2) {
        if (linearLayout.getChildCount() != 0) {
            Context context = this.f8861a;
            linearLayout.addView(new Space(context), new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, (float) 22.0d, context.getResources().getDisplayMetrics())));
        }
        View viewInflate = this.f8875p.inflate(R.layout.stepos_permission_dialog_item, (ViewGroup) linearLayout, false);
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
