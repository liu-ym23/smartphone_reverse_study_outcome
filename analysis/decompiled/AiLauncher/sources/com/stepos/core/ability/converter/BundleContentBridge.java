package com.stepos.core.ability.converter;

import La.H;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.base.Content;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import v9.C5685n;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u0011J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/stepos/core/ability/converter/BundleContentBridge;", "", "<init>", "()V", "KEY_BITMAP", "", "KEY_PATH", "KEY_FILE_DESCRIPTOR", "KEY_SHARED_MEMORY", "KEY_ROLE", "ROLE_SOURCE", "ROLE_MASK", "KEY_RESULT_BITMAP", "KEY_RESULT_WIDTH", "KEY_RESULT_HEIGHT", "KEY_RESULT_FORMAT", "MAX_MATTING_EDGE", "", "NO_DOWNSCALE", "fromSingleImageBundle", "Lcom/stepos/core/data/base/Content;", "bundle", "Landroid/os/Bundle;", "fromVisionImageBundle", "Lcom/stepos/core/ability/converter/BundleContentBridge$VisionImageInput;", "downSample", "", "calcSampleSize", "width", "height", "scaleDown", "Landroid/graphics/Bitmap;", "src", "maxEdge", "fromMultiImageBundle", "Lcom/stepos/core/data/MixedContent;", "toSingleImageBundle", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/core/data/ImageContent;", "VisionImageInput", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/core/ability/converter/BundleContentBridge$VisionImageInput;", "", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/core/data/base/Content;", "sampleSize", "", "<init>", "(Lcom/stepos/core/data/base/Content;I)V", "getContent", "()Lcom/stepos/core/data/base/Content;", "getSampleSize", "()I", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class VisionImageInput {
        private final Content content;
        private final int sampleSize;

        public VisionImageInput(Content content, int i10) {
            p.i(content, "content");
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

    public static final int calcSampleSize(int width, int height) {
        int i10 = 1;
        if (width > 0 && height > 0) {
            if (width <= MAX_MATTING_EDGE && height <= MAX_MATTING_EDGE) {
                return 1;
            }
            int i11 = width / 2;
            int i12 = height / 2;
            while (i12 / i10 >= MAX_MATTING_EDGE && i11 / i10 >= MAX_MATTING_EDGE) {
                i10 *= 2;
            }
        }
        return i10;
    }

    public static /* synthetic */ Bitmap scaleDown$default(BundleContentBridge bundleContentBridge, Bitmap bitmap, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 1280;
        }
        return bundleContentBridge.scaleDown(bitmap, i10);
    }

    public final MixedContent fromMultiImageBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        Bundle bundle2 = bundle.getBundle("source");
        if (bundle2 == null) {
            throw new IllegalArgumentException("MultiImageBundle missing 'source'");
        }
        Bundle bundle3 = bundle.getBundle("mask");
        ArrayList arrayList = new ArrayList();
        Content contentFromSingleImageBundle = fromSingleImageBundle(bundle2);
        contentFromSingleImageBundle.setParams(new ContentParams.Builder().putString(KEY_ROLE, "source").build());
        arrayList.add(contentFromSingleImageBundle);
        if (bundle3 != null) {
            Content contentFromSingleImageBundle2 = fromSingleImageBundle(bundle3);
            contentFromSingleImageBundle2.setParams(new ContentParams.Builder().putString(KEY_ROLE, "mask").build());
            arrayList.add(contentFromSingleImageBundle2);
        }
        return new MixedContent(arrayList);
    }

    public final Content fromSingleImageBundle(Bundle bundle) {
        p.i(bundle, "bundle");
        Bitmap bitmap = (Bitmap) bundle.getParcelable("bitmap");
        if (bitmap != null) {
            return ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, bitmap, 0, 0, 0, 0, 30, null);
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("file_descriptor");
        if (parcelFileDescriptor != null) {
            return new ImageContent(null, parcelFileDescriptor, 0L, 0, 0, 0, 0, null, null, 509, null);
        }
        String string = bundle.getString("path");
        if (string == null || H.x0(string)) {
            throw new IllegalArgumentException("SingleImageBundle has no usable image data (bitmap/fd/path)");
        }
        return new FileContent(string, "image/*", null, 4, null);
    }

    public final VisionImageInput fromVisionImageBundle(Bundle bundle, boolean downSample) {
        p.i(bundle, "bundle");
        Bitmap bitmap = (Bitmap) bundle.getParcelable("bitmap");
        if (bitmap != null) {
            int iCalcSampleSize = downSample ? calcSampleSize(bitmap.getWidth(), bitmap.getHeight()) : 1;
            Bitmap bitmapCreateScaledBitmap = iCalcSampleSize > 1 ? Bitmap.createScaledBitmap(bitmap, C5685n.f(bitmap.getWidth() / iCalcSampleSize, 1), C5685n.f(bitmap.getHeight() / iCalcSampleSize, 1), true) : bitmap;
            p.f(bitmapCreateScaledBitmap);
            ImageContent imageContentFromBitmap$default = ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, bitmapCreateScaledBitmap, 0, 0, 0, Integer.MAX_VALUE, 14, null);
            if (bitmapCreateScaledBitmap != bitmap && !bitmapCreateScaledBitmap.isRecycled()) {
                bitmapCreateScaledBitmap.recycle();
            }
            return new VisionImageInput(imageContentFromBitmap$default, iCalcSampleSize);
        }
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) bundle.getParcelable("file_descriptor");
        if (parcelFileDescriptor != null) {
            return new VisionImageInput(new ImageContent(null, parcelFileDescriptor, 0L, 0, 0, 0, 0, null, null, 509, null), 1);
        }
        String string = bundle.getString("path");
        if (string == null || H.x0(string)) {
            throw new IllegalArgumentException("SingleImageBundle has no usable image data (bitmap/fd/path)");
        }
        return new VisionImageInput(new FileContent(string, "image/*", null, 4, null), 1);
    }

    public final Bitmap scaleDown(Bitmap src, int maxEdge) {
        p.i(src, "src");
        float f10 = maxEdge;
        float fMin = Math.min(f10 / src.getWidth(), Math.min(f10 / src.getHeight(), 1.0f));
        if (fMin >= 1.0f) {
            return src;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(src, (int) (src.getWidth() * fMin), (int) (src.getHeight() * fMin), true);
        p.h(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
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
            kotlin.jvm.internal.p.i(r6, r5)
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
            kotlin.jvm.internal.p.f(r0)
            java.nio.ByteBuffer r0 = r0.mapReadOnly()     // Catch: java.lang.Exception -> L58
            java.lang.String r3 = "mapReadOnly(...)"
            kotlin.jvm.internal.p.h(r0, r3)     // Catch: java.lang.Exception -> L58
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
            kotlin.jvm.internal.p.f(r0)
            android.graphics.Bitmap r0 = android.graphics.Bitmap.wrapHardwareBuffer(r0, r2)
            if (r0 == 0) goto L58
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = r0.copy(r2, r1)
            goto L59
        L58:
            r0 = r2
        L59:
            if (r0 == 0) goto L61
            java.lang.String r1 = "result_bitmap"
            r5.putParcelable(r1, r0)
        L61:
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
