package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: Z, reason: collision with root package name */
    private String f10951Z;

    public interface a {
    }

    public static final class c implements Preference.g<EditTextPreference> {

        /* renamed from: a, reason: collision with root package name */
        private static c f10953a;

        private c() {
        }

        public static c b() {
            if (f10953a == null) {
                f10953a = new c();
            }
            return f10953a;
        }

        @Override // androidx.preference.Preference.g
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.Y0()) ? editTextPreference.l().getString(q.f11155c) : editTextPreference.Y0();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11265w, i5, i6);
        int i7 = s.f11267x;
        if (androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i7, i7, false)) {
            H0(c.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public boolean M0() {
        return TextUtils.isEmpty(this.f10951Z) || super.M0();
    }

    a X0() {
        return null;
    }

    public String Y0() {
        return this.f10951Z;
    }

    public void Z0(String str) {
        boolean zM0 = M0();
        this.f10951Z = str;
        m0(str);
        boolean zM02 = M0();
        if (zM02 != zM0) {
            R(zM02);
        }
        Q();
    }

    @Override // androidx.preference.Preference
    protected Object a0(TypedArray typedArray, int i5) {
        return typedArray.getString(i5);
    }

    @Override // androidx.preference.Preference
    protected void e0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(b.class)) {
            super.e0(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.e0(bVar.getSuperState());
        Z0(bVar.f10952a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable f0() {
        Parcelable parcelableF0 = super.f0();
        if (N()) {
            return parcelableF0;
        }
        b bVar = new b(parcelableF0);
        bVar.f10952a = Y0();
        return bVar;
    }

    @Override // androidx.preference.Preference
    protected void g0(Object obj) {
        Z0(y((String) obj));
    }

    private static class b extends Preference.b {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        String f10952a;

        class a implements Parcelable.Creator<b> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public b[] newArray(int i5) {
                return new b[i5];
            }
        }

        b(Parcel parcel) {
            super(parcel);
            this.f10952a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeString(this.f10952a);
        }

        b(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11133d, R.attr.editTextPreferenceStyle));
    }
}
