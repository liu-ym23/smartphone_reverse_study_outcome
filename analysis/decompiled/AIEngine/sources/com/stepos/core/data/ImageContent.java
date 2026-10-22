package com.stepos.core.data;

import ai.onnxruntime.providers.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.HardwareBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.data.base.Content;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ImageContent extends Content {
    public static final int FORMAT_BGR = 5;
    public static final int FORMAT_BGRA = 6;
    public static final int FORMAT_NV21 = 3;
    public static final int FORMAT_RGB = 1;
    public static final int FORMAT_RGBA = 2;
    public static final int FORMAT_YUV_420_888 = 4;
    private final transient Bitmap bitmap;
    private final int format;
    private final int height;
    private final HardwareBuffer hwBuffer;
    private final int rotation;
    private final SharedMemory sharedMemory;
    private final ParcelFileDescriptor shmFd;
    private final long shmSize;
    private final int width;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ImageContent> CREATOR = new Parcelable.Creator<ImageContent>() { // from class: com.stepos.core.data.ImageContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageContent createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            ImageContent imageContent = new ImageContent(parcel);
            ((Content) imageContent).params = contentParamsCreateFromParcel;
            return imageContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageContent[] newArray(int i10) {
            return new ImageContent[i10];
        }
    };

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ ImageContent fromBitmap$default(Companion companion, Bitmap bitmap, int i10, int i11, int i12, int i13, int i14, Object obj) {
            if ((i14 & 2) != 0) {
                i10 = bitmap.getWidth();
            }
            int i15 = i10;
            if ((i14 & 4) != 0) {
                i11 = bitmap.getHeight();
            }
            int i16 = i11;
            if ((i14 & 8) != 0) {
                i12 = 2;
            }
            int i17 = i12;
            if ((i14 & 16) != 0) {
                i13 = 1280;
            }
            return companion.fromBitmap(bitmap, i15, i16, i17, i13);
        }

        public static /* synthetic */ ImageContent fromPath$default(Companion companion, String str, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 1280;
            }
            return companion.fromPath(str, i10);
        }

        public static /* synthetic */ ImageContent fromUri$default(Companion companion, Context context, Uri uri, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i10 = 1280;
            }
            return companion.fromUri(context, uri, i10);
        }

        public final ImageContent fromBitmap(Bitmap bitmap, int i10, int i11, int i12, int i13) throws ErrnoException {
            Bitmap bitmap2 = bitmap;
            g.f(bitmap2, "bitmap");
            float f8 = i13;
            float fMin = Math.min(f8 / bitmap2.getWidth(), Math.min(f8 / bitmap2.getHeight(), 1.0f));
            if (fMin < 1.0f) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, (int) (bitmap2.getWidth() * fMin), (int) (bitmap2.getHeight() * fMin), true);
            }
            g.c(bitmap2);
            Bitmap.Config config = bitmap2.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2 && (bitmap2 = bitmap2.copy(config2, false)) == null) {
                throw new IllegalStateException("Failed to convert bitmap to ARGB_8888");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            SharedMemory sharedMemoryCreate = SharedMemory.create("img_shm", byteArray.length);
            g.e(sharedMemoryCreate, "create(...)");
            ByteBuffer byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
            g.e(byteBufferMapReadWrite, "mapReadWrite(...)");
            byteBufferMapReadWrite.put(byteArray);
            SharedMemory.unmap(byteBufferMapReadWrite);
            sharedMemoryCreate.setProtect(OsConstants.PROT_READ);
            return new ImageContent(null, null, byteArray.length, bitmap2.getWidth(), bitmap2.getHeight(), 2, 0, null, sharedMemoryCreate, 195, null);
        }

        public final ImageContent fromBitmapDirect(Bitmap bitmap) {
            g.f(bitmap, "bitmap");
            return new ImageContent(null, null, 0L, bitmap.getWidth(), bitmap.getHeight(), 0, 0, bitmap, null, 359, null);
        }

        public final ImageContent fromBytes(byte[] data, int i10, int i11, int i12) {
            int i13;
            int i14;
            Bitmap bitmap;
            g.f(data, "data");
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (i12 == 1) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i10, i11, config);
                int i15 = i10 * i11;
                int[] iArr = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    int i17 = i16 * 3;
                    iArr[i16] = (data[i17 + 2] & 255) | ((data[i17] & 255) << 16) | (-16777216) | ((data[i17 + 1] & 255) << 8);
                }
                bitmapCreateBitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
                i13 = i10;
                i14 = i11;
                bitmap = bitmapCreateBitmap;
            } else if (i12 != 2) {
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(data, 0, data.length);
                if (bitmapDecodeByteArray == null) {
                    throw new IllegalArgumentException(a.a(i12, "Cannot decode image bytes with format="));
                }
                bitmap = bitmapDecodeByteArray;
                i13 = i10;
                i14 = i11;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i10, i11, config);
                int i18 = i10 * i11;
                int[] iArr2 = new int[i18];
                for (int i19 = 0; i19 < i18; i19++) {
                    int i20 = i19 * 4;
                    iArr2[i19] = ((data[i20 + 3] & 255) << 24) | ((data[i20] & 255) << 16) | ((data[i20 + 1] & 255) << 8) | (data[i20 + 2] & 255);
                }
                i13 = i10;
                i14 = i11;
                bitmapCreateBitmap2.setPixels(iArr2, 0, i13, 0, 0, i10, i14);
                bitmap = bitmapCreateBitmap2;
            }
            return fromBitmap(bitmap, i13, i14, i12, Integer.MAX_VALUE);
        }

        public final ImageContent fromPath(String path, int i10) {
            g.f(path, "path");
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
            if (bitmapDecodeFile != null) {
                return fromBitmap$default(this, bitmapDecodeFile, 0, 0, 0, i10, 14, null);
            }
            throw new IllegalArgumentException("Cannot decode image from path: ".concat(path));
        }

        public final ImageContent fromUri(Context context, Uri uri, int i10) throws IOException {
            g.f(context, "context");
            g.f(uri, "uri");
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                    inputStreamOpenInputStream.close();
                    if (bitmapDecodeStream != null) {
                        return fromBitmap$default(this, bitmapDecodeStream, 0, 0, 0, i10, 14, null);
                    }
                } finally {
                }
            }
            throw new IllegalArgumentException("Cannot decode image from URI: " + uri);
        }

        public final ImageContent readFieldsFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new ImageContent(parcel);
        }

        private Companion() {
        }
    }

    public ImageContent() {
        this(null, null, 0L, 0, 0, 0, 0, null, null, 511, null);
    }

    public static final ImageContent fromBitmap(Bitmap bitmap, int i10, int i11, int i12, int i13) {
        return Companion.fromBitmap(bitmap, i10, i11, i12, i13);
    }

    public static final ImageContent fromBitmapDirect(Bitmap bitmap) {
        return Companion.fromBitmapDirect(bitmap);
    }

    public static final ImageContent fromBytes(byte[] bArr, int i10, int i11, int i12) {
        return Companion.fromBytes(bArr, i10, i11, i12);
    }

    public static final ImageContent fromPath(String str, int i10) {
        return Companion.fromPath(str, i10);
    }

    public static final ImageContent fromUri(Context context, Uri uri, int i10) {
        return Companion.fromUri(context, uri, i10);
    }

    public static final ImageContent readFieldsFromParcel(Parcel parcel) {
        return Companion.readFieldsFromParcel(parcel);
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getFormat() {
        return this.format;
    }

    public final int getHeight() {
        return this.height;
    }

    public final HardwareBuffer getHwBuffer() {
        return this.hwBuffer;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final SharedMemory getSharedMemory() {
        return this.sharedMemory;
    }

    public final ParcelFileDescriptor getShmFd() {
        return this.shmFd;
    }

    public final long getShmSize() {
        return this.shmSize;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void releaseSharedMemory() {
        SharedMemory sharedMemory = this.sharedMemory;
        if (sharedMemory != null) {
            sharedMemory.close();
        }
    }

    public String toString() {
        return ai.onnxruntime.a.j(")", this.format, h0.e.d(this.width, "ImageContent(width=", this.height, ", height=", ", format="));
    }

    public final boolean validate() {
        return !(this.hwBuffer == null && this.shmFd == null && this.sharedMemory == null) && this.width > 0 && this.height > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        super.writeToParcel(parcel, i10);
        parcel.writeTypedObject(this.hwBuffer, i10);
        parcel.writeTypedObject(this.shmFd, i10);
        parcel.writeLong(this.shmSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.format);
        parcel.writeInt(this.rotation);
        parcel.writeTypedObject(this.sharedMemory, i10);
    }

    public /* synthetic */ ImageContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j10, int i10, int i11, int i12, int i13, Bitmap bitmap, SharedMemory sharedMemory, int i14, e eVar) {
        this((i14 & 1) != 0 ? null : hardwareBuffer, (i14 & 2) != 0 ? null : parcelFileDescriptor, (i14 & 4) != 0 ? 0L : j10, (i14 & 8) != 0 ? 0 : i10, (i14 & 16) != 0 ? 0 : i11, (i14 & 32) != 0 ? 0 : i12, (i14 & 64) != 0 ? 0 : i13, (i14 & TraceIdKeys.MAX_LENGTH) != 0 ? null : bitmap, (i14 & 256) != 0 ? null : sharedMemory);
    }

    public ImageContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j10, int i10, int i11, int i12, int i13, Bitmap bitmap, SharedMemory sharedMemory) {
        super(1);
        this.hwBuffer = hardwareBuffer;
        this.shmFd = parcelFileDescriptor;
        this.shmSize = j10;
        this.width = i10;
        this.height = i11;
        this.format = i12;
        this.rotation = i13;
        this.bitmap = bitmap;
        this.sharedMemory = sharedMemory;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageContent(Parcel parcel) {
        this((HardwareBuffer) parcel.readTypedObject(HardwareBuffer.CREATOR), (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), null, (SharedMemory) parcel.readTypedObject(SharedMemory.CREATOR));
        g.f(parcel, "parcel");
    }
}
