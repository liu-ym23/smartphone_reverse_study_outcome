package com.stepos.core.ability.converter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.base.Content;
import gc.q;
import java.util.ArrayList;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BundleContentBridge {
    public static final BundleContentBridge INSTANCE = new BundleContentBridge();
    public static final String KEY_BITMAP = "bitmap";
    public static final String KEY_FILE_DESCRIPTOR = "file_descriptor";
    public static final String KEY_PATH = "path";
    public static final String KEY_RESULT_BITMAP = "result_bitmap";
    public static final String KEY_RESULT_FORMAT = "result_format";
    public static final String KEY_RESULT_HEIGHT = "result_height";
    public static final String KEY_RESULT_WIDTH = "result_width";
    public static final String KEY_ROLE = "role";
    public static final String KEY_SHARED_MEMORY = "shared_memory";
    private static final int MAX_MATTING_EDGE = 1024;
    private static final int NO_DOWNSCALE = Integer.MAX_VALUE;
    public static final String ROLE_MASK = "mask";
    public static final String ROLE_SOURCE = "source";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class VisionImageInput {
        private final Content content;
        private final int sampleSize;

        public VisionImageInput(Content content, int i10) {
            g.f(content, "content");
            this.content = content;
            this.sampleSize = i10;
        }

        public final Content getContent() {
            return this.content;
        }

        public final int getSampleSize() {
            return this.sampleSize;
        }
    }

    private BundleContentBridge() {
    }

    public static final int calcSampleSize(int i10, int i11) {
        int i12 = 1;
        if (i10 > 0 && i11 > 0) {
            if (i10 <= MAX_MATTING_EDGE && i11 <= MAX_MATTING_EDGE) {
                return 1;
            }
            int i13 = i10 / 2;
            int i14 = i11 / 2;
            while (i14 / i12 >= MAX_MATTING_EDGE && i13 / i12 >= MAX_MATTING_EDGE) {
                i12 *= 2;
            }
        }
        return i12;
    }

    public static /* synthetic */ Bitmap scaleDown$default(BundleContentBridge bundleContentBridge, Bitmap bitmap, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 1280;
        }
        return bundleContentBridge.scaleDown(bitmap, i10);
    }

    public final MixedContent fromMultiImageBundle(Bundle bundle) {
        g.f(bundle, "bundle");
        Bundle bundle2 = bundle.getBundle(ROLE_SOURCE);
        if (bundle2 == null) {
            throw new IllegalArgumentException("MultiImageBundle missing 'source'");
        }
        Bundle bundle3 = bundle.getBundle(ROLE_MASK);
        ArrayList arrayList = new ArrayList();
        Content contentFromSingleImageBundle = fromSingleImageBundle(bundle2);
        contentFromSingleImageBundle.setParams(new ContentParams.Builder().putString(KEY_ROLE, ROLE_SOURCE).build());
        arrayList.add(contentFromSingleImageBundle);
        if (bundle3 != null) {
            Content contentFromSingleImageBundle2 = fromSingleImageBundle(bundle3);
            contentFromSingleImageBundle2.setParams(new ContentParams.Builder().putString(KEY_ROLE, ROLE_MASK).build());
            arrayList.add(contentFromSingleImageBundle2);
        }
        return new MixedContent(arrayList);
    }

    public final Content fromSingleImageBundle(Bundle bundle) {
        g.f(bundle, "bundle");
        Bitmap bitmap = (Bitmap) bundle.getParcelable(KEY_BITMAP);
        if (bitmap != null) {
            return ImageContent.Companion.fromBitmap$default(ImageContent.Companion, bitmap, 0, 0, 0, 0, 30, null);
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable(KEY_FILE_DESCRIPTOR);
        if (parcelFileDescriptor != null) {
            return new ImageContent(null, parcelFileDescriptor, 0L, 0, 0, 0, 0, null, null, 509, null);
        }
        String string = bundle.getString(KEY_PATH);
        if (string == null || q.t0(string)) {
            throw new IllegalArgumentException("SingleImageBundle has no usable image data (bitmap/fd/path)");
        }
        return new FileContent(string, "image/*", null, 4, null);
    }

    public final VisionImageInput fromVisionImageBundle(Bundle bundle, boolean z) {
        Bitmap bitmapCreateScaledBitmap;
        g.f(bundle, "bundle");
        Bitmap bitmap = (Bitmap) bundle.getParcelable(KEY_BITMAP);
        if (bitmap == null) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable(KEY_FILE_DESCRIPTOR);
            if (parcelFileDescriptor != null) {
                return new VisionImageInput(new ImageContent(null, parcelFileDescriptor, 0L, 0, 0, 0, 0, null, null, 509, null), 1);
            }
            String string = bundle.getString(KEY_PATH);
            if (string == null || q.t0(string)) {
                throw new IllegalArgumentException("SingleImageBundle has no usable image data (bitmap/fd/path)");
            }
            return new VisionImageInput(new FileContent(string, "image/*", null, 4, null), 1);
        }
        int iCalcSampleSize = z ? calcSampleSize(bitmap.getWidth(), bitmap.getHeight()) : 1;
        if (iCalcSampleSize > 1) {
            int width = bitmap.getWidth() / iCalcSampleSize;
            if (width < 1) {
                width = 1;
            }
            int height = bitmap.getHeight() / iCalcSampleSize;
            if (height < 1) {
                height = 1;
            }
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        } else {
            bitmapCreateScaledBitmap = bitmap;
        }
        g.c(bitmapCreateScaledBitmap);
        ImageContent imageContentFromBitmap$default = ImageContent.Companion.fromBitmap$default(ImageContent.Companion, bitmapCreateScaledBitmap, 0, 0, 0, NO_DOWNSCALE, 14, null);
        if (bitmapCreateScaledBitmap != bitmap && !bitmapCreateScaledBitmap.isRecycled()) {
            bitmapCreateScaledBitmap.recycle();
        }
        return new VisionImageInput(imageContentFromBitmap$default, iCalcSampleSize);
    }

    public final Bitmap scaleDown(Bitmap src, int i10) {
        g.f(src, "src");
        float f8 = i10;
        float fMin = Math.min(f8 / src.getWidth(), Math.min(f8 / src.getHeight(), 1.0f));
        if (fMin >= 1.0f) {
            return src;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(src, (int) (src.getWidth() * fMin), (int) (src.getHeight() * fMin), true);
        g.e(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
        return bitmapCreateScaledBitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle toSingleImageBundle(com.stepos.core.data.ImageContent r6) throws android.system.ErrnoException {
        /*
            r5 = this;
            java.lang.String r5 = "content"
            kotlin.jvm.internal.g.f(r6, r5)
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            android.graphics.Bitmap r0 = r6.getBitmap()
            if (r0 == 0) goto L15
            android.graphics.Bitmap r0 = r6.getBitmap()
            goto L59
        L15:
            android.os.SharedMemory r0 = r6.getSharedMemory()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L3e
            android.os.SharedMemory r0 = r6.getSharedMemory()
            kotlin.jvm.internal.g.c(r0)
            java.nio.ByteBuffer r0 = r0.mapReadOnly()     // Catch: java.lang.Exception -> L58
            java.lang.String r3 = "mapReadOnly(...)"
            kotlin.jvm.internal.g.e(r0, r3)     // Catch: java.lang.Exception -> L58
            int r3 = r0.remaining()     // Catch: java.lang.Exception -> L58
            byte[] r4 = new byte[r3]     // Catch: java.lang.Exception -> L58
            r0.get(r4)     // Catch: java.lang.Exception -> L58
            android.os.SharedMemory.unmap(r0)     // Catch: java.lang.Exception -> L58
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r4, r1, r3)     // Catch: java.lang.Exception -> L58
            goto L59
        L3e:
            android.hardware.HardwareBuffer r0 = r6.getHwBuffer()
            if (r0 == 0) goto L58
            android.hardware.HardwareBuffer r0 = r6.getHwBuffer()
            kotlin.jvm.internal.g.c(r0)
            android.graphics.Bitmap r0 = android.graphics.Bitmap.wrapHardwareBuffer(r0, r2)
            if (r0 == 0) goto L58
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = r0.copy(r2, r1)
            goto L59
        L58:
            r0 = r2
        L59:
            if (r0 == 0) goto L60
            java.lang.String r1 = "result_bitmap"
            r5.putParcelable(r1, r0)
        L60:
            java.lang.String r0 = "result_width"
            int r1 = r6.getWidth()
            r5.putInt(r0, r1)
            java.lang.String r0 = "result_height"
            int r1 = r6.getHeight()
            r5.putInt(r0, r1)
            java.lang.String r0 = "result_format"
            int r6 = r6.getFormat()
            r5.putInt(r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.converter.BundleContentBridge.toSingleImageBundle(com.stepos.core.data.ImageContent):android.os.Bundle");
    }
}
