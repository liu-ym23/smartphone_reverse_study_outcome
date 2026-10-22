package androidx.camera.core;

import android.util.Size;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class ImageProxyDownsampler {

    public static final enum DownsamplingMethod extends Enum<DownsamplingMethod> {
        private static final /* synthetic */ DownsamplingMethod[] $VALUES = null;
        public static final DownsamplingMethod AVERAGING = null;
        public static final DownsamplingMethod NEAREST_NEIGHBOR = null;

        private static /* synthetic */ DownsamplingMethod[] $values() {
            return new DownsamplingMethod[]{NEAREST_NEIGHBOR, AVERAGING};
        }

        static {
            NEAREST_NEIGHBOR = new DownsamplingMethod("NEAREST_NEIGHBOR", 0);
            AVERAGING = new DownsamplingMethod("AVERAGING", 1);
            $VALUES = $values();
        }

        public static DownsamplingMethod[] values() {
            return (DownsamplingMethod[]) $VALUES.clone();
        }

        public static DownsamplingMethod valueOf(String r100) {
            return (DownsamplingMethod) r27.a.a(DownsamplingMethod.class, r100);
        }

        private DownsamplingMethod(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getHeight() {
            return this.mDownsampledHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getWidth() {
            return this.mDownsampledWidth;
        }

        public ForwardingImageProxyImpl(ImageProxy r100, ImageProxy.PlaneProxy[] r101, int r102, int r103) {
            super(r100);
            this.mDownsampledPlanes = r101;
            this.mDownsampledWidth = r102;
            this.mDownsampledHeight = r103;
        }
    }

    private ImageProxyDownsampler() {
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(final int r100, final int r101, final byte[] r102) {
        return new AnonymousClass1(r102, r100, r101);
    }

    public static ForwardingImageProxy downsample(ImageProxy r210, int r211, int r212, DownsamplingMethod r213) {
        if (r210.getFormat() != 35) goto L28;
        if (r210.getWidth() < r211) goto L26;
        if (r210.getHeight() < r212) goto L26;
        if (r210.getWidth() == r211) goto L11;
    L14:
        int r100 = 0;
        int[] r101 = {r210.getWidth(), r210.getWidth() / 2, r210.getWidth() / 2};
        int[] r102 = {r210.getHeight(), r210.getHeight() / 2, r210.getHeight() / 2};
        int r110 = r211 / 2;
        int[] r103 = {r211, r110, r110};
        int r111 = r212 / 2;
        int[] r112 = {r212, r111, r111};
        ImageProxy.PlaneProxy[] r104 = new ImageProxy.PlaneProxy[3];
    L15:
        if (r100 >= 3) goto L24;
        ImageProxy.PlaneProxy r113 = r210.getPlanes()[r100];
        ByteBuffer r114 = r113.getBuffer();
        byte[] r115 = new byte[r103[r100] * r112[r100]];
        int r116 = r213.ordinal();
        if (r116 == 0) goto L21;
        if (r116 == 1) goto L20;
        byte[] r214 = r115;
    L22:
        r104[r100] = createPlaneProxy(r103[r100], 1, r214);
        r100 = r100 + 1;
        goto L15
    L20:
        r214 = r115;
        resizeAveraging(r114, r101[r100], r113.getPixelStride(), r113.getRowStride(), r102[r100], r214, r103[r100], r112[r100]);
        goto L22
    L21:
        r214 = r115;
        resizeNearestNeighbor(r114, r101[r100], r113.getPixelStride(), r113.getRowStride(), r102[r100], r214, r103[r100], r112[r100]);
        goto L22
    L24:
        return new ForwardingImageProxyImpl(r210, r104, r211, r212);
    L11:
        if (r210.getHeight() != r212) goto L14;
        return new ForwardingImageProxyImpl(r210, r210.getPlanes(), r211, r212);
    L26:
        throw new IllegalArgumentException("Downsampled dimension " + new Size(r211, r212) + " is not <= original dimension " + new Size(r210.getWidth(), r210.getHeight()) + ".");
    L28:
        throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
    }

    private static void resizeAveraging(ByteBuffer r110, int r111, int r112, int r113, int r210, byte[] r211, int r212, int r213) {
        float r100 = r111 / r212;
        float r101 = r210 / r213;
        byte[] r102 = new byte[r113];
        byte[] r103 = new byte[r113];
        int[] r104 = new int[r212];
        int r114 = 0;
        int r115 = 0;
    L3:
        if (r115 >= r212) goto L5;
        r104[r115] = ((int) (r115 * r100)) * r112;
        r115 = r115 + 1;
        goto L3
    L5:
        monitor-enter(r110);
        r110.rewind();     // Catch: Throwable -> L14
        int r105 = 0;
    L7:
        if (r105 >= r213) goto L12;
        int r116 = (int) (r105 * r101);     // Catch: Throwable -> L14
        int r117 = r210 - 1;     // Catch: Throwable -> L14
        int r118 = Math.min(r116, r117) * r113;     // Catch: Throwable -> L14
        int r119 = Math.min(r116 + 1, r117) * r113;     // Catch: Throwable -> L14
        int r120 = r105 * r212;     // Catch: Throwable -> L14
        r110.position(r118);     // Catch: Throwable -> L14
        r110.get(r102, r114, Math.min(r113, r110.remaining()));     // Catch: Throwable -> L14
        r110.position(r119);     // Catch: Throwable -> L14
        r110.get(r103, r114, Math.min(r113, r110.remaining()));     // Catch: Throwable -> L14
        int r121 = 0;
    L9:
        if (r121 >= r212) goto L11;
        int r122 = r104[r121];     // Catch: Throwable -> L14
        int r123 = r102[r122] & UByte.MAX_VALUE;     // Catch: Throwable -> L14
        int r124 = r102[r122 + r112] & UByte.MAX_VALUE;     // Catch: Throwable -> L14
        r211[r120 + r121] = (byte) (((((r123 + r124) + (r103[r122] & UByte.MAX_VALUE)) + (r103[r122 + r112] & UByte.MAX_VALUE)) / 4) & 255);     // Catch: Throwable -> L14
        r121 = r121 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        r105 = r105 + 1;     // Catch: Throwable -> L14
        r114 = 0;
        goto L7
    L12:
        monitor-exit(r110);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static void resizeNearestNeighbor(ByteBuffer r100, int r101, int r102, int r110, int r111, byte[] r112, int r113, int r114) {
        float r103 = r101 / r113;
        float r104 = r111 / r114;
        byte[] r105 = new byte[r110];
        int[] r106 = new int[r113];
        int r107 = 0;
    L3:
        if (r107 >= r113) goto L5;
        r106[r107] = ((int) (r107 * r103)) * r102;
        r107 = r107 + 1;
        goto L3
    L5:
        monitor-enter(r100);
        r100.rewind();     // Catch: Throwable -> L14
        int r108 = 0;
    L7:
        if (r108 >= r114) goto L12;
        int r109 = r108 * r113;     // Catch: Throwable -> L14
        r100.position(Math.min((int) (r108 * r104), r111 - 1) * r110);     // Catch: Throwable -> L14
        r100.get(r105, 0, Math.min(r110, r100.remaining()));     // Catch: Throwable -> L14
        int r115 = 0;
    L9:
        if (r115 >= r113) goto L11;
        r112[r109 + r115] = r105[r106[r115]];     // Catch: Throwable -> L14
        r115 = r115 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        r108 = r108 + 1;     // Catch: Throwable -> L14
        goto L7
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
