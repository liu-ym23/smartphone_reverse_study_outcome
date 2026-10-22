package com.stepos.alphame.ocr.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.stepos.alphame.utils.BitmapUtils;
import com.stepos.alphame.utils.pool.PoolManager;
import java.io.File;

/* loaded from: classes.dex */
public class OcrDecoderBounds implements OcrDecoder {
    private final String filePath;

    public OcrDecoderBounds(String str) {
        this.filePath = str;
    }

    @Override // com.stepos.alphame.ocr.decoder.OcrDecoder
    public Bitmap decode() {
        int i4;
        int i5;
        if (TextUtils.isEmpty(this.filePath)) {
            return null;
        }
        File file = new File(this.filePath);
        if (file.exists() && file.length() != 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.filePath, options);
            if (options.outWidth >= 0 && options.outHeight >= 0) {
                options.inSampleSize = 1;
                while (true) {
                    i4 = options.outWidth;
                    i5 = options.outHeight;
                    if (i4 * i5 <= 9000000) {
                        break;
                    }
                    options.inSampleSize <<= 1;
                    options.outWidth = i4 >> 1;
                    options.outHeight = i5 >> 1;
                }
                if (i4 > 0 && i5 > 0) {
                    options.inBitmap = PoolManager.acquireBitmap(i4, i5, options.outConfig);
                    options.inJustDecodeBounds = false;
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.filePath, options);
                    if (bitmapDecodeFile == null) {
                        return null;
                    }
                    return BitmapUtils.getBitmap8888(bitmapDecodeFile, 0);
                }
            }
        }
        return null;
    }
}
