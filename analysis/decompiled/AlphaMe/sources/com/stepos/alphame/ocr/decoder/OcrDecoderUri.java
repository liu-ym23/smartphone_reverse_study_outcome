package com.stepos.alphame.ocr.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.utils.BitmapUtils;
import com.stepos.alphame.utils.pool.PoolManager;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class OcrDecoderUri implements OcrDecoder {
    private static final String TAG = "OcrTrace";
    private final Uri uri;

    public OcrDecoderUri(Uri uri) {
        this.uri = uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0066: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:25:0x0066 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    @Override // com.stepos.alphame.ocr.decoder.OcrDecoder
    public Bitmap decode() throws Throwable {
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        int iMax;
        BufferedInputStream bufferedInputStream3 = null;
        if (this.uri == null) {
            return null;
        }
        ?? contentResolver = ApplicationImpl.getApplication().getContentResolver();
        try {
            try {
                contentResolver = contentResolver.openInputStream(this.uri);
                if (contentResolver == 0) {
                    if (contentResolver != 0) {
                        try {
                            contentResolver.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(contentResolver);
                    try {
                        bufferedInputStream.mark(bufferedInputStream.available());
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        int iMax2 = options.outWidth;
                        if (iMax2 > 0 && (iMax = options.outHeight) > 0) {
                            options.inSampleSize = 1;
                            while (iMax2 * iMax > 9000000) {
                                options.inSampleSize <<= 1;
                                iMax2 = Math.max(1, iMax2 / 2);
                                iMax = Math.max(1, iMax / 2);
                            }
                            options.inBitmap = PoolManager.acquireBitmap(iMax2, iMax, options.outConfig);
                            int orientation = 0;
                            options.inJustDecodeBounds = false;
                            bufferedInputStream.reset();
                            bufferedInputStream.mark(bufferedInputStream.available());
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                            if (bitmapDecodeStream == null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                return null;
                            }
                            try {
                                orientation = BitmapUtils.getOrientation(new ExifInterface(bufferedInputStream));
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            Bitmap bitmap8888 = BitmapUtils.getBitmap8888(bitmapDecodeStream, orientation);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                            return bitmap8888;
                        }
                        Log.w("OcrTrace", "decodeUri bounds decode failed uri=" + this.uri + " bounds=" + options.outWidth + "x" + options.outHeight);
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        return null;
                    } catch (Exception e9) {
                        e = e9;
                        inputStream = contentResolver;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        } else if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                        return null;
                    }
                } catch (Exception e12) {
                    e = e12;
                    bufferedInputStream = null;
                    inputStream = contentResolver;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedInputStream3 != null) {
                        try {
                            bufferedInputStream3.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    } else if (contentResolver != 0) {
                        try {
                            contentResolver.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream3 = bufferedInputStream2;
            }
        } catch (Exception e15) {
            e = e15;
            inputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            contentResolver = 0;
        }
    }
}
