package com.ttnet.org.chromium.base.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.ttnet.org.chromium.base.annotations.AccessedByNative;
import com.ttnet.org.chromium.base.j;
import com.ttnet.org.chromium.base.n;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Linker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f18331a = null;

    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = null;
        private static final String EXTRA_LINKER_LIB_INFO = "libinfo";
        public String mLibFilePath;

        @AccessedByNative
        public long mLoadAddress;

        @AccessedByNative
        public long mLoadSize;

        @AccessedByNative
        public int mRelroFd;

        @AccessedByNative
        public long mRelroSize;

        @AccessedByNative
        public long mRelroStart;

        public class a implements Parcelable.Creator {
            public a() {
            }

            public LibInfo a(Parcel r10) {
                return new LibInfo(r10);
            }

            public LibInfo[] b(int r10) {
                return new LibInfo[r10];
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

        public LibInfo() {
            this.mRelroFd = -1;
        }

        public static LibInfo fromBundle(Bundle r10) {
            return (LibInfo) r10.getParcelable(EXTRA_LINKER_LIB_INFO);
        }

        public void close() {
            int r10 = this.mRelroFd;
            if (r10 < 0) goto L6;
            n.a(ParcelFileDescriptor.adoptFd(r10));
            this.mRelroFd = -1;
            return;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public Bundle toBundle() {
            Bundle r10 = new Bundle();
            r10.putParcelable(EXTRA_LINKER_LIB_INFO, this);
            return r10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            r10.writeString(this.mLibFilePath);
            r10.writeLong(this.mLoadAddress);
            r10.writeLong(this.mLoadSize);
            r10.writeLong(this.mRelroStart);
            r10.writeLong(this.mRelroSize);
            if (this.mRelroFd < 0) goto L5;
            int r12 = 1;
        L6:
            r10.writeInt(r12);
            int r13 = this.mRelroFd;
            if (r13 < 0) goto L15;
            ParcelFileDescriptor r14 = ParcelFileDescriptor.fromFd(r13);     // Catch: IOException -> L10
            r14.writeToParcel(r10, 0);     // Catch: IOException -> L10
            r14.close();     // Catch: IOException -> L10
            return;
        L10:
            e = move-exception;
            j.a("Linker", "Can't write LibInfo file descriptor to parcel", new Object[]{e});
            return;
        L15:
            return;
        L5:
            r12 = 0;
            goto L6
        }

        public LibInfo(Parcel r10) {
            this.mRelroFd = -1;
            this.mLibFilePath = r10.readString();
            this.mLoadAddress = r10.readLong();
            this.mLoadSize = r10.readLong();
            this.mRelroStart = r10.readLong();
            this.mRelroSize = r10.readLong();
            if (r10.readInt() == 0) goto L7;
            ParcelFileDescriptor r11 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(r10);
            if (r11 == null) goto L9;
            this.mRelroFd = r11.detachFd();
            return;
        L9:
            return;
        L7:
            this.mRelroFd = -1;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
        public static final int DONE = 3;
        public static final int DONE_PROVIDE_RELRO = 2;
        public static final int INITIALIZED = 1;
        public static final int UNINITIALIZED = 0;
    }

    static {
        f18331a = new Object();
    }

    private static native long nativeGetRandomBaseLoadAddress();
}
