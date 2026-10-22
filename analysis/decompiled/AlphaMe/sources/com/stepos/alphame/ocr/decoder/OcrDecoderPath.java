package com.stepos.alphame.ocr.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.BitmapUtils;
import com.stepos.alphame.utils.pool.PoolManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class OcrDecoderPath implements OcrDecoder {
    private static final String TAG = "OcrTrace";
    private final String filePath;

    public OcrDecoderPath(String str) {
        this.filePath = str;
    }

    private static String probeOpen(File file) throws IOException {
        String strProbeOpenError = probeOpenError(file);
        return strProbeOpenError != null ? strProbeOpenError : "open_ok_but_stat_failed";
    }

    private static String probeOpenError(File file) throws IOException {
        try {
            new FileInputStream(file).close();
            return null;
        } catch (Exception e4) {
            return e4.getClass().getSimpleName() + AwarenessDataItem.USERID_SPLITTER + e4.getMessage();
        }
    }

    @Override // com.stepos.alphame.ocr.decoder.OcrDecoder
    public Bitmap decode() throws IOException {
        String str;
        int iMax;
        String strPreflightError = preflightError();
        if (strPreflightError != null) {
            Log.w("OcrTrace", "decodePath failed ".concat(strPreflightError));
            return null;
        }
        File file = new File(this.filePath);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.filePath, options);
        int iMax2 = options.outWidth;
        if (iMax2 <= 0 || (iMax = options.outHeight) <= 0) {
            StringBuilder sb = new StringBuilder("decodePath bounds decode failed path=");
            sb.append(this.filePath);
            sb.append(" bounds=");
            sb.append(options.outWidth);
            sb.append("x");
            sb.append(options.outHeight);
            sb.append(" len=");
            sb.append(file.length());
            if (options.outWidth == 0) {
                str = " probe=" + probeOpen(file);
            } else {
                str = "";
            }
            sb.append(str);
            Log.w("OcrTrace", sb.toString());
            return null;
        }
        options.inSampleSize = 1;
        while (iMax2 * iMax > 9000000) {
            options.inSampleSize <<= 1;
            iMax2 = Math.max(1, iMax2 / 2);
            iMax = Math.max(1, iMax / 2);
        }
        options.inBitmap = PoolManager.acquireBitmap(iMax2, iMax, options.outConfig);
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.filePath, options);
        if (bitmapDecodeFile == null) {
            Log.w("OcrTrace", "decodePath decodeFile returned null path=" + this.filePath + " bounds=" + options.outWidth + "x" + options.outHeight);
            return null;
        }
        try {
            BitmapUtils.getOrientation(new ExifInterface(file));
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        Bitmap bitmap8888 = BitmapUtils.getBitmap8888(bitmapDecodeFile, 0);
        if (bitmap8888 == null) {
            Log.w("OcrTrace", "decodePath getBitmap8888 returned null path=" + this.filePath + " src=" + bitmapDecodeFile.getWidth() + "x" + bitmapDecodeFile.getHeight() + " cfg=" + bitmapDecodeFile.getConfig());
        }
        return bitmap8888;
    }

    @Override // com.stepos.alphame.ocr.decoder.OcrDecoder
    public String preflightError() throws IOException {
        if (TextUtils.isEmpty(this.filePath)) {
            return "empty_path";
        }
        File file = new File(this.filePath);
        if (file.exists() && file.length() != 0) {
            String strProbeOpenError = probeOpenError(file);
            if (strProbeOpenError == null) {
                return null;
            }
            return "unopenable path=" + this.filePath + " len=" + file.length() + " probe=" + strProbeOpenError;
        }
        return "unreadable path=" + this.filePath + " exists=" + file.exists() + " canRead=" + file.canRead() + " len=" + file.length() + " probe=" + probeOpen(file);
    }
}
