package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.c;
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
import androidx.annotation.RestrictTo;
import com.stepos.alphame.R;
import e.EnumC0546d;
import g.AbstractC0560a;
import k.C0663q;
import k.InterfaceC0641B;

@RestrictTo({EnumC0546d.f12494c})
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC0641B, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public C0663q f2704a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f2705b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f2706c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f2707d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f2708e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f2709f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f2710g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f2711h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f2712i;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f2713j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2714k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f2715l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2716m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f2717n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f2718o;

    /* renamed from: p, reason: collision with root package name */
    public LayoutInflater f2719p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2720q;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c cVarY = c.y(R.attr.listMenuViewStyle, 0, getContext(), attributeSet, AbstractC0560a.f12605r);
        this.f2713j = cVarY.l(5);
        this.f2714k = cVarY.r(1, -1);
        this.f2716m = cVarY.g(7, false);
        this.f2715l = context;
        this.f2717n = cVarY.l(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f2718o = typedArrayObtainStyledAttributes.hasValue(0);
        cVarY.A();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f2719p == null) {
            this.f2719p = LayoutInflater.from(getContext());
        }
        return this.f2719p;
    }

    private void setSubMenuArrowVisible(boolean z4) {
        ImageView imageView = this.f2710g;
        if (imageView != null) {
            imageView.setVisibility(z4 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2711h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2711h.getLayoutParams();
        rect.top = this.f2711h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    @Override // k.InterfaceC0641B
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(k.C0663q r11) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.c(k.q):void");
    }

    @Override // k.InterfaceC0641B
    public C0663q getItemData() {
        return this.f2704a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f2713j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f2707d = textView;
        int i4 = this.f2714k;
        if (i4 != -1) {
            textView.setTextAppearance(this.f2715l, i4);
        }
        this.f2709f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f2710g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2717n);
        }
        this.f2711h = (ImageView) findViewById(R.id.group_divider);
        this.f2712i = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        if (this.f2705b != null && this.f2716m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2705b.getLayoutParams();
            int i6 = layoutParams.height;
            if (i6 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i6;
            }
        }
        super.onMeasure(i4, i5);
    }

    public void setCheckable(boolean z4) {
        CompoundButton compoundButton;
        View view;
        if (!z4 && this.f2706c == null && this.f2708e == null) {
            return;
        }
        if ((this.f2704a.f13292x & 4) != 0) {
            if (this.f2706c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f2706c = radioButton;
                LinearLayout linearLayout = this.f2712i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f2706c;
            view = this.f2708e;
        } else {
            if (this.f2708e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f2708e = checkBox;
                LinearLayout linearLayout2 = this.f2712i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f2708e;
            view = this.f2706c;
        }
        if (z4) {
            compoundButton.setChecked(this.f2704a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f2708e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f2706c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if ((this.f2704a.f13292x & 4) != 0) {
            if (this.f2706c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f2706c = radioButton;
                LinearLayout linearLayout = this.f2712i;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f2706c;
        } else {
            if (this.f2708e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f2708e = checkBox;
                LinearLayout linearLayout2 = this.f2712i;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f2708e;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f2720q = z4;
        this.f2716m = z4;
    }

    public void setGroupDividerEnabled(boolean z4) {
        ImageView imageView = this.f2711h;
        if (imageView != null) {
            imageView.setVisibility((this.f2718o || !z4) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2704a.f13282n.getClass();
        boolean z4 = this.f2720q;
        if (z4 || this.f2716m) {
            ImageView imageView = this.f2705b;
            if (imageView == null && drawable == null && !this.f2716m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f2705b = imageView2;
                LinearLayout linearLayout = this.f2712i;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f2716m) {
                this.f2705b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f2705b;
            if (!z4) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f2705b.getVisibility() != 0) {
                this.f2705b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f2707d.getVisibility() != 8) {
                this.f2707d.setVisibility(8);
            }
        } else {
            this.f2707d.setText(charSequence);
            if (this.f2707d.getVisibility() != 0) {
                this.f2707d.setVisibility(0);
            }
        }
    }
}
