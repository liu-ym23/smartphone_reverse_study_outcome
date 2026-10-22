package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: T, reason: collision with root package name */
    private CharSequence f10940T;

    /* renamed from: U, reason: collision with root package name */
    private CharSequence f10941U;

    /* renamed from: V, reason: collision with root package name */
    private Drawable f10942V;

    /* renamed from: W, reason: collision with root package name */
    private CharSequence f10943W;

    /* renamed from: X, reason: collision with root package name */
    private CharSequence f10944X;

    /* renamed from: Y, reason: collision with root package name */
    private int f10945Y;

    public interface a {
        <T extends Preference> T a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11238j, i5, i6);
        String strM = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11259t, s.f11241k);
        this.f10940T = strM;
        if (strM == null) {
            this.f10940T = I();
        }
        this.f10941U = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11257s, s.f11243l);
        this.f10942V = androidx.core.content.res.k.c(typedArrayObtainStyledAttributes, s.f11253q, s.f11245m);
        this.f10943W = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11263v, s.f11247n);
        this.f10944X = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes, s.f11261u, s.f11249o);
        this.f10945Y = androidx.core.content.res.k.l(typedArrayObtainStyledAttributes, s.f11255r, s.f11251p, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Drawable R0() {
        return this.f10942V;
    }

    public int S0() {
        return this.f10945Y;
    }

    public CharSequence T0() {
        return this.f10941U;
    }

    public CharSequence U0() {
        return this.f10940T;
    }

    public CharSequence V0() {
        return this.f10944X;
    }

    public CharSequence W0() {
        return this.f10943W;
    }

    @Override // androidx.preference.Preference
    protected void X() {
        E().u(this);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11131b, R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(Context context) {
        this(context, null);
    }
}
