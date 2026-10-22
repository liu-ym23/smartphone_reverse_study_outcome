package androidx.appcompat.view.menu;

import a4.d;
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
import c.a;
import com.stepos.stepclaw.R;
import f.j;
import f.k;
import f.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements q, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public k f255a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f256b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f257c;
    public TextView d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f258e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f259f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f260g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f261h;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout f262j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f263k;

    /* renamed from: l, reason: collision with root package name */
    public final int f264l;

    /* renamed from: m, reason: collision with root package name */
    public final Context f265m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f266n;

    /* renamed from: o, reason: collision with root package name */
    public final Drawable f267o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f268p;

    /* renamed from: q, reason: collision with root package name */
    public LayoutInflater f269q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f270r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d dVarE = d.E(getContext(), attributeSet, a.f1027o, R.attr.listMenuViewStyle);
        this.f263k = dVarE.t(5);
        TypedArray typedArray = (TypedArray) dVarE.f97c;
        this.f264l = typedArray.getResourceId(1, -1);
        this.f266n = typedArray.getBoolean(7, false);
        this.f265m = context;
        this.f267o = dVarE.t(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f268p = typedArrayObtainStyledAttributes.hasValue(0);
        dVarE.H();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f269q == null) {
            this.f269q = LayoutInflater.from(getContext());
        }
        return this.f269q;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f260g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f261h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f261h.getLayoutParams();
        rect.top = this.f261h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // f.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(f.k r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.b(f.k):void");
    }

    @Override // f.q
    public k getItemData() {
        return this.f255a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f263k);
        TextView textView = (TextView) findViewById(R.id.title);
        this.d = textView;
        int i8 = this.f264l;
        if (i8 != -1) {
            textView.setTextAppearance(this.f265m, i8);
        }
        this.f259f = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f260g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f267o);
        }
        this.f261h = (ImageView) findViewById(R.id.group_divider);
        this.f262j = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        if (this.f256b != null && this.f266n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f256b.getLayoutParams();
            int i10 = layoutParams.height;
            if (i10 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i10;
            }
        }
        super.onMeasure(i8, i9);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        View view;
        if (!z && this.f257c == null && this.f258e == null) {
            return;
        }
        if ((this.f255a.f2495x & 4) != 0) {
            if (this.f257c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f257c = radioButton;
                LinearLayout linearLayout = this.f262j;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f257c;
            view = this.f258e;
        } else {
            if (this.f258e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f258e = checkBox;
                LinearLayout linearLayout2 = this.f262j;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f258e;
            view = this.f257c;
        }
        if (z) {
            compoundButton.setChecked(this.f255a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.f258e;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f257c;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.f255a.f2495x & 4) != 0) {
            if (this.f257c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f257c = radioButton;
                LinearLayout linearLayout = this.f262j;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f257c;
        } else {
            if (this.f258e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f258e = checkBox;
                LinearLayout linearLayout2 = this.f262j;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.f258e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f270r = z;
        this.f266n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f261h;
        if (imageView != null) {
            imageView.setVisibility((this.f268p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        j jVar = this.f255a.f2485n;
        boolean z = this.f270r;
        if (z || this.f266n) {
            ImageView imageView = this.f256b;
            if (imageView == null && drawable == null && !this.f266n) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f256b = imageView2;
                LinearLayout linearLayout = this.f262j;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f266n) {
                this.f256b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f256b;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f256b.getVisibility() != 0) {
                this.f256b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.d.getVisibility() != 8) {
                this.d.setVisibility(8);
            }
        } else {
            this.d.setText(charSequence);
            if (this.d.getVisibility() != 0) {
                this.d.setVisibility(0);
            }
        }
    }
}
