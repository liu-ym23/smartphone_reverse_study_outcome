package com.stepos.core.data;

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
import com.stepos.core.data.base.Content;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import l9.b;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u0000 82\u00020\u0001:\u00018Bi\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b.\u0010\u001bR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b/\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b0\u0010\u001bR\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b1\u0010\u001bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00105\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/stepos/core/data/ImageContent;", "Lcom/stepos/core/data/base/Content;", "Landroid/hardware/HardwareBuffer;", "hwBuffer", "Landroid/os/ParcelFileDescriptor;", "shmFd", "", "shmSize", "", "width", "height", "format", "rotation", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/os/SharedMemory;", "sharedMemory", "<init>", "(Landroid/hardware/HardwareBuffer;Landroid/os/ParcelFileDescriptor;JIIIILandroid/graphics/Bitmap;Landroid/os/SharedMemory;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "releaseSharedMemory", "()V", "", "toString", "()Ljava/lang/String;", "Landroid/hardware/HardwareBuffer;", "getHwBuffer", "()Landroid/hardware/HardwareBuffer;", "Landroid/os/ParcelFileDescriptor;", "getShmFd", "()Landroid/os/ParcelFileDescriptor;", "J", "getShmSize", "()J", "I", "getWidth", "getHeight", "getFormat", "getRotation", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "Landroid/os/SharedMemory;", "getSharedMemory", "()Landroid/os/SharedMemory;", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
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

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ImageContent> CREATOR = new Parcelable.Creator<ImageContent>() { // from class: com.stepos.core.data.ImageContent$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageContent createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            parcel.readInt();
            ContentParams contentParamsCreateFromParcel = parcel.readByte() == 1 ? ContentParams.CREATOR.createFromParcel(parcel) : null;
            ImageContent imageContent = new ImageContent(parcel);
            ((Content) imageContent).params = contentParamsCreateFromParcel;
            return imageContent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageContent[] newArray(int size) {
            return new ImageContent[size];
        }
    };

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J(\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J8\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0007J\"\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0007J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0007J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0#8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/stepos/core/data/ImageContent$Companion;", "", "<init>", "()V", "FORMAT_RGB", "", "FORMAT_RGBA", "FORMAT_NV21", "FORMAT_YUV_420_888", "FORMAT_BGR", "FORMAT_BGRA", "fromBitmapDirect", "Lcom/stepos/core/data/ImageContent;", "bitmap", "Landroid/graphics/Bitmap;", "fromBytes", "data", "", "width", "height", "format", "fromBitmap", "maxEdge", "fromUri", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "fromPath", "path", "", "readFieldsFromParcel", "parcel", "Landroid/os/Parcel;", "CREATOR", "Landroid/os/Parcelable$Creator;", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
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

        public final ImageContent fromBitmap(Bitmap bitmap, int width, int height, int format, int maxEdge) throws ErrnoException {
            Bitmap bitmap2 = bitmap;
            p.i(bitmap2, "bitmap");
            float f10 = maxEdge;
            float fMin = Math.min(f10 / bitmap2.getWidth(), Math.min(f10 / bitmap2.getHeight(), 1.0f));
            if (fMin < 1.0f) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, (int) (bitmap2.getWidth() * fMin), (int) (bitmap2.getHeight() * fMin), true);
            }
            p.f(bitmap2);
            Bitmap.Config config = bitmap2.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2 && (bitmap2 = bitmap2.copy(config2, false)) == null) {
                throw new IllegalStateException("Failed to convert bitmap to ARGB_8888");
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            SharedMemory sharedMemoryCreate = SharedMemory.create("img_shm", byteArray.length);
            p.h(sharedMemoryCreate, "create(...)");
            ByteBuffer byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
            p.h(byteBufferMapReadWrite, "mapReadWrite(...)");
            byteBufferMapReadWrite.put(byteArray);
            SharedMemory.unmap(byteBufferMapReadWrite);
            sharedMemoryCreate.setProtect(OsConstants.PROT_READ);
            return new ImageContent(null, null, byteArray.length, bitmap2.getWidth(), bitmap2.getHeight(), 2, 0, null, sharedMemoryCreate, 195, null);
        }

        public final ImageContent fromBitmapDirect(Bitmap bitmap) {
            p.i(bitmap, "bitmap");
            return new ImageContent(null, null, 0L, bitmap.getWidth(), bitmap.getHeight(), 0, 0, bitmap, null, 359, null);
        }

        public final ImageContent fromBytes(byte[] data, int width, int height, int format) {
            int i10;
            int i11;
            Bitmap bitmap;
            p.i(data, "data");
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (format == 1) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
                int i12 = width * height;
                int[] iArr = new int[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    int i14 = i13 * 3;
                    iArr[i13] = (data[i14 + 2] & 255) | ((data[i14] & 255) << 16) | (-16777216) | ((data[i14 + 1] & 255) << 8);
                }
                bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                i10 = width;
                i11 = height;
                bitmap = bitmapCreateBitmap;
            } else if (format != 2) {
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(data, 0, data.length);
                if (bitmapDecodeByteArray == null) {
                    throw new IllegalArgumentException("Cannot decode image bytes with format=" + format);
                }
                bitmap = bitmapDecodeByteArray;
                i10 = width;
                i11 = height;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width, height, config);
                int i15 = width * height;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    int i17 = i16 * 4;
                    iArr2[i16] = ((data[i17 + 3] & 255) << 24) | ((data[i17] & 255) << 16) | ((data[i17 + 1] & 255) << 8) | (data[i17 + 2] & 255);
                }
                i10 = width;
                i11 = height;
                bitmapCreateBitmap2.setPixels(iArr2, 0, i10, 0, 0, width, i11);
                bitmap = bitmapCreateBitmap2;
            }
            p.f(bitmap);
            return fromBitmap(bitmap, i10, i11, format, Integer.MAX_VALUE);
        }

        public final ImageContent fromPath(String path, int maxEdge) {
            p.i(path, "path");
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
            if (bitmapDecodeFile != null) {
                return fromBitmap$default(this, bitmapDecodeFile, 0, 0, 0, maxEdge, 14, null);
            }
            throw new IllegalArgumentException("Cannot decode image from path: " + path);
        }

        public final ImageContent fromUri(Context context, Uri uri, int maxEdge) throws IOException {
            p.i(context, "context");
            p.i(uri, "uri");
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                    b.a(inputStreamOpenInputStream, null);
                    if (bitmapDecodeStream != null) {
                        return fromBitmap$default(this, bitmapDecodeStream, 0, 0, 0, maxEdge, 14, null);
                    }
                } finally {
                }
            }
            throw new IllegalArgumentException("Cannot decode image from URI: " + uri);
        }

        public final ImageContent readFieldsFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new ImageContent(parcel);
        }

        private Companion() {
        }
    }

    public ImageContent() {
        this(null, null, 0L, 0, 0, 0, 0, null, null, 511, null);
    }

    public static final ImageContent fromBitmap(Bitmap bitmap, int i10, int i11, int i12, int i13) {
        return INSTANCE.fromBitmap(bitmap, i10, i11, i12, i13);
    }

    public static final ImageContent fromBitmapDirect(Bitmap bitmap) {
        return INSTANCE.fromBitmapDirect(bitmap);
    }

    public static final ImageContent fromBytes(byte[] bArr, int i10, int i11, int i12) {
        return INSTANCE.fromBytes(bArr, i10, i11, i12);
    }

    public static final ImageContent fromPath(String str, int i10) {
        return INSTANCE.fromPath(str, i10);
    }

    public static final ImageContent fromUri(Context context, Uri uri, int i10) {
        return INSTANCE.fromUri(context, uri, i10);
    }

    public static final ImageContent readFieldsFromParcel(Parcel parcel) {
        return INSTANCE.readFieldsFromParcel(parcel);
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
        return "ImageContent(width=" + this.width + ", height=" + this.height + ", format=" + this.format + ")";
    }

    public final boolean validate() {
        return !(this.hwBuffer == null && this.shmFd == null && this.sharedMemory == null) && this.width > 0 && this.height > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        super.writeToParcel(parcel, flags);
        parcel.writeTypedObject(this.hwBuffer, flags);
        parcel.writeTypedObject(this.shmFd, flags);
        parcel.writeLong(this.shmSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.format);
        parcel.writeInt(this.rotation);
        parcel.writeTypedObject(this.sharedMemory, flags);
    }

    public /* synthetic */ ImageContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j10, int i10, int i11, int i12, int i13, Bitmap bitmap, SharedMemory sharedMemory, int i14, i iVar) {
        this((i14 & 1) != 0 ? null : hardwareBuffer, (i14 & 2) != 0 ? null : parcelFileDescriptor, (i14 & 4) != 0 ? 0L : j10, (i14 & 8) != 0 ? 0 : i10, (i14 & 16) != 0 ? 0 : i11, (i14 & 32) != 0 ? 0 : i12, (i14 & 64) != 0 ? 0 : i13, (i14 & 128) != 0 ? null : bitmap, (i14 & 256) != 0 ? null : sharedMemory);
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
        p.i(parcel, "parcel");
    }
}
