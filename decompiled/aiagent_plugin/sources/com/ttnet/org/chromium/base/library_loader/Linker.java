package com.ttnet.org.chromium.base.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.ttnet.org.chromium.base.j;
import com.ttnet.org.chromium.base.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
abstract class Linker {
    private static final String TAG = "Linker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Linker f37715a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final /* synthetic */ boolean f37716e = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Object f37717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f37718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f37719d;

    static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = null;
        private static final String EXTRA_LINKER_LIB_INFO = "libinfo";
        public String mLibFilePath;
        public long mLoadAddress;
        public long mLoadSize;
        public int mRelroFd;
        public long mRelroSize;
        public long mRelroStart;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        LibInfo() {
            this.mRelroFd = -1;
        }

        LibInfo(Parcel r4) {
            this.mRelroFd = -1;
            this.mLibFilePath = r4.readString();
            this.mLoadAddress = r4.readLong();
            this.mLoadSize = r4.readLong();
            this.mRelroStart = r4.readLong();
            this.mRelroSize = r4.readLong();
            if (r4.readInt() == 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            ParcelFileDescriptor r5 = (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(ParcelFileDescriptor.CREATOR.createFromParcel(r4), ParcelFileDescriptor.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L12;
            this.mRelroFd = r5.detachFd();
            return;
        L12:
            return;
        L10:
            this.mRelroFd = -1;
            return;
        L5:
            r1 = false;
            goto L6
        }

        public void close() {
            int r0 = this.mRelroFd;
            if (r0 < 0) goto L6;
            q.a(ParcelFileDescriptor.adoptFd(r0));
            this.mRelroFd = -1;
            return;
        }

        public static LibInfo fromBundle(Bundle r2) {
            r2.setClassLoader(Linker.class.getClassLoader());
            return (LibInfo) ZeusTransformUtils.preCheckCast(r2.getParcelable(EXTRA_LINKER_LIB_INFO), LibInfo.class, "com.obric.aiagent.plugin");
        }

        public Bundle toBundle() {
            Bundle r0 = new Bundle();
            r0.putParcelable(EXTRA_LINKER_LIB_INFO, this);
            return r0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            r3.writeString(this.mLibFilePath);
            r3.writeLong(this.mLoadAddress);
            r3.writeLong(this.mLoadSize);
            r3.writeLong(this.mRelroStart);
            r3.writeLong(this.mRelroSize);
            if (this.mRelroFd < 0) goto L5;
            int r5 = 1;
        L6:
            r3.writeInt(r5);
            int r2 = this.mRelroFd;
            if (r2 < 0) goto L15;
            ParcelFileDescriptor r6 = ParcelFileDescriptor.fromFd(r2);     // Catch: IOException -> L10
            r6.writeToParcel(r3, 0);     // Catch: IOException -> L10
            r6.close();     // Catch: IOException -> L10
            return;
        L10:
            e = move-exception;
            j.e(Linker.TAG, "Can't write LibInfo file descriptor to parcel", new Object[]{e});
            return;
        L15:
            return;
        L5:
            r5 = 0;
            goto L6
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static {
    }

    public Linker() {
        this.f37717b = new Object();
        this.f37718c = true;
        this.f37719d = 0;
        if (f37716e == false) goto L5;
    L9:
        f37715a = this;
        return;
    L5:
        if (f37715a == null) goto L9;
        throw new AssertionError();
    }
}
