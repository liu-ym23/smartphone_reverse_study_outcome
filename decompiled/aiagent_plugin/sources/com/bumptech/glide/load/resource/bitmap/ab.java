package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.nio.ByteBuffer;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class ab<T> implements com.bumptech.glide.load.k<T, Bitmap> {
    private static final String TAG = "VideoDecoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Long> f3783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Integer> f3784b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f3785c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d<T> f3786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f3787e;
    private final c f;

    /* JADX INFO: compiled from: VideoDecoder.java */
    private static final class a implements d<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ab.d
        public /* synthetic */ void a(MediaMetadataRetriever r3, AssetFileDescriptor r4) {
            a2(r3, (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r4, AssetFileDescriptor.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaMetadataRetriever r7, AssetFileDescriptor r8) {
            r7.setDataSource(r8.getFileDescriptor(), r8.getStartOffset(), r8.getLength());
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static final class b implements d<ByteBuffer> {
        @Override // com.bumptech.glide.load.resource.bitmap.ab.d
        public /* synthetic */ void a(MediaMetadataRetriever r3, ByteBuffer r4) {
            a2(r3, (ByteBuffer) ZeusTransformUtils.preCheckCast(r4, ByteBuffer.class, "com.obric.aiagent.plugin"));
        }

        b() {
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaMetadataRetriever r2, final ByteBuffer r3) {
            r2.setDataSource(new VideoDecoder$ByteBufferInitializer$1(this, r3));
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static class c {
        c() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    interface d<T> {
        void a(MediaMetadataRetriever r1, T r2);
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static final class e implements d<ParcelFileDescriptor> {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.ab.d
        public /* synthetic */ void a(MediaMetadataRetriever r3, ParcelFileDescriptor r4) {
            a2(r3, (ParcelFileDescriptor) ZeusTransformUtils.preCheckCast(r4, ParcelFileDescriptor.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public void a2(MediaMetadataRetriever r1, ParcelFileDescriptor r2) {
            r1.setDataSource(r2.getFileDescriptor());
        }
    }

    @Override // com.bumptech.glide.load.k
    public boolean a(T r1, com.bumptech.glide.load.i r2) {
        return true;
    }

    static {
        f3783a = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new AnonymousClass1());
        f3784b = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new AnonymousClass2());
        f3785c = new c();
    }

    public static com.bumptech.glide.load.k<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.engine.a.e r3) {
        return new ab((com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin"), new a(null));
    }

    public static com.bumptech.glide.load.k<ParcelFileDescriptor, Bitmap> b(com.bumptech.glide.load.engine.a.e r2) {
        return new ab((com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin"), new e());
    }

    public static com.bumptech.glide.load.k<ByteBuffer, Bitmap> c(com.bumptech.glide.load.engine.a.e r2) {
        return new ab((com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin"), new b());
    }

    ab(com.bumptech.glide.load.engine.a.e r3, d<T> r4) {
        this((com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"), f3785c);
    }

    ab(com.bumptech.glide.load.engine.a.e r3, d<T> r4, c r5) {
        com.bumptech.glide.load.engine.a.e r6 = (com.bumptech.glide.load.engine.a.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.a.e.class, "com.obric.aiagent.plugin");
        d<T> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.f3787e = r6;
        this.f3786d = r7;
        this.f = r5;
    }

    @Override // com.bumptech.glide.load.k
    public com.bumptech.glide.load.engine.v<Bitmap> a(T r11, int r12, int r13, com.bumptech.glide.load.i r14) {
        long r4 = ((Long) ZeusTransformUtils.preCheckCast(r14.a(f3783a), Long.class, "com.obric.aiagent.plugin")).longValue();
        if (r4 < 0) goto L5;
    L9:
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r14.a(f3784b), Integer.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L12;
        r0 = 2;
    L12:
        l r15 = (l) ZeusTransformUtils.preCheckCast(r14.a(l.h), l.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L15;
        r15 = l.g;
    L15:
        l r9 = r15;
        MediaMetadataRetriever r16 = this.f.a();
        this.f3786d.a(r16, r11);     // Catch: Throwable -> L19 RuntimeException -> L21
        Bitmap r17 = a(r16, r4, r0.intValue(), r12, r13, r9);     // Catch: Throwable -> L19 RuntimeException -> L21
        r16.release();
        return com.bumptech.glide.load.resource.bitmap.e.a(r17, this.f3787e);
    L19:
        th = move-exception;
        r16.release();
        throw th;
    L21:
        e = move-exception;
        throw new IOException(e);     // Catch: Throwable -> L19
    L5:
        if (r4 == (-1)) goto L9;
        throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + r4);
    }

    private static Bitmap a(MediaMetadataRetriever r2, long r3, int r5, int r6, int r7, l r8) {
        if (Build.VERSION.SDK_INT >= 27) goto L5;
    L10:
        Bitmap r9 = null;
    L11:
        if (r9 == null) goto L13;
        return r9;
    L13:
        return a(r2, r3, r5);
    L5:
        if (r6 == Integer.MIN_VALUE) goto L10;
        if (r7 == Integer.MIN_VALUE) goto L10;
        if (r8 == l.f) goto L10;
        r9 = b(r2, r3, r5, r6, r7, r8);
        goto L11
    }

    private static Bitmap b(MediaMetadataRetriever r9, long r10, int r12, int r13, int r14, l r15) {
        int r0 = Integer.parseInt(r9.extractMetadata(18));     // Catch: Throwable -> L10
        int r1 = Integer.parseInt(r9.extractMetadata(19));     // Catch: Throwable -> L10
        int r2 = Integer.parseInt(r9.extractMetadata(24));     // Catch: Throwable -> L10
        if (r2 != 90) goto L6;
    L7:
        r1 = r0;
        r0 = r1;
    L8:
        float r16 = r15.a(r0, r1, r13, r14);     // Catch: Throwable -> L10
        return r9.getScaledFrameAtTime(r10, r12, Math.round(r0 * r16), Math.round(r16 * r1));
    L6:
        if (r2 != 270) goto L8;
    L10:
        th = move-exception;
        if (a(TAG, 3) == false) goto L18;
        a(TAG, "Exception trying to decode frame on oreo+", th);
        return null;
    L18:
        return null;
    }

    private static Bitmap a(MediaMetadataRetriever r0, long r1, int r3) {
        return r0.getFrameAtTime(r1, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }
}
