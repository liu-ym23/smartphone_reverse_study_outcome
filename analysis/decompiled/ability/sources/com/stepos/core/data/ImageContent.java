package com.stepos.core.data;

import B7.a;
import L.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.HardwareBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SharedMemory;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.core.data.base.Content;
import d5.n;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u0000 82\u00020\u0001:\u00019Bi\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0011\b\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0011\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b.\u0010\u001bR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b/\u0010\u001bR\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u0010-\u001a\u0004\b0\u0010\u001bR\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010-\u001a\u0004\b1\u0010\u001bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u00102\u001a\u0004\b3\u00104R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u00105\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/stepos/core/data/ImageContent;", "Lcom/stepos/core/data/base/Content;", "Landroid/hardware/HardwareBuffer;", "hwBuffer", "Landroid/os/ParcelFileDescriptor;", "shmFd", "", "shmSize", "", "width", "height", "format", Key.ROTATION, "Landroid/graphics/Bitmap;", "bitmap", "Landroid/os/SharedMemory;", "sharedMemory", AppAgent.CONSTRUCT, "(Landroid/hardware/HardwareBuffer;Landroid/os/ParcelFileDescriptor;JIIIILandroid/graphics/Bitmap;Landroid/os/SharedMemory;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "validate", "()Z", "releaseSharedMemory", "()V", "", "toString", "()Ljava/lang/String;", "Landroid/hardware/HardwareBuffer;", "getHwBuffer", "()Landroid/hardware/HardwareBuffer;", "Landroid/os/ParcelFileDescriptor;", "getShmFd", "()Landroid/os/ParcelFileDescriptor;", "J", "getShmSize", "()J", "I", "getWidth", "getHeight", "getFormat", "getRotation", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "Landroid/os/SharedMemory;", "getSharedMemory", "()Landroid/os/SharedMemory;", "Companion", "d5/n", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
    public static final n Companion = new n();
    public static final Parcelable.Creator<ImageContent> CREATOR = new g(14);

    public ImageContent() {
        this(null, null, 0L, 0, 0, 0, 0, null, null, 511, null);
    }

    @RequiresApi(26)
    public static final ImageContent fromBitmap(Bitmap bitmap, int i, int i6, int i10, int i11) {
        Companion.getClass();
        return n.a(bitmap, i11);
    }

    public static final ImageContent fromBitmapDirect(Bitmap bitmap) {
        Companion.getClass();
        k.f(bitmap, "bitmap");
        return new ImageContent(null, null, 0L, bitmap.getWidth(), bitmap.getHeight(), 0, 0, bitmap, null, 359, null);
    }

    @RequiresApi(26)
    public static final ImageContent fromBytes(byte[] data, int i, int i6, int i10) {
        int i11;
        int i12;
        Bitmap bitmapCreateBitmap;
        n nVar = Companion;
        nVar.getClass();
        k.f(data, "data");
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        if (i10 == 1) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(i, i6, config);
            int i13 = i * i6;
            int[] iArr = new int[i13];
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = i14 * 3;
                iArr[i14] = (data[i15 + 2] & 255) | ((data[i15] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((data[i15 + 1] & 255) << 8);
            }
            bitmapCreateBitmap2.setPixels(iArr, 0, i, 0, 0, i, i6);
            i11 = i;
            i12 = i6;
            bitmapCreateBitmap = bitmapCreateBitmap2;
        } else if (i10 != 2) {
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(data, 0, data.length);
            if (bitmapDecodeByteArray == null) {
                throw new IllegalArgumentException(a.h(i10, "Cannot decode image bytes with format="));
            }
            bitmapCreateBitmap = bitmapDecodeByteArray;
            i11 = i;
            i12 = i6;
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(i, i6, config);
            int i16 = i * i6;
            int[] iArr2 = new int[i16];
            for (int i17 = 0; i17 < i16; i17++) {
                int i18 = i17 * 4;
                iArr2[i17] = ((data[i18 + 3] & 255) << 24) | ((data[i18] & 255) << 16) | ((data[i18 + 1] & 255) << 8) | (data[i18 + 2] & 255);
            }
            i11 = i;
            i12 = i6;
            bitmapCreateBitmap.setPixels(iArr2, 0, i11, 0, 0, i, i12);
        }
        return n.b(nVar, bitmapCreateBitmap, i11, i12, i10, 0, 16);
    }

    @RequiresApi(26)
    public static final ImageContent fromPath(String path, int i) {
        n nVar = Companion;
        nVar.getClass();
        k.f(path, "path");
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
        if (bitmapDecodeFile != null) {
            return n.b(nVar, bitmapDecodeFile, 0, 0, 0, i, 14);
        }
        throw new IllegalArgumentException("Cannot decode image from path: ".concat(path));
    }

    @RequiresApi(26)
    public static final ImageContent fromUri(Context context, Uri uri, int i) throws IOException {
        n nVar = Companion;
        nVar.getClass();
        k.f(context, "context");
        k.f(uri, "uri");
        InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream != null) {
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                inputStreamOpenInputStream.close();
                if (bitmapDecodeStream != null) {
                    return n.b(nVar, bitmapDecodeStream, 0, 0, 0, i, 14);
                }
            } finally {
            }
        }
        throw new IllegalArgumentException(a.j("Cannot decode image from URI: ", uri));
    }

    @RequiresApi(26)
    public static final ImageContent readFieldsFromParcel(Parcel parcel) {
        Companion.getClass();
        k.f(parcel, "parcel");
        return new ImageContent(parcel);
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

    @RequiresApi(27)
    public final void releaseSharedMemory() {
        SharedMemory sharedMemory = this.sharedMemory;
        if (sharedMemory != null) {
            sharedMemory.close();
        }
    }

    public String toString() {
        int i = this.width;
        int i6 = this.height;
        return androidx.appfunctions.metadata.a.o(androidx.appfunctions.metadata.a.s(i, "ImageContent(width=", i6, ", height=", ", format="), ")", this.format);
    }

    public final boolean validate() {
        return !(this.hwBuffer == null && this.shmFd == null && this.sharedMemory == null) && this.width > 0 && this.height > 0;
    }

    @Override // com.stepos.core.data.base.Content, android.os.Parcelable
    @RequiresApi(26)
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
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

    public /* synthetic */ ImageContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j5, int i, int i6, int i10, int i11, Bitmap bitmap, SharedMemory sharedMemory, int i12, e eVar) {
        this((i12 & 1) != 0 ? null : hardwareBuffer, (i12 & 2) != 0 ? null : parcelFileDescriptor, (i12 & 4) != 0 ? 0L : j5, (i12 & 8) != 0 ? 0 : i, (i12 & 16) != 0 ? 0 : i6, (i12 & 32) != 0 ? 0 : i10, (i12 & 64) != 0 ? 0 : i11, (i12 & 128) != 0 ? null : bitmap, (i12 & 256) != 0 ? null : sharedMemory);
    }

    public ImageContent(HardwareBuffer hardwareBuffer, ParcelFileDescriptor parcelFileDescriptor, long j5, int i, int i6, int i10, int i11, Bitmap bitmap, SharedMemory sharedMemory) {
        super(1);
        this.hwBuffer = hardwareBuffer;
        this.shmFd = parcelFileDescriptor;
        this.shmSize = j5;
        this.width = i;
        this.height = i6;
        this.format = i10;
        this.rotation = i11;
        this.bitmap = bitmap;
        this.sharedMemory = sharedMemory;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(26)
    public ImageContent(Parcel parcel) {
        this((HardwareBuffer) parcel.readTypedObject(HardwareBuffer.CREATOR), (ParcelFileDescriptor) parcel.readTypedObject(ParcelFileDescriptor.CREATOR), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), null, (SharedMemory) parcel.readTypedObject(SharedMemory.CREATOR));
        k.f(parcel, "parcel");
    }
}
