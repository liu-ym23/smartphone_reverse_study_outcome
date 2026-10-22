package com.google.android.gms.common.moduleinstall;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import t0.J;

@SafeParcelable.Class(creator = "ModuleInstallStatusUpdateCreator")
/* loaded from: classes.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new C0154a(18);

    /* renamed from: a, reason: collision with root package name */
    public final int f9885a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9886b;

    /* renamed from: c, reason: collision with root package name */
    public final Long f9887c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f9888d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9889e;

    @Retention(RetentionPolicy.CLASS)
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    public ModuleInstallStatusUpdate(int i4, int i5, Long l4, Long l5, int i6) {
        this.f9885a = i4;
        this.f9886b = i5;
        this.f9887c = l4;
        this.f9888d = l5;
        this.f9889e = i6;
        if (l4 != null && l5 != null && l5.longValue() != 0 && l5.longValue() == 0) {
            throw new IllegalArgumentException("Given Long is zero");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9885a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9886b);
        Long l4 = this.f9887c;
        if (l4 != null) {
            J.c0(parcel, 3, 8);
            parcel.writeLong(l4.longValue());
        }
        Long l5 = this.f9888d;
        if (l5 != null) {
            J.c0(parcel, 4, 8);
            parcel.writeLong(l5.longValue());
        }
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9889e);
        J.b0(parcel, iZ);
    }
}
