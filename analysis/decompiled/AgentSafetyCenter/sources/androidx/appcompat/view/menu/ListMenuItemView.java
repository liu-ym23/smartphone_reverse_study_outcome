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
import g.a;
import l.l;
import l.n;
import l.y;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements y, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: c, reason: collision with root package name */
    public n f728c;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f729f;

    /* renamed from: g, reason: collision with root package name */
    public RadioButton f730g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f731h;
    public CheckBox i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f732j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f733k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f734l;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f735m;

    /* renamed from: n, reason: collision with root package name */
    public final Drawable f736n;

    /* renamed from: o, reason: collision with root package name */
    public final int f737o;

    /* renamed from: p, reason: collision with root package name */
    public final Context f738p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f739q;

    /* renamed from: r, reason: collision with root package name */
    public final Drawable f740r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f741s;

    /* renamed from: t, reason: collision with root package name */
    public LayoutInflater f742t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f743u;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        m mVarJ = m.J(getContext(), attributeSet, a.f4114r, i);
        this.f736n = mVarJ.A(5);
        TypedArray typedArray = (TypedArray) mVarJ.f9742g;
        this.f737o = typedArray.getResourceId(1, -1);
        this.f739q = typedArray.getBoolean(7, false);
        this.f738p = context;
        this.f740r = mVarJ.A(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, com.stepos.agentsafetycenter.R.attr.dropDownListViewStyle, 0);
        this.f741s = typedArrayObtainStyledAttributes.hasValue(0);
        mVarJ.M();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f742t == null) {
            this.f742t = LayoutInflater.from(getContext());
        }
        return this.f742t;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f733k;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f734l;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f734l.getLayoutParams();
        rect.top = this.f734l.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // l.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(l.n r11) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.c(l.n):void");
    }

    @Override // l.y
    public n getItemData() {
        return this.f728c;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackground(this.f736n);
        TextView textView = (TextView) findViewById(com.stepos.agentsafetycenter.R.id.title);
        this.f731h = textView;
        int i = this.f737o;
        if (i != -1) {
            textView.setTextAppearance(this.f738p, i);
        }
        this.f732j = (TextView) findViewById(com.stepos.agentsafetycenter.R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(com.stepos.agentsafetycenter.R.id.submenuarrow);
        this.f733k = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f740r);
        }
        this.f734l = (ImageView) findViewById(com.stepos.agentsafetycenter.R.id.group_divider);
        this.f735m = (LinearLayout) findViewById(com.stepos.agentsafetycenter.R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        if (this.f729f != null && this.f739q) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f729f.getLayoutParams();
            int i10 = layoutParams.height;
            if (i10 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i10;
            }
        }
        super.onMeasure(i, i3);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f730g == null && this.i == null) {
            return;
        }
        if ((this.f728c.f7632x & 4) != 0) {
            if (this.f730g == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(com.stepos.agentsafetycenter.R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f730g = radioButton;
                LinearLayout linearLayout = this.f735m;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f730g;
            view = this.i;
        } else {
            if (this.i == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(com.stepos.agentsafetycenter.R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.i = checkBox;
                LinearLayout linearLayout2 = this.f735m;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.i;
            view = this.f730g;
        }
        if (z10) {
            compoundButton.setChecked(this.f728c.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.i;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f730g;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if ((this.f728c.f7632x & 4) != 0) {
            if (this.f730g == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(com.stepos.agentsafetycenter.R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f730g = radioButton;
                LinearLayout linearLayout = this.f735m;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f730g;
        } else {
            if (this.i == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(com.stepos.agentsafetycenter.R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.i = checkBox;
                LinearLayout linearLayout2 = this.f735m;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.i;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f743u = z10;
        this.f739q = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f734l;
        if (imageView != null) {
            imageView.setVisibility((this.f741s || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        l lVar = this.f728c.f7622n;
        boolean z10 = this.f743u;
        if (z10 || this.f739q) {
            ImageView imageView = this.f729f;
            if (imageView == null && drawable == null && !this.f739q) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(com.stepos.agentsafetycenter.R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f729f = imageView2;
                LinearLayout linearLayout = this.f735m;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f739q) {
                this.f729f.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f729f;
            if (!z10) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f729f.getVisibility() != 0) {
                this.f729f.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f731h;
        if (charSequence == null) {
            if (textView.getVisibility() != 8) {
                this.f731h.setVisibility(8);
            }
        } else {
            textView.setText(charSequence);
            if (this.f731h.getVisibility() != 0) {
                this.f731h.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.stepos.agentsafetycenter.R.attr.listMenuViewStyle);
    }
}
