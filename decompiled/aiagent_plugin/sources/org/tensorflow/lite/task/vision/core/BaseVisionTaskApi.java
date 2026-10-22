package org.tensorflow.lite.task.vision.core;

import android.media.Image;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import org.tensorflow.lite.support.b.g;
import org.tensorflow.lite.task.core.d;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseVisionTaskApi extends d {

    /* JADX INFO: renamed from: org.tensorflow.lite.task.vision.core.BaseVisionTaskApi$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f40661a = null;

        static {
            int[] r0 = new int[org.tensorflow.lite.support.b.b.values().length];
            f40661a = r0;
            r0[org.tensorflow.lite.support.b.b.f40598a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f40661a[org.tensorflow.lite.support.b.b.f40600c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f40661a[org.tensorflow.lite.support.b.b.f40601d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f40661a[org.tensorflow.lite.support.b.b.f40602e.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f40661a[org.tensorflow.lite.support.b.b.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f40661a[org.tensorflow.lite.support.b.b.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static abstract class a {
        abstract long a();

        abstract long b();

        abstract byte[] c();

        a() {
        }

        public static a a(long r7, long r9, byte[] r11) {
            return new org.tensorflow.lite.task.vision.core.a(r7, r9, r11);
        }
    }

    public interface b<T> {
        T b(long r1, int r3, int r4, org.tensorflow.lite.task.core.a.b r5);
    }

    private static native long createFrameBufferFromByteBuffer(ByteBuffer r0, int r1, int r2, int r3, int r4);

    private static native long createFrameBufferFromBytes(byte[] r0, int r1, int r2, int r3, int r4, long[] r5);

    private static native long createFrameBufferFromPlanes(ByteBuffer r0, ByteBuffer r1, ByteBuffer r2, int r3, int r4, int r5, int r6, int r7, int r8);

    private static native void deleteFrameBuffer(long r0, long r2, byte[] r4);

    public BaseVisionTaskApi(long r1) {
        super(r1);
    }

    public <T> T a(b<T> r7, g r8, org.tensorflow.lite.task.core.a.b r9) {
        b r0 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        a r6 = a(r8, r9.b().a());
        T r10 = (T) r0.b(r6.a(), r8.f(), r8.g(), r9);
        deleteFrameBuffer(r6.a(), r6.b(), r6.c());
        return r10;
    }

    private static a a(g r3, int r4) {
        org.tensorflow.lite.support.b.b r0 = r3.e();
        switch(AnonymousClass1.f40661a[r0.ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Color space type, " + r0.name() + ", is unsupported.");
    L7:
        return b(r3, r4);
    L9:
        return c(r3, r4);
    }

    private static a b(g r13, int r14) {
        Image r15 = r13.c();
        if (r15.getFormat() != 35) goto L5;
        boolean r0 = true;
    L6:
        org.tensorflow.lite.support.a.a.a.a(r0, "Only supports loading YUV_420_888 Image.");
        Image.Plane[] r1 = r15.getPlanes();
        if (r1.length != 3) goto L9;
        boolean r3 = true;
    L10:
        org.tensorflow.lite.support.a.a.a.a(r3, String.format("The input image should have 3 planes, but got %d plane(s).", new Object[]{Integer.valueOf(r1.length)}));
        int r4 = r1.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L14;
        ByteBuffer r6 = r1[r5].getBuffer();
        org.tensorflow.lite.support.a.a.a.a(r6, "The image buffer is corrupted and the plane is null.");
        org.tensorflow.lite.support.a.a.a.a(r6.isDirect(), "The image plane buffer is not a direct ByteBuffer, and is not supported.");
        r6.rewind();
        r5 = r5 + 1;
        goto L11
    L14:
        return a.a(createFrameBufferFromPlanes(r1[0].getBuffer(), r1[1].getBuffer(), r1[2].getBuffer(), r15.getWidth(), r15.getHeight(), r1[0].getRowStride(), r1[1].getRowStride(), r1[1].getPixelStride(), r14), 0, new byte[0]);
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    private static a c(g r10, int r11) {
        if (r10.d() != org.tensorflow.lite.a.f40581c) goto L5;
        g r0 = r10;
    L6:
        ByteBuffer r1 = r0.a();
        r1.rewind();
        org.tensorflow.lite.support.b.b r12 = r10.e();
        if (r1.isDirect() == true) goto L9;
        long[] r2 = new long[1];
        byte[] r3 = a(r1);
        return a.a(createFrameBufferFromBytes(r3, r0.f(), r0.g(), r11, r12.a(), r2), r2[0], r3);
    L9:
        return a.a(createFrameBufferFromByteBuffer(r1, r0.f(), r0.g(), r11, r12.a()), 0, new byte[0]);
    L5:
        r0 = g.a(r10, org.tensorflow.lite.a.f40581c);
        goto L6
    }

    private static byte[] a(ByteBuffer r3) {
        if (r3.hasArray() == true) goto L5;
    L8:
        r3.rewind();
        int r0 = r3.limit();
        byte[] r1 = new byte[r0];
        r3.get(r1, 0, r0);
        return r1;
    L5:
        if (r3.arrayOffset() != 0) goto L8;
        return r3.array();
    }
}
