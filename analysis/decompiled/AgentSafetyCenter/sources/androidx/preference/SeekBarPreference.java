package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.stepos.agentsafetycenter.R;
import l4.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: l, reason: collision with root package name */
    public final int f1474l;

    /* renamed from: m, reason: collision with root package name */
    public final int f1475m;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i, R.attr.seekBarPreferenceStyle, 0);
        int i = typedArrayObtainStyledAttributes.getInt(3, 0);
        int i3 = typedArrayObtainStyledAttributes.getInt(1, 100);
        i3 = i3 < i ? i : i3;
        if (i3 != this.f1474l) {
            this.f1474l = i3;
        }
        int i10 = typedArrayObtainStyledAttributes.getInt(4, 0);
        if (i10 != this.f1475m) {
            this.f1475m = Math.min(this.f1474l - i, Math.abs(i10));
        }
        typedArrayObtainStyledAttributes.getBoolean(2, true);
        typedArrayObtainStyledAttributes.getBoolean(5, false);
        typedArrayObtainStyledAttributes.getBoolean(6, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object c(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 0));
    }
}
