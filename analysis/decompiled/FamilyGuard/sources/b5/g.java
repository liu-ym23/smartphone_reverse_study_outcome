package b5;

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
import b5.c;
import com.stepos.common.scrollbarview.StepOSScrollBarView;
import com.stepos.common.scrollview.StepOSNestedScrollView;
import com.stepos.common.widget.Switch;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import stepos.support.v7.widget.PermissionScrollView;

/* loaded from: classes.dex */
public class g implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f11853a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f11854b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f11855c;

    /* renamed from: d, reason: collision with root package name */
    private View f11856d;

    /* renamed from: e, reason: collision with root package name */
    private PermissionScrollView f11857e;

    /* renamed from: f, reason: collision with root package name */
    private StepOSNestedScrollView f11858f;

    /* renamed from: g, reason: collision with root package name */
    private RelativeLayout f11859g;

    /* renamed from: h, reason: collision with root package name */
    private StepOSScrollBarView f11860h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f11861i;

    /* renamed from: j, reason: collision with root package name */
    private View f11862j;

    /* renamed from: k, reason: collision with root package name */
    private LinearLayout f11863k;

    /* renamed from: l, reason: collision with root package name */
    private CheckBox f11864l;

    /* renamed from: m, reason: collision with root package name */
    private TextView f11865m;

    /* renamed from: n, reason: collision with root package name */
    private List<Z4.d> f11866n;

    /* renamed from: o, reason: collision with root package name */
    private final Z4.e f11867o;

    /* renamed from: p, reason: collision with root package name */
    private final LayoutInflater f11868p;

    /* renamed from: q, reason: collision with root package name */
    private final int f11869q;

    /* renamed from: r, reason: collision with root package name */
    private final int f11870r;

    /* renamed from: s, reason: collision with root package name */
    private final int f11871s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f11872t;

    /* renamed from: u, reason: collision with root package name */
    private Map<String, Boolean> f11873u = new HashMap();

    class a implements PermissionScrollView.a {
        a() {
        }

        @Override // stepos.support.v7.widget.PermissionScrollView.a
        public void onScrollChange(View view, int i5, int i6, int i7, int i8) {
            g gVar = g.this;
            gVar.m(view, gVar.f11856d, g.this.f11862j);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            gVar.m(gVar.f11857e, g.this.f11856d, g.this.f11862j);
        }
    }

    public g(Context context) {
        this.f11853a = context;
        this.f11869q = context.getResources().getColor(X4.c.f5859e);
        this.f11870r = context.getResources().getColor(X4.c.f5862h);
        this.f11871s = context.getResources().getColor(X4.c.f5861g);
        this.f11867o = Z4.e.b(context);
        this.f11868p = LayoutInflater.from(context);
    }

    private void h(ViewGroup viewGroup, String str, String str2, boolean z5) {
        if (this.f11872t) {
            i(viewGroup, str, str2, z5);
            return;
        }
        if (viewGroup.getChildCount() != 0) {
            viewGroup.addView(new Space(this.f11853a), new LinearLayout.LayoutParams(-1, a5.a.a(this.f11853a, 22.0d)));
        }
        View viewInflate = this.f11868p.inflate(X4.h.f6047s, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(X4.f.f5984c0);
        TextView textView2 = (TextView) viewInflate.findViewById(X4.f.f5982b0);
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z5) {
            textView.setTextColor(this.f11870r);
            textView2.setTextColor(this.f11871s);
        }
        viewGroup.addView(viewInflate);
    }

    private void i(ViewGroup viewGroup, final String str, String str2, boolean z5) {
        View viewInflate = this.f11868p.inflate(X4.h.f6048t, viewGroup, false);
        TextView textView = (TextView) viewInflate.findViewById(X4.f.f6010p0);
        TextView textView2 = (TextView) viewInflate.findViewById(X4.f.f6008o0);
        final Switch r32 = (Switch) viewInflate.findViewById(X4.f.f6006n0);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: b5.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r32.toggle();
            }
        });
        r32.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b5.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z6) {
                this.f11851a.f11873u.put(str, Boolean.valueOf(z6));
            }
        });
        textView.setText(str);
        if (TextUtils.isEmpty(str2)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(str2);
        }
        if (z5) {
            textView.setTextColor(this.f11870r);
            textView2.setTextColor(this.f11871s);
        }
        this.f11873u.put(str, Boolean.valueOf(r32.isChecked()));
        viewGroup.addView(viewInflate);
    }

    private int k(TextView textView, String str) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, textView).toString();
        }
        return (int) textView.getPaint().measureText(str);
    }

    private boolean l(TextView textView) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        return (k(textView, textView.getText().toString()) + (textView.getPaddingLeft() + textView.getPaddingRight())) + (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) <= this.f11853a.getResources().getDimensionPixelOffset(H1.f.f2128X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    @Override // b5.d
    public void a(c.a aVar) {
        String[] strArr;
        if (aVar.f11846h) {
            this.f11854b.setText(aVar.f11839a);
            if (l(this.f11854b)) {
                this.f11854b.setGravity(17);
            }
        } else {
            this.f11854b.setVisibility(8);
        }
        if (aVar.f11845g) {
            this.f11854b.setTextColor(this.f11869q);
            this.f11865m.setTextColor(this.f11871s);
        }
        this.f11872t = aVar.f11847i;
        String[] strArr2 = aVar.f11841c;
        boolean z5 = strArr2 != null && strArr2.length > 0;
        List<Pair<String, String>> list = aVar.f11848j;
        boolean z6 = list != null && list.size() > 0;
        if (z5 || z6) {
            if (z5) {
                HashMap map = new HashMap();
                int i5 = 0;
                while (true) {
                    strArr = aVar.f11841c;
                    if (i5 >= strArr.length) {
                        break;
                    }
                    map.put(strArr[i5], aVar.f11842d[i5]);
                    i5++;
                }
                List<Z4.d> listE = this.f11867o.e(strArr, false);
                this.f11866n = listE;
                for (Z4.d dVar : listE) {
                    if (dVar.i().size() > 0 && map.containsKey(dVar.g())) {
                        dVar.i().clear();
                    }
                }
                for (Z4.d dVar2 : this.f11866n) {
                    if (dVar2.i().size() > 0) {
                        for (Z4.c cVar : dVar2.i()) {
                            h(this.f11863k, cVar.d(this.f11853a), (String) map.get(cVar.e()), aVar.f11845g);
                        }
                    } else {
                        h(this.f11863k, dVar2.e(this.f11853a), (String) map.get(dVar2.g()), aVar.f11845g);
                    }
                }
            }
            if (z6) {
                for (Pair<String, String> pair : aVar.f11848j) {
                    h(this.f11863k, (String) pair.first, (String) pair.second, aVar.f11845g);
                }
            }
            this.f11857e.setOnScrollChangeListener(new a());
            this.f11857e.post(new b());
        } else {
            this.f11855c.setVisibility(8);
        }
        if (aVar.f11840b) {
            this.f11864l.setVisibility(0);
        } else {
            this.f11864l.setVisibility(8);
            ConstraintLayout.b bVar = (ConstraintLayout.b) this.f11859g.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = 0;
            this.f11859g.setLayoutParams(bVar);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11858f.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.f11858f.setLayoutParams(layoutParams);
        }
        if (!TextUtils.isEmpty(aVar.f11844f)) {
            this.f11861i.setText(aVar.f11844f);
            this.f11861i.setVisibility(0);
        } else {
            if (TextUtils.isEmpty(aVar.f11849k)) {
                this.f11861i.setVisibility(8);
                return;
            }
            this.f11861i.setText(aVar.f11849k);
            this.f11861i.setVisibility(0);
            this.f11861i.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // b5.d
    public View createView(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f11853a).inflate(X4.h.f6046r, viewGroup, false);
        this.f11859g = (RelativeLayout) viewInflate.findViewById(X4.f.f5959G);
        this.f11854b = (TextView) viewInflate.findViewById(X4.f.f6002l0);
        this.f11855c = (LinearLayout) viewInflate.findViewById(X4.f.f5978Z);
        this.f11856d = viewInflate.findViewById(X4.f.f5992g0);
        this.f11857e = (PermissionScrollView) viewInflate.findViewById(X4.f.f5994h0);
        this.f11860h = (StepOSScrollBarView) viewInflate.findViewById(X4.f.f5996i0);
        this.f11858f = (StepOSNestedScrollView) viewInflate.findViewById(X4.f.f5998j0);
        this.f11861i = (TextView) viewInflate.findViewById(X4.f.f5988e0);
        this.f11862j = viewInflate.findViewById(X4.f.f5990f0);
        this.f11863k = (LinearLayout) viewInflate.findViewById(X4.f.f5980a0);
        this.f11864l = (CheckBox) viewInflate.findViewById(X4.f.f5977Y);
        this.f11865m = (TextView) viewInflate.findViewById(X4.f.f6000k0);
        com.stepos.common.scrollbarview.d.b(this.f11858f, this.f11860h);
        return viewInflate;
    }

    @Override // b5.d
    public CheckBox getCheckBox() {
        return this.f11864l;
    }

    @Override // b5.d
    public List<Z4.d> getPermissions() {
        return this.f11866n;
    }

    @Override // b5.d
    public TextView getTermsView() {
        return this.f11865m;
    }

    public Map<String, Boolean> j() {
        return this.f11873u;
    }
}
