package stepos.support.v7.view.menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.stepos.aiengine.R;
import com.stepos.common.widget.NewMessageView;
import stepos.support.v7.view.menu.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public e f12346a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f12347b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f12348c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f12349d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f12350e;
    public TextView h;

    /* renamed from: j, reason: collision with root package name */
    public final Drawable f12351j;

    /* renamed from: k, reason: collision with root package name */
    public final int f12352k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f12353l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12354m;

    /* renamed from: n, reason: collision with root package name */
    public final Context f12355n;

    /* renamed from: o, reason: collision with root package name */
    public LayoutInflater f12356o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12357p;

    /* renamed from: q, reason: collision with root package name */
    public NewMessageView f12358q;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ListMenuItemView listMenuItemView = ListMenuItemView.this;
            listMenuItemView.f12349d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (listMenuItemView.f12349d.getLineCount() > 1) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) listMenuItemView.getLayoutParams();
                layoutParams.height = -1;
                listMenuItemView.setLayoutParams(layoutParams);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12355n = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.a.r, 0, 0);
        this.f12351j = typedArrayObtainStyledAttributes.getDrawable(5);
        this.f12352k = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f12354m = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f12353l = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f12356o == null) {
            this.f12356o = LayoutInflater.from(this.f12355n);
        }
        return this.f12356o;
    }

    private void setLittleSpotVisibility(boolean z) {
        NewMessageView newMessageView = this.f12358q;
        if (newMessageView != null) {
            newMessageView.setVisibility(z ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // stepos.support.v7.view.menu.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(stepos.support.v7.view.menu.e r8) {
        /*
            r7 = this;
            r7.f12346a = r8
            boolean r0 = r8.isVisible()
            stepos.support.v7.view.menu.c r1 = r8.f12409q
            r2 = 8
            r3 = 0
            if (r0 == 0) goto Lf
            r0 = r3
            goto L10
        Lf:
            r0 = r2
        L10:
            r7.setVisibility(r0)
            java.lang.CharSequence r0 = r8.f12401e
            r7.setTitle(r0)
            boolean r0 = r8.isCheckable()
            r7.setCheckable(r0)
            boolean r0 = r1.n()
            r4 = 1
            if (r0 == 0) goto L35
            boolean r0 = r1.m()
            if (r0 == 0) goto L2f
            char r0 = r8.f12405m
            goto L31
        L2f:
            char r0 = r8.f12403k
        L31:
            if (r0 == 0) goto L35
            r0 = r4
            goto L36
        L35:
            r0 = r3
        L36:
            r1.m()
            if (r0 == 0) goto L58
            stepos.support.v7.view.menu.e r0 = r7.f12346a
            stepos.support.v7.view.menu.c r1 = r0.f12409q
            boolean r5 = r1.n()
            if (r5 == 0) goto L53
            boolean r1 = r1.m()
            if (r1 == 0) goto L4e
            char r0 = r0.f12405m
            goto L50
        L4e:
            char r0 = r0.f12403k
        L50:
            if (r0 == 0) goto L53
            goto L54
        L53:
            r4 = r3
        L54:
            if (r4 == 0) goto L58
            r0 = r3
            goto L59
        L58:
            r0 = r2
        L59:
            if (r0 != 0) goto L97
            android.widget.TextView r1 = r7.h
            stepos.support.v7.view.menu.e r4 = r7.f12346a
            stepos.support.v7.view.menu.c r5 = r4.f12409q
            boolean r5 = r5.m()
            if (r5 == 0) goto L6a
            char r4 = r4.f12405m
            goto L6c
        L6a:
            char r4 = r4.f12403k
        L6c:
            if (r4 != 0) goto L71
            java.lang.String r2 = ""
            goto L94
        L71:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 0
            r5.<init>(r6)
            if (r4 == r2) goto L8d
            r2 = 10
            if (r4 == r2) goto L89
            r2 = 32
            if (r4 == r2) goto L85
            r5.append(r4)
            goto L90
        L85:
            r5.append(r6)
            goto L90
        L89:
            r5.append(r6)
            goto L90
        L8d:
            r5.append(r6)
        L90:
            java.lang.String r2 = r5.toString()
        L94:
            r1.setText(r2)
        L97:
            android.widget.TextView r1 = r7.h
            int r1 = r1.getVisibility()
            if (r1 == r0) goto La4
            android.widget.TextView r1 = r7.h
            r1.setVisibility(r0)
        La4:
            android.graphics.drawable.Drawable r0 = r8.getIcon()
            r7.setIcon(r0)
            boolean r0 = r8.isEnabled()
            r7.setEnabled(r0)
            android.widget.TextView r0 = r7.f12349d
            boolean r8 = r8.isEnabled()
            if (r8 == 0) goto Lbd
            r8 = 1065353216(0x3f800000, float:1.0)
            goto Lbf
        Lbd:
            r8 = 1048576000(0x3e800000, float:0.25)
        Lbf:
            r0.setAlpha(r8)
            r7.setLittleSpotVisibility(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.view.menu.ListMenuItemView.c(stepos.support.v7.view.menu.e):void");
    }

    @Override // stepos.support.v7.view.menu.h.a
    public e getItemData() {
        return this.f12346a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f12351j);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f12349d = textView;
        int i10 = this.f12352k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f12353l, i10);
        }
        this.h = (TextView) findViewById(R.id.shortcut);
        this.f12358q = (NewMessageView) findViewById(R.id.message_point);
        this.f12349d.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        if (this.f12347b != null && this.f12354m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12347b.getLayoutParams();
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
        if (!z && this.f12348c == null && this.f12350e == null) {
            return;
        }
        if ((this.f12346a.A & 4) != 0) {
            if (this.f12348c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f12348c = radioButton;
                addView(radioButton);
            }
            compoundButton = this.f12348c;
            compoundButton2 = this.f12350e;
        } else {
            if (this.f12350e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f12350e = checkBox;
                addView(checkBox);
            }
            compoundButton = this.f12350e;
            compoundButton2 = this.f12348c;
        }
        if (!z) {
            CheckBox checkBox2 = this.f12350e;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f12348c;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f12346a.isChecked());
        int i10 = z ? 0 : 8;
        if (compoundButton.getVisibility() != i10) {
            compoundButton.setVisibility(i10);
        }
        if (compoundButton2 != null && compoundButton2.getVisibility() != 8) {
            compoundButton2.setVisibility(8);
        }
        TextView textView = this.f12349d;
        if (textView instanceof CheckedTextView) {
            ((CheckedTextView) textView).setChecked(this.f12346a.isChecked());
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if ((this.f12346a.A & 4) != 0) {
            if (this.f12348c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f12348c = radioButton;
                addView(radioButton);
            }
            compoundButton = this.f12348c;
        } else {
            if (this.f12350e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f12350e = checkBox;
                addView(checkBox);
            }
            compoundButton = this.f12350e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f12357p = z;
        this.f12354m = z;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f12346a.f12409q.f12388t || this.f12357p;
        if (z || this.f12354m) {
            ImageView imageView = this.f12347b;
            if (imageView == null && drawable == null && !this.f12354m) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.stepos_list_menu_item_icon, (ViewGroup) this, false);
                this.f12347b = imageView2;
                addView(imageView2, 0);
            }
            if (drawable == null && !this.f12354m) {
                this.f12347b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f12347b;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f12347b.getVisibility() != 0) {
                this.f12347b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f12349d.getVisibility() != 8) {
                this.f12349d.setVisibility(8);
            }
        } else {
            this.f12349d.setText(charSequence);
            if (this.f12349d.getVisibility() != 0) {
                this.f12349d.setVisibility(0);
            }
        }
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void setTitleMaxLines(int i10) {
        TextView textView = this.f12349d;
        if (textView != null) {
            textView.setMaxLines(i10);
        }
    }
}
