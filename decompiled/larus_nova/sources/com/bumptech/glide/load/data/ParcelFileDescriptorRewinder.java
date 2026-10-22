package com.bumptech.glide.load.data;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class ParcelFileDescriptorRewinder implements DataRewinder<ParcelFileDescriptor> {
    private final InternalRewinder rewinder;

    public static final class Factory implements DataRewinder.Factory<ParcelFileDescriptor> {
        public Factory() {
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<ParcelFileDescriptor> getDataClass() {
            return ParcelFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public /* bridge */ /* synthetic */ DataRewinder<ParcelFileDescriptor> build(ParcelFileDescriptor r100) {
            return build2(r100);
        }

        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public DataRewinder<ParcelFileDescriptor> build2(ParcelFileDescriptor r100) {
            return new ParcelFileDescriptorRewinder(r100);
        }
    }

    public static final class InternalRewinder {
        private final ParcelFileDescriptor parcelFileDescriptor;

        public ParcelFileDescriptor rewind() throws IOException {
            Os.lseek(this.parcelFileDescriptor.getFileDescriptor(), 0, OsConstants.SEEK_SET);     // Catch: ErrnoException -> L5
            return this.parcelFileDescriptor;
        L5:
            e = move-exception;
            throw new IOException(e);
        }

        public InternalRewinder(ParcelFileDescriptor r100) {
            this.parcelFileDescriptor = r100;
        }
    }

    public static boolean isSupported() {
        return true;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    public ParcelFileDescriptor rewindAndGet() throws IOException {
        return this.rewinder.rewind();
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public /* bridge */ /* synthetic */ ParcelFileDescriptor rewindAndGet() throws IOException {
        return rewindAndGet();
    }

    public ParcelFileDescriptorRewinder(ParcelFileDescriptor r100) {
        this.rewinder = new InternalRewinder(r100);
    }
}
