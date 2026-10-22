package com.stepos.alphame.ocr.decoder;

import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;

/* loaded from: classes.dex */
public class OcrDecoderBinder implements OcrDecoder {
    public static int CAMERA_CODE = 250;
    public static int CODE = 1;
    private static final String TAG = "OcrDecoderBinder";
    private Bitmap mBitmap;

    public OcrDecoderBinder(IBinder iBinder, int i4) {
        this.mBitmap = null;
        if (iBinder == null) {
            return;
        }
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            try {
            } catch (RemoteException e4) {
                Log.w(TAG, "exception", e4);
            }
            if (iBinder.transact(i4, parcelObtain, parcelObtain2, 0)) {
                Bitmap bitmap = (Bitmap) parcelObtain2.readParcelable(ApplicationImpl.getApplication().getClassLoader(), Bitmap.class);
                if (bitmap != null) {
                    this.mBitmap = bitmap;
                    return;
                }
                Log.w(TAG, "getBitmap failed");
            } else {
                Log.w(TAG, "transact failed");
            }
        } finally {
            parcelObtain.recycle();
            parcelObtain2.recycle();
        }
    }

    @Override // com.stepos.alphame.ocr.decoder.OcrDecoder
    public Bitmap decode() {
        return this.mBitmap;
    }

    @Override // com.stepos.alphame.ocr.decoder.OcrDecoder
    public void release(Bitmap bitmap) {
        if (this.mBitmap == bitmap) {
            this.mBitmap = null;
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }
}
