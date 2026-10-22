package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import p2.C5047a;

@Deprecated
/* loaded from: classes2.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new b();
    final int zza;
    private final long zzb;
    private final int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final List zzh;
    private final String zzi;
    private final long zzj;
    private final int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;

    public WakeLockEvent(int i10, long j10, int i11, String str, int i12, List list, String str2, long j11, int i13, String str3, String str4, float f10, long j12, String str5, boolean z10) {
        this.zza = i10;
        this.zzb = j10;
        this.zzc = i11;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i12;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j11;
        this.zzk = i13;
        this.zzl = str4;
        this.zzm = f10;
        this.zzn = j12;
        this.zzo = z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, this.zza);
        C5047a.r(parcel, 2, this.zzb);
        C5047a.x(parcel, 4, this.zzd, false);
        C5047a.p(parcel, 5, this.zzg);
        C5047a.z(parcel, 6, this.zzh, false);
        C5047a.r(parcel, 8, this.zzj);
        C5047a.x(parcel, 10, this.zze, false);
        C5047a.p(parcel, 11, this.zzc);
        C5047a.x(parcel, 12, this.zzi, false);
        C5047a.x(parcel, 13, this.zzl, false);
        C5047a.p(parcel, 14, this.zzk);
        C5047a.m(parcel, 15, this.zzm);
        C5047a.r(parcel, 16, this.zzn);
        C5047a.x(parcel, 17, this.zzf, false);
        C5047a.g(parcel, 18, this.zzo);
        C5047a.b(parcel, iA);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzc() {
        List list = this.zzh;
        String strJoin = list == null ? "" : TextUtils.join(Const.STR_MART_COMMA, list);
        int i10 = this.zzk;
        String str = this.zze;
        String str2 = this.zzl;
        float f10 = this.zzm;
        String str3 = this.zzf;
        int i11 = this.zzg;
        String str4 = this.zzd;
        boolean z10 = this.zzo;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t");
        sb2.append(str4);
        sb2.append("\t");
        sb2.append(i11);
        sb2.append("\t");
        sb2.append(strJoin);
        sb2.append("\t");
        sb2.append(i10);
        sb2.append("\t");
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append("\t");
        if (str2 == null) {
            str2 = "";
        }
        sb2.append(str2);
        sb2.append("\t");
        sb2.append(f10);
        sb2.append("\t");
        sb2.append(str3 != null ? str3 : "");
        sb2.append("\t");
        sb2.append(z10);
        return sb2.toString();
    }
}
