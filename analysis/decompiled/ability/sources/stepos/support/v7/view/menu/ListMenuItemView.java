package stepos.support.v7.view.menu;

import Va.C;
import Va.q;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import com.stepos.common.widget.NewMessageView;
import stepos.support.v7.app.O;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
public class ListMenuItemView extends LinearLayout implements C {

    /* renamed from: a, reason: collision with root package name */
    public q f6378a;
    public ImageView b;
    public RadioButton c;
    public TextView d;
    public CheckBox e;
    public TextView f;
    public final Drawable g;
    public final int h;
    public final Context i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6379j;
    public final Context k;
    public LayoutInflater l;
    public boolean m;
    public NewMessageView n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MenuView, 0, 0);
        this.g = typedArrayObtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.h = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f6379j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.i = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.l == null) {
            this.l = LayoutInflater.from(this.k);
        }
        return this.l;
    }

    private void setLittleSpotVisibility(boolean z10) {
        NewMessageView newMessageView = this.n;
        if (newMessageView != null) {
            newMessageView.setVisibility(z10 ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // Va.C
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(Va.q r8) {
        /*
            r7 = this;
            r7.f6378a = r8
            boolean r0 = r8.isVisible()
            r1 = 8
            r2 = 0
            if (r0 == 0) goto Ld
            r0 = r2
            goto Le
        Ld:
            r0 = r1
        Le:
            r7.setVisibility(r0)
            java.lang.CharSequence r0 = r8.e
            r7.setTitle(r0)
            boolean r0 = r8.isCheckable()
            r7.setCheckable(r0)
            Va.n r0 = r8.n
            boolean r0 = r0.n()
            r3 = 1
            if (r0 == 0) goto L37
            Va.n r0 = r8.n
            boolean r0 = r0.m()
            if (r0 == 0) goto L31
            char r0 = r8.f1454j
            goto L33
        L31:
            char r0 = r8.h
        L33:
            if (r0 == 0) goto L37
            r0 = r3
            goto L38
        L37:
            r0 = r2
        L38:
            Va.n r4 = r8.n
            r4.m()
            if (r0 == 0) goto L5e
            Va.q r0 = r7.f6378a
            Va.n r4 = r0.n
            boolean r4 = r4.n()
            if (r4 == 0) goto L59
            Va.n r4 = r0.n
            boolean r4 = r4.m()
            if (r4 == 0) goto L54
            char r0 = r0.f1454j
            goto L56
        L54:
            char r0 = r0.h
        L56:
            if (r0 == 0) goto L59
            goto L5a
        L59:
            r3 = r2
        L5a:
            if (r3 == 0) goto L5e
            r0 = r2
            goto L5f
        L5e:
            r0 = r1
        L5f:
            if (r0 != 0) goto L9d
            android.widget.TextView r3 = r7.f
            Va.q r4 = r7.f6378a
            Va.n r5 = r4.n
            boolean r5 = r5.m()
            if (r5 == 0) goto L70
            char r4 = r4.f1454j
            goto L72
        L70:
            char r4 = r4.h
        L72:
            if (r4 != 0) goto L77
            java.lang.String r1 = ""
            goto L9a
        L77:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 0
            r5.<init>(r6)
            if (r4 == r1) goto L93
            r1 = 10
            if (r4 == r1) goto L8f
            r1 = 32
            if (r4 == r1) goto L8b
            r5.append(r4)
            goto L96
        L8b:
            r5.append(r6)
            goto L96
        L8f:
            r5.append(r6)
            goto L96
        L93:
            r5.append(r6)
        L96:
            java.lang.String r1 = r5.toString()
        L9a:
            r3.setText(r1)
        L9d:
            android.widget.TextView r1 = r7.f
            int r1 = r1.getVisibility()
            if (r1 == r0) goto Laa
            android.widget.TextView r1 = r7.f
            r1.setVisibility(r0)
        Laa:
            android.graphics.drawable.Drawable r0 = r8.getIcon()
            r7.setIcon(r0)
            boolean r0 = r8.isEnabled()
            r7.setEnabled(r0)
            android.widget.TextView r0 = r7.d
            boolean r8 = r8.isEnabled()
            if (r8 == 0) goto Lc3
            r8 = 1065353216(0x3f800000, float:1.0)
            goto Lc5
        Lc3:
            r8 = 1048576000(0x3e800000, float:0.25)
        Lc5:
            r0.setAlpha(r8)
            r7.setLittleSpotVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.view.menu.ListMenuItemView.a(Va.q):void");
    }

    @Override // Va.C
    public q getItemData() {
        return this.f6378a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.g);
        TextView textView = (TextView) findViewById(com.stepos.ability.R.id.title);
        this.d = textView;
        int i = this.h;
        if (i != -1) {
            textView.setTextAppearance(this.i, i);
        }
        this.f = (TextView) findViewById(com.stepos.ability.R.id.shortcut);
        this.n = (NewMessageView) findViewById(com.stepos.ability.R.id.message_point);
        this.d.getViewTreeObserver().addOnGlobalLayoutListener(new O(2, this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        if (this.b != null && this.f6379j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            int i10 = layoutParams.height;
            if (i10 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i10;
            }
        }
        super.onMeasure(i, i6);
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.c == null && this.e == null) {
            return;
        }
        if ((this.f6378a.f1461x & 4) != 0) {
            if (this.c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.c = radioButton;
                addView(radioButton);
            }
            compoundButton = this.c;
            view = this.e;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                addView(checkBox);
            }
            compoundButton = this.e;
            view = this.c;
        }
        if (!z10) {
            CheckBox checkBox2 = this.e;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.c;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f6378a.isChecked());
        int i = z10 ? 0 : 8;
        if (compoundButton.getVisibility() != i) {
            compoundButton.setVisibility(i);
        }
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        TextView textView = this.d;
        if (textView instanceof CheckedTextView) {
            ((CheckedTextView) textView).setChecked(this.f6378a.isChecked());
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if ((this.f6378a.f1461x & 4) != 0) {
            if (this.c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.c = radioButton;
                addView(radioButton);
            }
            compoundButton = this.c;
        } else {
            if (this.e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.e = checkBox;
                addView(checkBox);
            }
            compoundButton = this.e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.m = z10;
        this.f6379j = z10;
    }

    public void setIcon(Drawable drawable) {
        this.f6378a.n.getClass();
        boolean z10 = this.m;
        if (z10 || this.f6379j) {
            ImageView imageView = this.b;
            if (imageView == null && drawable == null && !this.f6379j) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(com.stepos.ability.R.layout.stepos_list_menu_item_icon, (ViewGroup) this, false);
                this.b = imageView2;
                addView(imageView2, 0);
            }
            if (drawable == null && !this.f6379j) {
                this.b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.b;
            if (!z10) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.b.getVisibility() != 0) {
                this.b.setVisibility(0);
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

    @Override // Va.C
    public void setTitleMaxLines(int i) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setMaxLines(i);
        }
    }
}
