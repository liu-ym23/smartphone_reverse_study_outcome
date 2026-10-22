package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.a0;
import g.C0728a;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    private g f7794a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f7795b;

    /* renamed from: c, reason: collision with root package name */
    private RadioButton f7796c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f7797d;

    /* renamed from: e, reason: collision with root package name */
    private CheckBox f7798e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f7799f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f7800g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f7801h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f7802i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f7803j;

    /* renamed from: k, reason: collision with root package name */
    private int f7804k;

    /* renamed from: l, reason: collision with root package name */
    private Context f7805l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f7806m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f7807n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7808o;

    /* renamed from: p, reason: collision with root package name */
    private LayoutInflater f7809p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f7810q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0728a.f16811H);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i5) {
        LinearLayout linearLayout = this.f7802i;
        if (linearLayout != null) {
            linearLayout.addView(view, i5);
        } else {
            addView(view, i5);
        }
    }

    private void d() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.g.f16952h, (ViewGroup) this, false);
        this.f7798e = checkBox;
        a(checkBox);
    }

    private void e() {
        ImageView imageView = (ImageView) getInflater().inflate(g.g.f16953i, (ViewGroup) this, false);
        this.f7795b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.g.f16955k, (ViewGroup) this, false);
        this.f7796c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f7809p == null) {
            this.f7809p = LayoutInflater.from(getContext());
        }
        return this.f7809p;
    }

    private void setSubMenuArrowVisible(boolean z5) {
        ImageView imageView = this.f7800g;
        if (imageView != null) {
            imageView.setVisibility(z5 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f7801h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7801h.getLayoutParams();
        rect.top += this.f7801h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void f(g gVar, int i5) {
        this.f7794a = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.f7794a;
    }

    public void h(boolean z5, char c6) {
        int i5 = (z5 && this.f7794a.A()) ? 0 : 8;
        if (i5 == 0) {
            this.f7799f.setText(this.f7794a.h());
        }
        if (this.f7799f.getVisibility() != i5) {
            this.f7799f.setVisibility(i5);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f7803j);
        TextView textView = (TextView) findViewById(g.f.f16915C);
        this.f7797d = textView;
        int i5 = this.f7804k;
        if (i5 != -1) {
            textView.setTextAppearance(this.f7805l, i5);
        }
        this.f7799f = (TextView) findViewById(g.f.f16941w);
        ImageView imageView = (ImageView) findViewById(g.f.f16944z);
        this.f7800g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f7807n);
        }
        this.f7801h = (ImageView) findViewById(g.f.f16936r);
        this.f7802i = (LinearLayout) findViewById(g.f.f16930l);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        if (this.f7795b != null && this.f7806m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f7795b.getLayoutParams();
            int i7 = layoutParams.height;
            if (i7 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i7;
            }
        }
        super.onMeasure(i5, i6);
    }

    public void setCheckable(boolean z5) {
        CompoundButton compoundButton;
        View view;
        if (!z5 && this.f7796c == null && this.f7798e == null) {
            return;
        }
        if (this.f7794a.m()) {
            if (this.f7796c == null) {
                g();
            }
            compoundButton = this.f7796c;
            view = this.f7798e;
        } else {
            if (this.f7798e == null) {
                d();
            }
            compoundButton = this.f7798e;
            view = this.f7796c;
        }
        if (z5) {
            compoundButton.setChecked(this.f7794a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f7798e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f7796c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z5) {
        CompoundButton compoundButton;
        if (this.f7794a.m()) {
            if (this.f7796c == null) {
                g();
            }
            compoundButton = this.f7796c;
        } else {
            if (this.f7798e == null) {
                d();
            }
            compoundButton = this.f7798e;
        }
        compoundButton.setChecked(z5);
    }

    public void setForceShowIcon(boolean z5) {
        this.f7810q = z5;
        this.f7806m = z5;
    }

    public void setGroupDividerEnabled(boolean z5) {
        ImageView imageView = this.f7801h;
        if (imageView != null) {
            imageView.setVisibility((this.f7808o || !z5) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z5 = this.f7794a.z() || this.f7810q;
        if (z5 || this.f7806m) {
            ImageView imageView = this.f7795b;
            if (imageView == null && drawable == null && !this.f7806m) {
                return;
            }
            if (imageView == null) {
                e();
            }
            if (drawable == null && !this.f7806m) {
                this.f7795b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f7795b;
            if (!z5) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f7795b.getVisibility() != 0) {
                this.f7795b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f7797d.getVisibility() != 8) {
                this.f7797d.setVisibility(8);
            }
        } else {
            this.f7797d.setText(charSequence);
            if (this.f7797d.getVisibility() != 0) {
                this.f7797d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet);
        a0 a0VarV = a0.v(getContext(), attributeSet, g.j.f17068T1, i5, 0);
        this.f7803j = a0VarV.g(g.j.f17076V1);
        this.f7804k = a0VarV.n(g.j.f17072U1, -1);
        this.f7806m = a0VarV.a(g.j.f17084X1, false);
        this.f7805l = context;
        this.f7807n = a0VarV.g(g.j.f17088Y1);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, C0728a.f16808E, 0);
        this.f7808o = typedArrayObtainStyledAttributes.hasValue(0);
        a0VarV.x();
        typedArrayObtainStyledAttributes.recycle();
    }
}
