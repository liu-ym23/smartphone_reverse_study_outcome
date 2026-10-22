package Ic;

import Ic.c;
import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.TransformationMethod;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.stepos.common.R$dimen;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import com.stepos.common.widget.Switch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import stepos.support.v7.appcompat.R$color;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.appcompat.R$layout;
import stepos.support.v7.widget.PermissionScrollView;

/* loaded from: classes5.dex */
public class g implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3450a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f3451b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f3452c;

    /* renamed from: d, reason: collision with root package name */
    public View f3453d;

    /* renamed from: e, reason: collision with root package name */
    public PermissionScrollView f3454e;

    /* renamed from: f, reason: collision with root package name */
    public StepOSNestedScrollView f3455f;

    /* renamed from: g, reason: collision with root package name */
    public RelativeLayout f3456g;

    /* renamed from: h, reason: collision with root package name */
    public StepOSScrollBarView f3457h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f3458i;

    /* renamed from: j, reason: collision with root package name */
    public View f3459j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f3460k;

    /* renamed from: l, reason: collision with root package name */
    public CheckBox f3461l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f3462m;

    /* renamed from: n, reason: collision with root package name */
    public List<stepos.support.v7.permission.d> f3463n;

    /* renamed from: o, reason: collision with root package name */
    public final stepos.support.v7.permission.e f3464o;

    /* renamed from: p, reason: collision with root package name */
    public final LayoutInflater f3465p;

    /* renamed from: q, reason: collision with root package name */
    public final int f3466q;

    /* renamed from: r, reason: collision with root package name */
    public final int f3467r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3468s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3469t;

    /* renamed from: u, reason: collision with root package name */
    public Map<String, Boolean> f3470u = new HashMap();

    public class a implements PermissionScrollView.a {
        public a() {
        }

        @Override // stepos.support.v7.widget.PermissionScrollView.a
        public void onScrollChange(View view, int i10, int i11, int i12, int i13) {
            g gVar = g.this;
            gVar.m(view, gVar.f3453d, g.this.f3459j);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.m(gVar.f3454e, g.this.f3453d, g.this.f3459j);
        }
    }

    public g(Context context) {
        this.f3450a = context;
        this.f3466q = context.getResources().getColor(R$color.stepos_alert_dialog_title_color_dark);
        this.f3467r = context.getResources().getColor(R$color.stepos_permission_dialog_item_title_dark);
        this.f3468s = context.getResources().getColor(R$color.stepos_permission_dialog_item_summary_dark);
        this.f3464o = stepos.support.v7.permission.e.b(context);
        this.f3465p = LayoutInflater.from(context);
    }

    @Override // Ic.d
    public void a(c.a aVar) {
        String[] strArr;
        if (aVar.f3443h) {
            this.f3451b.setText(aVar.f3436a);
            if (l(this.f3451b)) {
                this.f3451b.setGravity(17);
            }
        } else {
            this.f3451b.setVisibility(8);
        }
        if (aVar.f3442g) {
            this.f3451b.setTextColor(this.f3466q);
            this.f3462m.setTextColor(this.f3468s);
        }
        this.f3469t = aVar.f3444i;
        String[] strArr2 = aVar.f3438c;
        boolean z10 = strArr2 != null && strArr2.length > 0;
        List<Pair<String, String>> list = aVar.f3445j;
        boolean z11 = list != null && list.size() > 0;
        if (z10 || z11) {
            if (z10) {
                HashMap map = new HashMap();
                int i10 = 0;
                while (true) {
                    strArr = aVar.f3438c;
                    if (i10 >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i10], aVar.f3439d[i10]);
                    i10++;
                }
                List<stepos.support.v7.permission.d> listE = this.f3464o.e(strArr, false);
                this.f3463n = listE;
                for (stepos.support.v7.permission.d dVar : listE) {
                    if (dVar.i().size() > 0 && map.containsKey(dVar.e())) {
                        dVar.i().clear();
                    }
                }
                for (stepos.support.v7.permission.d dVar2 : this.f3463n) {
                    if (dVar2.i().size() > 0) {
                        for (stepos.support.v7.permission.c cVar : dVar2.i()) {
                            h(this.f3460k, cVar.b(this.f3450a), (String) map.get(cVar.c()), aVar.f3442g);
                        }
                    } else {
                        h(this.f3460k, dVar2.c(this.f3450a), (String) map.get(dVar2.e()), aVar.f3442g);
                    }
                }
            }
            if (z11) {
                for (Pair<String, String> pair : aVar.f3445j) {
                    h(this.f3460k, (String) pair.first, (String) pair.second, aVar.f3442g);
                }
            }
            this.f3454e.setOnScrollChangeListener(new a());
            this.f3454e.post(new b());
        } else {
            this.f3452c.setVisibility(8);
        }
        if (aVar.f3437b) {
            this.f3461l.setVisibility(0);
        } else {
            this.f3461l.setVisibility(8);
            ConstraintLayout.b bVar = (ConstraintLayout.b) this.f3456g.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = 0;
            this.f3456g.setLayoutParams(bVar);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3455f.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.f3455f.setLayoutParams(layoutParams);
        }
        if (!TextUtils.isEmpty(aVar.f3441f)) {
            this.f3458i.setText(aVar.f3441f);
            this.f3458i.setVisibility(0);
        } else {
            if (TextUtils.isEmpty(aVar.f3446k)) {
                this.f3458i.setVisibility(8);
                return;
            }
            this.f3458i.setText(aVar.f3446k);
            this.f3458i.setVisibility(0);
            this.f3458i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // Ic.d
    public View createView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f3450a).inflate(R$layout.stepos_permission_dialog, viewGroup, false);
        this.f3456g = (RelativeLayout) viewInflate.findViewById(R$id.permission_relative_layout);
        this.f3451b = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_title);
        this.f3452c = (LinearLayout) viewInflate.findViewById(R$id.stepos_permission_dialog_container);
        this.f3453d = viewInflate.findViewById(R$id.stepos_permission_dialog_scroll_indicator_up);
        this.f3454e = (PermissionScrollView) viewInflate.findViewById(R$id.stepos_permission_dialog_scroll_view);
        this.f3457h = (StepOSScrollBarView) viewInflate.findViewById(R$id.stepos_permission_dialog_scrollbarview_vertical);
        this.f3455f = (StepOSNestedScrollView) viewInflate.findViewById(R$id.stepos_permission_dialog_scrollview);
        this.f3458i = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_reminder);
        this.f3459j = viewInflate.findViewById(R$id.stepos_permission_dialog_scroll_indicator_down);
        this.f3460k = (LinearLayout) viewInflate.findViewById(R$id.stepos_permission_dialog_content_layout);
        this.f3461l = (CheckBox) viewInflate.findViewById(R$id.stepos_permission_dialog_checkbox);
        this.f3462m = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_terms);
        com.stepos.common.scrollbarview.d.b(this.f3455f, this.f3457h);
        return viewInflate;
    }

    @Override // Ic.d
    public CheckBox getCheckBox() {
        return this.f3461l;
    }

    @Override // Ic.d
    public List<stepos.support.v7.permission.d> getPermissions() {
        return this.f3463n;
    }

    @Override // Ic.d
    public TextView getTermsView() {
        return this.f3462m;
    }

    public final void h(ViewGroup viewGroup, String str, String str2, boolean z10) {
        if (this.f3469t) {
            i(viewGroup, str, str2, z10);
            return;
        }
        if (viewGroup.getChildCount() != 0) {
            viewGroup.addView(new Space(this.f3450a), new LinearLayout.LayoutParams(-1, Hc.a.a(this.f3450a, 22.0d)));
        }
        View viewInflate = this.f3465p.inflate(R$layout.stepos_permission_dialog_item, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_item_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.stepos_permission_dialog_item_summary);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z10) {
            textView.setTextColor(this.f3467r);
            textView2.setTextColor(this.f3468s);
        }
        viewGroup.addView(viewInflate);
    }

    public final void i(ViewGroup viewGroup, final String str, String str2, boolean z10) {
        View viewInflate = this.f3465p.inflate(R$layout.stepos_permission_dialog_item_intl, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(R$id.switch_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.switch_info);
        final Switch r32 = (Switch) viewInflate.findViewById(R$id.switch1);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: Ic.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r32.toggle();
            }
        });
        r32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: Ic.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                this.f3448a.f3470u.put(str, Boolean.valueOf(z11));
            }
        });
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z10) {
            textView.setTextColor(this.f3467r);
            textView2.setTextColor(this.f3468s);
        }
        this.f3470u.put(str, Boolean.valueOf(r32.isChecked()));
        viewGroup.addView(viewInflate);
    }

    public Map<String, Boolean> j() {
        return this.f3470u;
    }

    public final int k(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }

    public final boolean l(TextView textView) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (k(textView, textView.getText().toString()) + (textView.getPaddingLeft() + textView.getPaddingRight())) + (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) <= this.f3450a.getResources().getDimensionPixelOffset(R$dimen.stepos_alert_dialog_width);
    }

    public final void m(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }
}
