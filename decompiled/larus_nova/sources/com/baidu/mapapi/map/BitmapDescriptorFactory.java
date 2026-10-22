package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import java.io.FileInputStream;

/* JADX INFO: loaded from: classes39.dex */
public class BitmapDescriptorFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f30788a = null;

    static {
        f30788a = "BaiduMapSDK-BitmapDescriptorFactory";
    }

    public BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor fromAsset(String r100) {
        Context r101 = BMapManager.getContext();
        if (r101 != null) goto L12;
        return null;
    L12:
        Bitmap r102 = AssetsLoadUtil.loadAssetsFile(r100, r101);     // Catch: Exception -> L9
        BitmapDescriptor r103 = fromBitmap(r102);     // Catch: Exception -> L9
        if (r102 == null) goto L8;
        r102.recycle();     // Catch: Exception -> L9
    L8:
        return r103;
    L9:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static BitmapDescriptor fromAssetWithDpi(String r100) {
        Context r101 = BMapManager.getContext();
        if (r101 != null) goto L22;
        return null;
    L22:
        Bitmap r102 = AssetsLoadUtil.loadAssetsFile(r100, r101);     // Catch: Exception -> L19
        if (r102 != null) goto L8;
        return null;
    L8:
        int r103 = SysOSUtil.getDensityDpi();     // Catch: Exception -> L19
        if (r103 <= 480) goto L12;
        Matrix r104 = new Matrix();     // Catch: Exception -> L19
        r104.postScale(2.0f, 2.0f);     // Catch: Exception -> L19
        Bitmap r105 = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), r102.getHeight(), r104, true);     // Catch: Exception -> L19
        BitmapDescriptor r106 = fromBitmap(r105);     // Catch: Exception -> L19
    L15:
        r102.recycle();     // Catch: Exception -> L19
        if (r105 == null) goto L18;
        r105.recycle();     // Catch: Exception -> L19
    L18:
        return r106;
    L12:
        if (r103 <= 320) goto L14;
        Matrix r107 = new Matrix();     // Catch: Exception -> L19
        r107.postScale(1.5f, 1.5f);     // Catch: Exception -> L19
        r105 = Bitmap.createBitmap(r102, 0, 0, r102.getWidth(), r102.getHeight(), r107, true);     // Catch: Exception -> L19
        r106 = fromBitmap(r105);     // Catch: Exception -> L19
        goto L15
    L14:
        r106 = fromBitmap(r102);     // Catch: Exception -> L19
        r105 = null;
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static BitmapDescriptor fromBitmap(Bitmap r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isRecycled() == false) goto L7;
        return null;
    L7:
        return new BitmapDescriptor(r100);
    }

    public static BitmapDescriptor fromFile(String r100) {
        if (r100 != null) goto L5;
    L14:
        return null;
    L5:
        if (r100.equals("") == true) goto L14;
        Context r101 = BMapManager.getContext();
        if (r101 != null) goto L16;
        return null;
    L16:
        FileInputStream r102 = r101.openFileInput(r100);     // Catch: Throwable -> L15
        Bitmap r103 = BitmapFactory.decodeStream(r102);     // Catch: Throwable -> L15
        r102.close();     // Catch: Throwable -> L15
        if (r103 == null) goto L14;
        BitmapDescriptor r104 = fromBitmap(r103);     // Catch: Throwable -> L15
        r103.recycle();     // Catch: Throwable -> L15
        return r104;
    }

    public static BitmapDescriptor fromPath(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Bitmap r101 = BitmapFactory.decodeFile(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        BitmapDescriptor r102 = fromBitmap(r101);
        r101.recycle();
        return r102;
    }

    public static BitmapDescriptor fromResource(int r100) {
        Context r101 = BMapManager.getContext();
        if (r101 != null) goto L5;
        return null;
    L5:
        Bitmap r102 = BitmapFactory.decodeResource(r101.getResources(), r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        BitmapDescriptor r103 = fromBitmap(r102);
        r102.recycle();
        return r103;
    }

    public static BitmapDescriptor fromView(View r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));     // Catch: Exception -> L11
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());     // Catch: Exception -> L11
        r100.buildDrawingCache();     // Catch: Exception -> L11
        Bitmap r101 = r100.getDrawingCache();     // Catch: Exception -> L11
        BitmapDescriptor r102 = fromBitmap(r101);     // Catch: Exception -> L11
        if (r101 == null) goto L9;
        r101.recycle();     // Catch: Exception -> L11
    L9:
        r100.destroyDrawingCache();     // Catch: Exception -> L11
        return r102;
    L11:
        return null;
    }

    public static BitmapDescriptor fromFileWithDpi(String r100, int r101) {
        if (r100 != null) goto L5;
    L16:
        return null;
    L5:
        if (r100.equals("") == true) goto L16;
        Context r102 = BMapManager.getContext();
        if (r102 != null) goto L18;
        return null;
    L18:
        FileInputStream r103 = r102.openFileInput(r100);     // Catch: Throwable -> L17
        Bitmap r104 = BitmapFactory.decodeStream(r103);     // Catch: Throwable -> L17
        r103.close();     // Catch: Throwable -> L17
        if (r104 == null) goto L16;
        if (r101 > 0) goto L14;
        r101 = SysOSUtil.getDensityDpi();     // Catch: Throwable -> L17
    L14:
        r104.setDensity(r101);     // Catch: Throwable -> L17
        BitmapDescriptor r105 = fromBitmap(r104);     // Catch: Throwable -> L17
        r104.recycle();     // Catch: Throwable -> L17
        return r105;
    }

    public static BitmapDescriptor fromPathWithDpi(String r100, int r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Bitmap r102 = BitmapFactory.decodeFile(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r101 > 0) goto L10;
        r101 = SysOSUtil.getDensityDpi();
    L10:
        r102.setDensity(r101);
        BitmapDescriptor r103 = fromBitmap(r102);
        r102.recycle();
        return r103;
    }

    public static BitmapDescriptor fromResourceWithDpi(int r100, int r101) {
        Context r102 = BMapManager.getContext();
        if (r102 != null) goto L5;
        return null;
    L5:
        Bitmap r103 = BitmapFactory.decodeResource(r102.getResources(), r100);
        if (r103 != null) goto L8;
        return null;
    L8:
        if (r101 > 0) goto L10;
        r101 = SysOSUtil.getDensityDpi();
    L10:
        r103.setDensity(r101);
        BitmapDescriptor r104 = fromBitmap(r103);
        r103.recycle();
        return r104;
    }

    public static BitmapDescriptor fromViewWithDpi(View r100, int r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        r100.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        r100.layout(0, 0, r100.getMeasuredWidth(), r100.getMeasuredHeight());
        r100.buildDrawingCache();
        Bitmap r102 = r100.getDrawingCache();
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r101 > 0) goto L10;
        r101 = SysOSUtil.getDensityDpi();
    L10:
        r102.setDensity(r101);
        BitmapDescriptor r103 = fromBitmap(r102);
        r102.recycle();
        r100.destroyDrawingCache();
        return r103;
    }
}
