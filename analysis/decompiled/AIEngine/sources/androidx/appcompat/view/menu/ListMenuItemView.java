package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.x0;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements k.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public h f415a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f416b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f417c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f418d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f419e;
    public TextView h;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f420j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f421k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f422l;

    /* renamed from: m, reason: collision with root package name */
    public final Drawable f423m;

    /* renamed from: n, reason: collision with root package name */
    public final int f424n;

    /* renamed from: o, reason: collision with root package name */
    public final Context f425o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f426p;

    /* renamed from: q, reason: collision with root package name */
    public final Drawable f427q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public LayoutInflater f428s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f429t;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        x0 x0VarE = x0.e(getContext(), attributeSet, g.a.r, R.attr.listMenuViewStyle);
        this.f423m = x0VarE.b(5);
        TypedArray typedArray = x0VarE.f948b;
        this.f424n = typedArray.getResourceId(1, -1);
        this.f426p = typedArray.getBoolean(7, false);
        this.f425o = context;
        this.f427q = x0VarE.b(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.r = typedArrayObtainStyledAttributes.hasValue(0);
        x0VarE.f();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f428s == null) {
            this.f428s = LayoutInflater.from(getContext());
        }
        return this.f428s;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f420j;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f421k;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f421k.getLayoutParams();
        rect.top = this.f421k.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // androidx.appcompat.view.menu.k.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(androidx.appcompat.view.menu.h r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.d(androidx.appcompat.view.menu.h):void");
    }

    @Override // androidx.appcompat.view.menu.k.a
    public h getItemData() {
        return this.f415a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f423m);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f418d = textView;
        int i10 = this.f424n;
        if (i10 != -1) {
            textView.setTextAppearance(this.f425o, i10);
        }
        this.h = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f420j = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f427q);
        }
        this.f421k = (ImageView) findViewById(R.id.group_divider);
        this.f422l = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (this.f416b != null && this.f426p) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f416b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f417c == null && this.f419e == null) {
            return;
        }
        if ((this.f415a.A & 4) != 0) {
            if (this.f417c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f417c = radioButton;
                LinearLayout linearLayout = this.f422l;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f417c;
            compoundButton2 = this.f419e;
        } else {
            if (this.f419e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f419e = checkBox;
                LinearLayout linearLayout2 = this.f422l;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f419e;
            compoundButton2 = this.f417c;
        }
        if (z) {
            compoundButton.setChecked(this.f415a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f419e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f417c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.f415a.A & 4) != 0) {
            if (this.f417c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f417c = radioButton;
                LinearLayout linearLayout = this.f422l;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f417c;
        } else {
            if (this.f419e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f419e = checkBox;
                LinearLayout linearLayout2 = this.f422l;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f419e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f429t = z;
        this.f426p = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f421k;
        if (imageView != null) {
            imageView.setVisibility((this.r || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f415a.f513q.f494v || this.f429t;
        if (z || this.f426p) {
            ImageView imageView = this.f416b;
            if (imageView == null && drawable == null && !this.f426p) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f416b = imageView2;
                LinearLayout linearLayout = this.f422l;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f426p) {
                this.f416b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f416b;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f416b.getVisibility() != 0) {
                this.f416b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f418d.getVisibility() != 8) {
                this.f418d.setVisibility(8);
            }
        } else {
            this.f418d.setText(charSequence);
            if (this.f418d.getVisibility() != 0) {
                this.f418d.setVisibility(0);
            }
        }
    }
}
