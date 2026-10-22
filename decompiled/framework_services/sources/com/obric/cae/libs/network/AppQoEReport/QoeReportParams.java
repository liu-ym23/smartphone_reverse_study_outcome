package com.obric.cae.libs.network.AppQoEReport;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class QoeReportParams implements Parcelable {
    public static final Parcelable.Creator<QoeReportParams> CREATOR = null;
    public int appType;
    public int businessType;
    public int eventType;
    public long value;

    public class a implements Parcelable.Creator<QoeReportParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final QoeReportParams createFromParcel(Parcel r2) {
            QoeReportParams r0 = new QoeReportParams();
            r0.readFromParcel(r2);
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public final QoeReportParams[] newArray(int r1) {
            return new QoeReportParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public QoeReportParams() {
        this.appType = 0;
        this.businessType = 0;
        this.eventType = 0;
        this.value = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel r8) {
        int r0 = r8.dataPosition();
        int r1 = r8.readInt();
        if (r1 < 4) goto L50;
        if ((r8.dataPosition() - r0) >= r1) goto L8;
        this.appType = r8.readInt();     // Catch: Throwable -> L47
        if ((r8.dataPosition() - r0) >= r1) goto L17;
        this.businessType = r8.readInt();     // Catch: Throwable -> L47
        if ((r8.dataPosition() - r0) >= r1) goto L26;
        this.eventType = r8.readInt();     // Catch: Throwable -> L47
        if ((r8.dataPosition() - r0) >= r1) goto L35;
        this.value = r8.readLong();     // Catch: Throwable -> L47
        if (r0 > (Integer.MAX_VALUE - r1)) goto L46;
        r8.setDataPosition(r0 + r1);
        return;
    L46:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L35:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L39;
        r8.setDataPosition(r0 + r1);
        return;
    L39:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L26:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L30;
        r8.setDataPosition(r0 + r1);
        return;
    L30:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L17:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L21;
        r8.setDataPosition(r0 + r1);
        return;
    L21:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L8:
        if (r0 > (Integer.MAX_VALUE - r1)) goto L12;
        r8.setDataPosition(r0 + r1);
        return;
    L12:
        throw new BadParcelableException("Overflow in the size of parcelable");
    L50:
        throw new BadParcelableException("Parcelable too small");     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L54;
        r8.setDataPosition(r0 + r1);
        throw th;
    L54:
        throw new BadParcelableException("Overflow in the size of parcelable");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        int r5 = r3.dataPosition();
        r3.writeInt(0);
        r3.writeInt(this.appType);
        r3.writeInt(this.businessType);
        r3.writeInt(this.eventType);
        r3.writeLong(this.value);
        int r0 = r3.dataPosition();
        r3.setDataPosition(r5);
        r3.writeInt(r0 - r5);
        r3.setDataPosition(r0);
    }
}
