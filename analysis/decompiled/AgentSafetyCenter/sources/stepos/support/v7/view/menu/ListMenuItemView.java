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
import com.stepos.agentsafetycenter.R;
import com.stepos.common.widget.NewMessageView;
import g.a;
import java.lang.invoke.VarHandle;
import l.d;
import te.l;
import te.m;
import te.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ListMenuItemView extends LinearLayout implements w {

    /* renamed from: c, reason: collision with root package name */
    public m f12544c;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f12545f;

    /* renamed from: g, reason: collision with root package name */
    public RadioButton f12546g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f12547h;
    public CheckBox i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f12548j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f12549k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12550l;

    /* renamed from: m, reason: collision with root package name */
    public final Context f12551m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f12552n;

    /* renamed from: o, reason: collision with root package name */
    public final Context f12553o;

    /* renamed from: p, reason: collision with root package name */
    public LayoutInflater f12554p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12555q;

    /* renamed from: r, reason: collision with root package name */
    public NewMessageView f12556r;

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f12553o = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4114r, i, 0);
        this.f12549k = typedArrayObtainStyledAttributes.getDrawable(5);
        this.f12550l = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f12552n = typedArrayObtainStyledAttributes.getBoolean(7, false);
        this.f12551m = context;
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f12554p == null) {
            this.f12554p = LayoutInflater.from(this.f12553o);
        }
        return this.f12554p;
    }

    private void setLittleSpotVisibility(boolean z10) {
        NewMessageView newMessageView = this.f12556r;
        if (newMessageView != null) {
            newMessageView.setVisibility(z10 ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // te.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(te.m r8) {
        /*
            r7 = this;
            r7.f12544c = r8
            boolean r0 = r8.isVisible()
            te.l r1 = r8.f13375n
            r2 = 8
            r3 = 0
            if (r0 == 0) goto Lf
            r0 = r3
            goto L10
        Lf:
            r0 = r2
        L10:
            r7.setVisibility(r0)
            java.lang.CharSequence r0 = r8.f13367e
            r7.setTitle(r0)
            boolean r0 = r8.isCheckable()
            r7.setCheckable(r0)
            boolean r0 = r1.n()
            r4 = 1
            if (r0 == 0) goto L35
            boolean r0 = r1.m()
            if (r0 == 0) goto L2f
            char r0 = r8.f13371j
            goto L31
        L2f:
            char r0 = r8.f13370h
        L31:
            if (r0 == 0) goto L35
            r0 = r4
            goto L36
        L35:
            r0 = r3
        L36:
            r1.m()
            if (r0 == 0) goto L58
            te.m r0 = r7.f12544c
            te.l r1 = r0.f13375n
            boolean r5 = r1.n()
            if (r5 == 0) goto L53
            boolean r1 = r1.m()
            if (r1 == 0) goto L4e
            char r0 = r0.f13371j
            goto L50
        L4e:
            char r0 = r0.f13370h
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
            android.widget.TextView r1 = r7.f12548j
            te.m r4 = r7.f12544c
            te.l r5 = r4.f13375n
            boolean r5 = r5.m()
            if (r5 == 0) goto L6a
            char r4 = r4.f13371j
            goto L6c
        L6a:
            char r4 = r4.f13370h
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
            android.widget.TextView r1 = r7.f12548j
            int r1 = r1.getVisibility()
            if (r1 == r0) goto La4
            android.widget.TextView r1 = r7.f12548j
            r1.setVisibility(r0)
        La4:
            android.graphics.drawable.Drawable r0 = r8.getIcon()
            r7.setIcon(r0)
            boolean r0 = r8.isEnabled()
            r7.setEnabled(r0)
            android.widget.TextView r0 = r7.f12547h
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
        throw new UnsupportedOperationException("Method not decompiled: stepos.support.v7.view.menu.ListMenuItemView.d(te.m):void");
    }

    @Override // te.w
    public m getItemData() {
        return this.f12544c;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setBackgroundDrawable(this.f12549k);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f12547h = textView;
        int i = this.f12550l;
        if (i != -1) {
            textView.setTextAppearance(this.f12551m, i);
        }
        this.f12548j = (TextView) findViewById(R.id.shortcut);
        this.f12556r = (NewMessageView) findViewById(R.id.message_point);
        ViewTreeObserver viewTreeObserver = this.f12547h.getViewTreeObserver();
        d dVar = new d(4);
        dVar.f7543f = this;
        VarHandle.storeStoreFence();
        viewTreeObserver.addOnGlobalLayoutListener(dVar);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i3) {
        if (this.f12545f != null && this.f12552n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f12545f.getLayoutParams();
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
        if (!z10 && this.f12546g == null && this.i == null) {
            return;
        }
        if ((this.f12544c.f13385x & 4) != 0) {
            if (this.f12546g == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f12546g = radioButton;
                addView(radioButton);
            }
            compoundButton = this.f12546g;
            view = this.i;
        } else {
            if (this.i == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.i = checkBox;
                addView(checkBox);
            }
            compoundButton = this.i;
            view = this.f12546g;
        }
        if (!z10) {
            CheckBox checkBox2 = this.i;
            if (checkBox2 != null) {
                checkBox2.setVisibility(8);
            }
            RadioButton radioButton2 = this.f12546g;
            if (radioButton2 != null) {
                radioButton2.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f12544c.isChecked());
        int i = z10 ? 0 : 8;
        if (compoundButton.getVisibility() != i) {
            compoundButton.setVisibility(i);
        }
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        TextView textView = this.f12547h;
        if (textView instanceof CheckedTextView) {
            ((CheckedTextView) textView).setChecked(this.f12544c.isChecked());
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if ((this.f12544c.f13385x & 4) != 0) {
            if (this.f12546g == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f12546g = radioButton;
                addView(radioButton);
            }
            compoundButton = this.f12546g;
        } else {
            if (this.i == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.i = checkBox;
                addView(checkBox);
            }
            compoundButton = this.i;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f12555q = z10;
        this.f12552n = z10;
    }

    public void setIcon(Drawable drawable) {
        l lVar = this.f12544c.f13375n;
        boolean z10 = this.f12555q;
        if (z10 || this.f12552n) {
            ImageView imageView = this.f12545f;
            if (imageView == null && drawable == null && !this.f12552n) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.stepos_list_menu_item_icon, (ViewGroup) this, false);
                this.f12545f = imageView2;
                addView(imageView2, 0);
            }
            if (drawable == null && !this.f12552n) {
                this.f12545f.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f12545f;
            if (!z10) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f12545f.getVisibility() != 0) {
                this.f12545f.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.f12547h;
        if (charSequence == null) {
            if (textView.getVisibility() != 8) {
                this.f12547h.setVisibility(8);
            }
        } else {
            textView.setText(charSequence);
            if (this.f12547h.getVisibility() != 0) {
                this.f12547h.setVisibility(0);
            }
        }
    }

    @Override // te.w
    public void setTitleMaxLines(int i) {
        TextView textView = this.f12547h;
        if (textView != null) {
            textView.setMaxLines(i);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
