package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: N, reason: collision with root package name */
    public final CharSequence f4012N;

    /* renamed from: O, reason: collision with root package name */
    public final String f4013O;

    /* renamed from: P, reason: collision with root package name */
    public final Drawable f4014P;

    /* renamed from: Q, reason: collision with root package name */
    public final String f4015Q;

    /* renamed from: R, reason: collision with root package name */
    public final String f4016R;

    /* renamed from: S, reason: collision with root package name */
    public final int f4017S;

    public DialogPreference(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, L.f4043c, i4, 0);
        String strS = Z2.I.s(typedArrayObtainStyledAttributes, 9, 0);
        this.f4012N = strS;
        if (strS == null) {
            this.f4012N = this.f4084h;
        }
        String string = typedArrayObtainStyledAttributes.getString(8);
        this.f4013O = string == null ? typedArrayObtainStyledAttributes.getString(1) : string;
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(6);
        this.f4014P = drawable == null ? typedArrayObtainStyledAttributes.getDrawable(2) : drawable;
        String string2 = typedArrayObtainStyledAttributes.getString(11);
        this.f4015Q = string2 == null ? typedArrayObtainStyledAttributes.getString(3) : string2;
        String string3 = typedArrayObtainStyledAttributes.getString(10);
        this.f4016R = string3 == null ? typedArrayObtainStyledAttributes.getString(4) : string3;
        this.f4017S = typedArrayObtainStyledAttributes.getResourceId(7, typedArrayObtainStyledAttributes.getResourceId(5, 0));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void m() {
        E e4 = this.f4078b.f4030i;
        if (e4 != null) {
            e4.onDisplayPreferenceDialog(this);
        }
    }

    public DialogPreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, Z2.I.m(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
