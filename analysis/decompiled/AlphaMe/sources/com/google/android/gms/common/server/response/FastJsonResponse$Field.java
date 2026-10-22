package com.google.android.gms.common.server.response;

import B0.e;
import android.os.Parcel;
import c1.C0390a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.VisibleForTesting;
import com.stepos.activeview.utils.Constants;
import t0.J;

@VisibleForTesting
@SafeParcelable.Class(creator = "FieldCreator")
@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class FastJsonResponse$Field<I, O> extends AbstractSafeParcelable {
    public static final C0390a CREATOR = new C0390a();

    /* renamed from: a, reason: collision with root package name */
    public final int f9905a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9906b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9907c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9908d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f9909e;

    /* renamed from: f, reason: collision with root package name */
    public final String f9910f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9911g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f9912h;

    /* renamed from: i, reason: collision with root package name */
    public final String f9913i;

    /* renamed from: j, reason: collision with root package name */
    public zan f9914j;

    /* renamed from: k, reason: collision with root package name */
    public final StringToIntConverter f9915k;

    public FastJsonResponse$Field(int i4, int i5, boolean z4, int i6, boolean z5, String str, int i7, String str2, zaa zaaVar) {
        this.f9905a = i4;
        this.f9906b = i5;
        this.f9907c = z4;
        this.f9908d = i6;
        this.f9909e = z5;
        this.f9910f = str;
        this.f9911g = i7;
        if (str2 == null) {
            this.f9912h = null;
            this.f9913i = null;
        } else {
            this.f9912h = SafeParcelResponse.class;
            this.f9913i = str2;
        }
        if (zaaVar == null) {
            this.f9915k = null;
            return;
        }
        StringToIntConverter stringToIntConverter = zaaVar.f9901b;
        if (stringToIntConverter == null) {
            throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        }
        this.f9915k = stringToIntConverter;
    }

    public final String toString() {
        e eVar = new e(this);
        eVar.a(Integer.valueOf(this.f9905a), Constants.JSON_KEY_VERSION_CODE);
        eVar.a(Integer.valueOf(this.f9906b), "typeIn");
        eVar.a(Boolean.valueOf(this.f9907c), "typeInArray");
        eVar.a(Integer.valueOf(this.f9908d), "typeOut");
        eVar.a(Boolean.valueOf(this.f9909e), "typeOutArray");
        eVar.a(this.f9910f, "outputFieldName");
        eVar.a(Integer.valueOf(this.f9911g), "safeParcelFieldId");
        String str = this.f9913i;
        if (str == null) {
            str = null;
        }
        eVar.a(str, "concreteTypeName");
        Class cls = this.f9912h;
        if (cls != null) {
            eVar.a(cls.getCanonicalName(), "concreteType.class");
        }
        if (this.f9915k != null) {
            eVar.a(StringToIntConverter.class.getCanonicalName(), "converterName");
        }
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9905a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9906b);
        J.c0(parcel, 3, 4);
        parcel.writeInt(this.f9907c ? 1 : 0);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f9908d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9909e ? 1 : 0);
        J.U(parcel, 6, this.f9910f);
        J.c0(parcel, 7, 4);
        parcel.writeInt(this.f9911g);
        String str = this.f9913i;
        if (str == null) {
            str = null;
        }
        J.U(parcel, 8, str);
        StringToIntConverter stringToIntConverter = this.f9915k;
        J.T(parcel, 9, stringToIntConverter != null ? new zaa(stringToIntConverter) : null, i4);
        J.b0(parcel, iZ);
    }
}
