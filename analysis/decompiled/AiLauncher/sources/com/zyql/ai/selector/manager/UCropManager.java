package com.zyql.ai.selector.manager;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.zyql.ai.crop.UCrop;
import com.zyql.ai.selector.R;
import com.zyql.ai.selector.config.PictureMimeType;
import com.zyql.ai.selector.config.PictureSelectionConfig;
import com.zyql.ai.selector.entity.LocalMedia;
import com.zyql.ai.selector.tools.DateUtils;
import com.zyql.ai.selector.tools.DoubleUtils;
import com.zyql.ai.selector.tools.PictureFileUtils;
import com.zyql.ai.selector.tools.SdkVersionUtils;
import com.zyql.ai.selector.tools.StringUtils;
import com.zyql.ai.selector.tools.ToastUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class UCropManager {
    /* JADX WARN: Removed duplicated region for block: B:14:0x001d A[PHI: r1 r3 r4 r5 r7
      0x001d: PHI (r1v20 int) = (r1v12 int), (r1v16 int), (r1v21 int) binds: [B:41:0x0061, B:26:0x0035, B:13:0x001b] A[DONT_GENERATE, DONT_INLINE]
      0x001d: PHI (r3v3 boolean) = (r3v0 boolean), (r3v1 boolean), (r3v4 boolean) binds: [B:41:0x0061, B:26:0x0035, B:13:0x001b] A[DONT_GENERATE, DONT_INLINE]
      0x001d: PHI (r4v5 int) = (r4v0 int), (r4v2 int), (r4v7 int) binds: [B:41:0x0061, B:26:0x0035, B:13:0x001b] A[DONT_GENERATE, DONT_INLINE]
      0x001d: PHI (r5v5 int) = (r5v0 int), (r5v2 int), (r5v7 int) binds: [B:41:0x0061, B:26:0x0035, B:13:0x001b] A[DONT_GENERATE, DONT_INLINE]
      0x001d: PHI (r7v14 int) = (r7v3 int), (r7v4 int), (r7v15 int) binds: [B:41:0x0061, B:26:0x0035, B:13:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.zyql.ai.crop.UCrop.Options basicOptions(android.content.Context r7) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zyql.ai.selector.manager.UCropManager.basicOptions(android.content.Context):com.zyql.ai.crop.UCrop$Options");
    }

    public static void ofCrop(Activity activity, String str, String str2) {
        String str3;
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            ToastUtils.s(activity.getApplicationContext(), activity.getString(R.string.picture_not_crop_data));
            return;
        }
        PictureSelectionConfig pictureSelectionConfig = PictureSelectionConfig.getInstance();
        boolean zIsHasHttp = PictureMimeType.isHasHttp(str);
        String strReplace = str2.replace("image/", ".");
        String diskCacheDir = PictureFileUtils.getDiskCacheDir(activity.getApplicationContext());
        if (TextUtils.isEmpty(pictureSelectionConfig.renameCropFileName)) {
            str3 = DateUtils.getCreateFileName("IMG_CROP_") + strReplace;
        } else {
            str3 = pictureSelectionConfig.renameCropFileName;
        }
        UCrop.of((zIsHasHttp || SdkVersionUtils.checkedAndroid_Q()) ? Uri.parse(str) : Uri.fromFile(new File(str)), Uri.fromFile(new File(diskCacheDir, str3))).withOptions(basicOptions(activity)).startAnimationActivity(activity, PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
    }

    public static void ofCrop(Activity activity, ArrayList<LocalMedia> arrayList) {
        Uri uriFromFile;
        String strRename;
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (arrayList != null && arrayList.size() != 0) {
            PictureSelectionConfig pictureSelectionConfig = PictureSelectionConfig.getInstance();
            UCrop.Options optionsBasicOptions = basicOptions(activity);
            optionsBasicOptions.setCutListData(arrayList);
            int size = arrayList.size();
            int i10 = 0;
            if (pictureSelectionConfig.chooseMode == PictureMimeType.ofAll() && pictureSelectionConfig.isWithVideoImage) {
                if (PictureMimeType.isHasVideo(size > 0 ? arrayList.get(0).getMimeType() : "")) {
                    int i11 = 0;
                    while (true) {
                        if (i11 < size) {
                            LocalMedia localMedia = arrayList.get(i11);
                            if (localMedia != null && PictureMimeType.isHasImage(localMedia.getMimeType())) {
                                i10 = i11;
                                break;
                            }
                            i11++;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (i10 < size) {
                LocalMedia localMedia2 = arrayList.get(i10);
                boolean zIsHasHttp = PictureMimeType.isHasHttp(localMedia2.getPath());
                if (TextUtils.isEmpty(localMedia2.getAndroidQToPath())) {
                    uriFromFile = (zIsHasHttp || SdkVersionUtils.checkedAndroid_Q()) ? Uri.parse(localMedia2.getPath()) : Uri.fromFile(new File(localMedia2.getPath()));
                } else {
                    uriFromFile = Uri.fromFile(new File(localMedia2.getAndroidQToPath()));
                }
                String strReplace = localMedia2.getMimeType().replace("image/", ".");
                String diskCacheDir = PictureFileUtils.getDiskCacheDir(activity);
                if (TextUtils.isEmpty(pictureSelectionConfig.renameCropFileName)) {
                    strRename = DateUtils.getCreateFileName("IMG_CROP_") + strReplace;
                } else {
                    strRename = (pictureSelectionConfig.camera || size == 1) ? pictureSelectionConfig.renameCropFileName : StringUtils.rename(pictureSelectionConfig.renameCropFileName);
                }
                UCrop.of(uriFromFile, Uri.fromFile(new File(diskCacheDir, strRename))).withOptions(optionsBasicOptions).startAnimationMultipleCropActivity(activity, PictureSelectionConfig.windowAnimationStyle.activityCropEnterAnimation);
                return;
            }
            return;
        }
        ToastUtils.s(activity.getApplicationContext(), activity.getString(R.string.picture_not_crop_data));
    }
}
