package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.AssetsLoadUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class BitmapDescriptorFactory {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6263a = "BaiduMapSDK-BitmapDescriptorFactory";

    public static BitmapDescriptor fromAsset(String str) {
        Context context = BMapManager.getContext();
        if (context == null) {
            return null;
        }
        try {
            Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(str, context);
            BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapLoadAssetsFile);
            if (bitmapLoadAssetsFile != null) {
                bitmapLoadAssetsFile.recycle();
            }
            return bitmapDescriptorFromBitmap;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static BitmapDescriptor fromAssetWithDpi(String str) {
        BitmapDescriptor bitmapDescriptorFromBitmap;
        Bitmap bitmapCreateBitmap;
        Context context = BMapManager.getContext();
        if (context == null) {
            return null;
        }
        try {
            Bitmap bitmapLoadAssetsFile = AssetsLoadUtil.loadAssetsFile(str, context);
            if (bitmapLoadAssetsFile == null) {
                return null;
            }
            int densityDpi = SysOSUtil.getDensityDpi();
            if (densityDpi > 480) {
                Matrix matrix = new Matrix();
                matrix.postScale(2.0f, 2.0f);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix, true);
                bitmapDescriptorFromBitmap = fromBitmap(bitmapCreateBitmap);
            } else if (densityDpi > 320) {
                Matrix matrix2 = new Matrix();
                matrix2.postScale(1.5f, 1.5f);
                bitmapCreateBitmap = Bitmap.createBitmap(bitmapLoadAssetsFile, 0, 0, bitmapLoadAssetsFile.getWidth(), bitmapLoadAssetsFile.getHeight(), matrix2, true);
                bitmapDescriptorFromBitmap = fromBitmap(bitmapCreateBitmap);
            } else {
                bitmapDescriptorFromBitmap = fromBitmap(bitmapLoadAssetsFile);
                bitmapCreateBitmap = null;
            }
            bitmapLoadAssetsFile.recycle();
            if (bitmapCreateBitmap != null) {
                bitmapCreateBitmap.recycle();
            }
            return bitmapDescriptorFromBitmap;
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDescriptor(bitmap);
    }

    public static BitmapDescriptor fromFile(String str) throws IOException {
        Context context;
        if (str == null || str.equals("") || (context = BMapManager.getContext()) == null) {
            return null;
        }
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
            fileInputStreamOpenFileInput.close();
            if (bitmapDecodeStream != null) {
                BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapDecodeStream);
                bitmapDecodeStream.recycle();
                return bitmapDescriptorFromBitmap;
            }
        } catch (FileNotFoundException e4) {
            Log.e(f6263a, "FileNotFoundException happened", e4);
        } catch (IOException e5) {
            Log.e(f6263a, "IOException happened", e5);
        }
        return null;
    }

    public static BitmapDescriptor fromFileWithDpi(String str, int i4) throws IOException {
        Context context;
        if (str == null || str.equals("") || (context = BMapManager.getContext()) == null) {
            return null;
        }
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStreamOpenFileInput);
            fileInputStreamOpenFileInput.close();
            if (bitmapDecodeStream != null) {
                if (i4 <= 0) {
                    i4 = SysOSUtil.getDensityDpi();
                }
                bitmapDecodeStream.setDensity(i4);
                BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapDecodeStream);
                bitmapDecodeStream.recycle();
                return bitmapDescriptorFromBitmap;
            }
        } catch (FileNotFoundException e4) {
            Log.e(f6263a, "FileNotFoundException happened", e4);
        } catch (IOException e5) {
            Log.e(f6263a, "IOException happened", e5);
        }
        return null;
    }

    public static BitmapDescriptor fromPath(String str) {
        Bitmap bitmapDecodeFile;
        if (TextUtils.isEmpty(str) || (bitmapDecodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapDecodeFile);
        bitmapDecodeFile.recycle();
        return bitmapDescriptorFromBitmap;
    }

    public static BitmapDescriptor fromPathWithDpi(String str, int i4) {
        Bitmap bitmapDecodeFile;
        if (TextUtils.isEmpty(str) || (bitmapDecodeFile = BitmapFactory.decodeFile(str)) == null) {
            return null;
        }
        if (i4 <= 0) {
            i4 = SysOSUtil.getDensityDpi();
        }
        bitmapDecodeFile.setDensity(i4);
        BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapDecodeFile);
        bitmapDecodeFile.recycle();
        return bitmapDescriptorFromBitmap;
    }

    public static BitmapDescriptor fromResource(int i4) {
        Bitmap bitmapDecodeResource;
        Context context = BMapManager.getContext();
        if (context == null || (bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i4)) == null) {
            return null;
        }
        BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapDecodeResource);
        bitmapDecodeResource.recycle();
        return bitmapDescriptorFromBitmap;
    }

    public static BitmapDescriptor fromResourceWithDpi(int i4, int i5) {
        Bitmap bitmapDecodeResource;
        Context context = BMapManager.getContext();
        if (context == null || (bitmapDecodeResource = BitmapFactory.decodeResource(context.getResources(), i4)) == null) {
            return null;
        }
        if (i5 <= 0) {
            i5 = SysOSUtil.getDensityDpi();
        }
        bitmapDecodeResource.setDensity(i5);
        BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(bitmapDecodeResource);
        bitmapDecodeResource.recycle();
        return bitmapDescriptorFromBitmap;
    }

    public static BitmapDescriptor fromView(View view) {
        if (view == null) {
            return null;
        }
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache = view.getDrawingCache();
            BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(drawingCache);
            if (drawingCache != null) {
                drawingCache.recycle();
            }
            view.destroyDrawingCache();
            return bitmapDescriptorFromBitmap;
        } catch (Exception unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromViewWithDpi(View view, int i4) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            Log.e(f6263a, "Get bitmap failed");
            return null;
        }
        if (i4 <= 0) {
            i4 = SysOSUtil.getDensityDpi();
        }
        drawingCache.setDensity(i4);
        BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(drawingCache);
        drawingCache.recycle();
        view.destroyDrawingCache();
        return bitmapDescriptorFromBitmap;
    }
}
