package com.bumptech.glide.load.a;

import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: compiled from: ParcelFileDescriptorRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class m implements e<ParcelFileDescriptor> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f3391a;

    /* JADX INFO: compiled from: ParcelFileDescriptorRewinder.java */
    public static final class a implements e.a<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.a.e.a
        public /* synthetic */ e<ParcelFileDescriptor> a(ParcelFileDescriptor r3) {
            return a2((ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r3, ParcelFileDescriptor.class, "com.obric.aiagent.plugin"));
        }

        public a() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public e<ParcelFileDescriptor> a2(ParcelFileDescriptor r1) {
            return new m(r1);
        }

        @Override // com.bumptech.glide.load.a.e.a
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    /* JADX INFO: compiled from: ParcelFileDescriptorRewinder.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f3392a;

        b(ParcelFileDescriptor r1) {
            this.f3392a = r1;
        }

        ParcelFileDescriptor a() {
            Os.lseek(this.f3392a.getFileDescriptor(), 0, OsConstants.SEEK_SET);     // Catch: ErrnoException -> L5
            return this.f3392a;
        L5:
            e = move-exception;
            throw new IOException(e);
        }
    }

    @Override // com.bumptech.glide.load.a.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.a.e
    public /* synthetic */ ParcelFileDescriptor a() {
        return d();
    }

    public static boolean c() {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }

    public m(ParcelFileDescriptor r2) {
        this.f3391a = new b(r2);
    }

    public ParcelFileDescriptor d() {
        return this.f3391a.a();
    }
}
