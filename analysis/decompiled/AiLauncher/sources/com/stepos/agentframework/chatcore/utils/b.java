package com.stepos.agentframework.chatcore.utils;

import Y8.t;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.m;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/b;", "", "<init>", "()V", "Lu4/m$e;", "message", "", "desPath", Const.INTENT_KEY_PKGNAME, "(Lu4/m$e;Ljava/lang/String;)Ljava/lang/String;", "Landroid/graphics/BitmapFactory$Options;", "options", "", "maxWidth", "maxHeight", Const.INTENT_KEY_APIKEY, "(Landroid/graphics/BitmapFactory$Options;II)I", "TAG", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    public static final b INSTANCE = new b();
    public static final String TAG = "CompressUtil";

    public final int a(BitmapFactory.Options options, int maxWidth, int maxHeight) {
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        int i12 = 1;
        if (i10 <= maxWidth && i11 <= maxHeight) {
            return 1;
        }
        int i13 = i10 / 2;
        int i14 = i11 / 2;
        while (i13 / i12 >= maxWidth && i14 / i12 >= maxHeight) {
            i12 *= 2;
        }
        return i12;
    }

    public final String b(m.ImageMessage message, String desPath) {
        File parentFile;
        p.i(message, "message");
        p.i(desPath, "desPath");
        C4148a.k(TAG, "imageCompress desPath: " + desPath, false, 4, null);
        String localPath = message.getLocalPath();
        if (localPath == null || localPath.length() == 0 || !new File(localPath).exists()) {
            return null;
        }
        CompressConfig compressConfig = message.getCompressConfig();
        p.f(compressConfig);
        int imageWidth = compressConfig.getImageWidth();
        CompressConfig compressConfig2 = message.getCompressConfig();
        p.f(compressConfig2);
        int imageHeight = compressConfig2.getImageHeight();
        CompressConfig compressConfig3 = message.getCompressConfig();
        p.f(compressConfig3);
        int imageQuality = compressConfig3.getImageQuality();
        if (imageWidth <= 0 || imageHeight <= 0) {
            throw new IllegalArgumentException("maxWidth and maxHeight must be greater than 0");
        }
        File file = new File(desPath);
        if (!file.exists() && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(localPath, options);
            int iA = a(options, imageWidth, imageHeight);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = iA;
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(localPath, options2);
            if (bitmapDecodeFile == null) {
                return null;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    if (!bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, imageQuality, fileOutputStream)) {
                        l9.b.a(fileOutputStream, null);
                    }
                    t tVar = t.f7040a;
                    l9.b.a(fileOutputStream, null);
                    String absolutePath = file.getAbsolutePath();
                    if (!bitmapDecodeFile.isRecycled()) {
                        bitmapDecodeFile.recycle();
                    }
                    return absolutePath;
                } finally {
                }
            } finally {
                if (!bitmapDecodeFile.isRecycled()) {
                    bitmapDecodeFile.recycle();
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
