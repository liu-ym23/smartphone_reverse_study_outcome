package stepos.support.v7.view.menu;

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
import com.stepos.common.widget.NewMessageView;
import stepos.support.v7.view.menu.i;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements i.a {

    /* renamed from: a, reason: collision with root package name */
    private f f21227a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f21228b;

    /* renamed from: c, reason: collision with root package name */
    private RadioButton f21229c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f21230d;

    /* renamed from: e, reason: collision with root package name */
    private CheckBox f21231e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f21232f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable f21233g;

    /* renamed from: h, reason: collision with root package name */
    private int f21234h;

    /* renamed from: i, reason: collision with root package name */
    private Context f21235i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f21236j;

    /* renamed from: k, reason: collision with root package name */
    private int f21237k;

    /* renamed from: l, reason: collision with root package name */
    private Context f21238l;

    /* renamed from: m, reason: collision with root package name */
    private LayoutInflater f21239m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21240n;

    /* renamed from: o, reason: collision with root package name */
    private NewMessageView f21241o;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ListMenuItemView.this.f21230d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (ListMenuItemView.this.f21230d.getLineCount() > 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ListMenuItemView.this.getLayoutParams();
                layoutParams.height = -1;
                ListMenuItemView.this.setLayoutParams(layoutParams);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet);
        this.f21238l = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17068T1, i5, 0);
        this.f21233g = typedArrayObtainStyledAttributes.getDrawable(g.j.f17076V1);
        this.f21234h = typedArrayObtainStyledAttributes.getResourceId(g.j.f17072U1, -1);
        this.f21236j = typedArrayObtainStyledAttributes.getBoolean(g.j.f17084X1, false);
        this.f21235i = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private void b() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(g.g.f16952h, (ViewGroup) this, false);
        this.f21231e = checkBox;
        addView(checkBox);
    }

    private void e() {
        ImageView imageView = (ImageView) getInflater().inflate(X4.h.f6043o, (ViewGroup) this, false);
        this.f21228b = imageView;
        addView(imageView, 0);
    }

    private void f() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(g.g.f16955k, (ViewGroup) this, false);
        this.f21229c = radioButton;
        addView(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f21239m == null) {
            this.f21239m = LayoutInflater.from(this.f21238l);
        }
        return this.f21239m;
    }

    private void setLittleSpotVisibility(boolean z5) {
        NewMessageView newMessageView = this.f21241o;
        if (newMessageView != null) {
            newMessageView.setVisibility(z5 ? 0 : 8);
        }
    }

    @Override // stepos.support.v7.view.menu.i.a
    public boolean c() {
        return false;
    }

    @Override // stepos.support.v7.view.menu.i.a
    public void d(f fVar, int i5) {
        this.f21227a = fVar;
        this.f21237k = i5;
        setVisibility(fVar.isVisible() ? 0 : 8);
        setTitle(fVar.j(this));
        setCheckable(fVar.isCheckable());
        g(fVar.E(), fVar.g());
        setIcon(fVar.getIcon());
        setEnabled(fVar.isEnabled());
        this.f21230d.setAlpha(fVar.isEnabled() ? 1.0f : 0.25f);
        setLittleSpotVisibility(fVar.o());
        if (fVar.i() != null) {
            this.f21230d.setTextColor(fVar.i());
        }
    }

    public void g(boolean z5, char c6) {
        int i5 = (z5 && this.f21227a.E()) ? 0 : 8;
        if (i5 == 0) {
            this.f21232f.setText(this.f21227a.h());
        }
        if (this.f21232f.getVisibility() != i5) {
            this.f21232f.setVisibility(i5);
        }
    }

    @Override // stepos.support.v7.view.menu.i.a
    public f getItemData() {
        return this.f21227a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f21233g);
        TextView textView = (TextView) findViewById(X4.f.f6014r0);
        this.f21230d = textView;
        int i5 = this.f21234h;
        if (i5 != -1) {
            textView.setTextAppearance(this.f21235i, i5);
        }
        this.f21232f = (TextView) findViewById(X4.f.f5965M);
        this.f21241o = (NewMessageView) findViewById(X4.f.f5954B);
        this.f21230d.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        if (this.f21228b != null && this.f21236j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f21228b.getLayoutParams();
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
        if (!z5 && this.f21229c == null && this.f21231e == null) {
            return;
        }
        if (this.f21227a.n()) {
            if (this.f21229c == null) {
                f();
            }
            compoundButton = this.f21229c;
            view = this.f21231e;
        } else {
            if (this.f21231e == null) {
                b();
            }
            compoundButton = this.f21231e;
            view = this.f21229c;
        }
        if (!z5) {
            CheckBox checkBox = this.f21231e;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f21229c;
            if (radioButton != null) {
                radioButton.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f21227a.isChecked());
        int i5 = z5 ? 0 : 8;
        if (compoundButton.getVisibility() != i5) {
            compoundButton.setVisibility(i5);
        }
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        TextView textView = this.f21230d;
        if (textView instanceof CheckedTextView) {
            ((CheckedTextView) textView).setChecked(this.f21227a.isChecked());
        }
    }

    public void setChecked(boolean z5) {
        CompoundButton compoundButton;
        if (this.f21227a.n()) {
            if (this.f21229c == null) {
                f();
            }
            compoundButton = this.f21229c;
        } else {
            if (this.f21231e == null) {
                b();
            }
            compoundButton = this.f21231e;
        }
        compoundButton.setChecked(z5);
    }

    public void setForceShowIcon(boolean z5) {
        this.f21240n = z5;
        this.f21236j = z5;
    }

    public void setIcon(Drawable drawable) {
        boolean z5 = this.f21227a.D() || this.f21240n;
        if (z5 || this.f21236j) {
            ImageView imageView = this.f21228b;
            if (imageView == null && drawable == null && !this.f21236j) {
                return;
            }
            if (imageView == null) {
                e();
            }
            if (drawable == null && !this.f21236j) {
                this.f21228b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f21228b;
            if (!z5) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f21228b.getVisibility() != 0) {
                this.f21228b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f21230d.getVisibility() != 8) {
                this.f21230d.setVisibility(8);
            }
        } else {
            this.f21230d.setText(charSequence);
            if (this.f21230d.getVisibility() != 0) {
                this.f21230d.setVisibility(0);
            }
        }
    }

    @Override // stepos.support.v7.view.menu.i.a
    public void setTitleMaxLines(int i5) {
        TextView textView = this.f21230d;
        if (textView != null) {
            textView.setMaxLines(i5);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
