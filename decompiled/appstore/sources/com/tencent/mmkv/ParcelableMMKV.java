package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = null;
    private int ashmemFD;
    private int ashmemMetaFD;
    private String cryptKey;
    private String mmapID;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public ParcelableMMKV a(Parcel r10) {
            String r11 = r10.readString();
            Parcelable.Creator r12 = ParcelFileDescriptor.CREATOR;
            ParcelFileDescriptor r13 = (ParcelFileDescriptor) r12.createFromParcel(r10);
            ParcelFileDescriptor r14 = (ParcelFileDescriptor) r12.createFromParcel(r10);
            String r15 = r10.readString();
            if (r13 == null) goto L7;
            if (r14 != null) goto L6;
            return null;
        L6:
            return new ParcelableMMKV(r11, r13.detachFd(), r14.detachFd(), r15, null);
        L7:
            return null;
        }

        public ParcelableMMKV[] b(int r10) {
            return new ParcelableMMKV[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public /* synthetic */ ParcelableMMKV(String r10, int r11, int r12, String r13, a r14) {
        this(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public MMKV toMMKV() {
        int r10 = this.ashmemFD;
        if (r10 < 0) goto L8;
        int r11 = this.ashmemMetaFD;
        if (r11 >= 0) goto L7;
        return null;
    L7:
        return MMKV.m(this.mmapID, r10, r11, this.cryptKey);
    L8:
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeString(this.mmapID);     // Catch: IOException -> L6
        ParcelFileDescriptor r12 = ParcelFileDescriptor.fromFd(this.ashmemFD);     // Catch: IOException -> L6
        ParcelFileDescriptor r13 = ParcelFileDescriptor.fromFd(this.ashmemMetaFD);     // Catch: IOException -> L6
        int r14 = r11 | 1;     // Catch: IOException -> L6
        r12.writeToParcel(r10, r14);     // Catch: IOException -> L6
        r13.writeToParcel(r10, r14);     // Catch: IOException -> L6
        String r15 = this.cryptKey;     // Catch: IOException -> L6
        if (r15 == null) goto L11;
        r10.writeString(r15);     // Catch: IOException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public ParcelableMMKV(MMKV r10) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = r10.mmapID();
        this.ashmemFD = r10.ashmemFD();
        this.ashmemMetaFD = r10.ashmemMetaFD();
        this.cryptKey = r10.cryptKey();
    }

    private ParcelableMMKV(String r10, int r11, int r12, String r13) {
        this.mmapID = r10;
        this.ashmemFD = r11;
        this.ashmemMetaFD = r12;
        this.cryptKey = r13;
    }
}
