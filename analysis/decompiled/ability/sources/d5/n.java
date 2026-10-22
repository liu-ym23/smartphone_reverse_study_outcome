package d5;

import android.graphics.Bitmap;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.system.OsConstants;
import com.stepos.core.data.ImageContent;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class n {
    public static ImageContent a(Bitmap bitmap, int i) throws ErrnoException {
        Bitmap bitmap2 = bitmap;
        kotlin.jvm.internal.k.f(bitmap2, "bitmap");
        float f = i;
        float fMin = Math.min(f / bitmap2.getWidth(), Math.min(f / bitmap2.getHeight(), 1.0f));
        if (fMin < 1.0f) {
            bitmap2 = Bitmap.createScaledBitmap(bitmap2, (int) (bitmap2.getWidth() * fMin), (int) (bitmap2.getHeight() * fMin), true);
        }
        kotlin.jvm.internal.k.c(bitmap2);
        Bitmap.Config config = bitmap2.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        if (config != config2 && (bitmap2 = bitmap2.copy(config2, false)) == null) {
            throw new IllegalStateException("Failed to convert bitmap to ARGB_8888");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        SharedMemory sharedMemoryCreate = SharedMemory.create("img_shm", byteArray.length);
        kotlin.jvm.internal.k.e(sharedMemoryCreate, "create(...)");
        ByteBuffer byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
        kotlin.jvm.internal.k.e(byteBufferMapReadWrite, "mapReadWrite(...)");
        byteBufferMapReadWrite.put(byteArray);
        SharedMemory.unmap(byteBufferMapReadWrite);
        sharedMemoryCreate.setProtect(OsConstants.PROT_READ);
        return new ImageContent(null, null, byteArray.length, bitmap2.getWidth(), bitmap2.getHeight(), 2, 0, null, sharedMemoryCreate, 195, null);
    }

    public static /* synthetic */ ImageContent b(n nVar, Bitmap bitmap, int i, int i6, int i10, int i11, int i12) {
        if ((i12 & 2) != 0) {
            bitmap.getWidth();
        }
        if ((i12 & 4) != 0) {
            bitmap.getHeight();
        }
        if ((i12 & 16) != 0) {
            i11 = 1280;
        }
        nVar.getClass();
        return a(bitmap, i11);
    }
}
