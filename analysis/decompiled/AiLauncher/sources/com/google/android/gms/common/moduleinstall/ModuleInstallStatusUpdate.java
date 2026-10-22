package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import q2.i;

/* loaded from: classes2.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new i();
    private final int zaa;
    private final int zab;
    private final Long zac;
    private final Long zad;
    private final int zae;
    private final a zaf;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f19865a;

        /* renamed from: b, reason: collision with root package name */
        public final long f19866b;

        public a(long j10, long j11) {
            C1669j.m(j11);
            this.f19865a = j10;
            this.f19866b = j11;
        }
    }

    public ModuleInstallStatusUpdate(int i10, int i11, Long l10, Long l11, int i12) {
        this.zaa = i10;
        this.zab = i11;
        this.zac = l10;
        this.zad = l11;
        this.zae = i12;
        this.zaf = (l10 == null || l11 == null || l11.longValue() == 0) ? null : new a(l10.longValue(), l11.longValue());
    }

    public int getErrorCode() {
        return this.zae;
    }

    public int getInstallState() {
        return this.zab;
    }

    public a getProgressInfo() {
        return this.zaf;
    }

    public int getSessionId() {
        return this.zaa;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, getSessionId());
        C5047a.p(parcel, 2, getInstallState());
        C5047a.t(parcel, 3, this.zac, false);
        C5047a.t(parcel, 4, this.zad, false);
        C5047a.p(parcel, 5, getErrorCode());
        C5047a.b(parcel, iA);
    }
}
