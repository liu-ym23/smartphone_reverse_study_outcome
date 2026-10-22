package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: Z, reason: collision with root package name */
    private CharSequence[] f10954Z;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence[] f10955a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f10956b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f10957c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f10958d0;

    public static final class b implements Preference.g<ListPreference> {

        /* renamed from: a, reason: collision with root package name */
        private static b f10960a;

        private b() {
        }

        public static b b() {
            if (f10960a == null) {
                f10960a = new b();
            }
            return f10960a;
        }

        @Override // androidx.preference.Preference.g
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.Z0()) ? listPreference.l().getString(q.f11155c) : listPreference.Z0();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11269y, i5, i6);
        this.f10954Z = androidx.core.content.res.k.o(typedArrayObtainStyledAttributes, s.f11161B, s.f11271z);
        this.f10955a0 = androidx.core.content.res.k.o(typedArrayObtainStyledAttributes, s.f11163C, s.f11159A);
        int i7 = s.f11165D;
        if (androidx.core.content.res.k.b(typedArrayObtainStyledAttributes, i7, i7, false)) {
            H0(b.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, s.f11177J, i5, i6);
        this.f10957c0 = androidx.core.content.res.k.m(typedArrayObtainStyledAttributes2, s.f11256r0, s.f11193R);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private int c1() {
        return X0(this.f10956b0);
    }

    @Override // androidx.preference.Preference
    public CharSequence G() {
        if (H() != null) {
            return H().a(this);
        }
        CharSequence charSequenceZ0 = Z0();
        CharSequence charSequenceG = super.G();
        String str = this.f10957c0;
        if (str != null) {
            if (charSequenceZ0 == null) {
                charSequenceZ0 = BuildConfig.FLAVOR;
            }
            String str2 = String.format(str, charSequenceZ0);
            if (!TextUtils.equals(str2, charSequenceG)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceG;
    }

    @Override // androidx.preference.Preference
    public void G0(CharSequence charSequence) {
        super.G0(charSequence);
        if (charSequence == null) {
            this.f10957c0 = null;
        } else {
            this.f10957c0 = charSequence.toString();
        }
    }

    public int X0(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f10955a0) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.f10955a0[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] Y0() {
        return this.f10954Z;
    }

    public CharSequence Z0() {
        CharSequence[] charSequenceArr;
        int iC1 = c1();
        if (iC1 < 0 || (charSequenceArr = this.f10954Z) == null) {
            return null;
        }
        return charSequenceArr[iC1];
    }

    @Override // androidx.preference.Preference
    protected Object a0(TypedArray typedArray, int i5) {
        return typedArray.getString(i5);
    }

    public CharSequence[] a1() {
        return this.f10955a0;
    }

    public String b1() {
        return this.f10956b0;
    }

    public void d1(int i5) {
        e1(l().getResources().getTextArray(i5));
    }

    @Override // androidx.preference.Preference
    protected void e0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.e0(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.e0(aVar.getSuperState());
        f1(aVar.f10959a);
    }

    public void e1(CharSequence[] charSequenceArr) {
        this.f10954Z = charSequenceArr;
    }

    @Override // androidx.preference.Preference
    protected Parcelable f0() {
        Parcelable parcelableF0 = super.f0();
        if (N()) {
            return parcelableF0;
        }
        a aVar = new a(parcelableF0);
        aVar.f10959a = b1();
        return aVar;
    }

    public void f1(String str) {
        boolean zEquals = TextUtils.equals(this.f10956b0, str);
        if (zEquals && this.f10958d0) {
            return;
        }
        this.f10956b0 = str;
        this.f10958d0 = true;
        m0(str);
        if (zEquals) {
            return;
        }
        Q();
    }

    @Override // androidx.preference.Preference
    protected void g0(Object obj) {
        f1(y((String) obj));
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0140a();

        /* renamed from: a, reason: collision with root package name */
        String f10959a;

        /* renamed from: androidx.preference.ListPreference$a$a, reason: collision with other inner class name */
        class C0140a implements Parcelable.Creator<a> {
            C0140a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i5) {
                return new a[i5];
            }
        }

        a(Parcel parcel) {
            super(parcel);
            this.f10959a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeString(this.f10959a);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11131b, R.attr.dialogPreferenceStyle));
    }

    public ListPreference(Context context) {
        this(context, null);
    }
}
