package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {

    /* renamed from: Z, reason: collision with root package name */
    private CharSequence[] f10961Z;

    /* renamed from: a0, reason: collision with root package name */
    private CharSequence[] f10962a0;

    /* renamed from: b0, reason: collision with root package name */
    private Set<String> f10963b0;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f10963b0 = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.f11167E, i5, i6);
        this.f10961Z = androidx.core.content.res.k.o(typedArrayObtainStyledAttributes, s.f11173H, s.f11169F);
        this.f10962a0 = androidx.core.content.res.k.o(typedArrayObtainStyledAttributes, s.f11175I, s.f11171G);
        typedArrayObtainStyledAttributes.recycle();
    }

    public CharSequence[] X0() {
        return this.f10961Z;
    }

    public CharSequence[] Y0() {
        return this.f10962a0;
    }

    public Set<String> Z0() {
        return this.f10963b0;
    }

    @Override // androidx.preference.Preference
    protected Object a0(TypedArray typedArray, int i5) {
        CharSequence[] textArray = typedArray.getTextArray(i5);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    public void a1(Set<String> set) {
        this.f10963b0.clear();
        this.f10963b0.addAll(set);
        n0(set);
        Q();
    }

    @Override // androidx.preference.Preference
    protected void e0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.e0(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.e0(aVar.getSuperState());
        a1(aVar.f10964a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable f0() {
        Parcelable parcelableF0 = super.f0();
        if (N()) {
            return parcelableF0;
        }
        a aVar = new a(parcelableF0);
        aVar.f10964a = Z0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void g0(Object obj) {
        a1(z((Set) obj));
    }

    private static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0141a();

        /* renamed from: a, reason: collision with root package name */
        Set<String> f10964a;

        /* renamed from: androidx.preference.MultiSelectListPreference$a$a, reason: collision with other inner class name */
        class C0141a implements Parcelable.Creator<a> {
            C0141a() {
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
            int i5 = parcel.readInt();
            this.f10964a = new HashSet();
            String[] strArr = new String[i5];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f10964a, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f10964a.size());
            Set<String> set = this.f10964a;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.res.k.a(context, m.f11131b, R.attr.dialogPreferenceStyle));
    }
}
