package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f14315a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f14316b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f14317c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f14318d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f14319e;

    /* renamed from: f, reason: collision with root package name */
    public int f14320f;

    public interface a {
        <T extends Preference> T findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DialogPreference, i10, i11);
        String strM = s0.k.m(typedArrayObtainStyledAttributes, R$styleable.DialogPreference_dialogTitle, R$styleable.DialogPreference_android_dialogTitle);
        this.f14315a = strM;
        if (strM == null) {
            this.f14315a = getTitle();
        }
        this.f14316b = s0.k.m(typedArrayObtainStyledAttributes, R$styleable.DialogPreference_dialogMessage, R$styleable.DialogPreference_android_dialogMessage);
        this.f14317c = s0.k.c(typedArrayObtainStyledAttributes, R$styleable.DialogPreference_dialogIcon, R$styleable.DialogPreference_android_dialogIcon);
        this.f14318d = s0.k.m(typedArrayObtainStyledAttributes, R$styleable.DialogPreference_positiveButtonText, R$styleable.DialogPreference_android_positiveButtonText);
        this.f14319e = s0.k.m(typedArrayObtainStyledAttributes, R$styleable.DialogPreference_negativeButtonText, R$styleable.DialogPreference_android_negativeButtonText);
        this.f14320f = s0.k.l(typedArrayObtainStyledAttributes, R$styleable.DialogPreference_dialogLayout, R$styleable.DialogPreference_android_dialogLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Drawable a() {
        return this.f14317c;
    }

    public int b() {
        return this.f14320f;
    }

    public CharSequence c() {
        return this.f14316b;
    }

    public CharSequence e() {
        return this.f14315a;
    }

    public CharSequence i() {
        return this.f14319e;
    }

    public CharSequence j() {
        return this.f14318d;
    }

    @Override // androidx.preference.Preference
    public void onClick() {
        getPreferenceManager().s(this);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, s0.k.a(context, R$attr.dialogPreferenceStyle, R.attr.dialogPreferenceStyle));
    }
}
