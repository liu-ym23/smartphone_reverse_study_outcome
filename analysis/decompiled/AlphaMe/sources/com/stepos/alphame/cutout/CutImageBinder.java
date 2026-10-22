package com.stepos.alphame.cutout;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Parcel;
import android.os.RemoteException;
import com.stepos.alphame.utils.AlphaMeLogger;

/* loaded from: classes.dex */
public class CutImageBinder extends Binder {
    public static final int CODE_GET = 250;
    public static final int CODE_RELEASE = 249;
    private static final String TAG = "ImageBinder";
    private Bitmap mBitmapGallery = null;
    private Bitmap mBitmapPicker = null;

    public boolean insert(Bitmap bitmap, String str) {
        if (CutImageHelper.PACKAGE_NAME_GALLERY.equals(str)) {
            this.mBitmapGallery = bitmap.asShared();
            return true;
        }
        if (!CutImageHelper.PACKAGE_NAME_PICKER.equals(str)) {
            return false;
        }
        this.mBitmapPicker = bitmap.asShared();
        return true;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        AlphaMeLogger.debugLog(TAG, "onTransact " + i4);
        if (parcel == null) {
            AlphaMeLogger.debugLog(TAG, "onTransact null");
            return true;
        }
        String string = parcel.readString();
        AlphaMeLogger.debugLog(TAG, "onTransact " + string);
        if (CutImageHelper.PACKAGE_NAME_GALLERY.equals(string)) {
            if (parcel2 != null && i4 == 250) {
                parcel2.writeParcelable(this.mBitmapGallery, 0);
                return true;
            }
            if (i4 == 249) {
                this.mBitmapGallery = null;
                return true;
            }
        } else if (CutImageHelper.PACKAGE_NAME_PICKER.equals(string)) {
            if (parcel2 != null && i4 == 250) {
                parcel2.writeParcelable(this.mBitmapPicker, 0);
                return true;
            }
            if (i4 == 249) {
                this.mBitmapPicker = null;
                return true;
            }
        }
        return super.onTransact(i4, parcel, parcel2, i5);
    }
}
