package com.google.android.gms.common.stats;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import ch.qos.logback.classic.net.SyslogAppender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {

    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new C0154a(27);

    /* renamed from: a, reason: collision with root package name */
    public final int f9932a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9933b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9934c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9935d;

    /* renamed from: e, reason: collision with root package name */
    public final String f9936e;

    /* renamed from: f, reason: collision with root package name */
    public final String f9937f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9938g;

    /* renamed from: h, reason: collision with root package name */
    public final List f9939h;

    /* renamed from: i, reason: collision with root package name */
    public final String f9940i;

    /* renamed from: j, reason: collision with root package name */
    public final long f9941j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9942k;

    /* renamed from: l, reason: collision with root package name */
    public final String f9943l;

    /* renamed from: m, reason: collision with root package name */
    public final float f9944m;

    /* renamed from: n, reason: collision with root package name */
    public final long f9945n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f9946o;

    /* renamed from: p, reason: collision with root package name */
    public final long f9947p = -1;

    public WakeLockEvent(int i4, long j4, int i5, String str, int i6, ArrayList arrayList, String str2, long j5, int i7, String str3, String str4, float f4, long j6, String str5, boolean z4) {
        this.f9932a = i4;
        this.f9933b = j4;
        this.f9934c = i5;
        this.f9935d = str;
        this.f9936e = str3;
        this.f9937f = str5;
        this.f9938g = i6;
        this.f9939h = arrayList;
        this.f9940i = str2;
        this.f9941j = j5;
        this.f9942k = i7;
        this.f9943l = str4;
        this.f9944m = f4;
        this.f9945n = j6;
        this.f9946o = z4;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int N() {
        return this.f9934c;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long O() {
        return this.f9947p;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long P() {
        return this.f9933b;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String Q() {
        List list = this.f9939h;
        String strJoin = list == null ? "" : TextUtils.join(",", list);
        String str = this.f9936e;
        if (str == null) {
            str = "";
        }
        String str2 = this.f9943l;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.f9937f;
        return SyslogAppender.DEFAULT_STACKTRACE_PATTERN + this.f9935d + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + this.f9938g + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + strJoin + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + this.f9942k + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + str + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + str2 + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + this.f9944m + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + (str3 != null ? str3 : "") + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + this.f9946o;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9932a);
        J.c0(parcel, 2, 8);
        parcel.writeLong(this.f9933b);
        J.U(parcel, 4, this.f9935d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9938g);
        List<String> list = this.f9939h;
        if (list != null) {
            int iZ2 = J.Z(parcel, 6);
            parcel.writeStringList(list);
            J.b0(parcel, iZ2);
        }
        J.c0(parcel, 8, 8);
        parcel.writeLong(this.f9941j);
        J.U(parcel, 10, this.f9936e);
        J.c0(parcel, 11, 4);
        parcel.writeInt(this.f9934c);
        J.U(parcel, 12, this.f9940i);
        J.U(parcel, 13, this.f9943l);
        J.c0(parcel, 14, 4);
        parcel.writeInt(this.f9942k);
        J.c0(parcel, 15, 4);
        parcel.writeFloat(this.f9944m);
        J.c0(parcel, 16, 8);
        parcel.writeLong(this.f9945n);
        J.U(parcel, 17, this.f9937f);
        J.c0(parcel, 18, 4);
        parcel.writeInt(this.f9946o ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
