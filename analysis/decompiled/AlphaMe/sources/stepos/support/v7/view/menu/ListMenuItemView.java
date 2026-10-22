package stepos.support.v7.view.menu;

import L3.l;
import L3.x;
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
import com.stepos.alphame.R;
import com.stepos.common.widget.NewMessageView;
import g.AbstractC0560a;
import k.ViewTreeObserverOnGlobalLayoutListenerC0651e;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class ListMenuItemView extends LinearLayout implements x {

    /* renamed from: a, reason: collision with root package name */
    public l f14680a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f14681b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f14682c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f14683d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f14684e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f14685f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable f14686g;

    /* renamed from: h, reason: collision with root package name */
    public final int f14687h;

    /* renamed from: i, reason: collision with root package name */
    public final Context f14688i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14689j;

    /* renamed from: k, reason: collision with root package name */
    public final Context f14690k;

    /* renamed from: l, reason: collision with root package name */
    public LayoutInflater f14691l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14692m;

    /* renamed from: n, reason: collision with root package name */
    public NewMessageView f14693n;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14690k = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12605r, 0, 0);
        this.f14686g = typedArrayObtainStyledAttributes.getDrawable(5);
        this.f14687h = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f14689j = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f14688i = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f14691l == null) {
            this.f14691l = LayoutInflater.from(this.f14690k);
        }
        return this.f14691l;
    }

    private void setLittleSpotVisibility(boolean z4) {
        NewMessageView newMessageView = this.f14693n;
        if (newMessageView != null) {
            newMessageView.setVisibility(z4 ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    @Override // L3.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(L3.l r8) {
        /*
            r7 = this;
            r7.f14680a = r8
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
            java.lang.CharSequence r0 = r8.f1309e
            r7.setTitle(r0)
            boolean r0 = r8.isCheckable()
            r7.setCheckable(r0)
            L3.k r0 = r8.f1318n
            boolean r0 = r0.n()
            if (r0 == 0) goto L36
            L3.k r0 = r8.f1318n
            boolean r0 = r0.m()
            if (r0 == 0) goto L30
            char r0 = r8.f1314j
            goto L32
        L30:
            char r0 = r8.f1312h
        L32:
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L36:
            r0 = r2
        L37:
            L3.k r3 = r8.f1318n
            r3.m()
            if (r0 == 0) goto L59
            L3.l r0 = r7.f14680a
            L3.k r3 = r0.f1318n
            boolean r3 = r3.n()
            if (r3 == 0) goto L59
            L3.k r3 = r0.f1318n
            boolean r3 = r3.m()
            if (r3 == 0) goto L53
            char r0 = r0.f1314j
            goto L55
        L53:
            char r0 = r0.f1312h
        L55:
            if (r0 == 0) goto L59
            r0 = r2
            goto L5a
        L59:
            r0 = r1
        L5a:
            if (r0 != 0) goto L98
            android.widget.TextView r3 = r7.f14685f
            L3.l r4 = r7.f14680a
            L3.k r5 = r4.f1318n
            boolean r5 = r5.m()
            if (r5 == 0) goto L6b
            char r4 = r4.f1314j
            goto L6d
        L6b:
            char r4 = r4.f1312h
        L6d:
            if (r4 != 0) goto L72
            java.lang.String r1 = ""
            goto L95
        L72:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 0
            r5.<init>(r6)
            if (r4 == r1) goto L8e
            r1 = 10
            if (r4 == r1) goto L8a
            r1 = 32
            if (r4 == r1) goto L86
            r5.append(r4)
            goto L91
        L86:
            r5.append(r6)
            goto L91
        L8a:
            r5.append(r6)
            goto L91
        L8e:
            r5.append(r6)
        L91:
            java.lang.String r1 = r5.toString()
        L95:
            r3.setText(r1)
        L98:
            android.widget.TextView r1 = r7.f14685f
            int r1 = r1.getVisibility()
            if (r1 == r0) goto La5
            android.widget.TextView r1 = r7.f14685f
            r1.setVisibility(r0)
        La5:
            android.graphics.drawable.Drawable r0 = r8.getIcon()
            r7.setIcon(r0)
            boolean r0 = r8.isEnabled()
            r7.setEnabled(r0)
            android.widget.TextView r0 = r7.f14683d
            boolean r8 = r8.isEnabled()
            if (r8 == 0) goto Lbe
            r8 = 1065353216(0x3f800000, float:1.0)
            goto Lc0
        Lbe:
            r8 = 1048576000(0x3e800000, float:0.25)
        Lc0:
            r0.setAlpha(r8)
            r7.setLittleSpotVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.view.menu.ListMenuItemView.d(L3.l):void");
    }

    @Override // L3.x
    public l getItemData() {
        return this.f14680a;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f14686g);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f14683d = textView;
        int i4 = this.f14687h;
        if (i4 != -1) {
            textView.setTextAppearance(this.f14688i, i4);
        }
        this.f14685f = (TextView) findViewById(R.id.shortcut);
        this.f14693n = (NewMessageView) findViewById(R.id.message_point);
        this.f14683d.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0651e(4, this));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i4, int i5) {
        if (this.f14681b != null && this.f14689j) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f14681b.getLayoutParams();
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
        if (!z4 && this.f14682c == null && this.f14684e == null) {
            return;
        }
        if ((this.f14680a.f1328x & 4) != 0) {
            if (this.f14682c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f14682c = radioButton;
                addView(radioButton);
            }
            compoundButton = this.f14682c;
            view = this.f14684e;
        } else {
            if (this.f14684e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f14684e = checkBox;
                addView(checkBox);
            }
            compoundButton = this.f14684e;
            view = this.f14682c;
        }
        if (!z4) {
            CheckBox checkBox2 = this.f14684e;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f14682c;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f14680a.isChecked());
        int i4 = z4 ? 0 : 8;
        if (compoundButton.getVisibility() != i4) {
            compoundButton.setVisibility(i4);
        }
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        TextView textView = this.f14683d;
        if (textView instanceof CheckedTextView) {
            ((CheckedTextView) textView).setChecked(this.f14680a.isChecked());
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if ((this.f14680a.f1328x & 4) != 0) {
            if (this.f14682c == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f14682c = radioButton;
                addView(radioButton);
            }
            compoundButton = this.f14682c;
        } else {
            if (this.f14684e == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.f14684e = checkBox;
                addView(checkBox);
            }
            compoundButton = this.f14684e;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f14692m = z4;
        this.f14689j = z4;
    }

    public void setIcon(Drawable drawable) {
        this.f14680a.f1318n.getClass();
        boolean z4 = this.f14692m;
        if (z4 || this.f14689j) {
            ImageView imageView = this.f14681b;
            if (imageView == null && drawable == null && !this.f14689j) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.stepos_list_menu_item_icon, (ViewGroup) this, false);
                this.f14681b = imageView2;
                addView(imageView2, 0);
            }
            if (drawable == null && !this.f14689j) {
                this.f14681b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f14681b;
            if (!z4) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f14681b.getVisibility() != 0) {
                this.f14681b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f14683d.getVisibility() != 8) {
                this.f14683d.setVisibility(8);
            }
        } else {
            this.f14683d.setText(charSequence);
            if (this.f14683d.getVisibility() != 0) {
                this.f14683d.setVisibility(0);
            }
        }
    }

    @Override // L3.x
    public void setTitleMaxLines(int i4) {
        TextView textView = this.f14683d;
        if (textView != null) {
            textView.setMaxLines(i4);
        }
    }
}
