package Ua;

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
import com.stepos.ability.R;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import java.util.HashMap;
import java.util.List;
import stepos.support.v7.widget.PermissionScrollView;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1283a;
    public TextView b;
    public LinearLayout c;
    public View d;
    public PermissionScrollView e;
    public StepOSNestedScrollView f;
    public RelativeLayout g;
    public StepOSScrollBarView h;
    public TextView i;

    /* renamed from: j, reason: collision with root package name */
    public View f1284j;
    public LinearLayout k;
    public CheckBox l;
    public TextView m;
    public List n;
    public final stepos.support.v7.permission.d o;
    public final LayoutInflater p;

    /* renamed from: q, reason: collision with root package name */
    public final HashMap f1285q = new HashMap();

    public f(Context context) throws Resources.NotFoundException {
        this.f1283a = context;
        context.getResources().getColor(R.color.stepos_alert_dialog_title_color_dark);
        context.getResources().getColor(R.color.stepos_permission_dialog_item_title_dark);
        context.getResources().getColor(R.color.stepos_permission_dialog_item_summary_dark);
        this.o = stepos.support.v7.permission.d.a(context);
        this.p = LayoutInflater.from(context);
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
            Context context = this.f1283a;
            linearLayout.addView(new Space(context), new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, (float) 22.0d, context.getResources().getDisplayMetrics())));
        }
        View viewInflate = this.p.inflate(R.layout.stepos_permission_dialog_item, (ViewGroup) linearLayout, false);
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
