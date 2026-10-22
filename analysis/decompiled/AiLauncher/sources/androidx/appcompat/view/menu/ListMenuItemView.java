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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.U;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements j.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public g f8533a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f8534b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f8535c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f8536d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f8537e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f8538f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f8539g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f8540h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f8541i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f8542j;

    /* renamed from: k, reason: collision with root package name */
    public int f8543k;

    /* renamed from: l, reason: collision with root package name */
    public Context f8544l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8545m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f8546n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8547o;

    /* renamed from: p, reason: collision with root package name */
    public LayoutInflater f8548p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8549q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private void d() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f8537e = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f8534b = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f8535c = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f8548p == null) {
            this.f8548p = LayoutInflater.from(getContext());
        }
        return this.f8548p;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f8539g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f8540h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8540h.getLayoutParams();
        rect.top += this.f8540h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i10) {
        LinearLayout linearLayout = this.f8541i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void e(g gVar, int i10) {
        this.f8533a = gVar;
        setVisibility(gVar.isVisible() ? 0 : 8);
        setTitle(gVar.i(this));
        setCheckable(gVar.isCheckable());
        h(gVar.A(), gVar.g());
        setIcon(gVar.getIcon());
        setEnabled(gVar.isEnabled());
        setSubMenuArrowVisible(gVar.hasSubMenu());
        setContentDescription(gVar.getContentDescription());
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.f8533a;
    }

    public void h(boolean z10, char c10) {
        int i10 = (z10 && this.f8533a.A()) ? 0 : 8;
        if (i10 == 0) {
            this.f8538f.setText(this.f8533a.h());
        }
        if (this.f8538f.getVisibility() != i10) {
            this.f8538f.setVisibility(i10);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f8542j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f8536d = textView;
        int i10 = this.f8543k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f8544l, i10);
        }
        this.f8538f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f8539g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f8546n);
        }
        this.f8540h = (ImageView) findViewById(R$id.group_divider);
        this.f8541i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f8534b != null && this.f8545m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f8534b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f8535c == null && this.f8537e == null) {
            return;
        }
        if (this.f8533a.m()) {
            if (this.f8535c == null) {
                g();
            }
            compoundButton = this.f8535c;
            view = this.f8537e;
        } else {
            if (this.f8537e == null) {
                d();
            }
            compoundButton = this.f8537e;
            view = this.f8535c;
        }
        if (z10) {
            compoundButton.setChecked(this.f8533a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f8537e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f8535c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f8533a.m()) {
            if (this.f8535c == null) {
                g();
            }
            compoundButton = this.f8535c;
        } else {
            if (this.f8537e == null) {
                d();
            }
            compoundButton = this.f8537e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f8549q = z10;
        this.f8545m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f8540h;
        if (imageView != null) {
            imageView.setVisibility((this.f8547o || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f8533a.z() || this.f8549q;
        if (z10 || this.f8545m) {
            ImageView imageView = this.f8534b;
            if (imageView == null && drawable == null && !this.f8545m) {
                return;
            }
            if (imageView == null) {
                f();
            }
            if (drawable == null && !this.f8545m) {
                this.f8534b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f8534b;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f8534b.getVisibility() != 0) {
                this.f8534b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f8536d.getVisibility() != 8) {
                this.f8536d.setVisibility(8);
            }
        } else {
            this.f8536d.setText(charSequence);
            if (this.f8536d.getVisibility() != 0) {
                this.f8536d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        U uV = U.v(getContext(), attributeSet, R$styleable.MenuView, i10, 0);
        this.f8542j = uV.g(R$styleable.MenuView_android_itemBackground);
        this.f8543k = uV.n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f8545m = uV.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f8544l = context;
        this.f8546n = uV.g(R$styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f8547o = typedArrayObtainStyledAttributes.hasValue(0);
        uV.x();
        typedArrayObtainStyledAttributes.recycle();
    }
}
