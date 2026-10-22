package com.stepos.alphame.ocr.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.stepos.alphame.utils.BitmapUtils;
import com.stepos.alphame.utils.pool.PoolManager;

/* loaded from: classes.dex */
public class OcrDecoderBytes implements OcrDecoder {
    private final byte[] bytes;

    public OcrDecoderBytes(byte[] bArr) {
        this.bytes = bArr;
    }

    @Override // com.stepos.alphame.ocr.decoder.OcrDecoder
    public Bitmap decode() {
        int iMax;
        byte[] bArr = this.bytes;
        if (bArr != null && bArr.length != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = true;
            byte[] bArr2 = this.bytes;
            BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
            int iMax2 = options.outWidth;
            if (iMax2 > 0 && (iMax = options.outHeight) > 0) {
                options.inSampleSize = 1;
                while (iMax2 * iMax > 9000000) {
                    options.inSampleSize <<= 1;
                    iMax2 = Math.max(1, iMax2 / 2);
                    iMax = Math.max(1, iMax / 2);
                }
                options.inBitmap = PoolManager.acquireBitmap(iMax2, iMax, Bitmap.Config.ARGB_8888);
                options.inJustDecodeBounds = false;
                byte[] bArr3 = this.bytes;
                return BitmapUtils.getBitmap8888(BitmapFactory.decodeByteArray(bArr3, 0, bArr3.length, options), 0);
            }
        }
        return null;
    }
}
