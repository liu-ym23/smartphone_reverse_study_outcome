package stepos.support.v7.view.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import com.stepos.common.widget.NewMessageView;
import stepos.support.v7.appcompat.R$id;
import stepos.support.v7.view.menu.h;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class ListMenuItemView extends LinearLayout implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public e f40891a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f40892b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f40893c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f40894d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f40895e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f40896f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f40897g;

    /* renamed from: h, reason: collision with root package name */
    public int f40898h;

    /* renamed from: i, reason: collision with root package name */
    public Context f40899i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40900j;

    /* renamed from: k, reason: collision with root package name */
    public int f40901k;

    /* renamed from: l, reason: collision with root package name */
    public Context f40902l;

    /* renamed from: m, reason: collision with root package name */
    public LayoutInflater f40903m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f40904n;

    /* renamed from: o, reason: collision with root package name */
    public NewMessageView f40905o;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ListMenuItemView.this.f40894d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (ListMenuItemView.this.f40894d.getLineCount() > 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ListMenuItemView.this.getLayoutParams();
                layoutParams.height = -1;
                ListMenuItemView.this.setLayoutParams(layoutParams);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        this.f40902l = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MenuView, i10, 0);
        this.f40897g = typedArrayObtainStyledAttributes.getDrawable(R$styleable.MenuView_android_itemBackground);
        this.f40898h = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f40900j = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MenuView_preserveIconSpacing, false);
        this.f40899i = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f40903m == null) {
            this.f40903m = LayoutInflater.from(this.f40902l);
        }
        return this.f40903m;
    }

    private void setLittleSpotVisibility(boolean z10) {
        NewMessageView newMessageView = this.f40905o;
        if (newMessageView != null) {
            newMessageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void b() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f40895e = checkBox;
        addView(checkBox);
    }

    @Override // stepos.support.v7.view.menu.h.a
    public boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void d(e eVar, int i10) {
        this.f40891a = eVar;
        this.f40901k = i10;
        setVisibility(eVar.isVisible() ? 0 : 8);
        setTitle(eVar.j(this));
        setCheckable(eVar.isCheckable());
        g(eVar.E(), eVar.g());
        setIcon(eVar.getIcon());
        setEnabled(eVar.isEnabled());
        this.f40894d.setAlpha(eVar.isEnabled() ? 1.0f : 0.25f);
        setLittleSpotVisibility(eVar.o());
        if (eVar.i() != null) {
            this.f40894d.setTextColor(eVar.i());
        }
    }

    public final void e() {
        ImageView imageView = (ImageView) getInflater().inflate(stepos.support.v7.appcompat.R$layout.stepos_list_menu_item_icon, (ViewGroup) this, false);
        this.f40892b = imageView;
        addView(imageView, 0);
    }

    public final void f() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f40893c = radioButton;
        addView(radioButton);
    }

    public void g(boolean z10, char c10) {
        int i10 = (z10 && this.f40891a.E()) ? 0 : 8;
        if (i10 == 0) {
            this.f40896f.setText(this.f40891a.h());
        }
        if (this.f40896f.getVisibility() != i10) {
            this.f40896f.setVisibility(i10);
        }
    }

    @Override // stepos.support.v7.view.menu.h.a
    public e getItemData() {
        return this.f40891a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f40897g);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f40894d = textView;
        int i10 = this.f40898h;
        if (i10 != -1) {
            textView.setTextAppearance(this.f40899i, i10);
        }
        this.f40896f = (TextView) findViewById(R$id.shortcut);
        this.f40905o = (NewMessageView) findViewById(R$id.message_point);
        this.f40894d.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f40892b != null && this.f40900j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f40892b.getLayoutParams();
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
        if (!z10 && this.f40893c == null && this.f40895e == null) {
            return;
        }
        if (this.f40891a.n()) {
            if (this.f40893c == null) {
                f();
            }
            compoundButton = this.f40893c;
            view = this.f40895e;
        } else {
            if (this.f40895e == null) {
                b();
            }
            compoundButton = this.f40895e;
            view = this.f40893c;
        }
        if (!z10) {
            CheckBox checkBox = this.f40895e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f40893c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f40891a.isChecked());
        int i10 = z10 ? 0 : 8;
        if (compoundButton.getVisibility() != i10) {
            compoundButton.setVisibility(i10);
        }
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        TextView textView = this.f40894d;
        if (textView instanceof CheckedTextView) {
            ((CheckedTextView) textView).setChecked(this.f40891a.isChecked());
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f40891a.n()) {
            if (this.f40893c == null) {
                f();
            }
            compoundButton = this.f40893c;
        } else {
            if (this.f40895e == null) {
                b();
            }
            compoundButton = this.f40895e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f40904n = z10;
        this.f40900j = z10;
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f40891a.D() || this.f40904n;
        if (z10 || this.f40900j) {
            ImageView imageView = this.f40892b;
            if (imageView == null && drawable == null && !this.f40900j) {
                return;
            }
            if (imageView == null) {
                e();
            }
            if (drawable == null && !this.f40900j) {
                this.f40892b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f40892b;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f40892b.getVisibility() != 0) {
                this.f40892b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f40894d.getVisibility() != 8) {
                this.f40894d.setVisibility(8);
            }
        } else {
            this.f40894d.setText(charSequence);
            if (this.f40894d.getVisibility() != 0) {
                this.f40894d.setVisibility(0);
            }
        }
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void setTitleMaxLines(int i10) {
        TextView textView = this.f40894d;
        if (textView != null) {
            textView.setMaxLines(i10);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
